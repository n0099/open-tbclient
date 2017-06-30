package com.baidu.tbadk.core.tabHost;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private int adA;
    private View adB;
    private FragmentTabWidget adr;
    private int ads;
    private c adt;
    private boolean adu;
    private final List<c> adv;
    private CustomViewPager adw;
    private b adx;
    private a ady;
    private FrameLayout adz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator adE;
        public Fragment adF;
        public com.baidu.tbadk.mainTab.b adG;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adu = true;
        this.adv = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adA = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adu = true;
        this.adv = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adA = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.adz = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.ads = -1;
        this.adt = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adr != null) {
            this.adr.getLayoutParams().height = i;
            this.adr.requestLayout();
            this.adz.getLayoutParams().height = i;
            this.adz.requestLayout();
            this.adA = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adz;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adr != null) {
            this.adr.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adr != null) {
            this.adr.setShouldDrawTopLine(z);
        }
    }

    public void aB(boolean z) {
        if (this.adB == null) {
            this.adB = findViewById(w.h.topDvider);
        }
        if (!z) {
            this.adB.setVisibility(8);
            return;
        }
        if (this.adr != null) {
            this.adr.setShouldDrawTopLine(false);
        }
        int dip2px = this.adA + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.adB.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.adB.setLayoutParams(layoutParams);
        this.adB.setVisibility(0);
        as.k(this.adB, w.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.adr.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adr = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.adr.setTabSelectionListener(this);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.adr.setPadding(i, i2, i3, i4);
    }

    public void aC(boolean z) {
        this.adr.aC(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adE == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.adF == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adv.contains(cVar)) {
            if (cVar.adG != null) {
                cVar.adG.Ex();
            }
            this.adr.addView(cVar.adE, i);
            if (i == -1) {
                this.adv.add(cVar);
            } else {
                this.adv.add(i, cVar);
            }
            if (this.ads != -1 && i <= this.ads) {
                this.ads++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adw != null) {
            this.adw.setScrollable(z);
        }
    }

    public void initViewPager() {
        cx(0);
    }

    public void cx(int i) {
        if (this.adw != null) {
            removeView(this.adw);
        }
        this.adw = new CustomViewPager(this.mContext);
        this.adw.setId(w.h.tab_content);
        cy(i);
        addView(this.adw);
        removeView(this.adz);
        addView(this.adz);
        this.adw.setOffscreenPageLimit(this.adv.size() - 1);
        this.adw.setOnPageChangeListener(this);
        this.ady = new a(this.mFragmentManager, this.adv);
        this.adw.setAdapter(this.ady);
    }

    public void un() {
        if (this.adw != null) {
            removeView(this.adw);
        }
        this.adw = new CustomViewPager(this.mContext);
        this.adw.setId(w.h.tab_content);
        addView(this.adw);
        removeView(this.adz);
        addView(this.adz);
        this.adw.setOffscreenPageLimit(this.adv.size() - 1);
        this.adw.setOnPageChangeListener(this);
        this.ady = new a(this.mFragmentManager, this.adv);
        this.adw.setAdapter(this.ady);
    }

    public void cy(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adw.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adw.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adz.getLayoutParams();
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
            layoutParams.addRule(3, w.h.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.g(this.mContext, w.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.g(this.mContext, w.f.ds98);
        }
        this.adw.setLayoutParams(layoutParams);
        this.adz.setLayoutParams(layoutParams2);
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
        this.adx = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adv.size() && i != this.ads) {
            this.ads = i;
            this.adt = this.adv.get(this.ads);
            this.adr.g(this.ads, true);
            if (this.adw != null) {
                this.adw.setCurrentItem(this.ads, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adv.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adv.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.ads == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.adt = this.adv.get(i);
        if (this.adt.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_WRITE_THREAD));
        } else if (this.adt.mType != 8 || bl.aN(this.mContext)) {
            if (this.adx != null) {
                this.adx.f(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adr.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.ads;
    }

    public int getCurrentTabType() {
        if (this.ads < 0 || this.ads >= this.adv.size()) {
            return -1;
        }
        return this.adv.get(this.ads).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.adt != null) {
            return this.adt.adF;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adr;
    }

    public c cz(int i) {
        if (i < 0 || i >= this.adv.size()) {
            return null;
        }
        return this.adv.get(i);
    }

    public c cA(int i) {
        for (c cVar : this.adv) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adv.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adw.getId(), this.ady.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adv) {
            if (cVar.adG != null) {
                cVar.adG.cB();
            }
        }
        this.adv.clear();
        this.adt = null;
        this.ads = -1;
        this.adr.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(as.cQ(w.g.s_tabbar_bg));
        if (i == 2 && this.adu) {
            this.adz.setBackgroundDrawable(bitmapDrawable);
        } else {
            as.k(this.adz, w.e.common_color_10274);
        }
        this.adr.onChangeSkinType(i);
        if (this.adB != null) {
            as.k(this.adB, w.e.cp_bg_line_b);
        }
        for (c cVar : this.adv) {
            cVar.adE.dp(i);
        }
        if (this.ady != null) {
            int count = this.ady.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ady.getItem(i2);
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
        this.adr.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.ads = i;
        this.adt = this.adv.get(i);
        this.adr.g(this.ads, false);
        ViewGroup viewGroup = (ViewGroup) this.adt.adF.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adC;
        private List<c> adD;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adC = -1;
            this.adD = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adD.get(i).adF;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adD.get(i).adF.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adD.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adC != i) {
                if (this.adC != -1) {
                    ((BaseFragment) getItem(this.adC)).setPrimary(false);
                }
                this.adC = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adu = z;
    }
}
