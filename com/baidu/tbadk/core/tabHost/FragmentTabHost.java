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
    private final List<c> aeA;
    private CustomViewPager aeB;
    private b aeC;
    private a aeD;
    private FrameLayout aeE;
    private int aeF;
    private View aeG;
    private FragmentTabWidget aex;
    private c aey;
    private boolean aez;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, boolean z);

        boolean f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public e aeI;
        public Fragment aeJ;
        public com.baidu.tbadk.mainTab.b aeK;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aez = true;
        this.aeA = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aeF = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aez = true;
        this.aeA = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aeF = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aeE = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aey = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aex != null) {
            this.aex.getLayoutParams().height = i;
            this.aex.requestLayout();
            this.aeE.getLayoutParams().height = i;
            this.aeE.requestLayout();
            this.aeF = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aeE;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aex != null) {
            this.aex.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aex != null) {
            this.aex.setShouldDrawTopLine(z);
        }
    }

    public void ax(boolean z) {
        if (this.aeG == null) {
            this.aeG = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aeG.setVisibility(8);
            return;
        }
        if (this.aex != null) {
            this.aex.setShouldDrawTopLine(false);
        }
        int dip2px = this.aeF + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aeG.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aeG.setLayoutParams(layoutParams);
        this.aeG.setVisibility(0);
        aj.k(this.aeG, d.C0082d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aex.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aex = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aex.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.aex.setPadding(i, i2, i3, i4);
    }

    public void ay(boolean z) {
        this.aex.ay(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aeI == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aeJ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aeA.contains(cVar)) {
            if (cVar.aeK != null) {
                cVar.aeK.EX();
            }
            this.aex.addView(cVar.aeI, i);
            if (i == -1) {
                this.aeA.add(cVar);
            } else {
                this.aeA.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aeB != null) {
            this.aeB.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.aeB != null) {
            removeView(this.aeB);
        }
        this.aeB = new CustomViewPager(this.mContext);
        this.aeB.setId(d.g.tab_content);
        cA(i);
        addView(this.aeB);
        removeView(this.aeE);
        addView(this.aeE);
        this.aeB.setOffscreenPageLimit(this.aeA.size() - 1);
        this.aeB.setOnPageChangeListener(this);
        this.aeD = new a(this.mFragmentManager, this.aeA);
        this.aeB.setAdapter(this.aeD);
    }

    public void uf() {
        if (this.aeB != null) {
            removeView(this.aeB);
        }
        this.aeB = new CustomViewPager(this.mContext);
        this.aeB.setId(d.g.tab_content);
        addView(this.aeB);
        removeView(this.aeE);
        addView(this.aeE);
        this.aeB.setOffscreenPageLimit(this.aeA.size() - 1);
        this.aeB.setOnPageChangeListener(this);
        this.aeD = new a(this.mFragmentManager, this.aeA);
        this.aeB.setAdapter(this.aeD);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aeB.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aeB.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aeE.getLayoutParams();
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
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.f(this.mContext, d.e.ds88);
        }
        this.aeB.setLayoutParams(layoutParams);
        this.aeE.setLayoutParams(layoutParams2);
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

    public void setOnTabSelectionListener(b bVar) {
        this.aeC = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aeA.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aey = this.aeA.get(this.mCurrentTabIndex);
            this.aex.a(this.mCurrentTabIndex, true, false);
            if (this.aeB != null) {
                this.aeB.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aeA.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aeA.get(i3).mType) {
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
    public void e(int i, boolean z) {
        this.aey = this.aeA.get(i);
        if (this.aeC == null || this.aeC.f(i, z)) {
            if (this.aeC != null) {
                this.aeC.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aex.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aeA.size()) {
            return -1;
        }
        return this.aeA.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aey != null) {
            return this.aey.aeJ;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aex;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.aeA.size()) {
            return null;
        }
        return this.aeA.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.aeA) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aeA.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aeB.getId(), this.aeD.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aeA) {
            if (cVar.aeK != null) {
                cVar.aeK.cB();
            }
        }
        this.aeA.clear();
        this.aey = null;
        this.mCurrentTabIndex = -1;
        this.aex.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cT(d.f.s_tabbar_bg));
        if (i == 2 && this.aez) {
            this.aeE.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.aeE, d.C0082d.cp_bg_line_d);
        }
        this.aex.onChangeSkinType(i);
        if (this.aeG != null) {
            aj.k(this.aeG, d.C0082d.cp_bg_line_b);
        }
        for (c cVar : this.aeA) {
            cVar.aeI.dE(i);
        }
        if (this.aeD != null) {
            int count = this.aeD.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aeD.getItem(i2);
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
        this.aex.b(i, f);
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
        this.aey = this.aeA.get(i);
        this.aex.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aey.aeJ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aeH;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aeH = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aeH.get(i).aeJ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aeH.get(i).aeJ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aeH.size();
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
        this.aez = z;
    }
}
