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
    private a cYT;
    b cZe;
    protected PointPageIndicator cZf;
    protected int[] cZg;
    private int mBottomPadding;
    private int mLeftPadding;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes11.dex */
    public static abstract class a {
        private SlideableGridView cZh;

        public abstract View a(int i, int i2, View view, ViewGroup viewGroup);

        public abstract void a(int i, int i2, View view);

        public abstract int getPageCount();

        public abstract int iI(int i);

        void f(SlideableGridView slideableGridView) {
            this.cZh = slideableGridView;
        }

        public int iJ(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += iI(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }
    }

    public a getGridItemAdapter() {
        return this.cYT;
    }

    public void setGridItemAdapter(a aVar) {
        this.cYT = aVar;
        if (aVar != null) {
            aVar.f(this);
            if (this.cZe == null) {
                this.cZe = new b(getContext());
                this.mViewPager.setAdapter(this.cZe);
            } else {
                this.cZe.notifyDataSetChanged();
            }
            this.cZf.iF(aVar.getPageCount());
        } else if (this.cZe != null) {
            this.cZe.notifyDataSetChanged();
        }
        aBq();
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
        this.cZf = null;
        this.cZg = new int[2];
        init(context);
    }

    protected ViewPager dd(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        df(context);
        de(context);
    }

    protected void de(Context context) {
        this.cZf = new PointPageIndicator(context).au(g.c.aiapp_menu_slide_indicator_normal, g.c.aiapp_menu_slide_indicator_selected).iG((int) getResources().getDimension(g.b.common_grid_indicator_margin));
        this.cZg[0] = (int) getResources().getDimension(g.b.common_grid_indicator_height);
        this.cZg[1] = (int) getResources().getDimension(g.b.common_grid_indicator_height2);
        addView(this.cZf, aBp());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void df(Context context) {
        this.mViewPager = dd(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new c());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, aBm());
    }

    public PointPageIndicator getPageindicator() {
        return this.cZf;
    }

    protected int aBk() {
        return -2;
    }

    protected int aBl() {
        return -1;
    }

    protected LinearLayout.LayoutParams aBm() {
        return new LinearLayout.LayoutParams(aBl(), aBk());
    }

    protected int aBn() {
        return -1;
    }

    protected int aBo() {
        return (int) getResources().getDimension(g.b.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams aBp() {
        return new LinearLayout.LayoutParams(aBn(), aBo());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.cZg[0] = i;
        this.cZg[1] = i2;
        requestLayout();
    }

    protected void aBq() {
        int pageCount = this.cYT == null ? 0 : this.cYT.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.cZg[0] : this.cZg[1];
        this.cZf.iF(pageCount);
        this.cZf.setVisibility(z ? 0 : 4);
        this.cZf.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.cZf.iH(i);
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
            if (SlideableGridView.this.cYT != null) {
                return SlideableGridView.this.cYT.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected View h(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.cYT);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        protected void f(View view, int i) {
            ((GridPageView) view).at(SlideableGridView.this.cYT.iJ(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.cZf != null) {
            this.cZf.au(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.cZf != null) {
            this.mViewPager.setCurrentItem(i);
            this.cZf.iH(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
