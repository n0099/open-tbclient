package com.baidu.searchbox.ui;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ui.view.BadgeFactory;
import com.baidu.searchbox.ui.view.BadgeView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int INDICATOR_HEIGHT_DIPS = 2;
    private static final int TAB_ITEM_DISTANCE_DIPS = 1;
    private static final int TAB_ITEM_TEXT_SIZE_DIPS = 14;
    private static final int TAB_ITEM_VIEW_PADDING_DIPS = 11;
    private static final String TAG = "SlidingTabLayout";
    private final SparseArray<BadgeView> mBadgeViewMap;
    private TabSelectedListener mCurrentVpSelectedListener;
    private float mDeltaTextHeight;
    private boolean mDistributeEvenly;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private boolean mIsEnableSlide;
    private float mMaxTextScaleSize;
    private ViewPager.OnAdapterChangeListener mOnAdapterChangeListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private float mSelectedFontHeight;
    private int mSelectedTabPosition;
    private float mSelectedTextSize;
    private final SlidingTabIndicator mSlidingTabIndicator;
    private float mTabItemDistance;
    private final ArrayList<TextView> mTabItemViewList;
    private int mTabPaddingBottom;
    private int mTabPaddingEnd;
    private int mTabPaddingStart;
    private int mTabPaddingTop;
    private final ArrayList<TabSelectedListener> mTabSelectedListenerList;
    private ColorStateList mTabTextColors;
    private float mUnSelectedFontHeight;
    private float mUnSelectedTextSize;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public interface TabSelectedListener {
        void onTabReselected(int i);

        void onTabSelected(int i, boolean z);

        void onTabUnselected(int i, boolean z);
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDistributeEvenly = false;
        this.mIsEnableSlide = true;
        this.mSelectedTabPosition = -1;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.TabLayout);
        if (obtainStyledAttributes != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPadding, 0);
            this.mTabPaddingBottom = dimensionPixelSize;
            this.mTabPaddingEnd = dimensionPixelSize;
            this.mTabPaddingTop = dimensionPixelSize;
            this.mTabPaddingStart = dimensionPixelSize;
            this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingStart, this.mTabPaddingStart);
            this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
            this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
            this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
            this.mTabItemDistance = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabDistance, dpToPx(1));
            this.mTabTextColors = obtainStyledAttributes.getColorStateList(com.baidu.android.common.ui.R.styleable.TabLayout_tabTextColors);
            if (this.mTabTextColors == null) {
                this.mTabTextColors = createColorStateList(getTabTextNormalColor(), getTabTextSelectedColor());
            }
            this.mSelectedTextSize = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabTextSize, dpToPx(14));
            this.mIndicatorColor = obtainStyledAttributes.getColor(com.baidu.android.common.ui.R.styleable.TabLayout_tabLayout_indicatorColor, this.mIndicatorColor);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_indicatorHeight, dpToPx(2));
            obtainStyledAttributes.recycle();
        }
        this.mUnSelectedTextSize = this.mSelectedTextSize;
        this.mSelectedFontHeight = getFontHeight(this.mSelectedTextSize);
        this.mUnSelectedFontHeight = getFontHeight(this.mUnSelectedTextSize);
        this.mSlidingTabIndicator = new SlidingTabIndicator(context);
        addView(this.mSlidingTabIndicator, new LinearLayout.LayoutParams(-2, -1));
        this.mSlidingTabIndicator.setIndicatorHeight(this.mIndicatorHeight);
        this.mSlidingTabIndicator.setIndicatorPadding(dpToPx(11));
        this.mBadgeViewMap = new SparseArray<>();
        this.mTabItemViewList = new ArrayList<>();
        this.mTabSelectedListenerList = new ArrayList<>();
    }

    private TextView createTabItemView(int i) {
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        if (i == 0) {
            marginLayoutParams.setMargins(this.mTabPaddingStart, 0, (int) (this.mTabItemDistance / 2.0f), 0);
        } else if (i == getTabCount() - 1) {
            marginLayoutParams.setMargins((int) (this.mTabItemDistance / 2.0f), 0, this.mTabPaddingEnd, 0);
        } else {
            marginLayoutParams.setMargins((int) (this.mTabItemDistance / 2.0f), 0, (int) (this.mTabItemDistance / 2.0f), 0);
        }
        int dpToPx = dpToPx(11);
        textView.setPadding(dpToPx, 0, dpToPx, this.mIndicatorHeight);
        textView.setGravity(17);
        textView.setLayoutParams(marginLayoutParams);
        if (this.mDistributeEvenly) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        }
        return textView;
    }

    private TextView getTabItemView(int i) {
        if (this.mTabItemViewList == null || i >= this.mTabItemViewList.size() || i < 0) {
            return null;
        }
        return this.mTabItemViewList.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populateFromPagerAdapter() {
        this.mTabItemViewList.clear();
        this.mBadgeViewMap.clear();
        this.mSlidingTabIndicator.removeAllViews();
        for (int i = 0; i < getTabCount(); i++) {
            TextView createTabItemView = createTabItemView(i);
            createTabItemView.setOnClickListener(new TabClickListener(i));
            updateTabItemView(createTabItemView, false);
            if (this.mPagerAdapter != null && !TextUtils.isEmpty(this.mPagerAdapter.getPageTitle(i))) {
                createTabItemView.setText(this.mPagerAdapter.getPageTitle(i));
            }
            this.mSlidingTabIndicator.addView(createTabItemView);
            this.mTabItemViewList.add(createTabItemView);
        }
        selectTab(this.mViewPager != null ? this.mViewPager.getCurrentItem() : -1, true);
    }

    private void updateTabItemView(TextView textView, boolean z) {
        if (textView != null) {
            textView.setTextSize(0, z ? this.mSelectedTextSize : this.mUnSelectedTextSize);
            textView.setTextColor(this.mTabTextColors);
            textView.setSelected(z);
            textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            textView.setScaleX(getTabTextScaleByRatio(z ? 0.0f : 1.0f));
            textView.setScaleY(getTabTextScaleByRatio(z ? 0.0f : 1.0f));
            textView.setTranslationY(getTabTextTranslationY(z ? 0.0f : 1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gradualChangeTabView(int i, float f) {
        if (i >= 0 && i < this.mSlidingTabIndicator.getChildCount()) {
            gradualChangeTabItemView(getTabItemView(i), f, i);
        }
        if (i + 1 >= 0 && i + 1 < this.mSlidingTabIndicator.getChildCount()) {
            gradualChangeTabItemView(getTabItemView(i + 1), 1.0f - f, i + 1);
        }
    }

    private void gradualChangeTabItemView(TextView textView, float f, int i) {
        if (textView != null) {
            textView.setTextColor(getTabTextColorByRatio(f, i));
            float tabTextScaleByRatio = getTabTextScaleByRatio(f);
            textView.setScaleX(tabTextScaleByRatio);
            textView.setScaleY(tabTextScaleByRatio);
            float tabTextTranslationY = getTabTextTranslationY(f);
            textView.setTranslationY(tabTextTranslationY);
            BadgeView badgeView = this.mBadgeViewMap.get(i);
            if (badgeView != null && badgeView.getVisibility() == 0) {
                badgeView.setTranslationY(tabTextTranslationY * 2.0f);
            }
        }
    }

    private int getTabTextColorByRatio(float f, int i) {
        return ((Integer) new ArgbEvaluator().evaluate(f, Integer.valueOf(getTabTextSelectedColor()), Integer.valueOf(getTabTextNormalColor()))).intValue();
    }

    private int getTabTextSelectedColor() {
        return this.mTabTextColors == null ? ViewCompat.MEASURED_STATE_MASK : this.mTabTextColors.getColorForState(new int[]{16842913}, getTabTextNormalColor());
    }

    private int getTabTextNormalColor() {
        if (this.mTabTextColors == null) {
            return -7829368;
        }
        return this.mTabTextColors.getDefaultColor();
    }

    private float getTabTextScaleByRatio(float f) {
        return (1.0f * f) + ((this.mSelectedFontHeight / this.mUnSelectedFontHeight) * (1.0f - f));
    }

    private float getTabTextTranslationY(float f) {
        return ((-(this.mSelectedFontHeight - this.mUnSelectedFontHeight)) / 2.0f) * (1.0f - f);
    }

    private float getFontHeight(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (float) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
    }

    private int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    private ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToTab(int i, float f) {
        int childCount = this.mSlidingTabIndicator.getChildCount();
        if (this.mIsEnableSlide && childCount != 0 && i >= 0 && i < childCount) {
            smoothScrollTo(calculateScrollXForTab(i, f), 0);
        }
    }

    private int calculateScrollXForTab(int i, float f) {
        View childAt = this.mSlidingTabIndicator.getChildAt(i);
        View childAt2 = i + 1 < this.mSlidingTabIndicator.getChildCount() ? this.mSlidingTabIndicator.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((childAt != null ? childAt.getLeft() : 0) + (width / 2)) - (getWidth() / 2);
        int i2 = (int) ((width2 + width) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i2 : left - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        if (this.mPagerAdapter != null && this.mPagerAdapterObserver != null) {
            this.mPagerAdapter.unregisterDataSetObserver(this.mPagerAdapterObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new DataSetObserver() { // from class: com.baidu.searchbox.ui.TabLayout.1
                    @Override // android.database.DataSetObserver
                    public void onChanged() {
                        TabLayout.this.populateFromPagerAdapter();
                    }

                    @Override // android.database.DataSetObserver
                    public void onInvalidated() {
                        TabLayout.this.populateFromPagerAdapter();
                    }
                };
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectTab(int i, boolean z) {
        int i2 = this.mSelectedTabPosition;
        if (i2 == i) {
            dispatchTabReSelected(i);
            return;
        }
        this.mSelectedTabPosition = i;
        dispatchTabUnSelected(i2, z);
        updateTabItemView(getTabItemView(i2), false);
        updateTabItemView(getTabItemView(i), true);
        if (z) {
            this.mSlidingTabIndicator.setIndicatorPositionFromTabPosition(i, 0.0f);
            scrollToTab(i, 0.0f);
        }
        dispatchTabSelected(i, z);
    }

    private void dispatchTabSelected(int i, boolean z) {
        for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
            this.mTabSelectedListenerList.get(size).onTabSelected(i, z);
        }
    }

    private void dispatchTabUnSelected(int i, boolean z) {
        for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
            this.mTabSelectedListenerList.get(size).onTabUnselected(i, z);
        }
    }

    private void dispatchTabReSelected(int i) {
        for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
            this.mTabSelectedListenerList.get(size).onTabReselected(i);
        }
    }

    private int getTabCount() {
        if (this.mPagerAdapter != null) {
            return this.mPagerAdapter.getCount();
        }
        return 0;
    }

    public void setDistributeEvenly(boolean z) {
        this.mDistributeEvenly = z;
    }

    public void setIndicatorColor(int i) {
        this.mSlidingTabIndicator.setIndicatorColor(i);
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabsUIStyle();
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        if (this.mViewPager != viewPager) {
            if (this.mViewPager != null) {
                if (this.mOnPageChangeListener != null) {
                    this.mViewPager.removeOnPageChangeListener(this.mOnPageChangeListener);
                }
                if (this.mOnAdapterChangeListener != null) {
                    this.mViewPager.removeOnAdapterChangeListener(this.mOnAdapterChangeListener);
                }
            }
            if (this.mCurrentVpSelectedListener != null) {
                removeOnTabSelectedListener(this.mCurrentVpSelectedListener);
            }
            if (viewPager != null) {
                this.mViewPager = viewPager;
                if (this.mOnPageChangeListener == null) {
                    this.mOnPageChangeListener = new InternalViewPagerListener();
                }
                viewPager.addOnPageChangeListener(this.mOnPageChangeListener);
                if (this.mCurrentVpSelectedListener == null) {
                    this.mCurrentVpSelectedListener = new TabSelectedListenerAdapter() { // from class: com.baidu.searchbox.ui.TabLayout.2
                        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListenerAdapter, com.baidu.searchbox.ui.TabLayout.TabSelectedListener
                        public void onTabSelected(int i, boolean z) {
                            if (TabLayout.this.mViewPager != null) {
                                TabLayout.this.mViewPager.setCurrentItem(i, false);
                            }
                        }
                    };
                }
                addOnTabSelectedListener(this.mCurrentVpSelectedListener);
                PagerAdapter adapter = viewPager.getAdapter();
                if (adapter != null) {
                    setPagerAdapter(adapter, true);
                }
                if (this.mOnAdapterChangeListener == null) {
                    this.mOnAdapterChangeListener = new ViewPager.OnAdapterChangeListener() { // from class: com.baidu.searchbox.ui.TabLayout.3
                        @Override // android.support.v4.view.ViewPager.OnAdapterChangeListener
                        public void onAdapterChanged(@NonNull ViewPager viewPager2, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
                            TabLayout.this.setPagerAdapter(pagerAdapter2, true);
                        }
                    };
                }
                viewPager.addOnAdapterChangeListener(this.mOnAdapterChangeListener);
                return;
            }
            setPagerAdapter(null, false);
        }
    }

    public void showRedDot(int i) {
        showRedDot(i, 0);
    }

    public void showRedDot(int i, int i2) {
        BadgeView badgeView = this.mBadgeViewMap.get(i);
        if (badgeView == null) {
            badgeView = createDot(i2);
            badgeView.bindView(getTabItemView(i));
            this.mBadgeViewMap.put(i, badgeView);
        } else if ((badgeView.getBadgeCount() == null && i2 > 0) || (badgeView.getBadgeCount() != null && badgeView.getBadgeCount().intValue() != i2)) {
            badgeView.unbind();
            this.mBadgeViewMap.remove(i);
            badgeView = createDot(i2);
            badgeView.bindView(getTabItemView(i));
            this.mBadgeViewMap.put(i, badgeView);
        }
        badgeView.setVisibility(0);
    }

    public void showRedDot(int i, String str) {
        BadgeView badgeView = this.mBadgeViewMap.get(i);
        if (badgeView != null) {
            badgeView.unbind();
            this.mBadgeViewMap.remove(i);
        }
        BadgeView createMenuBadge = BadgeFactory.createMenuBadge(getContext());
        createMenuBadge.bindView(getTabItemView(i));
        createMenuBadge.setBadgeMargin(0, 1, 0, 0);
        createMenuBadge.setText(str);
        this.mBadgeViewMap.put(i, createMenuBadge);
        createMenuBadge.setVisibility(0);
    }

    public void hideRedDot(int i) {
        BadgeView badgeView = this.mBadgeViewMap.get(i);
        if (badgeView != null) {
            badgeView.setVisibility(4);
        }
    }

    private BadgeView createDot(int i) {
        if (i > 0) {
            BadgeView createMenuBadge = BadgeFactory.createMenuBadge(getContext());
            createMenuBadge.setBadgeCount(i);
            return createMenuBadge;
        }
        BadgeView createDot = BadgeFactory.createDot(getContext());
        createDot.setBadgeMargin(0, 8, 8, 0);
        return createDot;
    }

    public void enableSlide(boolean z) {
        this.mIsEnableSlide = z;
    }

    public int getSelectedTabPosition() {
        return this.mSelectedTabPosition;
    }

    public void updateAllTabsUIStyle() {
        if (this.mViewPager != null) {
            int i = 0;
            while (i < getTabCount()) {
                TextView tabItemView = getTabItemView(i);
                if (tabItemView != null) {
                    boolean z = i == this.mViewPager.getCurrentItem();
                    tabItemView.setTextColor(this.mTabTextColors);
                    tabItemView.setSelected(z);
                }
                i++;
            }
            this.mSlidingTabIndicator.invalidate();
        }
        for (int i2 = 0; i2 < this.mBadgeViewMap.size(); i2++) {
            BadgeView valueAt = this.mBadgeViewMap.valueAt(i2);
            if (valueAt != null) {
                if (TextUtils.isEmpty(valueAt.getText())) {
                    valueAt.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.common_badge));
                } else {
                    valueAt.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.common_badge_default_bg));
                }
            }
        }
    }

    public void addOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        if (!this.mTabSelectedListenerList.contains(tabSelectedListener)) {
            this.mTabSelectedListenerList.add(tabSelectedListener);
        }
    }

    public void removeOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        this.mTabSelectedListenerList.remove(tabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        this.mTabSelectedListenerList.clear();
    }

    /* loaded from: classes3.dex */
    public static class TabSelectedListenerAdapter implements TabSelectedListener {
        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabSelected(int i, boolean z) {
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabUnselected(int i, boolean z) {
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabReselected(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TabClickListener implements View.OnClickListener {
        private int clickPos;

        TabClickListener(int i) {
            this.clickPos = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabLayout.this.selectTab(this.clickPos, true);
        }
    }

    /* loaded from: classes3.dex */
    private class InternalViewPagerListener implements ViewPager.OnPageChangeListener {
        private boolean mIsUserDrag;
        private int mScrollState;

        private InternalViewPagerListener() {
            this.mIsUserDrag = false;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount = TabLayout.this.mSlidingTabIndicator.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                TabLayout.this.mSlidingTabIndicator.setIndicatorPositionFromTabPosition(i, f);
                if (this.mIsUserDrag) {
                    TabLayout.this.gradualChangeTabView(i, f);
                }
                TabLayout.this.scrollToTab(i, f);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            boolean z = true;
            if (i != 1 && (this.mScrollState != 1 || i != 2)) {
                z = false;
            }
            this.mIsUserDrag = z;
            this.mScrollState = i;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (TabLayout.this.mSelectedTabPosition != i) {
                TabLayout.this.selectTab(i, false);
            }
            this.mIsUserDrag = false;
        }
    }
}
