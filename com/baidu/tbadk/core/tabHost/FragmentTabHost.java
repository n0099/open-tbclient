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
    private FragmentTabWidget bHK;
    private com.baidu.tbadk.core.tabHost.a bHL;
    private b bHM;
    private boolean bHN;
    private final List<b> bHO;
    private CustomViewPager bHP;
    private a bHQ;
    private FragmentAdapter bHR;
    private LinearLayout bHS;
    private int bHT;
    private View bHU;
    private View bHV;
    private int bHW;
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
        public TbFragmentTabIndicator bHY;
        public Fragment bHZ;
        public com.baidu.tbadk.mainTab.b bIa;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bHN = true;
        this.bHO = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHT = 0;
        this.bHW = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHN = true;
        this.bHO = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHT = 0;
        this.bHW = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.bHS = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.bHV = findViewById(d.g.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bHM = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bHW = d.f.bottom_bar_background;
                al.k(this.bHS, this.bHW);
                setShouldDrawTopLine(false);
                dA(false);
            } else if (this.mType == 0) {
                this.bHW = d.f.white_bg;
                al.k(this.bHS, this.bHW);
                setShouldDrawTopLine(true);
                dA(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bHV.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bHK != null) {
            this.bHK.getLayoutParams().height = i;
            this.bHK.requestLayout();
            this.bHS.getLayoutParams().height = i;
            this.bHS.requestLayout();
            this.bHT = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bHK != null) {
            this.bHK.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bHK != null) {
            this.bHK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bHK != null) {
            this.bHK.setShouldDrawTopLine(z);
        }
    }

    public void dA(boolean z) {
        if (this.bHU == null) {
            this.bHU = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.bHU.setVisibility(8);
            return;
        }
        if (this.bHK != null) {
            this.bHK.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHU.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bHU.setLayoutParams(layoutParams);
        this.bHU.setVisibility(0);
        al.l(this.bHU, d.C0277d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bHK.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bHK != null) {
            this.bHK.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bHL == null) {
            this.bHL = new com.baidu.tbadk.core.tabHost.a(this, d.C0277d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dA(false);
        this.bHL.c(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bHK = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.bHK.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bHK.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bHY == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHZ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHO.contains(bVar)) {
            if (bVar.bIa != null) {
                bVar.bIa.anF();
            }
            this.bHK.addView(bVar.bHY, i);
            if (i == -1) {
                this.bHO.add(bVar);
            } else {
                this.bHO.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bHY == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHZ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHO.contains(bVar)) {
            if (bVar.bIa != null) {
                bVar.bIa.anF();
            }
            this.bHK.addView(bVar.bHY, i, z);
            if (i == -1) {
                this.bHO.add(bVar);
            } else {
                this.bHO.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bHP != null) {
            this.bHP.setScrollable(z);
        }
    }

    public void initViewPager() {
        gX(0);
    }

    public void gX(int i) {
        if (this.bHP != null) {
            removeView(this.bHP);
        }
        this.bHP = new CustomViewPager(this.mContext);
        this.bHP.setId(d.g.tab_content);
        gY(i);
        addView(this.bHP);
        removeView(this.bHS);
        addView(this.bHS);
        removeView(this.bHV);
        addView(this.bHV);
        this.bHP.setOffscreenPageLimit(this.bHO.size() - 1);
        this.bHP.setOnPageChangeListener(this);
        this.bHR = new FragmentAdapter(this.mFragmentManager, this.bHO);
        this.bHP.setAdapter(this.bHR);
    }

    public void abR() {
        if (this.bHP != null) {
            removeView(this.bHP);
        }
        this.bHP = new CustomViewPager(this.mContext);
        this.bHP.setId(d.g.tab_content);
        addView(this.bHP);
        removeView(this.bHS);
        addView(this.bHS);
        this.bHP.setOffscreenPageLimit(this.bHO.size() - 1);
        this.bHP.setOnPageChangeListener(this);
        this.bHR = new FragmentAdapter(this.mFragmentManager, this.bHO);
        this.bHP.setAdapter(this.bHR);
    }

    public void gY(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bHP.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bHP.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bHS.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bHS.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bHS.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHS.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, d.e.ds88);
            this.bHS.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHS.setVisibility(8);
        }
        this.bHP.setLayoutParams(layoutParams);
        this.bHS.setLayoutParams(layoutParams2);
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
        this.bHQ = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bHO.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bHM = this.bHO.get(this.mCurrentTabIndex);
            this.bHK.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bHP != null) {
                this.bHP.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bHO.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bHO.get(i3).mType) {
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
        this.bHM = this.bHO.get(i);
        if (this.bHQ == null || this.bHQ.onPreTabSelectionChange(i, z)) {
            if (this.bHQ != null) {
                this.bHQ.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bHK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bHO.size()) {
            return -1;
        }
        return this.bHO.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bHM != null) {
            return this.bHM.bHZ;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bHP;
    }

    public ViewGroup getTabWrapper() {
        return this.bHS;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bHK;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bHK != null) {
            this.bHK.setAbsoluteWeight(z);
        }
    }

    public b gZ(int i) {
        if (i < 0 || i >= this.bHO.size()) {
            return null;
        }
        return this.bHO.get(i);
    }

    public b ha(int i) {
        for (b bVar : this.bHO) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bHP != null && this.bHR != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bHO.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bHP.getId(), this.bHR.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bHO) {
                if (bVar.bIa != null) {
                    bVar.bIa.gv();
                }
            }
            this.bHO.clear();
            this.bHM = null;
            this.mCurrentTabIndex = -1;
            this.bHK.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + Config.TRACE_TODAY_VISIT_SPLIT + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bHN) {
            this.bHS.setBackgroundDrawable(new BitmapDrawable(al.hr(d.f.s_tabbar_bg)));
        } else {
            al.k(this.bHS, this.bHW);
        }
        this.bHK.onChangeSkinType(i);
        al.l(this.bHU, d.C0277d.cp_bg_line_b);
        for (b bVar : this.bHO) {
            bVar.bHY.ii(i);
        }
        if (this.bHR != null) {
            int count = this.bHR.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bHR.getItem(i2);
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
        this.bHK.d(i, f);
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
        this.bHM = this.bHO.get(i);
        this.bHK.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bHM.bHZ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bHX;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bHX = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bHX.get(i).bHZ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bHX.get(i).bHZ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bHX.size();
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
        this.bHN = z;
    }

    public void abS() {
        if (this.bHS != null && this.bHS.getVisibility() != 0) {
            this.bHS.setVisibility(0);
        }
    }

    public void abT() {
        if (this.bHS != null && this.bHS.getVisibility() != 8) {
            this.bHS.setVisibility(8);
        }
    }
}
