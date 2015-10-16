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
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private Animation YA;
    private Animation YB;
    private FragmentTabWidget.c YC;
    private FragmentTabWidget Yr;
    private int Ys;
    private b Yt;
    private View Yu;
    private final List<b> Yv;
    private CustomViewPager Yw;
    private a Yx;
    private FrameLayout Yy;
    private d Yz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public static class b {
        public FragmentTabIndicator YF;
        public Fragment YG;
        public com.baidu.tbadk.mainTab.b YH;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Yv = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Yz = new com.baidu.tbadk.core.tabHost.a(this);
        this.YC = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yv = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Yz = new com.baidu.tbadk.core.tabHost.a(this);
        this.YC = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.fragment_tabhost, (ViewGroup) this, true);
        this.Yy = (FrameLayout) findViewById(i.f.tabcontainer_wrapper);
        this.Yu = findViewById(i.f.tabcontainer_layer);
        an.j(this.Yu, i.c.black_alpha50);
        this.Ys = -1;
        this.Yt = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Yu != null) {
            this.Yu.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Yr != null) {
            this.Yr.getLayoutParams().height = i;
            this.Yr.requestLayout();
            this.Yy.getLayoutParams().height = i;
            this.Yy.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.Yy;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Yr != null) {
            this.Yr.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Yr != null) {
            this.Yr.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Yr = (FragmentTabWidget) findViewById(i.f.tabcontainer);
        this.Yr.setTabSelectionListener(this);
        this.Yr.setOnSizeChangedListener(this.YC);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.Yr.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.YF == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.YG == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Yv.contains(bVar)) {
            if (bVar.YH != null) {
                bVar.YH.onAdd();
            }
            this.Yr.addView(bVar.YF, i);
            if (i == -1) {
                this.Yv.add(bVar);
            } else {
                this.Yv.add(i, bVar);
            }
            if (this.Ys != -1 && i <= this.Ys) {
                this.Ys++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Yw != null) {
            this.Yw.setScrollable(z);
        }
    }

    public void initViewPager() {
        ca(0);
    }

    public void ca(int i) {
        if (this.Yw != null) {
            removeView(this.Yw);
        }
        this.Yw = new CustomViewPager(this.mContext);
        this.Yw.setId(i.f.tab_content);
        cb(i);
        addView(this.Yw);
        removeView(this.Yy);
        addView(this.Yy);
        this.Yw.setOffscreenPageLimit(this.Yv.size() - 1);
        this.Yw.setOnPageChangeListener(this);
        this.Yx = new a(this.mFragmentManager, this.Yv);
        this.Yw.setAdapter(this.Yx);
    }

    public void cb(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Yw.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Yw.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.Yy.getLayoutParams();
            layoutParams2.height = -2;
        }
        c(layoutParams.getRules());
        c(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(2, i.f.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, i.f.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.d(getContext(), i.d.ds80);
        }
        this.Yw.setLayoutParams(layoutParams);
        this.Yy.setLayoutParams(layoutParams2);
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
        if (i >= 0 && i < this.Yv.size() && i != this.Ys) {
            this.Ys = i;
            this.Yt = this.Yv.get(this.Ys);
            this.Yr.d(this.Ys, true);
            if (this.Yw != null) {
                this.Yw.setCurrentItem(this.Ys, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Yv.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Yv.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Ys == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Yr.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Ys;
    }

    public int getCurrentTabType() {
        if (this.Ys < 0 || this.Ys >= this.Yv.size()) {
            return -1;
        }
        return this.Yv.get(this.Ys).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Yu.clearAnimation();
            this.Yu.startAnimation(getLayerInAnimation());
            return;
        }
        this.Yu.clearAnimation();
        this.Yu.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i) {
        if (i > 0 && (this.Yu.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yu.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.Yy.getLayoutParams().height = i;
                this.Yy.requestLayout();
                this.Yu.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Yu.clearAnimation();
        this.Yu.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Yt != null) {
            return this.Yt.YG;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Yr;
    }

    public b cd(int i) {
        if (i < 0 || i >= this.Yv.size()) {
            return null;
        }
        return this.Yv.get(i);
    }

    public b ce(int i) {
        for (b bVar : this.Yv) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Yv.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Yw.getId(), this.Yx.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.Yv) {
            if (bVar.YH != null) {
                bVar.YH.onRemove();
            }
        }
        this.Yv.clear();
        this.Yt = null;
        this.Ys = -1;
        this.Yr.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YA == null) {
            this.YA = AnimationUtils.loadAnimation(getContext(), i.a.fade_in);
            this.YA.setAnimationListener(this.Yz);
        }
        return this.YA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YB == null) {
            this.YB = AnimationUtils.loadAnimation(getContext(), i.a.fade_out);
            this.YB.setAnimationListener(this.Yz);
        }
        return this.YB;
    }

    public void onChangeSkinType(int i) {
        this.Yr.onChangeSkinType(i);
        for (b bVar : this.Yv) {
            bVar.YF.cP(i);
        }
        if (this.Yx != null) {
            int count = this.Yx.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Yx.getItem(i2);
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
        this.Yr.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Ys = i;
        this.Yt = this.Yv.get(i);
        this.Yr.d(this.Ys, false);
        ViewGroup viewGroup = (ViewGroup) this.Yt.YG.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<b> YE;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.YE = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YE.get(i).YG;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YE.get(i).YG.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YE.size();
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
