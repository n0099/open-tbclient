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
    private a czF;
    b czQ;
    protected PointPageIndicator czR;
    protected int[] czS;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView czT;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int iB(int i);

        void f(SlideableGridView slideableGridView) {
            this.czT = slideableGridView;
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
        return this.czF;
    }

    public void setGridItemAdapter(a aVar) {
        this.czF = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.czQ == null) {
                this.czQ = new b(getContext());
                this.mViewPager.setAdapter(this.czQ);
            } else {
                this.czQ.notifyDataSetChanged();
            }
            this.czR.iy(aVar.getPageCount());
        } else if (this.czQ != null) {
            this.czQ.notifyDataSetChanged();
        }
        atd();
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
        this.czR = null;
        this.czS = new int[2];
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
        this.czR = new PointPageIndicator(context).ar(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).iz((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.czS[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.czS[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.czR, atc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dE(Context context) {
        this.mViewPager = dC(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, asZ());
    }

    public PointPageIndicator getPageindicator() {
        return this.czR;
    }

    protected int asX() {
        return -2;
    }

    protected int asY() {
        return -1;
    }

    protected LinearLayout.LayoutParams asZ() {
        return new LinearLayout.LayoutParams(asY(), asX());
    }

    protected int ata() {
        return -1;
    }

    protected int atb() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams atc() {
        return new LinearLayout.LayoutParams(ata(), atb());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.czS[0] = i;
        this.czS[1] = i2;
        requestLayout();
    }

    protected void atd() {
        int pageCount = this.czF == null ? 0 : this.czF.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.czS[0] : this.czS[1];
        this.czR.iy(pageCount);
        this.czR.setVisibility(z ? 0 : 4);
        this.czR.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.czR.iA(i);
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
            if (SlideableGridView.this.czF != null) {
                return SlideableGridView.this.czF.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View h(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.czF);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void g(View view, int i) {
            ((GridPageView) view).aq(SlideableGridView.this.czF.iC(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.czR != null) {
            this.czR.ar(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.czR != null) {
            this.mViewPager.setCurrentItem(i);
            this.czR.iA(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
