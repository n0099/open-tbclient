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
    private FragmentTabWidget bRc;
    private com.baidu.tbadk.core.tabHost.a bRd;
    private b bRe;
    private boolean bRf;
    private final List<b> bRg;
    private CustomViewPager bRh;
    private a bRi;
    private FragmentAdapter bRj;
    private LinearLayout bRk;
    private int bRl;
    private View bRm;
    private View bRn;
    private int bRo;
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
        public TbFragmentTabIndicator bRq;
        public Fragment bRr;
        public com.baidu.tbadk.mainTab.b bRs;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bRf = true;
        this.bRg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bRl = 0;
        this.bRo = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRf = true;
        this.bRg = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bRl = 0;
        this.bRo = R.color.cp_bg_line_h;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.bRk = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.bRn = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bRe = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bRo = R.drawable.bottom_bar_background;
                am.k(this.bRk, this.bRo);
                setShouldDrawTopLine(false);
                ea(false);
            } else if (this.mType == 0) {
                this.bRo = R.color.cp_bg_line_h;
                am.k(this.bRk, this.bRo);
                setShouldDrawTopLine(true);
                ea(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bRn.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bRc != null) {
            this.bRc.getLayoutParams().height = i;
            this.bRc.requestLayout();
            this.bRk.getLayoutParams().height = i;
            this.bRk.requestLayout();
            this.bRl = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bRc != null) {
            this.bRc.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bRc != null) {
            this.bRc.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bRc != null) {
            this.bRc.setShouldDrawTopLine(z);
        }
    }

    public void ea(boolean z) {
        if (this.bRm == null) {
            this.bRm = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.bRm.setVisibility(8);
            return;
        }
        if (this.bRc != null) {
            this.bRc.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bRm.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bRm.setLayoutParams(layoutParams);
        this.bRm.setVisibility(0);
        am.l(this.bRm, R.color.cp_bg_line_c);
        ((LinearLayout.LayoutParams) this.bRc.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bRc != null) {
            this.bRc.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bRd == null) {
            this.bRd = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        ea(false);
        this.bRd.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bRc = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.bRc.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bRc.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bRq == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bRr == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bRg.contains(bVar)) {
            if (bVar.bRs != null) {
                bVar.bRs.aue();
            }
            this.bRc.addView(bVar.bRq, i);
            if (i == -1) {
                this.bRg.add(bVar);
            } else {
                this.bRg.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bRq == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bRr == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bRg.contains(bVar)) {
            if (bVar.bRs != null) {
                bVar.bRs.aue();
            }
            this.bRc.addView(bVar.bRq, i, z);
            if (i == -1) {
                this.bRg.add(bVar);
            } else {
                this.bRg.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bRh != null) {
            this.bRh.setScrollable(z);
        }
    }

    public void initViewPager() {
        hR(0);
    }

    public void hR(int i) {
        if (this.bRh != null) {
            removeView(this.bRh);
        }
        this.bRh = new CustomViewPager(this.mContext);
        this.bRh.setId(R.id.tab_content);
        hS(i);
        addView(this.bRh);
        removeView(this.bRk);
        addView(this.bRk);
        removeView(this.bRn);
        addView(this.bRn);
        this.bRh.setOffscreenPageLimit(this.bRg.size() - 1);
        this.bRh.setOnPageChangeListener(this);
        this.bRj = new FragmentAdapter(this.mFragmentManager, this.bRg);
        this.bRh.setAdapter(this.bRj);
    }

    public void ahW() {
        if (this.bRh != null) {
            removeView(this.bRh);
        }
        this.bRh = new CustomViewPager(this.mContext);
        this.bRh.setId(R.id.tab_content);
        addView(this.bRh);
        removeView(this.bRk);
        addView(this.bRk);
        this.bRh.setOffscreenPageLimit(this.bRg.size() - 1);
        this.bRh.setOnPageChangeListener(this);
        this.bRj = new FragmentAdapter(this.mFragmentManager, this.bRg);
        this.bRh.setAdapter(this.bRj);
    }

    public void hS(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bRh.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bRh.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bRk.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bRk.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bRk.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bRk.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.mContext, R.dimen.ds88);
            this.bRk.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bRk.setVisibility(8);
        }
        this.bRh.setLayoutParams(layoutParams);
        this.bRk.setLayoutParams(layoutParams2);
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
        this.bRi = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bRg.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bRe = this.bRg.get(this.mCurrentTabIndex);
            this.bRc.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bRh != null) {
                this.bRh.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bRg.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bRg.get(i3).mType) {
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
        this.bRe = this.bRg.get(i);
        if (this.bRi == null || this.bRi.onPreTabSelectionChange(i, z)) {
            if (this.bRi != null) {
                this.bRi.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bRc.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bRg.size()) {
            return -1;
        }
        return this.bRg.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bRe != null) {
            return this.bRe.bRr;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bRh;
    }

    public ViewGroup getTabWrapper() {
        return this.bRk;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bRc;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bRc != null) {
            this.bRc.setAbsoluteWeight(z);
        }
    }

    public b hT(int i) {
        if (i < 0 || i >= this.bRg.size()) {
            return null;
        }
        return this.bRg.get(i);
    }

    public b hU(int i) {
        for (b bVar : this.bRg) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bRh != null && this.bRj != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bRg.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bRh.getId(), this.bRj.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bRg) {
                if (bVar.bRs != null) {
                    bVar.bRs.fv();
                }
            }
            this.bRg.clear();
            this.bRe = null;
            this.mCurrentTabIndex = -1;
            this.bRc.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bRf) {
            this.bRk.setBackgroundDrawable(new BitmapDrawable(am.il(R.drawable.s_tabbar_bg)));
        } else {
            am.k(this.bRk, this.bRo);
        }
        this.bRc.onChangeSkinType(i);
        am.l(this.bRm, R.color.cp_bg_line_c);
        for (b bVar : this.bRg) {
            bVar.bRq.jg(i);
            bVar.bRq.setSelected(bVar.bRq.isSelected());
        }
        if (this.bRj != null) {
            int count = this.bRj.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bRj.getItem(i2);
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
        this.bRc.d(i, f);
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
        this.bRe = this.bRg.get(i);
        this.bRc.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bRe.bRr.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bRp;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bRp = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bRp.get(i).bRr;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bRp.get(i).bRr.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bRp.size();
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
        this.bRf = z;
    }

    public void ahX() {
        if (this.bRk != null && this.bRk.getVisibility() != 0) {
            this.bRk.setVisibility(0);
        }
    }

    public void ahY() {
        if (this.bRk != null && this.bRk.getVisibility() != 8) {
            this.bRk.setVisibility(8);
        }
    }
}
