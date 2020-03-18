package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bb;
import com.baidu.live.im.k;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImBarrageOptionListView extends HListView {
    private b avs;
    boolean avt;
    private a avu;
    private int mDividerWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(int i);

        boolean xs();
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avt = true;
        init();
    }

    public void setCallback(a aVar) {
        this.avu = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.avt = z;
    }

    public void setData(bb[] bbVarArr, Map<String, Integer> map, int i) {
        if (this.avs == null) {
            this.avs = new b();
            this.avs.a(bbVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.avs);
            return;
        }
        this.avs.a(bbVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.avs.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.avs != null) {
            this.avs.bW(UtilHelper.getRealScreenOrientation(getContext()));
            this.avs.notifyDataSetChanged();
        }
    }

    public void i(Map<String, Integer> map) {
        if (this.avs != null) {
            this.avs.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.avs.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (k.wF().wH() != z) {
            k.wF().setSwitchStatus(z);
            if (!z) {
                k.wF().setSelectId(null);
                if (this.avs != null && this.avs.getCount() > 0) {
                    this.avs.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.avs != null && this.avs.getItem(i) != null) {
            String str = this.avs.getItem(i).id;
            String wI = k.wF().wI();
            if (TextUtils.isEmpty(wI) || !wI.equals(str)) {
                o(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int dQ;
        if (!TextUtils.isEmpty(str) && this.avs != null && (dQ = dQ(str)) >= 0) {
            o(dQ, str);
        }
    }

    public bb getSelectInfo() {
        if (this.avs != null) {
            return this.avs.getItem(dQ(k.wF().wI()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.avt = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.barrage.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.bZ(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i) {
        bb item;
        if (this.avt && this.avs != null && this.avu != null && dQ(k.wF().wI()) != i && (item = this.avs.getItem(i)) != null) {
            if (item.type == 16 && !this.avu.xs()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            setSelectPos(i);
            this.avu.bP(i);
        }
    }

    private int dQ(String str) {
        if (TextUtils.isEmpty(str) || this.avs == null) {
            return -1;
        }
        for (int i = 0; i <= this.avs.getCount(); i++) {
            if (this.avs.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void o(int i, String str) {
        k.wF().setSwitchStatus(true);
        k.wF().setSelectId(str);
        if (this.avs != null && this.avs.getCount() > 0) {
            this.avs.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private bb[] avw;
        private Map<String, Integer> avx;
        private int from;
        private int itemWidth;

        private b() {
        }

        public void a(bb[] bbVarArr, Map<String, Integer> map, int i, int i2) {
            this.avw = bbVarArr;
            this.avx = map;
            this.from = i2;
            this.itemWidth = cb(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.avx = map;
            this.itemWidth = cb(i);
        }

        public void bW(int i) {
            this.itemWidth = cb(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avw != null) {
                return this.avw.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: ca */
        public bb getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.avw[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_im_barrage_option_item, (ViewGroup) null);
                cVar = new c();
                cVar.avy = view.findViewById(a.g.layout_container);
                cVar.avz = view.findViewById(a.g.layout_content);
                cVar.avA = (TextView) view.findViewById(a.g.tv_name);
                cVar.avB = view.findViewById(a.g.mask);
                cVar.avC = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.avD = view.findViewById(a.g.layout_gift_count);
                cVar.avE = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            bb item = getItem(i);
            Drawable background = cVar.avz.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                ((GradientDrawable) background).setColors(item.qR());
            } else {
                ((GradientDrawable) background).setColor(item.qR()[0]);
            }
            cVar.avz.setBackgroundDrawable(background);
            boolean equals = item.id.equals(k.wF().wI());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.avx, this.from, equals)) {
                cVar.avA.setVisibility(0);
                if (item.type == 1) {
                    cVar.avA.setText(item.price + "T豆/条");
                } else {
                    cVar.avA.setText(item.name);
                }
                cVar.avD.setVisibility(8);
                cVar.avC.setVisibility(8);
            }
            cVar.avB.setVisibility(equals ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.avy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.itemWidth, -1);
            }
            layoutParams.width = this.itemWidth;
            ViewGroup.LayoutParams layoutParams2 = cVar.avD.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.avz.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.avz.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int cb(int i) {
            int count;
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, bb bbVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(bbVar.id) && (intValue = map.get(bbVar.id).intValue()) != 0 && bbVar.price == 100) {
            cVar.avA.setVisibility(8);
            cVar.avC.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            cVar.avC.setVisibility(0);
            cVar.avD.setVisibility(0);
            cVar.avE.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.avE.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.avC.getLayoutParams();
            if (i == 0) {
                layoutParams.width = -2;
                layoutParams.height = -1;
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds18);
            } else {
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds116);
                layoutParams.height = getResources().getDimensionPixelOffset(a.e.sdk_ds72);
                layoutParams.addRule(12);
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds12);
            }
            cVar.avC.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        TextView avA;
        View avB;
        ImageView avC;
        View avD;
        ImBarrageItemGiftCountView avE;
        View avy;
        View avz;

        private c() {
        }
    }
}
