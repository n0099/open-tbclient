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
import android.widget.LinearLayout;
import com.baidu.adp.lib.g.d;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private b YA;
    private View YB;
    private final List<b> YC;
    private CustomViewPager YD;
    private a YE;
    private FrameLayout YF;
    private d YG;
    private Animation YH;
    private Animation YI;
    private FragmentTabWidget Yy;
    private int Yz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public static class b {
        public FragmentTabIndicator YL;
        public Fragment YM;
        public com.baidu.tbadk.mainTab.b YN;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.YC = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YG = new com.baidu.tbadk.core.tabHost.a(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YC = new ArrayList();
        this.mOnPageChangeListener = null;
        this.YG = new com.baidu.tbadk.core.tabHost.a(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(i.g.fragment_tabhost, (ViewGroup) this, true);
        this.YF = (FrameLayout) findViewById(i.f.tabcontainer_wrapper);
        this.YB = findViewById(i.f.tabcontainer_layer);
        al.i(this.YB, i.c.black_alpha50);
        this.Yz = -1;
        this.YA = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.YB != null) {
            this.YB.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Yy != null) {
            this.Yy.getLayoutParams().height = i;
            this.Yy.requestLayout();
            this.YF.getLayoutParams().height = i;
            this.YF.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.YF;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Yy != null) {
            this.Yy.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Yy != null) {
            this.Yy.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Yy = (FragmentTabWidget) findViewById(i.f.tabcontainer);
        this.Yy.setTabSelectionListener(this);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.Yy.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.YL == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.YM == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.YC.contains(bVar)) {
            if (bVar.YN != null) {
                bVar.YN.onAdd();
            }
            this.Yy.addView(bVar.YL, i);
            if (i == -1) {
                this.YC.add(bVar);
            } else {
                this.YC.add(i, bVar);
            }
            if (this.Yz != -1 && i <= this.Yz) {
                this.Yz++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.YD != null) {
            this.YD.setScrollable(z);
        }
    }

    public void initViewPager() {
        ca(0);
    }

    public void ca(int i) {
        if (this.YD != null) {
            removeView(this.YD);
        }
        this.YD = new CustomViewPager(this.mContext);
        this.YD.setId(i.f.tab_content);
        this.YD.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i == 1) {
            addView(this.YD, 0);
        } else {
            addView(this.YD);
        }
        this.YD.setOffscreenPageLimit(this.YC.size() - 1);
        this.YD.setOnPageChangeListener(this);
        this.YE = new a(this.mFragmentManager, this.YC);
        this.YD.setAdapter(this.YE);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.YC.size() && i != this.Yz) {
            this.Yz = i;
            this.YA = this.YC.get(this.Yz);
            this.Yy.d(this.Yz, true);
            if (this.YD != null) {
                this.YD.setCurrentItem(this.Yz, false);
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
        } else if (this.Yz == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Yy.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Yz;
    }

    public int getCurrentTabType() {
        if (this.Yz < 0 || this.Yz >= this.YC.size()) {
            return -1;
        }
        return this.YC.get(this.Yz).mType;
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

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.YB.clearAnimation();
        this.YB.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.YA != null) {
            return this.YA.YM;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Yy;
    }

    public b cb(int i) {
        if (i < 0 || i >= this.YC.size()) {
            return null;
        }
        return this.YC.get(i);
    }

    public b cc(int i) {
        for (b bVar : this.YC) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.YC.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.YD.getId(), this.YE.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.YC) {
            if (bVar.YN != null) {
                bVar.YN.onRemove();
            }
        }
        this.YC.clear();
        this.YA = null;
        this.Yz = -1;
        this.Yy.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.YH == null) {
            this.YH = AnimationUtils.loadAnimation(getContext(), i.a.fade_in);
            this.YH.setAnimationListener(this.YG);
        }
        return this.YH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.YI == null) {
            this.YI = AnimationUtils.loadAnimation(getContext(), i.a.fade_out);
            this.YI.setAnimationListener(this.YG);
        }
        return this.YI;
    }

    public void onChangeSkinType(int i) {
        this.Yy.onChangeSkinType(i);
        for (b bVar : this.YC) {
            bVar.YL.cO(i);
        }
        if (this.YE != null) {
            int count = this.YE.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.YE.getItem(i2);
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
        this.Yy.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Yz = i;
        this.YA = this.YC.get(i);
        this.Yy.d(this.Yz, false);
        ViewGroup viewGroup = (ViewGroup) this.YA.YM.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<b> YK;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.YK = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.YK.get(i).YM;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.YK.get(i).YM.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.YK.size();
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
