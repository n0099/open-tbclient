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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private final List<b> afA;
    private CustomViewPager afB;
    private a afC;
    private FragmentAdapter afD;
    private FrameLayout afE;
    private int afF;
    private View afG;
    private FragmentTabWidget afx;
    private b afy;
    private boolean afz;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, boolean z);

        boolean j(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator afI;
        public Fragment afJ;
        public com.baidu.tbadk.mainTab.b afK;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.afz = true;
        this.afA = new ArrayList();
        this.mOnPageChangeListener = null;
        this.afF = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afz = true;
        this.afA = new ArrayList();
        this.mOnPageChangeListener = null;
        this.afF = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.fragment_tabhost, (ViewGroup) this, true);
        this.afE = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.afy = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.afx != null) {
            this.afx.getLayoutParams().height = i;
            this.afx.requestLayout();
            this.afE.getLayoutParams().height = i;
            this.afE.requestLayout();
            this.afF = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.afE;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.afx != null) {
            this.afx.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.afx != null) {
            this.afx.setShouldDrawTopLine(z);
        }
    }

    public void aB(boolean z) {
        if (this.afG == null) {
            this.afG = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.afG.setVisibility(8);
            return;
        }
        if (this.afx != null) {
            this.afx.setShouldDrawTopLine(false);
        }
        int dip2px = this.afF + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.afG.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.afG.setLayoutParams(layoutParams);
        this.afG.setVisibility(0);
        ak.j(this.afG, d.C0126d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.afx.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.afx != null) {
            this.afx.setShouldDrawTopLine(z);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.afx = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.afx.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.afx.setPadding(i, i2, i3, i4);
    }

    public void aC(boolean z) {
        this.afx.aC(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.afI == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.afJ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.afA.contains(bVar)) {
            if (bVar.afK != null) {
                bVar.afK.Fw();
            }
            this.afx.addView(bVar.afI, i);
            if (i == -1) {
                this.afA.add(bVar);
            } else {
                this.afA.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.afB != null) {
            this.afB.setScrollable(z);
        }
    }

    public void initViewPager() {
        cu(0);
    }

    public void cu(int i) {
        if (this.afB != null) {
            removeView(this.afB);
        }
        this.afB = new CustomViewPager(this.mContext);
        this.afB.setId(d.g.tab_content);
        cv(i);
        addView(this.afB);
        removeView(this.afE);
        addView(this.afE);
        this.afB.setOffscreenPageLimit(this.afA.size() - 1);
        this.afB.setOnPageChangeListener(this);
        this.afD = new FragmentAdapter(this.mFragmentManager, this.afA);
        this.afB.setAdapter(this.afD);
    }

    public void uw() {
        if (this.afB != null) {
            removeView(this.afB);
        }
        this.afB = new CustomViewPager(this.mContext);
        this.afB.setId(d.g.tab_content);
        addView(this.afB);
        removeView(this.afE);
        addView(this.afE);
        this.afB.setOffscreenPageLimit(this.afA.size() - 1);
        this.afB.setOnPageChangeListener(this);
        this.afD = new FragmentAdapter(this.mFragmentManager, this.afA);
        this.afB.setAdapter(this.afD);
    }

    public void cv(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.afB.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.afB.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.afE.getLayoutParams();
            layoutParams2.height = -2;
        }
        f(layoutParams.getRules());
        f(layoutParams2.getRules());
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
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.e(this.mContext, d.e.ds88);
        }
        this.afB.setLayoutParams(layoutParams);
        this.afE.setLayoutParams(layoutParams2);
    }

    private void f(int[] iArr) {
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
        this.afC = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.afA.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.afy = this.afA.get(this.mCurrentTabIndex);
            this.afx.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.afB != null) {
                this.afB.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.afA.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.afA.get(i3).mType) {
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
    public void i(int i, boolean z) {
        this.afy = this.afA.get(i);
        if (this.afC == null || this.afC.j(i, z)) {
            if (this.afC != null) {
                this.afC.i(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.afx.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.afA.size()) {
            return -1;
        }
        return this.afA.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.afy != null) {
            return this.afy.afJ;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.afx;
    }

    public b cw(int i) {
        if (i < 0 || i >= this.afA.size()) {
            return null;
        }
        return this.afA.get(i);
    }

    public b cx(int i) {
        for (b bVar : this.afA) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.afA.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.afB.getId(), this.afD.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.afA) {
            if (bVar.afK != null) {
                bVar.afK.ck();
            }
        }
        this.afA.clear();
        this.afy = null;
        this.mCurrentTabIndex = -1;
        this.afx.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ak.cP(d.f.s_tabbar_bg));
        if (i == 2 && this.afz) {
            this.afE.setBackgroundDrawable(bitmapDrawable);
        } else {
            ak.j(this.afE, d.C0126d.cp_bg_line_d);
        }
        this.afx.onChangeSkinType(i);
        if (this.afG != null) {
            ak.j(this.afG, d.C0126d.cp_bg_line_b);
        }
        for (b bVar : this.afA) {
            bVar.afI.dz(i);
        }
        if (this.afD != null) {
            int count = this.afD.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.afD.getItem(i2);
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
        this.afx.b(i, f);
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
        this.afy = this.afA.get(i);
        this.afx.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.afy.afJ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> afH;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.afH = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.afH.get(i).afJ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.afH.get(i).afJ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.afH.size();
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
        this.afz = z;
    }

    public void ux() {
        if (this.afE != null && this.afE.getVisibility() != 0) {
            this.afE.setVisibility(0);
        }
    }

    public void uy() {
        if (this.afE != null && this.afE.getVisibility() != 8) {
            this.afE.setVisibility(8);
        }
    }
}
