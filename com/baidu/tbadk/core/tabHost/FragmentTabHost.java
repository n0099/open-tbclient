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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget bHG;
    private com.baidu.tbadk.core.tabHost.a bHH;
    private b bHI;
    private boolean bHJ;
    private final List<b> bHK;
    private CustomViewPager bHL;
    private a bHM;
    private FragmentAdapter bHN;
    private LinearLayout bHO;
    private int bHP;
    private View bHQ;
    private View bHR;
    private int bHS;
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
        public TbFragmentTabIndicator bHU;
        public Fragment bHV;
        public com.baidu.tbadk.mainTab.b bHW;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bHJ = true;
        this.bHK = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHP = 0;
        this.bHS = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHJ = true;
        this.bHK = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bHP = 0;
        this.bHS = d.f.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.bHO = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.bHR = findViewById(d.g.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bHI = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bHS = d.f.bottom_bar_background;
                al.k(this.bHO, this.bHS);
                setShouldDrawTopLine(false);
                dA(false);
            } else if (this.mType == 0) {
                this.bHS = d.f.white_bg;
                al.k(this.bHO, this.bHS);
                setShouldDrawTopLine(true);
                dA(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bHR.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bHG != null) {
            this.bHG.getLayoutParams().height = i;
            this.bHG.requestLayout();
            this.bHO.getLayoutParams().height = i;
            this.bHO.requestLayout();
            this.bHP = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bHG != null) {
            this.bHG.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bHG != null) {
            this.bHG.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bHG != null) {
            this.bHG.setShouldDrawTopLine(z);
        }
    }

    public void dA(boolean z) {
        if (this.bHQ == null) {
            this.bHQ = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.bHQ.setVisibility(8);
            return;
        }
        if (this.bHG != null) {
            this.bHG.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHQ.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bHQ.setLayoutParams(layoutParams);
        this.bHQ.setVisibility(0);
        al.l(this.bHQ, d.C0236d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bHG.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bHG != null) {
            this.bHG.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bHH == null) {
            this.bHH = new com.baidu.tbadk.core.tabHost.a(this, d.C0236d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dA(false);
        this.bHH.c(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bHG = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.bHG.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bHG.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bHU == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHV == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHK.contains(bVar)) {
            if (bVar.bHW != null) {
                bVar.bHW.anJ();
            }
            this.bHG.addView(bVar.bHU, i);
            if (i == -1) {
                this.bHK.add(bVar);
            } else {
                this.bHK.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bHU == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bHV == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bHK.contains(bVar)) {
            if (bVar.bHW != null) {
                bVar.bHW.anJ();
            }
            this.bHG.addView(bVar.bHU, i, z);
            if (i == -1) {
                this.bHK.add(bVar);
            } else {
                this.bHK.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bHL != null) {
            this.bHL.setScrollable(z);
        }
    }

    public void initViewPager() {
        gY(0);
    }

    public void gY(int i) {
        if (this.bHL != null) {
            removeView(this.bHL);
        }
        this.bHL = new CustomViewPager(this.mContext);
        this.bHL.setId(d.g.tab_content);
        gZ(i);
        addView(this.bHL);
        removeView(this.bHO);
        addView(this.bHO);
        removeView(this.bHR);
        addView(this.bHR);
        this.bHL.setOffscreenPageLimit(this.bHK.size() - 1);
        this.bHL.setOnPageChangeListener(this);
        this.bHN = new FragmentAdapter(this.mFragmentManager, this.bHK);
        this.bHL.setAdapter(this.bHN);
    }

    public void abU() {
        if (this.bHL != null) {
            removeView(this.bHL);
        }
        this.bHL = new CustomViewPager(this.mContext);
        this.bHL.setId(d.g.tab_content);
        addView(this.bHL);
        removeView(this.bHO);
        addView(this.bHO);
        this.bHL.setOffscreenPageLimit(this.bHK.size() - 1);
        this.bHL.setOnPageChangeListener(this);
        this.bHN = new FragmentAdapter(this.mFragmentManager, this.bHK);
        this.bHL.setAdapter(this.bHN);
    }

    public void gZ(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bHL.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bHL.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bHO.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bHO.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bHO.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHO.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, d.e.ds88);
            this.bHO.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bHO.setVisibility(8);
        }
        this.bHL.setLayoutParams(layoutParams);
        this.bHO.setLayoutParams(layoutParams2);
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
        this.bHM = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bHK.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bHI = this.bHK.get(this.mCurrentTabIndex);
            this.bHG.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bHL != null) {
                this.bHL.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bHK.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bHK.get(i3).mType) {
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
        this.bHI = this.bHK.get(i);
        if (this.bHM == null || this.bHM.onPreTabSelectionChange(i, z)) {
            if (this.bHM != null) {
                this.bHM.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bHG.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bHK.size()) {
            return -1;
        }
        return this.bHK.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bHI != null) {
            return this.bHI.bHV;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bHL;
    }

    public ViewGroup getTabWrapper() {
        return this.bHO;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bHG;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bHG != null) {
            this.bHG.setAbsoluteWeight(z);
        }
    }

    public b ha(int i) {
        if (i < 0 || i >= this.bHK.size()) {
            return null;
        }
        return this.bHK.get(i);
    }

    public b hb(int i) {
        for (b bVar : this.bHK) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bHL != null && this.bHN != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bHK.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bHL.getId(), this.bHN.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bHK) {
                if (bVar.bHW != null) {
                    bVar.bHW.gv();
                }
            }
            this.bHK.clear();
            this.bHI = null;
            this.mCurrentTabIndex = -1;
            this.bHG.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bHJ) {
            this.bHO.setBackgroundDrawable(new BitmapDrawable(al.hs(d.f.s_tabbar_bg)));
        } else {
            al.k(this.bHO, this.bHS);
        }
        this.bHG.onChangeSkinType(i);
        al.l(this.bHQ, d.C0236d.cp_bg_line_b);
        for (b bVar : this.bHK) {
            bVar.bHU.ij(i);
        }
        if (this.bHN != null) {
            int count = this.bHN.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bHN.getItem(i2);
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
        this.bHG.d(i, f);
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
        this.bHI = this.bHK.get(i);
        this.bHG.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bHI.bHV.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bHT;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bHT = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bHT.get(i).bHV;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bHT.get(i).bHV.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bHT.size();
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
        this.bHJ = z;
    }

    public void abV() {
        if (this.bHO != null && this.bHO.getVisibility() != 0) {
            this.bHO.setVisibility(0);
        }
    }

    public void abW() {
        if (this.bHO != null && this.bHO.getVisibility() != 8) {
            this.bHO.setVisibility(8);
        }
    }
}
