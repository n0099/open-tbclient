package com.baidu.live.yuyinbarrage.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ck;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.f;
import java.util.Map;
/* loaded from: classes11.dex */
public class ImBarrageOptionListView extends HListView implements c {
    boolean aGE;
    private e aGF;
    private a bYp;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aGE = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aGF = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aGE = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(ck[] ckVarArr, Map<String, Integer> map, int i) {
        if (this.bYp == null) {
            this.bYp = new a();
            this.bYp.a(ckVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.bYp);
            return;
        }
        this.bYp.a(ckVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.bYp.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.bYp != null) {
            this.bYp.dU(UtilHelper.getRealScreenOrientation(getContext()));
            this.bYp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.bYp != null) {
            this.bYp.b(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.bYp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Nk().Nn() != z) {
            d.Nk().setSwitchStatus(z);
            if (!z) {
                d.Nk().setSelectId(null);
                if (this.bYp != null && this.bYp.getCount() > 0) {
                    this.bYp.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.bYp != null && this.bYp.getItem(i) != null) {
            String str = this.bYp.getItem(i).id;
            String No = d.Nk().No();
            if (TextUtils.isEmpty(No) || !No.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int ge;
        if (!TextUtils.isEmpty(str) && this.bYp != null && (ge = ge(str)) >= 0) {
            h(ge, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public ck getSelectInfo() {
        if (this.bYp != null) {
            return this.bYp.getItem(ge(d.Nk().No()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aGE = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dT(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dT(int i) {
        ck item;
        if (this.aGE && this.bYp != null && this.aGF != null && ge(d.Nk().No()) != i && (item = this.bYp.getItem(i)) != null) {
            if (item.type == 16 && !this.aGF.Nt()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aTG > this.aGF.MK()) {
                if (item.aTG == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aGF.fb(i);
        }
    }

    private int ge(String str) {
        if (TextUtils.isEmpty(str) || this.bYp == null) {
            return -1;
        }
        for (int i = 0; i <= this.bYp.getCount(); i++) {
            if (this.bYp.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.Nk().setSwitchStatus(true);
        d.Nk().setSelectId(str);
        if (this.bYp != null && this.bYp.getCount() > 0) {
            this.bYp.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private ck[] aGH;
        private Map<String, Integer> aGI;
        private int aGJ;
        private int from;

        private a() {
        }

        public void a(ck[] ckVarArr, Map<String, Integer> map, int i, int i2) {
            this.aGH = ckVarArr;
            this.aGI = map;
            this.from = i2;
            this.aGJ = dW(i);
        }

        public void b(Map<String, Integer> map, int i) {
            this.aGI = map;
            this.aGJ = dW(i);
        }

        public void dU(int i) {
            this.aGJ = dW(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aGH != null) {
                return this.aGH.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dV */
        public ck getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aGH[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyinala_im_barrage_option_item, (ViewGroup) null);
                bVar = new b();
                bVar.aGK = view.findViewById(a.f.layout_container);
                bVar.aGL = view.findViewById(a.f.layout_content);
                bVar.aGM = (TextView) view.findViewById(a.f.tv_name);
                bVar.aGN = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aGO = view.findViewById(a.f.layout_gift_count);
                bVar.bYr = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aGQ = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ck item = getItem(i);
            Drawable background = bVar.aGL.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aTD) {
                if (item.aTF >= 0 && item.aTF <= 255) {
                    ((f) background).O(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aTF);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.Fs(), item.Ft());
            } else {
                ((f) background).setColors(item.Fs());
            }
            bVar.aGL.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aGQ.setVisibility(0);
                if (item.aTG == 7) {
                    bVar.aGQ.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aGQ.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aGQ.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Nk().No());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aGI, this.from, equals)) {
                bVar.aGM.setVisibility(0);
                if (item.type == 1) {
                    bVar.aGM.setText(item.price + "T豆/条");
                } else {
                    bVar.aGM.setText(item.name);
                }
                bVar.aGO.setVisibility(8);
                bVar.aGN.setVisibility(8);
            }
            if (equals) {
                bVar.aGK.setAlpha(1.0f);
            } else {
                bVar.aGK.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aGK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aGJ, -1);
            }
            layoutParams.width = this.aGJ;
            ViewGroup.LayoutParams layoutParams2 = bVar.aGO.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aGL.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aGL.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int dW(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.d.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, ck ckVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(ckVar.id) && (intValue = map.get(ckVar.id).intValue()) != 0 && ckVar.price == 100) {
            bVar.aGM.setVisibility(8);
            bVar.aGN.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aGN.setVisibility(0);
            bVar.aGO.setVisibility(0);
            bVar.bYr.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.bYr.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aGN.getLayoutParams();
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
            bVar.aGN.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        View aGK;
        View aGL;
        TextView aGM;
        ImageView aGN;
        View aGO;
        ImageView aGQ;
        ImBarrageItemGiftCountView bYr;

        private b() {
        }
    }
}
