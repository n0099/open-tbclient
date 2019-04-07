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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget bHJ;
    private com.baidu.tbadk.core.tabHost.a bHK;
    private b bHL;
    private boolean bHM;
    private final List<b> bHN;
    private CustomViewPager bHO;
    private a bHP;
    private FragmentAdapter bHQ;
    private LinearLayout bHR;
    private int bHS;
    private View bHT;
    private View bHU;
    private int bHV;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mType;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator bHX;
        public Fragment bHY;
        public com.baidu.tbadk.mainTab.b bHZ;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bHM = true;
        this.bHN = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHS = 0;
        this.bHV = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHM = true;
        this.bHN = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHS = 0;
        this.bHV = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.bHR = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.bHU = findViewById(d.g.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bHL = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bHV = d.f.bottom_bar_background;
                al.k(this.bHR, this.bHV);
                setShouldDrawTopLine(false);
                dA(false);
            } else if (this.mType == 0) {
                this.bHV = d.f.white_bg;
                al.k(this.bHR, this.bHV);
                setShouldDrawTopLine(true);
                dA(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bHU.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bHJ != null) {
            this.bHJ.getLayoutParams().height = i;
            this.bHJ.requestLayout();
            this.bHR.getLayoutParams().height = i;
            this.bHR.requestLayout();
            this.bHS = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bHJ != null) {
            this.bHJ.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bHJ != null) {
            this.bHJ.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bHJ != null) {
            this.bHJ.setShouldDrawTopLine(z);
        }
    }

    public void dA(boolean z) {
        if (this.bHT == null) {
            this.bHT = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.bHT.setVisibility(8);
            return;
        }
        if (this.bHJ != null) {
            this.bHJ.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHT.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bHT.setLayoutParams(layoutParams);
        this.bHT.setVisibility(0);
        al.l(this.bHT, d.C0277d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bHJ.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bHJ != null) {
            this.bHJ.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bHK == null) {
            this.bHK = new com.baidu.tbadk.core.tabHost.a(this, d.C0277d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dA(false);
        this.bHK.c(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bHJ = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.bHJ.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bHJ.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bHX == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHY == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHN.contains(bVar)) {
            if (bVar.bHZ != null) {
                bVar.bHZ.anF();
            }
            this.bHJ.addView(bVar.bHX, i);
            if (i == -1) {
                this.bHN.add(bVar);
            } else {
                this.bHN.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bHX == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHY == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHN.contains(bVar)) {
            if (bVar.bHZ != null) {
                bVar.bHZ.anF();
            }
            this.bHJ.addView(bVar.bHX, i, z);
            if (i == -1) {
                this.bHN.add(bVar);
            } else {
                this.bHN.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bHO != null) {
            this.bHO.setScrollable(z);
        }
    }

    public void initViewPager() {
        gX(0);
    }

    public void gX(int i) {
        if (this.bHO != null) {
            removeView(this.bHO);
        }
        this.bHO = new CustomViewPager(this.mContext);
        this.bHO.setId(d.g.tab_content);
        gY(i);
        addView(this.bHO);
        removeView(this.bHR);
        addView(this.bHR);
        removeView(this.bHU);
        addView(this.bHU);
        this.bHO.setOffscreenPageLimit(this.bHN.size() - 1);
        this.bHO.setOnPageChangeListener(this);
        this.bHQ = new FragmentAdapter(this.mFragmentManager, this.bHN);
        this.bHO.setAdapter(this.bHQ);
    }

    public void abR() {
        if (this.bHO != null) {
            removeView(this.bHO);
        }
        this.bHO = new CustomViewPager(this.mContext);
        this.bHO.setId(d.g.tab_content);
        addView(this.bHO);
        removeView(this.bHR);
        addView(this.bHR);
        this.bHO.setOffscreenPageLimit(this.bHN.size() - 1);
        this.bHO.setOnPageChangeListener(this);
        this.bHQ = new FragmentAdapter(this.mFragmentManager, this.bHN);
        this.bHO.setAdapter(this.bHQ);
    }

    public void gY(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bHO.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bHO.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bHR.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bHR.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bHR.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHR.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, d.e.ds88);
            this.bHR.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHR.setVisibility(8);
        }
        this.bHO.setLayoutParams(layoutParams);
        this.bHR.setLayoutParams(layoutParams2);
    }

    private void h(int[] iArr) {
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
        this.bHP = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bHN.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bHL = this.bHN.get(this.mCurrentTabIndex);
            this.bHJ.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bHO != null) {
                this.bHO.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bHN.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bHN.get(i3).mType) {
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
        this.bHL = this.bHN.get(i);
        if (this.bHP == null || this.bHP.onPreTabSelectionChange(i, z)) {
            if (this.bHP != null) {
                this.bHP.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bHJ.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bHN.size()) {
            return -1;
        }
        return this.bHN.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bHL != null) {
            return this.bHL.bHY;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bHO;
    }

    public ViewGroup getTabWrapper() {
        return this.bHR;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bHJ;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bHJ != null) {
            this.bHJ.setAbsoluteWeight(z);
        }
    }

    public b gZ(int i) {
        if (i < 0 || i >= this.bHN.size()) {
            return null;
        }
        return this.bHN.get(i);
    }

    public b ha(int i) {
        for (b bVar : this.bHN) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bHO != null && this.bHQ != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bHN.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bHO.getId(), this.bHQ.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bHN) {
                if (bVar.bHZ != null) {
                    bVar.bHZ.gv();
                }
            }
            this.bHN.clear();
            this.bHL = null;
            this.mCurrentTabIndex = -1;
            this.bHJ.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bHM) {
            this.bHR.setBackgroundDrawable(new BitmapDrawable(al.hr(d.f.s_tabbar_bg)));
        } else {
            al.k(this.bHR, this.bHV);
        }
        this.bHJ.onChangeSkinType(i);
        al.l(this.bHT, d.C0277d.cp_bg_line_b);
        for (b bVar : this.bHN) {
            bVar.bHX.ii(i);
        }
        if (this.bHQ != null) {
            int count = this.bHQ.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bHQ.getItem(i2);
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
        this.bHJ.d(i, f);
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
        this.bHL = this.bHN.get(i);
        this.bHJ.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bHL.bHY.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bHW;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bHW = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bHW.get(i).bHY;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bHW.get(i).bHY.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bHW.size();
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
        this.bHM = z;
    }

    public void abS() {
        if (this.bHR != null && this.bHR.getVisibility() != 0) {
            this.bHR.setVisibility(0);
        }
    }

    public void abT() {
        if (this.bHR != null && this.bHR.getVisibility() != 8) {
            this.bHR.setVisibility(8);
        }
    }
}
