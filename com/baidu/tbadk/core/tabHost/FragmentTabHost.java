package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget adE;
    private int adF;
    private c adG;
    private boolean adH;
    private final List<c> adI;
    private CustomViewPager adJ;
    private b adK;
    private a adL;
    private FrameLayout adM;
    private int adN;
    private View adO;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void e(int i, boolean z);

        boolean f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public e adR;
        public Fragment adS;
        public com.baidu.tbadk.mainTab.b adT;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.adH = true;
        this.adI = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adN = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adH = true;
        this.adI = new ArrayList();
        this.mOnPageChangeListener = null;
        this.adN = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.fragment_tabhost, (ViewGroup) this, true);
        this.adM = (FrameLayout) findViewById(d.h.tabcontainer_wrapper);
        this.adF = -1;
        this.adG = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.adE != null) {
            this.adE.getLayoutParams().height = i;
            this.adE.requestLayout();
            this.adM.getLayoutParams().height = i;
            this.adM.requestLayout();
            this.adN = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.adM;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.adE != null) {
            this.adE.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.adE != null) {
            this.adE.setShouldDrawTopLine(z);
        }
    }

    public void az(boolean z) {
        if (this.adO == null) {
            this.adO = findViewById(d.h.topDvider);
        }
        if (!z) {
            this.adO.setVisibility(8);
            return;
        }
        if (this.adE != null) {
            this.adE.setShouldDrawTopLine(false);
        }
        int dip2px = this.adN + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.adO.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.adO.setLayoutParams(layoutParams);
        this.adO.setVisibility(0);
        aj.k(this.adO, d.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.adE.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.adE = (FragmentTabWidget) findViewById(d.h.tabcontainer);
        this.adE.setTabSelectionListener(this);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.adE.setPadding(i, i2, i3, i4);
    }

    public void aA(boolean z) {
        this.adE.aA(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adR == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.adS == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.adI.contains(cVar)) {
            if (cVar.adT != null) {
                cVar.adT.Es();
            }
            this.adE.addView(cVar.adR, i);
            if (i == -1) {
                this.adI.add(cVar);
            } else {
                this.adI.add(i, cVar);
            }
            if (this.adF != -1 && i <= this.adF) {
                this.adF++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.adJ != null) {
            this.adJ.setScrollable(z);
        }
    }

    public void initViewPager() {
        cy(0);
    }

    public void cy(int i) {
        if (this.adJ != null) {
            removeView(this.adJ);
        }
        this.adJ = new CustomViewPager(this.mContext);
        this.adJ.setId(d.h.tab_content);
        cz(i);
        addView(this.adJ);
        removeView(this.adM);
        addView(this.adM);
        this.adJ.setOffscreenPageLimit(this.adI.size() - 1);
        this.adJ.setOnPageChangeListener(this);
        this.adL = new a(this.mFragmentManager, this.adI);
        this.adJ.setAdapter(this.adL);
    }

    public void tV() {
        if (this.adJ != null) {
            removeView(this.adJ);
        }
        this.adJ = new CustomViewPager(this.mContext);
        this.adJ.setId(d.h.tab_content);
        addView(this.adJ);
        removeView(this.adM);
        addView(this.adM);
        this.adJ.setOffscreenPageLimit(this.adI.size() - 1);
        this.adJ.setOnPageChangeListener(this);
        this.adL = new a(this.mFragmentManager, this.adI);
        this.adJ.setAdapter(this.adL);
    }

    public void cz(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.adJ.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.adJ.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.adM.getLayoutParams();
            layoutParams2.height = -2;
        }
        f(layoutParams.getRules());
        f(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.h.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.f(this.mContext, d.f.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.f(this.mContext, d.f.ds98);
        }
        this.adJ.setLayoutParams(layoutParams);
        this.adM.setLayoutParams(layoutParams2);
    }

    private void f(int[] iArr) {
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
        this.adK = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.adI.size() && i != this.adF) {
            this.adF = i;
            this.adG = this.adI.get(this.adF);
            this.adE.a(this.adF, true, false);
            if (this.adJ != null) {
                this.adJ.setCurrentItem(this.adF, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.adI.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.adI.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.adF == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        this.adG = this.adI.get(i);
        if (this.adK == null || this.adK.f(i, z)) {
            if (this.adK != null) {
                this.adK.e(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.adE.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.adF;
    }

    public int getCurrentTabType() {
        if (this.adF < 0 || this.adF >= this.adI.size()) {
            return -1;
        }
        return this.adI.get(this.adF).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.adG != null) {
            return this.adG.adS;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.adE;
    }

    public c cA(int i) {
        if (i < 0 || i >= this.adI.size()) {
            return null;
        }
        return this.adI.get(i);
    }

    public c cB(int i) {
        for (c cVar : this.adI) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.adI.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.adJ.getId(), this.adL.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.adI) {
            if (cVar.adT != null) {
                cVar.adT.cB();
            }
        }
        this.adI.clear();
        this.adG = null;
        this.adF = -1;
        this.adE.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aj.cS(d.g.s_tabbar_bg));
        if (i == 2 && this.adH) {
            this.adM.setBackgroundDrawable(bitmapDrawable);
        } else {
            aj.k(this.adM, d.e.cp_bg_line_d);
        }
        this.adE.onChangeSkinType(i);
        if (this.adO != null) {
            aj.k(this.adO, d.e.cp_bg_line_b);
        }
        for (c cVar : this.adI) {
            cVar.adR.dD(i);
        }
        if (this.adL != null) {
            int count = this.adL.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.adL.getItem(i2);
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
        this.adE.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.adF = i;
        this.adG = this.adI.get(i);
        this.adE.a(this.adF, false, true);
        ViewGroup viewGroup = (ViewGroup) this.adG.adS.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int adP;
        private List<c> adQ;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.adP = -1;
            this.adQ = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adQ.get(i).adS;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adQ.get(i).adS.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adQ.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.adP != i) {
                if (this.adP != -1) {
                    ((BaseFragment) getItem(this.adP)).setPrimary(false);
                }
                this.adP = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.adH = z;
    }
}
