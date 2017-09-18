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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private a aeA;
    private FrameLayout aeB;
    private int aeC;
    private View aeD;
    private FragmentTabWidget aet;
    private int aeu;
    private c aev;
    private boolean aew;
    private final List<c> aex;
    private CustomViewPager aey;
    private b aez;
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
        public e aeG;
        public Fragment aeH;
        public com.baidu.tbadk.mainTab.b aeI;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aew = true;
        this.aex = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aeC = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aew = true;
        this.aex = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aeC = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.aeB = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.aeu = -1;
        this.aev = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aet != null) {
            this.aet.getLayoutParams().height = i;
            this.aet.requestLayout();
            this.aeB.getLayoutParams().height = i;
            this.aeB.requestLayout();
            this.aeC = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aeB;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aet != null) {
            this.aet.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aet != null) {
            this.aet.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.aeD == null) {
            this.aeD = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.aeD.setVisibility(8);
            return;
        }
        if (this.aet != null) {
            this.aet.setShouldDrawTopLine(false);
        }
        int dip2px = this.aeC + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aeD.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aeD.setLayoutParams(layoutParams);
        this.aeD.setVisibility(0);
        aj.k(this.aeD, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aet.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aet = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.aet.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.aet.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.aet.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aeG == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aeH == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aex.contains(cVar)) {
            if (cVar.aeI != null) {
                cVar.aeI.ET();
            }
            this.aet.addView(cVar.aeG, i);
            if (i == -1) {
                this.aex.add(cVar);
            } else {
                this.aex.add(i, cVar);
            }
            if (this.aeu != -1 && i <= this.aeu) {
                this.aeu++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aey != null) {
            this.aey.setScrollable(z);
        }
    }

    public void initViewPager() {
        cB(0);
    }

    public void cB(int i) {
        if (this.aey != null) {
            removeView(this.aey);
        }
        this.aey = new CustomViewPager(this.mContext);
        this.aey.setId(d.h.tab_content);
        cC(i);
        addView(this.aey);
        removeView(this.aeB);
        addView(this.aeB);
        this.aey.setOffscreenPageLimit(this.aex.size() - 1);
        this.aey.setOnPageChangeListener(this);
        this.aeA = new a(this.mFragmentManager, this.aex);
        this.aey.setAdapter(this.aeA);
    }

    public void uz() {
        if (this.aey != null) {
            removeView(this.aey);
        }
        this.aey = new CustomViewPager(this.mContext);
        this.aey.setId(d.h.tab_content);
        addView(this.aey);
        removeView(this.aeB);
        addView(this.aeB);
        this.aey.setOffscreenPageLimit(this.aex.size() - 1);
        this.aey.setOnPageChangeListener(this);
        this.aeA = new a(this.mFragmentManager, this.aex);
        this.aey.setAdapter(this.aeA);
    }

    public void cC(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aey.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aey.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aeB.getLayoutParams();
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
            layoutParams.bottomMargin = k.f(this.mContext, d.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.f(this.mContext, d.f.ds98);
        }
        this.aey.setLayoutParams(layoutParams);
        this.aeB.setLayoutParams(layoutParams2);
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
        this.aez = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aex.size() && i != this.aeu) {
            this.aeu = i;
            this.aev = this.aex.get(this.aeu);
            this.aet.a(this.aeu, true, false);
            if (this.aey != null) {
                this.aey.setCurrentItem(this.aeu, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aex.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aex.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.aeu == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        this.aev = this.aex.get(i);
        if (this.aez == null || this.aez.f(i, z)) {
            if (this.aez != null) {
                this.aez.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aet.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.aeu;
    }

    public int getCurrentTabType() {
        if (this.aeu < 0 || this.aeu >= this.aex.size()) {
            return -1;
        }
        return this.aex.get(this.aeu).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aev != null) {
            return this.aev.aeH;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aet;
    }

    public c cD(int i) {
        if (i < 0 || i >= this.aex.size()) {
            return null;
        }
        return this.aex.get(i);
    }

    public c cE(int i) {
        for (c cVar : this.aex) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aex.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aey.getId(), this.aeA.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aex) {
            if (cVar.aeI != null) {
                cVar.aeI.cB();
            }
        }
        this.aex.clear();
        this.aev = null;
        this.aeu = -1;
        this.aet.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cV(d.g.s_tabbar_bg));
        if (i == 2 && this.aew) {
            this.aeB.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.aeB, d.e.cp_bg_line_d);
        }
        this.aet.onChangeSkinType(i);
        if (this.aeD != null) {
            aj.k(this.aeD, d.e.cp_bg_line_b);
        }
        for (c cVar : this.aex) {
            cVar.aeG.du(i);
        }
        if (this.aeA != null) {
            int count = this.aeA.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aeA.getItem(i2);
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
        this.aet.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.aeu = i;
        this.aev = this.aex.get(i);
        this.aet.a(this.aeu, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aev.aeH.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int aeE;
        private List<c> aeF;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.aeE = -1;
            this.aeF = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aeF.get(i).aeH;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aeF.get(i).aeH.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aeF.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.aeE != i) {
                if (this.aeE != -1) {
                    ((BaseFragment) getItem(this.aeE)).setPrimary(false);
                }
                this.aeE = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.aew = z;
    }
}
