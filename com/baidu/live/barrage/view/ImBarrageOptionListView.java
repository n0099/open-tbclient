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
import com.baidu.live.data.bz;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.g;
import java.util.Map;
/* loaded from: classes4.dex */
public class ImBarrageOptionListView extends HListView implements c {
    private a aEt;
    boolean aEu;
    private e aEv;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aEu = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aEv = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aEu = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(bz[] bzVarArr, Map<String, Integer> map, int i) {
        if (this.aEt == null) {
            this.aEt = new a();
            this.aEt.a(bzVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aEt);
            return;
        }
        this.aEt.a(bzVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aEt.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aEt != null) {
            this.aEt.dI(UtilHelper.getRealScreenOrientation(getContext()));
            this.aEt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aEt != null) {
            this.aEt.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aEt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Lm().Lo() != z) {
            d.Lm().setSwitchStatus(z);
            if (!z) {
                d.Lm().setSelectId(null);
                if (this.aEt != null && this.aEt.getCount() > 0) {
                    this.aEt.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aEt != null && this.aEt.getItem(i) != null) {
            String str = this.aEt.getItem(i).id;
            String Lp = d.Lm().Lp();
            if (TextUtils.isEmpty(Lp) || !Lp.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fZ;
        if (!TextUtils.isEmpty(str) && this.aEt != null && (fZ = fZ(str)) >= 0) {
            h(fZ, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public bz getSelectInfo() {
        if (this.aEt != null) {
            return this.aEt.getItem(fZ(d.Lm().Lp()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aEu = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i) {
        bz item;
        if (this.aEu && this.aEt != null && this.aEv != null && fZ(d.Lm().Lp()) != i && (item = this.aEt.getItem(i)) != null) {
            if (item.type == 16 && !this.aEv.Ls()) {
                BdUtilHelper.showToast(getContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aPF > this.aEv.KX()) {
                if (item.aPF == 7) {
                    BdUtilHelper.showToast(getContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aEv.eh(i);
        }
    }

    private int fZ(String str) {
        if (TextUtils.isEmpty(str) || this.aEt == null) {
            return -1;
        }
        for (int i = 0; i <= this.aEt.getCount(); i++) {
            if (this.aEt.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.Lm().setSwitchStatus(true);
        d.Lm().setSelectId(str);
        if (this.aEt != null && this.aEt.getCount() > 0) {
            this.aEt.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private bz[] aEx;
        private Map<String, Integer> aEy;
        private int aEz;
        private int from;

        private a() {
        }

        public void a(bz[] bzVarArr, Map<String, Integer> map, int i, int i2) {
            this.aEx = bzVarArr;
            this.aEy = map;
            this.from = i2;
            this.aEz = dK(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aEy = map;
            this.aEz = dK(i);
        }

        public void dI(int i) {
            this.aEz = dK(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aEx != null) {
                return this.aEx.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dJ */
        public bz getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aEx[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_im_barrage_option_item, (ViewGroup) null);
                bVar = new b();
                bVar.aEA = view.findViewById(a.g.layout_container);
                bVar.aEB = view.findViewById(a.g.layout_content);
                bVar.aEC = (TextView) view.findViewById(a.g.tv_name);
                bVar.aED = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.aEE = view.findViewById(a.g.layout_gift_count);
                bVar.aEF = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.aEG = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bz item = getItem(i);
            Drawable background = bVar.aEB.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aPC) {
                if (item.aPE >= 0 && item.aPE <= 255) {
                    ((g) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aPE);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.En(), item.Eo());
            } else {
                ((g) background).setColors(item.En());
            }
            bVar.aEB.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aEG.setVisibility(0);
                if (item.aPF == 7) {
                    bVar.aEG.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aEG.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aEG.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Lm().Lp());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aEy, this.from, equals)) {
                bVar.aEC.setVisibility(0);
                if (item.type == 1) {
                    bVar.aEC.setText(item.price + "T豆/条");
                } else {
                    bVar.aEC.setText(item.name);
                }
                bVar.aEE.setVisibility(8);
                bVar.aED.setVisibility(8);
            }
            if (equals) {
                bVar.aEA.setAlpha(1.0f);
            } else {
                bVar.aEA.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aEA.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aEz, -1);
            }
            layoutParams.width = this.aEz;
            ViewGroup.LayoutParams layoutParams2 = bVar.aEE.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aEB.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aEB.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int dK(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.e.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, bz bzVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(bzVar.id) && (intValue = map.get(bzVar.id).intValue()) != 0 && bzVar.price == 100) {
            bVar.aEC.setVisibility(8);
            bVar.aED.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.aED.setVisibility(0);
            bVar.aEE.setVisibility(0);
            bVar.aEF.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aEF.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aED.getLayoutParams();
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
            bVar.aED.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        View aEA;
        View aEB;
        TextView aEC;
        ImageView aED;
        View aEE;
        ImBarrageItemGiftCountView aEF;
        ImageView aEG;

        private b() {
        }
    }
}
