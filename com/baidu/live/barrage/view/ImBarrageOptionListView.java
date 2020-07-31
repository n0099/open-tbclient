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
import com.baidu.live.data.bp;
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
    private a avE;
    boolean avF;
    private e avG;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.avF = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.avG = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.avF = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(bp[] bpVarArr, Map<String, Integer> map, int i) {
        if (this.avE == null) {
            this.avE = new a();
            this.avE.a(bpVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.avE);
            return;
        }
        this.avE.a(bpVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.avE.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.avE != null) {
            this.avE.bN(UtilHelper.getRealScreenOrientation(getContext()));
            this.avE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.avE != null) {
            this.avE.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.avE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Ea().Ec() != z) {
            d.Ea().setSwitchStatus(z);
            if (!z) {
                d.Ea().setSelectId(null);
                if (this.avE != null && this.avE.getCount() > 0) {
                    this.avE.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.avE != null && this.avE.getItem(i) != null) {
            String str = this.avE.getItem(i).id;
            String Ed = d.Ea().Ed();
            if (TextUtils.isEmpty(Ed) || !Ed.equals(str)) {
                g(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int eo;
        if (!TextUtils.isEmpty(str) && this.avE != null && (eo = eo(str)) >= 0) {
            g(eo, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public bp getSelectInfo() {
        if (this.avE != null) {
            return this.avE.getItem(eo(d.Ea().Ed()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.avF = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.bM(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i) {
        bp item;
        if (this.avF && this.avE != null && this.avG != null && eo(d.Ea().Ed()) != i && (item = this.avE.getItem(i)) != null) {
            if (item.type == 16 && !this.avG.Eg()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aFH > this.avG.DK()) {
                if (item.aFH == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.avG.cj(i);
        }
    }

    private int eo(String str) {
        if (TextUtils.isEmpty(str) || this.avE == null) {
            return -1;
        }
        for (int i = 0; i <= this.avE.getCount(); i++) {
            if (this.avE.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void g(int i, String str) {
        d.Ea().setSwitchStatus(true);
        d.Ea().setSelectId(str);
        if (this.avE != null && this.avE.getCount() > 0) {
            this.avE.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private bp[] avI;
        private Map<String, Integer> avJ;
        private int avK;
        private int from;

        private a() {
        }

        public void a(bp[] bpVarArr, Map<String, Integer> map, int i, int i2) {
            this.avI = bpVarArr;
            this.avJ = map;
            this.from = i2;
            this.avK = bP(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.avJ = map;
            this.avK = bP(i);
        }

        public void bN(int i) {
            this.avK = bP(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.avI != null) {
                return this.avI.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bO */
        public bp getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.avI[i];
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
                bVar.avL = view.findViewById(a.g.layout_container);
                bVar.avM = view.findViewById(a.g.layout_content);
                bVar.avN = (TextView) view.findViewById(a.g.tv_name);
                bVar.avO = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.avP = view.findViewById(a.g.layout_gift_count);
                bVar.avQ = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.avR = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bp item = getItem(i);
            Drawable background = bVar.avM.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aFE) {
                if (item.aFG >= 0 && item.aFG <= 255) {
                    ((g) background).L(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aFG);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.xx(), item.xy());
            } else {
                ((g) background).setColors(item.xx());
            }
            bVar.avM.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.avR.setVisibility(0);
                if (item.aFH == 7) {
                    bVar.avR.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.avR.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.avR.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Ea().Ed());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.avJ, this.from, equals)) {
                bVar.avN.setVisibility(0);
                if (item.type == 1) {
                    bVar.avN.setText(item.price + "T豆/条");
                } else {
                    bVar.avN.setText(item.name);
                }
                bVar.avP.setVisibility(8);
                bVar.avO.setVisibility(8);
            }
            if (equals) {
                bVar.avL.setAlpha(1.0f);
            } else {
                bVar.avL.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.avL.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.avK, -1);
            }
            layoutParams.width = this.avK;
            ViewGroup.LayoutParams layoutParams2 = bVar.avP.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.avM.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.avM.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int bP(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.e.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, bp bpVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(bpVar.id) && (intValue = map.get(bpVar.id).intValue()) != 0 && bpVar.price == 100) {
            bVar.avN.setVisibility(8);
            bVar.avO.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.avO.setVisibility(0);
            bVar.avP.setVisibility(0);
            bVar.avQ.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.avQ.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.avO.getLayoutParams();
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
            bVar.avO.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        View avL;
        View avM;
        TextView avN;
        ImageView avO;
        View avP;
        ImBarrageItemGiftCountView avQ;
        ImageView avR;

        private b() {
        }
    }
}
