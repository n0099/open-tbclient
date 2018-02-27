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
    private FragmentTabWidget aUb;
    private c aUc;
    private boolean aUd;
    private final List<c> aUe;
    private CustomViewPager aUf;
    private b aUg;
    private a aUh;
    private FrameLayout aUi;
    private int aUj;
    private View aUk;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void u(int i, boolean z);

        boolean v(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public e aUm;
        public Fragment aUn;
        public com.baidu.tbadk.mainTab.b aUo;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aUd = true;
        this.aUe = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUj = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUd = true;
        this.aUe = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUj = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aUi = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aUc = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aUb != null) {
            this.aUb.getLayoutParams().height = i;
            this.aUb.requestLayout();
            this.aUi.getLayoutParams().height = i;
            this.aUi.requestLayout();
            this.aUj = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aUi;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aUb != null) {
            this.aUb.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aUb != null) {
            this.aUb.setShouldDrawTopLine(z);
        }
    }

    public void bj(boolean z) {
        if (this.aUk == null) {
            this.aUk = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aUk.setVisibility(8);
            return;
        }
        if (this.aUb != null) {
            this.aUb.setShouldDrawTopLine(false);
        }
        int dip2px = this.aUj + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aUk.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aUk.setLayoutParams(layoutParams);
        this.aUk.setVisibility(0);
        aj.t(this.aUk, d.C0141d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aUb.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aUb = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aUb.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aUb.setPadding(i, i2, i3, i4);
    }

    public void bk(boolean z) {
        this.aUb.bk(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aUm == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aUn == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aUe.contains(cVar)) {
            if (cVar.aUo != null) {
                cVar.aUo.MS();
            }
            this.aUb.addView(cVar.aUm, i);
            if (i == -1) {
                this.aUe.add(cVar);
            } else {
                this.aUe.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aUf != null) {
            this.aUf.setScrollable(z);
        }
    }

    public void initViewPager() {
        fw(0);
    }

    public void fw(int i) {
        if (this.aUf != null) {
            removeView(this.aUf);
        }
        this.aUf = new CustomViewPager(this.mContext);
        this.aUf.setId(d.g.tab_content);
        fx(i);
        addView(this.aUf);
        removeView(this.aUi);
        addView(this.aUi);
        this.aUf.setOffscreenPageLimit(this.aUe.size() - 1);
        this.aUf.setOnPageChangeListener(this);
        this.aUh = new a(this.mFragmentManager, this.aUe);
        this.aUf.setAdapter(this.aUh);
    }

    public void BN() {
        if (this.aUf != null) {
            removeView(this.aUf);
        }
        this.aUf = new CustomViewPager(this.mContext);
        this.aUf.setId(d.g.tab_content);
        addView(this.aUf);
        removeView(this.aUi);
        addView(this.aUi);
        this.aUf.setOffscreenPageLimit(this.aUe.size() - 1);
        this.aUf.setOnPageChangeListener(this);
        this.aUh = new a(this.mFragmentManager, this.aUe);
        this.aUf.setAdapter(this.aUh);
    }

    public void fx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aUf.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aUf.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aUi.getLayoutParams();
            layoutParams2.height = -2;
        }
        l(layoutParams.getRules());
        l(layoutParams2.getRules());
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
            layoutParams.bottomMargin = l.t(this.mContext, d.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.t(this.mContext, d.e.ds88);
        }
        this.aUf.setLayoutParams(layoutParams);
        this.aUi.setLayoutParams(layoutParams2);
    }

    private void l(int[] iArr) {
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
        this.aUg = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aUe.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aUc = this.aUe.get(this.mCurrentTabIndex);
            this.aUb.a(this.mCurrentTabIndex, true, false);
            if (this.aUf != null) {
                this.aUf.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aUe.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aUe.get(i3).mType) {
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
    public void u(int i, boolean z) {
        this.aUc = this.aUe.get(i);
        if (this.aUg == null || this.aUg.v(i, z)) {
            if (this.aUg != null) {
                this.aUg.u(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aUb.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aUe.size()) {
            return -1;
        }
        return this.aUe.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aUc != null) {
            return this.aUc.aUn;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aUb;
    }

    public c fy(int i) {
        if (i < 0 || i >= this.aUe.size()) {
            return null;
        }
        return this.aUe.get(i);
    }

    public c fz(int i) {
        for (c cVar : this.aUe) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aUe.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aUf.getId(), this.aUh.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aUe) {
            if (cVar.aUo != null) {
                cVar.aUo.kg();
            }
        }
        this.aUe.clear();
        this.aUc = null;
        this.mCurrentTabIndex = -1;
        this.aUb.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fQ(d.f.s_tabbar_bg));
        if (i == 2 && this.aUd) {
            this.aUi.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aUi, d.C0141d.cp_bg_line_d);
        }
        this.aUb.onChangeSkinType(i);
        if (this.aUk != null) {
            aj.t(this.aUk, d.C0141d.cp_bg_line_b);
        }
        for (c cVar : this.aUe) {
            cVar.aUm.gB(i);
        }
        if (this.aUh != null) {
            int count = this.aUh.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aUh.getItem(i2);
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
        this.aUb.g(i, f);
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
        this.aUc = this.aUe.get(i);
        this.aUb.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aUc.aUn.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aUl;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aUl = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aUl.get(i).aUn;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aUl.get(i).aUn.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aUl.size();
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
        this.aUd = z;
    }
}
