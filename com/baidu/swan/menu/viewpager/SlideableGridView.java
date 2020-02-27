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
    private a czD;
    b czO;
    protected PointPageIndicator czP;
    protected int[] czQ;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView czR;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int iB(int i);

        void f(SlideableGridView slideableGridView) {
            this.czR = slideableGridView;
        }

        public int iC(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += iB(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.czD;
    }

    public void setGridItemAdapter(a aVar) {
        this.czD = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.czO == null) {
                this.czO = new b(getContext());
                this.mViewPager.setAdapter(this.czO);
            } else {
                this.czO.notifyDataSetChanged();
            }
            this.czP.iy(aVar.getPageCount());
        } else if (this.czO != null) {
            this.czO.notifyDataSetChanged();
        }
        atb();
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
        this.czP = null;
        this.czQ = new int[2];
        init(context);
    }

    protected ViewPager dC(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dE(context);
        dD(context);
    }

    protected void dD(Context context) {
        this.czP = new PointPageIndicator(context).ar(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).iz((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.czQ[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.czQ[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.czP, ata());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dE(Context context) {
        this.mViewPager = dC(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, asX());
    }

    public PointPageIndicator getPageindicator() {
        return this.czP;
    }

    protected int asV() {
        return -2;
    }

    protected int asW() {
        return -1;
    }

    protected LinearLayout.LayoutParams asX() {
        return new LinearLayout.LayoutParams(asW(), asV());
    }

    protected int asY() {
        return -1;
    }

    protected int asZ() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams ata() {
        return new LinearLayout.LayoutParams(asY(), asZ());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.czQ[0] = i;
        this.czQ[1] = i2;
        requestLayout();
    }

    protected void atb() {
        int pageCount = this.czD == null ? 0 : this.czD.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.czQ[0] : this.czQ[1];
        this.czP.iy(pageCount);
        this.czP.setVisibility(z ? 0 : 4);
        this.czP.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.czP.iA(i);
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
            if (SlideableGridView.this.czD != null) {
                return SlideableGridView.this.czD.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View h(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.czD);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void g(View view, int i) {
            ((GridPageView) view).aq(SlideableGridView.this.czD.iC(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.czP != null) {
            this.czP.ar(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.czP != null) {
            this.mViewPager.setCurrentItem(i);
            this.czP.iA(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
