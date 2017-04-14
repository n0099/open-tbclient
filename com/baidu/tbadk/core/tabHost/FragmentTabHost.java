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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private b adA;
    private a adB;
    private FrameLayout adC;
    private d adD;
    private Animation adE;
    private Animation adF;
    private FragmentTabWidget.c adG;
    private FragmentTabWidget adt;
    private int adu;
    private c adv;
    private boolean adw;
    private View adx;
    private final List<c> ady;
    private CustomViewPager adz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator adK;
        public Fragment adL;
        public com.baidu.tbadk.mainTab.b adM;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adw = true;
        this.ady = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adD = new com.baidu.tbadk.core.tabHost.a(this);
        this.adG = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adw = true;
        this.ady = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adD = new com.baidu.tbadk.core.tabHost.a(this);
        this.adG = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.adC = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.adx = findViewById(w.h.tabcontainer_layer);
        aq.k(this.adx, w.e.common_color_10012);
        this.adu = -1;
        this.adv = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.adx != null) {
            this.adx.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adt != null) {
            this.adt.getLayoutParams().height = i;
            this.adt.requestLayout();
            this.adC.getLayoutParams().height = i;
            this.adC.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adC;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adt != null) {
            this.adt.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adt != null) {
            this.adt.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.adt != null) {
            this.adt.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adt = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.adt.setTabSelectionListener(this);
        this.adt.setOnSizeChangedListener(this.adG);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.adt.setPadding(i, i2, i3, i4);
    }

    public void aE(boolean z) {
        this.adt.aE(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adK == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.adL == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.ady.contains(cVar)) {
            if (cVar.adM != null) {
                cVar.adM.Fc();
            }
            this.adt.addView(cVar.adK, i);
            if (i == -1) {
                this.ady.add(cVar);
            } else {
                this.ady.add(i, cVar);
            }
            if (this.adu != -1 && i <= this.adu) {
                this.adu++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adz != null) {
            this.adz.setScrollable(z);
        }
    }

    public void initViewPager() {
        cw(0);
    }

    public void cw(int i) {
        if (this.adz != null) {
            removeView(this.adz);
        }
        this.adz = new CustomViewPager(this.mContext);
        this.adz.setId(w.h.tab_content);
        cx(i);
        addView(this.adz);
        removeView(this.adC);
        addView(this.adC);
        this.adz.setOffscreenPageLimit(this.ady.size() - 1);
        this.adz.setOnPageChangeListener(this);
        this.adB = new a(this.mFragmentManager, this.ady);
        this.adz.setAdapter(this.adB);
    }

    public void uO() {
        if (this.adz != null) {
            removeView(this.adz);
        }
        this.adz = new CustomViewPager(this.mContext);
        this.adz.setId(w.h.tab_content);
        addView(this.adz);
        removeView(this.adC);
        addView(this.adC);
        this.adz.setOffscreenPageLimit(this.ady.size() - 1);
        this.adz.setOnPageChangeListener(this);
        this.adB = new a(this.mFragmentManager, this.ady);
        this.adz.setAdapter(this.adB);
    }

    public void cx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adz.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adz.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adC.getLayoutParams();
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
        this.adz.setLayoutParams(layoutParams);
        this.adC.setLayoutParams(layoutParams2);
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
        this.adA = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ady.size() && i != this.adu) {
            this.adu = i;
            this.adv = this.ady.get(this.adu);
            this.adt.g(this.adu, true);
            if (this.adz != null) {
                this.adz.setCurrentItem(this.adu, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.ady.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.ady.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adu == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.adA != null) {
            this.adA.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adt.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adu;
    }

    public int getCurrentTabType() {
        if (this.adu < 0 || this.adu >= this.ady.size()) {
            return -1;
        }
        return this.ady.get(this.adu).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.adx.clearAnimation();
            this.adx.startAnimation(getLayerInAnimation());
            return;
        }
        this.adx.clearAnimation();
        this.adx.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i) {
        if (i > 0 && (this.adx.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.adx.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.adC.getLayoutParams().height = i;
                this.adC.requestLayout();
                this.adx.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.adx.clearAnimation();
        this.adx.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.adv != null) {
            return this.adv.adL;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adt;
    }

    public c cz(int i) {
        if (i < 0 || i >= this.ady.size()) {
            return null;
        }
        return this.ady.get(i);
    }

    public c cA(int i) {
        for (c cVar : this.ady) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.ady.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adz.getId(), this.adB.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.ady) {
            if (cVar.adM != null) {
                cVar.adM.cB();
            }
        }
        this.ady.clear();
        this.adv = null;
        this.adu = -1;
        this.adt.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.adE == null) {
            this.adE = AnimationUtils.loadAnimation(getContext(), w.a.fade_in);
            this.adE.setAnimationListener(this.adD);
        }
        return this.adE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.adF == null) {
            this.adF = AnimationUtils.loadAnimation(getContext(), w.a.fade_out);
            this.adF.setAnimationListener(this.adD);
        }
        return this.adF;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aq.cQ(w.g.s_tabbar_bg));
        if (i == 2 && this.adw) {
            this.adC.setBackgroundDrawable(bitmapDrawable);
        } else {
            aq.k(this.adC, w.e.common_color_10274);
        }
        this.adt.onChangeSkinType(i);
        for (c cVar : this.ady) {
            cVar.adK.m14do(i);
        }
        if (this.adB != null) {
            int count = this.adB.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adB.getItem(i2);
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
        this.adt.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adu = i;
        this.adv = this.ady.get(i);
        this.adt.g(this.adu, false);
        ViewGroup viewGroup = (ViewGroup) this.adv.adL.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adI;
        private List<c> adJ;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adI = -1;
            this.adJ = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adJ.get(i).adL;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adJ.get(i).adL.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adJ.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adI != i) {
                if (this.adI != -1) {
                    ((BaseFragment) getItem(this.adI)).setPrimary(false);
                }
                this.adI = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adw = z;
    }
}
