package com.baidu.searchbox.ui;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.searchbox.ui.view.BadgeFactory;
import com.baidu.searchbox.ui.view.BadgeView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int INDICATOR_HEIGHT_DIPS = 2;
    public static final int TAB_ITEM_DISTANCE_DIPS = 1;
    public static final int TAB_ITEM_TEXT_SIZE_DIPS = 14;
    public static final int TAB_ITEM_VIEW_PADDING_DIPS = 11;
    public static final String TAG = "SlidingTabLayout";
    public final SparseArray<BadgeView> mBadgeViewMap;
    public TabSelectedListener mCurrentVpSelectedListener;
    public float mDeltaTextHeight;
    public boolean mDistributeEvenly;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public boolean mIsEnableSlide;
    public float mMaxTextScaleSize;
    public ViewPager.OnAdapterChangeListener mOnAdapterChangeListener;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public PagerAdapter mPagerAdapter;
    public DataSetObserver mPagerAdapterObserver;
    public float mSelectedFontHeight;
    public int mSelectedTabPosition;
    public float mSelectedTextSize;
    public final SlidingTabIndicator mSlidingTabIndicator;
    public float mTabItemDistance;
    public final ArrayList<TextView> mTabItemViewList;
    public int mTabPaddingBottom;
    public int mTabPaddingEnd;
    public int mTabPaddingStart;
    public int mTabPaddingTop;
    public final ArrayList<TabSelectedListener> mTabSelectedListenerList;
    public ColorStateList mTabTextColors;
    public float mUnSelectedFontHeight;
    public float mUnSelectedTextSize;
    public ViewPager mViewPager;

    /* loaded from: classes4.dex */
    public interface TabSelectedListener {
        void onTabReselected(int i);

        void onTabSelected(int i, boolean z);

        void onTabUnselected(int i, boolean z);
    }

    /* loaded from: classes4.dex */
    public static class TabSelectedListenerAdapter implements TabSelectedListener {
        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabReselected(int i) {
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabSelected(int i, boolean z) {
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabUnselected(int i, boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class InternalViewPagerListener implements ViewPager.OnPageChangeListener {
        public boolean mIsUserDrag;
        public int mScrollState;

        public InternalViewPagerListener() {
            this.mIsUserDrag = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            boolean z = true;
            if (i != 1 && (this.mScrollState != 1 || i != 2)) {
                z = false;
            }
            this.mIsUserDrag = z;
            this.mScrollState = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (TabLayout.this.mSelectedTabPosition != i) {
                TabLayout.this.selectTab(i, false);
            }
            this.mIsUserDrag = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
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
    }

    /* loaded from: classes4.dex */
    public class TabClickListener implements View.OnClickListener {
        public int clickPos;

        public TabClickListener(int i) {
            this.clickPos = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TabLayout.this.selectTab(this.clickPos, true);
        }
    }

    public TabLayout(Context context) {
        this(context, null);
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

    private void dispatchTabReSelected(int i) {
        for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
            this.mTabSelectedListenerList.get(size).onTabReselected(i);
        }
    }

    private int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    private float getFontHeight(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (float) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
    }

    private TextView getTabItemView(int i) {
        ArrayList<TextView> arrayList = this.mTabItemViewList;
        if (arrayList != null && i < arrayList.size() && i >= 0) {
            return this.mTabItemViewList.get(i);
        }
        return null;
    }

    private float getTabTextScaleByRatio(float f) {
        return (f * 1.0f) + ((this.mSelectedFontHeight / this.mUnSelectedFontHeight) * (1.0f - f));
    }

    private float getTabTextTranslationY(float f) {
        return ((-(this.mSelectedFontHeight - this.mUnSelectedFontHeight)) / 2.0f) * (1.0f - f);
    }

    public void addOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        if (!this.mTabSelectedListenerList.contains(tabSelectedListener)) {
            this.mTabSelectedListenerList.add(tabSelectedListener);
        }
    }

    public void enableSlide(boolean z) {
        this.mIsEnableSlide = z;
    }

    public void hideRedDot(int i) {
        BadgeView badgeView = this.mBadgeViewMap.get(i);
        if (badgeView != null) {
            badgeView.setVisibility(4);
        }
    }

    public void removeOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        this.mTabSelectedListenerList.remove(tabSelectedListener);
    }

    public void setDistributeEvenly(boolean z) {
        this.mDistributeEvenly = z;
    }

    public void setIndicatorColor(int i) {
        this.mSlidingTabIndicator.setIndicatorColor(i);
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabsUIStyle();
        }
    }

    public void showRedDot(int i) {
        showRedDot(i, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
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

    private int getTabTextColorByRatio(float f, int i) {
        return ((Integer) new ArgbEvaluator().evaluate(f, Integer.valueOf(getTabTextSelectedColor()), Integer.valueOf(getTabTextNormalColor()))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gradualChangeTabView(int i, float f) {
        if (i >= 0 && i < this.mSlidingTabIndicator.getChildCount()) {
            gradualChangeTabItemView(getTabItemView(i), f, i);
        }
        int i2 = i + 1;
        if (i2 >= 0 && i2 < this.mSlidingTabIndicator.getChildCount()) {
            gradualChangeTabItemView(getTabItemView(i2), 1.0f - f, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToTab(int i, float f) {
        int childCount = this.mSlidingTabIndicator.getChildCount();
        if (this.mIsEnableSlide && childCount != 0 && i >= 0 && i < childCount) {
            smoothScrollTo(calculateScrollXForTab(i, f), 0);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
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

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
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

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDistributeEvenly = false;
        this.mIsEnableSlide = true;
        this.mSelectedTabPosition = -1;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.TabLayout);
        if (obtainStyledAttributes != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(18, 0);
            this.mTabPaddingBottom = dimensionPixelSize;
            this.mTabPaddingEnd = dimensionPixelSize;
            this.mTabPaddingTop = dimensionPixelSize;
            this.mTabPaddingStart = dimensionPixelSize;
            this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(21, dimensionPixelSize);
            this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(22, this.mTabPaddingTop);
            this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(20, this.mTabPaddingEnd);
            this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(19, this.mTabPaddingBottom);
            this.mTabItemDistance = obtainStyledAttributes.getDimensionPixelSize(3, dpToPx(1));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(27);
            this.mTabTextColors = colorStateList;
            if (colorStateList == null) {
                this.mTabTextColors = createColorStateList(getTabTextNormalColor(), getTabTextSelectedColor());
            }
            this.mSelectedTextSize = obtainStyledAttributes.getDimensionPixelSize(28, dpToPx(14));
            this.mIndicatorColor = obtainStyledAttributes.getColor(14, this.mIndicatorColor);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(0, dpToPx(2));
            obtainStyledAttributes.recycle();
        }
        float f = this.mSelectedTextSize;
        this.mUnSelectedTextSize = f;
        this.mSelectedFontHeight = getFontHeight(f);
        this.mUnSelectedFontHeight = getFontHeight(this.mUnSelectedTextSize);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context);
        this.mSlidingTabIndicator = slidingTabIndicator;
        addView(slidingTabIndicator, new LinearLayout.LayoutParams(-2, -1));
        this.mSlidingTabIndicator.setIndicatorHeight(this.mIndicatorHeight);
        this.mSlidingTabIndicator.setIndicatorPadding(dpToPx(11));
        this.mBadgeViewMap = new SparseArray<>();
        this.mTabItemViewList = new ArrayList<>();
        this.mTabSelectedListenerList = new ArrayList<>();
    }

    private int calculateScrollXForTab(int i, float f) {
        View view2;
        int i2;
        int i3;
        View childAt = this.mSlidingTabIndicator.getChildAt(i);
        int i4 = i + 1;
        if (i4 < this.mSlidingTabIndicator.getChildCount()) {
            view2 = this.mSlidingTabIndicator.getChildAt(i4);
        } else {
            view2 = null;
        }
        int i5 = 0;
        if (childAt != null) {
            i2 = childAt.getWidth();
        } else {
            i2 = 0;
        }
        if (view2 != null) {
            i3 = view2.getWidth();
        } else {
            i3 = 0;
        }
        if (childAt != null) {
            i5 = childAt.getLeft();
        }
        int width = (i5 + (i2 / 2)) - (getWidth() / 2);
        int i6 = (int) ((i2 + i3) * 0.5f * f);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return width + i6;
        }
        return width - i6;
    }

    private void updateTabItemView(TextView textView, boolean z) {
        float f;
        Typeface typeface;
        float f2;
        float f3;
        if (textView == null) {
            return;
        }
        if (z) {
            f = this.mSelectedTextSize;
        } else {
            f = this.mUnSelectedTextSize;
        }
        textView.setTextSize(0, f);
        textView.setTextColor(this.mTabTextColors);
        textView.setSelected(z);
        if (z) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        textView.setTypeface(typeface);
        float f4 = 0.0f;
        if (z) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        textView.setScaleX(getTabTextScaleByRatio(f2));
        if (z) {
            f3 = 0.0f;
        } else {
            f3 = 1.0f;
        }
        textView.setScaleY(getTabTextScaleByRatio(f3));
        if (!z) {
            f4 = 1.0f;
        }
        textView.setTranslationY(getTabTextTranslationY(f4));
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

    private TextView createTabItemView(int i) {
        TextView textView = new TextView(getContext());
        textView.setSingleLine();
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        if (i == 0) {
            marginLayoutParams.setMargins(this.mTabPaddingStart, 0, (int) (this.mTabItemDistance / 2.0f), 0);
        } else if (i == getTabCount() - 1) {
            marginLayoutParams.setMargins((int) (this.mTabItemDistance / 2.0f), 0, this.mTabPaddingEnd, 0);
        } else {
            float f = this.mTabItemDistance;
            marginLayoutParams.setMargins((int) (f / 2.0f), 0, (int) (f / 2.0f), 0);
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

    public void setupWithViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(onPageChangeListener);
            }
            ViewPager.OnAdapterChangeListener onAdapterChangeListener = this.mOnAdapterChangeListener;
            if (onAdapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener(onAdapterChangeListener);
            }
        }
        TabSelectedListener tabSelectedListener = this.mCurrentVpSelectedListener;
        if (tabSelectedListener != null) {
            removeOnTabSelectedListener(tabSelectedListener);
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
                    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
                    public void onAdapterChanged(@NonNull ViewPager viewPager3, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
                        TabLayout.this.setPagerAdapter(pagerAdapter2, true);
                    }
                };
            }
            viewPager.addOnAdapterChangeListener(this.mOnAdapterChangeListener);
            return;
        }
        setPagerAdapter(null, false);
    }

    private int getTabCount() {
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter != null) {
            return pagerAdapter.getCount();
        }
        return 0;
    }

    private int getTabTextNormalColor() {
        ColorStateList colorStateList = this.mTabTextColors;
        if (colorStateList == null) {
            return -7829368;
        }
        return colorStateList.getDefaultColor();
    }

    private int getTabTextSelectedColor() {
        ColorStateList colorStateList = this.mTabTextColors;
        if (colorStateList == null) {
            return -16777216;
        }
        return colorStateList.getColorForState(new int[]{16842913}, getTabTextNormalColor());
    }

    public void clearOnTabSelectedListeners() {
        this.mTabSelectedListenerList.clear();
    }

    public int getSelectedTabPosition() {
        return this.mSelectedTabPosition;
    }

    private void gradualChangeTabItemView(TextView textView, float f, int i) {
        if (textView == null) {
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void populateFromPagerAdapter() {
        int i;
        this.mTabItemViewList.clear();
        this.mBadgeViewMap.clear();
        this.mSlidingTabIndicator.removeAllViews();
        for (int i2 = 0; i2 < getTabCount(); i2++) {
            TextView createTabItemView = createTabItemView(i2);
            createTabItemView.setOnClickListener(new TabClickListener(i2));
            updateTabItemView(createTabItemView, false);
            PagerAdapter pagerAdapter = this.mPagerAdapter;
            if (pagerAdapter != null && !TextUtils.isEmpty(pagerAdapter.getPageTitle(i2))) {
                createTabItemView.setText(this.mPagerAdapter.getPageTitle(i2));
            }
            this.mSlidingTabIndicator.addView(createTabItemView);
            this.mTabItemViewList.add(createTabItemView);
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            i = viewPager.getCurrentItem();
        } else {
            i = -1;
        }
        selectTab(i, true);
    }

    public void updateAllTabsUIStyle() {
        boolean z;
        if (this.mViewPager != null) {
            for (int i = 0; i < getTabCount(); i++) {
                TextView tabItemView = getTabItemView(i);
                if (tabItemView != null) {
                    if (i == this.mViewPager.getCurrentItem()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    tabItemView.setTextColor(this.mTabTextColors);
                    tabItemView.setSelected(z);
                }
            }
            this.mSlidingTabIndicator.invalidate();
        }
        for (int i2 = 0; i2 < this.mBadgeViewMap.size(); i2++) {
            BadgeView valueAt = this.mBadgeViewMap.valueAt(i2);
            if (valueAt != null) {
                if (TextUtils.isEmpty(valueAt.getText())) {
                    valueAt.setBackground(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080502));
                } else {
                    valueAt.setBackground(getResources().getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080503));
                }
            }
        }
    }
}
