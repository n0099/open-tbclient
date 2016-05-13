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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget UK;
    private int UL;
    private c UM;
    private boolean UN;
    private View UO;
    private final List<c> UQ;
    private CustomViewPager UR;
    private b US;
    private a UT;
    private FrameLayout UU;
    private d UV;
    private Animation UW;
    private Animation UX;
    private FragmentTabWidget.c UY;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator Vc;
        public Fragment Vd;
        public com.baidu.tbadk.mainTab.b Ve;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.UN = true;
        this.UQ = new ArrayList();
        this.mOnPageChangeListener = null;
        this.UV = new com.baidu.tbadk.core.tabHost.a(this);
        this.UY = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UN = true;
        this.UQ = new ArrayList();
        this.mOnPageChangeListener = null;
        this.UV = new com.baidu.tbadk.core.tabHost.a(this);
        this.UY = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.fragment_tabhost, (ViewGroup) this, true);
        this.UU = (FrameLayout) findViewById(t.g.tabcontainer_wrapper);
        this.UO = findViewById(t.g.tabcontainer_layer);
        at.l(this.UO, t.d.black_alpha50);
        this.UL = -1;
        this.UM = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.UO != null) {
            this.UO.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.UK != null) {
            this.UK.getLayoutParams().height = i;
            this.UK.requestLayout();
            this.UU.getLayoutParams().height = i;
            this.UU.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.UU;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.UK != null) {
            this.UK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.UK != null) {
            this.UK.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.UK != null) {
            this.UK.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.UK = (FragmentTabWidget) findViewById(t.g.tabcontainer);
        this.UK.setTabSelectionListener(this);
        this.UK.setOnSizeChangedListener(this.UY);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.UK.setPadding(i, i2, i3, i4);
    }

    public void ax(boolean z) {
        this.UK.ax(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Vc == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.Vd == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.UQ.contains(cVar)) {
            if (cVar.Ve != null) {
                cVar.Ve.Dc();
            }
            this.UK.addView(cVar.Vc, i);
            if (i == -1) {
                this.UQ.add(cVar);
            } else {
                this.UQ.add(i, cVar);
            }
            if (this.UL != -1 && i <= this.UL) {
                this.UL++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.UR != null) {
            this.UR.setScrollable(z);
        }
    }

    public void initViewPager() {
        ch(0);
    }

    public void ch(int i) {
        if (this.UR != null) {
            removeView(this.UR);
        }
        this.UR = new CustomViewPager(this.mContext);
        this.UR.setId(t.g.tab_content);
        ci(i);
        addView(this.UR);
        removeView(this.UU);
        addView(this.UU);
        this.UR.setOffscreenPageLimit(this.UQ.size() - 1);
        this.UR.setOnPageChangeListener(this);
        this.UT = new a(this.mFragmentManager, this.UQ);
        this.UR.setAdapter(this.UT);
    }

    public void sU() {
        if (this.UR != null) {
            removeView(this.UR);
        }
        this.UR = new CustomViewPager(this.mContext);
        this.UR.setId(t.g.tab_content);
        addView(this.UR);
        removeView(this.UU);
        addView(this.UU);
        this.UR.setOffscreenPageLimit(this.UQ.size() - 1);
        this.UR.setOnPageChangeListener(this);
        this.UT = new a(this.mFragmentManager, this.UQ);
        this.UR.setAdapter(this.UT);
    }

    public void ci(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.UR.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.UR.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.UU.getLayoutParams();
            layoutParams2.height = -2;
        }
        b(layoutParams.getRules());
        b(layoutParams2.getRules());
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
            layoutParams.bottomMargin = k.c(this.mContext, t.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.c(this.mContext, t.e.ds98);
        }
        this.UR.setLayoutParams(layoutParams);
        this.UU.setLayoutParams(layoutParams2);
    }

    private void b(int[] iArr) {
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
        this.US = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.UQ.size() && i != this.UL) {
            this.UL = i;
            this.UM = this.UQ.get(this.UL);
            this.UK.f(this.UL, true);
            if (this.UR != null) {
                this.UR.setCurrentItem(this.UL, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.UQ.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.UQ.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.UL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        if (this.US != null) {
            this.US.e(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.UK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.UL;
    }

    public int getCurrentTabType() {
        if (this.UL < 0 || this.UL >= this.UQ.size()) {
            return -1;
        }
        return this.UQ.get(this.UL).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.UO.clearAnimation();
            this.UO.startAnimation(getLayerInAnimation());
            return;
        }
        this.UO.clearAnimation();
        this.UO.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(int i) {
        if (i > 0 && (this.UO.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.UO.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.UU.getLayoutParams().height = i;
                this.UU.requestLayout();
                this.UO.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.UO.clearAnimation();
        this.UO.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.UM != null) {
            return this.UM.Vd;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.UK;
    }

    public c ck(int i) {
        if (i < 0 || i >= this.UQ.size()) {
            return null;
        }
        return this.UQ.get(i);
    }

    public c cl(int i) {
        for (c cVar : this.UQ) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.UQ.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.UR.getId(), this.UT.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.UQ) {
            if (cVar.Ve != null) {
                cVar.Ve.ay();
            }
        }
        this.UQ.clear();
        this.UM = null;
        this.UL = -1;
        this.UK.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.UW == null) {
            this.UW = AnimationUtils.loadAnimation(getContext(), t.a.fade_in);
            this.UW.setAnimationListener(this.UV);
        }
        return this.UW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.UX == null) {
            this.UX = AnimationUtils.loadAnimation(getContext(), t.a.fade_out);
            this.UX.setAnimationListener(this.UV);
        }
        return this.UX;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(at.cB(t.f.s_tabbar_bg));
        if (i == 2 && this.UN) {
            this.UU.setBackgroundDrawable(bitmapDrawable);
        } else {
            at.l(this.UU, t.d.navigation_bar_bg);
        }
        this.UK.onChangeSkinType(i);
        for (c cVar : this.UQ) {
            cVar.Vc.cV(i);
        }
        if (this.UT != null) {
            int count = this.UT.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.UT.getItem(i2);
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
        this.UK.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.UL = i;
        this.UM = this.UQ.get(i);
        this.UK.f(this.UL, false);
        ViewGroup viewGroup = (ViewGroup) this.UM.Vd.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int Va;
        private List<c> Vb;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.Va = -1;
            this.Vb = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Vb.get(i).Vd;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Vb.get(i).Vd.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Vb.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.Va != i) {
                if (this.Va != -1) {
                    ((BaseFragment) getItem(this.Va)).setPrimary(false);
                }
                this.Va = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.UN = z;
    }
}
