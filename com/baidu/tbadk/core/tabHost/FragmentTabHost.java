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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget aah;
    private int aai;
    private c aaj;
    private View aak;
    private final List<c> aal;
    private CustomViewPager aam;
    private b aan;
    private a aao;
    private FrameLayout aap;
    private d aaq;
    private Animation aar;
    private Animation aas;
    private FragmentTabWidget.c aat;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void c(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator aax;
        public Fragment aay;
        public com.baidu.tbadk.mainTab.b aaz;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.aal = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aaq = new com.baidu.tbadk.core.tabHost.a(this);
        this.aat = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aal = new ArrayList();
        this.mOnPageChangeListener = null;
        this.aaq = new com.baidu.tbadk.core.tabHost.a(this);
        this.aat = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(t.h.fragment_tabhost, (ViewGroup) this, true);
        this.aap = (FrameLayout) findViewById(t.g.tabcontainer_wrapper);
        this.aak = findViewById(t.g.tabcontainer_layer);
        ar.l(this.aak, t.d.black_alpha50);
        this.aai = -1;
        this.aaj = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.aak != null) {
            this.aak.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.aah != null) {
            this.aah.getLayoutParams().height = i;
            this.aah.requestLayout();
            this.aap.getLayoutParams().height = i;
            this.aap.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.aap;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.aah != null) {
            this.aah.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.aah != null) {
            this.aah.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.aah = (FragmentTabWidget) findViewById(t.g.tabcontainer);
        this.aah.setTabSelectionListener(this);
        this.aah.setOnSizeChangedListener(this.aat);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.aah.setPadding(i, i2, i3, i4);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.aax == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.aay == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.aal.contains(cVar)) {
            if (cVar.aaz != null) {
                cVar.aaz.Ew();
            }
            this.aah.addView(cVar.aax, i);
            if (i == -1) {
                this.aal.add(cVar);
            } else {
                this.aal.add(i, cVar);
            }
            if (this.aai != -1 && i <= this.aai) {
                this.aai++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.aam != null) {
            this.aam.setScrollable(z);
        }
    }

    public void initViewPager() {
        cu(0);
    }

    public void cu(int i) {
        if (this.aam != null) {
            removeView(this.aam);
        }
        this.aam = new CustomViewPager(this.mContext);
        this.aam.setId(t.g.tab_content);
        cv(i);
        addView(this.aam);
        removeView(this.aap);
        addView(this.aap);
        this.aam.setOffscreenPageLimit(this.aal.size() - 1);
        this.aam.setOnPageChangeListener(this);
        this.aao = new a(this.mFragmentManager, this.aal);
        this.aam.setAdapter(this.aao);
    }

    public void cv(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.aam.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.aam.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.aap.getLayoutParams();
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
        this.aam.setLayoutParams(layoutParams);
        this.aap.setLayoutParams(layoutParams2);
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
        this.aan = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.aal.size() && i != this.aai) {
            this.aai = i;
            this.aaj = this.aal.get(this.aai);
            this.aah.d(this.aai, true);
            if (this.aam != null) {
                this.aam.setCurrentItem(this.aai, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.aal.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.aal.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.aai == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        if (this.aan != null) {
            this.aan.c(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.aah.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.aai;
    }

    public int getCurrentTabType() {
        if (this.aai < 0 || this.aai >= this.aal.size()) {
            return -1;
        }
        return this.aal.get(this.aai).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.aak.clearAnimation();
            this.aak.startAnimation(getLayerInAnimation());
            return;
        }
        this.aak.clearAnimation();
        this.aak.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i) {
        if (i > 0 && (this.aak.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aak.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.aap.getLayoutParams().height = i;
                this.aap.requestLayout();
                this.aak.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.aak.clearAnimation();
        this.aak.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.aaj != null) {
            return this.aaj.aay;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.aah;
    }

    public c cz(int i) {
        if (i < 0 || i >= this.aal.size()) {
            return null;
        }
        return this.aal.get(i);
    }

    public c cA(int i) {
        for (c cVar : this.aal) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.aal.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.aam.getId(), this.aao.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.aal) {
            if (cVar.aaz != null) {
                cVar.aaz.ei();
            }
        }
        this.aal.clear();
        this.aaj = null;
        this.aai = -1;
        this.aah.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.aar == null) {
            this.aar = AnimationUtils.loadAnimation(getContext(), t.a.fade_in);
            this.aar.setAnimationListener(this.aaq);
        }
        return this.aar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.aas == null) {
            this.aas = AnimationUtils.loadAnimation(getContext(), t.a.fade_out);
            this.aas.setAnimationListener(this.aaq);
        }
        return this.aas;
    }

    public void onChangeSkinType(int i) {
        this.aah.onChangeSkinType(i);
        for (c cVar : this.aal) {
            cVar.aax.dk(i);
        }
        if (this.aao != null) {
            int count = this.aao.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.aao.getItem(i2);
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
        this.aah.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.aai = i;
        this.aaj = this.aal.get(i);
        this.aah.d(this.aai, false);
        ViewGroup viewGroup = (ViewGroup) this.aaj.aay.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int aav;
        private List<c> aaw;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.aav = -1;
            this.aaw = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aaw.get(i).aay;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aaw.get(i).aay.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aaw.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.aav != i) {
                if (this.aav != -1) {
                    ((BaseFragment) getItem(this.aav)).setPrimary(false);
                }
                this.aav = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }
}
