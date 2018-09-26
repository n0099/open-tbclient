package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget aqh;
    private com.baidu.tbadk.core.tabHost.a aqi;
    private b aqj;
    private boolean aqk;
    private final List<b> aql;
    private CustomViewPager aqm;
    private a aqn;
    private FragmentAdapter aqo;
    private LinearLayout aqp;
    private int aqq;
    private View aqr;
    private int aqs;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator aqu;
        public Fragment aqv;
        public com.baidu.tbadk.mainTab.b aqw;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aqk = true;
        this.aql = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aqq = 0;
        this.aqs = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqk = true;
        this.aql = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aqq = 0;
        this.aqs = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.aqp = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aqj = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aqh != null) {
            this.aqh.getLayoutParams().height = i;
            this.aqh.requestLayout();
            this.aqp.getLayoutParams().height = i;
            this.aqp.requestLayout();
            this.aqq = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.aqh != null) {
            this.aqh.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aqh != null) {
            this.aqh.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aqh != null) {
            this.aqh.setShouldDrawTopLine(z);
        }
    }

    public void aP(boolean z) {
        if (this.aqr == null) {
            this.aqr = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.aqr.setVisibility(8);
            return;
        }
        if (this.aqh != null) {
            this.aqh.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqr.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aqr.setLayoutParams(layoutParams);
        this.aqr.setVisibility(0);
        al.j(this.aqr, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.aqh.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.aqh != null) {
            this.aqh.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.aqi == null) {
            this.aqi = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aP(false);
        this.aqi.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aqh = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.aqh.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.aqh.setPadding(i, i2, i3, i4);
    }

    public void aQ(boolean z) {
        this.aqh.aQ(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.aqu == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.aqv == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aql.contains(bVar)) {
            if (bVar.aqw != null) {
                bVar.aqw.KC();
            }
            this.aqh.addView(bVar.aqu, i);
            if (i == -1) {
                this.aql.add(bVar);
            } else {
                this.aql.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aqm != null) {
            this.aqm.setScrollable(z);
        }
    }

    public void initViewPager() {
        cK(0);
    }

    public void cK(int i) {
        if (this.aqm != null) {
            removeView(this.aqm);
        }
        this.aqm = new CustomViewPager(this.mContext);
        this.aqm.setId(e.g.tab_content);
        cL(i);
        addView(this.aqm);
        removeView(this.aqp);
        addView(this.aqp);
        this.aqm.setOffscreenPageLimit(this.aql.size() - 1);
        this.aqm.setOnPageChangeListener(this);
        this.aqo = new FragmentAdapter(this.mFragmentManager, this.aql);
        this.aqm.setAdapter(this.aqo);
    }

    public void ze() {
        if (this.aqm != null) {
            removeView(this.aqm);
        }
        this.aqm = new CustomViewPager(this.mContext);
        this.aqm.setId(e.g.tab_content);
        addView(this.aqm);
        removeView(this.aqp);
        addView(this.aqp);
        this.aqm.setOffscreenPageLimit(this.aql.size() - 1);
        this.aqm.setOnPageChangeListener(this);
        this.aqo = new FragmentAdapter(this.mFragmentManager, this.aql);
        this.aqm.setAdapter(this.aqo);
    }

    public void cL(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aqm.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aqm.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aqp.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.aqp.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.aqp.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0141e.ds98);
            this.aqp.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0141e.ds88);
            this.aqp.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.aqp.setVisibility(8);
        }
        this.aqm.setLayoutParams(layoutParams);
        this.aqp.setLayoutParams(layoutParams2);
    }

    private void g(int[] iArr) {
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
        this.aqn = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aql.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aqj = this.aql.get(this.mCurrentTabIndex);
            this.aqh.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.aqm != null) {
                this.aqm.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aql.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aql.get(i3).mType) {
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
        this.aqj = this.aql.get(i);
        if (this.aqn == null || this.aqn.onPreTabSelectionChange(i, z)) {
            if (this.aqn != null) {
                this.aqn.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aqh.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aql.size()) {
            return -1;
        }
        return this.aql.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aqj != null) {
            return this.aqj.aqv;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.aqm;
    }

    public ViewGroup getTabWrapper() {
        return this.aqp;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aqh;
    }

    public b cM(int i) {
        if (i < 0 || i >= this.aql.size()) {
            return null;
        }
        return this.aql.get(i);
    }

    public b cN(int i) {
        for (b bVar : this.aql) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.aqm != null && this.aqo != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.aql.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aqm.getId(), this.aqo.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.aql) {
                if (bVar.aqw != null) {
                    bVar.aqw.gg();
                }
            }
            this.aql.clear();
            this.aqj = null;
            this.mCurrentTabIndex = -1;
            this.aqh.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.aqk) {
            this.aqp.setBackgroundDrawable(new BitmapDrawable(al.de(e.f.s_tabbar_bg)));
        } else {
            al.j(this.aqp, this.aqs);
        }
        this.aqh.onChangeSkinType(i);
        al.j(this.aqr, e.d.cp_bg_line_b);
        for (b bVar : this.aql) {
            bVar.aqu.dQ(i);
        }
        if (this.aqo != null) {
            int count = this.aqo.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aqo.getItem(i2);
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
        this.aqh.d(i, f);
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
        this.aqj = this.aql.get(i);
        this.aqh.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aqj.aqv.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> aqt;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aqt = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aqt.get(i).aqv;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aqt.get(i).aqv.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aqt.size();
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
        this.aqk = z;
    }

    public void zf() {
        if (this.aqp != null && this.aqp.getVisibility() != 0) {
            this.aqp.setVisibility(0);
        }
    }

    public void zg() {
        if (this.aqp != null && this.aqp.getVisibility() != 8) {
            this.aqp.setVisibility(8);
        }
    }
}
