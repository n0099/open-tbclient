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
    private FragmentTabWidget aSF;
    private c aSG;
    private boolean aSH;
    private final List<c> aSI;
    private CustomViewPager aSJ;
    private b aSK;
    private a aSL;
    private FrameLayout aSM;
    private int aSN;
    private View aSO;
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
        public e aSQ;
        public Fragment aSR;
        public com.baidu.tbadk.mainTab.b aSS;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aSH = true;
        this.aSI = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSN = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSH = true;
        this.aSI = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aSN = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aSM = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aSG = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aSF != null) {
            this.aSF.getLayoutParams().height = i;
            this.aSF.requestLayout();
            this.aSM.getLayoutParams().height = i;
            this.aSM.requestLayout();
            this.aSN = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aSM;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aSF != null) {
            this.aSF.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aSF != null) {
            this.aSF.setShouldDrawTopLine(z);
        }
    }

    public void bf(boolean z) {
        if (this.aSO == null) {
            this.aSO = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aSO.setVisibility(8);
            return;
        }
        if (this.aSF != null) {
            this.aSF.setShouldDrawTopLine(false);
        }
        int dip2px = this.aSN + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aSO.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aSO.setLayoutParams(layoutParams);
        this.aSO.setVisibility(0);
        aj.t(this.aSO, d.C0107d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aSF.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aSF = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aSF.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aSF.setPadding(i, i2, i3, i4);
    }

    public void bg(boolean z) {
        this.aSF.bg(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aSQ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aSR == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aSI.contains(cVar)) {
            if (cVar.aSS != null) {
                cVar.aSS.Ml();
            }
            this.aSF.addView(cVar.aSQ, i);
            if (i == -1) {
                this.aSI.add(cVar);
            } else {
                this.aSI.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aSJ != null) {
            this.aSJ.setScrollable(z);
        }
    }

    public void initViewPager() {
        fw(0);
    }

    public void fw(int i) {
        if (this.aSJ != null) {
            removeView(this.aSJ);
        }
        this.aSJ = new CustomViewPager(this.mContext);
        this.aSJ.setId(d.g.tab_content);
        fx(i);
        addView(this.aSJ);
        removeView(this.aSM);
        addView(this.aSM);
        this.aSJ.setOffscreenPageLimit(this.aSI.size() - 1);
        this.aSJ.setOnPageChangeListener(this);
        this.aSL = new a(this.mFragmentManager, this.aSI);
        this.aSJ.setAdapter(this.aSL);
    }

    public void Bu() {
        if (this.aSJ != null) {
            removeView(this.aSJ);
        }
        this.aSJ = new CustomViewPager(this.mContext);
        this.aSJ.setId(d.g.tab_content);
        addView(this.aSJ);
        removeView(this.aSM);
        addView(this.aSM);
        this.aSJ.setOffscreenPageLimit(this.aSI.size() - 1);
        this.aSJ.setOnPageChangeListener(this);
        this.aSL = new a(this.mFragmentManager, this.aSI);
        this.aSJ.setAdapter(this.aSL);
    }

    public void fx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aSJ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aSJ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aSM.getLayoutParams();
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
        this.aSJ.setLayoutParams(layoutParams);
        this.aSM.setLayoutParams(layoutParams2);
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
        this.aSK = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aSI.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aSG = this.aSI.get(this.mCurrentTabIndex);
            this.aSF.a(this.mCurrentTabIndex, true, false);
            if (this.aSJ != null) {
                this.aSJ.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aSI.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aSI.get(i3).mType) {
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
        this.aSG = this.aSI.get(i);
        if (this.aSK == null || this.aSK.q(i, z)) {
            if (this.aSK != null) {
                this.aSK.p(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aSF.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aSI.size()) {
            return -1;
        }
        return this.aSI.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aSG != null) {
            return this.aSG.aSR;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aSF;
    }

    public c fy(int i) {
        if (i < 0 || i >= this.aSI.size()) {
            return null;
        }
        return this.aSI.get(i);
    }

    public c fz(int i) {
        for (c cVar : this.aSI) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aSI.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aSJ.getId(), this.aSL.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aSI) {
            if (cVar.aSS != null) {
                cVar.aSS.kg();
            }
        }
        this.aSI.clear();
        this.aSG = null;
        this.mCurrentTabIndex = -1;
        this.aSF.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fQ(d.f.s_tabbar_bg));
        if (i == 2 && this.aSH) {
            this.aSM.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aSM, d.C0107d.cp_bg_line_d);
        }
        this.aSF.onChangeSkinType(i);
        if (this.aSO != null) {
            aj.t(this.aSO, d.C0107d.cp_bg_line_b);
        }
        for (c cVar : this.aSI) {
            cVar.aSQ.gz(i);
        }
        if (this.aSL != null) {
            int count = this.aSL.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aSL.getItem(i2);
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
        this.aSF.g(i, f);
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
        this.aSG = this.aSI.get(i);
        this.aSF.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aSG.aSR.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aSP;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aSP = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aSP.get(i).aSR;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aSP.get(i).aSR.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aSP.size();
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
        this.aSH = z;
    }
}
