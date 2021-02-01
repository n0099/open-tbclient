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
import com.baidu.live.data.cr;
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
    boolean aDE;
    private e aDF;
    private a bXC;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aDE = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aDF = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aDE = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(cr[] crVarArr, Map<String, Integer> map, int i) {
        if (this.bXC == null) {
            this.bXC = new a();
            this.bXC.a(crVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.bXC);
            return;
        }
        this.bXC.a(crVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.bXC.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.bXC != null) {
            this.bXC.cr(UtilHelper.getRealScreenOrientation(getContext()));
            this.bXC.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.bXC != null) {
            this.bXC.b(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.bXC.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.KN().KQ() != z) {
            d.KN().setSwitchStatus(z);
            if (!z) {
                d.KN().setSelectId(null);
                if (this.bXC != null && this.bXC.getCount() > 0) {
                    this.bXC.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.bXC != null && this.bXC.getItem(i) != null) {
            String str = this.bXC.getItem(i).id;
            String KR = d.KN().KR();
            if (TextUtils.isEmpty(KR) || !KR.equals(str)) {
                l(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fm;
        if (!TextUtils.isEmpty(str) && this.bXC != null && (fm = fm(str)) >= 0) {
            l(fm, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public cr getSelectInfo() {
        if (this.bXC != null) {
            return this.bXC.getItem(fm(d.KN().KR()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aDE = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinbarrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.cq(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(int i) {
        cr item;
        if (this.aDE && this.bXC != null && this.aDF != null && fm(d.KN().KR()) != i && (item = this.bXC.getItem(i)) != null) {
            if (item.type == 16 && !this.aDF.KW()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aRV > this.aDF.Kn()) {
                if (item.aRV == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aDF.dB(i);
        }
    }

    private int fm(String str) {
        if (TextUtils.isEmpty(str) || this.bXC == null) {
            return -1;
        }
        for (int i = 0; i <= this.bXC.getCount(); i++) {
            if (this.bXC.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void l(int i, String str) {
        d.KN().setSwitchStatus(true);
        d.KN().setSelectId(str);
        if (this.bXC != null && this.bXC.getCount() > 0) {
            this.bXC.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BaseAdapter {
        private cr[] aDH;
        private Map<String, Integer> aDI;
        private int aDJ;
        private int from;

        private a() {
        }

        public void a(cr[] crVarArr, Map<String, Integer> map, int i, int i2) {
            this.aDH = crVarArr;
            this.aDI = map;
            this.from = i2;
            this.aDJ = ct(i);
        }

        public void b(Map<String, Integer> map, int i) {
            this.aDI = map;
            this.aDJ = ct(i);
        }

        public void cr(int i) {
            this.aDJ = ct(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aDH != null) {
                return this.aDH.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: cs */
        public cr getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aDH[i];
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
                bVar.aDK = view.findViewById(a.f.layout_container);
                bVar.aDL = view.findViewById(a.f.layout_content);
                bVar.aDM = (TextView) view.findViewById(a.f.tv_name);
                bVar.aDN = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aDO = view.findViewById(a.f.layout_gift_count);
                bVar.bXE = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aDQ = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            cr item = getItem(i);
            Drawable background = bVar.aDL.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aRS) {
                if (item.aRU >= 0 && item.aRU <= 255) {
                    ((f) background).O(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aRU);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.CM(), item.CN());
            } else {
                ((f) background).setColors(item.CM());
            }
            bVar.aDL.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aDQ.setVisibility(0);
                if (item.aRV == 7) {
                    bVar.aDQ.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aDQ.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aDQ.setVisibility(8);
            }
            boolean equals = item.id.equals(d.KN().KR());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aDI, this.from, equals)) {
                bVar.aDM.setVisibility(0);
                if (item.type == 1) {
                    bVar.aDM.setText(item.price + "T豆/条");
                } else {
                    bVar.aDM.setText(item.name);
                }
                bVar.aDO.setVisibility(8);
                bVar.aDN.setVisibility(8);
            }
            if (equals) {
                bVar.aDK.setAlpha(1.0f);
            } else {
                bVar.aDK.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aDK.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aDJ, -1);
            }
            layoutParams.width = this.aDJ;
            ViewGroup.LayoutParams layoutParams2 = bVar.aDO.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aDL.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aDL.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int ct(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.d.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, cr crVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(crVar.id) && (intValue = map.get(crVar.id).intValue()) != 0 && crVar.price == 100) {
            bVar.aDM.setVisibility(8);
            bVar.aDN.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aDN.setVisibility(0);
            bVar.aDO.setVisibility(0);
            bVar.bXE.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.bXE.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aDN.getLayoutParams();
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
            bVar.aDN.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        View aDK;
        View aDL;
        TextView aDM;
        ImageView aDN;
        View aDO;
        ImageView aDQ;
        ImBarrageItemGiftCountView bXE;

        private b() {
        }
    }
}
