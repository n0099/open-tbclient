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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget.c YA;
    private FragmentTabWidget Yp;
    private int Yq;
    private b Yr;
    private View Ys;
    private final List<b> Yt;
    private CustomViewPager Yu;
    private a Yv;
    private FrameLayout Yw;
    private d Yx;
    private Animation Yy;
    private Animation Yz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public static class b {
        public FragmentTabIndicator YD;
        public Fragment YE;
        public com.baidu.tbadk.mainTab.b YF;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Yt = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Yx = new com.baidu.tbadk.core.tabHost.a(this);
        this.YA = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yt = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Yx = new com.baidu.tbadk.core.tabHost.a(this);
        this.YA = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.fragment_tabhost, (ViewGroup) this, true);
        this.Yw = (FrameLayout) findViewById(i.f.tabcontainer_wrapper);
        this.Ys = findViewById(i.f.tabcontainer_layer);
        am.j(this.Ys, i.c.black_alpha50);
        this.Yq = -1;
        this.Yr = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Ys != null) {
            this.Ys.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Yp != null) {
            this.Yp.getLayoutParams().height = i;
            this.Yp.requestLayout();
            this.Yw.getLayoutParams().height = i;
            this.Yw.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.Yw;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Yp != null) {
            this.Yp.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Yp != null) {
            this.Yp.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Yp = (FragmentTabWidget) findViewById(i.f.tabcontainer);
        this.Yp.setTabSelectionListener(this);
        this.Yp.setOnSizeChangedListener(this.YA);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.Yp.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.YD == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.YE == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Yt.contains(bVar)) {
            if (bVar.YF != null) {
                bVar.YF.onAdd();
            }
            this.Yp.addView(bVar.YD, i);
            if (i == -1) {
                this.Yt.add(bVar);
            } else {
                this.Yt.add(i, bVar);
            }
            if (this.Yq != -1 && i <= this.Yq) {
                this.Yq++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Yu != null) {
            this.Yu.setScrollable(z);
        }
    }

    public void initViewPager() {
        ca(0);
    }

    public void ca(int i) {
        if (this.Yu != null) {
            removeView(this.Yu);
        }
        this.Yu = new CustomViewPager(this.mContext);
        this.Yu.setId(i.f.tab_content);
        cb(i);
        addView(this.Yu);
        removeView(this.Yw);
        addView(this.Yw);
        this.Yu.setOffscreenPageLimit(this.Yt.size() - 1);
        this.Yu.setOnPageChangeListener(this);
        this.Yv = new a(this.mFragmentManager, this.Yt);
        this.Yu.setAdapter(this.Yv);
    }

    public void cb(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Yu.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Yu.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.Yw.getLayoutParams();
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
        this.Yu.setLayoutParams(layoutParams);
        this.Yw.setLayoutParams(layoutParams2);
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
        if (i >= 0 && i < this.Yt.size() && i != this.Yq) {
            this.Yq = i;
            this.Yr = this.Yt.get(this.Yq);
            this.Yp.d(this.Yq, true);
            if (this.Yu != null) {
                this.Yu.setCurrentItem(this.Yq, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Yt.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Yt.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Yq == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Yp.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Yq;
    }

    public int getCurrentTabType() {
        if (this.Yq < 0 || this.Yq >= this.Yt.size()) {
            return -1;
        }
        return this.Yt.get(this.Yq).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Ys.clearAnimation();
            this.Ys.startAnimation(getLayerInAnimation());
            return;
        }
        this.Ys.clearAnimation();
        this.Ys.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i) {
        if (i > 0 && (this.Ys.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Ys.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.Yw.getLayoutParams().height = i;
                this.Yw.requestLayout();
                this.Ys.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Ys.clearAnimation();
        this.Ys.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Yr != null) {
            return this.Yr.YE;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Yp;
    }

    public b cd(int i) {
        if (i < 0 || i >= this.Yt.size()) {
            return null;
        }
        return this.Yt.get(i);
    }

    public b ce(int i) {
        for (b bVar : this.Yt) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Yt.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Yu.getId(), this.Yv.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.Yt) {
            if (bVar.YF != null) {
                bVar.YF.onRemove();
            }
        }
        this.Yt.clear();
        this.Yr = null;
        this.Yq = -1;
        this.Yp.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.Yy == null) {
            this.Yy = AnimationUtils.loadAnimation(getContext(), i.a.fade_in);
            this.Yy.setAnimationListener(this.Yx);
        }
        return this.Yy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.Yz == null) {
            this.Yz = AnimationUtils.loadAnimation(getContext(), i.a.fade_out);
            this.Yz.setAnimationListener(this.Yx);
        }
        return this.Yz;
    }

    public void onChangeSkinType(int i) {
        this.Yp.onChangeSkinType(i);
        for (b bVar : this.Yt) {
            bVar.YD.cP(i);
        }
        if (this.Yv != null) {
            int count = this.Yv.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Yv.getItem(i2);
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
        this.Yp.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Yq = i;
        this.Yr = this.Yt.get(i);
        this.Yp.d(this.Yq, false);
        ViewGroup viewGroup = (ViewGroup) this.Yr.YE.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<b> YC;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.YC = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YC.get(i).YE;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YC.get(i).YE.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YC.size();
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
