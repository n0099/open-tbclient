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
    private a aFr;
    boolean aFs;
    private e aFt;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aFs = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aFt = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aFs = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(cg[] cgVarArr, Map<String, Integer> map, int i) {
        if (this.aFr == null) {
            this.aFr = new a();
            this.aFr.a(cgVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aFr);
            return;
        }
        this.aFr.a(cgVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aFr.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aFr != null) {
            this.aFr.dI(UtilHelper.getRealScreenOrientation(getContext()));
            this.aFr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aFr != null) {
            this.aFr.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aFr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Mg().Mj() != z) {
            d.Mg().setSwitchStatus(z);
            if (!z) {
                d.Mg().setSelectId(null);
                if (this.aFr != null && this.aFr.getCount() > 0) {
                    this.aFr.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aFr != null && this.aFr.getItem(i) != null) {
            String str = this.aFr.getItem(i).id;
            String Mk = d.Mg().Mk();
            if (TextUtils.isEmpty(Mk) || !Mk.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int gf;
        if (!TextUtils.isEmpty(str) && this.aFr != null && (gf = gf(str)) >= 0) {
            h(gf, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public cg getSelectInfo() {
        if (this.aFr != null) {
            return this.aFr.getItem(gf(d.Mg().Mk()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aFs = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i) {
        cg item;
        if (this.aFs && this.aFr != null && this.aFt != null && gf(d.Mg().Mk()) != i && (item = this.aFr.getItem(i)) != null) {
            if (item.type == 16 && !this.aFt.Mn()) {
                BdUtilHelper.showToast(getContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aRr > this.aFt.LR()) {
                if (item.aRr == 7) {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aFt.ei(i);
        }
    }

    private int gf(String str) {
        if (TextUtils.isEmpty(str) || this.aFr == null) {
            return -1;
        }
        for (int i = 0; i <= this.aFr.getCount(); i++) {
            if (this.aFr.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.Mg().setSwitchStatus(true);
        d.Mg().setSelectId(str);
        if (this.aFr != null && this.aFr.getCount() > 0) {
            this.aFr.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private cg[] aFv;
        private Map<String, Integer> aFw;
        private int aFx;
        private int from;

        private a() {
        }

        public void a(cg[] cgVarArr, Map<String, Integer> map, int i, int i2) {
            this.aFv = cgVarArr;
            this.aFw = map;
            this.from = i2;
            this.aFx = dK(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aFw = map;
            this.aFx = dK(i);
        }

        public void dI(int i) {
            this.aFx = dK(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFv != null) {
                return this.aFv.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dJ */
        public cg getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aFv[i];
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
                bVar.aFy = view.findViewById(a.f.layout_container);
                bVar.aFz = view.findViewById(a.f.layout_content);
                bVar.aFA = (TextView) view.findViewById(a.f.tv_name);
                bVar.aFB = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aFC = view.findViewById(a.f.layout_gift_count);
                bVar.aFD = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aFE = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            cg item = getItem(i);
            Drawable background = bVar.aFz.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aRo) {
                if (item.aRq >= 0 && item.aRq <= 255) {
                    ((f) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aRq);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.EX(), item.EY());
            } else {
                ((f) background).setColors(item.EX());
            }
            bVar.aFz.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aFE.setVisibility(0);
                if (item.aRr == 7) {
                    bVar.aFE.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aFE.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aFE.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Mg().Mk());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aFw, this.from, equals)) {
                bVar.aFA.setVisibility(0);
                if (item.type == 1) {
                    bVar.aFA.setText(item.price + "T豆/条");
                } else {
                    bVar.aFA.setText(item.name);
                }
                bVar.aFC.setVisibility(8);
                bVar.aFB.setVisibility(8);
            }
            if (equals) {
                bVar.aFy.setAlpha(1.0f);
            } else {
                bVar.aFy.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aFy.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aFx, -1);
            }
            layoutParams.width = this.aFx;
            ViewGroup.LayoutParams layoutParams2 = bVar.aFC.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aFz.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aFz.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int dK(int i) {
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
            bVar.aFA.setVisibility(8);
            bVar.aFB.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aFB.setVisibility(0);
            bVar.aFC.setVisibility(0);
            bVar.aFD.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aFD.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aFB.getLayoutParams();
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
            bVar.aFB.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        TextView aFA;
        ImageView aFB;
        View aFC;
        ImBarrageItemGiftCountView aFD;
        ImageView aFE;
        View aFy;
        View aFz;

        private b() {
        }
    }
}
