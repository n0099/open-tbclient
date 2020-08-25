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
    private a aAG;
    boolean aAH;
    private e aAI;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aAH = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aAI = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aAH = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(br[] brVarArr, Map<String, Integer> map, int i) {
        if (this.aAG == null) {
            this.aAG = new a();
            this.aAG.a(brVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aAG);
            return;
        }
        this.aAG.a(brVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aAG.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aAG != null) {
            this.aAG.dz(UtilHelper.getRealScreenOrientation(getContext()));
            this.aAG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aAG != null) {
            this.aAG.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aAG.notifyDataSetChanged();
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
                if (this.aAG != null && this.aAG.getCount() > 0) {
                    this.aAG.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aAG != null && this.aAG.getItem(i) != null) {
            String str = this.aAG.getItem(i).id;
            String JG = d.JD().JG();
            if (TextUtils.isEmpty(JG) || !JG.equals(str)) {
                f(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fG;
        if (!TextUtils.isEmpty(str) && this.aAG != null && (fG = fG(str)) >= 0) {
            f(fG, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public br getSelectInfo() {
        if (this.aAG != null) {
            return this.aAG.getItem(fG(d.JD().JG()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aAH = true;
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
        if (this.aAH && this.aAG != null && this.aAI != null && fG(d.JD().JG()) != i && (item = this.aAG.getItem(i)) != null) {
            if (item.type == 16 && !this.aAI.JJ()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aKR > this.aAI.Jn()) {
                if (item.aKR == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aAI.dY(i);
        }
    }

    private int fG(String str) {
        if (TextUtils.isEmpty(str) || this.aAG == null) {
            return -1;
        }
        for (int i = 0; i <= this.aAG.getCount(); i++) {
            if (this.aAG.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void f(int i, String str) {
        d.JD().setSwitchStatus(true);
        d.JD().setSelectId(str);
        if (this.aAG != null && this.aAG.getCount() > 0) {
            this.aAG.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BaseAdapter {
        private br[] aAK;
        private Map<String, Integer> aAL;
        private int aAM;
        private int from;

        private a() {
        }

        public void a(br[] brVarArr, Map<String, Integer> map, int i, int i2) {
            this.aAK = brVarArr;
            this.aAL = map;
            this.from = i2;
            this.aAM = dB(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aAL = map;
            this.aAM = dB(i);
        }

        public void dz(int i) {
            this.aAM = dB(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aAK != null) {
                return this.aAK.length;
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
            return this.aAK[i];
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
                bVar.aAN = view.findViewById(a.g.layout_container);
                bVar.aAO = view.findViewById(a.g.layout_content);
                bVar.aAP = (TextView) view.findViewById(a.g.tv_name);
                bVar.aAQ = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.aAR = view.findViewById(a.g.layout_gift_count);
                bVar.aAS = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.aAT = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            br item = getItem(i);
            Drawable background = bVar.aAO.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aKO) {
                if (item.aKQ >= 0 && item.aKQ <= 255) {
                    ((g) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aKQ);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.Da(), item.Db());
            } else {
                ((g) background).setColors(item.Da());
            }
            bVar.aAO.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aAT.setVisibility(0);
                if (item.aKR == 7) {
                    bVar.aAT.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aAT.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aAT.setVisibility(8);
            }
            boolean equals = item.id.equals(d.JD().JG());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aAL, this.from, equals)) {
                bVar.aAP.setVisibility(0);
                if (item.type == 1) {
                    bVar.aAP.setText(item.price + "T豆/条");
                } else {
                    bVar.aAP.setText(item.name);
                }
                bVar.aAR.setVisibility(8);
                bVar.aAQ.setVisibility(8);
            }
            if (equals) {
                bVar.aAN.setAlpha(1.0f);
            } else {
                bVar.aAN.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aAN.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aAM, -1);
            }
            layoutParams.width = this.aAM;
            ViewGroup.LayoutParams layoutParams2 = bVar.aAR.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aAO.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aAO.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
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
            bVar.aAP.setVisibility(8);
            bVar.aAQ.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.aAQ.setVisibility(0);
            bVar.aAR.setVisibility(0);
            bVar.aAS.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aAS.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aAQ.getLayoutParams();
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
            bVar.aAQ.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        View aAN;
        View aAO;
        TextView aAP;
        ImageView aAQ;
        View aAR;
        ImBarrageItemGiftCountView aAS;
        ImageView aAT;

        private b() {
        }
    }
}
