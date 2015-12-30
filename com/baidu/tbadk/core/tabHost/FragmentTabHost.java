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
    private FragmentTabWidget ZK;
    private int ZL;
    private c ZM;
    private View ZN;
    private final List<c> ZO;
    private CustomViewPager ZP;
    private b ZQ;
    private a ZR;
    private FrameLayout ZS;
    private d ZT;
    private Animation ZU;
    private Animation ZV;
    private FragmentTabWidget.c ZW;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void c(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator ZZ;
        public Fragment aaa;
        public com.baidu.tbadk.mainTab.b aab;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.ZO = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ZT = new com.baidu.tbadk.core.tabHost.a(this);
        this.ZW = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = new ArrayList();
        this.mOnPageChangeListener = null;
        this.ZT = new com.baidu.tbadk.core.tabHost.a(this);
        this.ZW = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(n.h.fragment_tabhost, (ViewGroup) this, true);
        this.ZS = (FrameLayout) findViewById(n.g.tabcontainer_wrapper);
        this.ZN = findViewById(n.g.tabcontainer_layer);
        as.j(this.ZN, n.d.black_alpha50);
        this.ZL = -1;
        this.ZM = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.ZN != null) {
            this.ZN.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.ZK != null) {
            this.ZK.getLayoutParams().height = i;
            this.ZK.requestLayout();
            this.ZS.getLayoutParams().height = i;
            this.ZS.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.ZS;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.ZK != null) {
            this.ZK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.ZK != null) {
            this.ZK.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.ZK = (FragmentTabWidget) findViewById(n.g.tabcontainer);
        this.ZK.setTabSelectionListener(this);
        this.ZK.setOnSizeChangedListener(this.ZW);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.ZK.setPadding(i, i2, i3, i4);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.ZZ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aaa == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.ZO.contains(cVar)) {
            if (cVar.aab != null) {
                cVar.aab.onAdd();
            }
            this.ZK.addView(cVar.ZZ, i);
            if (i == -1) {
                this.ZO.add(cVar);
            } else {
                this.ZO.add(i, cVar);
            }
            if (this.ZL != -1 && i <= this.ZL) {
                this.ZL++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.ZP != null) {
            this.ZP.setScrollable(z);
        }
    }

    public void initViewPager() {
        cb(0);
    }

    public void cb(int i) {
        if (this.ZP != null) {
            removeView(this.ZP);
        }
        this.ZP = new CustomViewPager(this.mContext);
        this.ZP.setId(n.g.tab_content);
        cc(i);
        addView(this.ZP);
        removeView(this.ZS);
        addView(this.ZS);
        this.ZP.setOffscreenPageLimit(this.ZO.size() - 1);
        this.ZP.setOnPageChangeListener(this);
        this.ZR = new a(this.mFragmentManager, this.ZO);
        this.ZP.setAdapter(this.ZR);
    }

    public void cc(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.ZP.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.ZP.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.ZS.getLayoutParams();
            layoutParams2.height = -2;
        }
        c(layoutParams.getRules());
        c(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(2, n.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, n.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.d(this.mContext, n.e.ds98);
        }
        this.ZP.setLayoutParams(layoutParams);
        this.ZS.setLayoutParams(layoutParams2);
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
        this.ZQ = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ZO.size() && i != this.ZL) {
            this.ZL = i;
            this.ZM = this.ZO.get(this.ZL);
            this.ZK.d(this.ZL, true);
            if (this.ZP != null) {
                this.ZP.setCurrentItem(this.ZL, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.ZO.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.ZO.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.ZL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        if (this.ZQ != null) {
            this.ZQ.c(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.ZK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.ZL;
    }

    public int getCurrentTabType() {
        if (this.ZL < 0 || this.ZL >= this.ZO.size()) {
            return -1;
        }
        return this.ZO.get(this.ZL).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.ZN.clearAnimation();
            this.ZN.startAnimation(getLayerInAnimation());
            return;
        }
        this.ZN.clearAnimation();
        this.ZN.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(int i) {
        if (i > 0 && (this.ZN.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ZN.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.ZS.getLayoutParams().height = i;
                this.ZS.requestLayout();
                this.ZN.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.ZN.clearAnimation();
        this.ZN.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.ZM != null) {
            return this.ZM.aaa;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.ZK;
    }

    public c ce(int i) {
        if (i < 0 || i >= this.ZO.size()) {
            return null;
        }
        return this.ZO.get(i);
    }

    public c cf(int i) {
        for (c cVar : this.ZO) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.ZO.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.ZP.getId(), this.ZR.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.ZO) {
            if (cVar.aab != null) {
                cVar.aab.onRemove();
            }
        }
        this.ZO.clear();
        this.ZM = null;
        this.ZL = -1;
        this.ZK.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.ZU == null) {
            this.ZU = AnimationUtils.loadAnimation(getContext(), n.a.fade_in);
            this.ZU.setAnimationListener(this.ZT);
        }
        return this.ZU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.ZV == null) {
            this.ZV = AnimationUtils.loadAnimation(getContext(), n.a.fade_out);
            this.ZV.setAnimationListener(this.ZT);
        }
        return this.ZV;
    }

    public void onChangeSkinType(int i) {
        this.ZK.onChangeSkinType(i);
        for (c cVar : this.ZO) {
            cVar.ZZ.cR(i);
        }
        if (this.ZR != null) {
            int count = this.ZR.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.ZR.getItem(i2);
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
        this.ZK.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.ZL = i;
        this.ZM = this.ZO.get(i);
        this.ZK.d(this.ZL, false);
        ViewGroup viewGroup = (ViewGroup) this.ZM.aaa.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private List<c> ZY;
        private int mPrimaryPosition;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.ZY = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.ZY.get(i).aaa;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.ZY.get(i).aaa.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.ZY.size();
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
