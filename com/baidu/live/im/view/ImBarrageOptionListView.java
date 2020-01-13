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
import com.baidu.live.data.az;
import com.baidu.live.im.k;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.Map;
/* loaded from: classes2.dex */
public class ImBarrageOptionListView extends HListView {
    private b arg;
    boolean arh;
    private a ari;
    private int mDividerWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void bI(int i);

        boolean vX();
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arh = true;
        init();
    }

    public void setCallback(a aVar) {
        this.ari = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.arh = z;
    }

    public void setData(az[] azVarArr, Map<String, Integer> map, int i) {
        if (this.arg == null) {
            this.arg = new b();
            this.arg.a(azVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.arg);
            return;
        }
        this.arg.a(azVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.arg.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.arg != null) {
            this.arg.bN(UtilHelper.getRealScreenOrientation(getContext()));
            this.arg.notifyDataSetChanged();
        }
    }

    public void i(Map<String, Integer> map) {
        if (this.arg != null) {
            this.arg.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.arg.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (k.uW().uY() != z) {
            k.uW().setSwitchStatus(z);
            if (!z) {
                k.uW().setSelectId(null);
                if (this.arg != null && this.arg.getCount() > 0) {
                    this.arg.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.arg != null && this.arg.getItem(i) != null) {
            String str = this.arg.getItem(i).id;
            String uZ = k.uW().uZ();
            if (TextUtils.isEmpty(uZ) || !uZ.equals(str)) {
                o(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int dG;
        if (!TextUtils.isEmpty(str) && this.arg != null && (dG = dG(str)) >= 0) {
            o(dG, str);
        }
    }

    public az getSelectInfo() {
        if (this.arg != null) {
            return this.arg.getItem(dG(k.uW().uZ()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.arh = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.bM(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i) {
        az item;
        if (this.arh && this.arg != null && this.ari != null && dG(k.uW().uZ()) != i && (item = this.arg.getItem(i)) != null) {
            if (item.type == 16 && !this.ari.vX()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            setSelectPos(i);
            this.ari.bI(i);
        }
    }

    private int dG(String str) {
        if (TextUtils.isEmpty(str) || this.arg == null) {
            return -1;
        }
        for (int i = 0; i <= this.arg.getCount(); i++) {
            if (this.arg.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void o(int i, String str) {
        k.uW().setSwitchStatus(true);
        k.uW().setSelectId(str);
        if (this.arg != null && this.arg.getCount() > 0) {
            this.arg.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BaseAdapter {
        private az[] ark;
        private Map<String, Integer> arl;
        private int from;
        private int itemWidth;

        private b() {
        }

        public void a(az[] azVarArr, Map<String, Integer> map, int i, int i2) {
            this.ark = azVarArr;
            this.arl = map;
            this.from = i2;
            this.itemWidth = bP(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.arl = map;
            this.itemWidth = bP(i);
        }

        public void bN(int i) {
            this.itemWidth = bP(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ark != null) {
                return this.ark.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bO */
        public az getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.ark[i];
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
                cVar.arm = view.findViewById(a.g.layout_container);
                cVar.arn = view.findViewById(a.g.layout_content);
                cVar.aro = (TextView) view.findViewById(a.g.tv_name);
                cVar.arp = view.findViewById(a.g.mask);
                cVar.arq = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.arr = view.findViewById(a.g.layout_gift_count);
                cVar.ars = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            az item = getItem(i);
            Drawable background = cVar.arn.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                ((GradientDrawable) background).setColors(item.qb());
            } else {
                ((GradientDrawable) background).setColor(item.qb()[0]);
            }
            cVar.arn.setBackgroundDrawable(background);
            boolean equals = item.id.equals(k.uW().uZ());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.arl, this.from, equals)) {
                cVar.aro.setVisibility(0);
                if (item.type == 1) {
                    cVar.aro.setText(item.price + "T豆/条");
                } else {
                    cVar.aro.setText(item.name);
                }
                cVar.arr.setVisibility(8);
                cVar.arq.setVisibility(8);
            }
            cVar.arp.setVisibility(equals ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.arm.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.itemWidth, -1);
            }
            layoutParams.width = this.itemWidth;
            ViewGroup.LayoutParams layoutParams2 = cVar.arr.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.arn.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.arn.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
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
    public boolean a(c cVar, az azVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(azVar.id) && (intValue = map.get(azVar.id).intValue()) != 0 && azVar.price == 100) {
            cVar.aro.setVisibility(8);
            cVar.arq.setImageResource(z ? a.f.sdk_icon_barrage_gift_price_100_selected : a.f.sdk_icon_barrage_gift_price_100_unselected);
            cVar.arq.setVisibility(0);
            cVar.arr.setVisibility(0);
            cVar.ars.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.ars.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.arq.getLayoutParams();
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
            cVar.arq.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        View arm;
        View arn;
        TextView aro;
        View arp;
        ImageView arq;
        View arr;
        ImBarrageItemGiftCountView ars;

        private c() {
        }
    }
}
