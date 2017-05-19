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
    private FragmentTabWidget acP;
    private int acQ;
    private c acR;
    private boolean acS;
    private final List<c> acT;
    private CustomViewPager acU;
    private b acV;
    private a acW;
    private FrameLayout acX;
    private int acY;
    private View acZ;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface b {
        void f(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FragmentTabIndicator adc;
        public Fragment ade;
        public com.baidu.tbadk.mainTab.b adf;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.acS = true;
        this.acT = new ArrayList();
        this.mOnPageChangeListener = null;
        this.acY = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acS = true;
        this.acT = new ArrayList();
        this.mOnPageChangeListener = null;
        this.acY = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.fragment_tabhost, (ViewGroup) this, true);
        this.acX = (FrameLayout) findViewById(w.h.tabcontainer_wrapper);
        this.acQ = -1;
        this.acR = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.acP != null) {
            this.acP.getLayoutParams().height = i;
            this.acP.requestLayout();
            this.acX.getLayoutParams().height = i;
            this.acX.requestLayout();
            this.acY = i;
        }
    }

    public FrameLayout getTabWrapper() {
        return this.acX;
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.acP != null) {
            this.acP.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.acP != null) {
            this.acP.setShouldDrawTopLine(z);
        }
    }

    public void aB(boolean z) {
        this.acZ = findViewById(w.h.topDvider);
        if (!z) {
            this.acZ.setVisibility(8);
            return;
        }
        if (this.acP != null) {
            this.acP.setShouldDrawTopLine(false);
        }
        int dip2px = this.acY + k.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.acZ.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.acZ.setLayoutParams(layoutParams);
        this.acZ.setVisibility(0);
        ((FrameLayout.LayoutParams) this.acP.getLayoutParams()).gravity = 80;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.acP = (FragmentTabWidget) findViewById(w.h.tabcontainer);
        this.acP.setTabSelectionListener(this);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.acP.setPadding(i, i2, i3, i4);
    }

    public void aC(boolean z) {
        this.acP.aC(z);
    }

    public void a(c cVar) {
        a(cVar, -1);
    }

    public void a(c cVar, int i) {
        if (cVar.adc == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (cVar.ade == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.acT.contains(cVar)) {
            if (cVar.adf != null) {
                cVar.adf.Eg();
            }
            this.acP.addView(cVar.adc, i);
            if (i == -1) {
                this.acT.add(cVar);
            } else {
                this.acT.add(i, cVar);
            }
            if (this.acQ != -1 && i <= this.acQ) {
                this.acQ++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.acU != null) {
            this.acU.setScrollable(z);
        }
    }

    public void initViewPager() {
        cu(0);
    }

    public void cu(int i) {
        if (this.acU != null) {
            removeView(this.acU);
        }
        this.acU = new CustomViewPager(this.mContext);
        this.acU.setId(w.h.tab_content);
        cv(i);
        addView(this.acU);
        removeView(this.acX);
        addView(this.acX);
        this.acU.setOffscreenPageLimit(this.acT.size() - 1);
        this.acU.setOnPageChangeListener(this);
        this.acW = new a(this.mFragmentManager, this.acT);
        this.acU.setAdapter(this.acW);
    }

    public void ua() {
        if (this.acU != null) {
            removeView(this.acU);
        }
        this.acU = new CustomViewPager(this.mContext);
        this.acU.setId(w.h.tab_content);
        addView(this.acU);
        removeView(this.acX);
        addView(this.acX);
        this.acU.setOffscreenPageLimit(this.acT.size() - 1);
        this.acU.setOnPageChangeListener(this);
        this.acW = new a(this.mFragmentManager, this.acT);
        this.acU.setAdapter(this.acW);
    }

    public void cv(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.acU.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.acU.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.acX.getLayoutParams();
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
        this.acU.setLayoutParams(layoutParams);
        this.acX.setLayoutParams(layoutParams2);
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
        this.acV = bVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.acT.size() && i != this.acQ) {
            this.acQ = i;
            this.acR = this.acT.get(this.acQ);
            this.acP.g(this.acQ, true);
            if (this.acU != null) {
                this.acU.setCurrentItem(this.acQ, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.acT.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.acT.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.acQ == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        this.acR = this.acT.get(i);
        if (this.acR.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_WRITE_THREAD));
            return;
        }
        if (this.acV != null) {
            this.acV.f(i, z);
        }
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.acP.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.acQ;
    }

    public int getCurrentTabType() {
        if (this.acQ < 0 || this.acQ >= this.acT.size()) {
            return -1;
        }
        return this.acT.get(this.acQ).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.acR != null) {
            return this.acR.ade;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.acP;
    }

    public c cw(int i) {
        if (i < 0 || i >= this.acT.size()) {
            return null;
        }
        return this.acT.get(i);
    }

    public c cx(int i) {
        for (c cVar : this.acT) {
            if (i == cVar.mType) {
                return cVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.acT.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.acU.getId(), this.acW.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (c cVar : this.acT) {
            if (cVar.adf != null) {
                cVar.adf.cB();
            }
        }
        this.acT.clear();
        this.acR = null;
        this.acQ = -1;
        this.acP.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aq.cN(w.g.s_tabbar_bg));
        if (i == 2 && this.acS) {
            this.acX.setBackgroundDrawable(bitmapDrawable);
        } else {
            aq.k(this.acX, w.e.common_color_10274);
        }
        this.acP.onChangeSkinType(i);
        if (this.acZ != null) {
            aq.k(this.acZ, w.e.cp_bg_line_b);
        }
        for (c cVar : this.acT) {
            cVar.adc.dm(i);
        }
        if (this.acW != null) {
            int count = this.acW.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.acW.getItem(i2);
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
        this.acP.b(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.acQ = i;
        this.acR = this.acT.get(i);
        this.acP.g(this.acQ, false);
        ViewGroup viewGroup = (ViewGroup) this.acR.ade.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FragmentPagerAdapter {
        private int ada;
        private List<c> adb;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.ada = -1;
            this.adb = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.adb.get(i).ade;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.adb.get(i).ade.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.adb.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.ada != i) {
                if (this.ada != -1) {
                    ((BaseFragment) getItem(this.ada)).setPrimary(false);
                }
                this.ada = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.acS = z;
    }
}
