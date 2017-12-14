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
    private View aeA;
    private FragmentTabWidget aer;
    private c aes;
    private boolean aet;
    private final List<c> aeu;
    private CustomViewPager aev;
    private b aew;
    private a aex;
    private FrameLayout aey;
    private int aez;
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
        public e aeC;
        public Fragment aeD;
        public com.baidu.tbadk.mainTab.b aeE;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aet = true;
        this.aeu = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aez = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aet = true;
        this.aeu = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aez = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aey = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aes = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aer != null) {
            this.aer.getLayoutParams().height = i;
            this.aer.requestLayout();
            this.aey.getLayoutParams().height = i;
            this.aey.requestLayout();
            this.aez = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aey;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aer != null) {
            this.aer.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aer != null) {
            this.aer.setShouldDrawTopLine(z);
        }
    }

    public void ax(boolean z) {
        if (this.aeA == null) {
            this.aeA = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aeA.setVisibility(8);
            return;
        }
        if (this.aer != null) {
            this.aer.setShouldDrawTopLine(false);
        }
        int dip2px = this.aez + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aeA.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aeA.setLayoutParams(layoutParams);
        this.aeA.setVisibility(0);
        aj.k(this.aeA, d.C0096d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aer.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aer = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aer.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.aer.setPadding(i, i2, i3, i4);
    }

    public void ay(boolean z) {
        this.aer.ay(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aeC == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aeD == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aeu.contains(cVar)) {
            if (cVar.aeE != null) {
                cVar.aeE.EY();
            }
            this.aer.addView(cVar.aeC, i);
            if (i == -1) {
                this.aeu.add(cVar);
            } else {
                this.aeu.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aev != null) {
            this.aev.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.aev != null) {
            removeView(this.aev);
        }
        this.aev = new CustomViewPager(this.mContext);
        this.aev.setId(d.g.tab_content);
        cA(i);
        addView(this.aev);
        removeView(this.aey);
        addView(this.aey);
        this.aev.setOffscreenPageLimit(this.aeu.size() - 1);
        this.aev.setOnPageChangeListener(this);
        this.aex = new a(this.mFragmentManager, this.aeu);
        this.aev.setAdapter(this.aex);
    }

    public void uc() {
        if (this.aev != null) {
            removeView(this.aev);
        }
        this.aev = new CustomViewPager(this.mContext);
        this.aev.setId(d.g.tab_content);
        addView(this.aev);
        removeView(this.aey);
        addView(this.aey);
        this.aev.setOffscreenPageLimit(this.aeu.size() - 1);
        this.aev.setOnPageChangeListener(this);
        this.aex = new a(this.mFragmentManager, this.aeu);
        this.aev.setAdapter(this.aex);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aev.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aev.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aey.getLayoutParams();
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
        this.aev.setLayoutParams(layoutParams);
        this.aey.setLayoutParams(layoutParams2);
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
        this.aew = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aeu.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aes = this.aeu.get(this.mCurrentTabIndex);
            this.aer.a(this.mCurrentTabIndex, true, false);
            if (this.aev != null) {
                this.aev.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aeu.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aeu.get(i3).mType) {
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
        this.aes = this.aeu.get(i);
        if (this.aew == null || this.aew.f(i, z)) {
            if (this.aew != null) {
                this.aew.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aer.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aeu.size()) {
            return -1;
        }
        return this.aeu.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aes != null) {
            return this.aes.aeD;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aer;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.aeu.size()) {
            return null;
        }
        return this.aeu.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.aeu) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aeu.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aev.getId(), this.aex.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aeu) {
            if (cVar.aeE != null) {
                cVar.aeE.cB();
            }
        }
        this.aeu.clear();
        this.aes = null;
        this.mCurrentTabIndex = -1;
        this.aer.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cT(d.f.s_tabbar_bg));
        if (i == 2 && this.aet) {
            this.aey.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.aey, d.C0096d.cp_bg_line_d);
        }
        this.aer.onChangeSkinType(i);
        if (this.aeA != null) {
            aj.k(this.aeA, d.C0096d.cp_bg_line_b);
        }
        for (c cVar : this.aeu) {
            cVar.aeC.dE(i);
        }
        if (this.aex != null) {
            int count = this.aex.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aex.getItem(i2);
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
        this.aer.b(i, f);
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
        this.aes = this.aeu.get(i);
        this.aer.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aes.aeD.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aeB;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aeB = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aeB.get(i).aeD;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aeB.get(i).aeD.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aeB.size();
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
        this.aet = z;
    }
}
