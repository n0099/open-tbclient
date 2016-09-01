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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private boolean YA;
    private View YB;
    private final List<c> YC;
    private CustomViewPager YD;
    private b YE;
    private a YF;
    private FrameLayout YG;
    private d YH;
    private Animation YI;
    private Animation YJ;
    private FragmentTabWidget.c YK;
    private FragmentTabWidget Yx;
    private int Yy;
    private c Yz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator YO;
        public Fragment YP;
        public com.baidu.tbadk.mainTab.b YQ;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.YA = true;
        this.YC = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YH = new com.baidu.tbadk.core.tabHost.a(this);
        this.YK = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YA = true;
        this.YC = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YH = new com.baidu.tbadk.core.tabHost.a(this);
        this.YK = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.fragment_tabhost, (ViewGroup) this, true);
        this.YG = (FrameLayout) findViewById(t.g.tabcontainer_wrapper);
        this.YB = findViewById(t.g.tabcontainer_layer);
        av.l(this.YB, t.d.common_color_10012);
        this.Yy = -1;
        this.Yz = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.YB != null) {
            this.YB.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Yx != null) {
            this.Yx.getLayoutParams().height = i;
            this.Yx.requestLayout();
            this.YG.getLayoutParams().height = i;
            this.YG.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.YG;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Yx != null) {
            this.Yx.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.Yx != null) {
            this.Yx.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Yx != null) {
            this.Yx.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Yx = (FragmentTabWidget) findViewById(t.g.tabcontainer);
        this.Yx.setTabSelectionListener(this);
        this.Yx.setOnSizeChangedListener(this.YK);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.Yx.setPadding(i, i2, i3, i4);
    }

    public void az(boolean z) {
        this.Yx.az(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.YO == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.YP == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.YC.contains(cVar)) {
            if (cVar.YQ != null) {
                cVar.YQ.ED();
            }
            this.Yx.addView(cVar.YO, i);
            if (i == -1) {
                this.YC.add(cVar);
            } else {
                this.YC.add(i, cVar);
            }
            if (this.Yy != -1 && i <= this.Yy) {
                this.Yy++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.YD != null) {
            this.YD.setScrollable(z);
        }
    }

    public void initViewPager() {
        cv(0);
    }

    public void cv(int i) {
        if (this.YD != null) {
            removeView(this.YD);
        }
        this.YD = new CustomViewPager(this.mContext);
        this.YD.setId(t.g.tab_content);
        cw(i);
        addView(this.YD);
        removeView(this.YG);
        addView(this.YG);
        this.YD.setOffscreenPageLimit(this.YC.size() - 1);
        this.YD.setOnPageChangeListener(this);
        this.YF = new a(this.mFragmentManager, this.YC);
        this.YD.setAdapter(this.YF);
    }

    public void tV() {
        if (this.YD != null) {
            removeView(this.YD);
        }
        this.YD = new CustomViewPager(this.mContext);
        this.YD.setId(t.g.tab_content);
        addView(this.YD);
        removeView(this.YG);
        addView(this.YG);
        this.YD.setOffscreenPageLimit(this.YC.size() - 1);
        this.YD.setOnPageChangeListener(this);
        this.YF = new a(this.mFragmentManager, this.YC);
        this.YD.setAdapter(this.YF);
    }

    public void cw(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.YD.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.YD.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.YG.getLayoutParams();
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
            layoutParams.addRule(3, t.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.e(this.mContext, t.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.e(this.mContext, t.e.ds98);
        }
        this.YD.setLayoutParams(layoutParams);
        this.YG.setLayoutParams(layoutParams2);
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
        this.YE = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YC.size() && i != this.Yy) {
            this.Yy = i;
            this.Yz = this.YC.get(this.Yy);
            this.Yx.g(this.Yy, true);
            if (this.YD != null) {
                this.YD.setCurrentItem(this.Yy, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.YC.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.YC.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Yy == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.YE != null) {
            this.YE.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Yx.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Yy;
    }

    public int getCurrentTabType() {
        if (this.Yy < 0 || this.Yy >= this.YC.size()) {
            return -1;
        }
        return this.YC.get(this.Yy).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.YB.clearAnimation();
            this.YB.startAnimation(getLayerInAnimation());
            return;
        }
        this.YB.clearAnimation();
        this.YB.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i) {
        if (i > 0 && (this.YB.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YB.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.YG.getLayoutParams().height = i;
                this.YG.requestLayout();
                this.YB.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.YB.clearAnimation();
        this.YB.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Yz != null) {
            return this.Yz.YP;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Yx;
    }

    public c cy(int i) {
        if (i < 0 || i >= this.YC.size()) {
            return null;
        }
        return this.YC.get(i);
    }

    public c cz(int i) {
        for (c cVar : this.YC) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.YC.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.YD.getId(), this.YF.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.YC) {
            if (cVar.YQ != null) {
                cVar.YQ.bt();
            }
        }
        this.YC.clear();
        this.Yz = null;
        this.Yy = -1;
        this.Yx.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YI == null) {
            this.YI = AnimationUtils.loadAnimation(getContext(), t.a.fade_in);
            this.YI.setAnimationListener(this.YH);
        }
        return this.YI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YJ == null) {
            this.YJ = AnimationUtils.loadAnimation(getContext(), t.a.fade_out);
            this.YJ.setAnimationListener(this.YH);
        }
        return this.YJ;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(av.cP(t.f.s_tabbar_bg));
        if (i == 2 && this.YA) {
            this.YG.setBackgroundDrawable(bitmapDrawable);
        } else {
            av.l(this.YG, t.d.common_color_10274);
        }
        this.Yx.onChangeSkinType(i);
        for (c cVar : this.YC) {
            cVar.YO.dl(i);
        }
        if (this.YF != null) {
            int count = this.YF.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.YF.getItem(i2);
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
        this.Yx.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Yy = i;
        this.Yz = this.YC.get(i);
        this.Yx.g(this.Yy, false);
        ViewGroup viewGroup = (ViewGroup) this.Yz.YP.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int YM;
        private List<c> YN;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.YM = -1;
            this.YN = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YN.get(i).YP;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YN.get(i).YP.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YN.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.YM != i) {
                if (this.YM != -1) {
                    ((BaseFragment) getItem(this.YM)).setPrimary(false);
                }
                this.YM = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.YA = z;
    }
}
