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
    private FragmentTabWidget adN;
    private int adO;
    private c adP;
    private boolean adQ;
    private final List<c> adR;
    private CustomViewPager adS;
    private b adT;
    private a adU;
    private FrameLayout adV;
    private int adW;
    private View adX;
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
        public FragmentTabIndicator aea;
        public Fragment aeb;
        public com.baidu.tbadk.mainTab.b aec;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adQ = true;
        this.adR = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adW = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adQ = true;
        this.adR = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adW = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.adV = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.adO = -1;
        this.adP = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adN != null) {
            this.adN.getLayoutParams().height = i;
            this.adN.requestLayout();
            this.adV.getLayoutParams().height = i;
            this.adV.requestLayout();
            this.adW = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adV;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adN != null) {
            this.adN.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adN != null) {
            this.adN.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.adX == null) {
            this.adX = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.adX.setVisibility(8);
            return;
        }
        if (this.adN != null) {
            this.adN.setShouldDrawTopLine(false);
        }
        int dip2px = this.adW + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.adX.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.adX.setLayoutParams(layoutParams);
        this.adX.setVisibility(0);
        ai.k(this.adX, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.adN.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adN = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.adN.setTabSelectionListener(this);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.adN.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.adN.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aea == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aeb == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adR.contains(cVar)) {
            if (cVar.aec != null) {
                cVar.aec.EN();
            }
            this.adN.addView(cVar.aea, i);
            if (i == -1) {
                this.adR.add(cVar);
            } else {
                this.adR.add(i, cVar);
            }
            if (this.adO != -1 && i <= this.adO) {
                this.adO++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adS != null) {
            this.adS.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.adS != null) {
            removeView(this.adS);
        }
        this.adS = new CustomViewPager(this.mContext);
        this.adS.setId(d.h.tab_content);
        cA(i);
        addView(this.adS);
        removeView(this.adV);
        addView(this.adV);
        this.adS.setOffscreenPageLimit(this.adR.size() - 1);
        this.adS.setOnPageChangeListener(this);
        this.adU = new a(this.mFragmentManager, this.adR);
        this.adS.setAdapter(this.adU);
    }

    public void ut() {
        if (this.adS != null) {
            removeView(this.adS);
        }
        this.adS = new CustomViewPager(this.mContext);
        this.adS.setId(d.h.tab_content);
        addView(this.adS);
        removeView(this.adV);
        addView(this.adV);
        this.adS.setOffscreenPageLimit(this.adR.size() - 1);
        this.adS.setOnPageChangeListener(this);
        this.adU = new a(this.mFragmentManager, this.adR);
        this.adS.setAdapter(this.adU);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adS.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adS.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adV.getLayoutParams();
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
        this.adS.setLayoutParams(layoutParams);
        this.adV.setLayoutParams(layoutParams2);
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
        this.adT = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adR.size() && i != this.adO) {
            this.adO = i;
            this.adP = this.adR.get(this.adO);
            this.adN.h(this.adO, true);
            if (this.adS != null) {
                this.adS.setCurrentItem(this.adO, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adR.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adR.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adO == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.adP = this.adR.get(i);
        if (this.adT == null || this.adT.g(i, z)) {
            if (this.adT != null) {
                this.adT.f(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adN.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adO;
    }

    public int getCurrentTabType() {
        if (this.adO < 0 || this.adO >= this.adR.size()) {
            return -1;
        }
        return this.adR.get(this.adO).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.adP != null) {
            return this.adP.aeb;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adN;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.adR.size()) {
            return null;
        }
        return this.adR.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.adR) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adR.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adS.getId(), this.adU.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adR) {
            if (cVar.aec != null) {
                cVar.aec.cB();
            }
        }
        this.adR.clear();
        this.adP = null;
        this.adO = -1;
        this.adN.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ai.cS(d.g.s_tabbar_bg));
        if (i == 2 && this.adQ) {
            this.adV.setBackgroundDrawable(bitmapDrawable);
        } else {
            ai.k(this.adV, d.e.common_color_10274);
        }
        this.adN.onChangeSkinType(i);
        if (this.adX != null) {
            ai.k(this.adX, d.e.cp_bg_line_b);
        }
        for (c cVar : this.adR) {
            cVar.aea.dr(i);
        }
        if (this.adU != null) {
            int count = this.adU.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adU.getItem(i2);
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
        this.adN.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adO = i;
        this.adP = this.adR.get(i);
        this.adN.h(this.adO, false);
        ViewGroup viewGroup = (ViewGroup) this.adP.aeb.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adY;
        private List<c> adZ;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adY = -1;
            this.adZ = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adZ.get(i).aeb;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adZ.get(i).aeb.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adZ.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adY != i) {
                if (this.adY != -1) {
                    ((BaseFragment) getItem(this.adY)).setPrimary(false);
                }
                this.adY = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adQ = z;
    }
}
