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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends RelativeLayout implements ViewPager.OnPageChangeListener, FragmentTabWidget.a {
    private CustomViewPager bPA;
    private a bPB;
    private FragmentAdapter bPC;
    private LinearLayout bPD;
    private int bPE;
    private View bPF;
    private View bPG;
    private int bPH;
    private FragmentTabWidget bPv;
    private com.baidu.tbadk.core.tabHost.a bPw;
    private b bPx;
    private boolean bPy;
    private final List<b> bPz;
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
        public TbFragmentTabIndicator bPJ;
        public Fragment bPK;
        public com.baidu.tbadk.mainTab.b bPL;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bPy = true;
        this.bPz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bPE = 0;
        this.bPH = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPy = true;
        this.bPz = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bPE = 0;
        this.bPH = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.bPD = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.bPG = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bPx = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bPH = R.drawable.bottom_bar_background;
                al.k(this.bPD, this.bPH);
                setShouldDrawTopLine(false);
                dW(false);
            } else if (this.mType == 0) {
                this.bPH = R.drawable.white_bg;
                al.k(this.bPD, this.bPH);
                setShouldDrawTopLine(true);
                dW(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bPG.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bPv != null) {
            this.bPv.getLayoutParams().height = i;
            this.bPv.requestLayout();
            this.bPD.getLayoutParams().height = i;
            this.bPD.requestLayout();
            this.bPE = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bPv != null) {
            this.bPv.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bPv != null) {
            this.bPv.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bPv != null) {
            this.bPv.setShouldDrawTopLine(z);
        }
    }

    public void dW(boolean z) {
        if (this.bPF == null) {
            this.bPF = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.bPF.setVisibility(8);
            return;
        }
        if (this.bPv != null) {
            this.bPv.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bPF.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bPF.setLayoutParams(layoutParams);
        this.bPF.setVisibility(0);
        al.l(this.bPF, R.color.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bPv.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bPv != null) {
            this.bPv.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bPw == null) {
            this.bPw = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dW(false);
        this.bPw.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bPv = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.bPv.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bPv.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bPJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bPK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bPz.contains(bVar)) {
            if (bVar.bPL != null) {
                bVar.bPL.asI();
            }
            this.bPv.addView(bVar.bPJ, i);
            if (i == -1) {
                this.bPz.add(bVar);
            } else {
                this.bPz.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bPJ == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bPK == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bPz.contains(bVar)) {
            if (bVar.bPL != null) {
                bVar.bPL.asI();
            }
            this.bPv.addView(bVar.bPJ, i, z);
            if (i == -1) {
                this.bPz.add(bVar);
            } else {
                this.bPz.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bPA != null) {
            this.bPA.setScrollable(z);
        }
    }

    public void initViewPager() {
        hL(0);
    }

    public void hL(int i) {
        if (this.bPA != null) {
            removeView(this.bPA);
        }
        this.bPA = new CustomViewPager(this.mContext);
        this.bPA.setId(R.id.tab_content);
        hM(i);
        addView(this.bPA);
        removeView(this.bPD);
        addView(this.bPD);
        removeView(this.bPG);
        addView(this.bPG);
        this.bPA.setOffscreenPageLimit(this.bPz.size() - 1);
        this.bPA.setOnPageChangeListener(this);
        this.bPC = new FragmentAdapter(this.mFragmentManager, this.bPz);
        this.bPA.setAdapter(this.bPC);
    }

    public void agO() {
        if (this.bPA != null) {
            removeView(this.bPA);
        }
        this.bPA = new CustomViewPager(this.mContext);
        this.bPA.setId(R.id.tab_content);
        addView(this.bPA);
        removeView(this.bPD);
        addView(this.bPD);
        this.bPA.setOffscreenPageLimit(this.bPz.size() - 1);
        this.bPA.setOnPageChangeListener(this);
        this.bPC = new FragmentAdapter(this.mFragmentManager, this.bPz);
        this.bPA.setAdapter(this.bPC);
    }

    public void hM(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bPA.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bPA.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bPD.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bPD.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bPD.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bPD.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.mContext, R.dimen.ds88);
            this.bPD.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bPD.setVisibility(8);
        }
        this.bPA.setLayoutParams(layoutParams);
        this.bPD.setLayoutParams(layoutParams2);
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
        this.bPB = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bPz.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bPx = this.bPz.get(this.mCurrentTabIndex);
            this.bPv.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bPA != null) {
                this.bPA.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bPz.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bPz.get(i3).mType) {
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
        this.bPx = this.bPz.get(i);
        if (this.bPB == null || this.bPB.onPreTabSelectionChange(i, z)) {
            if (this.bPB != null) {
                this.bPB.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bPv.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bPz.size()) {
            return -1;
        }
        return this.bPz.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bPx != null) {
            return this.bPx.bPK;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bPA;
    }

    public ViewGroup getTabWrapper() {
        return this.bPD;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bPv;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bPv != null) {
            this.bPv.setAbsoluteWeight(z);
        }
    }

    public b hN(int i) {
        if (i < 0 || i >= this.bPz.size()) {
            return null;
        }
        return this.bPz.get(i);
    }

    public b hO(int i) {
        for (b bVar : this.bPz) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bPA != null && this.bPC != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bPz.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bPA.getId(), this.bPC.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bPz) {
                if (bVar.bPL != null) {
                    bVar.bPL.fn();
                }
            }
            this.bPz.clear();
            this.bPx = null;
            this.mCurrentTabIndex = -1;
            this.bPv.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bPy) {
            this.bPD.setBackgroundDrawable(new BitmapDrawable(al.m19if(R.drawable.s_tabbar_bg)));
        } else {
            al.k(this.bPD, this.bPH);
        }
        this.bPv.onChangeSkinType(i);
        al.l(this.bPF, R.color.cp_bg_line_b);
        for (b bVar : this.bPz) {
            bVar.bPJ.iW(i);
            bVar.bPJ.setSelected(bVar.bPJ.isSelected());
        }
        if (this.bPC != null) {
            int count = this.bPC.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bPC.getItem(i2);
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
        this.bPv.d(i, f);
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
        this.bPx = this.bPz.get(i);
        this.bPv.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bPx.bPK.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bPI;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bPI = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bPI.get(i).bPK;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bPI.get(i).bPK.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bPI.size();
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
        this.bPy = z;
    }

    public void agP() {
        if (this.bPD != null && this.bPD.getVisibility() != 0) {
            this.bPD.setVisibility(0);
        }
    }

    public void agQ() {
        if (this.bPD != null && this.bPD.getVisibility() != 8) {
            this.bPD.setVisibility(8);
        }
    }
}
