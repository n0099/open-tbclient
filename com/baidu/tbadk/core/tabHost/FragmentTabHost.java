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
    private FragmentTabWidget azO;
    private com.baidu.tbadk.core.tabHost.a azP;
    private b azQ;
    private boolean azR;
    private final List<b> azS;
    private CustomViewPager azT;
    private a azU;
    private FragmentAdapter azV;
    private LinearLayout azW;
    private int azX;
    private View azY;
    private int azZ;
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
        public TbFragmentTabIndicator aAb;
        public Fragment aAc;
        public com.baidu.tbadk.mainTab.b aAd;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.azR = true;
        this.azS = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azX = 0;
        this.azZ = e.d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azR = true;
        this.azS = new ArrayList();
        this.mOnPageChangeListener = null;
        this.azX = 0;
        this.azZ = e.d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.fragment_tabhost, (ViewGroup) this, true);
        this.azW = (LinearLayout) findViewById(e.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.azQ = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.azO != null) {
            this.azO.getLayoutParams().height = i;
            this.azO.requestLayout();
            this.azW.getLayoutParams().height = i;
            this.azW.requestLayout();
            this.azX = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.azO != null) {
            this.azO.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.azO != null) {
            this.azO.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.azO != null) {
            this.azO.setShouldDrawTopLine(z);
        }
    }

    public void br(boolean z) {
        if (this.azY == null) {
            this.azY = findViewById(e.g.topDvider);
        }
        if (!z) {
            this.azY.setVisibility(8);
            return;
        }
        if (this.azO != null) {
            this.azO.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.azY.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.azY.setLayoutParams(layoutParams);
        this.azY.setVisibility(0);
        al.j(this.azY, e.d.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.azO.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.azO != null) {
            this.azO.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.azP == null) {
            this.azP = new com.baidu.tbadk.core.tabHost.a(this, e.d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        br(false);
        this.azP.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.azO = (FragmentTabWidget) findViewById(e.g.tabcontainer);
        this.azO.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.azO.setPadding(i, i2, i3, i4);
    }

    public void bs(boolean z) {
        this.azO.bs(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.aAb == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.aAc == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.azS.contains(bVar)) {
            if (bVar.aAd != null) {
                bVar.aAd.Of();
            }
            this.azO.addView(bVar.aAb, i);
            if (i == -1) {
                this.azS.add(bVar);
            } else {
                this.azS.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.azT != null) {
            this.azT.setScrollable(z);
        }
    }

    public void initViewPager() {
        dw(0);
    }

    public void dw(int i) {
        if (this.azT != null) {
            removeView(this.azT);
        }
        this.azT = new CustomViewPager(this.mContext);
        this.azT.setId(e.g.tab_content);
        dx(i);
        addView(this.azT);
        removeView(this.azW);
        addView(this.azW);
        this.azT.setOffscreenPageLimit(this.azS.size() - 1);
        this.azT.setOnPageChangeListener(this);
        this.azV = new FragmentAdapter(this.mFragmentManager, this.azS);
        this.azT.setAdapter(this.azV);
    }

    public void CK() {
        if (this.azT != null) {
            removeView(this.azT);
        }
        this.azT = new CustomViewPager(this.mContext);
        this.azT.setId(e.g.tab_content);
        addView(this.azT);
        removeView(this.azW);
        addView(this.azW);
        this.azT.setOffscreenPageLimit(this.azS.size() - 1);
        this.azT.setOnPageChangeListener(this);
        this.azV = new FragmentAdapter(this.mFragmentManager, this.azS);
        this.azT.setAdapter(this.azV);
    }

    public void dx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.azT.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.azT.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.azW.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.azW.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, e.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.azW.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds98);
            this.azW.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.h(this.mContext, e.C0210e.ds88);
            this.azW.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.azW.setVisibility(8);
        }
        this.azT.setLayoutParams(layoutParams);
        this.azW.setLayoutParams(layoutParams2);
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
        this.azU = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.azS.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.azQ = this.azS.get(this.mCurrentTabIndex);
            this.azO.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.azT != null) {
                this.azT.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.azS.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.azS.get(i3).mType) {
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
        this.azQ = this.azS.get(i);
        if (this.azU == null || this.azU.onPreTabSelectionChange(i, z)) {
            if (this.azU != null) {
                this.azU.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.azO.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.azS.size()) {
            return -1;
        }
        return this.azS.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.azQ != null) {
            return this.azQ.aAc;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.azT;
    }

    public ViewGroup getTabWrapper() {
        return this.azW;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.azO;
    }

    public b dy(int i) {
        if (i < 0 || i >= this.azS.size()) {
            return null;
        }
        return this.azS.get(i);
    }

    public b dz(int i) {
        for (b bVar : this.azS) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.azT != null && this.azV != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.azS.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.azT.getId(), this.azV.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.azS) {
                if (bVar.aAd != null) {
                    bVar.aAd.gy();
                }
            }
            this.azS.clear();
            this.azQ = null;
            this.mCurrentTabIndex = -1;
            this.azO.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.azR) {
            this.azW.setBackgroundDrawable(new BitmapDrawable(al.dQ(e.f.s_tabbar_bg)));
        } else {
            al.j(this.azW, this.azZ);
        }
        this.azO.onChangeSkinType(i);
        al.j(this.azY, e.d.cp_bg_line_b);
        for (b bVar : this.azS) {
            bVar.aAb.eD(i);
        }
        if (this.azV != null) {
            int count = this.azV.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.azV.getItem(i2);
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
        this.azO.d(i, f);
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
        this.azQ = this.azS.get(i);
        this.azO.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.azQ.aAc.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> aAa;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.aAa = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.aAa.get(i).aAc;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.aAa.get(i).aAc.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.aAa.size();
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
        this.azR = z;
    }

    public void CL() {
        if (this.azW != null && this.azW.getVisibility() != 0) {
            this.azW.setVisibility(0);
        }
    }

    public void CM() {
        if (this.azW != null && this.azW.getVisibility() != 8) {
            this.azW.setVisibility(8);
        }
    }
}
