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
import com.baidu.adp.lib.h.d;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget YC;
    private int YD;
    private c YE;
    private boolean YF;
    private View YG;
    private final List<c> YH;
    private CustomViewPager YI;
    private b YJ;
    private a YK;
    private FrameLayout YL;
    private d YM;
    private Animation YN;
    private Animation YO;
    private FragmentTabWidget.c YP;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator YT;
        public Fragment YU;
        public com.baidu.tbadk.mainTab.b YV;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.YF = true;
        this.YH = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YM = new com.baidu.tbadk.core.tabHost.a(this);
        this.YP = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YF = true;
        this.YH = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YM = new com.baidu.tbadk.core.tabHost.a(this);
        this.YP = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.fragment_tabhost, (ViewGroup) this, true);
        this.YL = (FrameLayout) findViewById(r.g.tabcontainer_wrapper);
        this.YG = findViewById(r.g.tabcontainer_layer);
        ar.l(this.YG, r.d.common_color_10012);
        this.YD = -1;
        this.YE = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.YG != null) {
            this.YG.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.YC != null) {
            this.YC.getLayoutParams().height = i;
            this.YC.requestLayout();
            this.YL.getLayoutParams().height = i;
            this.YL.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.YL;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.YC != null) {
            this.YC.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.YC != null) {
            this.YC.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.YC != null) {
            this.YC.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.YC = (FragmentTabWidget) findViewById(r.g.tabcontainer);
        this.YC.setTabSelectionListener(this);
        this.YC.setOnSizeChangedListener(this.YP);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.YC.setPadding(i, i2, i3, i4);
    }

    public void aD(boolean z) {
        this.YC.aD(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.YT == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.YU == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.YH.contains(cVar)) {
            if (cVar.YV != null) {
                cVar.YV.Eq();
            }
            this.YC.addView(cVar.YT, i);
            if (i == -1) {
                this.YH.add(cVar);
            } else {
                this.YH.add(i, cVar);
            }
            if (this.YD != -1 && i <= this.YD) {
                this.YD++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.YI != null) {
            this.YI.setScrollable(z);
        }
    }

    public void initViewPager() {
        cy(0);
    }

    public void cy(int i) {
        if (this.YI != null) {
            removeView(this.YI);
        }
        this.YI = new CustomViewPager(this.mContext);
        this.YI.setId(r.g.tab_content);
        cz(i);
        addView(this.YI);
        removeView(this.YL);
        addView(this.YL);
        this.YI.setOffscreenPageLimit(this.YH.size() - 1);
        this.YI.setOnPageChangeListener(this);
        this.YK = new a(this.mFragmentManager, this.YH);
        this.YI.setAdapter(this.YK);
    }

    public void tZ() {
        if (this.YI != null) {
            removeView(this.YI);
        }
        this.YI = new CustomViewPager(this.mContext);
        this.YI.setId(r.g.tab_content);
        addView(this.YI);
        removeView(this.YL);
        addView(this.YL);
        this.YI.setOffscreenPageLimit(this.YH.size() - 1);
        this.YI.setOnPageChangeListener(this);
        this.YK = new a(this.mFragmentManager, this.YH);
        this.YI.setAdapter(this.YK);
    }

    public void cz(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.YI.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.YI.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.YL.getLayoutParams();
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
            layoutParams.addRule(3, r.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.e(this.mContext, r.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.e(this.mContext, r.e.ds98);
        }
        this.YI.setLayoutParams(layoutParams);
        this.YL.setLayoutParams(layoutParams2);
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
        this.YJ = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YH.size() && i != this.YD) {
            this.YD = i;
            this.YE = this.YH.get(this.YD);
            this.YC.g(this.YD, true);
            if (this.YI != null) {
                this.YI.setCurrentItem(this.YD, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.YH.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.YH.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.YD == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.YJ != null) {
            this.YJ.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.YC.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.YD;
    }

    public int getCurrentTabType() {
        if (this.YD < 0 || this.YD >= this.YH.size()) {
            return -1;
        }
        return this.YH.get(this.YD).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.YG.clearAnimation();
            this.YG.startAnimation(getLayerInAnimation());
            return;
        }
        this.YG.clearAnimation();
        this.YG.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(int i) {
        if (i > 0 && (this.YG.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YG.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.YL.getLayoutParams().height = i;
                this.YL.requestLayout();
                this.YG.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.YG.clearAnimation();
        this.YG.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.YE != null) {
            return this.YE.YU;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.YC;
    }

    public c cB(int i) {
        if (i < 0 || i >= this.YH.size()) {
            return null;
        }
        return this.YH.get(i);
    }

    public c cC(int i) {
        for (c cVar : this.YH) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.YH.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.YI.getId(), this.YK.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.YH) {
            if (cVar.YV != null) {
                cVar.YV.bt();
            }
        }
        this.YH.clear();
        this.YE = null;
        this.YD = -1;
        this.YC.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YN == null) {
            this.YN = AnimationUtils.loadAnimation(getContext(), r.a.fade_in);
            this.YN.setAnimationListener(this.YM);
        }
        return this.YN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YO == null) {
            this.YO = AnimationUtils.loadAnimation(getContext(), r.a.fade_out);
            this.YO.setAnimationListener(this.YM);
        }
        return this.YO;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ar.cS(r.f.s_tabbar_bg));
        if (i == 2 && this.YF) {
            this.YL.setBackgroundDrawable(bitmapDrawable);
        } else {
            ar.l(this.YL, r.d.common_color_10274);
        }
        this.YC.onChangeSkinType(i);
        for (c cVar : this.YH) {
            cVar.YT.m14do(i);
        }
        if (this.YK != null) {
            int count = this.YK.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.YK.getItem(i2);
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
        this.YC.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.YD = i;
        this.YE = this.YH.get(i);
        this.YC.g(this.YD, false);
        ViewGroup viewGroup = (ViewGroup) this.YE.YU.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int YR;
        private List<c> YS;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.YR = -1;
            this.YS = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YS.get(i).YU;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YS.get(i).YU.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YS.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.YR != i) {
                if (this.YR != -1) {
                    ((BaseFragment) getItem(this.YR)).setPrimary(false);
                }
                this.YR = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.YF = z;
    }
}
