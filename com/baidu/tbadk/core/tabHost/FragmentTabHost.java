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
    private FragmentTabWidget aUd;
    private c aUe;
    private boolean aUf;
    private final List<c> aUg;
    private CustomViewPager aUh;
    private b aUi;
    private a aUj;
    private FrameLayout aUk;
    private int aUl;
    private View aUm;
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
        public e aUo;
        public Fragment aUp;
        public com.baidu.tbadk.mainTab.b aUq;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aUf = true;
        this.aUg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUl = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUf = true;
        this.aUg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUl = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aUk = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aUe = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aUd != null) {
            this.aUd.getLayoutParams().height = i;
            this.aUd.requestLayout();
            this.aUk.getLayoutParams().height = i;
            this.aUk.requestLayout();
            this.aUl = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aUk;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aUd != null) {
            this.aUd.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aUd != null) {
            this.aUd.setShouldDrawTopLine(z);
        }
    }

    public void bj(boolean z) {
        if (this.aUm == null) {
            this.aUm = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aUm.setVisibility(8);
            return;
        }
        if (this.aUd != null) {
            this.aUd.setShouldDrawTopLine(false);
        }
        int dip2px = this.aUl + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aUm.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aUm.setLayoutParams(layoutParams);
        this.aUm.setVisibility(0);
        aj.t(this.aUm, d.C0141d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aUd.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aUd = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aUd.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aUd.setPadding(i, i2, i3, i4);
    }

    public void bk(boolean z) {
        this.aUd.bk(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aUo == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aUp == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aUg.contains(cVar)) {
            if (cVar.aUq != null) {
                cVar.aUq.MT();
            }
            this.aUd.addView(cVar.aUo, i);
            if (i == -1) {
                this.aUg.add(cVar);
            } else {
                this.aUg.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aUh != null) {
            this.aUh.setScrollable(z);
        }
    }

    public void initViewPager() {
        fw(0);
    }

    public void fw(int i) {
        if (this.aUh != null) {
            removeView(this.aUh);
        }
        this.aUh = new CustomViewPager(this.mContext);
        this.aUh.setId(d.g.tab_content);
        fx(i);
        addView(this.aUh);
        removeView(this.aUk);
        addView(this.aUk);
        this.aUh.setOffscreenPageLimit(this.aUg.size() - 1);
        this.aUh.setOnPageChangeListener(this);
        this.aUj = new a(this.mFragmentManager, this.aUg);
        this.aUh.setAdapter(this.aUj);
    }

    public void BO() {
        if (this.aUh != null) {
            removeView(this.aUh);
        }
        this.aUh = new CustomViewPager(this.mContext);
        this.aUh.setId(d.g.tab_content);
        addView(this.aUh);
        removeView(this.aUk);
        addView(this.aUk);
        this.aUh.setOffscreenPageLimit(this.aUg.size() - 1);
        this.aUh.setOnPageChangeListener(this);
        this.aUj = new a(this.mFragmentManager, this.aUg);
        this.aUh.setAdapter(this.aUj);
    }

    public void fx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aUh.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aUh.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aUk.getLayoutParams();
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
        this.aUh.setLayoutParams(layoutParams);
        this.aUk.setLayoutParams(layoutParams2);
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
        this.aUi = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aUg.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aUe = this.aUg.get(this.mCurrentTabIndex);
            this.aUd.a(this.mCurrentTabIndex, true, false);
            if (this.aUh != null) {
                this.aUh.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aUg.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aUg.get(i3).mType) {
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
        this.aUe = this.aUg.get(i);
        if (this.aUi == null || this.aUi.v(i, z)) {
            if (this.aUi != null) {
                this.aUi.u(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aUd.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aUg.size()) {
            return -1;
        }
        return this.aUg.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aUe != null) {
            return this.aUe.aUp;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aUd;
    }

    public c fy(int i) {
        if (i < 0 || i >= this.aUg.size()) {
            return null;
        }
        return this.aUg.get(i);
    }

    public c fz(int i) {
        for (c cVar : this.aUg) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aUg.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aUh.getId(), this.aUj.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aUg) {
            if (cVar.aUq != null) {
                cVar.aUq.kg();
            }
        }
        this.aUg.clear();
        this.aUe = null;
        this.mCurrentTabIndex = -1;
        this.aUd.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fQ(d.f.s_tabbar_bg));
        if (i == 2 && this.aUf) {
            this.aUk.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aUk, d.C0141d.cp_bg_line_d);
        }
        this.aUd.onChangeSkinType(i);
        if (this.aUm != null) {
            aj.t(this.aUm, d.C0141d.cp_bg_line_b);
        }
        for (c cVar : this.aUg) {
            cVar.aUo.gB(i);
        }
        if (this.aUj != null) {
            int count = this.aUj.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aUj.getItem(i2);
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
        this.aUd.g(i, f);
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
        this.aUe = this.aUg.get(i);
        this.aUd.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aUe.aUp.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aUn;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aUn = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aUn.get(i).aUp;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aUn.get(i).aUp.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aUn.size();
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
        this.aUf = z;
    }
}
