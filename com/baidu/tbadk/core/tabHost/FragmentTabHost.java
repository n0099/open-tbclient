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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget XQ;
    private int XR;
    private c XS;
    private boolean XT;
    private View XU;
    private final List<c> XV;
    private CustomViewPager XW;
    private b XX;
    private a XY;
    private FrameLayout XZ;
    private d Ya;
    private Animation Yb;
    private Animation Yc;
    private FragmentTabWidget.c Yd;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator Yh;
        public Fragment Yi;
        public com.baidu.tbadk.mainTab.b Yj;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.XT = true;
        this.XV = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Ya = new com.baidu.tbadk.core.tabHost.a(this);
        this.Yd = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XT = true;
        this.XV = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Ya = new com.baidu.tbadk.core.tabHost.a(this);
        this.Yd = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.j.fragment_tabhost, (ViewGroup) this, true);
        this.XZ = (FrameLayout) findViewById(r.h.tabcontainer_wrapper);
        this.XU = findViewById(r.h.tabcontainer_layer);
        ap.k(this.XU, r.e.common_color_10012);
        this.XR = -1;
        this.XS = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.XU != null) {
            this.XU.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.XQ != null) {
            this.XQ.getLayoutParams().height = i;
            this.XQ.requestLayout();
            this.XZ.getLayoutParams().height = i;
            this.XZ.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.XZ;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.XQ != null) {
            this.XQ.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.XQ != null) {
            this.XQ.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.XQ != null) {
            this.XQ.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.XQ = (FragmentTabWidget) findViewById(r.h.tabcontainer);
        this.XQ.setTabSelectionListener(this);
        this.XQ.setOnSizeChangedListener(this.Yd);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.XQ.setPadding(i, i2, i3, i4);
    }

    public void aD(boolean z) {
        this.XQ.aD(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Yh == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.Yi == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.XV.contains(cVar)) {
            if (cVar.Yj != null) {
                cVar.Yj.El();
            }
            this.XQ.addView(cVar.Yh, i);
            if (i == -1) {
                this.XV.add(cVar);
            } else {
                this.XV.add(i, cVar);
            }
            if (this.XR != -1 && i <= this.XR) {
                this.XR++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.XW != null) {
            this.XW.setScrollable(z);
        }
    }

    public void initViewPager() {
        cx(0);
    }

    public void cx(int i) {
        if (this.XW != null) {
            removeView(this.XW);
        }
        this.XW = new CustomViewPager(this.mContext);
        this.XW.setId(r.h.tab_content);
        cy(i);
        addView(this.XW);
        removeView(this.XZ);
        addView(this.XZ);
        this.XW.setOffscreenPageLimit(this.XV.size() - 1);
        this.XW.setOnPageChangeListener(this);
        this.XY = new a(this.mFragmentManager, this.XV);
        this.XW.setAdapter(this.XY);
    }

    public void tT() {
        if (this.XW != null) {
            removeView(this.XW);
        }
        this.XW = new CustomViewPager(this.mContext);
        this.XW.setId(r.h.tab_content);
        addView(this.XW);
        removeView(this.XZ);
        addView(this.XZ);
        this.XW.setOffscreenPageLimit(this.XV.size() - 1);
        this.XW.setOnPageChangeListener(this);
        this.XY = new a(this.mFragmentManager, this.XV);
        this.XW.setAdapter(this.XY);
    }

    public void cy(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.XW.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.XW.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.XZ.getLayoutParams();
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
            layoutParams.addRule(3, r.h.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.e(this.mContext, r.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.e(this.mContext, r.f.ds98);
        }
        this.XW.setLayoutParams(layoutParams);
        this.XZ.setLayoutParams(layoutParams2);
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
        this.XX = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.XV.size() && i != this.XR) {
            this.XR = i;
            this.XS = this.XV.get(this.XR);
            this.XQ.g(this.XR, true);
            if (this.XW != null) {
                this.XW.setCurrentItem(this.XR, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.XV.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.XV.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.XR == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.XX != null) {
            this.XX.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.XQ.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.XR;
    }

    public int getCurrentTabType() {
        if (this.XR < 0 || this.XR >= this.XV.size()) {
            return -1;
        }
        return this.XV.get(this.XR).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.XU.clearAnimation();
            this.XU.startAnimation(getLayerInAnimation());
            return;
        }
        this.XU.clearAnimation();
        this.XU.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i) {
        if (i > 0 && (this.XU.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.XU.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.XZ.getLayoutParams().height = i;
                this.XZ.requestLayout();
                this.XU.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.XU.clearAnimation();
        this.XU.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.XS != null) {
            return this.XS.Yi;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.XQ;
    }

    public c cA(int i) {
        if (i < 0 || i >= this.XV.size()) {
            return null;
        }
        return this.XV.get(i);
    }

    public c cB(int i) {
        for (c cVar : this.XV) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.XV.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.XW.getId(), this.XY.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.XV) {
            if (cVar.Yj != null) {
                cVar.Yj.bt();
            }
        }
        this.XV.clear();
        this.XS = null;
        this.XR = -1;
        this.XQ.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.Yb == null) {
            this.Yb = AnimationUtils.loadAnimation(getContext(), r.a.fade_in);
            this.Yb.setAnimationListener(this.Ya);
        }
        return this.Yb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.Yc == null) {
            this.Yc = AnimationUtils.loadAnimation(getContext(), r.a.fade_out);
            this.Yc.setAnimationListener(this.Ya);
        }
        return this.Yc;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ap.cR(r.g.s_tabbar_bg));
        if (i == 2 && this.XT) {
            this.XZ.setBackgroundDrawable(bitmapDrawable);
        } else {
            ap.k(this.XZ, r.e.common_color_10274);
        }
        this.XQ.onChangeSkinType(i);
        for (c cVar : this.XV) {
            cVar.Yh.dp(i);
        }
        if (this.XY != null) {
            int count = this.XY.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.XY.getItem(i2);
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
        this.XQ.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.XR = i;
        this.XS = this.XV.get(i);
        this.XQ.g(this.XR, false);
        ViewGroup viewGroup = (ViewGroup) this.XS.Yi.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int Yf;
        private List<c> Yg;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.Yf = -1;
            this.Yg = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Yg.get(i).Yi;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Yg.get(i).Yi.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Yg.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.Yf != i) {
                if (this.Yf != -1) {
                    ((BaseFragment) getItem(this.Yf)).setPrimary(false);
                }
                this.Yf = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.XT = z;
    }
}
