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
    private a aBo;
    boolean aBp;
    private e aBq;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aBp = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aBq = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aBp = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(bz[] bzVarArr, Map<String, Integer> map, int i) {
        if (this.aBo == null) {
            this.aBo = new a();
            this.aBo.a(bzVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aBo);
            return;
        }
        this.aBo.a(bzVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aBo.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aBo != null) {
            this.aBo.dD(UtilHelper.getRealScreenOrientation(getContext()));
            this.aBo.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aBo != null) {
            this.aBo.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aBo.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.Kh().Kj() != z) {
            d.Kh().setSwitchStatus(z);
            if (!z) {
                d.Kh().setSelectId(null);
                if (this.aBo != null && this.aBo.getCount() > 0) {
                    this.aBo.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aBo != null && this.aBo.getItem(i) != null) {
            String str = this.aBo.getItem(i).id;
            String Kk = d.Kh().Kk();
            if (TextUtils.isEmpty(Kk) || !Kk.equals(str)) {
                f(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fL;
        if (!TextUtils.isEmpty(str) && this.aBo != null && (fL = fL(str)) >= 0) {
            f(fL, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public bz getSelectInfo() {
        if (this.aBo != null) {
            return this.aBo.getItem(fL(d.Kh().Kk()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aBp = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.dC(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(int i) {
        bz item;
        if (this.aBp && this.aBo != null && this.aBq != null && fL(d.Kh().Kk()) != i && (item = this.aBo.getItem(i)) != null) {
            if (item.type == 16 && !this.aBq.Kn()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aMA > this.aBq.JR()) {
                if (item.aMA == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aBq.ec(i);
        }
    }

    private int fL(String str) {
        if (TextUtils.isEmpty(str) || this.aBo == null) {
            return -1;
        }
        for (int i = 0; i <= this.aBo.getCount(); i++) {
            if (this.aBo.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void f(int i, String str) {
        d.Kh().setSwitchStatus(true);
        d.Kh().setSelectId(str);
        if (this.aBo != null && this.aBo.getCount() > 0) {
            this.aBo.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BaseAdapter {
        private bz[] aBs;
        private Map<String, Integer> aBt;
        private int aBu;
        private int from;

        private a() {
        }

        public void a(bz[] bzVarArr, Map<String, Integer> map, int i, int i2) {
            this.aBs = bzVarArr;
            this.aBt = map;
            this.from = i2;
            this.aBu = dF(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aBt = map;
            this.aBu = dF(i);
        }

        public void dD(int i) {
            this.aBu = dF(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aBs != null) {
                return this.aBs.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: dE */
        public bz getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aBs[i];
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
                bVar.aBv = view.findViewById(a.g.layout_container);
                bVar.aBw = view.findViewById(a.g.layout_content);
                bVar.aBx = (TextView) view.findViewById(a.g.tv_name);
                bVar.aBy = (ImageView) view.findViewById(a.g.iv_gift);
                bVar.aBz = view.findViewById(a.g.layout_gift_count);
                bVar.aBA = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                bVar.aBB = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bz item = getItem(i);
            Drawable background = bVar.aBw.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aMx) {
                if (item.aMz >= 0 && item.aMz <= 255) {
                    ((g) background).P(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aMz);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.Dq(), item.Dr());
            } else {
                ((g) background).setColors(item.Dq());
            }
            bVar.aBw.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aBB.setVisibility(0);
                if (item.aMA == 7) {
                    bVar.aBB.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aBB.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aBB.setVisibility(8);
            }
            boolean equals = item.id.equals(d.Kh().Kk());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aBt, this.from, equals)) {
                bVar.aBx.setVisibility(0);
                if (item.type == 1) {
                    bVar.aBx.setText(item.price + "T豆/条");
                } else {
                    bVar.aBx.setText(item.name);
                }
                bVar.aBz.setVisibility(8);
                bVar.aBy.setVisibility(8);
            }
            if (equals) {
                bVar.aBv.setAlpha(1.0f);
            } else {
                bVar.aBv.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aBv.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aBu, -1);
            }
            layoutParams.width = this.aBu;
            ViewGroup.LayoutParams layoutParams2 = bVar.aBz.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aBw.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aBw.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int dF(int i) {
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
            bVar.aBx.setVisibility(8);
            bVar.aBy.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            bVar.aBy.setVisibility(0);
            bVar.aBz.setVisibility(0);
            bVar.aBA.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aBA.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aBy.getLayoutParams();
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
            bVar.aBy.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {
        ImBarrageItemGiftCountView aBA;
        ImageView aBB;
        View aBv;
        View aBw;
        TextView aBx;
        ImageView aBy;
        View aBz;

        private b() {
        }
    }
}
