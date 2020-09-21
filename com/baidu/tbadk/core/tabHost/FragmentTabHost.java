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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget ekL;
    private com.baidu.tbadk.core.tabHost.a ekM;
    private FragmentTabSwellingView ekN;
    private b ekO;
    private CustomViewPager ekP;
    private a ekQ;
    private FragmentAdapter ekR;
    private LinearLayout ekS;
    private View ekT;
    private int ekU;
    private int ekV;
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
        public TbFragmentTabIndicator ekW;
        public com.baidu.tbadk.mainTab.b ekX;
        public Fragment mContentFragment;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ekU = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ekU = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.ekS = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.ekT = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.ekO = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.ekU = R.drawable.bottom_bar_background;
                setShouldDrawTopLine(false);
                needShowTopDiver(false);
            } else if (this.mType == 0) {
                this.ekU = R.color.cp_bg_line_h;
                setShouldDrawTopLine(true);
                needShowTopDiver(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.ekT.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.ekL != null) {
            this.ekL.getLayoutParams().height = i;
            this.ekL.requestLayout();
            this.ekS.getLayoutParams().height = i;
            this.ekS.requestLayout();
            if (this.ekV == 1) {
                this.ekN.getLayoutParams().height = i;
                this.ekN.requestLayout();
            }
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.ekL != null) {
            this.ekL.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.ekL != null) {
            this.ekL.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.ekL != null) {
            this.ekL.setShouldDrawTopLine(z);
        }
    }

    public void setBackGroundStyle(int i) {
        this.ekV = i;
        if (this.ekL != null) {
            this.ekL.setBackGroundStyle(i);
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
        if (this.ekL != null) {
            this.ekL.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.topDvider.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.topDvider.setLayoutParams(layoutParams);
        this.topDvider.setVisibility(0);
        ap.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ((FrameLayout.LayoutParams) this.ekL.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.ekL != null) {
            this.ekL.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.ekM == null) {
            this.ekM = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        needShowTopDiver(false);
        this.ekM.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.ekL = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.ekN = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.ekL.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.ekL.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.ekW == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.ekX != null) {
                bVar.ekX.onAdd();
            }
            this.ekL.addView(bVar.ekW, i);
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
        if (bVar.ekW == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.ekX != null) {
                bVar.ekX.onAdd();
            }
            this.ekL.addView(bVar.ekW, i, z);
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
        if (this.ekP != null) {
            this.ekP.setScrollable(z);
        }
    }

    public void initViewPager() {
        initViewPager(0);
    }

    public void initViewPager(int i) {
        if (this.ekP != null) {
            removeView(this.ekP);
        }
        this.ekP = new CustomViewPager(this.mContext);
        this.ekP.setId(R.id.tab_content);
        changeStyle(i);
        addView(this.ekP);
        removeView(this.ekS);
        addView(this.ekS);
        removeView(this.ekT);
        addView(this.ekT);
        this.ekP.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.ekP.setOnPageChangeListener(this);
        this.ekR = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.ekP.setAdapter(this.ekR);
    }

    public void initViewPagerWithNoType() {
        if (this.ekP != null) {
            removeView(this.ekP);
        }
        this.ekP = new CustomViewPager(this.mContext);
        this.ekP.setId(R.id.tab_content);
        addView(this.ekP);
        removeView(this.ekS);
        addView(this.ekS);
        this.ekP.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.ekP.setOnPageChangeListener(this);
        this.ekR = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.ekP.setAdapter(this.ekR);
    }

    public void changeStyle(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.ekP.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.ekP.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.ekS.getLayoutParams();
            layoutParams2.height = -2;
        }
        clearRules(layoutParams.getRules());
        clearRules(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.ekS.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.ekS.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.ekS.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.mContext, R.dimen.ds88);
            this.ekS.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.ekS.setVisibility(8);
        }
        this.ekP.setLayoutParams(layoutParams);
        this.ekS.setLayoutParams(layoutParams2);
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
        this.ekQ = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mTabSpecs.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.ekO = this.mTabSpecs.get(this.mCurrentTabIndex);
            this.ekL.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.ekP != null) {
                this.ekP.setCurrentItem(this.mCurrentTabIndex, false);
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
        this.ekO = this.mTabSpecs.get(i);
        if (this.ekQ == null || this.ekQ.onPreTabSelectionChange(i, z)) {
            if (this.ekQ != null) {
                this.ekQ.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.ekL.setBackgroundColor(i);
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
        if (this.ekO != null) {
            return this.ekO.mContentFragment;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.ekP;
    }

    public ViewGroup getTabWrapper() {
        return this.ekS;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.ekL;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.ekL != null) {
            this.ekL.setAbsoluteWeight(z);
        }
    }

    public b nX(int i) {
        if (i < 0 || i >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(i);
    }

    public b nY(int i) {
        for (b bVar : this.mTabSpecs) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.ekP != null && this.ekR != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.mTabSpecs.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.ekP.getId(), this.ekR.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.mTabSpecs) {
                if (bVar.ekX != null) {
                    bVar.ekX.onRemove();
                }
            }
            this.mTabSpecs.clear();
            this.ekO = null;
            this.mCurrentTabIndex = -1;
            this.ekL.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.ekL.onChangeSkinType(i);
        this.ekN.onChangeSkinType(i);
        ap.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.ekT, R.drawable.bottom_view_shadow);
        for (b bVar : this.mTabSpecs) {
            bVar.ekW.onChangeSkin(i);
            bVar.ekW.setSelected(bVar.ekW.isSelected());
        }
        if (this.ekR != null) {
            int count = this.ekR.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ekR.getItem(i2);
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
        this.ekL.changeLeft(i, f);
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
        this.ekO = this.mTabSpecs.get(i);
        this.ekL.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.ekO.mContentFragment.getView();
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
        if (this.ekS != null && this.ekS.getVisibility() != 0) {
            this.ekS.setVisibility(0);
        }
    }

    public void hideTabWidget() {
        if (this.ekS != null && this.ekS.getVisibility() != 8) {
            this.ekS.setVisibility(8);
        }
    }
}
