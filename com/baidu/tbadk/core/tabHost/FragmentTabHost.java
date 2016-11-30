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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget Zi;
    private int Zj;
    private c Zk;
    private boolean Zl;
    private View Zm;
    private final List<c> Zn;
    private CustomViewPager Zo;
    private b Zp;
    private a Zq;
    private FrameLayout Zr;
    private d Zs;
    private Animation Zt;
    private Animation Zu;
    private FragmentTabWidget.c Zv;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public Fragment ZA;
        public com.baidu.tbadk.mainTab.b ZB;
        public FragmentTabIndicator Zz;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Zl = true;
        this.Zn = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Zs = new com.baidu.tbadk.core.tabHost.a(this);
        this.Zv = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zl = true;
        this.Zn = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Zs = new com.baidu.tbadk.core.tabHost.a(this);
        this.Zv = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(r.h.fragment_tabhost, (ViewGroup) this, true);
        this.Zr = (FrameLayout) findViewById(r.g.tabcontainer_wrapper);
        this.Zm = findViewById(r.g.tabcontainer_layer);
        at.l(this.Zm, r.d.common_color_10012);
        this.Zj = -1;
        this.Zk = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Zm != null) {
            this.Zm.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Zi != null) {
            this.Zi.getLayoutParams().height = i;
            this.Zi.requestLayout();
            this.Zr.getLayoutParams().height = i;
            this.Zr.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.Zr;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Zi != null) {
            this.Zi.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.Zi != null) {
            this.Zi.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Zi != null) {
            this.Zi.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Zi = (FragmentTabWidget) findViewById(r.g.tabcontainer);
        this.Zi.setTabSelectionListener(this);
        this.Zi.setOnSizeChangedListener(this.Zv);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.Zi.setPadding(i, i2, i3, i4);
    }

    public void aC(boolean z) {
        this.Zi.aC(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Zz == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.ZA == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Zn.contains(cVar)) {
            if (cVar.ZB != null) {
                cVar.ZB.EI();
            }
            this.Zi.addView(cVar.Zz, i);
            if (i == -1) {
                this.Zn.add(cVar);
            } else {
                this.Zn.add(i, cVar);
            }
            if (this.Zj != -1 && i <= this.Zj) {
                this.Zj++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Zo != null) {
            this.Zo.setScrollable(z);
        }
    }

    public void initViewPager() {
        cw(0);
    }

    public void cw(int i) {
        if (this.Zo != null) {
            removeView(this.Zo);
        }
        this.Zo = new CustomViewPager(this.mContext);
        this.Zo.setId(r.g.tab_content);
        cx(i);
        addView(this.Zo);
        removeView(this.Zr);
        addView(this.Zr);
        this.Zo.setOffscreenPageLimit(this.Zn.size() - 1);
        this.Zo.setOnPageChangeListener(this);
        this.Zq = new a(this.mFragmentManager, this.Zn);
        this.Zo.setAdapter(this.Zq);
    }

    public void up() {
        if (this.Zo != null) {
            removeView(this.Zo);
        }
        this.Zo = new CustomViewPager(this.mContext);
        this.Zo.setId(r.g.tab_content);
        addView(this.Zo);
        removeView(this.Zr);
        addView(this.Zr);
        this.Zo.setOffscreenPageLimit(this.Zn.size() - 1);
        this.Zo.setOnPageChangeListener(this);
        this.Zq = new a(this.mFragmentManager, this.Zn);
        this.Zo.setAdapter(this.Zq);
    }

    public void cx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Zo.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Zo.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.Zr.getLayoutParams();
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
        this.Zo.setLayoutParams(layoutParams);
        this.Zr.setLayoutParams(layoutParams2);
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
        this.Zp = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Zn.size() && i != this.Zj) {
            this.Zj = i;
            this.Zk = this.Zn.get(this.Zj);
            this.Zi.g(this.Zj, true);
            if (this.Zo != null) {
                this.Zo.setCurrentItem(this.Zj, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Zn.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Zn.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Zj == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.Zp != null) {
            this.Zp.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Zi.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Zj;
    }

    public int getCurrentTabType() {
        if (this.Zj < 0 || this.Zj >= this.Zn.size()) {
            return -1;
        }
        return this.Zn.get(this.Zj).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Zm.clearAnimation();
            this.Zm.startAnimation(getLayerInAnimation());
            return;
        }
        this.Zm.clearAnimation();
        this.Zm.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i) {
        if (i > 0 && (this.Zm.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zm.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.Zr.getLayoutParams().height = i;
                this.Zr.requestLayout();
                this.Zm.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Zm.clearAnimation();
        this.Zm.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Zk != null) {
            return this.Zk.ZA;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Zi;
    }

    public c cz(int i) {
        if (i < 0 || i >= this.Zn.size()) {
            return null;
        }
        return this.Zn.get(i);
    }

    public c cA(int i) {
        for (c cVar : this.Zn) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Zn.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Zo.getId(), this.Zq.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.Zn) {
            if (cVar.ZB != null) {
                cVar.ZB.bt();
            }
        }
        this.Zn.clear();
        this.Zk = null;
        this.Zj = -1;
        this.Zi.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.Zt == null) {
            this.Zt = AnimationUtils.loadAnimation(getContext(), r.a.fade_in);
            this.Zt.setAnimationListener(this.Zs);
        }
        return this.Zt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.Zu == null) {
            this.Zu = AnimationUtils.loadAnimation(getContext(), r.a.fade_out);
            this.Zu.setAnimationListener(this.Zs);
        }
        return this.Zu;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(at.cQ(r.f.s_tabbar_bg));
        if (i == 2 && this.Zl) {
            this.Zr.setBackgroundDrawable(bitmapDrawable);
        } else {
            at.l(this.Zr, r.d.common_color_10274);
        }
        this.Zi.onChangeSkinType(i);
        for (c cVar : this.Zn) {
            cVar.Zz.dm(i);
        }
        if (this.Zq != null) {
            int count = this.Zq.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Zq.getItem(i2);
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
        this.Zi.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Zj = i;
        this.Zk = this.Zn.get(i);
        this.Zi.g(this.Zj, false);
        ViewGroup viewGroup = (ViewGroup) this.Zk.ZA.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int Zx;
        private List<c> Zy;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.Zx = -1;
            this.Zy = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Zy.get(i).ZA;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Zy.get(i).ZA.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Zy.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.Zx != i) {
                if (this.Zx != -1) {
                    ((BaseFragment) getItem(this.Zx)).setPrimary(false);
                }
                this.Zx = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.Zl = z;
    }
}
