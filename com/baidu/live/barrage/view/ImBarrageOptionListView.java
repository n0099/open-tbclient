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
import com.baidu.live.data.ci;
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
    private a aGm;
    boolean aGn;
    private e aGo;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aGn = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aGo = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aGn = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(ci[] ciVarArr, Map<String, Integer> map, int i) {
        if (this.aGm == null) {
            this.aGm = new a();
            this.aGm.a(ciVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aGm);
            return;
        }
        this.aGm.a(ciVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aGm.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aGm != null) {
            this.aGm.dX(UtilHelper.getRealScreenOrientation(getContext()));
            this.aGm.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aGm != null) {
            this.aGm.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aGm.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.NK().NN() != z) {
            d.NK().setSwitchStatus(z);
            if (!z) {
                d.NK().setSelectId(null);
                if (this.aGm != null && this.aGm.getCount() > 0) {
                    this.aGm.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aGm != null && this.aGm.getItem(i) != null) {
            String str = this.aGm.getItem(i).id;
            String NO = d.NK().NO();
            if (TextUtils.isEmpty(NO) || !NO.equals(str)) {
                h(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int gv;
        if (!TextUtils.isEmpty(str) && this.aGm != null && (gv = gv(str)) >= 0) {
            h(gv, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public ci getSelectInfo() {
        if (this.aGm != null) {
            return this.aGm.getItem(gv(d.NK().NO()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aGn = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dW(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(int i) {
        ci item;
        if (this.aGn && this.aGm != null && this.aGo != null && gv(d.NK().NO()) != i && (item = this.aGm.getItem(i)) != null) {
            if (item.type == 16 && !this.aGo.NR()) {
                BdUtilHelper.showToast(getContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aSI > this.aGo.Nm()) {
                if (item.aSI == 7) {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aGo.fd(i);
        }
    }

    private int gv(String str) {
        if (TextUtils.isEmpty(str) || this.aGm == null) {
            return -1;
        }
        for (int i = 0; i <= this.aGm.getCount(); i++) {
            if (this.aGm.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void h(int i, String str) {
        d.NK().setSwitchStatus(true);
        d.NK().setSelectId(str);
        if (this.aGm != null && this.aGm.getCount() > 0) {
            this.aGm.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private ci[] aGq;
        private Map<String, Integer> aGr;
        private int aGs;
        private int from;

        private a() {
        }

        public void a(ci[] ciVarArr, Map<String, Integer> map, int i, int i2) {
            this.aGq = ciVarArr;
            this.aGr = map;
            this.from = i2;
            this.aGs = dZ(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aGr = map;
            this.aGs = dZ(i);
        }

        public void dX(int i) {
            this.aGs = dZ(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aGq != null) {
                return this.aGq.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dY */
        public ci getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aGq[i];
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
                bVar.aGt = view.findViewById(a.f.layout_container);
                bVar.aGu = view.findViewById(a.f.layout_content);
                bVar.aGv = (TextView) view.findViewById(a.f.tv_name);
                bVar.aGw = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aGx = view.findViewById(a.f.layout_gift_count);
                bVar.aGy = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aGz = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            ci item = getItem(i);
            Drawable background = bVar.aGu.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aSF) {
                if (item.aSH >= 0 && item.aSH <= 255) {
                    ((f) background).O(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aSH);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.FZ(), item.Ga());
            } else {
                ((f) background).setColors(item.FZ());
            }
            bVar.aGu.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aGz.setVisibility(0);
                if (item.aSI == 7) {
                    bVar.aGz.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aGz.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aGz.setVisibility(8);
            }
            boolean equals = item.id.equals(d.NK().NO());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aGr, this.from, equals)) {
                bVar.aGv.setVisibility(0);
                if (item.type == 1) {
                    bVar.aGv.setText(item.price + "T豆/条");
                } else {
                    bVar.aGv.setText(item.name);
                }
                bVar.aGx.setVisibility(8);
                bVar.aGw.setVisibility(8);
            }
            if (equals) {
                bVar.aGt.setAlpha(1.0f);
            } else {
                bVar.aGt.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aGt.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aGs, -1);
            }
            layoutParams.width = this.aGs;
            ViewGroup.LayoutParams layoutParams2 = bVar.aGx.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aGu.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aGu.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int dZ(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.d.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, ci ciVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(ciVar.id) && (intValue = map.get(ciVar.id).intValue()) != 0 && ciVar.price == 100) {
            bVar.aGv.setVisibility(8);
            bVar.aGw.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aGw.setVisibility(0);
            bVar.aGx.setVisibility(0);
            bVar.aGy.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aGy.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aGw.getLayoutParams();
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
            bVar.aGw.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        View aGt;
        View aGu;
        TextView aGv;
        ImageView aGw;
        View aGx;
        ImBarrageItemGiftCountView aGy;
        ImageView aGz;

        private b() {
        }
    }
}
