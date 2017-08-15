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
    private FragmentTabWidget afk;
    private int afl;
    private c afm;
    private boolean afn;
    private final List<c> afo;
    private CustomViewPager afp;
    private b afq;
    private a afr;
    private FrameLayout afs;
    private int aft;
    private View afu;
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
        public FragmentTabIndicator afx;
        public Fragment afy;
        public com.baidu.tbadk.mainTab.b afz;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.afn = true;
        this.afo = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aft = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afn = true;
        this.afo = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aft = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.afs = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.afl = -1;
        this.afm = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.afk != null) {
            this.afk.getLayoutParams().height = i;
            this.afk.requestLayout();
            this.afs.getLayoutParams().height = i;
            this.afs.requestLayout();
            this.aft = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.afs;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.afk != null) {
            this.afk.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.afk != null) {
            this.afk.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.afu == null) {
            this.afu = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.afu.setVisibility(8);
            return;
        }
        if (this.afk != null) {
            this.afk.setShouldDrawTopLine(false);
        }
        int dip2px = this.aft + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.afu.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.afu.setLayoutParams(layoutParams);
        this.afu.setVisibility(0);
        ai.k(this.afu, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.afk.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.afk = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.afk.setTabSelectionListener(this);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.afk.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.afk.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.afx == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.afy == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.afo.contains(cVar)) {
            if (cVar.afz != null) {
                cVar.afz.EV();
            }
            this.afk.addView(cVar.afx, i);
            if (i == -1) {
                this.afo.add(cVar);
            } else {
                this.afo.add(i, cVar);
            }
            if (this.afl != -1 && i <= this.afl) {
                this.afl++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.afp != null) {
            this.afp.setScrollable(z);
        }
    }

    public void initViewPager() {
        cB(0);
    }

    public void cB(int i) {
        if (this.afp != null) {
            removeView(this.afp);
        }
        this.afp = new CustomViewPager(this.mContext);
        this.afp.setId(d.h.tab_content);
        cC(i);
        addView(this.afp);
        removeView(this.afs);
        addView(this.afs);
        this.afp.setOffscreenPageLimit(this.afo.size() - 1);
        this.afp.setOnPageChangeListener(this);
        this.afr = new a(this.mFragmentManager, this.afo);
        this.afp.setAdapter(this.afr);
    }

    public void uD() {
        if (this.afp != null) {
            removeView(this.afp);
        }
        this.afp = new CustomViewPager(this.mContext);
        this.afp.setId(d.h.tab_content);
        addView(this.afp);
        removeView(this.afs);
        addView(this.afs);
        this.afp.setOffscreenPageLimit(this.afo.size() - 1);
        this.afp.setOnPageChangeListener(this);
        this.afr = new a(this.mFragmentManager, this.afo);
        this.afp.setAdapter(this.afr);
    }

    public void cC(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.afp.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.afp.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.afs.getLayoutParams();
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
        this.afp.setLayoutParams(layoutParams);
        this.afs.setLayoutParams(layoutParams2);
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
        this.afq = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.afo.size() && i != this.afl) {
            this.afl = i;
            this.afm = this.afo.get(this.afl);
            this.afk.h(this.afl, true);
            if (this.afp != null) {
                this.afp.setCurrentItem(this.afl, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.afo.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.afo.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.afl == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.afm = this.afo.get(i);
        if (this.afq == null || this.afq.g(i, z)) {
            if (this.afq != null) {
                this.afq.f(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.afk.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.afl;
    }

    public int getCurrentTabType() {
        if (this.afl < 0 || this.afl >= this.afo.size()) {
            return -1;
        }
        return this.afo.get(this.afl).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.afm != null) {
            return this.afm.afy;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.afk;
    }

    public c cD(int i) {
        if (i < 0 || i >= this.afo.size()) {
            return null;
        }
        return this.afo.get(i);
    }

    public c cE(int i) {
        for (c cVar : this.afo) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.afo.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.afp.getId(), this.afr.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.afo) {
            if (cVar.afz != null) {
                cVar.afz.cM();
            }
        }
        this.afo.clear();
        this.afm = null;
        this.afl = -1;
        this.afk.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ai.cU(d.g.s_tabbar_bg));
        if (i == 2 && this.afn) {
            this.afs.setBackgroundDrawable(bitmapDrawable);
        } else {
            ai.k(this.afs, d.e.common_color_10274);
        }
        this.afk.onChangeSkinType(i);
        if (this.afu != null) {
            ai.k(this.afu, d.e.cp_bg_line_b);
        }
        for (c cVar : this.afo) {
            cVar.afx.dt(i);
        }
        if (this.afr != null) {
            int count = this.afr.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.afr.getItem(i2);
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
        this.afk.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.afl = i;
        this.afm = this.afo.get(i);
        this.afk.h(this.afl, false);
        ViewGroup viewGroup = (ViewGroup) this.afm.afy.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int afv;
        private List<c> afw;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.afv = -1;
            this.afw = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.afw.get(i).afy;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.afw.get(i).afy.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.afw.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.afv != i) {
                if (this.afv != -1) {
                    ((BaseFragment) getItem(this.afv)).setPrimary(false);
                }
                this.afv = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.afn = z;
    }
}
