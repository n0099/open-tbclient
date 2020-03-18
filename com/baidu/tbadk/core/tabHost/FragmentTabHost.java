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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget cYk;
    private com.baidu.tbadk.core.tabHost.a cYl;
    private FragmentTabSwellingView cYm;
    private b cYn;
    private CustomViewPager cYo;
    private a cYp;
    private FragmentAdapter cYq;
    private LinearLayout cYr;
    private View cYs;
    private int cYt;
    private int cYu;
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
        public TbFragmentTabIndicator cYv;
        public com.baidu.tbadk.mainTab.b cYw;
        public Fragment mContentFragment;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.cYt = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needShowThemeStyle = true;
        this.mTabSpecs = new ArrayList();
        this.mOnPageChangeListener = null;
        this.cYt = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.cYr = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.cYs = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.cYn = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.cYt = R.drawable.bottom_bar_background;
                setShouldDrawTopLine(false);
                needShowTopDiver(false);
            } else if (this.mType == 0) {
                this.cYt = R.color.cp_bg_line_h;
                setShouldDrawTopLine(true);
                needShowTopDiver(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.cYs.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.cYk != null) {
            this.cYk.getLayoutParams().height = i;
            this.cYk.requestLayout();
            this.cYr.getLayoutParams().height = i;
            this.cYr.requestLayout();
            if (this.cYu == 1) {
                this.cYm.getLayoutParams().height = i;
                this.cYm.requestLayout();
            }
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.cYk != null) {
            this.cYk.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.cYk != null) {
            this.cYk.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.cYk != null) {
            this.cYk.setShouldDrawTopLine(z);
        }
    }

    public void setBackGroundStyle(int i) {
        this.cYu = i;
        if (this.cYk != null) {
            this.cYk.setBackGroundStyle(i);
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
        if (this.cYk != null) {
            this.cYk.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.topDvider.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.topDvider.setLayoutParams(layoutParams);
        this.topDvider.setVisibility(0);
        am.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        ((FrameLayout.LayoutParams) this.cYk.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.cYk != null) {
            this.cYk.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.cYl == null) {
            this.cYl = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        needShowTopDiver(false);
        this.cYl.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.cYk = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.cYm = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.cYk.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.cYk.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.cYv == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.cYw != null) {
                bVar.cYw.onAdd();
            }
            this.cYk.addView(bVar.cYv, i);
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
        if (bVar.cYv == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.mContentFragment == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.mTabSpecs.contains(bVar)) {
            if (bVar.cYw != null) {
                bVar.cYw.onAdd();
            }
            this.cYk.addView(bVar.cYv, i, z);
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
        if (this.cYo != null) {
            this.cYo.setScrollable(z);
        }
    }

    public void initViewPager() {
        initViewPager(0);
    }

    public void initViewPager(int i) {
        if (this.cYo != null) {
            removeView(this.cYo);
        }
        this.cYo = new CustomViewPager(this.mContext);
        this.cYo.setId(R.id.tab_content);
        changeStyle(i);
        addView(this.cYo);
        removeView(this.cYr);
        addView(this.cYr);
        removeView(this.cYs);
        addView(this.cYs);
        this.cYo.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.cYo.setOnPageChangeListener(this);
        this.cYq = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.cYo.setAdapter(this.cYq);
    }

    public void initViewPagerWithNoType() {
        if (this.cYo != null) {
            removeView(this.cYo);
        }
        this.cYo = new CustomViewPager(this.mContext);
        this.cYo.setId(R.id.tab_content);
        addView(this.cYo);
        removeView(this.cYr);
        addView(this.cYr);
        this.cYo.setOffscreenPageLimit(this.mTabSpecs.size() - 1);
        this.cYo.setOnPageChangeListener(this);
        this.cYq = new FragmentAdapter(this.mFragmentManager, this.mTabSpecs);
        this.cYo.setAdapter(this.cYq);
    }

    public void changeStyle(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.cYo.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.cYo.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.cYr.getLayoutParams();
            layoutParams2.height = -2;
        }
        clearRules(layoutParams.getRules());
        clearRules(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.cYr.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.cYr.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.cYr.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.mContext, R.dimen.ds88);
            this.cYr.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.cYr.setVisibility(8);
        }
        this.cYo.setLayoutParams(layoutParams);
        this.cYr.setLayoutParams(layoutParams2);
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
        this.cYp = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.mTabSpecs.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.cYn = this.mTabSpecs.get(this.mCurrentTabIndex);
            this.cYk.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.cYo != null) {
                this.cYo.setCurrentItem(this.mCurrentTabIndex, false);
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
        this.cYn = this.mTabSpecs.get(i);
        if (this.cYp == null || this.cYp.onPreTabSelectionChange(i, z)) {
            if (this.cYp != null) {
                this.cYp.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.cYk.setBackgroundColor(i);
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
        if (this.cYn != null) {
            return this.cYn.mContentFragment;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.cYo;
    }

    public ViewGroup getTabWrapper() {
        return this.cYr;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.cYk;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.cYk != null) {
            this.cYk.setAbsoluteWeight(z);
        }
    }

    public b ko(int i) {
        if (i < 0 || i >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(i);
    }

    public b kp(int i) {
        for (b bVar : this.mTabSpecs) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.cYo != null && this.cYq != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.mTabSpecs.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.cYo.getId(), this.cYq.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.mTabSpecs) {
                if (bVar.cYw != null) {
                    bVar.cYw.onRemove();
                }
            }
            this.mTabSpecs.clear();
            this.cYn = null;
            this.mCurrentTabIndex = -1;
            this.cYk.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.cYk.onChangeSkinType(i);
        this.cYm.onChangeSkinType(i);
        am.setBackgroundColor(this.topDvider, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cYs, R.drawable.bottom_view_shadow);
        for (b bVar : this.mTabSpecs) {
            bVar.cYv.onChangeSkin(i);
            bVar.cYv.setSelected(bVar.cYv.isSelected());
        }
        if (this.cYq != null) {
            int count = this.cYq.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.cYq.getItem(i2);
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
        this.cYk.changeLeft(i, f);
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
        this.cYn = this.mTabSpecs.get(i);
        this.cYk.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.cYn.mContentFragment.getView();
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
        if (this.cYr != null && this.cYr.getVisibility() != 0) {
            this.cYr.setVisibility(0);
        }
    }

    public void hideTabWidget() {
        if (this.cYr != null && this.cYr.getVisibility() != 8) {
            this.cYr.setVisibility(8);
        }
    }
}
