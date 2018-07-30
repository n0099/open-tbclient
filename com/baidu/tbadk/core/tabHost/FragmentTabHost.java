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
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget anA;
    private com.baidu.tbadk.core.tabHost.a anB;
    private b anC;
    private boolean anD;
    private final List<b> anE;
    private CustomViewPager anF;
    private a anG;
    private FragmentAdapter anH;
    private LinearLayout anI;
    private int anJ;
    private View anK;
    private int anL;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator anN;
        public Fragment anO;
        public com.baidu.tbadk.mainTab.b anP;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.anD = true;
        this.anE = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anJ = 0;
        this.anL = d.C0140d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anD = true;
        this.anE = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anJ = 0;
        this.anL = d.C0140d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.fragment_tabhost, (ViewGroup) this, true);
        this.anI = (LinearLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.anC = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.anA != null) {
            this.anA.getLayoutParams().height = i;
            this.anA.requestLayout();
            this.anI.getLayoutParams().height = i;
            this.anI.requestLayout();
            this.anJ = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.anA != null) {
            this.anA.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.anA != null) {
            this.anA.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.anA != null) {
            this.anA.setShouldDrawTopLine(z);
        }
    }

    public void aF(boolean z) {
        if (this.anK == null) {
            this.anK = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.anK.setVisibility(8);
            return;
        }
        if (this.anA != null) {
            this.anA.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anK.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.anK.setLayoutParams(layoutParams);
        this.anK.setVisibility(0);
        am.j(this.anK, d.C0140d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.anA.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.anA != null) {
            this.anA.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.anB == null) {
            this.anB = new com.baidu.tbadk.core.tabHost.a(this, d.C0140d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aF(false);
        this.anB.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.anA = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.anA.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.anA.setPadding(i, i2, i3, i4);
    }

    public void aG(boolean z) {
        this.anA.aG(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.anN == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.anO == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.anE.contains(bVar)) {
            if (bVar.anP != null) {
                bVar.anP.Jm();
            }
            this.anA.addView(bVar.anN, i);
            if (i == -1) {
                this.anE.add(bVar);
            } else {
                this.anE.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.anF != null) {
            this.anF.setScrollable(z);
        }
    }

    public void initViewPager() {
        cA(0);
    }

    public void cA(int i) {
        if (this.anF != null) {
            removeView(this.anF);
        }
        this.anF = new CustomViewPager(this.mContext);
        this.anF.setId(d.g.tab_content);
        cB(i);
        addView(this.anF);
        removeView(this.anI);
        addView(this.anI);
        this.anF.setOffscreenPageLimit(this.anE.size() - 1);
        this.anF.setOnPageChangeListener(this);
        this.anH = new FragmentAdapter(this.mFragmentManager, this.anE);
        this.anF.setAdapter(this.anH);
    }

    public void xY() {
        if (this.anF != null) {
            removeView(this.anF);
        }
        this.anF = new CustomViewPager(this.mContext);
        this.anF.setId(d.g.tab_content);
        addView(this.anF);
        removeView(this.anI);
        addView(this.anI);
        this.anF.setOffscreenPageLimit(this.anE.size() - 1);
        this.anF.setOnPageChangeListener(this);
        this.anH = new FragmentAdapter(this.mFragmentManager, this.anE);
        this.anF.setAdapter(this.anH);
    }

    public void cB(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.anF.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.anF.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.anI.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.anI.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.anI.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds98);
            this.anI.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.f(this.mContext, d.e.ds88);
            this.anI.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.anI.setVisibility(8);
        }
        this.anF.setLayoutParams(layoutParams);
        this.anI.setLayoutParams(layoutParams2);
    }

    private void g(int[] iArr) {
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

    public void setOnTabSelectionListener(a aVar) {
        this.anG = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.anE.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.anC = this.anE.get(this.mCurrentTabIndex);
            this.anA.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.anF != null) {
                this.anF.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.anE.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.anE.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.mCurrentTabIndex == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void onTabSelectionChanged(int i, boolean z) {
        this.anC = this.anE.get(i);
        if (this.anG == null || this.anG.onPreTabSelectionChange(i, z)) {
            if (this.anG != null) {
                this.anG.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.anA.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.anE.size()) {
            return -1;
        }
        return this.anE.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.anC != null) {
            return this.anC.anO;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.anF;
    }

    public ViewGroup getTabWrapper() {
        return this.anI;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.anA;
    }

    public b cC(int i) {
        if (i < 0 || i >= this.anE.size()) {
            return null;
        }
        return this.anE.get(i);
    }

    public b cD(int i) {
        for (b bVar : this.anE) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.anF != null && this.anH != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.anE.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.anF.getId(), this.anH.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.anE) {
                if (bVar.anP != null) {
                    bVar.anP.eX();
                }
            }
            this.anE.clear();
            this.anC = null;
            this.mCurrentTabIndex = -1;
            this.anA.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.anD) {
            this.anI.setBackgroundDrawable(new BitmapDrawable(am.cV(d.f.s_tabbar_bg)));
        } else {
            am.j(this.anI, this.anL);
        }
        this.anA.onChangeSkinType(i);
        am.j(this.anK, d.C0140d.cp_bg_line_b);
        for (b bVar : this.anE) {
            bVar.anN.dG(i);
        }
        if (this.anH != null) {
            int count = this.anH.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.anH.getItem(i2);
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
        this.anA.d(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.mCurrentTabIndex = i;
        this.anC = this.anE.get(i);
        this.anA.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.anC.anO.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> anM;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.anM = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.anM.get(i).anO;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.anM.get(i).anO.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.anM.size();
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

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            try {
                super.finishUpdate(viewGroup);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
        this.anD = z;
    }

    public void xZ() {
        if (this.anI != null && this.anI.getVisibility() != 0) {
            this.anI.setVisibility(0);
        }
    }

    public void ya() {
        if (this.anI != null && this.anI.getVisibility() != 8) {
            this.anI.setVisibility(8);
        }
    }
}
