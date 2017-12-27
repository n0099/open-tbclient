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
    private FragmentTabWidget aSG;
    private c aSH;
    private boolean aSI;
    private final List<c> aSJ;
    private CustomViewPager aSK;
    private b aSL;
    private a aSM;
    private FrameLayout aSN;
    private int aSO;
    private View aSP;
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
        public e aSR;
        public Fragment aSS;
        public com.baidu.tbadk.mainTab.b aST;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aSI = true;
        this.aSJ = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSO = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSI = true;
        this.aSJ = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSO = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aSN = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aSH = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aSG != null) {
            this.aSG.getLayoutParams().height = i;
            this.aSG.requestLayout();
            this.aSN.getLayoutParams().height = i;
            this.aSN.requestLayout();
            this.aSO = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aSN;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aSG != null) {
            this.aSG.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aSG != null) {
            this.aSG.setShouldDrawTopLine(z);
        }
    }

    public void bf(boolean z) {
        if (this.aSP == null) {
            this.aSP = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aSP.setVisibility(8);
            return;
        }
        if (this.aSG != null) {
            this.aSG.setShouldDrawTopLine(false);
        }
        int dip2px = this.aSO + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aSP.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aSP.setLayoutParams(layoutParams);
        this.aSP.setVisibility(0);
        aj.t(this.aSP, d.C0108d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aSG.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aSG = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aSG.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aSG.setPadding(i, i2, i3, i4);
    }

    public void bg(boolean z) {
        this.aSG.bg(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aSR == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aSS == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aSJ.contains(cVar)) {
            if (cVar.aST != null) {
                cVar.aST.Mx();
            }
            this.aSG.addView(cVar.aSR, i);
            if (i == -1) {
                this.aSJ.add(cVar);
            } else {
                this.aSJ.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aSK != null) {
            this.aSK.setScrollable(z);
        }
    }

    public void initViewPager() {
        fy(0);
    }

    public void fy(int i) {
        if (this.aSK != null) {
            removeView(this.aSK);
        }
        this.aSK = new CustomViewPager(this.mContext);
        this.aSK.setId(d.g.tab_content);
        fz(i);
        addView(this.aSK);
        removeView(this.aSN);
        addView(this.aSN);
        this.aSK.setOffscreenPageLimit(this.aSJ.size() - 1);
        this.aSK.setOnPageChangeListener(this);
        this.aSM = new a(this.mFragmentManager, this.aSJ);
        this.aSK.setAdapter(this.aSM);
    }

    public void BC() {
        if (this.aSK != null) {
            removeView(this.aSK);
        }
        this.aSK = new CustomViewPager(this.mContext);
        this.aSK.setId(d.g.tab_content);
        addView(this.aSK);
        removeView(this.aSN);
        addView(this.aSN);
        this.aSK.setOffscreenPageLimit(this.aSJ.size() - 1);
        this.aSK.setOnPageChangeListener(this);
        this.aSM = new a(this.mFragmentManager, this.aSJ);
        this.aSK.setAdapter(this.aSM);
    }

    public void fz(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aSK.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aSK.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aSN.getLayoutParams();
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
        this.aSK.setLayoutParams(layoutParams);
        this.aSN.setLayoutParams(layoutParams2);
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
        this.aSL = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aSJ.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aSH = this.aSJ.get(this.mCurrentTabIndex);
            this.aSG.a(this.mCurrentTabIndex, true, false);
            if (this.aSK != null) {
                this.aSK.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aSJ.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aSJ.get(i3).mType) {
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
        this.aSH = this.aSJ.get(i);
        if (this.aSL == null || this.aSL.q(i, z)) {
            if (this.aSL != null) {
                this.aSL.p(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aSG.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aSJ.size()) {
            return -1;
        }
        return this.aSJ.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aSH != null) {
            return this.aSH.aSS;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aSG;
    }

    public c fA(int i) {
        if (i < 0 || i >= this.aSJ.size()) {
            return null;
        }
        return this.aSJ.get(i);
    }

    public c fB(int i) {
        for (c cVar : this.aSJ) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aSJ.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aSK.getId(), this.aSM.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aSJ) {
            if (cVar.aST != null) {
                cVar.aST.kg();
            }
        }
        this.aSJ.clear();
        this.aSH = null;
        this.mCurrentTabIndex = -1;
        this.aSG.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fS(d.f.s_tabbar_bg));
        if (i == 2 && this.aSI) {
            this.aSN.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aSN, d.C0108d.cp_bg_line_d);
        }
        this.aSG.onChangeSkinType(i);
        if (this.aSP != null) {
            aj.t(this.aSP, d.C0108d.cp_bg_line_b);
        }
        for (c cVar : this.aSJ) {
            cVar.aSR.gC(i);
        }
        if (this.aSM != null) {
            int count = this.aSM.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aSM.getItem(i2);
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
        this.aSG.g(i, f);
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
        this.aSH = this.aSJ.get(i);
        this.aSG.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aSH.aSS.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aSQ;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aSQ = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aSQ.get(i).aSS;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aSQ.get(i).aSS.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aSQ.size();
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
        this.aSI = z;
    }
}
