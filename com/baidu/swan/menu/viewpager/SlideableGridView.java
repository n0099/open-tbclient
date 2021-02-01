package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.swan.menu.f;
/* loaded from: classes5.dex */
public class SlideableGridView extends LinearLayout {
    private ViewPager Ze;
    protected PointPageIndicator etA;
    protected int[] etB;
    private a etj;
    b etw;
    private int etx;
    private int ety;
    private int etz;
    private int mTopPadding;

    /* loaded from: classes5.dex */
    public static abstract class a {
        private SlideableGridView etC;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lO(int i);

        void f(SlideableGridView slideableGridView) {
            this.etC = slideableGridView;
        }

        public int lP(int i) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 < getPageCount()) {
                    i2 = lO(i3) + i4;
                    i3++;
                } else {
                    if (i4 < 5) {
                    }
                    return 5;
                }
            }
        }
    }

    public a getGridItemAdapter() {
        return this.etj;
    }

    public void setGridItemAdapter(a aVar) {
        this.etj = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.etw == null) {
                this.etw = new b(getContext());
                this.Ze.setAdapter(this.etw);
            } else {
                this.etw.notifyDataSetChanged();
            }
            this.etA.lL(aVar.getPageCount());
        } else if (this.etw != null) {
            this.etw.notifyDataSetChanged();
        }
        bbT();
    }

    public SlideableGridView(Context context) {
        this(context, null);
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ze = null;
        this.etA = null;
        this.etB = new int[2];
        init(context);
    }

    protected ViewPager eF(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        eH(context);
        eG(context);
    }

    protected void eG(Context context) {
        this.etA = new PointPageIndicator(context).az(f.c.aiapp_menu_slide_indicator_normal, f.c.aiapp_menu_slide_indicator_selected).lM((int) getResources().getDimension(f.b.common_grid_indicator_margin));
        this.etB[0] = (int) getResources().getDimension(f.b.common_grid_indicator_height);
        this.etB[1] = (int) getResources().getDimension(f.b.common_grid_indicator_height2);
        addView(this.etA, bbS());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(Context context) {
        this.Ze = eF(context);
        this.Ze.setOffscreenPageLimit(0);
        this.Ze.setOnPageChangeListener(new c());
        this.Ze.setOverScrollMode(2);
        addView(this.Ze, bbP());
    }

    public PointPageIndicator getPageindicator() {
        return this.etA;
    }

    protected int bbN() {
        return -2;
    }

    protected int bbO() {
        return -1;
    }

    protected LinearLayout.LayoutParams bbP() {
        return new LinearLayout.LayoutParams(bbO(), bbN());
    }

    protected int bbQ() {
        return -1;
    }

    protected int bbR() {
        return (int) getResources().getDimension(f.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams bbS() {
        return new LinearLayout.LayoutParams(bbQ(), bbR());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.etB[0] = i;
        this.etB[1] = i2;
        requestLayout();
    }

    protected void bbT() {
        int pageCount = this.etj == null ? 0 : this.etj.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.etB[0] : this.etB[1];
        this.etA.lL(pageCount);
        this.etA.setVisibility(z ? 0 : 4);
        this.etA.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.etA.lN(i);
        }
    }

    /* loaded from: classes5.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.etj != null) {
                return SlideableGridView.this.etj.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View j(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.etj);
            gridPageView.setPadding(SlideableGridView.this.etx, SlideableGridView.this.mTopPadding, SlideableGridView.this.ety, SlideableGridView.this.etz);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void k(View view, int i) {
            ((GridPageView) view).ay(SlideableGridView.this.etj.lP(i), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.etA != null) {
            this.etA.az(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.Ze != null && this.etA != null) {
            this.Ze.setCurrentItem(i);
            this.etA.lN(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.etx = i;
        this.ety = i3;
        this.mTopPadding = i2;
        this.etz = i4;
    }
}
