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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget YK;
    private int YL;
    private c YM;
    private boolean YN;
    private View YO;
    private final List<c> YP;
    private CustomViewPager YQ;
    private b YR;
    private a YS;
    private FrameLayout YT;
    private d YU;
    private Animation YV;
    private Animation YW;
    private FragmentTabWidget.c YX;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator Zb;
        public Fragment Zc;
        public com.baidu.tbadk.mainTab.b Zd;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.YN = true;
        this.YP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YU = new com.baidu.tbadk.core.tabHost.a(this);
        this.YX = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YN = true;
        this.YP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YU = new com.baidu.tbadk.core.tabHost.a(this);
        this.YX = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.fragment_tabhost, (ViewGroup) this, true);
        this.YT = (FrameLayout) findViewById(r.g.tabcontainer_wrapper);
        this.YO = findViewById(r.g.tabcontainer_layer);
        av.l(this.YO, r.d.common_color_10012);
        this.YL = -1;
        this.YM = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.YO != null) {
            this.YO.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.YK != null) {
            this.YK.getLayoutParams().height = i;
            this.YK.requestLayout();
            this.YT.getLayoutParams().height = i;
            this.YT.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.YT;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.YK != null) {
            this.YK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.YK != null) {
            this.YK.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.YK != null) {
            this.YK.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.YK = (FragmentTabWidget) findViewById(r.g.tabcontainer);
        this.YK.setTabSelectionListener(this);
        this.YK.setOnSizeChangedListener(this.YX);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.YK.setPadding(i, i2, i3, i4);
    }

    public void az(boolean z) {
        this.YK.az(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Zb == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.Zc == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.YP.contains(cVar)) {
            if (cVar.Zd != null) {
                cVar.Zd.ED();
            }
            this.YK.addView(cVar.Zb, i);
            if (i == -1) {
                this.YP.add(cVar);
            } else {
                this.YP.add(i, cVar);
            }
            if (this.YL != -1 && i <= this.YL) {
                this.YL++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.YQ != null) {
            this.YQ.setScrollable(z);
        }
    }

    public void initViewPager() {
        cv(0);
    }

    public void cv(int i) {
        if (this.YQ != null) {
            removeView(this.YQ);
        }
        this.YQ = new CustomViewPager(this.mContext);
        this.YQ.setId(r.g.tab_content);
        cw(i);
        addView(this.YQ);
        removeView(this.YT);
        addView(this.YT);
        this.YQ.setOffscreenPageLimit(this.YP.size() - 1);
        this.YQ.setOnPageChangeListener(this);
        this.YS = new a(this.mFragmentManager, this.YP);
        this.YQ.setAdapter(this.YS);
    }

    public void ul() {
        if (this.YQ != null) {
            removeView(this.YQ);
        }
        this.YQ = new CustomViewPager(this.mContext);
        this.YQ.setId(r.g.tab_content);
        addView(this.YQ);
        removeView(this.YT);
        addView(this.YT);
        this.YQ.setOffscreenPageLimit(this.YP.size() - 1);
        this.YQ.setOnPageChangeListener(this);
        this.YS = new a(this.mFragmentManager, this.YP);
        this.YQ.setAdapter(this.YS);
    }

    public void cw(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.YQ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.YQ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.YT.getLayoutParams();
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
        this.YQ.setLayoutParams(layoutParams);
        this.YT.setLayoutParams(layoutParams2);
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
        this.YR = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YP.size() && i != this.YL) {
            this.YL = i;
            this.YM = this.YP.get(this.YL);
            this.YK.g(this.YL, true);
            if (this.YQ != null) {
                this.YQ.setCurrentItem(this.YL, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.YP.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.YP.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.YL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.YR != null) {
            this.YR.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.YK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.YL;
    }

    public int getCurrentTabType() {
        if (this.YL < 0 || this.YL >= this.YP.size()) {
            return -1;
        }
        return this.YP.get(this.YL).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.YO.clearAnimation();
            this.YO.startAnimation(getLayerInAnimation());
            return;
        }
        this.YO.clearAnimation();
        this.YO.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i) {
        if (i > 0 && (this.YO.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.YO.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.YT.getLayoutParams().height = i;
                this.YT.requestLayout();
                this.YO.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.YO.clearAnimation();
        this.YO.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.YM != null) {
            return this.YM.Zc;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.YK;
    }

    public c cy(int i) {
        if (i < 0 || i >= this.YP.size()) {
            return null;
        }
        return this.YP.get(i);
    }

    public c cz(int i) {
        for (c cVar : this.YP) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.YP.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.YQ.getId(), this.YS.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.YP) {
            if (cVar.Zd != null) {
                cVar.Zd.bt();
            }
        }
        this.YP.clear();
        this.YM = null;
        this.YL = -1;
        this.YK.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YV == null) {
            this.YV = AnimationUtils.loadAnimation(getContext(), r.a.fade_in);
            this.YV.setAnimationListener(this.YU);
        }
        return this.YV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YW == null) {
            this.YW = AnimationUtils.loadAnimation(getContext(), r.a.fade_out);
            this.YW.setAnimationListener(this.YU);
        }
        return this.YW;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(av.cP(r.f.s_tabbar_bg));
        if (i == 2 && this.YN) {
            this.YT.setBackgroundDrawable(bitmapDrawable);
        } else {
            av.l(this.YT, r.d.common_color_10274);
        }
        this.YK.onChangeSkinType(i);
        for (c cVar : this.YP) {
            cVar.Zb.dl(i);
        }
        if (this.YS != null) {
            int count = this.YS.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.YS.getItem(i2);
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
        this.YK.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.YL = i;
        this.YM = this.YP.get(i);
        this.YK.g(this.YL, false);
        ViewGroup viewGroup = (ViewGroup) this.YM.Zc.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int YZ;
        private List<c> Za;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.YZ = -1;
            this.Za = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Za.get(i).Zc;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Za.get(i).Zc.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Za.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.YZ != i) {
                if (this.YZ != -1) {
                    ((BaseFragment) getItem(this.YZ)).setPrimary(false);
                }
                this.YZ = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.YN = z;
    }
}
