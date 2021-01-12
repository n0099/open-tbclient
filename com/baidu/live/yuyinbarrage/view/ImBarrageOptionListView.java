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
/* loaded from: classes10.dex */
public class ImBarrageOptionListView extends HListView implements c {
    boolean aBR;
    private e aBS;
    private a bTD;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aBR = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aBS = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aBR = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(ck[] ckVarArr, Map<String, Integer> map, int i) {
        if (this.bTD == null) {
            this.bTD = new a();
            this.bTD.a(ckVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.bTD);
            return;
        }
        this.bTD.a(ckVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.bTD.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.bTD != null) {
            this.bTD.co(UtilHelper.getRealScreenOrientation(getContext()));
            this.bTD.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.bTD != null) {
            this.bTD.b(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.bTD.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Jp().Js() != z) {
            d.Jp().setSwitchStatus(z);
            if (!z) {
                d.Jp().setSelectId(null);
                if (this.bTD != null && this.bTD.getCount() > 0) {
                    this.bTD.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.bTD != null && this.bTD.getItem(i) != null) {
            String str = this.bTD.getItem(i).id;
            String Jt = d.Jp().Jt();
            if (TextUtils.isEmpty(Jt) || !Jt.equals(str)) {
                i(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int eT;
        if (!TextUtils.isEmpty(str) && this.bTD != null && (eT = eT(str)) >= 0) {
            i(eT, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public ck getSelectInfo() {
        if (this.bTD != null) {
            return this.bTD.getItem(eT(d.Jp().Jt()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aBR = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.cn(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(int i) {
        ck item;
        if (this.aBR && this.bTD != null && this.aBS != null && eT(d.Jp().Jt()) != i && (item = this.bTD.getItem(i)) != null) {
            if (item.type == 16 && !this.aBS.Jy()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aOT > this.aBS.IP()) {
                if (item.aOT == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aBS.dv(i);
        }
    }

    private int eT(String str) {
        if (TextUtils.isEmpty(str) || this.bTD == null) {
            return -1;
        }
        for (int i = 0; i <= this.bTD.getCount(); i++) {
            if (this.bTD.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void i(int i, String str) {
        d.Jp().setSwitchStatus(true);
        d.Jp().setSelectId(str);
        if (this.bTD != null && this.bTD.getCount() > 0) {
            this.bTD.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        private ck[] aBU;
        private Map<String, Integer> aBV;
        private int aBW;
        private int from;

        private a() {
        }

        public void a(ck[] ckVarArr, Map<String, Integer> map, int i, int i2) {
            this.aBU = ckVarArr;
            this.aBV = map;
            this.from = i2;
            this.aBW = cq(i);
        }

        public void b(Map<String, Integer> map, int i) {
            this.aBV = map;
            this.aBW = cq(i);
        }

        public void co(int i) {
            this.aBW = cq(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBU != null) {
                return this.aBU.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: cp */
        public ck getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aBU[i];
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
                bVar.aBX = view.findViewById(a.f.layout_container);
                bVar.aBY = view.findViewById(a.f.layout_content);
                bVar.aBZ = (TextView) view.findViewById(a.f.tv_name);
                bVar.aCa = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aCb = view.findViewById(a.f.layout_gift_count);
                bVar.bTF = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aCd = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ck item = getItem(i);
            Drawable background = bVar.aBY.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aOQ) {
                if (item.aOS >= 0 && item.aOS <= 255) {
                    ((f) background).O(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aOS);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.Bx(), item.By());
            } else {
                ((f) background).setColors(item.Bx());
            }
            bVar.aBY.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aCd.setVisibility(0);
                if (item.aOT == 7) {
                    bVar.aCd.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aCd.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aCd.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Jp().Jt());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aBV, this.from, equals)) {
                bVar.aBZ.setVisibility(0);
                if (item.type == 1) {
                    bVar.aBZ.setText(item.price + "T豆/条");
                } else {
                    bVar.aBZ.setText(item.name);
                }
                bVar.aCb.setVisibility(8);
                bVar.aCa.setVisibility(8);
            }
            if (equals) {
                bVar.aBX.setAlpha(1.0f);
            } else {
                bVar.aBX.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aBX.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aBW, -1);
            }
            layoutParams.width = this.aBW;
            ViewGroup.LayoutParams layoutParams2 = bVar.aCb.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aBY.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aBY.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int cq(int i) {
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
            bVar.aBZ.setVisibility(8);
            bVar.aCa.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aCa.setVisibility(0);
            bVar.aCb.setVisibility(0);
            bVar.bTF.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.bTF.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aCa.getLayoutParams();
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
            bVar.aCa.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        View aBX;
        View aBY;
        TextView aBZ;
        ImageView aCa;
        View aCb;
        ImageView aCd;
        ImBarrageItemGiftCountView bTF;

        private b() {
        }
    }
}
