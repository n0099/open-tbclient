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
import com.baidu.live.data.ce;
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
    private a aEB;
    boolean aEC;
    private e aED;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aEC = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aED = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aEC = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(ce[] ceVarArr, Map<String, Integer> map, int i) {
        if (this.aEB == null) {
            this.aEB = new a();
            this.aEB.a(ceVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aEB);
            return;
        }
        this.aEB.a(ceVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aEB.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aEB != null) {
            this.aEB.dI(UtilHelper.getRealScreenOrientation(getContext()));
            this.aEB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aEB != null) {
            this.aEB.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aEB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.LG().LJ() != z) {
            d.LG().setSwitchStatus(z);
            if (!z) {
                d.LG().setSelectId(null);
                if (this.aEB != null && this.aEB.getCount() > 0) {
                    this.aEB.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aEB != null && this.aEB.getItem(i) != null) {
            String str = this.aEB.getItem(i).id;
            String LK = d.LG().LK();
            if (TextUtils.isEmpty(LK) || !LK.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int ga;
        if (!TextUtils.isEmpty(str) && this.aEB != null && (ga = ga(str)) >= 0) {
            h(ga, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public ce getSelectInfo() {
        if (this.aEB != null) {
            return this.aEB.getItem(ga(d.LG().LK()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aEC = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dH(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i) {
        ce item;
        if (this.aEC && this.aEB != null && this.aED != null && ga(d.LG().LK()) != i && (item = this.aEB.getItem(i)) != null) {
            if (item.type == 16 && !this.aED.LN()) {
                BdUtilHelper.showToast(getContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aQp > this.aED.Lr()) {
                if (item.aQp == 7) {
                    BdUtilHelper.showToast(getContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aED.ei(i);
        }
    }

    private int ga(String str) {
        if (TextUtils.isEmpty(str) || this.aEB == null) {
            return -1;
        }
        for (int i = 0; i <= this.aEB.getCount(); i++) {
            if (this.aEB.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.LG().setSwitchStatus(true);
        d.LG().setSelectId(str);
        if (this.aEB != null && this.aEB.getCount() > 0) {
            this.aEB.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private ce[] aEF;
        private Map<String, Integer> aEG;
        private int aEH;
        private int from;

        private a() {
        }

        public void a(ce[] ceVarArr, Map<String, Integer> map, int i, int i2) {
            this.aEF = ceVarArr;
            this.aEG = map;
            this.from = i2;
            this.aEH = dK(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aEG = map;
            this.aEH = dK(i);
        }

        public void dI(int i) {
            this.aEH = dK(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aEF != null) {
                return this.aEF.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dJ */
        public ce getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aEF[i];
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
                bVar.aEI = view.findViewById(a.g.layout_container);
                bVar.aEJ = view.findViewById(a.g.layout_content);
                bVar.aEK = (TextView) view.findViewById(a.g.tv_name);
                bVar.aEL = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.aEM = view.findViewById(a.g.layout_gift_count);
                bVar.aEN = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.aEO = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ce item = getItem(i);
            Drawable background = bVar.aEJ.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aQm) {
                if (item.aQo >= 0 && item.aQo <= 255) {
                    ((g) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aQo);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.Ew(), item.Ex());
            } else {
                ((g) background).setColors(item.Ew());
            }
            bVar.aEJ.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aEO.setVisibility(0);
                if (item.aQp == 7) {
                    bVar.aEO.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aEO.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aEO.setVisibility(8);
            }
            boolean equals = item.id.equals(d.LG().LK());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aEG, this.from, equals)) {
                bVar.aEK.setVisibility(0);
                if (item.type == 1) {
                    bVar.aEK.setText(item.price + "T豆/条");
                } else {
                    bVar.aEK.setText(item.name);
                }
                bVar.aEM.setVisibility(8);
                bVar.aEL.setVisibility(8);
            }
            if (equals) {
                bVar.aEI.setAlpha(1.0f);
            } else {
                bVar.aEI.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aEI.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aEH, -1);
            }
            layoutParams.width = this.aEH;
            ViewGroup.LayoutParams layoutParams2 = bVar.aEM.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aEJ.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aEJ.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
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
    public boolean a(b bVar, ce ceVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(ceVar.id) && (intValue = map.get(ceVar.id).intValue()) != 0 && ceVar.price == 100) {
            bVar.aEK.setVisibility(8);
            bVar.aEL.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.aEL.setVisibility(0);
            bVar.aEM.setVisibility(0);
            bVar.aEN.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aEN.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aEL.getLayoutParams();
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
            bVar.aEL.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        View aEI;
        View aEJ;
        TextView aEK;
        ImageView aEL;
        View aEM;
        ImBarrageItemGiftCountView aEN;
        ImageView aEO;

        private b() {
        }
    }
}
