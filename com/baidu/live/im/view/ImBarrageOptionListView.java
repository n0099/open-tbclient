package com.baidu.live.im.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.data.ao;
import com.baidu.live.im.k;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.util.Map;
/* loaded from: classes6.dex */
public class ImBarrageOptionListView extends HListView {
    private int aep;
    private b aiw;
    boolean aix;
    private a aiy;
    private int mDividerWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bu(int i);
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aix = true;
        this.aep = -1;
        init();
    }

    public void setCallback(a aVar) {
        this.aiy = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aix = z;
    }

    public void setData(ao[] aoVarArr, Map<String, Integer> map, int i) {
        if (this.aiw == null) {
            this.aiw = new b();
            this.aiw.a(aoVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aiw);
        } else {
            this.aiw.a(aoVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            this.aiw.notifyDataSetChanged();
        }
        setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aiw != null) {
            this.aiw.bw(UtilHelper.getRealScreenOrientation(getContext()));
            this.aiw.notifyDataSetChanged();
        }
    }

    public void j(Map<String, Integer> map) {
        if (this.aiw != null) {
            this.aiw.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aiw.notifyDataSetChanged();
        }
    }

    public int getSelect() {
        return this.aep;
    }

    public void setSelect(int i) {
        if (this.aep != i) {
            this.aep = i;
            if (this.aiw != null && this.aiw.getCount() > 0) {
                this.aiw.notifyDataSetChanged();
            }
        }
    }

    public ao getSelectInfo() {
        if (this.aiw != null) {
            return this.aiw.getItem(this.aep);
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aix = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (ImBarrageOptionListView.this.aix && ImBarrageOptionListView.this.aep != i) {
                    ImBarrageOptionListView.this.aep = i;
                    k.sN().setSelect(ImBarrageOptionListView.this.aep);
                    if (ImBarrageOptionListView.this.aiw != null) {
                        ImBarrageOptionListView.this.aiw.notifyDataSetChanged();
                    }
                    if (ImBarrageOptionListView.this.aiy != null) {
                        ImBarrageOptionListView.this.aiy.bu(ImBarrageOptionListView.this.aep);
                    }
                }
            }
        });
    }

    /* loaded from: classes6.dex */
    private class b extends BaseAdapter {
        private ao[] aiA;
        private Map<String, Integer> aiB;
        private int aiC;
        private int from;

        private b() {
        }

        public void a(ao[] aoVarArr, Map<String, Integer> map, int i, int i2) {
            this.aiA = aoVarArr;
            this.aiB = map;
            this.from = i2;
            this.aiC = by(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aiB = map;
            this.aiC = by(i);
        }

        public void bw(int i) {
            this.aiC = by(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aiA != null) {
                return this.aiA.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bx */
        public ao getItem(int i) {
            if (i < getCount()) {
                return this.aiA[i];
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @RequiresApi(api = 16)
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_im_barrage_option_item, (ViewGroup) null);
                cVar = new c();
                cVar.aiD = (FrameLayout) view.findViewById(a.g.layout_content);
                cVar.aiE = (FrameLayout) view.findViewById(a.g.layout_normal);
                cVar.textView = (TextView) view.findViewById(a.g.tv);
                cVar.aiF = view.findViewById(a.g.mask);
                cVar.aiG = (ImBarrageItemGiftCountView) view.findViewById(a.g.gift_count);
                cVar.aiH = (ImageView) view.findViewById(a.g.iv_gift);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            ao item = getItem(i);
            Drawable background = view.getBackground();
            if (!(background instanceof GradientDrawable)) {
                background = new GradientDrawable();
                ((GradientDrawable) background).setCornerRadius(viewGroup.getResources().getDimensionPixelOffset(a.e.sdk_ds38));
                ((GradientDrawable) background).setGradientType(0);
                ((GradientDrawable) background).setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
            ((GradientDrawable) background).setColors(item.oB());
            cVar.aiD.setBackground(background);
            boolean z = i == ImBarrageOptionListView.this.aep;
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aiB, this.from, z)) {
                cVar.aiE.setVisibility(0);
                cVar.textView.setText(item.price + "T豆/条");
                cVar.aiG.setVisibility(8);
                cVar.aiH.setVisibility(8);
            }
            cVar.aiF.setVisibility(z ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.aiD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.aiC, -1);
            }
            layoutParams.width = this.aiC;
            return view;
        }

        private int by(int i) {
            switch (i) {
                case 1:
                    int count = getCount();
                    if (count > 0) {
                        return count > 3 ? (int) ((ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * 3)) / 3.2f) : (ImBarrageOptionListView.this.getWidth() - (ImBarrageOptionListView.this.mDividerWidth * (count - 1))) / count;
                    }
                    return 0;
                case 2:
                    return ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(this.from == 1 ? a.e.sdk_ds176 : a.e.sdk_ds212);
                default:
                    return ImBarrageOptionListView.this.getResources().getDimensionPixelOffset(this.from == 1 ? a.e.sdk_ds176 : a.e.sdk_ds212);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, ao aoVar, Map<String, Integer> map, int i, boolean z) {
        int intValue;
        if (map == null || map.size() == 0) {
            return false;
        }
        if (map.containsKey(aoVar.id) && (intValue = map.get(aoVar.id).intValue()) != 0 && aoVar.price == 100) {
            cVar.aiE.setVisibility(8);
            cVar.aiG.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aiG.setTextColor(-16198405);
            cVar.aiG.setVisibility(0);
            cVar.aiH.setImageResource(z ? a.f.sdk_icon_barrage_gift_price_100_selected : a.f.sdk_icon_barrage_gift_price_100_unselected);
            cVar.aiH.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.aiH.getLayoutParams();
            if (i == 0) {
                layoutParams.width = -2;
                layoutParams.height = -1;
                layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds18);
                layoutParams.gravity = 48;
            } else {
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds116);
                layoutParams.height = getResources().getDimensionPixelOffset(a.e.sdk_ds72);
                layoutParams.leftMargin = 0;
                layoutParams.gravity = 80;
            }
            cVar.aiH.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {
        FrameLayout aiD;
        FrameLayout aiE;
        View aiF;
        ImBarrageItemGiftCountView aiG;
        ImageView aiH;
        TextView textView;

        private c() {
        }
    }
}
