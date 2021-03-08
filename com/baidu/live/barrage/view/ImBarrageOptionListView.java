package com.baidu.live.barrage.view;

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
/* loaded from: classes10.dex */
public class ImBarrageOptionListView extends HListView implements c {
    private a aFd;
    boolean aFe;
    private e aFf;
    private int mDividerWidth;

    public ImBarrageOptionListView(Context context) {
        super(context);
        this.aFe = true;
        init();
    }

    @Override // com.baidu.live.im.b.c
    public void setCallback(e eVar) {
        this.aFf = eVar;
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectEnabled(boolean z) {
        this.aFe = z;
    }

    @Override // com.baidu.live.im.b.c
    public void setData(cr[] crVarArr, Map<String, Integer> map, int i) {
        if (this.aFd == null) {
            this.aFd = new a();
            this.aFd.a(crVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aFd);
            return;
        }
        this.aFd.a(crVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aFd.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aFd != null) {
            this.aFd.cs(UtilHelper.getRealScreenOrientation(getContext()));
            this.aFd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    public void f(Map<String, Integer> map) {
        if (this.aFd != null) {
            this.aFd.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aFd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.live.im.b.c
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.b.c
    public void setSwitchStatus(boolean z) {
        if (d.KQ().KT() != z) {
            d.KQ().setSwitchStatus(z);
            if (!z) {
                d.KQ().setSelectId(null);
                if (this.aFd != null && this.aFd.getCount() > 0) {
                    this.aFd.notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectPos(int i) {
        if (this.aFd != null && this.aFd.getItem(i) != null) {
            String str = this.aFd.getItem(i).id;
            String KU = d.KQ().KU();
            if (TextUtils.isEmpty(KU) || !KU.equals(str)) {
                l(i, str);
            }
        }
    }

    @Override // com.baidu.live.im.b.c
    public void setSelectId(String str) {
        int fs;
        if (!TextUtils.isEmpty(str) && this.aFd != null && (fs = fs(str)) >= 0) {
            l(fs, str);
        }
    }

    @Override // com.baidu.live.im.b.c
    public cr getSelectInfo() {
        if (this.aFd != null) {
            return this.aFd.getItem(fs(d.KQ().KU()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.d.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aFe = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.barrage.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.cr(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(int i) {
        cr item;
        if (this.aFe && this.aFd != null && this.aFf != null && fs(d.KQ().KU()) != i && (item = this.aFd.getItem(i)) != null) {
            if (item.type == 16 && !this.aFf.KZ()) {
                BdUtilHelper.showToast(getContext(), a.h.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aTv > this.aFf.Kq()) {
                if (item.aTv == 7) {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext(), a.h.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aFf.dC(i);
        }
    }

    private int fs(String str) {
        if (TextUtils.isEmpty(str) || this.aFd == null) {
            return -1;
        }
        for (int i = 0; i <= this.aFd.getCount(); i++) {
            if (this.aFd.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void l(int i, String str) {
        d.KQ().setSwitchStatus(true);
        d.KQ().setSelectId(str);
        if (this.aFd != null && this.aFd.getCount() > 0) {
            this.aFd.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        private cr[] aFh;
        private Map<String, Integer> aFi;
        private int aFj;
        private int from;

        private a() {
        }

        public void a(cr[] crVarArr, Map<String, Integer> map, int i, int i2) {
            this.aFh = crVarArr;
            this.aFi = map;
            this.from = i2;
            this.aFj = cu(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aFi = map;
            this.aFj = cu(i);
        }

        public void cs(int i) {
            this.aFj = cu(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aFh != null) {
                return this.aFh.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: ct */
        public cr getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aFh[i];
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
                bVar.aFk = view.findViewById(a.f.layout_container);
                bVar.aFl = view.findViewById(a.f.layout_content);
                bVar.aFm = (TextView) view.findViewById(a.f.tv_name);
                bVar.aFn = (ImageView) view.findViewById(a.f.iv_gift);
                bVar.aFo = view.findViewById(a.f.layout_gift_count);
                bVar.aFp = (ImBarrageItemGiftCountView) view.findViewById(a.f.tv_gift_count);
                bVar.aFq = (ImageView) view.findViewById(a.f.barrage_prime);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            cr item = getItem(i);
            Drawable background = bVar.aFl.getBackground();
            if (!(background instanceof f)) {
                background = new f();
                ((f) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.d.sdk_ds16));
            }
            if (item.aTs) {
                if (item.aTu >= 0 && item.aTu <= 255) {
                    ((f) background).O(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2), item.aTu);
                } else {
                    ((f) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.d.sdk_ds2));
                }
                ((f) background).f(item.CP(), item.CQ());
            } else {
                ((f) background).setColors(item.CP());
            }
            bVar.aFl.setBackgroundDrawable(background);
            if (item.type == 17) {
                bVar.aFq.setVisibility(0);
                if (item.aTv == 7) {
                    bVar.aFq.setImageResource(a.e.icon_live_im_barrage_noble_prime_big);
                } else {
                    bVar.aFq.setImageResource(a.e.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                bVar.aFq.setVisibility(8);
            }
            boolean equals = item.id.equals(d.KQ().KU());
            if (!ImBarrageOptionListView.this.a(bVar, item, this.aFi, this.from, equals)) {
                bVar.aFm.setVisibility(0);
                if (item.type == 1) {
                    bVar.aFm.setText(item.price + "T豆/条");
                } else {
                    bVar.aFm.setText(item.name);
                }
                bVar.aFo.setVisibility(8);
                bVar.aFn.setVisibility(8);
            }
            if (equals) {
                bVar.aFk.setAlpha(1.0f);
            } else {
                bVar.aFk.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = bVar.aFk.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aFj, -1);
            }
            layoutParams.width = this.aFj;
            ViewGroup.LayoutParams layoutParams2 = bVar.aFo.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                bVar.aFl.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                bVar.aFl.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.d.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.f.iv_gift);
                }
            }
            return view;
        }

        private int cu(int i) {
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
            bVar.aFm.setVisibility(8);
            bVar.aFn.setImageResource(z ? a.e.icon_barrage_gift_price_100_selected : a.e.icon_barrage_gift_price_100_unselected);
            bVar.aFn.setVisibility(0);
            bVar.aFo.setVisibility(0);
            bVar.aFp.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            bVar.aFp.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.aFn.getLayoutParams();
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
            bVar.aFn.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        View aFk;
        View aFl;
        TextView aFm;
        ImageView aFn;
        View aFo;
        ImBarrageItemGiftCountView aFp;
        ImageView aFq;

        private b() {
        }
    }
}
