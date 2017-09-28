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
    private FragmentTabWidget adQ;
    private int adR;
    private c adS;
    private boolean adT;
    private final List<c> adU;
    private CustomViewPager adV;
    private b adW;
    private a adX;
    private FrameLayout adY;
    private int adZ;
    private View aea;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, boolean z);

        boolean f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public e aed;
        public Fragment aee;
        public com.baidu.tbadk.mainTab.b aef;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adT = true;
        this.adU = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adZ = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adT = true;
        this.adU = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adZ = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.adY = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.adR = -1;
        this.adS = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adQ != null) {
            this.adQ.getLayoutParams().height = i;
            this.adQ.requestLayout();
            this.adY.getLayoutParams().height = i;
            this.adY.requestLayout();
            this.adZ = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adY;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adQ != null) {
            this.adQ.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adQ != null) {
            this.adQ.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.aea == null) {
            this.aea = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.aea.setVisibility(8);
            return;
        }
        if (this.adQ != null) {
            this.adQ.setShouldDrawTopLine(false);
        }
        int dip2px = this.adZ + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aea.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aea.setLayoutParams(layoutParams);
        this.aea.setVisibility(0);
        aj.k(this.aea, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.adQ.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adQ = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.adQ.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.adQ.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.adQ.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aed == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aee == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adU.contains(cVar)) {
            if (cVar.aef != null) {
                cVar.aef.Ey();
            }
            this.adQ.addView(cVar.aed, i);
            if (i == -1) {
                this.adU.add(cVar);
            } else {
                this.adU.add(i, cVar);
            }
            if (this.adR != -1 && i <= this.adR) {
                this.adR++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adV != null) {
            this.adV.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.adV != null) {
            removeView(this.adV);
        }
        this.adV = new CustomViewPager(this.mContext);
        this.adV.setId(d.h.tab_content);
        cA(i);
        addView(this.adV);
        removeView(this.adY);
        addView(this.adY);
        this.adV.setOffscreenPageLimit(this.adU.size() - 1);
        this.adV.setOnPageChangeListener(this);
        this.adX = new a(this.mFragmentManager, this.adU);
        this.adV.setAdapter(this.adX);
    }

    public void uc() {
        if (this.adV != null) {
            removeView(this.adV);
        }
        this.adV = new CustomViewPager(this.mContext);
        this.adV.setId(d.h.tab_content);
        addView(this.adV);
        removeView(this.adY);
        addView(this.adY);
        this.adV.setOffscreenPageLimit(this.adU.size() - 1);
        this.adV.setOnPageChangeListener(this);
        this.adX = new a(this.mFragmentManager, this.adU);
        this.adV.setAdapter(this.adX);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adV.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adV.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adY.getLayoutParams();
            layoutParams2.height = -2;
        }
        d(layoutParams.getRules());
        d(layoutParams2.getRules());
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
            layoutParams.bottomMargin = l.f(this.mContext, d.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.f(this.mContext, d.f.ds98);
        }
        this.adV.setLayoutParams(layoutParams);
        this.adY.setLayoutParams(layoutParams2);
    }

    private void d(int[] iArr) {
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
        this.adW = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adU.size() && i != this.adR) {
            this.adR = i;
            this.adS = this.adU.get(this.adR);
            this.adQ.a(this.adR, true, false);
            if (this.adV != null) {
                this.adV.setCurrentItem(this.adR, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adU.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adU.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adR == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        this.adS = this.adU.get(i);
        if (this.adW == null || this.adW.f(i, z)) {
            if (this.adW != null) {
                this.adW.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adQ.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adR;
    }

    public int getCurrentTabType() {
        if (this.adR < 0 || this.adR >= this.adU.size()) {
            return -1;
        }
        return this.adU.get(this.adR).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.adS != null) {
            return this.adS.aee;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adQ;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.adU.size()) {
            return null;
        }
        return this.adU.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.adU) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adU.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adV.getId(), this.adX.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adU) {
            if (cVar.aef != null) {
                cVar.aef.cB();
            }
        }
        this.adU.clear();
        this.adS = null;
        this.adR = -1;
        this.adQ.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cT(d.g.s_tabbar_bg));
        if (i == 2 && this.adT) {
            this.adY.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.adY, d.e.cp_bg_line_d);
        }
        this.adQ.onChangeSkinType(i);
        if (this.aea != null) {
            aj.k(this.aea, d.e.cp_bg_line_b);
        }
        for (c cVar : this.adU) {
            cVar.aed.dE(i);
        }
        if (this.adX != null) {
            int count = this.adX.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adX.getItem(i2);
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
        this.adQ.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adR = i;
        this.adS = this.adU.get(i);
        this.adQ.a(this.adR, false, true);
        ViewGroup viewGroup = (ViewGroup) this.adS.aee.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int aeb;
        private List<c> aec;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.aeb = -1;
            this.aec = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aec.get(i).aee;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aec.get(i).aee.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aec.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.aeb != i) {
                if (this.aeb != -1) {
                    ((BaseFragment) getItem(this.aeb)).setPrimary(false);
                }
                this.aeb = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adT = z;
    }
}
