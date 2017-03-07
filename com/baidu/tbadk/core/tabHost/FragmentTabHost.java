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
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget adf;
    private int adg;
    private c adh;
    private boolean adi;
    private View adj;
    private final List<c> adk;
    private CustomViewPager adl;
    private b adm;
    private a adn;
    private FrameLayout ado;
    private d adp;
    private Animation adq;
    private Animation adr;
    private FragmentTabWidget.c ads;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator adw;
        public Fragment adx;
        public com.baidu.tbadk.mainTab.b ady;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adi = true;
        this.adk = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adp = new com.baidu.tbadk.core.tabHost.a(this);
        this.ads = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adi = true;
        this.adk = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adp = new com.baidu.tbadk.core.tabHost.a(this);
        this.ads = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.ado = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.adj = findViewById(w.h.tabcontainer_layer);
        aq.k(this.adj, w.e.common_color_10012);
        this.adg = -1;
        this.adh = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.adj != null) {
            this.adj.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adf != null) {
            this.adf.getLayoutParams().height = i;
            this.adf.requestLayout();
            this.ado.getLayoutParams().height = i;
            this.ado.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.ado;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adf != null) {
            this.adf.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adf != null) {
            this.adf.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.adf != null) {
            this.adf.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adf = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.adf.setTabSelectionListener(this);
        this.adf.setOnSizeChangedListener(this.ads);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.adf.setPadding(i, i2, i3, i4);
    }

    public void aC(boolean z) {
        this.adf.aC(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adw == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.adx == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adk.contains(cVar)) {
            if (cVar.ady != null) {
                cVar.ady.EE();
            }
            this.adf.addView(cVar.adw, i);
            if (i == -1) {
                this.adk.add(cVar);
            } else {
                this.adk.add(i, cVar);
            }
            if (this.adg != -1 && i <= this.adg) {
                this.adg++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adl != null) {
            this.adl.setScrollable(z);
        }
    }

    public void initViewPager() {
        ct(0);
    }

    public void ct(int i) {
        if (this.adl != null) {
            removeView(this.adl);
        }
        this.adl = new CustomViewPager(this.mContext);
        this.adl.setId(w.h.tab_content);
        cu(i);
        addView(this.adl);
        removeView(this.ado);
        addView(this.ado);
        this.adl.setOffscreenPageLimit(this.adk.size() - 1);
        this.adl.setOnPageChangeListener(this);
        this.adn = new a(this.mFragmentManager, this.adk);
        this.adl.setAdapter(this.adn);
    }

    public void ur() {
        if (this.adl != null) {
            removeView(this.adl);
        }
        this.adl = new CustomViewPager(this.mContext);
        this.adl.setId(w.h.tab_content);
        addView(this.adl);
        removeView(this.ado);
        addView(this.ado);
        this.adl.setOffscreenPageLimit(this.adk.size() - 1);
        this.adl.setOnPageChangeListener(this);
        this.adn = new a(this.mFragmentManager, this.adk);
        this.adl.setAdapter(this.adn);
    }

    public void cu(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adl.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adl.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.ado.getLayoutParams();
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
            layoutParams.addRule(3, w.h.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.g(this.mContext, w.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.g(this.mContext, w.f.ds98);
        }
        this.adl.setLayoutParams(layoutParams);
        this.ado.setLayoutParams(layoutParams2);
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
        this.adm = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adk.size() && i != this.adg) {
            this.adg = i;
            this.adh = this.adk.get(this.adg);
            this.adf.g(this.adg, true);
            if (this.adl != null) {
                this.adl.setCurrentItem(this.adg, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adk.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adk.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adg == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.adm != null) {
            this.adm.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adf.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adg;
    }

    public int getCurrentTabType() {
        if (this.adg < 0 || this.adg >= this.adk.size()) {
            return -1;
        }
        return this.adk.get(this.adg).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.adj.clearAnimation();
            this.adj.startAnimation(getLayerInAnimation());
            return;
        }
        this.adj.clearAnimation();
        this.adj.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(int i) {
        if (i > 0 && (this.adj.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.adj.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.ado.getLayoutParams().height = i;
                this.ado.requestLayout();
                this.adj.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.adj.clearAnimation();
        this.adj.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.adh != null) {
            return this.adh.adx;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adf;
    }

    public c cw(int i) {
        if (i < 0 || i >= this.adk.size()) {
            return null;
        }
        return this.adk.get(i);
    }

    public c cx(int i) {
        for (c cVar : this.adk) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adk.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adl.getId(), this.adn.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adk) {
            if (cVar.ady != null) {
                cVar.ady.cC();
            }
        }
        this.adk.clear();
        this.adh = null;
        this.adg = -1;
        this.adf.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.adq == null) {
            this.adq = AnimationUtils.loadAnimation(getContext(), w.a.fade_in);
            this.adq.setAnimationListener(this.adp);
        }
        return this.adq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.adr == null) {
            this.adr = AnimationUtils.loadAnimation(getContext(), w.a.fade_out);
            this.adr.setAnimationListener(this.adp);
        }
        return this.adr;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aq.cN(w.g.s_tabbar_bg));
        if (i == 2 && this.adi) {
            this.ado.setBackgroundDrawable(bitmapDrawable);
        } else {
            aq.k(this.ado, w.e.common_color_10274);
        }
        this.adf.onChangeSkinType(i);
        for (c cVar : this.adk) {
            cVar.adw.dl(i);
        }
        if (this.adn != null) {
            int count = this.adn.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adn.getItem(i2);
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
        this.adf.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adg = i;
        this.adh = this.adk.get(i);
        this.adf.g(this.adg, false);
        ViewGroup viewGroup = (ViewGroup) this.adh.adx.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adu;
        private List<c> adv;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adu = -1;
            this.adv = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adv.get(i).adx;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adv.get(i).adx.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adv.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adu != i) {
                if (this.adu != -1) {
                    ((BaseFragment) getItem(this.adu)).setPrimary(false);
                }
                this.adu = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adi = z;
    }
}
