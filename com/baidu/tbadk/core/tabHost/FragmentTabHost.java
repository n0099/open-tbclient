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
    private CustomViewPager adA;
    private b adB;
    private a adC;
    private FrameLayout adD;
    private d adE;
    private Animation adF;
    private Animation adG;
    private FragmentTabWidget.c adH;
    private FragmentTabWidget adu;
    private int adv;
    private c adw;
    private boolean adx;
    private View ady;
    private final List<c> adz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator adL;
        public Fragment adM;
        public com.baidu.tbadk.mainTab.b adN;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adx = true;
        this.adz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adE = new com.baidu.tbadk.core.tabHost.a(this);
        this.adH = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adx = true;
        this.adz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adE = new com.baidu.tbadk.core.tabHost.a(this);
        this.adH = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.adD = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.ady = findViewById(w.h.tabcontainer_layer);
        aq.k(this.ady, w.e.common_color_10012);
        this.adv = -1;
        this.adw = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.ady != null) {
            this.ady.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adu != null) {
            this.adu.getLayoutParams().height = i;
            this.adu.requestLayout();
            this.adD.getLayoutParams().height = i;
            this.adD.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adD;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adu != null) {
            this.adu.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adu != null) {
            this.adu.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.adu != null) {
            this.adu.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adu = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.adu.setTabSelectionListener(this);
        this.adu.setOnSizeChangedListener(this.adH);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.adu.setPadding(i, i2, i3, i4);
    }

    public void aE(boolean z) {
        this.adu.aE(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adL == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.adM == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adz.contains(cVar)) {
            if (cVar.adN != null) {
                cVar.adN.Fc();
            }
            this.adu.addView(cVar.adL, i);
            if (i == -1) {
                this.adz.add(cVar);
            } else {
                this.adz.add(i, cVar);
            }
            if (this.adv != -1 && i <= this.adv) {
                this.adv++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adA != null) {
            this.adA.setScrollable(z);
        }
    }

    public void initViewPager() {
        cw(0);
    }

    public void cw(int i) {
        if (this.adA != null) {
            removeView(this.adA);
        }
        this.adA = new CustomViewPager(this.mContext);
        this.adA.setId(w.h.tab_content);
        cx(i);
        addView(this.adA);
        removeView(this.adD);
        addView(this.adD);
        this.adA.setOffscreenPageLimit(this.adz.size() - 1);
        this.adA.setOnPageChangeListener(this);
        this.adC = new a(this.mFragmentManager, this.adz);
        this.adA.setAdapter(this.adC);
    }

    public void uO() {
        if (this.adA != null) {
            removeView(this.adA);
        }
        this.adA = new CustomViewPager(this.mContext);
        this.adA.setId(w.h.tab_content);
        addView(this.adA);
        removeView(this.adD);
        addView(this.adD);
        this.adA.setOffscreenPageLimit(this.adz.size() - 1);
        this.adA.setOnPageChangeListener(this);
        this.adC = new a(this.mFragmentManager, this.adz);
        this.adA.setAdapter(this.adC);
    }

    public void cx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adA.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adA.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adD.getLayoutParams();
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
        this.adA.setLayoutParams(layoutParams);
        this.adD.setLayoutParams(layoutParams2);
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
        this.adB = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adz.size() && i != this.adv) {
            this.adv = i;
            this.adw = this.adz.get(this.adv);
            this.adu.g(this.adv, true);
            if (this.adA != null) {
                this.adA.setCurrentItem(this.adv, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adz.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adz.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adv == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.adB != null) {
            this.adB.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adu.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adv;
    }

    public int getCurrentTabType() {
        if (this.adv < 0 || this.adv >= this.adz.size()) {
            return -1;
        }
        return this.adz.get(this.adv).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.ady.clearAnimation();
            this.ady.startAnimation(getLayerInAnimation());
            return;
        }
        this.ady.clearAnimation();
        this.ady.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i) {
        if (i > 0 && (this.ady.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ady.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.adD.getLayoutParams().height = i;
                this.adD.requestLayout();
                this.ady.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.ady.clearAnimation();
        this.ady.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.adw != null) {
            return this.adw.adM;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adu;
    }

    public c cz(int i) {
        if (i < 0 || i >= this.adz.size()) {
            return null;
        }
        return this.adz.get(i);
    }

    public c cA(int i) {
        for (c cVar : this.adz) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adz.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adA.getId(), this.adC.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adz) {
            if (cVar.adN != null) {
                cVar.adN.cB();
            }
        }
        this.adz.clear();
        this.adw = null;
        this.adv = -1;
        this.adu.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.adF == null) {
            this.adF = AnimationUtils.loadAnimation(getContext(), w.a.fade_in);
            this.adF.setAnimationListener(this.adE);
        }
        return this.adF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.adG == null) {
            this.adG = AnimationUtils.loadAnimation(getContext(), w.a.fade_out);
            this.adG.setAnimationListener(this.adE);
        }
        return this.adG;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aq.cQ(w.g.s_tabbar_bg));
        if (i == 2 && this.adx) {
            this.adD.setBackgroundDrawable(bitmapDrawable);
        } else {
            aq.k(this.adD, w.e.common_color_10274);
        }
        this.adu.onChangeSkinType(i);
        for (c cVar : this.adz) {
            cVar.adL.m14do(i);
        }
        if (this.adC != null) {
            int count = this.adC.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adC.getItem(i2);
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
        this.adu.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adv = i;
        this.adw = this.adz.get(i);
        this.adu.g(this.adv, false);
        ViewGroup viewGroup = (ViewGroup) this.adw.adM.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adJ;
        private List<c> adK;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adJ = -1;
            this.adK = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adK.get(i).adM;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adK.get(i).adM.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adK.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adJ != i) {
                if (this.adJ != -1) {
                    ((BaseFragment) getItem(this.adJ)).setPrimary(false);
                }
                this.adJ = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adx = z;
    }
}
