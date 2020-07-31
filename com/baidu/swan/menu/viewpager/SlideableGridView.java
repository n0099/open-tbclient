package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class SlideableGridView extends LinearLayout {
    b duK;
    protected PointPageIndicator duL;
    protected int[] duM;
    private a duz;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes9.dex */
    public static abstract class a {
        private SlideableGridView duN;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int jD(int i);

        void f(SlideableGridView slideableGridView) {
            this.duN = slideableGridView;
        }

        public int jE(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += jD(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.duz;
    }

    public void setGridItemAdapter(a aVar) {
        this.duz = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.duK == null) {
                this.duK = new b(getContext());
                this.mViewPager.setAdapter(this.duK);
            } else {
                this.duK.notifyDataSetChanged();
            }
            this.duL.jA(aVar.getPageCount());
        } else if (this.duK != null) {
            this.duK.notifyDataSetChanged();
        }
        aKf();
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
        this.mViewPager = null;
        this.duL = null;
        this.duM = new int[2];
        init(context);
    }

    protected ViewPager dx(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dz(context);
        dy(context);
    }

    protected void dy(Context context) {
        this.duL = new PointPageIndicator(context).aw(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).jB((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.duM[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.duM[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.duL, aKe());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dz(Context context) {
        this.mViewPager = dx(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aKb());
    }

    public PointPageIndicator getPageindicator() {
        return this.duL;
    }

    protected int aJZ() {
        return -2;
    }

    protected int aKa() {
        return -1;
    }

    protected LinearLayout.LayoutParams aKb() {
        return new LinearLayout.LayoutParams(aKa(), aJZ());
    }

    protected int aKc() {
        return -1;
    }

    protected int aKd() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aKe() {
        return new LinearLayout.LayoutParams(aKc(), aKd());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.duM[0] = i;
        this.duM[1] = i2;
        requestLayout();
    }

    protected void aKf() {
        int pageCount = this.duz == null ? 0 : this.duz.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.duM[0] : this.duM[1];
        this.duL.jA(pageCount);
        this.duL.setVisibility(z ? 0 : 4);
        this.duL.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.duL.jC(i);
        }
    }

    /* loaded from: classes9.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.duz != null) {
                return SlideableGridView.this.duz.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.duz);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).av(SlideableGridView.this.duz.jE(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.duL != null) {
            this.duL.aw(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.duL != null) {
            this.mViewPager.setCurrentItem(i);
            this.duL.jC(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
