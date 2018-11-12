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
    private FragmentTabWidget avL;
    private com.baidu.tbadk.core.tabHost.a avM;
    private b avN;
    private boolean avO;
    private final List<b> avP;
    private CustomViewPager avQ;
    private a avR;
    private FragmentAdapter avS;
    private LinearLayout avT;
    private int avU;
    private View avV;
    private int avW;
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
        public TbFragmentTabIndicator avY;
        public Fragment avZ;
        public com.baidu.tbadk.mainTab.b awa;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.avO = true;
        this.avP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.avU = 0;
        this.avW = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avO = true;
        this.avP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.avU = 0;
        this.avW = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.avT = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.avN = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.avL != null) {
            this.avL.getLayoutParams().height = i;
            this.avL.requestLayout();
            this.avT.getLayoutParams().height = i;
            this.avT.requestLayout();
            this.avU = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.avL != null) {
            this.avL.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.avL != null) {
            this.avL.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.avL != null) {
            this.avL.setShouldDrawTopLine(z);
        }
    }

    public void bp(boolean z) {
        if (this.avV == null) {
            this.avV = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.avV.setVisibility(8);
            return;
        }
        if (this.avL != null) {
            this.avL.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.avV.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.avV.setLayoutParams(layoutParams);
        this.avV.setVisibility(0);
        al.j(this.avV, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.avL.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.avL != null) {
            this.avL.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.avM == null) {
            this.avM = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        bp(false);
        this.avM.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.avL = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.avL.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.avL.setPadding(i, i2, i3, i4);
    }

    public void bq(boolean z) {
        this.avL.bq(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.avY == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.avZ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.avP.contains(bVar)) {
            if (bVar.awa != null) {
                bVar.awa.MJ();
            }
            this.avL.addView(bVar.avY, i);
            if (i == -1) {
                this.avP.add(bVar);
            } else {
                this.avP.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.avQ != null) {
            this.avQ.setScrollable(z);
        }
    }

    public void initViewPager() {
        di(0);
    }

    public void di(int i) {
        if (this.avQ != null) {
            removeView(this.avQ);
        }
        this.avQ = new CustomViewPager(this.mContext);
        this.avQ.setId(e.g.tab_content);
        dj(i);
        addView(this.avQ);
        removeView(this.avT);
        addView(this.avT);
        this.avQ.setOffscreenPageLimit(this.avP.size() - 1);
        this.avQ.setOnPageChangeListener(this);
        this.avS = new FragmentAdapter(this.mFragmentManager, this.avP);
        this.avQ.setAdapter(this.avS);
    }

    public void Bt() {
        if (this.avQ != null) {
            removeView(this.avQ);
        }
        this.avQ = new CustomViewPager(this.mContext);
        this.avQ.setId(e.g.tab_content);
        addView(this.avQ);
        removeView(this.avT);
        addView(this.avT);
        this.avQ.setOffscreenPageLimit(this.avP.size() - 1);
        this.avQ.setOnPageChangeListener(this);
        this.avS = new FragmentAdapter(this.mFragmentManager, this.avP);
        this.avQ.setAdapter(this.avS);
    }

    public void dj(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.avQ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.avQ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.avT.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.avT.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.avT.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0200e.ds98);
            this.avT.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0200e.ds88);
            this.avT.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.avT.setVisibility(8);
        }
        this.avQ.setLayoutParams(layoutParams);
        this.avT.setLayoutParams(layoutParams2);
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
        this.avR = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.avP.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.avN = this.avP.get(this.mCurrentTabIndex);
            this.avL.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.avQ != null) {
                this.avQ.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.avP.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.avP.get(i3).mType) {
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
        this.avN = this.avP.get(i);
        if (this.avR == null || this.avR.onPreTabSelectionChange(i, z)) {
            if (this.avR != null) {
                this.avR.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.avL.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.avP.size()) {
            return -1;
        }
        return this.avP.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.avN != null) {
            return this.avN.avZ;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.avQ;
    }

    public ViewGroup getTabWrapper() {
        return this.avT;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.avL;
    }

    public b dk(int i) {
        if (i < 0 || i >= this.avP.size()) {
            return null;
        }
        return this.avP.get(i);
    }

    public b dl(int i) {
        for (b bVar : this.avP) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.avQ != null && this.avS != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.avP.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.avQ.getId(), this.avS.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.avP) {
                if (bVar.awa != null) {
                    bVar.awa.gy();
                }
            }
            this.avP.clear();
            this.avN = null;
            this.mCurrentTabIndex = -1;
            this.avL.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.avO) {
            this.avT.setBackgroundDrawable(new BitmapDrawable(al.dC(e.f.s_tabbar_bg)));
        } else {
            al.j(this.avT, this.avW);
        }
        this.avL.onChangeSkinType(i);
        al.j(this.avV, e.d.cp_bg_line_b);
        for (b bVar : this.avP) {
            bVar.avY.eo(i);
        }
        if (this.avS != null) {
            int count = this.avS.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.avS.getItem(i2);
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
        this.avL.d(i, f);
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
        this.avN = this.avP.get(i);
        this.avL.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.avN.avZ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> avX;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.avX = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.avX.get(i).avZ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.avX.get(i).avZ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.avX.size();
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
        this.avO = z;
    }

    public void Bu() {
        if (this.avT != null && this.avT.getVisibility() != 0) {
            this.avT.setVisibility(0);
        }
    }

    public void Bv() {
        if (this.avT != null && this.avT.getVisibility() != 8) {
            this.avT.setVisibility(8);
        }
    }
}
