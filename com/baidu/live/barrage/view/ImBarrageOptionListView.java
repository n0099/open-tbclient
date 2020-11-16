package com.baidu.live.barrage.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.cg;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.f;
import java.util.Map;
/* loaded from: classes4.dex */
public class ImBarrageOptionListView extends HListView implements c {
    private a aDG;
    boolean aDH;
    private e aDI;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aDH = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aDI = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aDH = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(cg[] cgVarArr, Map<String, Integer> map, int i) {
        if (this.aDG == null) {
            this.aDG = new a();
            this.aDG.a(cgVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aDG);
            return;
        }
        this.aDG.a(cgVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aDG.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aDG != null) {
            this.aDG.dE(UtilHelper.getRealScreenOrientation(getContext()));
            this.aDG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aDG != null) {
            this.aDG.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aDG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Lx().LA() != z) {
            d.Lx().setSwitchStatus(z);
            if (!z) {
                d.Lx().setSelectId(null);
                if (this.aDG != null && this.aDG.getCount() > 0) {
                    this.aDG.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aDG != null && this.aDG.getItem(i) != null) {
            String str = this.aDG.getItem(i).id;
            String LB = d.Lx().LB();
            if (TextUtils.isEmpty(LB) || !LB.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fZ;
        if (!TextUtils.isEmpty(str) && this.aDG != null && (fZ = fZ(str)) >= 0) {
            h(fZ, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public cg getSelectInfo() {
        if (this.aDG != null) {
            return this.aDG.getItem(fZ(d.Lx().LB()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aDH = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dD(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i) {
        cg item;
        if (this.aDH && this.aDG != null && this.aDI != null && fZ(d.Lx().LB()) != i && (item = this.aDG.getItem(i)) != null) {
            if (item.type == 16 && !this.aDI.LE()) {
                BdUtilHelper.showToast(getContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aPG > this.aDI.Li()) {
                if (item.aPG == 7) {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aDI.ee(i);
        }
    }

    private int fZ(String str) {
        if (TextUtils.isEmpty(str) || this.aDG == null) {
            return -1;
        }
        for (int i = 0; i <= this.aDG.getCount(); i++) {
            if (this.aDG.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.Lx().setSwitchStatus(true);
        d.Lx().setSelectId(str);
        if (this.aDG != null && this.aDG.getCount() > 0) {
            this.aDG.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private cg[] aDK;
        private Map<String, Integer> aDL;
        private int aDM;
        private int from;

        private a() {
        }

        public void a(cg[] cgVarArr, Map<String, Integer> map, int i, int i2) {
            this.aDK = cgVarArr;
            this.aDL = map;
            this.from = i2;
            this.aDM = dG(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aDL = map;
            this.aDM = dG(i);
        }

        public void dE(int i) {
            this.aDM = dG(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDK != null) {
                return this.aDK.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dF */
        public cg getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aDK[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_im_barrage_option_item, (ViewGroup) null);
                bVar = new b();
                bVar.aDN = view.findViewById(a.f.layout_container);
                bVar.aDO = view.findViewById(a.f.layout_content);
                bVar.aDP = (TextView) view.findViewById(a.f.tv_name);
                bVar.aDQ = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aDR = view.findViewById(a.f.layout_gift_count);
                bVar.aDS = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aDT = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            cg item = getItem(i);
            Drawable background = bVar.aDO.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aPD) {
                if (item.aPF >= 0 && item.aPF <= 255) {
                    ((f) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aPF);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.Eo(), item.Ep());
            } else {
                ((f) background).setColors(item.Eo());
            }
            bVar.aDO.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aDT.setVisibility(0);
                if (item.aPG == 7) {
                    bVar.aDT.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aDT.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aDT.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Lx().LB());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aDL, this.from, equals)) {
                bVar.aDP.setVisibility(0);
                if (item.type == 1) {
                    bVar.aDP.setText(item.price + "T豆/条");
                } else {
                    bVar.aDP.setText(item.name);
                }
                bVar.aDR.setVisibility(8);
                bVar.aDQ.setVisibility(8);
            }
            if (equals) {
                bVar.aDN.setAlpha(1.0f);
            } else {
                bVar.aDN.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aDN.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aDM, -1);
            }
            layoutParams.width = this.aDM;
            ViewGroup.LayoutParams layoutParams2 = bVar.aDR.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aDO.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aDO.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int dG(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.d.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, cg cgVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(cgVar.id) && (intValue = map.get(cgVar.id).intValue()) != 0 && cgVar.price == 100) {
            bVar.aDP.setVisibility(8);
            bVar.aDQ.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aDQ.setVisibility(0);
            bVar.aDR.setVisibility(0);
            bVar.aDS.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aDS.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aDQ.getLayoutParams();
            if (i == 0) {
                layoutParams.width = -2;
                layoutParams.height = -1;
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds18);
            } else {
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds116);
                layoutParams.height = getResources().getDimensionPixelOffset(a.d.sdk_ds72);
                layoutParams.addRule(12);
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds12);
            }
            bVar.aDQ.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        View aDN;
        View aDO;
        TextView aDP;
        ImageView aDQ;
        View aDR;
        ImBarrageItemGiftCountView aDS;
        ImageView aDT;

        private b() {
        }
    }
}
