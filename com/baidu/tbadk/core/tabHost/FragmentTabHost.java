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
    private FragmentTabWidget auY;
    private com.baidu.tbadk.core.tabHost.a auZ;
    private b ava;
    private boolean avb;
    private final List<b> avc;
    private CustomViewPager avd;
    private a ave;
    private FragmentAdapter avf;
    private LinearLayout avg;
    private int avh;
    private View avi;
    private int avj;
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
        public TbFragmentTabIndicator avl;
        public Fragment avm;
        public com.baidu.tbadk.mainTab.b avn;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.avb = true;
        this.avc = new ArrayList();
        this.mOnPageChangeListener = null;
        this.avh = 0;
        this.avj = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avb = true;
        this.avc = new ArrayList();
        this.mOnPageChangeListener = null;
        this.avh = 0;
        this.avj = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.avg = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.ava = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.auY != null) {
            this.auY.getLayoutParams().height = i;
            this.auY.requestLayout();
            this.avg.getLayoutParams().height = i;
            this.avg.requestLayout();
            this.avh = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.auY != null) {
            this.auY.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.auY != null) {
            this.auY.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.auY != null) {
            this.auY.setShouldDrawTopLine(z);
        }
    }

    public void aZ(boolean z) {
        if (this.avi == null) {
            this.avi = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.avi.setVisibility(8);
            return;
        }
        if (this.auY != null) {
            this.auY.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avi.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.avi.setLayoutParams(layoutParams);
        this.avi.setVisibility(0);
        al.j(this.avi, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.auY.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.auY != null) {
            this.auY.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.auZ == null) {
            this.auZ = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aZ(false);
        this.auZ.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.auY = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.auY.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.auY.setPadding(i, i2, i3, i4);
    }

    public void ba(boolean z) {
        this.auY.ba(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.avl == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.avm == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.avc.contains(bVar)) {
            if (bVar.avn != null) {
                bVar.avn.MA();
            }
            this.auY.addView(bVar.avl, i);
            if (i == -1) {
                this.avc.add(bVar);
            } else {
                this.avc.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.avd != null) {
            this.avd.setScrollable(z);
        }
    }

    public void initViewPager() {
        cU(0);
    }

    public void cU(int i) {
        if (this.avd != null) {
            removeView(this.avd);
        }
        this.avd = new CustomViewPager(this.mContext);
        this.avd.setId(e.g.tab_content);
        cV(i);
        addView(this.avd);
        removeView(this.avg);
        addView(this.avg);
        this.avd.setOffscreenPageLimit(this.avc.size() - 1);
        this.avd.setOnPageChangeListener(this);
        this.avf = new FragmentAdapter(this.mFragmentManager, this.avc);
        this.avd.setAdapter(this.avf);
    }

    public void Bm() {
        if (this.avd != null) {
            removeView(this.avd);
        }
        this.avd = new CustomViewPager(this.mContext);
        this.avd.setId(e.g.tab_content);
        addView(this.avd);
        removeView(this.avg);
        addView(this.avg);
        this.avd.setOffscreenPageLimit(this.avc.size() - 1);
        this.avd.setOnPageChangeListener(this);
        this.avf = new FragmentAdapter(this.mFragmentManager, this.avc);
        this.avd.setAdapter(this.avf);
    }

    public void cV(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.avd.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.avd.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.avg.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.avg.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.avg.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0175e.ds98);
            this.avg.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0175e.ds88);
            this.avg.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.avg.setVisibility(8);
        }
        this.avd.setLayoutParams(layoutParams);
        this.avg.setLayoutParams(layoutParams2);
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
        this.ave = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.avc.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.ava = this.avc.get(this.mCurrentTabIndex);
            this.auY.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.avd != null) {
                this.avd.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.avc.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.avc.get(i3).mType) {
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
        this.ava = this.avc.get(i);
        if (this.ave == null || this.ave.onPreTabSelectionChange(i, z)) {
            if (this.ave != null) {
                this.ave.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.auY.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.avc.size()) {
            return -1;
        }
        return this.avc.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.ava != null) {
            return this.ava.avm;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.avd;
    }

    public ViewGroup getTabWrapper() {
        return this.avg;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.auY;
    }

    public b cW(int i) {
        if (i < 0 || i >= this.avc.size()) {
            return null;
        }
        return this.avc.get(i);
    }

    public b cX(int i) {
        for (b bVar : this.avc) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.avd != null && this.avf != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.avc.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.avd.getId(), this.avf.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.avc) {
                if (bVar.avn != null) {
                    bVar.avn.gy();
                }
            }
            this.avc.clear();
            this.ava = null;
            this.mCurrentTabIndex = -1;
            this.auY.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.avb) {
            this.avg.setBackgroundDrawable(new BitmapDrawable(al.m17do(e.f.s_tabbar_bg)));
        } else {
            al.j(this.avg, this.avj);
        }
        this.auY.onChangeSkinType(i);
        al.j(this.avi, e.d.cp_bg_line_b);
        for (b bVar : this.avc) {
            bVar.avl.ea(i);
        }
        if (this.avf != null) {
            int count = this.avf.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.avf.getItem(i2);
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
        this.auY.d(i, f);
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
        this.ava = this.avc.get(i);
        this.auY.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.ava.avm.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> avk;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.avk = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.avk.get(i).avm;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.avk.get(i).avm.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.avk.size();
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
        this.avb = z;
    }

    public void Bn() {
        if (this.avg != null && this.avg.getVisibility() != 0) {
            this.avg.setVisibility(0);
        }
    }

    public void Bo() {
        if (this.avg != null && this.avg.getVisibility() != 8) {
            this.avg.setVisibility(8);
        }
    }
}
