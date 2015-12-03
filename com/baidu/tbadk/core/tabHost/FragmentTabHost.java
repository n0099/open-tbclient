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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget Zh;
    private int Zi;
    private b Zj;
    private View Zk;
    private final List<b> Zl;
    private CustomViewPager Zm;
    private a Zn;
    private FrameLayout Zo;
    private d Zp;
    private Animation Zq;
    private Animation Zr;
    private FragmentTabWidget.c Zs;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public static class b {
        public FragmentTabIndicator Zv;
        public Fragment Zw;
        public com.baidu.tbadk.mainTab.b Zx;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Zl = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Zp = new com.baidu.tbadk.core.tabHost.a(this);
        this.Zs = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zl = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Zp = new com.baidu.tbadk.core.tabHost.a(this);
        this.Zs = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.g.fragment_tabhost, (ViewGroup) this, true);
        this.Zo = (FrameLayout) findViewById(n.f.tabcontainer_wrapper);
        this.Zk = findViewById(n.f.tabcontainer_layer);
        as.j(this.Zk, n.c.black_alpha50);
        this.Zi = -1;
        this.Zj = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Zk != null) {
            this.Zk.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Zh != null) {
            this.Zh.getLayoutParams().height = i;
            this.Zh.requestLayout();
            this.Zo.getLayoutParams().height = i;
            this.Zo.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.Zo;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Zh != null) {
            this.Zh.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Zh != null) {
            this.Zh.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Zh = (FragmentTabWidget) findViewById(n.f.tabcontainer);
        this.Zh.setTabSelectionListener(this);
        this.Zh.setOnSizeChangedListener(this.Zs);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.Zh.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.Zv == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.Zw == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Zl.contains(bVar)) {
            if (bVar.Zx != null) {
                bVar.Zx.onAdd();
            }
            this.Zh.addView(bVar.Zv, i);
            if (i == -1) {
                this.Zl.add(bVar);
            } else {
                this.Zl.add(i, bVar);
            }
            if (this.Zi != -1 && i <= this.Zi) {
                this.Zi++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Zm != null) {
            this.Zm.setScrollable(z);
        }
    }

    public void initViewPager() {
        ci(0);
    }

    public void ci(int i) {
        if (this.Zm != null) {
            removeView(this.Zm);
        }
        this.Zm = new CustomViewPager(this.mContext);
        this.Zm.setId(n.f.tab_content);
        cj(i);
        addView(this.Zm);
        removeView(this.Zo);
        addView(this.Zo);
        this.Zm.setOffscreenPageLimit(this.Zl.size() - 1);
        this.Zm.setOnPageChangeListener(this);
        this.Zn = new a(this.mFragmentManager, this.Zl);
        this.Zm.setAdapter(this.Zn);
    }

    public void cj(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Zm.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Zm.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.Zo.getLayoutParams();
            layoutParams2.height = -2;
        }
        c(layoutParams.getRules());
        c(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(2, n.f.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, n.f.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.d(this.mContext, n.d.ds98);
        }
        this.Zm.setLayoutParams(layoutParams);
        this.Zo.setLayoutParams(layoutParams2);
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

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Zl.size() && i != this.Zi) {
            this.Zi = i;
            this.Zj = this.Zl.get(this.Zi);
            this.Zh.d(this.Zi, true);
            if (this.Zm != null) {
                this.Zm.setCurrentItem(this.Zi, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Zl.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Zl.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Zi == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Zh.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Zi;
    }

    public int getCurrentTabType() {
        if (this.Zi < 0 || this.Zi >= this.Zl.size()) {
            return -1;
        }
        return this.Zl.get(this.Zi).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Zk.clearAnimation();
            this.Zk.startAnimation(getLayerInAnimation());
            return;
        }
        this.Zk.clearAnimation();
        this.Zk.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(int i) {
        if (i > 0 && (this.Zk.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Zk.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.Zo.getLayoutParams().height = i;
                this.Zo.requestLayout();
                this.Zk.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Zk.clearAnimation();
        this.Zk.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Zj != null) {
            return this.Zj.Zw;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Zh;
    }

    public b cl(int i) {
        if (i < 0 || i >= this.Zl.size()) {
            return null;
        }
        return this.Zl.get(i);
    }

    public b cm(int i) {
        for (b bVar : this.Zl) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Zl.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Zm.getId(), this.Zn.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.Zl) {
            if (bVar.Zx != null) {
                bVar.Zx.onRemove();
            }
        }
        this.Zl.clear();
        this.Zj = null;
        this.Zi = -1;
        this.Zh.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.Zq == null) {
            this.Zq = AnimationUtils.loadAnimation(getContext(), n.a.fade_in);
            this.Zq.setAnimationListener(this.Zp);
        }
        return this.Zq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.Zr == null) {
            this.Zr = AnimationUtils.loadAnimation(getContext(), n.a.fade_out);
            this.Zr.setAnimationListener(this.Zp);
        }
        return this.Zr;
    }

    public void onChangeSkinType(int i) {
        this.Zh.onChangeSkinType(i);
        for (b bVar : this.Zl) {
            bVar.Zv.cX(i);
        }
        if (this.Zn != null) {
            int count = this.Zn.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Zn.getItem(i2);
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
        this.Zh.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Zi = i;
        this.Zj = this.Zl.get(i);
        this.Zh.d(this.Zi, false);
        ViewGroup viewGroup = (ViewGroup) this.Zj.Zw.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<b> Zu;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.Zu = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Zu.get(i).Zw;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Zu.get(i).Zw.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Zu.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.mPrimaryPosition != i) {
                if (this.mPrimaryPosition != -1) {
                    ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }
}
