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
    b cAb;
    protected PointPageIndicator cAc;
    protected int[] cAd;
    private a czQ;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView cAe;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int iB(int i);

        void f(SlideableGridView slideableGridView) {
            this.cAe = slideableGridView;
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
        return this.czQ;
    }

    public void setGridItemAdapter(a aVar) {
        this.czQ = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.cAb == null) {
                this.cAb = new b(getContext());
                this.mViewPager.setAdapter(this.cAb);
            } else {
                this.cAb.notifyDataSetChanged();
            }
            this.cAc.iy(aVar.getPageCount());
        } else if (this.cAb != null) {
            this.cAb.notifyDataSetChanged();
        }
        atg();
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
        this.cAc = null;
        this.cAd = new int[2];
        init(context);
    }

    protected ViewPager dB(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        dD(context);
        dC(context);
    }

    protected void dC(Context context) {
        this.cAc = new PointPageIndicator(context).ar(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).iz((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.cAd[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.cAd[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.cAc, atf());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dD(Context context) {
        this.mViewPager = dB(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, atc());
    }

    public PointPageIndicator getPageindicator() {
        return this.cAc;
    }

    protected int ata() {
        return -2;
    }

    protected int atb() {
        return -1;
    }

    protected LinearLayout.LayoutParams atc() {
        return new LinearLayout.LayoutParams(atb(), ata());
    }

    protected int atd() {
        return -1;
    }

    protected int ate() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams atf() {
        return new LinearLayout.LayoutParams(atd(), ate());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.cAd[0] = i;
        this.cAd[1] = i2;
        requestLayout();
    }

    protected void atg() {
        int pageCount = this.czQ == null ? 0 : this.czQ.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.cAd[0] : this.cAd[1];
        this.cAc.iy(pageCount);
        this.cAc.setVisibility(z ? 0 : 4);
        this.cAc.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.cAc.iA(i);
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
            if (SlideableGridView.this.czQ != null) {
                return SlideableGridView.this.czQ.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View h(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.czQ);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void g(View view, int i) {
            ((GridPageView) view).aq(SlideableGridView.this.czQ.iC(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.cAc != null) {
            this.cAc.ar(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.cAc != null) {
            this.mViewPager.setCurrentItem(i);
            this.cAc.iA(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
