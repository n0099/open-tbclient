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
    private CustomViewPager bQA;
    private a bQB;
    private FragmentAdapter bQC;
    private LinearLayout bQD;
    private int bQE;
    private View bQF;
    private View bQG;
    private int bQH;
    private FragmentTabWidget bQv;
    private com.baidu.tbadk.core.tabHost.a bQw;
    private b bQx;
    private boolean bQy;
    private final List<b> bQz;
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
        public TbFragmentTabIndicator bQJ;
        public Fragment bQK;
        public com.baidu.tbadk.mainTab.b bQL;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bQy = true;
        this.bQz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bQE = 0;
        this.bQH = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQy = true;
        this.bQz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bQE = 0;
        this.bQH = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.bQD = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.bQG = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bQx = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bQH = R.drawable.bottom_bar_background;
                am.k(this.bQD, this.bQH);
                setShouldDrawTopLine(false);
                ea(false);
            } else if (this.mType == 0) {
                this.bQH = R.drawable.white_bg;
                am.k(this.bQD, this.bQH);
                setShouldDrawTopLine(true);
                ea(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bQG.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bQv != null) {
            this.bQv.getLayoutParams().height = i;
            this.bQv.requestLayout();
            this.bQD.getLayoutParams().height = i;
            this.bQD.requestLayout();
            this.bQE = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bQv != null) {
            this.bQv.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bQv != null) {
            this.bQv.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bQv != null) {
            this.bQv.setShouldDrawTopLine(z);
        }
    }

    public void ea(boolean z) {
        if (this.bQF == null) {
            this.bQF = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.bQF.setVisibility(8);
            return;
        }
        if (this.bQv != null) {
            this.bQv.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bQF.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bQF.setLayoutParams(layoutParams);
        this.bQF.setVisibility(0);
        am.l(this.bQF, R.color.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bQv.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bQv != null) {
            this.bQv.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bQw == null) {
            this.bQw = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        ea(false);
        this.bQw.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bQv = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.bQv.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bQv.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bQJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bQK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bQz.contains(bVar)) {
            if (bVar.bQL != null) {
                bVar.bQL.atQ();
            }
            this.bQv.addView(bVar.bQJ, i);
            if (i == -1) {
                this.bQz.add(bVar);
            } else {
                this.bQz.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bQJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bQK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bQz.contains(bVar)) {
            if (bVar.bQL != null) {
                bVar.bQL.atQ();
            }
            this.bQv.addView(bVar.bQJ, i, z);
            if (i == -1) {
                this.bQz.add(bVar);
            } else {
                this.bQz.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bQA != null) {
            this.bQA.setScrollable(z);
        }
    }

    public void initViewPager() {
        hR(0);
    }

    public void hR(int i) {
        if (this.bQA != null) {
            removeView(this.bQA);
        }
        this.bQA = new CustomViewPager(this.mContext);
        this.bQA.setId(R.id.tab_content);
        hS(i);
        addView(this.bQA);
        removeView(this.bQD);
        addView(this.bQD);
        removeView(this.bQG);
        addView(this.bQG);
        this.bQA.setOffscreenPageLimit(this.bQz.size() - 1);
        this.bQA.setOnPageChangeListener(this);
        this.bQC = new FragmentAdapter(this.mFragmentManager, this.bQz);
        this.bQA.setAdapter(this.bQC);
    }

    public void ahQ() {
        if (this.bQA != null) {
            removeView(this.bQA);
        }
        this.bQA = new CustomViewPager(this.mContext);
        this.bQA.setId(R.id.tab_content);
        addView(this.bQA);
        removeView(this.bQD);
        addView(this.bQD);
        this.bQA.setOffscreenPageLimit(this.bQz.size() - 1);
        this.bQA.setOnPageChangeListener(this);
        this.bQC = new FragmentAdapter(this.mFragmentManager, this.bQz);
        this.bQA.setAdapter(this.bQC);
    }

    public void hS(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bQA.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bQA.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bQD.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bQD.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bQD.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bQD.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.mContext, R.dimen.ds88);
            this.bQD.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bQD.setVisibility(8);
        }
        this.bQA.setLayoutParams(layoutParams);
        this.bQD.setLayoutParams(layoutParams2);
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
        this.bQB = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bQz.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bQx = this.bQz.get(this.mCurrentTabIndex);
            this.bQv.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bQA != null) {
                this.bQA.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bQz.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bQz.get(i3).mType) {
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
        this.bQx = this.bQz.get(i);
        if (this.bQB == null || this.bQB.onPreTabSelectionChange(i, z)) {
            if (this.bQB != null) {
                this.bQB.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bQv.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bQz.size()) {
            return -1;
        }
        return this.bQz.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bQx != null) {
            return this.bQx.bQK;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bQA;
    }

    public ViewGroup getTabWrapper() {
        return this.bQD;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bQv;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bQv != null) {
            this.bQv.setAbsoluteWeight(z);
        }
    }

    public b hT(int i) {
        if (i < 0 || i >= this.bQz.size()) {
            return null;
        }
        return this.bQz.get(i);
    }

    public b hU(int i) {
        for (b bVar : this.bQz) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bQA != null && this.bQC != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bQz.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bQA.getId(), this.bQC.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bQz) {
                if (bVar.bQL != null) {
                    bVar.bQL.fv();
                }
            }
            this.bQz.clear();
            this.bQx = null;
            this.mCurrentTabIndex = -1;
            this.bQv.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bQy) {
            this.bQD.setBackgroundDrawable(new BitmapDrawable(am.il(R.drawable.s_tabbar_bg)));
        } else {
            am.k(this.bQD, this.bQH);
        }
        this.bQv.onChangeSkinType(i);
        am.l(this.bQF, R.color.cp_bg_line_b);
        for (b bVar : this.bQz) {
            bVar.bQJ.jc(i);
            bVar.bQJ.setSelected(bVar.bQJ.isSelected());
        }
        if (this.bQC != null) {
            int count = this.bQC.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bQC.getItem(i2);
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
        this.bQv.d(i, f);
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
        this.bQx = this.bQz.get(i);
        this.bQv.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bQx.bQK.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bQI;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bQI = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bQI.get(i).bQK;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bQI.get(i).bQK.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bQI.size();
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
        this.bQy = z;
    }

    public void ahR() {
        if (this.bQD != null && this.bQD.getVisibility() != 0) {
            this.bQD.setVisibility(0);
        }
    }

    public void ahS() {
        if (this.bQD != null && this.bQD.getVisibility() != 8) {
            this.bQD.setVisibility(8);
        }
    }
}
