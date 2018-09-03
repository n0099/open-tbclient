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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget anB;
    private com.baidu.tbadk.core.tabHost.a anC;
    private b anD;
    private boolean anE;
    private final List<b> anF;
    private CustomViewPager anG;
    private a anH;
    private FragmentAdapter anI;
    private LinearLayout anJ;
    private int anK;
    private View anL;
    private int anM;
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
        public TbFragmentTabIndicator anO;
        public Fragment anP;
        public com.baidu.tbadk.mainTab.b anQ;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.anE = true;
        this.anF = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anK = 0;
        this.anM = f.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anE = true;
        this.anF = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anK = 0;
        this.anM = f.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(f.h.fragment_tabhost, (ViewGroup) this, true);
        this.anJ = (LinearLayout) findViewById(f.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.anD = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.anB != null) {
            this.anB.getLayoutParams().height = i;
            this.anB.requestLayout();
            this.anJ.getLayoutParams().height = i;
            this.anJ.requestLayout();
            this.anK = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.anB != null) {
            this.anB.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.anB != null) {
            this.anB.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.anB != null) {
            this.anB.setShouldDrawTopLine(z);
        }
    }

    public void aG(boolean z) {
        if (this.anL == null) {
            this.anL = findViewById(f.g.topDvider);
        }
        if (!z) {
            this.anL.setVisibility(8);
            return;
        }
        if (this.anB != null) {
            this.anB.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anL.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.anL.setLayoutParams(layoutParams);
        this.anL.setVisibility(0);
        am.j(this.anL, f.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.anB.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.anB != null) {
            this.anB.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.anC == null) {
            this.anC = new com.baidu.tbadk.core.tabHost.a(this, f.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aG(false);
        this.anC.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.anB = (FragmentTabWidget) findViewById(f.g.tabcontainer);
        this.anB.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.anB.setPadding(i, i2, i3, i4);
    }

    public void aH(boolean z) {
        this.anB.aH(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.anO == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.anP == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.anF.contains(bVar)) {
            if (bVar.anQ != null) {
                bVar.anQ.Jm();
            }
            this.anB.addView(bVar.anO, i);
            if (i == -1) {
                this.anF.add(bVar);
            } else {
                this.anF.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.anG != null) {
            this.anG.setScrollable(z);
        }
    }

    public void initViewPager() {
        cA(0);
    }

    public void cA(int i) {
        if (this.anG != null) {
            removeView(this.anG);
        }
        this.anG = new CustomViewPager(this.mContext);
        this.anG.setId(f.g.tab_content);
        cB(i);
        addView(this.anG);
        removeView(this.anJ);
        addView(this.anJ);
        this.anG.setOffscreenPageLimit(this.anF.size() - 1);
        this.anG.setOnPageChangeListener(this);
        this.anI = new FragmentAdapter(this.mFragmentManager, this.anF);
        this.anG.setAdapter(this.anI);
    }

    public void xX() {
        if (this.anG != null) {
            removeView(this.anG);
        }
        this.anG = new CustomViewPager(this.mContext);
        this.anG.setId(f.g.tab_content);
        addView(this.anG);
        removeView(this.anJ);
        addView(this.anJ);
        this.anG.setOffscreenPageLimit(this.anF.size() - 1);
        this.anG.setOnPageChangeListener(this);
        this.anI = new FragmentAdapter(this.mFragmentManager, this.anF);
        this.anG.setAdapter(this.anI);
    }

    public void cB(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.anG.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.anG.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.anJ.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.anJ.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, f.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.anJ.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.f(this.mContext, f.e.ds98);
            this.anJ.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.f(this.mContext, f.e.ds88);
            this.anJ.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.anJ.setVisibility(8);
        }
        this.anG.setLayoutParams(layoutParams);
        this.anJ.setLayoutParams(layoutParams2);
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
        this.anH = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.anF.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.anD = this.anF.get(this.mCurrentTabIndex);
            this.anB.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.anG != null) {
                this.anG.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.anF.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.anF.get(i3).mType) {
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
        this.anD = this.anF.get(i);
        if (this.anH == null || this.anH.onPreTabSelectionChange(i, z)) {
            if (this.anH != null) {
                this.anH.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.anB.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.anF.size()) {
            return -1;
        }
        return this.anF.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.anD != null) {
            return this.anD.anP;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.anG;
    }

    public ViewGroup getTabWrapper() {
        return this.anJ;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.anB;
    }

    public b cC(int i) {
        if (i < 0 || i >= this.anF.size()) {
            return null;
        }
        return this.anF.get(i);
    }

    public b cD(int i) {
        for (b bVar : this.anF) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.anG != null && this.anI != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.anF.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.anG.getId(), this.anI.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.anF) {
                if (bVar.anQ != null) {
                    bVar.anQ.eX();
                }
            }
            this.anF.clear();
            this.anD = null;
            this.mCurrentTabIndex = -1;
            this.anB.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.anE) {
            this.anJ.setBackgroundDrawable(new BitmapDrawable(am.cV(f.C0146f.s_tabbar_bg)));
        } else {
            am.j(this.anJ, this.anM);
        }
        this.anB.onChangeSkinType(i);
        am.j(this.anL, f.d.cp_bg_line_b);
        for (b bVar : this.anF) {
            bVar.anO.dF(i);
        }
        if (this.anI != null) {
            int count = this.anI.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.anI.getItem(i2);
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
        this.anB.d(i, f);
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
        this.anD = this.anF.get(i);
        this.anB.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.anD.anP.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> anN;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.anN = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.anN.get(i).anP;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.anN.get(i).anP.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.anN.size();
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
        this.anE = z;
    }

    public void xY() {
        if (this.anJ != null && this.anJ.getVisibility() != 0) {
            this.anJ.setVisibility(0);
        }
    }

    public void xZ() {
        if (this.anJ != null && this.anJ.getVisibility() != 8) {
            this.anJ.setVisibility(8);
        }
    }
}
