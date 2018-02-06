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
    private FragmentTabWidget aUn;
    private c aUo;
    private boolean aUp;
    private final List<c> aUq;
    private CustomViewPager aUr;
    private b aUs;
    private a aUt;
    private FrameLayout aUu;
    private int aUv;
    private View aUw;
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
        public com.baidu.tbadk.mainTab.b aUA;
        public e aUy;
        public Fragment aUz;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aUp = true;
        this.aUq = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUv = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUp = true;
        this.aUq = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aUv = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.aUu = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.aUo = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aUn != null) {
            this.aUn.getLayoutParams().height = i;
            this.aUn.requestLayout();
            this.aUu.getLayoutParams().height = i;
            this.aUu.requestLayout();
            this.aUv = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aUu;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aUn != null) {
            this.aUn.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.aUn != null) {
            this.aUn.setShouldDrawTopLine(z);
        }
    }

    public void bj(boolean z) {
        if (this.aUw == null) {
            this.aUw = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.aUw.setVisibility(8);
            return;
        }
        if (this.aUn != null) {
            this.aUn.setShouldDrawTopLine(false);
        }
        int dip2px = this.aUv + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aUw.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.aUw.setLayoutParams(layoutParams);
        this.aUw.setVisibility(0);
        aj.t(this.aUw, d.C0140d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.aUn.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aUn = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.aUn.setTabSelectionListener(this);
    }

    public void n(int i, int i2, int i3, int i4) {
        this.aUn.setPadding(i, i2, i3, i4);
    }

    public void bk(boolean z) {
        this.aUn.bk(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aUy == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aUz == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aUq.contains(cVar)) {
            if (cVar.aUA != null) {
                cVar.aUA.MT();
            }
            this.aUn.addView(cVar.aUy, i);
            if (i == -1) {
                this.aUq.add(cVar);
            } else {
                this.aUq.add(i, cVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aUr != null) {
            this.aUr.setScrollable(z);
        }
    }

    public void initViewPager() {
        fw(0);
    }

    public void fw(int i) {
        if (this.aUr != null) {
            removeView(this.aUr);
        }
        this.aUr = new CustomViewPager(this.mContext);
        this.aUr.setId(d.g.tab_content);
        fx(i);
        addView(this.aUr);
        removeView(this.aUu);
        addView(this.aUu);
        this.aUr.setOffscreenPageLimit(this.aUq.size() - 1);
        this.aUr.setOnPageChangeListener(this);
        this.aUt = new a(this.mFragmentManager, this.aUq);
        this.aUr.setAdapter(this.aUt);
    }

    public void BO() {
        if (this.aUr != null) {
            removeView(this.aUr);
        }
        this.aUr = new CustomViewPager(this.mContext);
        this.aUr.setId(d.g.tab_content);
        addView(this.aUr);
        removeView(this.aUu);
        addView(this.aUu);
        this.aUr.setOffscreenPageLimit(this.aUq.size() - 1);
        this.aUr.setOnPageChangeListener(this);
        this.aUt = new a(this.mFragmentManager, this.aUq);
        this.aUr.setAdapter(this.aUt);
    }

    public void fx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aUr.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aUr.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aUu.getLayoutParams();
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
        this.aUr.setLayoutParams(layoutParams);
        this.aUu.setLayoutParams(layoutParams2);
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
        this.aUs = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aUq.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.aUo = this.aUq.get(this.mCurrentTabIndex);
            this.aUn.a(this.mCurrentTabIndex, true, false);
            if (this.aUr != null) {
                this.aUr.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aUq.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aUq.get(i3).mType) {
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
        this.aUo = this.aUq.get(i);
        if (this.aUs == null || this.aUs.v(i, z)) {
            if (this.aUs != null) {
                this.aUs.u(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aUn.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.aUq.size()) {
            return -1;
        }
        return this.aUq.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.aUo != null) {
            return this.aUo.aUz;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aUn;
    }

    public c fy(int i) {
        if (i < 0 || i >= this.aUq.size()) {
            return null;
        }
        return this.aUq.get(i);
    }

    public c fz(int i) {
        for (c cVar : this.aUq) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aUq.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aUr.getId(), this.aUt.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aUq) {
            if (cVar.aUA != null) {
                cVar.aUA.kg();
            }
        }
        this.aUq.clear();
        this.aUo = null;
        this.mCurrentTabIndex = -1;
        this.aUn.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.fQ(d.f.s_tabbar_bg));
        if (i == 2 && this.aUp) {
            this.aUu.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.t(this.aUu, d.C0140d.cp_bg_line_d);
        }
        this.aUn.onChangeSkinType(i);
        if (this.aUw != null) {
            aj.t(this.aUw, d.C0140d.cp_bg_line_b);
        }
        for (c cVar : this.aUq) {
            cVar.aUy.gB(i);
        }
        if (this.aUt != null) {
            int count = this.aUt.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aUt.getItem(i2);
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
        this.aUn.g(i, f);
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
        this.aUo = this.aUq.get(i);
        this.aUn.a(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.aUo.aUz.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> aUx;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aUx = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aUx.get(i).aUz;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aUx.get(i).aUz.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aUx.size();
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
        this.aUp = z;
    }
}
