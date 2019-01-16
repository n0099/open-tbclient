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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private FragmentTabWidget azN;
    private com.baidu.tbadk.core.tabHost.a azO;
    private b azP;
    private boolean azQ;
    private final List<b> azR;
    private CustomViewPager azS;
    private a azT;
    private FragmentAdapter azU;
    private LinearLayout azV;
    private int azW;
    private View azX;
    private int azY;
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
        public TbFragmentTabIndicator aAa;
        public Fragment aAb;
        public com.baidu.tbadk.mainTab.b aAc;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.azQ = true;
        this.azR = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azW = 0;
        this.azY = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azQ = true;
        this.azR = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azW = 0;
        this.azY = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.azV = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.azP = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.azN != null) {
            this.azN.getLayoutParams().height = i;
            this.azN.requestLayout();
            this.azV.getLayoutParams().height = i;
            this.azV.requestLayout();
            this.azW = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.azN != null) {
            this.azN.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.azN != null) {
            this.azN.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.azN != null) {
            this.azN.setShouldDrawTopLine(z);
        }
    }

    public void br(boolean z) {
        if (this.azX == null) {
            this.azX = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.azX.setVisibility(8);
            return;
        }
        if (this.azN != null) {
            this.azN.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azX.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.azX.setLayoutParams(layoutParams);
        this.azX.setVisibility(0);
        al.j(this.azX, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.azN.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.azN != null) {
            this.azN.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.azO == null) {
            this.azO = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        br(false);
        this.azO.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.azN = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.azN.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.azN.setPadding(i, i2, i3, i4);
    }

    public void bs(boolean z) {
        this.azN.bs(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.aAa == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.aAb == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.azR.contains(bVar)) {
            if (bVar.aAc != null) {
                bVar.aAc.Of();
            }
            this.azN.addView(bVar.aAa, i);
            if (i == -1) {
                this.azR.add(bVar);
            } else {
                this.azR.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.azS != null) {
            this.azS.setScrollable(z);
        }
    }

    public void initViewPager() {
        dw(0);
    }

    public void dw(int i) {
        if (this.azS != null) {
            removeView(this.azS);
        }
        this.azS = new CustomViewPager(this.mContext);
        this.azS.setId(e.g.tab_content);
        dx(i);
        addView(this.azS);
        removeView(this.azV);
        addView(this.azV);
        this.azS.setOffscreenPageLimit(this.azR.size() - 1);
        this.azS.setOnPageChangeListener(this);
        this.azU = new FragmentAdapter(this.mFragmentManager, this.azR);
        this.azS.setAdapter(this.azU);
    }

    public void CK() {
        if (this.azS != null) {
            removeView(this.azS);
        }
        this.azS = new CustomViewPager(this.mContext);
        this.azS.setId(e.g.tab_content);
        addView(this.azS);
        removeView(this.azV);
        addView(this.azV);
        this.azS.setOffscreenPageLimit(this.azR.size() - 1);
        this.azS.setOnPageChangeListener(this);
        this.azU = new FragmentAdapter(this.mFragmentManager, this.azR);
        this.azS.setAdapter(this.azU);
    }

    public void dx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.azS.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.azS.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.azV.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.azV.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.azV.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds98);
            this.azV.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0210e.ds88);
            this.azV.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.azV.setVisibility(8);
        }
        this.azS.setLayoutParams(layoutParams);
        this.azV.setLayoutParams(layoutParams2);
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
        this.azT = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.azR.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.azP = this.azR.get(this.mCurrentTabIndex);
            this.azN.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.azS != null) {
                this.azS.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.azR.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.azR.get(i3).mType) {
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
        this.azP = this.azR.get(i);
        if (this.azT == null || this.azT.onPreTabSelectionChange(i, z)) {
            if (this.azT != null) {
                this.azT.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.azN.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.azR.size()) {
            return -1;
        }
        return this.azR.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.azP != null) {
            return this.azP.aAb;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.azS;
    }

    public ViewGroup getTabWrapper() {
        return this.azV;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.azN;
    }

    public b dy(int i) {
        if (i < 0 || i >= this.azR.size()) {
            return null;
        }
        return this.azR.get(i);
    }

    public b dz(int i) {
        for (b bVar : this.azR) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.azS != null && this.azU != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.azR.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.azS.getId(), this.azU.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.azR) {
                if (bVar.aAc != null) {
                    bVar.aAc.gy();
                }
            }
            this.azR.clear();
            this.azP = null;
            this.mCurrentTabIndex = -1;
            this.azN.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.azQ) {
            this.azV.setBackgroundDrawable(new BitmapDrawable(al.dQ(e.f.s_tabbar_bg)));
        } else {
            al.j(this.azV, this.azY);
        }
        this.azN.onChangeSkinType(i);
        al.j(this.azX, e.d.cp_bg_line_b);
        for (b bVar : this.azR) {
            bVar.aAa.eD(i);
        }
        if (this.azU != null) {
            int count = this.azU.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.azU.getItem(i2);
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
        this.azN.d(i, f);
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
        this.azP = this.azR.get(i);
        this.azN.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.azP.aAb.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> azZ;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.azZ = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.azZ.get(i).aAb;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.azZ.get(i).aAb.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.azZ.size();
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
        this.azQ = z;
    }

    public void CL() {
        if (this.azV != null && this.azV.getVisibility() != 0) {
            this.azV.setVisibility(0);
        }
    }

    public void CM() {
        if (this.azV != null && this.azV.getVisibility() != 8) {
            this.azV.setVisibility(8);
        }
    }
}
