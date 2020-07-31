package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget dYM;
    private com.baidu.tbadk.core.tabHost.a dYN;
    private FragmentTabSwellingView dYO;
    private b dYP;
    private CustomViewPager dYQ;
    private a dYR;
    private FragmentAdapter dYS;
    private LinearLayout dYT;
    private View dYU;
    private int dYV;
    private int dYW;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private final List<b> mTabSpecs;
    private int mType;
    private boolean needShowThemeStyle;
    private View topDvider;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator dYX;
        public com.baidu.tbadk.mainTab.b dYY;
        public Fragment mContentFragment;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.dYV = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.dYV = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.dYT = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.dYU = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.dYP = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.dYV = R.drawable.bottom_bar_background;
                setShouldDrawTopLine(false);
                needShowTopDiver(false);
            } else if (this.mType == 0) {
                this.dYV = R.color.cp_bg_line_h;
                setShouldDrawTopLine(true);
                needShowTopDiver(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.dYU.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.dYM != null) {
            this.dYM.getLayoutParams().height = i;
            this.dYM.requestLayout();
            this.dYT.getLayoutParams().height = i;
            this.dYT.requestLayout();
            if (this.dYW == 1) {
                this.dYO.getLayoutParams().height = i;
                this.dYO.requestLayout();
            }
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.dYM != null) {
            this.dYM.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.dYM != null) {
            this.dYM.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.dYM != null) {
            this.dYM.setShouldDrawTopLine(z);
        }
    }

    public void setBackGroundStyle(int i) {
        this.dYW = i;
        if (this.dYM != null) {
            this.dYM.setBackGroundStyle(i);
        }
    }

    public void needShowTopDiver(boolean z) {
        if (this.topDvider == null) {
            this.topDvider = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.topDvider.setVisibility(8);
            return;
        }
        if (this.dYM != null) {
            this.dYM.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.topDvider.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.topDvider.setLayoutParams(layoutParams);
        this.topDvider.setVisibility(0);
        ao.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ((FrameLayout.LayoutParams) this.dYM.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.dYM != null) {
            this.dYM.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.dYN == null) {
            this.dYN = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        needShowTopDiver(false);
        this.dYN.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.dYM = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.dYO = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.dYM.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.dYM.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.dYX == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.dYY != null) {
                bVar.dYY.onAdd();
            }
            this.dYM.addView(bVar.dYX, i);
            if (i == -1) {
                this.mTabSpecs.add(bVar);
            } else {
                this.mTabSpecs.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.dYX == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.dYY != null) {
                bVar.dYY.onAdd();
            }
            this.dYM.addView(bVar.dYX, i, z);
            if (i == -1) {
                this.mTabSpecs.add(bVar);
            } else {
                this.mTabSpecs.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.dYQ != null) {
            this.dYQ.setScrollable(z);
        }
    }

    public void initViewPager() {
        initViewPager(0);
    }

    public void initViewPager(int i) {
        if (this.dYQ != null) {
            removeView(this.dYQ);
        }
        this.dYQ = new CustomViewPager(this.mContext);
        this.dYQ.setId(R.id.tab_content);
        changeStyle(i);
        addView(this.dYQ);
        removeView(this.dYT);
        addView(this.dYT);
        removeView(this.dYU);
        addView(this.dYU);
        this.dYQ.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.dYQ.setOnPageChangeListener(this);
        this.dYS = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.dYQ.setAdapter(this.dYS);
    }

    public void initViewPagerWithNoType() {
        if (this.dYQ != null) {
            removeView(this.dYQ);
        }
        this.dYQ = new CustomViewPager(this.mContext);
        this.dYQ.setId(R.id.tab_content);
        addView(this.dYQ);
        removeView(this.dYT);
        addView(this.dYT);
        this.dYQ.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.dYQ.setOnPageChangeListener(this);
        this.dYS = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.dYQ.setAdapter(this.dYS);
    }

    public void changeStyle(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.dYQ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.dYQ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.dYT.getLayoutParams();
            layoutParams2.height = -2;
        }
        clearRules(layoutParams.getRules());
        clearRules(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.dYT.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.dYT.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.dYT.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.mContext, R.dimen.ds88);
            this.dYT.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.dYT.setVisibility(8);
        }
        this.dYQ.setLayoutParams(layoutParams);
        this.dYT.setLayoutParams(layoutParams2);
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

    public void setOnTabSelectionListener(a aVar) {
        this.dYR = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mTabSpecs.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.dYP = this.mTabSpecs.get(this.mCurrentTabIndex);
            this.dYM.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.dYQ != null) {
                this.dYQ.setCurrentItem(this.mCurrentTabIndex, false);
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

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void onTabSelectionChanged(int i, boolean z) {
        this.dYP = this.mTabSpecs.get(i);
        if (this.dYR == null || this.dYR.onPreTabSelectionChange(i, z)) {
            if (this.dYR != null) {
                this.dYR.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.dYM.setBackgroundColor(i);
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
        if (this.dYP != null) {
            return this.dYP.mContentFragment;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.dYQ;
    }

    public ViewGroup getTabWrapper() {
        return this.dYT;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.dYM;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.dYM != null) {
            this.dYM.setAbsoluteWeight(z);
        }
    }

    public b lF(int i) {
        if (i < 0 || i >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(i);
    }

    public b lG(int i) {
        for (b bVar : this.mTabSpecs) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.dYQ != null && this.dYS != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.mTabSpecs.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.dYQ.getId(), this.dYS.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.mTabSpecs) {
                if (bVar.dYY != null) {
                    bVar.dYY.onRemove();
                }
            }
            this.mTabSpecs.clear();
            this.dYP = null;
            this.mCurrentTabIndex = -1;
            this.dYM.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.dYM.onChangeSkinType(i);
        this.dYO.onChangeSkinType(i);
        ao.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.dYU, R.drawable.bottom_view_shadow);
        for (b bVar : this.mTabSpecs) {
            bVar.dYX.onChangeSkin(i);
            bVar.dYX.setSelected(bVar.dYX.isSelected());
        }
        if (this.dYS != null) {
            int count = this.dYS.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.dYS.getItem(i2);
                if (item instanceof BaseFragment) {
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
        this.dYM.changeLeft(i, f);
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
        this.dYP = this.mTabSpecs.get(i);
        this.dYM.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.dYP.mContentFragment.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).refreshMatrix(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private int mPrimaryPosition;
        private List<b> specs;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
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
                    Fragment item = getItem(this.mPrimaryPosition);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            try {
                super.finishUpdate(viewGroup);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.needShowThemeStyle = z;
    }

    public void showTabWidget() {
        if (this.dYT != null && this.dYT.getVisibility() != 0) {
            this.dYT.setVisibility(0);
        }
    }

    public void hideTabWidget() {
        if (this.dYT != null && this.dYT.getVisibility() != 8) {
            this.dYT.setVisibility(8);
        }
    }
}
