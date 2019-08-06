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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget bQB;
    private com.baidu.tbadk.core.tabHost.a bQC;
    private b bQD;
    private boolean bQE;
    private final List<b> bQF;
    private CustomViewPager bQG;
    private a bQH;
    private FragmentAdapter bQI;
    private LinearLayout bQJ;
    private int bQK;
    private View bQL;
    private View bQM;
    private int bQN;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mType;

    /* loaded from: classes.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator bQP;
        public Fragment bQQ;
        public com.baidu.tbadk.mainTab.b bQR;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bQE = true;
        this.bQF = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bQK = 0;
        this.bQN = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQE = true;
        this.bQF = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bQK = 0;
        this.bQN = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.bQJ = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.bQM = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bQD = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bQN = R.drawable.bottom_bar_background;
                am.k(this.bQJ, this.bQN);
                setShouldDrawTopLine(false);
                ea(false);
            } else if (this.mType == 0) {
                this.bQN = R.drawable.white_bg;
                am.k(this.bQJ, this.bQN);
                setShouldDrawTopLine(true);
                ea(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bQM.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bQB != null) {
            this.bQB.getLayoutParams().height = i;
            this.bQB.requestLayout();
            this.bQJ.getLayoutParams().height = i;
            this.bQJ.requestLayout();
            this.bQK = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bQB != null) {
            this.bQB.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bQB != null) {
            this.bQB.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bQB != null) {
            this.bQB.setShouldDrawTopLine(z);
        }
    }

    public void ea(boolean z) {
        if (this.bQL == null) {
            this.bQL = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.bQL.setVisibility(8);
            return;
        }
        if (this.bQB != null) {
            this.bQB.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQL.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bQL.setLayoutParams(layoutParams);
        this.bQL.setVisibility(0);
        am.l(this.bQL, R.color.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bQB.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bQB != null) {
            this.bQB.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bQC == null) {
            this.bQC = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        ea(false);
        this.bQC.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bQB = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.bQB.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bQB.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bQP == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bQQ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bQF.contains(bVar)) {
            if (bVar.bQR != null) {
                bVar.bQR.atS();
            }
            this.bQB.addView(bVar.bQP, i);
            if (i == -1) {
                this.bQF.add(bVar);
            } else {
                this.bQF.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bQP == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bQQ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bQF.contains(bVar)) {
            if (bVar.bQR != null) {
                bVar.bQR.atS();
            }
            this.bQB.addView(bVar.bQP, i, z);
            if (i == -1) {
                this.bQF.add(bVar);
            } else {
                this.bQF.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bQG != null) {
            this.bQG.setScrollable(z);
        }
    }

    public void initViewPager() {
        hR(0);
    }

    public void hR(int i) {
        if (this.bQG != null) {
            removeView(this.bQG);
        }
        this.bQG = new CustomViewPager(this.mContext);
        this.bQG.setId(R.id.tab_content);
        hS(i);
        addView(this.bQG);
        removeView(this.bQJ);
        addView(this.bQJ);
        removeView(this.bQM);
        addView(this.bQM);
        this.bQG.setOffscreenPageLimit(this.bQF.size() - 1);
        this.bQG.setOnPageChangeListener(this);
        this.bQI = new FragmentAdapter(this.mFragmentManager, this.bQF);
        this.bQG.setAdapter(this.bQI);
    }

    public void ahS() {
        if (this.bQG != null) {
            removeView(this.bQG);
        }
        this.bQG = new CustomViewPager(this.mContext);
        this.bQG.setId(R.id.tab_content);
        addView(this.bQG);
        removeView(this.bQJ);
        addView(this.bQJ);
        this.bQG.setOffscreenPageLimit(this.bQF.size() - 1);
        this.bQG.setOnPageChangeListener(this);
        this.bQI = new FragmentAdapter(this.mFragmentManager, this.bQF);
        this.bQG.setAdapter(this.bQI);
    }

    public void hS(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bQG.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bQG.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bQJ.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bQJ.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bQJ.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bQJ.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.mContext, R.dimen.ds88);
            this.bQJ.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bQJ.setVisibility(8);
        }
        this.bQG.setLayoutParams(layoutParams);
        this.bQJ.setLayoutParams(layoutParams2);
    }

    private void h(int[] iArr) {
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
        this.bQH = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bQF.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bQD = this.bQF.get(this.mCurrentTabIndex);
            this.bQB.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bQG != null) {
                this.bQG.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bQF.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bQF.get(i3).mType) {
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
        this.bQD = this.bQF.get(i);
        if (this.bQH == null || this.bQH.onPreTabSelectionChange(i, z)) {
            if (this.bQH != null) {
                this.bQH.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bQB.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bQF.size()) {
            return -1;
        }
        return this.bQF.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bQD != null) {
            return this.bQD.bQQ;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bQG;
    }

    public ViewGroup getTabWrapper() {
        return this.bQJ;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bQB;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bQB != null) {
            this.bQB.setAbsoluteWeight(z);
        }
    }

    public b hT(int i) {
        if (i < 0 || i >= this.bQF.size()) {
            return null;
        }
        return this.bQF.get(i);
    }

    public b hU(int i) {
        for (b bVar : this.bQF) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bQG != null && this.bQI != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bQF.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bQG.getId(), this.bQI.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bQF) {
                if (bVar.bQR != null) {
                    bVar.bQR.fv();
                }
            }
            this.bQF.clear();
            this.bQD = null;
            this.mCurrentTabIndex = -1;
            this.bQB.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bQE) {
            this.bQJ.setBackgroundDrawable(new BitmapDrawable(am.il(R.drawable.s_tabbar_bg)));
        } else {
            am.k(this.bQJ, this.bQN);
        }
        this.bQB.onChangeSkinType(i);
        am.l(this.bQL, R.color.cp_bg_line_b);
        for (b bVar : this.bQF) {
            bVar.bQP.jd(i);
            bVar.bQP.setSelected(bVar.bQP.isSelected());
        }
        if (this.bQI != null) {
            int count = this.bQI.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bQI.getItem(i2);
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
        this.bQB.d(i, f);
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
        this.bQD = this.bQF.get(i);
        this.bQB.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bQD.bQQ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bQO;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bQO = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bQO.get(i).bQQ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bQO.get(i).bQQ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bQO.size();
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
        this.bQE = z;
    }

    public void ahT() {
        if (this.bQJ != null && this.bQJ.getVisibility() != 0) {
            this.bQJ.setVisibility(0);
        }
    }

    public void ahU() {
        if (this.bQJ != null && this.bQJ.getVisibility() != 8) {
            this.bQJ.setVisibility(8);
        }
    }
}
