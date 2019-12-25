package com.baidu.live.im.view;

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
import com.baidu.live.data.av;
import com.baidu.live.im.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.Map;
/* loaded from: classes2.dex */
public class ImBarrageOptionListView extends HListView {
    private b aqu;
    boolean aqv;
    private a aqw;
    private int mDividerWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bI(int i);

        boolean vG();
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqv = true;
        init();
    }

    public void setCallback(a aVar) {
        this.aqw = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aqv = z;
    }

    public void setData(av[] avVarArr, Map<String, Integer> map, int i) {
        if (this.aqu == null) {
            this.aqu = new b();
            this.aqu.a(avVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aqu);
            return;
        }
        this.aqu.a(avVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aqu.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aqu != null) {
            this.aqu.bN(UtilHelper.getRealScreenOrientation(getContext()));
            this.aqu.notifyDataSetChanged();
        }
    }

    public void i(Map<String, Integer> map) {
        if (this.aqu != null) {
            this.aqu.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aqu.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (k.uF().uH() != z) {
            k.uF().setSwitchStatus(z);
            if (!z) {
                k.uF().setSelectId(null);
                if (this.aqu != null && this.aqu.getCount() > 0) {
                    this.aqu.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.aqu != null && this.aqu.getItem(i) != null) {
            String str = this.aqu.getItem(i).id;
            String uI = k.uF().uI();
            if (TextUtils.isEmpty(uI) || !uI.equals(str)) {
                l(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int dE;
        if (!TextUtils.isEmpty(str) && this.aqu != null && (dE = dE(str)) >= 0) {
            l(dE, str);
        }
    }

    public av getSelectInfo() {
        if (this.aqu != null) {
            return this.aqu.getItem(dE(k.uF().uI()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aqv = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.bM(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i) {
        av item;
        if (this.aqv && this.aqu != null && this.aqw != null && dE(k.uF().uI()) != i && (item = this.aqu.getItem(i)) != null) {
            if (item.type == 16 && !this.aqw.vG()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            setSelectPos(i);
            this.aqw.bI(i);
        }
    }

    private int dE(String str) {
        if (TextUtils.isEmpty(str) || this.aqu == null) {
            return -1;
        }
        for (int i = 0; i <= this.aqu.getCount(); i++) {
            if (this.aqu.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void l(int i, String str) {
        k.uF().setSwitchStatus(true);
        k.uF().setSelectId(str);
        if (this.aqu != null && this.aqu.getCount() > 0) {
            this.aqu.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BaseAdapter {
        private av[] aqy;
        private Map<String, Integer> aqz;
        private int from;
        private int itemWidth;

        private b() {
        }

        public void a(av[] avVarArr, Map<String, Integer> map, int i, int i2) {
            this.aqy = avVarArr;
            this.aqz = map;
            this.from = i2;
            this.itemWidth = bP(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aqz = map;
            this.itemWidth = bP(i);
        }

        public void bN(int i) {
            this.itemWidth = bP(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aqy != null) {
                return this.aqy.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bO */
        public av getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aqy[i];
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
                cVar.aqA = view.findViewById(a.g.layout_container);
                cVar.aqB = view.findViewById(a.g.layout_content);
                cVar.aqC = (TextView) view.findViewById(a.g.tv_name);
                cVar.aqD = view.findViewById(a.g.mask);
                cVar.aqE = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.aqF = view.findViewById(a.g.layout_gift_count);
                cVar.aqG = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            av item = getItem(i);
            Drawable background = cVar.aqB.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                ((GradientDrawable) background).setColors(item.pV());
            } else {
                ((GradientDrawable) background).setColor(item.pV()[0]);
            }
            cVar.aqB.setBackgroundDrawable(background);
            boolean equals = item.id.equals(k.uF().uI());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aqz, this.from, equals)) {
                cVar.aqC.setVisibility(0);
                if (item.type == 1) {
                    cVar.aqC.setText(item.price + "T豆/条");
                } else {
                    cVar.aqC.setText(item.name);
                }
                cVar.aqF.setVisibility(8);
                cVar.aqE.setVisibility(8);
            }
            cVar.aqD.setVisibility(equals ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.aqA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.itemWidth, -1);
            }
            layoutParams.width = this.itemWidth;
            ViewGroup.LayoutParams layoutParams2 = cVar.aqF.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.aqB.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.aqB.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int bP(int i) {
            int count;
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, av avVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(avVar.id) && (intValue = map.get(avVar.id).intValue()) != 0 && avVar.price == 100) {
            cVar.aqC.setVisibility(8);
            cVar.aqE.setImageResource(z ? a.f.sdk_icon_barrage_gift_price_100_selected : a.f.sdk_icon_barrage_gift_price_100_unselected);
            cVar.aqE.setVisibility(0);
            cVar.aqF.setVisibility(0);
            cVar.aqG.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aqG.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.aqE.getLayoutParams();
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
            cVar.aqE.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        View aqA;
        View aqB;
        TextView aqC;
        View aqD;
        ImageView aqE;
        View aqF;
        ImBarrageItemGiftCountView aqG;

        private c() {
        }
    }
}
