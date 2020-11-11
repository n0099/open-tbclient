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
    private FragmentTabWidget eLh;
    private com.baidu.tbadk.core.tabHost.a eLi;
    private FragmentTabSwellingView eLj;
    private b eLk;
    private CustomViewPager eLl;
    private a eLm;
    private FragmentAdapter eLn;
    private LinearLayout eLo;
    private View eLp;
    private int eLq;
    private int eLr;
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
        public TbFragmentTabIndicator eLs;
        public com.baidu.tbadk.mainTab.b eLt;
        public Fragment mContentFragment;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.eLq = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.eLq = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.eLo = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.eLp = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.eLk = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.eLq = R.drawable.bottom_bar_background;
                setShouldDrawTopLine(false);
                needShowTopDiver(false);
            } else if (this.mType == 0) {
                this.eLq = R.color.cp_bg_line_h;
                setShouldDrawTopLine(true);
                needShowTopDiver(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.eLp.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.eLh != null) {
            this.eLh.getLayoutParams().height = i;
            this.eLh.requestLayout();
            this.eLo.getLayoutParams().height = i;
            this.eLo.requestLayout();
            if (this.eLr == 1) {
                this.eLj.getLayoutParams().height = i;
                this.eLj.requestLayout();
            }
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.eLh != null) {
            this.eLh.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.eLh != null) {
            this.eLh.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.eLh != null) {
            this.eLh.setShouldDrawTopLine(z);
        }
    }

    public void setBackGroundStyle(int i) {
        this.eLr = i;
        if (this.eLh != null) {
            this.eLh.setBackGroundStyle(i);
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
        if (this.eLh != null) {
            this.eLh.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.topDvider.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.topDvider.setLayoutParams(layoutParams);
        this.topDvider.setVisibility(0);
        ap.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ((FrameLayout.LayoutParams) this.eLh.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.eLh != null) {
            this.eLh.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.eLi == null) {
            this.eLi = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        needShowTopDiver(false);
        this.eLi.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.eLh = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.eLj = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.eLh.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.eLh.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.eLs == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.eLt != null) {
                bVar.eLt.onAdd();
            }
            this.eLh.addView(bVar.eLs, i);
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
        if (bVar.eLs == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.eLt != null) {
                bVar.eLt.onAdd();
            }
            this.eLh.addView(bVar.eLs, i, z);
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
        if (this.eLl != null) {
            this.eLl.setScrollable(z);
        }
    }

    public void initViewPager() {
        initViewPager(0);
    }

    public void initViewPager(int i) {
        if (this.eLl != null) {
            removeView(this.eLl);
        }
        this.eLl = new CustomViewPager(this.mContext);
        this.eLl.setId(R.id.tab_content);
        changeStyle(i);
        addView(this.eLl);
        removeView(this.eLo);
        addView(this.eLo);
        removeView(this.eLp);
        addView(this.eLp);
        this.eLl.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.eLl.setOnPageChangeListener(this);
        this.eLn = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.eLl.setAdapter(this.eLn);
    }

    public void initViewPagerWithNoType() {
        if (this.eLl != null) {
            removeView(this.eLl);
        }
        this.eLl = new CustomViewPager(this.mContext);
        this.eLl.setId(R.id.tab_content);
        addView(this.eLl);
        removeView(this.eLo);
        addView(this.eLo);
        this.eLl.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.eLl.setOnPageChangeListener(this);
        this.eLn = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.eLl.setAdapter(this.eLn);
    }

    public void changeStyle(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.eLl.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.eLl.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.eLo.getLayoutParams();
            layoutParams2.height = -2;
        }
        clearRules(layoutParams.getRules());
        clearRules(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.eLo.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.eLo.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.eLo.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.mContext, R.dimen.ds88);
            this.eLo.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.eLo.setVisibility(8);
        }
        this.eLl.setLayoutParams(layoutParams);
        this.eLo.setLayoutParams(layoutParams2);
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
        this.eLm = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mTabSpecs.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.eLk = this.mTabSpecs.get(this.mCurrentTabIndex);
            this.eLh.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.eLl != null) {
                this.eLl.setCurrentItem(this.mCurrentTabIndex, false);
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
        this.eLk = this.mTabSpecs.get(i);
        if (this.eLm == null || this.eLm.onPreTabSelectionChange(i, z)) {
            if (this.eLm != null) {
                this.eLm.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.eLh.setBackgroundColor(i);
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
        if (this.eLk != null) {
            return this.eLk.mContentFragment;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.eLl;
    }

    public ViewGroup getTabWrapper() {
        return this.eLo;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.eLh;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.eLh != null) {
            this.eLh.setAbsoluteWeight(z);
        }
    }

    public b oP(int i) {
        if (i < 0 || i >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(i);
    }

    public b oQ(int i) {
        for (b bVar : this.mTabSpecs) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.eLl != null && this.eLn != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.mTabSpecs.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.eLl.getId(), this.eLn.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.mTabSpecs) {
                if (bVar.eLt != null) {
                    bVar.eLt.onRemove();
                }
            }
            this.mTabSpecs.clear();
            this.eLk = null;
            this.mCurrentTabIndex = -1;
            this.eLh.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.eLh.onChangeSkinType(i);
        this.eLj.onChangeSkinType(i);
        ap.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eLp, R.drawable.bottom_view_shadow);
        for (b bVar : this.mTabSpecs) {
            bVar.eLs.onChangeSkin(i);
            bVar.eLs.setSelected(bVar.eLs.isSelected());
        }
        if (this.eLn != null) {
            int count = this.eLn.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.eLn.getItem(i2);
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
        this.eLh.changeLeft(i, f);
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
        this.eLk = this.mTabSpecs.get(i);
        this.eLh.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.eLk.mContentFragment.getView();
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
        if (this.eLo != null && this.eLo.getVisibility() != 0) {
            this.eLo.setVisibility(0);
        }
    }

    public void hideTabWidget() {
        if (this.eLo != null && this.eLo.getVisibility() != 8) {
            this.eLo.setVisibility(8);
        }
    }
}
