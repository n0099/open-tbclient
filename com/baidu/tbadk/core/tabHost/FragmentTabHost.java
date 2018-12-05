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
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget azl;
    private com.baidu.tbadk.core.tabHost.a azm;
    private b azn;
    private boolean azo;
    private final List<b> azp;
    private CustomViewPager azq;
    private a azr;
    private FragmentAdapter azs;
    private LinearLayout azt;
    private int azu;
    private View azv;
    private int azw;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.tbadk.mainTab.b azA;
        public TbFragmentTabIndicator azy;
        public Fragment azz;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.azo = true;
        this.azp = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azu = 0;
        this.azw = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azo = true;
        this.azp = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azu = 0;
        this.azw = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.azt = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.azn = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.azl != null) {
            this.azl.getLayoutParams().height = i;
            this.azl.requestLayout();
            this.azt.getLayoutParams().height = i;
            this.azt.requestLayout();
            this.azu = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.azl != null) {
            this.azl.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.azl != null) {
            this.azl.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.azl != null) {
            this.azl.setShouldDrawTopLine(z);
        }
    }

    public void bq(boolean z) {
        if (this.azv == null) {
            this.azv = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.azv.setVisibility(8);
            return;
        }
        if (this.azl != null) {
            this.azl.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azv.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.azv.setLayoutParams(layoutParams);
        this.azv.setVisibility(0);
        al.j(this.azv, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.azl.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.azl != null) {
            this.azl.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.azm == null) {
            this.azm = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        bq(false);
        this.azm.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.azl = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.azl.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.azl.setPadding(i, i2, i3, i4);
    }

    public void br(boolean z) {
        this.azl.br(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.azy == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.azz == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.azp.contains(bVar)) {
            if (bVar.azA != null) {
                bVar.azA.NN();
            }
            this.azl.addView(bVar.azy, i);
            if (i == -1) {
                this.azp.add(bVar);
            } else {
                this.azp.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.azq != null) {
            this.azq.setScrollable(z);
        }
    }

    public void initViewPager() {
        dw(0);
    }

    public void dw(int i) {
        if (this.azq != null) {
            removeView(this.azq);
        }
        this.azq = new CustomViewPager(this.mContext);
        this.azq.setId(e.g.tab_content);
        dx(i);
        addView(this.azq);
        removeView(this.azt);
        addView(this.azt);
        this.azq.setOffscreenPageLimit(this.azp.size() - 1);
        this.azq.setOnPageChangeListener(this);
        this.azs = new FragmentAdapter(this.mFragmentManager, this.azp);
        this.azq.setAdapter(this.azs);
    }

    public void Cx() {
        if (this.azq != null) {
            removeView(this.azq);
        }
        this.azq = new CustomViewPager(this.mContext);
        this.azq.setId(e.g.tab_content);
        addView(this.azq);
        removeView(this.azt);
        addView(this.azt);
        this.azq.setOffscreenPageLimit(this.azp.size() - 1);
        this.azq.setOnPageChangeListener(this);
        this.azs = new FragmentAdapter(this.mFragmentManager, this.azp);
        this.azq.setAdapter(this.azs);
    }

    public void dx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.azq.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.azq.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.azt.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.azt.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.azt.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds98);
            this.azt.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0210e.ds88);
            this.azt.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.azt.setVisibility(8);
        }
        this.azq.setLayoutParams(layoutParams);
        this.azt.setLayoutParams(layoutParams2);
    }

    private void g(int[] iArr) {
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

    public void setOnTabSelectionListener(a aVar) {
        this.azr = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.azp.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.azn = this.azp.get(this.mCurrentTabIndex);
            this.azl.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.azq != null) {
                this.azq.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.azp.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.azp.get(i3).mType) {
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
    public void onTabSelectionChanged(int i, boolean z) {
        this.azn = this.azp.get(i);
        if (this.azr == null || this.azr.onPreTabSelectionChange(i, z)) {
            if (this.azr != null) {
                this.azr.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.azl.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.azp.size()) {
            return -1;
        }
        return this.azp.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.azn != null) {
            return this.azn.azz;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.azq;
    }

    public ViewGroup getTabWrapper() {
        return this.azt;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.azl;
    }

    public b dy(int i) {
        if (i < 0 || i >= this.azp.size()) {
            return null;
        }
        return this.azp.get(i);
    }

    public b dz(int i) {
        for (b bVar : this.azp) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.azq != null && this.azs != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.azp.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.azq.getId(), this.azs.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.azp) {
                if (bVar.azA != null) {
                    bVar.azA.gy();
                }
            }
            this.azp.clear();
            this.azn = null;
            this.mCurrentTabIndex = -1;
            this.azl.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.azo) {
            this.azt.setBackgroundDrawable(new BitmapDrawable(al.dQ(e.f.s_tabbar_bg)));
        } else {
            al.j(this.azt, this.azw);
        }
        this.azl.onChangeSkinType(i);
        al.j(this.azv, e.d.cp_bg_line_b);
        for (b bVar : this.azp) {
            bVar.azy.eC(i);
        }
        if (this.azs != null) {
            int count = this.azs.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.azs.getItem(i2);
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
        this.azl.d(i, f);
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
        this.azn = this.azp.get(i);
        this.azl.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.azn.azz.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> azx;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.azx = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.azx.get(i).azz;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.azx.get(i).azz.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.azx.size();
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

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            try {
                super.finishUpdate(viewGroup);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.azo = z;
    }

    public void Cy() {
        if (this.azt != null && this.azt.getVisibility() != 0) {
            this.azt.setVisibility(0);
        }
    }

    public void Cz() {
        if (this.azt != null && this.azt.getVisibility() != 8) {
            this.azt.setVisibility(8);
        }
    }
}
