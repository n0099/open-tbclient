package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.baidu.live.data.bo;
import com.baidu.live.im.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.g;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImBarrageOptionListView extends HListView {
    private b aXQ;
    boolean aXR;
    private a aXS;
    private int mDividerWidth;

    /* loaded from: classes3.dex */
    public interface a {
        int Di();

        boolean Ec();

        void cd(int i);
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXR = true;
        init();
    }

    public void setCallback(a aVar) {
        this.aXS = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aXR = z;
    }

    public void setData(bo[] boVarArr, Map<String, Integer> map, int i) {
        if (this.aXQ == null) {
            this.aXQ = new b();
            this.aXQ.a(boVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aXQ);
            return;
        }
        this.aXQ.a(boVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aXQ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aXQ != null) {
            this.aXQ.cA(UtilHelper.getRealScreenOrientation(getContext()));
            this.aXQ.notifyDataSetChanged();
        }
    }

    public void g(Map<String, Integer> map) {
        if (this.aXQ != null) {
            this.aXQ.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aXQ.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (m.Dm().Do() != z) {
            m.Dm().setSwitchStatus(z);
            if (!z) {
                m.Dm().setSelectId(null);
                if (this.aXQ != null && this.aXQ.getCount() > 0) {
                    this.aXQ.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.aXQ != null && this.aXQ.getItem(i) != null) {
            String str = this.aXQ.getItem(i).id;
            String Dp = m.Dm().Dp();
            if (TextUtils.isEmpty(Dp) || !Dp.equals(str)) {
                p(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int fA;
        if (!TextUtils.isEmpty(str) && this.aXQ != null && (fA = fA(str)) >= 0) {
            p(fA, str);
        }
    }

    public bo getSelectInfo() {
        if (this.aXQ != null) {
            return this.aXQ.getItem(fA(m.Dm().Dp()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aXR = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.barrage.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.cD(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(int i) {
        bo item;
        if (this.aXR && this.aXQ != null && this.aXS != null && fA(m.Dm().Dp()) != i && (item = this.aXQ.getItem(i)) != null) {
            if (item.type == 16 && !this.aXS.Ec()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aEn > this.aXS.Di()) {
                if (item.aEn == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aXS.cd(i);
        }
    }

    private int fA(String str) {
        if (TextUtils.isEmpty(str) || this.aXQ == null) {
            return -1;
        }
        for (int i = 0; i <= this.aXQ.getCount(); i++) {
            if (this.aXQ.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void p(int i, String str) {
        m.Dm().setSwitchStatus(true);
        m.Dm().setSelectId(str);
        if (this.aXQ != null && this.aXQ.getCount() > 0) {
            this.aXQ.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private bo[] aXU;
        private Map<String, Integer> aXV;
        private int aXW;
        private int from;

        private b() {
        }

        public void a(bo[] boVarArr, Map<String, Integer> map, int i, int i2) {
            this.aXU = boVarArr;
            this.aXV = map;
            this.from = i2;
            this.aXW = cF(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aXV = map;
            this.aXW = cF(i);
        }

        public void cA(int i) {
            this.aXW = cF(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aXU != null) {
                return this.aXU.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: cE */
        public bo getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aXU[i];
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
                cVar.aXX = view.findViewById(a.g.layout_container);
                cVar.aXY = view.findViewById(a.g.layout_content);
                cVar.aXZ = (TextView) view.findViewById(a.g.tv_name);
                cVar.aYa = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.aYb = view.findViewById(a.g.layout_gift_count);
                cVar.aYc = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                cVar.aYd = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            bo item = getItem(i);
            Drawable background = cVar.aXY.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aEk) {
                if (item.aEm >= 0 && item.aEm <= 255) {
                    ((g) background).L(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aEm);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.wU(), item.wV());
            } else {
                ((g) background).setColors(item.wU());
            }
            cVar.aXY.setBackgroundDrawable(background);
            if (item.type == 17) {
                cVar.aYd.setVisibility(0);
                if (item.aEn == 7) {
                    cVar.aYd.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    cVar.aYd.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                cVar.aYd.setVisibility(8);
            }
            boolean equals = item.id.equals(m.Dm().Dp());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aXV, this.from, equals)) {
                cVar.aXZ.setVisibility(0);
                if (item.type == 1) {
                    cVar.aXZ.setText(item.price + "T豆/条");
                } else {
                    cVar.aXZ.setText(item.name);
                }
                cVar.aYb.setVisibility(8);
                cVar.aYa.setVisibility(8);
            }
            if (equals) {
                cVar.aXX.setAlpha(1.0f);
            } else {
                cVar.aXX.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = cVar.aXX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aXW, -1);
            }
            layoutParams.width = this.aXW;
            ViewGroup.LayoutParams layoutParams2 = cVar.aYb.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.aXY.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.aXY.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int cF(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.e.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, bo boVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(boVar.id) && (intValue = map.get(boVar.id).intValue()) != 0 && boVar.price == 100) {
            cVar.aXZ.setVisibility(8);
            cVar.aYa.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            cVar.aYa.setVisibility(0);
            cVar.aYb.setVisibility(0);
            cVar.aYc.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aYc.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.aYa.getLayoutParams();
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
            cVar.aYa.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        View aXX;
        View aXY;
        TextView aXZ;
        ImageView aYa;
        View aYb;
        ImBarrageItemGiftCountView aYc;
        ImageView aYd;

        private c() {
        }
    }
}
