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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget Vb;
    private int Vc;
    private c Vd;
    private boolean Ve;
    private View Vf;
    private final List<c> Vg;
    private CustomViewPager Vh;
    private b Vi;
    private a Vj;
    private FrameLayout Vk;
    private d Vl;
    private Animation Vm;
    private Animation Vn;
    private FragmentTabWidget.c Vo;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator Vs;
        public Fragment Vt;
        public com.baidu.tbadk.mainTab.b Vu;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.Ve = true;
        this.Vg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Vl = new com.baidu.tbadk.core.tabHost.a(this);
        this.Vo = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ve = true;
        this.Vg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.Vl = new com.baidu.tbadk.core.tabHost.a(this);
        this.Vo = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(u.h.fragment_tabhost, (ViewGroup) this, true);
        this.Vk = (FrameLayout) findViewById(u.g.tabcontainer_wrapper);
        this.Vf = findViewById(u.g.tabcontainer_layer);
        av.l(this.Vf, u.d.common_color_10012);
        this.Vc = -1;
        this.Vd = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.Vf != null) {
            this.Vf.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Vb != null) {
            this.Vb.getLayoutParams().height = i;
            this.Vb.requestLayout();
            this.Vk.getLayoutParams().height = i;
            this.Vk.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.Vk;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Vb != null) {
            this.Vb.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.Vb != null) {
            this.Vb.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Vb != null) {
            this.Vb.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Vb = (FragmentTabWidget) findViewById(u.g.tabcontainer);
        this.Vb.setTabSelectionListener(this);
        this.Vb.setOnSizeChangedListener(this.Vo);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.Vb.setPadding(i, i2, i3, i4);
    }

    public void av(boolean z) {
        this.Vb.av(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Vs == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.Vt == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Vg.contains(cVar)) {
            if (cVar.Vu != null) {
                cVar.Vu.Dk();
            }
            this.Vb.addView(cVar.Vs, i);
            if (i == -1) {
                this.Vg.add(cVar);
            } else {
                this.Vg.add(i, cVar);
            }
            if (this.Vc != -1 && i <= this.Vc) {
                this.Vc++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Vh != null) {
            this.Vh.setScrollable(z);
        }
    }

    public void initViewPager() {
        ci(0);
    }

    public void ci(int i) {
        if (this.Vh != null) {
            removeView(this.Vh);
        }
        this.Vh = new CustomViewPager(this.mContext);
        this.Vh.setId(u.g.tab_content);
        cj(i);
        addView(this.Vh);
        removeView(this.Vk);
        addView(this.Vk);
        this.Vh.setOffscreenPageLimit(this.Vg.size() - 1);
        this.Vh.setOnPageChangeListener(this);
        this.Vj = new a(this.mFragmentManager, this.Vg);
        this.Vh.setAdapter(this.Vj);
    }

    public void sR() {
        if (this.Vh != null) {
            removeView(this.Vh);
        }
        this.Vh = new CustomViewPager(this.mContext);
        this.Vh.setId(u.g.tab_content);
        addView(this.Vh);
        removeView(this.Vk);
        addView(this.Vk);
        this.Vh.setOffscreenPageLimit(this.Vg.size() - 1);
        this.Vh.setOnPageChangeListener(this);
        this.Vj = new a(this.mFragmentManager, this.Vg);
        this.Vh.setAdapter(this.Vj);
    }

    public void cj(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.Vh.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.Vh.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.Vk.getLayoutParams();
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
            layoutParams.addRule(3, u.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = k.c(this.mContext, u.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + k.c(this.mContext, u.e.ds98);
        }
        this.Vh.setLayoutParams(layoutParams);
        this.Vk.setLayoutParams(layoutParams2);
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
        this.Vi = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Vg.size() && i != this.Vc) {
            this.Vc = i;
            this.Vd = this.Vg.get(this.Vc);
            this.Vb.f(this.Vc, true);
            if (this.Vh != null) {
                this.Vh.setCurrentItem(this.Vc, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Vg.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Vg.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Vc == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        if (this.Vi != null) {
            this.Vi.e(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Vb.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Vc;
    }

    public int getCurrentTabType() {
        if (this.Vc < 0 || this.Vc >= this.Vg.size()) {
            return -1;
        }
        return this.Vg.get(this.Vc).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.Vf.clearAnimation();
            this.Vf.startAnimation(getLayerInAnimation());
            return;
        }
        this.Vf.clearAnimation();
        this.Vf.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(int i) {
        if (i > 0 && (this.Vf.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Vf.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.Vk.getLayoutParams().height = i;
                this.Vk.requestLayout();
                this.Vf.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.Vf.clearAnimation();
        this.Vf.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.Vd != null) {
            return this.Vd.Vt;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Vb;
    }

    public c cl(int i) {
        if (i < 0 || i >= this.Vg.size()) {
            return null;
        }
        return this.Vg.get(i);
    }

    public c cm(int i) {
        for (c cVar : this.Vg) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Vg.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Vh.getId(), this.Vj.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.Vg) {
            if (cVar.Vu != null) {
                cVar.Vu.ay();
            }
        }
        this.Vg.clear();
        this.Vd = null;
        this.Vc = -1;
        this.Vb.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.Vm == null) {
            this.Vm = AnimationUtils.loadAnimation(getContext(), u.a.fade_in);
            this.Vm.setAnimationListener(this.Vl);
        }
        return this.Vm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.Vn == null) {
            this.Vn = AnimationUtils.loadAnimation(getContext(), u.a.fade_out);
            this.Vn.setAnimationListener(this.Vl);
        }
        return this.Vn;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(av.cC(u.f.s_tabbar_bg));
        if (i == 2 && this.Ve) {
            this.Vk.setBackgroundDrawable(bitmapDrawable);
        } else {
            av.l(this.Vk, u.d.common_color_10274);
        }
        this.Vb.onChangeSkinType(i);
        for (c cVar : this.Vg) {
            cVar.Vs.cX(i);
        }
        if (this.Vj != null) {
            int count = this.Vj.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Vj.getItem(i2);
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
        this.Vb.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Vc = i;
        this.Vd = this.Vg.get(i);
        this.Vb.f(this.Vc, false);
        ViewGroup viewGroup = (ViewGroup) this.Vd.Vt.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int Vq;
        private List<c> Vr;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.Vq = -1;
            this.Vr = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Vr.get(i).Vt;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Vr.get(i).Vt.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Vr.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.Vq != i) {
                if (this.Vq != -1) {
                    ((BaseFragment) getItem(this.Vq)).setPrimary(false);
                }
                this.Vq = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.Ve = z;
    }
}
