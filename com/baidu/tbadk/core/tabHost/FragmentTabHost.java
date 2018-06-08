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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private com.baidu.tbadk.core.tabHost.a anA;
    private b anB;
    private boolean anC;
    private final List<b> anD;
    private CustomViewPager anE;
    private a anF;
    private FragmentAdapter anG;
    private FrameLayout anH;
    private int anI;
    private View anJ;
    private int anK;
    private FragmentTabWidget anz;
    private Context mContext;
    private int mCurrentTabIndex;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    /* loaded from: classes.dex */
    public interface a {
        void i(int i, boolean z);

        boolean j(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TbFragmentTabIndicator anM;
        public Fragment anN;
        public com.baidu.tbadk.mainTab.b anO;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.anC = true;
        this.anD = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anI = 0;
        this.anK = d.C0141d.cp_bg_line_d;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anC = true;
        this.anD = new ArrayList();
        this.mOnPageChangeListener = null;
        this.anI = 0;
        this.anK = d.C0141d.cp_bg_line_d;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.fragment_tabhost, (ViewGroup) this, true);
        this.anH = (FrameLayout) findViewById(d.g.tabcontainer_wrapper);
        this.mCurrentTabIndex = -1;
        this.anB = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.anz != null) {
            this.anz.getLayoutParams().height = i;
            this.anz.requestLayout();
            this.anH.getLayoutParams().height = i;
            this.anH.requestLayout();
            this.anI = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.anz != null) {
            this.anz.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.anz != null) {
            this.anz.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.anz != null) {
            this.anz.setShouldDrawTopLine(z);
        }
    }

    public void aF(boolean z) {
        if (this.anJ == null) {
            this.anJ = findViewById(d.g.topDvider);
        }
        if (!z) {
            this.anJ.setVisibility(8);
            return;
        }
        if (this.anz != null) {
            this.anz.setShouldDrawTopLine(false);
        }
        int dip2px = this.anI + l.dip2px(getContext(), 1.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.anJ.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.anJ.setLayoutParams(layoutParams);
        this.anJ.setVisibility(0);
        al.j(this.anJ, d.C0141d.cp_bg_line_b);
        ((FrameLayout.LayoutParams) this.anz.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.anz != null) {
            this.anz.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.anA == null) {
            this.anA = new com.baidu.tbadk.core.tabHost.a(this, d.C0141d.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        aF(false);
        this.anA.a(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.anz = (FragmentTabWidget) findViewById(d.g.tabcontainer);
        this.anz.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.anz.setPadding(i, i2, i3, i4);
    }

    public void aG(boolean z) {
        this.anz.aG(z);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.anM == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.anN == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.anD.contains(bVar)) {
            if (bVar.anO != null) {
                bVar.anO.IZ();
            }
            this.anz.addView(bVar.anM, i);
            if (i == -1) {
                this.anD.add(bVar);
            } else {
                this.anD.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.anE != null) {
            this.anE.setScrollable(z);
        }
    }

    public void initViewPager() {
        cx(0);
    }

    public void cx(int i) {
        if (this.anE != null) {
            removeView(this.anE);
        }
        this.anE = new CustomViewPager(this.mContext);
        this.anE.setId(d.g.tab_content);
        cy(i);
        addView(this.anE);
        removeView(this.anH);
        addView(this.anH);
        this.anE.setOffscreenPageLimit(this.anD.size() - 1);
        this.anE.setOnPageChangeListener(this);
        this.anG = new FragmentAdapter(this.mFragmentManager, this.anD);
        this.anE.setAdapter(this.anG);
    }

    public void xT() {
        if (this.anE != null) {
            removeView(this.anE);
        }
        this.anE = new CustomViewPager(this.mContext);
        this.anE.setId(d.g.tab_content);
        addView(this.anE);
        removeView(this.anH);
        addView(this.anH);
        this.anE.setOffscreenPageLimit(this.anD.size() - 1);
        this.anE.setOnPageChangeListener(this);
        this.anG = new FragmentAdapter(this.mFragmentManager, this.anD);
        this.anE.setAdapter(this.anG);
    }

    public void cy(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.anE.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.anE.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.anH.getLayoutParams();
            layoutParams2.height = -2;
        }
        g(layoutParams.getRules());
        g(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, d.g.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds98);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.e(this.mContext, d.e.ds88);
        }
        this.anE.setLayoutParams(layoutParams);
        this.anH.setLayoutParams(layoutParams2);
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
        this.anF = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.anD.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.anB = this.anD.get(this.mCurrentTabIndex);
            this.anz.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.anE != null) {
                this.anE.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.anD.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.anD.get(i3).mType) {
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
    public void i(int i, boolean z) {
        this.anB = this.anD.get(i);
        if (this.anF == null || this.anF.j(i, z)) {
            if (this.anF != null) {
                this.anF.i(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.anz.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.anD.size()) {
            return -1;
        }
        return this.anD.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.anB != null) {
            return this.anB.anN;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.anE;
    }

    public FrameLayout getTabWrapper() {
        return this.anH;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.anz;
    }

    public b cz(int i) {
        if (i < 0 || i >= this.anD.size()) {
            return null;
        }
        return this.anD.get(i);
    }

    public b cA(int i) {
        for (b bVar : this.anD) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.anE != null && this.anG != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.anD.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.anE.getId(), this.anG.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.anD) {
                if (bVar.anO != null) {
                    bVar.anO.eY();
                }
            }
            this.anD.clear();
            this.anB = null;
            this.mCurrentTabIndex = -1;
            this.anz.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + SystemInfoUtil.COLON + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.anC) {
            this.anH.setBackgroundDrawable(new BitmapDrawable(al.cS(d.f.s_tabbar_bg)));
        } else {
            al.j(this.anH, this.anK);
        }
        this.anz.onChangeSkinType(i);
        al.j(this.anJ, d.C0141d.cp_bg_line_b);
        for (b bVar : this.anD) {
            bVar.anM.dC(i);
        }
        if (this.anG != null) {
            int count = this.anG.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.anG.getItem(i2);
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
        this.anz.d(i, f);
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
        this.anB = this.anD.get(i);
        this.anz.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.anB.anN.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> anL;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.anL = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.anL.get(i).anN;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.anL.get(i).anN.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.anL.size();
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
        this.anC = z;
    }

    public void xU() {
        if (this.anH != null && this.anH.getVisibility() != 0) {
            this.anH.setVisibility(0);
        }
    }

    public void xV() {
        if (this.anH != null && this.anH.getVisibility() != 8) {
            this.anH.setVisibility(8);
        }
    }
}
