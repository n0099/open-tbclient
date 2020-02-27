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
    private b avh;
    boolean avi;
    private a avj;
    private int mDividerWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void bP(int i);

        boolean xn();
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avi = true;
        init();
    }

    public void setCallback(a aVar) {
        this.avj = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.avi = z;
    }

    public void setData(bb[] bbVarArr, Map<String, Integer> map, int i) {
        if (this.avh == null) {
            this.avh = new b();
            this.avh.a(bbVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.avh);
            return;
        }
        this.avh.a(bbVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.avh.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.avh != null) {
            this.avh.bW(UtilHelper.getRealScreenOrientation(getContext()));
            this.avh.notifyDataSetChanged();
        }
    }

    public void i(Map<String, Integer> map) {
        if (this.avh != null) {
            this.avh.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.avh.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (k.wA().wC() != z) {
            k.wA().setSwitchStatus(z);
            if (!z) {
                k.wA().setSelectId(null);
                if (this.avh != null && this.avh.getCount() > 0) {
                    this.avh.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.avh != null && this.avh.getItem(i) != null) {
            String str = this.avh.getItem(i).id;
            String wD = k.wA().wD();
            if (TextUtils.isEmpty(wD) || !wD.equals(str)) {
                o(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int dR;
        if (!TextUtils.isEmpty(str) && this.avh != null && (dR = dR(str)) >= 0) {
            o(dR, str);
        }
    }

    public bb getSelectInfo() {
        if (this.avh != null) {
            return this.avh.getItem(dR(k.wA().wD()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.avi = true;
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
        if (this.avi && this.avh != null && this.avj != null && dR(k.wA().wD()) != i && (item = this.avh.getItem(i)) != null) {
            if (item.type == 16 && !this.avj.xn()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            setSelectPos(i);
            this.avj.bP(i);
        }
    }

    private int dR(String str) {
        if (TextUtils.isEmpty(str) || this.avh == null) {
            return -1;
        }
        for (int i = 0; i <= this.avh.getCount(); i++) {
            if (this.avh.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void o(int i, String str) {
        k.wA().setSwitchStatus(true);
        k.wA().setSelectId(str);
        if (this.avh != null && this.avh.getCount() > 0) {
            this.avh.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private bb[] avl;
        private Map<String, Integer> avm;
        private int from;
        private int itemWidth;

        private b() {
        }

        public void a(bb[] bbVarArr, Map<String, Integer> map, int i, int i2) {
            this.avl = bbVarArr;
            this.avm = map;
            this.from = i2;
            this.itemWidth = cb(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.avm = map;
            this.itemWidth = cb(i);
        }

        public void bW(int i) {
            this.itemWidth = cb(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avl != null) {
                return this.avl.length;
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
            return this.avl[i];
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
                cVar.avn = view.findViewById(a.g.layout_container);
                cVar.avo = view.findViewById(a.g.layout_content);
                cVar.avp = (TextView) view.findViewById(a.g.tv_name);
                cVar.avq = view.findViewById(a.g.mask);
                cVar.avr = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.avs = view.findViewById(a.g.layout_gift_count);
                cVar.avt = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            bb item = getItem(i);
            Drawable background = cVar.avo.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                ((GradientDrawable) background).setColors(item.qM());
            } else {
                ((GradientDrawable) background).setColor(item.qM()[0]);
            }
            cVar.avo.setBackgroundDrawable(background);
            boolean equals = item.id.equals(k.wA().wD());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.avm, this.from, equals)) {
                cVar.avp.setVisibility(0);
                if (item.type == 1) {
                    cVar.avp.setText(item.price + "T豆/条");
                } else {
                    cVar.avp.setText(item.name);
                }
                cVar.avs.setVisibility(8);
                cVar.avr.setVisibility(8);
            }
            cVar.avq.setVisibility(equals ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.avn.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.itemWidth, -1);
            }
            layoutParams.width = this.itemWidth;
            ViewGroup.LayoutParams layoutParams2 = cVar.avs.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.avo.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.avo.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
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
            cVar.avp.setVisibility(8);
            cVar.avr.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            cVar.avr.setVisibility(0);
            cVar.avs.setVisibility(0);
            cVar.avt.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.avt.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.avr.getLayoutParams();
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
            cVar.avr.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        View avn;
        View avo;
        TextView avp;
        View avq;
        ImageView avr;
        View avs;
        ImBarrageItemGiftCountView avt;

        private c() {
        }
    }
}
