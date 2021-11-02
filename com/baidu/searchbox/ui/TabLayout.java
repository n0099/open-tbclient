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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.view.BadgeFactory;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class TabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INDICATOR_HEIGHT_DIPS = 2;
    public static final int TAB_ITEM_DISTANCE_DIPS = 1;
    public static final int TAB_ITEM_TEXT_SIZE_DIPS = 14;
    public static final int TAB_ITEM_VIEW_PADDING_DIPS = 11;
    public static final String TAG = "SlidingTabLayout";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public class InternalViewPagerListener implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsUserDrag;
        public int mScrollState;
        public final /* synthetic */ TabLayout this$0;

        public InternalViewPagerListener(TabLayout tabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
            this.mIsUserDrag = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                boolean z = true;
                if (i2 != 1 && (this.mScrollState != 1 || i2 != 2)) {
                    z = false;
                }
                this.mIsUserDrag = z;
                this.mScrollState = i2;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (childCount = this.this$0.mSlidingTabIndicator.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            this.this$0.mSlidingTabIndicator.setIndicatorPositionFromTabPosition(i2, f2);
            if (this.mIsUserDrag) {
                this.this$0.gradualChangeTabView(i2, f2);
            }
            this.this$0.scrollToTab(i2, f2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.this$0.mSelectedTabPosition != i2) {
                    this.this$0.selectTab(i2, false);
                }
                this.mIsUserDrag = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class TabClickListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int clickPos;
        public final /* synthetic */ TabLayout this$0;

        public TabClickListener(TabLayout tabLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tabLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tabLayout;
            this.clickPos = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.this$0.selectTab(this.clickPos, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface TabSelectedListener {
        void onTabReselected(int i2);

        void onTabSelected(int i2, boolean z);

        void onTabUnselected(int i2, boolean z);
    }

    /* loaded from: classes7.dex */
    public static class TabSelectedListenerAdapter implements TabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TabSelectedListenerAdapter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabReselected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabSelected(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListener
        public void onTabUnselected(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int calculateScrollXForTab(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            View childAt = this.mSlidingTabIndicator.getChildAt(i2);
            int i3 = i2 + 1;
            View childAt2 = i3 < this.mSlidingTabIndicator.getChildCount() ? this.mSlidingTabIndicator.getChildAt(i3) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = ((childAt != null ? childAt.getLeft() : 0) + (width / 2)) - (getWidth() / 2);
            int i4 = (int) ((width + width2) * 0.5f * f2);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
        }
        return invokeCommon.intValue;
    }

    private ColorStateList createColorStateList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i2, i3)) == null) ? new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2}) : (ColorStateList) invokeII.objValue;
    }

    private BadgeView createDot(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i2)) == null) {
            if (i2 > 0) {
                BadgeView createMenuBadge = BadgeFactory.createMenuBadge(getContext());
                createMenuBadge.setBadgeCount(i2);
                return createMenuBadge;
            }
            BadgeView createDot = BadgeFactory.createDot(getContext());
            createDot.setBadgeMargin(0, 8, 8, 0);
            return createDot;
        }
        return (BadgeView) invokeI.objValue;
    }

    private TextView createTabItemView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            TextView textView = new TextView(getContext());
            textView.setSingleLine();
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
            if (i2 == 0) {
                marginLayoutParams.setMargins(this.mTabPaddingStart, 0, (int) (this.mTabItemDistance / 2.0f), 0);
            } else if (i2 == getTabCount() - 1) {
                marginLayoutParams.setMargins((int) (this.mTabItemDistance / 2.0f), 0, this.mTabPaddingEnd, 0);
            } else {
                float f2 = this.mTabItemDistance;
                marginLayoutParams.setMargins((int) (f2 / 2.0f), 0, (int) (f2 / 2.0f), 0);
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
        return (TextView) invokeI.objValue;
    }

    private void dispatchTabReSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
                this.mTabSelectedListenerList.get(size).onTabReselected(i2);
            }
        }
    }

    private void dispatchTabSelected(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
                this.mTabSelectedListenerList.get(size).onTabSelected(i2, z);
            }
        }
    }

    private void dispatchTabUnSelected(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int size = this.mTabSelectedListenerList.size() - 1; size >= 0; size--) {
                this.mTabSelectedListenerList.get(size).onTabUnselected(i2, z);
            }
        }
    }

    private int dpToPx(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, this, i2)) == null) ? Math.round(getResources().getDisplayMetrics().density * i2) : invokeI.intValue;
    }

    private float getFontHeight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65555, this, f2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(f2);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            return (float) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
        }
        return invokeF.floatValue;
    }

    private int getTabCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            PagerAdapter pagerAdapter = this.mPagerAdapter;
            if (pagerAdapter != null) {
                return pagerAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private TextView getTabItemView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, this, i2)) == null) {
            ArrayList<TextView> arrayList = this.mTabItemViewList;
            if (arrayList == null || i2 >= arrayList.size() || i2 < 0) {
                return null;
            }
            return this.mTabItemViewList.get(i2);
        }
        return (TextView) invokeI.objValue;
    }

    private int getTabTextColorByRatio(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? ((Integer) new ArgbEvaluator().evaluate(f2, Integer.valueOf(getTabTextSelectedColor()), Integer.valueOf(getTabTextNormalColor()))).intValue() : invokeCommon.intValue;
    }

    private int getTabTextNormalColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            ColorStateList colorStateList = this.mTabTextColors;
            if (colorStateList == null) {
                return -7829368;
            }
            return colorStateList.getDefaultColor();
        }
        return invokeV.intValue;
    }

    private float getTabTextScaleByRatio(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65560, this, f2)) == null) ? (f2 * 1.0f) + ((this.mSelectedFontHeight / this.mUnSelectedFontHeight) * (1.0f - f2)) : invokeF.floatValue;
    }

    private int getTabTextSelectedColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            ColorStateList colorStateList = this.mTabTextColors;
            if (colorStateList == null) {
                return -16777216;
            }
            return colorStateList.getColorForState(new int[]{16842913}, getTabTextNormalColor());
        }
        return invokeV.intValue;
    }

    private float getTabTextTranslationY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65562, this, f2)) == null) ? ((-(this.mSelectedFontHeight - this.mUnSelectedFontHeight)) / 2.0f) * (1.0f - f2) : invokeF.floatValue;
    }

    private void gradualChangeTabItemView(TextView textView, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{textView, Float.valueOf(f2), Integer.valueOf(i2)}) == null) || textView == null) {
            return;
        }
        textView.setTextColor(getTabTextColorByRatio(f2, i2));
        float tabTextScaleByRatio = getTabTextScaleByRatio(f2);
        textView.setScaleX(tabTextScaleByRatio);
        textView.setScaleY(tabTextScaleByRatio);
        float tabTextTranslationY = getTabTextTranslationY(f2);
        textView.setTranslationY(tabTextTranslationY);
        BadgeView badgeView = this.mBadgeViewMap.get(i2);
        if (badgeView == null || badgeView.getVisibility() != 0) {
            return;
        }
        badgeView.setTranslationY(tabTextTranslationY * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gradualChangeTabView(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (i2 >= 0 && i2 < this.mSlidingTabIndicator.getChildCount()) {
                gradualChangeTabItemView(getTabItemView(i2), f2, i2);
            }
            int i3 = i2 + 1;
            if (i3 < 0 || i3 >= this.mSlidingTabIndicator.getChildCount()) {
                return;
            }
            gradualChangeTabItemView(getTabItemView(i3), 1.0f - f2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populateFromPagerAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.mTabItemViewList.clear();
            this.mBadgeViewMap.clear();
            this.mSlidingTabIndicator.removeAllViews();
            for (int i2 = 0; i2 < getTabCount(); i2++) {
                TextView createTabItemView = createTabItemView(i2);
                createTabItemView.setOnClickListener(new TabClickListener(this, i2));
                updateTabItemView(createTabItemView, false);
                PagerAdapter pagerAdapter = this.mPagerAdapter;
                if (pagerAdapter != null && !TextUtils.isEmpty(pagerAdapter.getPageTitle(i2))) {
                    createTabItemView.setText(this.mPagerAdapter.getPageTitle(i2));
                }
                this.mSlidingTabIndicator.addView(createTabItemView);
                this.mTabItemViewList.add(createTabItemView);
            }
            ViewPager viewPager = this.mViewPager;
            selectTab(viewPager != null ? viewPager.getCurrentItem() : -1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToTab(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int childCount = this.mSlidingTabIndicator.getChildCount();
            if (!this.mIsEnableSlide || childCount == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            smoothScrollTo(calculateScrollXForTab(i2, f2), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectTab(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            int i3 = this.mSelectedTabPosition;
            if (i3 == i2) {
                dispatchTabReSelected(i2);
                return;
            }
            this.mSelectedTabPosition = i2;
            dispatchTabUnSelected(i3, z);
            updateTabItemView(getTabItemView(i3), false);
            updateTabItemView(getTabItemView(i2), true);
            if (z) {
                this.mSlidingTabIndicator.setIndicatorPositionFromTabPosition(i2, 0.0f);
                scrollToTab(i2, 0.0f);
            }
            dispatchTabSelected(i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65568, this, pagerAdapter, z) == null) {
            PagerAdapter pagerAdapter2 = this.mPagerAdapter;
            if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
                pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
            this.mPagerAdapter = pagerAdapter;
            if (z && pagerAdapter != null) {
                if (this.mPagerAdapterObserver == null) {
                    this.mPagerAdapterObserver = new DataSetObserver(this) { // from class: com.baidu.searchbox.ui.TabLayout.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TabLayout this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // android.database.DataSetObserver
                        public void onChanged() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.populateFromPagerAdapter();
                            }
                        }

                        @Override // android.database.DataSetObserver
                        public void onInvalidated() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.this$0.populateFromPagerAdapter();
                            }
                        }
                    };
                }
                pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
            }
            populateFromPagerAdapter();
        }
    }

    private void updateTabItemView(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65569, this, textView, z) == null) || textView == null) {
            return;
        }
        textView.setTextSize(0, z ? this.mSelectedTextSize : this.mUnSelectedTextSize);
        textView.setTextColor(this.mTabTextColors);
        textView.setSelected(z);
        textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        textView.setScaleX(getTabTextScaleByRatio(z ? 0.0f : 1.0f));
        textView.setScaleY(getTabTextScaleByRatio(z ? 0.0f : 1.0f));
        textView.setTranslationY(getTabTextTranslationY(z ? 0.0f : 1.0f));
    }

    public void addOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tabSelectedListener) == null) || this.mTabSelectedListenerList.contains(tabSelectedListener)) {
            return;
        }
        this.mTabSelectedListenerList.add(tabSelectedListener);
    }

    public void clearOnTabSelectedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTabSelectedListenerList.clear();
        }
    }

    public void enableSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mIsEnableSlide = z;
        }
    }

    public int getSelectedTabPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSelectedTabPosition : invokeV.intValue;
    }

    public void hideRedDot(int i2) {
        BadgeView badgeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (badgeView = this.mBadgeViewMap.get(i2)) == null) {
            return;
        }
        badgeView.setVisibility(4);
    }

    public void removeOnTabSelectedListener(@NonNull TabSelectedListener tabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tabSelectedListener) == null) {
            this.mTabSelectedListenerList.remove(tabSelectedListener);
        }
    }

    public void setDistributeEvenly(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mDistributeEvenly = z;
        }
    }

    public void setIndicatorColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mSlidingTabIndicator.setIndicatorColor(i2);
        }
    }

    public void setTabTextColors(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            setTabTextColors(createColorStateList(i2, i3));
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        ViewPager viewPager2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, viewPager) == null) || (viewPager2 = this.mViewPager) == viewPager) {
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
                this.mCurrentVpSelectedListener = new TabSelectedListenerAdapter(this) { // from class: com.baidu.searchbox.ui.TabLayout.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TabLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.ui.TabLayout.TabSelectedListenerAdapter, com.baidu.searchbox.ui.TabLayout.TabSelectedListener
                    public void onTabSelected(int i2, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.this$0.mViewPager == null) {
                            return;
                        }
                        this.this$0.mViewPager.setCurrentItem(i2, false);
                    }
                };
            }
            addOnTabSelectedListener(this.mCurrentVpSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, true);
            }
            if (this.mOnAdapterChangeListener == null) {
                this.mOnAdapterChangeListener = new ViewPager.OnAdapterChangeListener(this) { // from class: com.baidu.searchbox.ui.TabLayout.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TabLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
                    public void onAdapterChanged(@NonNull ViewPager viewPager3, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, viewPager3, pagerAdapter, pagerAdapter2) == null) {
                            this.this$0.setPagerAdapter(pagerAdapter2, true);
                        }
                    }
                };
            }
            viewPager.addOnAdapterChangeListener(this.mOnAdapterChangeListener);
            return;
        }
        setPagerAdapter(null, false);
    }

    public void showRedDot(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            showRedDot(i2, 0);
        }
    }

    public void updateAllTabsUIStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.mViewPager != null) {
                int i2 = 0;
                while (i2 < getTabCount()) {
                    TextView tabItemView = getTabItemView(i2);
                    if (tabItemView != null) {
                        boolean z = i2 == this.mViewPager.getCurrentItem();
                        tabItemView.setTextColor(this.mTabTextColors);
                        tabItemView.setSelected(z);
                    }
                    i2++;
                }
                this.mSlidingTabIndicator.invalidate();
            }
            for (int i3 = 0; i3 < this.mBadgeViewMap.size(); i3++) {
                BadgeView valueAt = this.mBadgeViewMap.valueAt(i3);
                if (valueAt != null) {
                    if (TextUtils.isEmpty(valueAt.getText())) {
                        valueAt.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.common_badge));
                    } else {
                        valueAt.setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.common_badge_default_bg));
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, colorStateList) == null) || this.mTabTextColors == colorStateList) {
            return;
        }
        this.mTabTextColors = colorStateList;
        updateAllTabsUIStyle();
    }

    public void showRedDot(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            BadgeView badgeView = this.mBadgeViewMap.get(i2);
            if (badgeView == null) {
                badgeView = createDot(i3);
                badgeView.bindView(getTabItemView(i2));
                this.mBadgeViewMap.put(i2, badgeView);
            } else if ((badgeView.getBadgeCount() == null && i3 > 0) || (badgeView.getBadgeCount() != null && badgeView.getBadgeCount().intValue() != i3)) {
                badgeView.unbind();
                this.mBadgeViewMap.remove(i2);
                badgeView = createDot(i3);
                badgeView.bindView(getTabItemView(i2));
                this.mBadgeViewMap.put(i2, badgeView);
            }
            badgeView.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
            this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
            this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingTop, this.mTabPaddingTop);
            this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingEnd, this.mTabPaddingEnd);
            this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabPaddingBottom, this.mTabPaddingBottom);
            this.mTabItemDistance = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabDistance, dpToPx(1));
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(com.baidu.android.common.ui.R.styleable.TabLayout_tabTextColors);
            this.mTabTextColors = colorStateList;
            if (colorStateList == null) {
                this.mTabTextColors = createColorStateList(getTabTextNormalColor(), getTabTextSelectedColor());
            }
            this.mSelectedTextSize = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_tabTextSize, dpToPx(14));
            this.mIndicatorColor = obtainStyledAttributes.getColor(com.baidu.android.common.ui.R.styleable.TabLayout_tabLayout_indicatorColor, this.mIndicatorColor);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(com.baidu.android.common.ui.R.styleable.TabLayout_indicatorHeight, dpToPx(2));
            obtainStyledAttributes.recycle();
        }
        float f2 = this.mSelectedTextSize;
        this.mUnSelectedTextSize = f2;
        this.mSelectedFontHeight = getFontHeight(f2);
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

    public void showRedDot(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, str) == null) {
            BadgeView badgeView = this.mBadgeViewMap.get(i2);
            if (badgeView != null) {
                badgeView.unbind();
                this.mBadgeViewMap.remove(i2);
            }
            BadgeView createMenuBadge = BadgeFactory.createMenuBadge(getContext());
            createMenuBadge.bindView(getTabItemView(i2));
            createMenuBadge.setBadgeMargin(0, 1, 0, 0);
            createMenuBadge.setText(str);
            this.mBadgeViewMap.put(i2, createMenuBadge);
            createMenuBadge.setVisibility(0);
        }
    }
}
