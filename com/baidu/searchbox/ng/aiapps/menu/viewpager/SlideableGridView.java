package com.baidu.searchbox.ng.aiapps.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.searchbox.ng.aiapps.menu.GridPageView;
import com.baidu.searchbox.ng.aiapps.menu.R;
/* loaded from: classes2.dex */
public class SlideableGridView extends LinearLayout {
    private int mBottomPadding;
    private GridItemAdapter mGridItemAdapter;
    protected PointPageIndicator mIndicator;
    protected int[] mIndicatorHeight;
    private int mLeftPadding;
    GridPagerAdapterImpl mPagerAdapter;
    private int mRightPadding;
    private int mTopPadding;
    private ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class GridItemAdapter {
        public static final int MAX_ITEM_NUM = 8;
        public static final int MAX_NUM_COLUMNS = 5;
        public static final int MIN_NUM_COLUMNS = 5;
        private SlideableGridView mSlideableGridView;

        public abstract View getGridItemView(int i, int i2, View view, ViewGroup viewGroup);

        public abstract int getPageCount();

        public abstract int getPageGridItemCount(int i);

        public abstract void onGridItemClick(int i, int i2, View view);

        void regSlideableGridView(SlideableGridView slideableGridView) {
            this.mSlideableGridView = slideableGridView;
        }

        public int getColumnNum(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += getPageGridItemCount(i3);
            }
            if (i2 < 5) {
            }
            return 5;
        }

        public void notifyDataChanged() {
            if (this.mSlideableGridView != null && this.mSlideableGridView.mPagerAdapter != null) {
                this.mSlideableGridView.mPagerAdapter.notifyDataSetChanged();
                this.mSlideableGridView.adjustLayout();
            }
        }
    }

    public GridItemAdapter getGridItemAdapter() {
        return this.mGridItemAdapter;
    }

    public void setGridItemAdapter(GridItemAdapter gridItemAdapter) {
        this.mGridItemAdapter = gridItemAdapter;
        if (gridItemAdapter != null) {
            gridItemAdapter.regSlideableGridView(this);
            if (this.mPagerAdapter == null) {
                this.mPagerAdapter = new GridPagerAdapterImpl(getContext());
                this.mViewPager.setAdapter(this.mPagerAdapter);
            } else {
                this.mPagerAdapter.notifyDataSetChanged();
            }
            this.mIndicator.setPointCount(gridItemAdapter.getPageCount());
        } else if (this.mPagerAdapter != null) {
            this.mPagerAdapter.notifyDataSetChanged();
        }
        adjustLayout();
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
        this.mIndicator = null;
        this.mIndicatorHeight = new int[2];
        init(context);
    }

    protected ViewPager createViewPager(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    protected void init(Context context) {
        setOrientation(1);
        addViewPager(context);
        addIndicator(context);
    }

    protected void addIndicator(Context context) {
        this.mIndicator = new PointPageIndicator(context).setPointDrawableResId(R.drawable.aiapp_menu_slide_indicator_normal, R.drawable.aiapp_menu_slide_indicator_selected).setPointMargin((int) getResources().getDimension(R.dimen.common_grid_indicator_margin));
        this.mIndicatorHeight[0] = (int) getResources().getDimension(R.dimen.common_grid_indicator_height);
        this.mIndicatorHeight[1] = (int) getResources().getDimension(R.dimen.common_grid_indicator_height2);
        addView(this.mIndicator, createIndicatorParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addViewPager(Context context) {
        this.mViewPager = createViewPager(context);
        this.mViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new SimpleOnPageChangeListenerImpl());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, createViewPagerParams());
    }

    public PointPageIndicator getPageindicator() {
        return this.mIndicator;
    }

    protected int createViewPagerHeight() {
        return -2;
    }

    protected int createViewPagerWidth() {
        return -1;
    }

    protected LinearLayout.LayoutParams createViewPagerParams() {
        return new LinearLayout.LayoutParams(createViewPagerWidth(), createViewPagerHeight());
    }

    protected int createIndicatorWidth() {
        return -1;
    }

    protected int createIndicatorHeight() {
        return (int) getResources().getDimension(R.dimen.common_grid_indicator_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinearLayout.LayoutParams createIndicatorParams() {
        return new LinearLayout.LayoutParams(createIndicatorWidth(), createIndicatorHeight());
    }

    public void setPageIndicatorHeight(int i, int i2) {
        this.mIndicatorHeight[0] = i;
        this.mIndicatorHeight[1] = i2;
        requestLayout();
    }

    protected void adjustLayout() {
        int pageCount = this.mGridItemAdapter == null ? 0 : this.mGridItemAdapter.getPageCount();
        boolean z = pageCount > 1;
        int i = !z ? this.mIndicatorHeight[0] : this.mIndicatorHeight[1];
        this.mIndicator.setPointCount(pageCount);
        this.mIndicator.setVisibility(z ? 0 : 4);
        this.mIndicator.getLayoutParams().height = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class SimpleOnPageChangeListenerImpl extends ViewPager.SimpleOnPageChangeListener {
        SimpleOnPageChangeListenerImpl() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.mIndicator.setCurrentPosition(i);
        }
    }

    /* loaded from: classes2.dex */
    class GridPagerAdapterImpl extends PagerAdapterImpl {
        private Context mContext;

        public GridPagerAdapterImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.PagerAdapterImpl, android.support.v4.view.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.mGridItemAdapter != null) {
                return SlideableGridView.this.mGridItemAdapter.getPageCount();
            }
            return 0;
        }

        @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.PagerAdapterImpl
        protected View onInstantiateItem(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            if (gridPageView != null) {
                gridPageView.setGridItemAdapter(SlideableGridView.this.mGridItemAdapter);
            }
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.searchbox.ng.aiapps.menu.viewpager.PagerAdapterImpl
        protected void onConfigItem(View view, int i) {
            ((GridPageView) view).configItem(SlideableGridView.this.mGridItemAdapter.getColumnNum(i), i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public void setIndicatorColor(int i, int i2) {
        if (this.mIndicator != null) {
            this.mIndicator.setPointDrawableResId(i, i2);
        }
    }

    public void setCurrentPage(int i) {
        if (this.mViewPager != null && this.mIndicator != null) {
            this.mViewPager.setCurrentItem(i);
            this.mIndicator.setCurrentPosition(i);
        }
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
