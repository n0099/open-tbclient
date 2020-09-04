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
/* loaded from: classes14.dex */
public class SlideableGridView extends LinearLayout {
    b dEK;
    protected PointPageIndicator dEL;
    protected int[] dEM;
    private a dEz;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes14.dex */
    public static abstract class a {
        private SlideableGridView dEN;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int lL(int i);

        void f(SlideableGridView slideableGridView) {
            this.dEN = slideableGridView;
        }

        public int lM(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += lL(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.dEz;
    }

    public void setGridItemAdapter(a aVar) {
        this.dEz = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.dEK == null) {
                this.dEK = new b(getContext());
                this.mViewPager.setAdapter(this.dEK);
            } else {
                this.dEK.notifyDataSetChanged();
            }
            this.dEL.lI(aVar.getPageCount());
        } else if (this.dEK != null) {
            this.dEK.notifyDataSetChanged();
        }
        aSR();
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
        this.dEL = null;
        this.dEM = new int[2];
        init(context);
    }

    protected ViewPager dD(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dF(context);
        dE(context);
    }

    protected void dE(Context context) {
        this.dEL = new PointPageIndicator(context).aD(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).lJ((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.dEM[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.dEM[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.dEL, aSQ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dF(Context context) {
        this.mViewPager = dD(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aSN());
    }

    public PointPageIndicator getPageindicator() {
        return this.dEL;
    }

    protected int aSL() {
        return -2;
    }

    protected int aSM() {
        return -1;
    }

    protected LinearLayout.LayoutParams aSN() {
        return new LinearLayout.LayoutParams(aSM(), aSL());
    }

    protected int aSO() {
        return -1;
    }

    protected int aSP() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aSQ() {
        return new LinearLayout.LayoutParams(aSO(), aSP());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.dEM[0] = i;
        this.dEM[1] = i2;
        requestLayout();
    }

    protected void aSR() {
        int pageCount = this.dEz == null ? 0 : this.dEz.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.dEM[0] : this.dEM[1];
        this.dEL.lI(pageCount);
        this.dEL.setVisibility(z ? 0 : 4);
        this.dEL.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.dEL.lK(i);
        }
    }

    /* loaded from: classes14.dex */
    class b extends PagerAdapterImpl {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.dEz != null) {
                return SlideableGridView.this.dEz.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View f(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.dEz);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).aC(SlideableGridView.this.dEz.lM(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.dEL != null) {
            this.dEL.aD(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.dEL != null) {
            this.mViewPager.setCurrentItem(i);
            this.dEL.lK(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
