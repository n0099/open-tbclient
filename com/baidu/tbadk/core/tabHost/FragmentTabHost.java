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
    private CustomViewPager YA;
    private a YB;
    private FrameLayout YC;
    private d YD;
    private Animation YE;
    private Animation YF;
    private FragmentTabWidget.c YG;
    private FragmentTabWidget Yv;
    private int Yw;
    private b Yx;
    private View Yy;
    private final List<b> Yz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public static class b {
        public FragmentTabIndicator YJ;
        public Fragment YK;
        public com.baidu.tbadk.mainTab.b YL;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Yz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YD = new com.baidu.tbadk.core.tabHost.a(this);
        this.YG = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YD = new com.baidu.tbadk.core.tabHost.a(this);
        this.YG = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.fragment_tabhost, (ViewGroup) this, true);
        this.YC = (FrameLayout) findViewById(i.f.tabcontainer_wrapper);
        this.Yy = findViewById(i.f.tabcontainer_layer);
        an.j(this.Yy, i.c.black_alpha50);
        this.Yw = -1;
        this.Yx = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Yy != null) {
            this.Yy.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Yv != null) {
            this.Yv.getLayoutParams().height = i;
            this.Yv.requestLayout();
            this.YC.getLayoutParams().height = i;
            this.YC.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.YC;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Yv != null) {
            this.Yv.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Yv != null) {
            this.Yv.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Yv = (FragmentTabWidget) findViewById(i.f.tabcontainer);
        this.Yv.setTabSelectionListener(this);
        this.Yv.setOnSizeChangedListener(this.YG);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.Yv.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.YJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.YK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Yz.contains(bVar)) {
            if (bVar.YL != null) {
                bVar.YL.onAdd();
            }
            this.Yv.addView(bVar.YJ, i);
            if (i == -1) {
                this.Yz.add(bVar);
            } else {
                this.Yz.add(i, bVar);
            }
            if (this.Yw != -1 && i <= this.Yw) {
                this.Yw++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.YA != null) {
            this.YA.setScrollable(z);
        }
    }

    public void initViewPager() {
        ca(0);
    }

    public void ca(int i) {
        if (this.YA != null) {
            removeView(this.YA);
        }
        this.YA = new CustomViewPager(this.mContext);
        this.YA.setId(i.f.tab_content);
        cb(i);
        addView(this.YA);
        removeView(this.YC);
        addView(this.YC);
        this.YA.setOffscreenPageLimit(this.Yz.size() - 1);
        this.YA.setOnPageChangeListener(this);
        this.YB = new a(this.mFragmentManager, this.Yz);
        this.YA.setAdapter(this.YB);
    }

    public void cb(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.YA.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.YA.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.YC.getLayoutParams();
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
        this.YA.setLayoutParams(layoutParams);
        this.YC.setLayoutParams(layoutParams2);
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
        if (i >= 0 && i < this.Yz.size() && i != this.Yw) {
            this.Yw = i;
            this.Yx = this.Yz.get(this.Yw);
            this.Yv.d(this.Yw, true);
            if (this.YA != null) {
                this.YA.setCurrentItem(this.Yw, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Yz.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Yz.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Yw == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Yv.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Yw;
    }

    public int getCurrentTabType() {
        if (this.Yw < 0 || this.Yw >= this.Yz.size()) {
            return -1;
        }
        return this.Yz.get(this.Yw).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Yy.clearAnimation();
            this.Yy.startAnimation(getLayerInAnimation());
            return;
        }
        this.Yy.clearAnimation();
        this.Yy.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i) {
        if (i > 0 && (this.Yy.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Yy.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.YC.getLayoutParams().height = i;
                this.YC.requestLayout();
                this.Yy.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Yy.clearAnimation();
        this.Yy.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Yx != null) {
            return this.Yx.YK;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Yv;
    }

    public b cd(int i) {
        if (i < 0 || i >= this.Yz.size()) {
            return null;
        }
        return this.Yz.get(i);
    }

    public b ce(int i) {
        for (b bVar : this.Yz) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Yz.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.YA.getId(), this.YB.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.Yz) {
            if (bVar.YL != null) {
                bVar.YL.onRemove();
            }
        }
        this.Yz.clear();
        this.Yx = null;
        this.Yw = -1;
        this.Yv.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YE == null) {
            this.YE = AnimationUtils.loadAnimation(getContext(), i.a.fade_in);
            this.YE.setAnimationListener(this.YD);
        }
        return this.YE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YF == null) {
            this.YF = AnimationUtils.loadAnimation(getContext(), i.a.fade_out);
            this.YF.setAnimationListener(this.YD);
        }
        return this.YF;
    }

    public void onChangeSkinType(int i) {
        this.Yv.onChangeSkinType(i);
        for (b bVar : this.Yz) {
            bVar.YJ.cP(i);
        }
        if (this.YB != null) {
            int count = this.YB.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.YB.getItem(i2);
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
        this.Yv.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Yw = i;
        this.Yx = this.Yz.get(i);
        this.Yv.d(this.Yw, false);
        ViewGroup viewGroup = (ViewGroup) this.Yx.YK.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<b> YI;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.YI = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YI.get(i).YK;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YI.get(i).YK.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YI.size();
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
