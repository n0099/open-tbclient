package com.baidu.live.tbadk.core.tabhost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.tabhost.FragmentTabWidget;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.maintab.FragmentDelegate;
import com.baidu.live.tbadk.maintab.TbFragmentTabIndicator;
import com.baidu.live.tbadk.widget.CustomViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.OnTabSelectionChanged {
    public static final int BELOW_NAVIGATION = 3;
    public static final int TABBAR_COVER_BOTTOM = 2;
    public static final int VIEWPAGER_IN_BOTTOM = 0;
    public static final int VIEWPAGER_IN_TOP = 1;
    private Context mContext;
    private TabSpec mCurentTabSpec;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private OnTabSelectionListener mOnTabSelectionListener;
    private FragmentAdapter mPagerAdapter;
    private final List<TabSpec> mTabSpecs;
    private FragmentTabWidget mTabWidgetView;
    private CustomViewPager mViewPager;
    private boolean needShowThemeStyle;
    private FrameLayout tabWrapper;
    private View topDvider;
    private int wrapperHeight;

    /* loaded from: classes2.dex */
    public interface OnTabSelectionListener {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes2.dex */
    public static class TabSpec {
        public FragmentDelegate FragmentDelegate;
        public Fragment mContentFragment;
        public TbFragmentTabIndicator mIndicatorView;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.wrapperHeight = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.wrapperHeight = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(a.h.sdk_fragment_tabhost, (ViewGroup) this, true);
        this.tabWrapper = (FrameLayout) findViewById(a.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.mCurentTabSpec = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.mTabWidgetView != null) {
            this.mTabWidgetView.getLayoutParams().height = i;
            this.mTabWidgetView.requestLayout();
            this.tabWrapper.getLayoutParams().height = i;
            this.tabWrapper.requestLayout();
            this.wrapperHeight = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.tabWrapper;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.mTabWidgetView != null) {
            this.mTabWidgetView.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.mTabWidgetView != null) {
            this.mTabWidgetView.setShouldDrawTopLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.mTabWidgetView != null) {
            this.mTabWidgetView.setShouldDrawTopLine(z);
        }
    }

    public void needShowTopDiver(boolean z) {
        if (this.topDvider == null) {
            this.topDvider = findViewById(a.g.topDvider);
        }
        if (!z) {
            this.topDvider.setVisibility(8);
            return;
        }
        if (this.mTabWidgetView != null) {
            this.mTabWidgetView.setShouldDrawTopLine(false);
        }
        int dip2px = this.wrapperHeight + BdUtilHelper.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topDvider.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.topDvider.setLayoutParams(layoutParams);
        this.topDvider.setVisibility(0);
        SkinManager.setBackgroundColor(this.topDvider, a.d.sdk_cp_bg_line_b);
        if (this.mTabWidgetView != null) {
            ((FrameLayout.LayoutParams) this.mTabWidgetView.getLayoutParams()).gravity = 80;
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.mTabWidgetView = (FragmentTabWidget) findViewById(a.g.tabcontainer);
        this.mTabWidgetView.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.mTabWidgetView.setPadding(i, i2, i3, i4);
    }

    public void isTabItemNeedPadding(boolean z) {
        this.mTabWidgetView.isTabItemNeedPadding(z);
    }

    public void addTabSpec(TabSpec tabSpec) {
        addTabSpec(tabSpec, -1);
    }

    public void addTabSpec(TabSpec tabSpec, int i) {
        if (tabSpec.mIndicatorView == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (tabSpec.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(tabSpec)) {
            if (tabSpec.FragmentDelegate != null) {
                tabSpec.FragmentDelegate.onAdd();
            }
            this.mTabWidgetView.addView(tabSpec.mIndicatorView, i);
            if (i == -1) {
                this.mTabSpecs.add(tabSpec);
            } else {
                this.mTabSpecs.add(i, tabSpec);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.mViewPager != null) {
            this.mViewPager.setScrollable(z);
        }
    }

    public void initViewPager() {
        initViewPager(0);
    }

    public void initViewPager(int i) {
        if (this.mViewPager != null) {
            removeView(this.mViewPager);
        }
        this.mViewPager = new CustomViewPager(this.mContext);
        this.mViewPager.setId(a.g.sdk_tab_content);
        changeStyle(i);
        addView(this.mViewPager);
        removeView(this.tabWrapper);
        addView(this.tabWrapper);
        this.mViewPager.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.mPagerAdapter = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.mViewPager.setAdapter(this.mPagerAdapter);
    }

    public void initViewPagerWithNoType() {
        if (this.mViewPager != null) {
            removeView(this.mViewPager);
        }
        this.mViewPager = new CustomViewPager(this.mContext);
        this.mViewPager.setId(a.g.sdk_tab_content);
        addView(this.mViewPager);
        removeView(this.tabWrapper);
        addView(this.tabWrapper);
        this.mViewPager.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.mPagerAdapter = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.mViewPager.setAdapter(this.mPagerAdapter);
    }

    public void changeStyle(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.mViewPager.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.mViewPager.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.tabWrapper.getLayoutParams();
            layoutParams2.height = -2;
        }
        clearRules(layoutParams2.getRules());
        if (layoutParams != null) {
            clearRules(layoutParams.getRules());
            if (i == 1) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(12, -1);
                layoutParams.bottomMargin = 0;
            } else if (i == 0) {
                layoutParams2.addRule(10, -1);
                layoutParams.addRule(3, a.g.tabcontainer_wrapper);
                layoutParams.bottomMargin = 0;
            } else if (i == 2) {
                layoutParams2.addRule(12, -1);
                layoutParams.addRule(10, -1);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds98);
            } else if (i == 3) {
                layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds88);
            }
            this.mViewPager.setLayoutParams(layoutParams);
        }
        this.tabWrapper.setLayoutParams(layoutParams2);
    }

    private void clearRules(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = 0;
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setOnTabSelectionListener(OnTabSelectionListener onTabSelectionListener) {
        this.mOnTabSelectionListener = onTabSelectionListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mTabSpecs.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.mCurentTabSpec = this.mTabSpecs.get(this.mCurrentTabIndex);
            this.mTabWidgetView.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.mViewPager != null) {
                this.mViewPager.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.mTabSpecs.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.mTabSpecs.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.mCurrentTabIndex == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.live.tbadk.core.tabhost.FragmentTabWidget.OnTabSelectionChanged
    public void onTabSelectionChanged(int i, boolean z) {
        this.mCurentTabSpec = this.mTabSpecs.get(i);
        if (this.mOnTabSelectionListener == null || this.mOnTabSelectionListener.onPreTabSelectionChange(i, z)) {
            if (this.mOnTabSelectionListener != null) {
                this.mOnTabSelectionListener.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.mTabWidgetView.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.mTabSpecs.size()) {
            return -1;
        }
        return this.mTabSpecs.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.mCurentTabSpec != null) {
            return this.mCurentTabSpec.mContentFragment;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.mTabWidgetView;
    }

    public TabSpec getTabSpec(int i) {
        if (i < 0 || i >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(i);
    }

    public TabSpec getTabSpecByType(int i) {
        for (TabSpec tabSpec : this.mTabSpecs) {
            if (i == tabSpec.mType) {
                return tabSpec;
            }
        }
        return null;
    }

    public void reset() {
        if (this.mViewPager != null && this.mPagerAdapter != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.mTabSpecs.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.mPagerAdapter.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (TabSpec tabSpec : this.mTabSpecs) {
                if (tabSpec.FragmentDelegate != null) {
                    tabSpec.FragmentDelegate.onRemove();
                }
            }
            this.mTabSpecs.clear();
            this.mCurentTabSpec = null;
            this.mCurrentTabIndex = -1;
            this.mTabWidgetView.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        new BitmapDrawable(SkinManager.getBitmap565Quality(a.f.sdk_s_tabbar_bg));
        SkinManager.setBackgroundColor(this.tabWrapper, a.d.sdk_cp_bg_line_d);
        this.mTabWidgetView.onChangeSkinType(i);
        if (this.topDvider != null) {
            SkinManager.setBackgroundColor(this.topDvider, a.d.sdk_cp_bg_line_b);
        }
        for (TabSpec tabSpec : this.mTabSpecs) {
            tabSpec.mIndicatorView.onChangeSkin(i);
        }
        if (this.mPagerAdapter != null) {
            int count = this.mPagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.mPagerAdapter.getItem(i2);
                if (item != null && (item instanceof BaseFragment)) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.mTabWidgetView.changeLeft(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.mCurrentTabIndex = i;
        this.mCurentTabSpec = this.mTabSpecs.get(i);
        this.mTabWidgetView.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.mCurentTabSpec.mContentFragment.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).refreshMatrix(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private int mPrimaryPosition;
        private List<TabSpec> specs;

        public FragmentAdapter(FragmentManager fragmentManager, List<TabSpec> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.specs = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.specs.get(i).mContentFragment;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.specs.get(i).mContentFragment.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.specs.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.mPrimaryPosition != i) {
                if (this.mPrimaryPosition != -1) {
                    ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.needShowThemeStyle = z;
    }

    public void showTabWidget() {
        if (this.tabWrapper != null && this.tabWrapper.getVisibility() != 0) {
            this.tabWrapper.setVisibility(0);
        }
    }

    public void hideTabWidget() {
        if (this.tabWrapper != null && this.tabWrapper.getVisibility() != 8) {
            this.tabWrapper.setVisibility(8);
        }
    }
}
