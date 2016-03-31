package com.baidu.tbadk.core.tabHost;

import android.content.Context;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private a ZA;
    private FrameLayout ZB;
    private d ZC;
    private Animation ZD;
    private Animation ZE;
    private FragmentTabWidget.c ZF;
    private FragmentTabWidget Zt;
    private int Zu;
    private c Zv;
    private View Zw;
    private final List<c> Zx;
    private CustomViewPager Zy;
    private b Zz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void c(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator ZJ;
        public Fragment ZK;
        public com.baidu.tbadk.mainTab.b ZL;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Zx = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ZC = new com.baidu.tbadk.core.tabHost.a(this);
        this.ZF = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zx = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ZC = new com.baidu.tbadk.core.tabHost.a(this);
        this.ZF = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.fragment_tabhost, (ViewGroup) this, true);
        this.ZB = (FrameLayout) findViewById(t.g.tabcontainer_wrapper);
        this.Zw = findViewById(t.g.tabcontainer_layer);
        at.l(this.Zw, t.d.black_alpha50);
        this.Zu = -1;
        this.Zv = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Zw != null) {
            this.Zw.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Zt != null) {
            this.Zt.getLayoutParams().height = i;
            this.Zt.requestLayout();
            this.ZB.getLayoutParams().height = i;
            this.ZB.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.ZB;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Zt != null) {
            this.Zt.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Zt != null) {
            this.Zt.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Zt = (FragmentTabWidget) findViewById(t.g.tabcontainer);
        this.Zt.setTabSelectionListener(this);
        this.Zt.setOnSizeChangedListener(this.ZF);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.Zt.setPadding(i, i2, i3, i4);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.ZJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.ZK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Zx.contains(cVar)) {
            if (cVar.ZL != null) {
                cVar.ZL.Fj();
            }
            this.Zt.addView(cVar.ZJ, i);
            if (i == -1) {
                this.Zx.add(cVar);
            } else {
                this.Zx.add(i, cVar);
            }
            if (this.Zu != -1 && i <= this.Zu) {
                this.Zu++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Zy != null) {
            this.Zy.setScrollable(z);
        }
    }

    public void initViewPager() {
        cz(0);
    }

    public void cz(int i) {
        if (this.Zy != null) {
            removeView(this.Zy);
        }
        this.Zy = new CustomViewPager(this.mContext);
        this.Zy.setId(t.g.tab_content);
        cA(i);
        addView(this.Zy);
        removeView(this.ZB);
        addView(this.ZB);
        this.Zy.setOffscreenPageLimit(this.Zx.size() - 1);
        this.Zy.setOnPageChangeListener(this);
        this.ZA = new a(this.mFragmentManager, this.Zx);
        this.Zy.setAdapter(this.ZA);
    }

    public void cA(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Zy.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Zy.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.ZB.getLayoutParams();
            layoutParams2.height = -2;
        }
        c(layoutParams.getRules());
        c(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(2, t.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, t.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.c(this.mContext, t.e.ds98);
        }
        this.Zy.setLayoutParams(layoutParams);
        this.ZB.setLayoutParams(layoutParams2);
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
        this.Zz = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Zx.size() && i != this.Zu) {
            this.Zu = i;
            this.Zv = this.Zx.get(this.Zu);
            this.Zt.d(this.Zu, true);
            if (this.Zy != null) {
                this.Zy.setCurrentItem(this.Zu, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Zx.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Zx.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Zu == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        if (this.Zz != null) {
            this.Zz.c(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Zt.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Zu;
    }

    public int getCurrentTabType() {
        if (this.Zu < 0 || this.Zu >= this.Zx.size()) {
            return -1;
        }
        return this.Zx.get(this.Zu).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Zw.clearAnimation();
            this.Zw.startAnimation(getLayerInAnimation());
            return;
        }
        this.Zw.clearAnimation();
        this.Zw.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i) {
        if (i > 0 && (this.Zw.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zw.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.ZB.getLayoutParams().height = i;
                this.ZB.requestLayout();
                this.Zw.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Zw.clearAnimation();
        this.Zw.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Zv != null) {
            return this.Zv.ZK;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Zt;
    }

    public c cC(int i) {
        if (i < 0 || i >= this.Zx.size()) {
            return null;
        }
        return this.Zx.get(i);
    }

    public c cD(int i) {
        for (c cVar : this.Zx) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Zx.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Zy.getId(), this.ZA.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.Zx) {
            if (cVar.ZL != null) {
                cVar.ZL.ei();
            }
        }
        this.Zx.clear();
        this.Zv = null;
        this.Zu = -1;
        this.Zt.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.ZD == null) {
            this.ZD = AnimationUtils.loadAnimation(getContext(), t.a.fade_in);
            this.ZD.setAnimationListener(this.ZC);
        }
        return this.ZD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.ZE == null) {
            this.ZE = AnimationUtils.loadAnimation(getContext(), t.a.fade_out);
            this.ZE.setAnimationListener(this.ZC);
        }
        return this.ZE;
    }

    public void onChangeSkinType(int i) {
        this.Zt.onChangeSkinType(i);
        for (c cVar : this.Zx) {
            cVar.ZJ.dn(i);
        }
        if (this.ZA != null) {
            int count = this.ZA.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ZA.getItem(i2);
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
        this.Zt.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Zu = i;
        this.Zv = this.Zx.get(i);
        this.Zt.d(this.Zu, false);
        ViewGroup viewGroup = (ViewGroup) this.Zv.ZK.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int ZH;
        private List<c> ZI;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.ZH = -1;
            this.ZI = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.ZI.get(i).ZK;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.ZI.get(i).ZK.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.ZI.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.ZH != i) {
                if (this.ZH != -1) {
                    ((BaseFragment) getItem(this.ZH)).setPrimary(false);
                }
                this.ZH = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }
}
