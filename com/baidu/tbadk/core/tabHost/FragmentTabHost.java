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
    private FragmentTabWidget aec;
    private c aed;
    private boolean aee;
    private final List<c> aef;
    private CustomViewPager aeg;
    private b aeh;
    private a aei;
    private FrameLayout aej;
    private int aek;
    private View ael;
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
        public e aen;
        public Fragment aeo;
        public com.baidu.tbadk.mainTab.b aep;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aee = true;
        this.aef = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aek = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aee = true;
        this.aef = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aek = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aej = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aed = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aec != null) {
            this.aec.getLayoutParams().height = i;
            this.aec.requestLayout();
            this.aej.getLayoutParams().height = i;
            this.aej.requestLayout();
            this.aek = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aej;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aec != null) {
            this.aec.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aec != null) {
            this.aec.setShouldDrawTopLine(z);
        }
    }

    public void ax(boolean z) {
        if (this.ael == null) {
            this.ael = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.ael.setVisibility(8);
            return;
        }
        if (this.aec != null) {
            this.aec.setShouldDrawTopLine(false);
        }
        int dip2px = this.aek + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ael.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.ael.setLayoutParams(layoutParams);
        this.ael.setVisibility(0);
        aj.k(this.ael, d.C0080d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aec.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aec = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aec.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.aec.setPadding(i, i2, i3, i4);
    }

    public void ay(boolean z) {
        this.aec.ay(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aen == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aeo == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aef.contains(cVar)) {
            if (cVar.aep != null) {
                cVar.aep.EE();
            }
            this.aec.addView(cVar.aen, i);
            if (i == -1) {
                this.aef.add(cVar);
            } else {
                this.aef.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aeg != null) {
            this.aeg.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.aeg != null) {
            removeView(this.aeg);
        }
        this.aeg = new CustomViewPager(this.mContext);
        this.aeg.setId(d.g.tab_content);
        cA(i);
        addView(this.aeg);
        removeView(this.aej);
        addView(this.aej);
        this.aeg.setOffscreenPageLimit(this.aef.size() - 1);
        this.aeg.setOnPageChangeListener(this);
        this.aei = new a(this.mFragmentManager, this.aef);
        this.aeg.setAdapter(this.aei);
    }

    public void uc() {
        if (this.aeg != null) {
            removeView(this.aeg);
        }
        this.aeg = new CustomViewPager(this.mContext);
        this.aeg.setId(d.g.tab_content);
        addView(this.aeg);
        removeView(this.aej);
        addView(this.aej);
        this.aeg.setOffscreenPageLimit(this.aef.size() - 1);
        this.aeg.setOnPageChangeListener(this);
        this.aei = new a(this.mFragmentManager, this.aef);
        this.aeg.setAdapter(this.aei);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aeg.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aeg.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aej.getLayoutParams();
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
        this.aeg.setLayoutParams(layoutParams);
        this.aej.setLayoutParams(layoutParams2);
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
        this.aeh = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aef.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aed = this.aef.get(this.mCurrentTabIndex);
            this.aec.a(this.mCurrentTabIndex, true, false);
            if (this.aeg != null) {
                this.aeg.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aef.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aef.get(i3).mType) {
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
        this.aed = this.aef.get(i);
        if (this.aeh == null || this.aeh.f(i, z)) {
            if (this.aeh != null) {
                this.aeh.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aec.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aef.size()) {
            return -1;
        }
        return this.aef.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aed != null) {
            return this.aed.aeo;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aec;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.aef.size()) {
            return null;
        }
        return this.aef.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.aef) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aef.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aeg.getId(), this.aei.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aef) {
            if (cVar.aep != null) {
                cVar.aep.cB();
            }
        }
        this.aef.clear();
        this.aed = null;
        this.mCurrentTabIndex = -1;
        this.aec.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cT(d.f.s_tabbar_bg));
        if (i == 2 && this.aee) {
            this.aej.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.aej, d.C0080d.cp_bg_line_d);
        }
        this.aec.onChangeSkinType(i);
        if (this.ael != null) {
            aj.k(this.ael, d.C0080d.cp_bg_line_b);
        }
        for (c cVar : this.aef) {
            cVar.aen.dE(i);
        }
        if (this.aei != null) {
            int count = this.aei.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aei.getItem(i2);
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
        this.aec.b(i, f);
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
        this.aed = this.aef.get(i);
        this.aec.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aed.aeo.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aem;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aem = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aem.get(i).aeo;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aem.get(i).aeo.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aem.size();
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
        this.aee = z;
    }
}
