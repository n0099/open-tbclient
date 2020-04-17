package com.baidu.live.im.view.barrage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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
import com.baidu.live.data.be;
import com.baidu.live.im.m;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import java.util.Map;
/* loaded from: classes3.dex */
public class ImBarrageOptionListView extends HListView {
    private b aOU;
    boolean aOV;
    private a aOW;
    private int mDividerWidth;

    /* loaded from: classes3.dex */
    public interface a {
        boolean Ce();

        void bO(int i);
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOV = true;
        init();
    }

    public void setCallback(a aVar) {
        this.aOW = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aOV = z;
    }

    public void setData(be[] beVarArr, Map<String, Integer> map, int i) {
        if (this.aOU == null) {
            this.aOU = new b();
            this.aOU.a(beVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aOU);
            return;
        }
        this.aOU.a(beVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
        this.aOU.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aOU != null) {
            this.aOU.cl(UtilHelper.getRealScreenOrientation(getContext()));
            this.aOU.notifyDataSetChanged();
        }
    }

    public void f(Map<String, Integer> map) {
        if (this.aOU != null) {
            this.aOU.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aOU.notifyDataSetChanged();
        }
    }

    public void setSwitchStatus(boolean z) {
        if (m.Bp().Br() != z) {
            m.Bp().setSwitchStatus(z);
            if (!z) {
                m.Bp().setSelectId(null);
                if (this.aOU != null && this.aOU.getCount() > 0) {
                    this.aOU.notifyDataSetChanged();
                }
            }
        }
    }

    public void setSelectPos(int i) {
        if (this.aOU != null && this.aOU.getItem(i) != null) {
            String str = this.aOU.getItem(i).id;
            String Bs = m.Bp().Bs();
            if (TextUtils.isEmpty(Bs) || !Bs.equals(str)) {
                n(i, str);
            }
        }
    }

    public void setSelectId(String str) {
        int eJ;
        if (!TextUtils.isEmpty(str) && this.aOU != null && (eJ = eJ(str)) >= 0) {
            n(eJ, str);
        }
    }

    public be getSelectInfo() {
        if (this.aOU != null) {
            return this.aOU.getItem(eJ(m.Bp().Bs()));
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aOV = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.barrage.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                ImBarrageOptionListView.this.co(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(int i) {
        be item;
        if (this.aOV && this.aOU != null && this.aOW != null && eJ(m.Bp().Bs()) != i && (item = this.aOU.getItem(i)) != null) {
            if (item.type == 16 && !this.aOW.Ce()) {
                BdUtilHelper.showToast(getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
            }
            setSelectPos(i);
            this.aOW.bO(i);
        }
    }

    private int eJ(String str) {
        if (TextUtils.isEmpty(str) || this.aOU == null) {
            return -1;
        }
        for (int i = 0; i <= this.aOU.getCount(); i++) {
            if (this.aOU.getItem(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void n(int i, String str) {
        m.Bp().setSwitchStatus(true);
        m.Bp().setSelectId(str);
        if (this.aOU != null && this.aOU.getCount() > 0) {
            this.aOU.notifyDataSetChanged();
        }
        setSelection(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        private be[] aOY;
        private Map<String, Integer> aOZ;
        private int aPa;
        private int from;

        private b() {
        }

        public void a(be[] beVarArr, Map<String, Integer> map, int i, int i2) {
            this.aOY = beVarArr;
            this.aOZ = map;
            this.from = i2;
            this.aPa = cq(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aOZ = map;
            this.aPa = cq(i);
        }

        public void cl(int i) {
            this.aPa = cq(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aOY != null) {
                return this.aOY.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: cp */
        public be getItem(int i) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.aOY[i];
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
                cVar.aPb = view.findViewById(a.g.layout_container);
                cVar.aPc = view.findViewById(a.g.layout_content);
                cVar.aPd = (TextView) view.findViewById(a.g.tv_name);
                cVar.aPe = view.findViewById(a.g.mask);
                cVar.aPf = (ImageView) view.findViewById(a.g.iv_gift);
                cVar.aPg = view.findViewById(a.g.layout_gift_count);
                cVar.aPh = (ImBarrageItemGiftCountView) view.findViewById(a.g.tv_gift_count);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            be item = getItem(i);
            Drawable background = cVar.aPc.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                if (Build.VERSION.SDK_INT >= 16) {
                    ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                ((GradientDrawable) background).setColors(item.vi());
            } else {
                ((GradientDrawable) background).setColor(item.vi()[0]);
            }
            cVar.aPc.setBackgroundDrawable(background);
            boolean equals = item.id.equals(m.Bp().Bs());
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aOZ, this.from, equals)) {
                cVar.aPd.setVisibility(0);
                if (item.type == 1) {
                    cVar.aPd.setText(item.price + "T豆/条");
                } else {
                    cVar.aPd.setText(item.name);
                }
                cVar.aPg.setVisibility(8);
                cVar.aPf.setVisibility(8);
            }
            cVar.aPe.setVisibility(equals ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.aPb.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.aPa, -1);
            }
            layoutParams.width = this.aPa;
            ViewGroup.LayoutParams layoutParams2 = cVar.aPg.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (layoutParams.width > 0) {
                cVar.aPc.setPadding(0, 0, 0, 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11);
                }
            } else {
                cVar.aPc.setPadding(ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0, ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(a.e.sdk_ds20), 0);
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(11, 0);
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(1, a.g.iv_gift);
                }
            }
            return view;
        }

        private int cq(int i) {
            int count;
            if (i == 1 && (count = getCount()) <= 3) {
                return (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
            }
            return -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, be beVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(beVar.id) && (intValue = map.get(beVar.id).intValue()) != 0 && beVar.price == 100) {
            cVar.aPd.setVisibility(8);
            cVar.aPf.setImageResource(z ? a.f.icon_barrage_gift_price_100_selected : a.f.icon_barrage_gift_price_100_unselected);
            cVar.aPf.setVisibility(0);
            cVar.aPg.setVisibility(0);
            cVar.aPh.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aPh.setTextColor(-16198405);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cVar.aPf.getLayoutParams();
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
            cVar.aPf.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        View aPb;
        View aPc;
        TextView aPd;
        View aPe;
        ImageView aPf;
        View aPg;
        ImBarrageItemGiftCountView aPh;

        private c() {
        }
    }
}
