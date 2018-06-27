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
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget anZ;
    private com.baidu.tbadk.core.tabHost.a aoa;
    private b aob;
    private boolean aoc;
    private final List<b> aod;
    private CustomViewPager aoe;
    private a aof;
    private FragmentAdapter aog;
    private LinearLayout aoh;
    private int aoi;
    private View aoj;
    private int aok;
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
        public TbFragmentTabIndicator aom;
        public Fragment aon;
        public com.baidu.tbadk.mainTab.b aoo;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aoc = true;
        this.aod = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aoi = 0;
        this.aok = d.C0142d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoc = true;
        this.aod = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aoi = 0;
        this.aok = d.C0142d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.fragment_tabhost, (ViewGroup) this, true);
        this.aoh = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aob = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.anZ != null) {
            this.anZ.getLayoutParams().height = i;
            this.anZ.requestLayout();
            this.aoh.getLayoutParams().height = i;
            this.aoh.requestLayout();
            this.aoi = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.anZ != null) {
            this.anZ.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.anZ != null) {
            this.anZ.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.anZ != null) {
            this.anZ.setShouldDrawTopLine(z);
        }
    }

    public void aH(boolean z) {
        if (this.aoj == null) {
            this.aoj = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aoj.setVisibility(8);
            return;
        }
        if (this.anZ != null) {
            this.anZ.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoj.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aoj.setLayoutParams(layoutParams);
        this.aoj.setVisibility(0);
        am.j(this.aoj, d.C0142d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.anZ.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.anZ != null) {
            this.anZ.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.aoa == null) {
            this.aoa = new com.baidu.tbadk.core.tabHost.a(this, d.C0142d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aH(false);
        this.aoa.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.anZ = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.anZ.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.anZ.setPadding(i, i2, i3, i4);
    }

    public void aI(boolean z) {
        this.anZ.aI(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.aom == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.aon == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aod.contains(bVar)) {
            if (bVar.aoo != null) {
                bVar.aoo.Jr();
            }
            this.anZ.addView(bVar.aom, i);
            if (i == -1) {
                this.aod.add(bVar);
            } else {
                this.aod.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aoe != null) {
            this.aoe.setScrollable(z);
        }
    }

    public void initViewPager() {
        cy(0);
    }

    public void cy(int i) {
        if (this.aoe != null) {
            removeView(this.aoe);
        }
        this.aoe = new CustomViewPager(this.mContext);
        this.aoe.setId(d.g.tab_content);
        cz(i);
        addView(this.aoe);
        removeView(this.aoh);
        addView(this.aoh);
        this.aoe.setOffscreenPageLimit(this.aod.size() - 1);
        this.aoe.setOnPageChangeListener(this);
        this.aog = new FragmentAdapter(this.mFragmentManager, this.aod);
        this.aoe.setAdapter(this.aog);
    }

    public void yg() {
        if (this.aoe != null) {
            removeView(this.aoe);
        }
        this.aoe = new CustomViewPager(this.mContext);
        this.aoe.setId(d.g.tab_content);
        addView(this.aoe);
        removeView(this.aoh);
        addView(this.aoh);
        this.aoe.setOffscreenPageLimit(this.aod.size() - 1);
        this.aoe.setOnPageChangeListener(this);
        this.aog = new FragmentAdapter(this.mFragmentManager, this.aod);
        this.aoe.setAdapter(this.aog);
    }

    public void cz(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aoe.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aoe.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aoh.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.aoh.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.aoh.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds98);
            this.aoh.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.e(this.mContext, d.e.ds88);
            this.aoh.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.aoh.setVisibility(8);
        }
        this.aoe.setLayoutParams(layoutParams);
        this.aoh.setLayoutParams(layoutParams2);
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
        this.aof = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aod.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aob = this.aod.get(this.mCurrentTabIndex);
            this.anZ.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.aoe != null) {
                this.aoe.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aod.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aod.get(i3).mType) {
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
        this.aob = this.aod.get(i);
        if (this.aof == null || this.aof.onPreTabSelectionChange(i, z)) {
            if (this.aof != null) {
                this.aof.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.anZ.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aod.size()) {
            return -1;
        }
        return this.aod.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aob != null) {
            return this.aob.aon;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.aoe;
    }

    public ViewGroup getTabWrapper() {
        return this.aoh;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.anZ;
    }

    public b cA(int i) {
        if (i < 0 || i >= this.aod.size()) {
            return null;
        }
        return this.aod.get(i);
    }

    public b cB(int i) {
        for (b bVar : this.aod) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.aoe != null && this.aog != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.aod.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aoe.getId(), this.aog.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.aod) {
                if (bVar.aoo != null) {
                    bVar.aoo.eY();
                }
            }
            this.aod.clear();
            this.aob = null;
            this.mCurrentTabIndex = -1;
            this.anZ.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.aoc) {
            this.aoh.setBackgroundDrawable(new BitmapDrawable(am.cT(d.f.s_tabbar_bg)));
        } else {
            am.j(this.aoh, this.aok);
        }
        this.anZ.onChangeSkinType(i);
        am.j(this.aoj, d.C0142d.cp_bg_line_b);
        for (b bVar : this.aod) {
            bVar.aom.dD(i);
        }
        if (this.aog != null) {
            int count = this.aog.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aog.getItem(i2);
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
        this.anZ.d(i, f);
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
        this.aob = this.aod.get(i);
        this.anZ.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aob.aon.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> aol;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aol = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aol.get(i).aon;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aol.get(i).aon.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aol.size();
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
        this.aoc = z;
    }

    public void yh() {
        if (this.aoh != null && this.aoh.getVisibility() != 0) {
            this.aoh.setVisibility(0);
        }
    }

    public void yi() {
        if (this.aoh != null && this.aoh.getVisibility() != 8) {
            this.aoh.setVisibility(8);
        }
    }
}
