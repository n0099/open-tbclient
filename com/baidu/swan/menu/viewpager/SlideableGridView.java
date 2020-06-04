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
/* loaded from: classes11.dex */
public class SlideableGridView extends LinearLayout {
    private a djX;
    b dki;
    protected PointPageIndicator dkj;
    protected int[] dkk;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView dkl;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int jb(int i);

        void f(SlideableGridView slideableGridView) {
            this.dkl = slideableGridView;
        }

        public int jc(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += jb(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.djX;
    }

    public void setGridItemAdapter(a aVar) {
        this.djX = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.dki == null) {
                this.dki = new b(getContext());
                this.mViewPager.setAdapter(this.dki);
            } else {
                this.dki.notifyDataSetChanged();
            }
            this.dkj.iY(aVar.getPageCount());
        } else if (this.dki != null) {
            this.dki.notifyDataSetChanged();
        }
        aFi();
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
        this.dkj = null;
        this.dkk = new int[2];
        init(context);
    }

    protected ViewPager ds(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        du(context);
        dt(context);
    }

    protected void dt(Context context) {
        this.dkj = new PointPageIndicator(context).au(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).iZ((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.dkk[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.dkk[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.dkj, aFh());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void du(Context context) {
        this.mViewPager = ds(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aFe());
    }

    public PointPageIndicator getPageindicator() {
        return this.dkj;
    }

    protected int aFc() {
        return -2;
    }

    protected int aFd() {
        return -1;
    }

    protected LinearLayout.LayoutParams aFe() {
        return new LinearLayout.LayoutParams(aFd(), aFc());
    }

    protected int aFf() {
        return -1;
    }

    protected int aFg() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aFh() {
        return new LinearLayout.LayoutParams(aFf(), aFg());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.dkk[0] = i;
        this.dkk[1] = i2;
        requestLayout();
    }

    protected void aFi() {
        int pageCount = this.djX == null ? 0 : this.djX.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.dkk[0] : this.dkk[1];
        this.dkj.iY(pageCount);
        this.dkj.setVisibility(z ? 0 : 4);
        this.dkj.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.dkj.ja(i);
        }
    }

    /* loaded from: classes11.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.djX != null) {
                return SlideableGridView.this.djX.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.djX);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).at(SlideableGridView.this.djX.jc(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.dkj != null) {
            this.dkj.au(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.dkj != null) {
            this.mViewPager.setCurrentItem(i);
            this.dkj.ja(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
