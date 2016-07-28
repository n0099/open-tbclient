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
    private FragmentTabWidget VK;
    private int VL;
    private c VM;
    private boolean VN;
    private View VO;
    private final List<c> VP;
    private CustomViewPager VQ;
    private b VR;
    private a VS;
    private FrameLayout VT;
    private d VU;
    private Animation VV;
    private Animation VW;
    private FragmentTabWidget.c VX;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator Wb;
        public Fragment Wc;
        public com.baidu.tbadk.mainTab.b Wd;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.VN = true;
        this.VP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.VU = new com.baidu.tbadk.core.tabHost.a(this);
        this.VX = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VN = true;
        this.VP = new ArrayList();
        this.mOnPageChangeListener = null;
        this.VU = new com.baidu.tbadk.core.tabHost.a(this);
        this.VX = new com.baidu.tbadk.core.tabHost.b(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(u.h.fragment_tabhost, (ViewGroup) this, true);
        this.VT = (FrameLayout) findViewById(u.g.tabcontainer_wrapper);
        this.VO = findViewById(u.g.tabcontainer_layer);
        av.l(this.VO, u.d.common_color_10012);
        this.VL = -1;
        this.VM = null;
    }

    public void setFrameLayerClickListener(View.OnClickListener onClickListener) {
        if (this.VO != null) {
            this.VO.setOnClickListener(onClickListener);
        }
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.VK != null) {
            this.VK.getLayoutParams().height = i;
            this.VK.requestLayout();
            this.VT.getLayoutParams().height = i;
            this.VT.requestLayout();
        }
    }

    public FrameLayout getTabWrapper() {
        return this.VT;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.VK != null) {
            this.VK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.VK != null) {
            this.VK.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.VK != null) {
            this.VK.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.VK = (FragmentTabWidget) findViewById(u.g.tabcontainer);
        this.VK.setTabSelectionListener(this);
        this.VK.setOnSizeChangedListener(this.VX);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.VK.setPadding(i, i2, i3, i4);
    }

    public void ay(boolean z) {
        this.VK.ay(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.Wb == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.Wc == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.VP.contains(cVar)) {
            if (cVar.Wd != null) {
                cVar.Wd.Dj();
            }
            this.VK.addView(cVar.Wb, i);
            if (i == -1) {
                this.VP.add(cVar);
            } else {
                this.VP.add(i, cVar);
            }
            if (this.VL != -1 && i <= this.VL) {
                this.VL++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.VQ != null) {
            this.VQ.setScrollable(z);
        }
    }

    public void initViewPager() {
        ci(0);
    }

    public void ci(int i) {
        if (this.VQ != null) {
            removeView(this.VQ);
        }
        this.VQ = new CustomViewPager(this.mContext);
        this.VQ.setId(u.g.tab_content);
        cj(i);
        addView(this.VQ);
        removeView(this.VT);
        addView(this.VT);
        this.VQ.setOffscreenPageLimit(this.VP.size() - 1);
        this.VQ.setOnPageChangeListener(this);
        this.VS = new a(this.mFragmentManager, this.VP);
        this.VQ.setAdapter(this.VS);
    }

    public void sQ() {
        if (this.VQ != null) {
            removeView(this.VQ);
        }
        this.VQ = new CustomViewPager(this.mContext);
        this.VQ.setId(u.g.tab_content);
        addView(this.VQ);
        removeView(this.VT);
        addView(this.VT);
        this.VQ.setOffscreenPageLimit(this.VP.size() - 1);
        this.VQ.setOnPageChangeListener(this);
        this.VS = new a(this.mFragmentManager, this.VP);
        this.VQ.setAdapter(this.VS);
    }

    public void cj(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.VQ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.VQ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.VT.getLayoutParams();
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
        this.VQ.setLayoutParams(layoutParams);
        this.VT.setLayoutParams(layoutParams2);
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
        this.VR = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.VP.size() && i != this.VL) {
            this.VL = i;
            this.VM = this.VP.get(this.VL);
            this.VK.g(this.VL, true);
            if (this.VQ != null) {
                this.VQ.setCurrentItem(this.VL, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.VP.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.VP.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.VL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        if (this.VR != null) {
            this.VR.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.VK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.VL;
    }

    public int getCurrentTabType() {
        if (this.VL < 0 || this.VL >= this.VP.size()) {
            return -1;
        }
        return this.VP.get(this.VL).mType;
    }

    public void setWidgetLayerVisible(boolean z) {
        if (z) {
            this.VO.clearAnimation();
            this.VO.startAnimation(getLayerInAnimation());
            return;
        }
        this.VO.clearAnimation();
        this.VO.startAnimation(getLayerOutAnimation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(int i) {
        if (i > 0 && (this.VO.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.VO.getLayoutParams();
            if (layoutParams.height != i) {
                layoutParams.height = i;
                this.VT.getLayoutParams().height = i;
                this.VT.requestLayout();
                this.VO.setLayoutParams(layoutParams);
            }
        }
    }

    public void setWidgetLayerVisibleNoAnimation(boolean z) {
        this.VO.clearAnimation();
        this.VO.setVisibility(z ? 0 : 8);
    }

    public Fragment getCurrentFragment() {
        if (this.VM != null) {
            return this.VM.Wc;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.VK;
    }

    public c cl(int i) {
        if (i < 0 || i >= this.VP.size()) {
            return null;
        }
        return this.VP.get(i);
    }

    public c cm(int i) {
        for (c cVar : this.VP) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.VP.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.VQ.getId(), this.VS.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.VP) {
            if (cVar.Wd != null) {
                cVar.Wd.ay();
            }
        }
        this.VP.clear();
        this.VM = null;
        this.VL = -1;
        this.VK.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerInAnimation() {
        if (this.VV == null) {
            this.VV = AnimationUtils.loadAnimation(getContext(), u.a.fade_in);
            this.VV.setAnimationListener(this.VU);
        }
        return this.VV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getLayerOutAnimation() {
        if (this.VW == null) {
            this.VW = AnimationUtils.loadAnimation(getContext(), u.a.fade_out);
            this.VW.setAnimationListener(this.VU);
        }
        return this.VW;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(av.cC(u.f.s_tabbar_bg));
        if (i == 2 && this.VN) {
            this.VT.setBackgroundDrawable(bitmapDrawable);
        } else {
            av.l(this.VT, u.d.common_color_10274);
        }
        this.VK.onChangeSkinType(i);
        for (c cVar : this.VP) {
            cVar.Wb.cX(i);
        }
        if (this.VS != null) {
            int count = this.VS.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.VS.getItem(i2);
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
        this.VK.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.VL = i;
        this.VM = this.VP.get(i);
        this.VK.g(this.VL, false);
        ViewGroup viewGroup = (ViewGroup) this.VM.Wc.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int VZ;
        private List<c> Wa;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.VZ = -1;
            this.Wa = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.Wa.get(i).Wc;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.Wa.get(i).Wc.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.Wa.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.VZ != i) {
                if (this.VZ != -1) {
                    ((BaseFragment) getItem(this.VZ)).setPrimary(false);
                }
                this.VZ = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.VN = z;
    }
}
