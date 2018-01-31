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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget aSI;
    private c aSJ;
    private boolean aSK;
    private final List<c> aSL;
    private CustomViewPager aSM;
    private b aSN;
    private a aSO;
    private FrameLayout aSP;
    private int aSQ;
    private View aSR;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void p(int i, boolean z);

        boolean q(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public e aST;
        public Fragment aSU;
        public com.baidu.tbadk.mainTab.b aSV;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aSK = true;
        this.aSL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSQ = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSK = true;
        this.aSL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSQ = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aSP = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aSJ = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aSI != null) {
            this.aSI.getLayoutParams().height = i;
            this.aSI.requestLayout();
            this.aSP.getLayoutParams().height = i;
            this.aSP.requestLayout();
            this.aSQ = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aSP;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aSI != null) {
            this.aSI.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aSI != null) {
            this.aSI.setShouldDrawTopLine(z);
        }
    }

    public void bg(boolean z) {
        if (this.aSR == null) {
            this.aSR = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aSR.setVisibility(8);
            return;
        }
        if (this.aSI != null) {
            this.aSI.setShouldDrawTopLine(false);
        }
        int dip2px = this.aSQ + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aSR.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aSR.setLayoutParams(layoutParams);
        this.aSR.setVisibility(0);
        aj.t(this.aSR, d.C0108d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aSI.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aSI = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aSI.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aSI.setPadding(i, i2, i3, i4);
    }

    public void bh(boolean z) {
        this.aSI.bh(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aST == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aSU == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aSL.contains(cVar)) {
            if (cVar.aSV != null) {
                cVar.aSV.Mn();
            }
            this.aSI.addView(cVar.aST, i);
            if (i == -1) {
                this.aSL.add(cVar);
            } else {
                this.aSL.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aSM != null) {
            this.aSM.setScrollable(z);
        }
    }

    public void initViewPager() {
        fw(0);
    }

    public void fw(int i) {
        if (this.aSM != null) {
            removeView(this.aSM);
        }
        this.aSM = new CustomViewPager(this.mContext);
        this.aSM.setId(d.g.tab_content);
        fx(i);
        addView(this.aSM);
        removeView(this.aSP);
        addView(this.aSP);
        this.aSM.setOffscreenPageLimit(this.aSL.size() - 1);
        this.aSM.setOnPageChangeListener(this);
        this.aSO = new a(this.mFragmentManager, this.aSL);
        this.aSM.setAdapter(this.aSO);
    }

    public void Bv() {
        if (this.aSM != null) {
            removeView(this.aSM);
        }
        this.aSM = new CustomViewPager(this.mContext);
        this.aSM.setId(d.g.tab_content);
        addView(this.aSM);
        removeView(this.aSP);
        addView(this.aSP);
        this.aSM.setOffscreenPageLimit(this.aSL.size() - 1);
        this.aSM.setOnPageChangeListener(this);
        this.aSO = new a(this.mFragmentManager, this.aSL);
        this.aSM.setAdapter(this.aSO);
    }

    public void fx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aSM.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aSM.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aSP.getLayoutParams();
            layoutParams2.height = -2;
        }
        m(layoutParams.getRules());
        m(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.s(this.mContext, d.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.s(this.mContext, d.e.ds88);
        }
        this.aSM.setLayoutParams(layoutParams);
        this.aSP.setLayoutParams(layoutParams2);
    }

    private void m(int[] iArr) {
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

    public void setOnTabSelectionListener(b bVar) {
        this.aSN = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aSL.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aSJ = this.aSL.get(this.mCurrentTabIndex);
            this.aSI.a(this.mCurrentTabIndex, true, false);
            if (this.aSM != null) {
                this.aSM.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aSL.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aSL.get(i3).mType) {
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
    public void p(int i, boolean z) {
        this.aSJ = this.aSL.get(i);
        if (this.aSN == null || this.aSN.q(i, z)) {
            if (this.aSN != null) {
                this.aSN.p(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aSI.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aSL.size()) {
            return -1;
        }
        return this.aSL.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aSJ != null) {
            return this.aSJ.aSU;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aSI;
    }

    public c fy(int i) {
        if (i < 0 || i >= this.aSL.size()) {
            return null;
        }
        return this.aSL.get(i);
    }

    public c fz(int i) {
        for (c cVar : this.aSL) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aSL.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aSM.getId(), this.aSO.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aSL) {
            if (cVar.aSV != null) {
                cVar.aSV.kg();
            }
        }
        this.aSL.clear();
        this.aSJ = null;
        this.mCurrentTabIndex = -1;
        this.aSI.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fQ(d.f.s_tabbar_bg));
        if (i == 2 && this.aSK) {
            this.aSP.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aSP, d.C0108d.cp_bg_line_d);
        }
        this.aSI.onChangeSkinType(i);
        if (this.aSR != null) {
            aj.t(this.aSR, d.C0108d.cp_bg_line_b);
        }
        for (c cVar : this.aSL) {
            cVar.aST.gz(i);
        }
        if (this.aSO != null) {
            int count = this.aSO.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aSO.getItem(i2);
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
        this.aSI.g(i, f);
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
        this.aSJ = this.aSL.get(i);
        this.aSI.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aSJ.aSU.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aSS;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aSS = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aSS.get(i).aSU;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aSS.get(i).aSU.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aSS.size();
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
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.aSK = z;
    }
}
