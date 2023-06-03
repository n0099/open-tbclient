package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.ui.viewpager.PagerAdapterImpl;
import com.baidu.searchbox.ui.viewpager.PointPageIndicator;
/* loaded from: classes4.dex */
public class SlideableGridView extends LinearLayout {
    public int mBottomPadding;
    public GridItemAdapter mGridItemAdapter;
    public PointPageIndicator mIndicator;
    public int[] mIndicatorHeight;
    public int mLeftPadding;
    public GridPagerAdapterImpl mPagerAdapter;
    public int mRightPadding;
    public int mTopPadding;
    public ViewPager mViewPager;

    public int createIndicatorWidth() {
        return -1;
    }

    public int createViewPagerHeight() {
        return -2;
    }

    public int createViewPagerWidth() {
        return -1;
    }

    /* loaded from: classes4.dex */
    public static abstract class GridItemAdapter {
        public static final int MAX_ITEM_NUM = 8;
        public static final int MAX_NUM_COLUMNS = 5;
        public static final int MIN_NUM_COLUMNS = 5;
        public SlideableGridView mSlideableGridView;

        public abstract View getGridItemView(int i, int i2, View view2, ViewGroup viewGroup);

        public abstract int getPageCount();

        public abstract int getPageGridItemCount(int i);

        public abstract void onGridItemClick(int i, int i2, View view2);

        public void notifyDataChanged() {
            GridPagerAdapterImpl gridPagerAdapterImpl;
            SlideableGridView slideableGridView = this.mSlideableGridView;
            if (slideableGridView != null && (gridPagerAdapterImpl = slideableGridView.mPagerAdapter) != null) {
                gridPagerAdapterImpl.notifyDataSetChanged();
                this.mSlideableGridView.adjustLayout();
            }
        }

        public int getColumnNum(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < getPageCount(); i3++) {
                i2 += getPageGridItemCount(i3);
            }
            return 5;
        }

        public void regSlideableGridView(SlideableGridView slideableGridView) {
            this.mSlideableGridView = slideableGridView;
        }
    }

    /* loaded from: classes4.dex */
    public class GridPagerAdapterImpl extends PagerAdapterImpl {
        public Context mContext;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public GridPagerAdapterImpl(Context context) {
            this.mContext = context;
        }

        @Override // com.baidu.searchbox.ui.viewpager.PagerAdapterImpl
        public void onConfigItem(View view2, int i) {
            ((GridPageView) view2).configItem(SlideableGridView.this.mGridItemAdapter.getColumnNum(i), i);
        }

        @Override // com.baidu.searchbox.ui.viewpager.PagerAdapterImpl
        public View onInstantiateItem(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.mContext);
            gridPageView.setGridItemAdapter(SlideableGridView.this.mGridItemAdapter);
            gridPageView.setPadding(SlideableGridView.this.mLeftPadding, SlideableGridView.this.mTopPadding, SlideableGridView.this.mRightPadding, SlideableGridView.this.mBottomPadding);
            return gridPageView;
        }

        @Override // com.baidu.searchbox.ui.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.mGridItemAdapter != null) {
                return SlideableGridView.this.mGridItemAdapter.getPageCount();
            }
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public class SimpleOnPageChangeListenerImpl extends ViewPager.SimpleOnPageChangeListener {
        public SimpleOnPageChangeListenerImpl() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.mIndicator.setCurrentPosition(i);
        }
    }

    public SlideableGridView(Context context) {
        this(context, null);
    }

    public void addViewPager(Context context) {
        ViewPager createViewPager = createViewPager(context);
        this.mViewPager = createViewPager;
        createViewPager.setOffscreenPageLimit(0);
        this.mViewPager.setOnPageChangeListener(new SimpleOnPageChangeListenerImpl());
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager, createViewPagerParams());
    }

    public ViewPager createViewPager(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    public void init(Context context) {
        setOrientation(1);
        addViewPager(context);
        addIndicator(context);
    }

    public void setCurrentPage(int i) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && this.mIndicator != null) {
            viewPager.setCurrentItem(i);
            this.mIndicator.setCurrentPosition(i);
        }
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setIndicatorColor(int i, int i2) {
        PointPageIndicator pointPageIndicator = this.mIndicator;
        if (pointPageIndicator != null) {
            pointPageIndicator.setPointDrawableResId(i, i2);
        }
    }

    public void setPageIndicatorHeight(int i, int i2) {
        int[] iArr = this.mIndicatorHeight;
        iArr[0] = i;
        iArr[1] = i2;
        requestLayout();
    }

    @SuppressLint({"NewApi", "suppressNewApi"})
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewPager = null;
        this.mIndicator = null;
        this.mIndicatorHeight = new int[2];
        init(context);
    }

    public void addIndicator(Context context) {
        this.mIndicator = new PointPageIndicator(context).setPointDrawableResId(com.baidu.tieba.R.drawable.common_menu_slide_indicator_normal, com.baidu.tieba.R.drawable.common_menu_slide_indicator_selected).setPointMargin((int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070248));
        this.mIndicatorHeight[0] = (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070246);
        this.mIndicatorHeight[1] = (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070247);
        addView(this.mIndicator, createIndicatorParams());
    }

    public void adjustLayout() {
        int pageCount;
        boolean z;
        int i;
        GridItemAdapter gridItemAdapter = this.mGridItemAdapter;
        int i2 = 0;
        if (gridItemAdapter == null) {
            pageCount = 0;
        } else {
            pageCount = gridItemAdapter.getPageCount();
        }
        if (pageCount > 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i = this.mIndicatorHeight[0];
        } else {
            i = this.mIndicatorHeight[1];
        }
        this.mIndicator.setPointCount(pageCount);
        PointPageIndicator pointPageIndicator = this.mIndicator;
        if (!z) {
            i2 = 4;
        }
        pointPageIndicator.setVisibility(i2);
        this.mIndicator.getLayoutParams().height = i;
    }

    public int createIndicatorHeight() {
        return (int) getResources().getDimension(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070246);
    }

    public LinearLayout.LayoutParams createIndicatorParams() {
        return new LinearLayout.LayoutParams(createIndicatorWidth(), createIndicatorHeight());
    }

    public LinearLayout.LayoutParams createViewPagerParams() {
        return new LinearLayout.LayoutParams(createViewPagerWidth(), createViewPagerHeight());
    }

    public GridItemAdapter getGridItemAdapter() {
        return this.mGridItemAdapter;
    }

    public PointPageIndicator getPageindicator() {
        return this.mIndicator;
    }

    public void setGridItemAdapter(GridItemAdapter gridItemAdapter) {
        this.mGridItemAdapter = gridItemAdapter;
        if (gridItemAdapter != null) {
            gridItemAdapter.regSlideableGridView(this);
            GridPagerAdapterImpl gridPagerAdapterImpl = this.mPagerAdapter;
            if (gridPagerAdapterImpl == null) {
                GridPagerAdapterImpl gridPagerAdapterImpl2 = new GridPagerAdapterImpl(getContext());
                this.mPagerAdapter = gridPagerAdapterImpl2;
                this.mViewPager.setAdapter(gridPagerAdapterImpl2);
            } else {
                gridPagerAdapterImpl.notifyDataSetChanged();
            }
            this.mIndicator.setPointCount(gridItemAdapter.getPageCount());
        } else {
            GridPagerAdapterImpl gridPagerAdapterImpl3 = this.mPagerAdapter;
            if (gridPagerAdapterImpl3 != null) {
                gridPagerAdapterImpl3.notifyDataSetChanged();
            }
        }
        adjustLayout();
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.mLeftPadding = i;
        this.mRightPadding = i3;
        this.mTopPadding = i2;
        this.mBottomPadding = i4;
    }
}
