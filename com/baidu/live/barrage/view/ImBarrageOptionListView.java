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
import com.baidu.live.data.br;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.g;
import java.util.Map;
/* loaded from: classes7.dex */
public class ImBarrageOptionListView extends HListView implements c {
    private a aAI;
    boolean aAJ;
    private e aAK;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aAJ = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aAK = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aAJ = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(br[] brVarArr, Map<String, Integer> map, int i) {
        if (this.aAI == null) {
            this.aAI = new a();
            this.aAI.a(brVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aAI);
            return;
        }
        this.aAI.a(brVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aAI.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aAI != null) {
            this.aAI.dz(UtilHelper.getRealScreenOrientation(getContext()));
            this.aAI.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aAI != null) {
            this.aAI.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aAI.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.JD().JF() != z) {
            d.JD().setSwitchStatus(z);
            if (!z) {
                d.JD().setSelectId(null);
                if (this.aAI != null && this.aAI.getCount() > 0) {
                    this.aAI.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aAI != null && this.aAI.getItem(i) != null) {
            String str = this.aAI.getItem(i).id;
            String JG = d.JD().JG();
            if (TextUtils.isEmpty(JG) || !JG.equals(str)) {
                f(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fH;
        if (!TextUtils.isEmpty(str) && this.aAI != null && (fH = fH(str)) >= 0) {
            f(fH, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public br getSelectInfo() {
        if (this.aAI != null) {
            return this.aAI.getItem(fH(d.JD().JG()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aAJ = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dy(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i) {
        br item;
        if (this.aAJ && this.aAI != null && this.aAK != null && fH(d.JD().JG()) != i && (item = this.aAI.getItem(i)) != null) {
            if (item.type == 16 && !this.aAK.JJ()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aKT > this.aAK.Jn()) {
                if (item.aKT == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aAK.dY(i);
        }
    }

    private int fH(String str) {
        if (TextUtils.isEmpty(str) || this.aAI == null) {
            return -1;
        }
        for (int i = 0; i <= this.aAI.getCount(); i++) {
            if (this.aAI.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void f(int i, String str) {
        d.JD().setSwitchStatus(true);
        d.JD().setSelectId(str);
        if (this.aAI != null && this.aAI.getCount() > 0) {
            this.aAI.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private br[] aAM;
        private Map<String, Integer> aAN;
        private int aAO;
        private int from;

        private a() {
        }

        public void a(br[] brVarArr, Map<String, Integer> map, int i, int i2) {
            this.aAM = brVarArr;
            this.aAN = map;
            this.from = i2;
            this.aAO = dB(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aAN = map;
            this.aAO = dB(i);
        }

        public void dz(int i) {
            this.aAO = dB(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aAM != null) {
                return this.aAM.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dA */
        public br getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aAM[i];
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
                bVar.aAP = view.findViewById(a.g.layout_container);
                bVar.aAQ = view.findViewById(a.g.layout_content);
                bVar.aAR = (TextView) view.findViewById(a.g.tv_name);
                bVar.aAS = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.aAT = view.findViewById(a.g.layout_gift_count);
                bVar.aAU = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.aAV = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            br item = getItem(i);
            Drawable background = bVar.aAQ.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aKQ) {
                if (item.aKS >= 0 && item.aKS <= 255) {
                    ((g) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aKS);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.Da(), item.Db());
            } else {
                ((g) background).setColors(item.Da());
            }
            bVar.aAQ.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aAV.setVisibility(0);
                if (item.aKT == 7) {
                    bVar.aAV.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aAV.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aAV.setVisibility(8);
            }
            boolean equals = item.id.equals(d.JD().JG());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aAN, this.from, equals)) {
                bVar.aAR.setVisibility(0);
                if (item.type == 1) {
                    bVar.aAR.setText(item.price + "T豆/条");
                } else {
                    bVar.aAR.setText(item.name);
                }
                bVar.aAT.setVisibility(8);
                bVar.aAS.setVisibility(8);
            }
            if (equals) {
                bVar.aAP.setAlpha(1.0f);
            } else {
                bVar.aAP.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aAP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aAO, -1);
            }
            layoutParams.width = this.aAO;
            ViewGroup.LayoutParams layoutParams2 = bVar.aAT.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aAQ.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aAQ.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int dB(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.e.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, br brVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(brVar.id) && (intValue = map.get(brVar.id).intValue()) != 0 && brVar.price == 100) {
            bVar.aAR.setVisibility(8);
            bVar.aAS.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.aAS.setVisibility(0);
            bVar.aAT.setVisibility(0);
            bVar.aAU.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aAU.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aAS.getLayoutParams();
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
            bVar.aAS.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        View aAP;
        View aAQ;
        TextView aAR;
        ImageView aAS;
        View aAT;
        ImBarrageItemGiftCountView aAU;
        ImageView aAV;

        private b() {
        }
    }
}
