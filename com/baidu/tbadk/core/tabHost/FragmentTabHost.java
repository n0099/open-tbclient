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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget afi;
    private int afj;
    private c afk;
    private boolean afl;
    private final List<c> afm;
    private CustomViewPager afn;
    private b afo;
    private a afp;
    private FrameLayout afq;
    private int afr;
    private View afs;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);

        boolean g(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator afv;
        public Fragment afw;
        public com.baidu.tbadk.mainTab.b afx;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.afl = true;
        this.afm = new ArrayList();
        this.mOnPageChangeListener = null;
        this.afr = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afl = true;
        this.afm = new ArrayList();
        this.mOnPageChangeListener = null;
        this.afr = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.afq = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.afj = -1;
        this.afk = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.afi != null) {
            this.afi.getLayoutParams().height = i;
            this.afi.requestLayout();
            this.afq.getLayoutParams().height = i;
            this.afq.requestLayout();
            this.afr = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.afq;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.afi != null) {
            this.afi.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.afi != null) {
            this.afi.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.afs == null) {
            this.afs = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.afs.setVisibility(8);
            return;
        }
        if (this.afi != null) {
            this.afi.setShouldDrawTopLine(false);
        }
        int dip2px = this.afr + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.afs.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.afs.setLayoutParams(layoutParams);
        this.afs.setVisibility(0);
        ai.k(this.afs, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.afi.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.afi = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.afi.setTabSelectionListener(this);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.afi.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.afi.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.afv == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.afw == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.afm.contains(cVar)) {
            if (cVar.afx != null) {
                cVar.afx.EV();
            }
            this.afi.addView(cVar.afv, i);
            if (i == -1) {
                this.afm.add(cVar);
            } else {
                this.afm.add(i, cVar);
            }
            if (this.afj != -1 && i <= this.afj) {
                this.afj++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.afn != null) {
            this.afn.setScrollable(z);
        }
    }

    public void initViewPager() {
        cB(0);
    }

    public void cB(int i) {
        if (this.afn != null) {
            removeView(this.afn);
        }
        this.afn = new CustomViewPager(this.mContext);
        this.afn.setId(d.h.tab_content);
        cC(i);
        addView(this.afn);
        removeView(this.afq);
        addView(this.afq);
        this.afn.setOffscreenPageLimit(this.afm.size() - 1);
        this.afn.setOnPageChangeListener(this);
        this.afp = new a(this.mFragmentManager, this.afm);
        this.afn.setAdapter(this.afp);
    }

    public void uD() {
        if (this.afn != null) {
            removeView(this.afn);
        }
        this.afn = new CustomViewPager(this.mContext);
        this.afn.setId(d.h.tab_content);
        addView(this.afn);
        removeView(this.afq);
        addView(this.afq);
        this.afn.setOffscreenPageLimit(this.afm.size() - 1);
        this.afn.setOnPageChangeListener(this);
        this.afp = new a(this.mFragmentManager, this.afm);
        this.afn.setAdapter(this.afp);
    }

    public void cC(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.afn.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.afn.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.afq.getLayoutParams();
            layoutParams2.height = -2;
        }
        c(layoutParams.getRules());
        c(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.h.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.g(this.mContext, d.f.ds98);
        }
        this.afn.setLayoutParams(layoutParams);
        this.afq.setLayoutParams(layoutParams2);
    }

    private void c(int[] iArr) {
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
        this.afo = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.afm.size() && i != this.afj) {
            this.afj = i;
            this.afk = this.afm.get(this.afj);
            this.afi.h(this.afj, true);
            if (this.afn != null) {
                this.afn.setCurrentItem(this.afj, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.afm.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.afm.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.afj == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.afk = this.afm.get(i);
        if (this.afo == null || this.afo.g(i, z)) {
            if (this.afo != null) {
                this.afo.f(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.afi.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.afj;
    }

    public int getCurrentTabType() {
        if (this.afj < 0 || this.afj >= this.afm.size()) {
            return -1;
        }
        return this.afm.get(this.afj).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.afk != null) {
            return this.afk.afw;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.afi;
    }

    public c cD(int i) {
        if (i < 0 || i >= this.afm.size()) {
            return null;
        }
        return this.afm.get(i);
    }

    public c cE(int i) {
        for (c cVar : this.afm) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.afm.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.afn.getId(), this.afp.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.afm) {
            if (cVar.afx != null) {
                cVar.afx.cM();
            }
        }
        this.afm.clear();
        this.afk = null;
        this.afj = -1;
        this.afi.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ai.cU(d.g.s_tabbar_bg));
        if (i == 2 && this.afl) {
            this.afq.setBackgroundDrawable(bitmapDrawable);
        } else {
            ai.k(this.afq, d.e.common_color_10274);
        }
        this.afi.onChangeSkinType(i);
        if (this.afs != null) {
            ai.k(this.afs, d.e.cp_bg_line_b);
        }
        for (c cVar : this.afm) {
            cVar.afv.dt(i);
        }
        if (this.afp != null) {
            int count = this.afp.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.afp.getItem(i2);
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
        this.afi.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.afj = i;
        this.afk = this.afm.get(i);
        this.afi.h(this.afj, false);
        ViewGroup viewGroup = (ViewGroup) this.afk.afw.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int aft;
        private List<c> afu;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.aft = -1;
            this.afu = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.afu.get(i).afw;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.afu.get(i).afw.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.afu.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.aft != i) {
                if (this.aft != -1) {
                    ((BaseFragment) getItem(this.aft)).setPrimary(false);
                }
                this.aft = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.afl = z;
    }
}
