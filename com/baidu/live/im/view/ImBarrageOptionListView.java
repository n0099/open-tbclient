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
    private int aeH;
    private b aiO;
    boolean aiP;
    private a aiQ;
    private int mDividerWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bu(int i);
    }

    public ImBarrageOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiP = true;
        this.aeH = -1;
        init();
    }

    public void setCallback(a aVar) {
        this.aiQ = aVar;
    }

    public void setSelectEnabled(boolean z) {
        this.aiP = z;
    }

    public void setData(ao[] aoVarArr, Map<String, Integer> map, int i) {
        if (this.aiO == null) {
            this.aiO = new b();
            this.aiO.a(aoVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            setAdapter((ListAdapter) this.aiO);
        } else {
            this.aiO.a(aoVarArr, map, UtilHelper.getRealScreenOrientation(getContext()), i);
            this.aiO.notifyDataSetChanged();
        }
        setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.aiO != null) {
            this.aiO.bw(UtilHelper.getRealScreenOrientation(getContext()));
            this.aiO.notifyDataSetChanged();
        }
    }

    public void j(Map<String, Integer> map) {
        if (this.aiO != null) {
            this.aiO.a(map, UtilHelper.getRealScreenOrientation(getContext()));
            this.aiO.notifyDataSetChanged();
        }
    }

    public int getSelect() {
        return this.aeH;
    }

    public void setSelect(int i) {
        if (this.aeH != i) {
            this.aeH = i;
            if (this.aiO != null && this.aiO.getCount() > 0) {
                this.aiO.notifyDataSetChanged();
            }
        }
    }

    public ao getSelectInfo() {
        if (this.aiO != null) {
            return this.aiO.getItem(this.aeH);
        }
        return null;
    }

    private void init() {
        setBackgroundColor(0);
        setDivider(new ColorDrawable(0));
        this.mDividerWidth = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        setDividerWidth(this.mDividerWidth);
        setSelector(new ColorDrawable(0));
        this.aiP = true;
        setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.im.view.ImBarrageOptionListView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (ImBarrageOptionListView.this.aiP && ImBarrageOptionListView.this.aeH != i) {
                    ImBarrageOptionListView.this.aeH = i;
                    k.sM().setSelect(ImBarrageOptionListView.this.aeH);
                    if (ImBarrageOptionListView.this.aiO != null) {
                        ImBarrageOptionListView.this.aiO.notifyDataSetChanged();
                    }
                    if (ImBarrageOptionListView.this.aiQ != null) {
                        ImBarrageOptionListView.this.aiQ.bu(ImBarrageOptionListView.this.aeH);
                    }
                }
            }
        });
    }

    /* loaded from: classes6.dex */
    private class b extends BaseAdapter {
        private ao[] aiS;
        private Map<String, Integer> aiT;
        private int aiU;
        private int from;

        private b() {
        }

        public void a(ao[] aoVarArr, Map<String, Integer> map, int i, int i2) {
            this.aiS = aoVarArr;
            this.aiT = map;
            this.from = i2;
            this.aiU = by(i);
        }

        public void a(Map<String, Integer> map, int i) {
            this.aiT = map;
            this.aiU = by(i);
        }

        public void bw(int i) {
            this.aiU = by(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.aiS != null) {
                return this.aiS.length;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: bx */
        public ao getItem(int i) {
            if (i < getCount()) {
                return this.aiS[i];
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
                cVar.aiV = (FrameLayout) view.findViewById(a.g.layout_content);
                cVar.aiW = (FrameLayout) view.findViewById(a.g.layout_normal);
                cVar.textView = (TextView) view.findViewById(a.g.tv);
                cVar.aiX = view.findViewById(a.g.mask);
                cVar.aiY = (ImBarrageItemGiftCountView) view.findViewById(a.g.gift_count);
                cVar.aiZ = (ImageView) view.findViewById(a.g.iv_gift);
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
            cVar.aiV.setBackground(background);
            boolean z = i == ImBarrageOptionListView.this.aeH;
            if (!ImBarrageOptionListView.this.a(cVar, item, this.aiT, this.from, z)) {
                cVar.aiW.setVisibility(0);
                cVar.textView.setText(item.price + "T豆/条");
                cVar.aiY.setVisibility(8);
                cVar.aiZ.setVisibility(8);
            }
            cVar.aiX.setVisibility(z ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = cVar.aiV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.aiU, -1);
            }
            layoutParams.width = this.aiU;
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
            cVar.aiW.setVisibility(8);
            cVar.aiY.setText(intValue > 999 ? "999+" : String.valueOf(intValue));
            cVar.aiY.setTextColor(-16198405);
            cVar.aiY.setVisibility(0);
            cVar.aiZ.setImageResource(z ? a.f.sdk_icon_barrage_gift_price_100_selected : a.f.sdk_icon_barrage_gift_price_100_unselected);
            cVar.aiZ.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.aiZ.getLayoutParams();
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
            cVar.aiZ.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {
        FrameLayout aiV;
        FrameLayout aiW;
        View aiX;
        ImBarrageItemGiftCountView aiY;
        ImageView aiZ;
        TextView textView;

        private c() {
        }
    }
}
