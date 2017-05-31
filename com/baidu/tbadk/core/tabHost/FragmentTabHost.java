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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private FragmentTabWidget acH;
    private int acI;
    private c acJ;
    private boolean acK;
    private final List<c> acL;
    private CustomViewPager acM;
    private b acN;
    private a acO;
    private FrameLayout acP;
    private int acQ;
    private View acR;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator acU;
        public Fragment acV;
        public com.baidu.tbadk.mainTab.b acW;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.acK = true;
        this.acL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.acQ = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acK = true;
        this.acL = new ArrayList();
        this.mOnPageChangeListener = null;
        this.acQ = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.acP = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.acI = -1;
        this.acJ = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.acH != null) {
            this.acH.getLayoutParams().height = i;
            this.acH.requestLayout();
            this.acP.getLayoutParams().height = i;
            this.acP.requestLayout();
            this.acQ = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.acP;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.acH != null) {
            this.acH.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.acH != null) {
            this.acH.setShouldDrawTopLine(z);
        }
    }

    public void aA(boolean z) {
        if (this.acR == null) {
            this.acR = findViewById(w.h.topDvider);
        }
        if (!z) {
            this.acR.setVisibility(8);
            return;
        }
        if (this.acH != null) {
            this.acH.setShouldDrawTopLine(false);
        }
        int dip2px = this.acQ + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.acR.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.acR.setLayoutParams(layoutParams);
        this.acR.setVisibility(0);
        aq.k(this.acR, w.e.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.acH.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.acH = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.acH.setTabSelectionListener(this);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.acH.setPadding(i, i2, i3, i4);
    }

    public void aB(boolean z) {
        this.acH.aB(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.acU == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.acV == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.acL.contains(cVar)) {
            if (cVar.acW != null) {
                cVar.acW.Ea();
            }
            this.acH.addView(cVar.acU, i);
            if (i == -1) {
                this.acL.add(cVar);
            } else {
                this.acL.add(i, cVar);
            }
            if (this.acI != -1 && i <= this.acI) {
                this.acI++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.acM != null) {
            this.acM.setScrollable(z);
        }
    }

    public void initViewPager() {
        cv(0);
    }

    public void cv(int i) {
        if (this.acM != null) {
            removeView(this.acM);
        }
        this.acM = new CustomViewPager(this.mContext);
        this.acM.setId(w.h.tab_content);
        cw(i);
        addView(this.acM);
        removeView(this.acP);
        addView(this.acP);
        this.acM.setOffscreenPageLimit(this.acL.size() - 1);
        this.acM.setOnPageChangeListener(this);
        this.acO = new a(this.mFragmentManager, this.acL);
        this.acM.setAdapter(this.acO);
    }

    public void tW() {
        if (this.acM != null) {
            removeView(this.acM);
        }
        this.acM = new CustomViewPager(this.mContext);
        this.acM.setId(w.h.tab_content);
        addView(this.acM);
        removeView(this.acP);
        addView(this.acP);
        this.acM.setOffscreenPageLimit(this.acL.size() - 1);
        this.acM.setOnPageChangeListener(this);
        this.acO = new a(this.mFragmentManager, this.acL);
        this.acM.setAdapter(this.acO);
    }

    public void cw(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.acM.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.acM.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.acP.getLayoutParams();
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
        this.acM.setLayoutParams(layoutParams);
        this.acP.setLayoutParams(layoutParams2);
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
        this.acN = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acL.size() && i != this.acI) {
            this.acI = i;
            this.acJ = this.acL.get(this.acI);
            this.acH.g(this.acI, true);
            if (this.acM != null) {
                this.acM.setCurrentItem(this.acI, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.acL.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.acL.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.acI == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.acJ = this.acL.get(i);
        if (this.acJ.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_WRITE_THREAD));
            return;
        }
        if (this.acN != null) {
            this.acN.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.acH.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.acI;
    }

    public int getCurrentTabType() {
        if (this.acI < 0 || this.acI >= this.acL.size()) {
            return -1;
        }
        return this.acL.get(this.acI).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.acJ != null) {
            return this.acJ.acV;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.acH;
    }

    public c cx(int i) {
        if (i < 0 || i >= this.acL.size()) {
            return null;
        }
        return this.acL.get(i);
    }

    public c cy(int i) {
        for (c cVar : this.acL) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.acL.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.acM.getId(), this.acO.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.acL) {
            if (cVar.acW != null) {
                cVar.acW.cB();
            }
        }
        this.acL.clear();
        this.acJ = null;
        this.acI = -1;
        this.acH.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aq.cO(w.g.s_tabbar_bg));
        if (i == 2 && this.acK) {
            this.acP.setBackgroundDrawable(bitmapDrawable);
        } else {
            aq.k(this.acP, w.e.common_color_10274);
        }
        this.acH.onChangeSkinType(i);
        if (this.acR != null) {
            aq.k(this.acR, w.e.cp_bg_line_b);
        }
        for (c cVar : this.acL) {
            cVar.acU.dn(i);
        }
        if (this.acO != null) {
            int count = this.acO.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.acO.getItem(i2);
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
        this.acH.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.acI = i;
        this.acJ = this.acL.get(i);
        this.acH.g(this.acI, false);
        ViewGroup viewGroup = (ViewGroup) this.acJ.acV.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int acS;
        private List<c> acT;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.acS = -1;
            this.acT = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.acT.get(i).acV;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.acT.get(i).acV.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.acT.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.acS != i) {
                if (this.acS != -1) {
                    ((BaseFragment) getItem(this.acS)).setPrimary(false);
                }
                this.acS = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.acK = z;
    }
}
