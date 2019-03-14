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
    private FragmentTabWidget bHH;
    private com.baidu.tbadk.core.tabHost.a bHI;
    private b bHJ;
    private boolean bHK;
    private final List<b> bHL;
    private CustomViewPager bHM;
    private a bHN;
    private FragmentAdapter bHO;
    private LinearLayout bHP;
    private int bHQ;
    private View bHR;
    private View bHS;
    private int bHT;
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
        public TbFragmentTabIndicator bHV;
        public Fragment bHW;
        public com.baidu.tbadk.mainTab.b bHX;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bHK = true;
        this.bHL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHQ = 0;
        this.bHT = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHK = true;
        this.bHL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHQ = 0;
        this.bHT = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.bHP = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.bHS = findViewById(d.g.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bHJ = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bHT = d.f.bottom_bar_background;
                al.k(this.bHP, this.bHT);
                setShouldDrawTopLine(false);
                dA(false);
            } else if (this.mType == 0) {
                this.bHT = d.f.white_bg;
                al.k(this.bHP, this.bHT);
                setShouldDrawTopLine(true);
                dA(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bHS.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bHH != null) {
            this.bHH.getLayoutParams().height = i;
            this.bHH.requestLayout();
            this.bHP.getLayoutParams().height = i;
            this.bHP.requestLayout();
            this.bHQ = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bHH != null) {
            this.bHH.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bHH != null) {
            this.bHH.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bHH != null) {
            this.bHH.setShouldDrawTopLine(z);
        }
    }

    public void dA(boolean z) {
        if (this.bHR == null) {
            this.bHR = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.bHR.setVisibility(8);
            return;
        }
        if (this.bHH != null) {
            this.bHH.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHR.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bHR.setLayoutParams(layoutParams);
        this.bHR.setVisibility(0);
        al.l(this.bHR, d.C0277d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bHH.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bHH != null) {
            this.bHH.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bHI == null) {
            this.bHI = new com.baidu.tbadk.core.tabHost.a(this, d.C0277d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dA(false);
        this.bHI.c(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bHH = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.bHH.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bHH.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bHV == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHW == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHL.contains(bVar)) {
            if (bVar.bHX != null) {
                bVar.bHX.anI();
            }
            this.bHH.addView(bVar.bHV, i);
            if (i == -1) {
                this.bHL.add(bVar);
            } else {
                this.bHL.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bHV == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHW == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHL.contains(bVar)) {
            if (bVar.bHX != null) {
                bVar.bHX.anI();
            }
            this.bHH.addView(bVar.bHV, i, z);
            if (i == -1) {
                this.bHL.add(bVar);
            } else {
                this.bHL.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bHM != null) {
            this.bHM.setScrollable(z);
        }
    }

    public void initViewPager() {
        gY(0);
    }

    public void gY(int i) {
        if (this.bHM != null) {
            removeView(this.bHM);
        }
        this.bHM = new CustomViewPager(this.mContext);
        this.bHM.setId(d.g.tab_content);
        gZ(i);
        addView(this.bHM);
        removeView(this.bHP);
        addView(this.bHP);
        removeView(this.bHS);
        addView(this.bHS);
        this.bHM.setOffscreenPageLimit(this.bHL.size() - 1);
        this.bHM.setOnPageChangeListener(this);
        this.bHO = new FragmentAdapter(this.mFragmentManager, this.bHL);
        this.bHM.setAdapter(this.bHO);
    }

    public void abU() {
        if (this.bHM != null) {
            removeView(this.bHM);
        }
        this.bHM = new CustomViewPager(this.mContext);
        this.bHM.setId(d.g.tab_content);
        addView(this.bHM);
        removeView(this.bHP);
        addView(this.bHP);
        this.bHM.setOffscreenPageLimit(this.bHL.size() - 1);
        this.bHM.setOnPageChangeListener(this);
        this.bHO = new FragmentAdapter(this.mFragmentManager, this.bHL);
        this.bHM.setAdapter(this.bHO);
    }

    public void gZ(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bHM.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bHM.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bHP.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bHP.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bHP.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHP.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, d.e.ds88);
            this.bHP.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHP.setVisibility(8);
        }
        this.bHM.setLayoutParams(layoutParams);
        this.bHP.setLayoutParams(layoutParams2);
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
        this.bHN = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bHL.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bHJ = this.bHL.get(this.mCurrentTabIndex);
            this.bHH.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bHM != null) {
                this.bHM.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bHL.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bHL.get(i3).mType) {
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
        this.bHJ = this.bHL.get(i);
        if (this.bHN == null || this.bHN.onPreTabSelectionChange(i, z)) {
            if (this.bHN != null) {
                this.bHN.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bHH.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bHL.size()) {
            return -1;
        }
        return this.bHL.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bHJ != null) {
            return this.bHJ.bHW;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bHM;
    }

    public ViewGroup getTabWrapper() {
        return this.bHP;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bHH;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bHH != null) {
            this.bHH.setAbsoluteWeight(z);
        }
    }

    public b ha(int i) {
        if (i < 0 || i >= this.bHL.size()) {
            return null;
        }
        return this.bHL.get(i);
    }

    public b hb(int i) {
        for (b bVar : this.bHL) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bHM != null && this.bHO != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bHL.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bHM.getId(), this.bHO.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bHL) {
                if (bVar.bHX != null) {
                    bVar.bHX.gv();
                }
            }
            this.bHL.clear();
            this.bHJ = null;
            this.mCurrentTabIndex = -1;
            this.bHH.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bHK) {
            this.bHP.setBackgroundDrawable(new BitmapDrawable(al.hs(d.f.s_tabbar_bg)));
        } else {
            al.k(this.bHP, this.bHT);
        }
        this.bHH.onChangeSkinType(i);
        al.l(this.bHR, d.C0277d.cp_bg_line_b);
        for (b bVar : this.bHL) {
            bVar.bHV.ij(i);
        }
        if (this.bHO != null) {
            int count = this.bHO.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bHO.getItem(i2);
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
        this.bHH.d(i, f);
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
        this.bHJ = this.bHL.get(i);
        this.bHH.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bHJ.bHW.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bHU;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bHU = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bHU.get(i).bHW;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bHU.get(i).bHW.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bHU.size();
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
        this.bHK = z;
    }

    public void abV() {
        if (this.bHP != null && this.bHP.getVisibility() != 0) {
            this.bHP.setVisibility(0);
        }
    }

    public void abW() {
        if (this.bHP != null && this.bHP.getVisibility() != 8) {
            this.bHP.setVisibility(8);
        }
    }
}
