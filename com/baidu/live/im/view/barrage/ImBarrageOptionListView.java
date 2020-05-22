package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.im.m;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.live.view.g;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImBarrageOptionListView extends HListView {
    private b aVj;
    boolean aVk;
    private a aVl;
    private int mDividerWidth;

    /* loaded from: classes3.dex */
    public interface a {
        int CH();

        boolean DA();

        void bV(int i);
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aVk = true;
        init();
    }

    public void setCallback(a aVar) {
        this.aVl = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aVk = z;
    }

    public void setData(bj[] bjVarArr, Map<String, Integer> map, int i) {
        if (this.aVj == null) {
            this.aVj = new b();
            this.aVj.a(bjVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aVj);
            return;
        }
        this.aVj.a(bjVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aVj.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aVj != null) {
            this.aVj.cs(UtilHelper.getRealScreenOrientation(getContext()));
            this.aVj.notifyDataSetChanged();
        }
    }

    public void g(Map<String, Integer> map) {
        if (this.aVj != null) {
            this.aVj.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aVj.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (m.CL().CN() != z) {
            m.CL().setSwitchStatus(z);
            if (!z) {
                m.CL().setSelectId(null);
                if (this.aVj != null && this.aVj.getCount() > 0) {
                    this.aVj.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.aVj != null && this.aVj.getItem(i) != null) {
            String str = this.aVj.getItem(i).id;
            String CO = m.CL().CO();
            if (TextUtils.isEmpty(CO) || !CO.equals(str)) {
                n(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int fv;
        if (!TextUtils.isEmpty(str) && this.aVj != null && (fv = fv(str)) >= 0) {
            n(fv, str);
        }
    }

    public bj getSelectInfo() {
        if (this.aVj != null) {
            return this.aVj.getItem(fv(m.CL().CO()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds4);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aVk = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.barrage.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.cv(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(int i) {
        bj item;
        if (this.aVk && this.aVj != null && this.aVl != null && fv(m.CL().CO()) != i && (item = this.aVj.getItem(i)) != null) {
            if (item.type == 16 && !this.aVl.DA()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            if (item.type == 17 && item.aCc > this.aVl.CH()) {
                if (item.aCc == 7) {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                } else {
                    BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                }
            }
            setSelectPos(i);
            this.aVl.bV(i);
        }
    }

    private int fv(String str) {
        if (TextUtils.isEmpty(str) || this.aVj == null) {
            return -1;
        }
        for (int i = 0; i <= this.aVj.getCount(); i++) {
            if (this.aVj.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void n(int i, String str) {
        m.CL().setSwitchStatus(true);
        m.CL().setSelectId(str);
        if (this.aVj != null && this.aVj.getCount() > 0) {
            this.aVj.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private bj[] aVn;
        private Map<String, Integer> aVo;
        private int aVp;
        private int from;

        private b() {
        }

        public void a(bj[] bjVarArr, Map<String, Integer> map, int i, int i2) {
            this.aVn = bjVarArr;
            this.aVo = map;
            this.from = i2;
            this.aVp = cx(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aVo = map;
            this.aVp = cx(i);
        }

        public void cs(int i) {
            this.aVp = cx(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aVn != null) {
                return this.aVn.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: cw */
        public bj getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aVn[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_im_barrage_option_item, (ViewGroup) null);
                cVar = new c();
                cVar.aVq = view.findViewById(a.g.layout_container);
                cVar.aVr = view.findViewById(a.g.layout_content);
                cVar.aVs = (TextView) view.findViewById(a.g.tv_name);
                cVar.aVt = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.aVu = view.findViewById(a.g.layout_gift_count);
                cVar.aVv = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                cVar.aVw = (ImageView) view.findViewById(a.g.barrage_prime);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            bj item = getItem(i);
            Drawable background = cVar.aVr.getBackground();
            if (!(background instanceof g)) {
                background = new g();
                ((g) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds16));
            }
            if (item.aBZ) {
                if (item.aCb >= 0 && item.aCb <= 255) {
                    ((g) background).J(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2), item.aCb);
                } else {
                    ((g) background).setStrokeWidth(ImBarrageOptionListView.this.getResources().getDimensionPixelSize(a.e.sdk_ds2));
                }
                ((g) background).f(item.ww(), item.wx());
            } else {
                ((g) background).setColors(item.ww());
            }
            cVar.aVr.setBackgroundDrawable(background);
            if (item.type == 17) {
                cVar.aVw.setVisibility(0);
                if (item.aCc == 7) {
                    cVar.aVw.setImageResource(a.f.icon_live_im_barrage_noble_prime_big);
                } else {
                    cVar.aVw.setImageResource(a.f.icon_live_im_barrage_noble_prime_small);
                }
            } else {
                cVar.aVw.setVisibility(8);
            }
            boolean equals = item.id.equals(m.CL().CO());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aVo, this.from, equals)) {
                cVar.aVs.setVisibility(0);
                if (item.type == 1) {
                    cVar.aVs.setText(item.price + "T豆/条");
                } else {
                    cVar.aVs.setText(item.name);
                }
                cVar.aVu.setVisibility(8);
                cVar.aVt.setVisibility(8);
            }
            if (equals) {
                cVar.aVq.setAlpha(1.0f);
            } else {
                cVar.aVq.setAlpha(0.3f);
            }
            ViewGroup.LayoutParams layoutParams = cVar.aVq.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aVp, -1);
            }
            layoutParams.width = this.aVp;
            ViewGroup.LayoutParams layoutParams2 = cVar.aVu.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.aVr.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.aVr.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int cx(int i) {
            int count;
            int dimens = BdUtilHelper.getDimens(ImBarrageOptionListView.this.getContext(), a.e.sdk_ds220);
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return dimens;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, bj bjVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(bjVar.id) && (intValue = map.get(bjVar.id).intValue()) != 0 && bjVar.price == 100) {
            cVar.aVs.setVisibility(8);
            cVar.aVt.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            cVar.aVt.setVisibility(0);
            cVar.aVu.setVisibility(0);
            cVar.aVv.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aVv.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.aVt.getLayoutParams();
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
            cVar.aVt.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        View aVq;
        View aVr;
        TextView aVs;
        ImageView aVt;
        View aVu;
        ImBarrageItemGiftCountView aVv;
        ImageView aVw;

        private c() {
        }
    }
}
