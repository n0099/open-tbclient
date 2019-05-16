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
    private a bPA;
    private FragmentAdapter bPB;
    private LinearLayout bPC;
    private int bPD;
    private View bPE;
    private View bPF;
    private int bPG;
    private FragmentTabWidget bPu;
    private com.baidu.tbadk.core.tabHost.a bPv;
    private b bPw;
    private boolean bPx;
    private final List<b> bPy;
    private CustomViewPager bPz;
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
        public TbFragmentTabIndicator bPI;
        public Fragment bPJ;
        public com.baidu.tbadk.mainTab.b bPK;
        public int mType;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.bPx = true;
        this.bPy = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bPD = 0;
        this.bPG = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPx = true;
        this.bPy = new ArrayList();
        this.mOnPageChangeListener = null;
        this.bPD = 0;
        this.bPG = R.drawable.white_bg;
        this.mType = 0;
        init(context);
    }

    @SuppressLint({"ResourceAsColor"})
    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.bPC = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.bPF = findViewById(R.id.tabcontainer_shadow);
        this.mCurrentTabIndex = -1;
        this.bPw = null;
    }

    public void setUIType(int i) {
        if (this.mType != i) {
            this.mType = i;
            if (this.mType == 1) {
                this.bPG = R.drawable.bottom_bar_background;
                al.k(this.bPC, this.bPG);
                setShouldDrawTopLine(false);
                dW(false);
            } else if (this.mType == 0) {
                this.bPG = R.drawable.white_bg;
                al.k(this.bPC, this.bPG);
                setShouldDrawTopLine(true);
                dW(true);
            }
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.bPF.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.bPu != null) {
            this.bPu.getLayoutParams().height = i;
            this.bPu.requestLayout();
            this.bPC.getLayoutParams().height = i;
            this.bPC.requestLayout();
            this.bPD = i;
        }
    }

    public void setShouldDrawDividerLine(boolean z) {
        if (this.bPu != null) {
            this.bPu.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.bPu != null) {
            this.bPu.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        if (this.bPu != null) {
            this.bPu.setShouldDrawTopLine(z);
        }
    }

    public void dW(boolean z) {
        if (this.bPE == null) {
            this.bPE = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.bPE.setVisibility(8);
            return;
        }
        if (this.bPu != null) {
            this.bPu.setShouldDrawTopLine(false);
        }
        int dip2px = l.dip2px(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bPE.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = dip2px;
        this.bPE.setLayoutParams(layoutParams);
        this.bPE.setVisibility(0);
        al.l(this.bPE, R.color.cp_bg_line_b);
        ((LinearLayout.LayoutParams) this.bPu.getLayoutParams()).gravity = 80;
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        if (this.bPu != null) {
            this.bPu.setShouldDrawTopLine(z);
        }
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.bPv == null) {
            this.bPv = new com.baidu.tbadk.core.tabHost.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        dW(false);
        this.bPv.d(pair);
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.bPu = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.bPu.setTabSelectionListener(this);
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.bPu.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.bPI == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bPJ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bPy.contains(bVar)) {
            if (bVar.bPK != null) {
                bVar.bPK.asI();
            }
            this.bPu.addView(bVar.bPI, i);
            if (i == -1) {
                this.bPy.add(bVar);
            } else {
                this.bPy.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void a(b bVar, int i, boolean z) {
        if (bVar.bPI == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.bPJ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.bPy.contains(bVar)) {
            if (bVar.bPK != null) {
                bVar.bPK.asI();
            }
            this.bPu.addView(bVar.bPI, i, z);
            if (i == -1) {
                this.bPy.add(bVar);
            } else {
                this.bPy.add(i, bVar);
            }
            if (this.mCurrentTabIndex != -1 && i <= this.mCurrentTabIndex) {
                this.mCurrentTabIndex++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.bPz != null) {
            this.bPz.setScrollable(z);
        }
    }

    public void initViewPager() {
        hL(0);
    }

    public void hL(int i) {
        if (this.bPz != null) {
            removeView(this.bPz);
        }
        this.bPz = new CustomViewPager(this.mContext);
        this.bPz.setId(R.id.tab_content);
        hM(i);
        addView(this.bPz);
        removeView(this.bPC);
        addView(this.bPC);
        removeView(this.bPF);
        addView(this.bPF);
        this.bPz.setOffscreenPageLimit(this.bPy.size() - 1);
        this.bPz.setOnPageChangeListener(this);
        this.bPB = new FragmentAdapter(this.mFragmentManager, this.bPy);
        this.bPz.setAdapter(this.bPB);
    }

    public void agO() {
        if (this.bPz != null) {
            removeView(this.bPz);
        }
        this.bPz = new CustomViewPager(this.mContext);
        this.bPz.setId(R.id.tab_content);
        addView(this.bPz);
        removeView(this.bPC);
        addView(this.bPC);
        this.bPz.setOffscreenPageLimit(this.bPy.size() - 1);
        this.bPz.setOnPageChangeListener(this);
        this.bPB = new FragmentAdapter(this.mFragmentManager, this.bPy);
        this.bPz.setAdapter(this.bPB);
    }

    public void hM(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.bPz.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.bPz.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bPC.getLayoutParams();
            layoutParams2.height = -2;
        }
        h(layoutParams.getRules());
        h(layoutParams2.getRules());
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.bPC.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.bPC.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bPC.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.mContext, R.dimen.ds88);
            this.bPC.setVisibility(0);
        } else if (i == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.bPC.setVisibility(8);
        }
        this.bPz.setLayoutParams(layoutParams);
        this.bPC.setLayoutParams(layoutParams2);
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
        this.bPA = aVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.bPy.size() && i != this.mCurrentTabIndex) {
            this.mCurrentTabIndex = i;
            this.bPw = this.bPy.get(this.mCurrentTabIndex);
            this.bPu.setCurrentTab(this.mCurrentTabIndex, true, false);
            if (this.bPz != null) {
                this.bPz.setCurrentItem(this.mCurrentTabIndex, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.bPy.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.bPy.get(i3).mType) {
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
        this.bPw = this.bPy.get(i);
        if (this.bPA == null || this.bPA.onPreTabSelectionChange(i, z)) {
            if (this.bPA != null) {
                this.bPA.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.bPu.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public int getCurrentTabType() {
        if (this.mCurrentTabIndex < 0 || this.mCurrentTabIndex >= this.bPy.size()) {
            return -1;
        }
        return this.bPy.get(this.mCurrentTabIndex).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.bPw != null) {
            return this.bPw.bPJ;
        }
        return null;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.bPz;
    }

    public ViewGroup getTabWrapper() {
        return this.bPC;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.bPu;
    }

    public void setAbsoluteWeight(boolean z) {
        if (this.bPu != null) {
            this.bPu.setAbsoluteWeight(z);
        }
    }

    public b hN(int i) {
        if (i < 0 || i >= this.bPy.size()) {
            return null;
        }
        return this.bPy.get(i);
    }

    public b hO(int i) {
        for (b bVar : this.bPy) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        if (this.bPz != null && this.bPB != null) {
            FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
            int size = this.bPy.size();
            for (int i = 0; i < size; i++) {
                Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.bPz.getId(), this.bPB.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
            for (b bVar : this.bPy) {
                if (bVar.bPK != null) {
                    bVar.bPK.fn();
                }
            }
            this.bPy.clear();
            this.bPw = null;
            this.mCurrentTabIndex = -1;
            this.bPu.reset();
        }
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        if (i == 2 && this.bPx) {
            this.bPC.setBackgroundDrawable(new BitmapDrawable(al.m19if(R.drawable.s_tabbar_bg)));
        } else {
            al.k(this.bPC, this.bPG);
        }
        this.bPu.onChangeSkinType(i);
        al.l(this.bPE, R.color.cp_bg_line_b);
        for (b bVar : this.bPy) {
            bVar.bPI.iW(i);
            bVar.bPI.setSelected(bVar.bPI.isSelected());
        }
        if (this.bPB != null) {
            int count = this.bPB.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.bPB.getItem(i2);
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
        this.bPu.d(i, f);
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
        this.bPw = this.bPy.get(i);
        this.bPu.setCurrentTab(this.mCurrentTabIndex, false, true);
        ViewGroup viewGroup = (ViewGroup) this.bPw.bPJ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {
        private List<b> bPH;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.bPH = list;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.bPH.get(i).bPJ;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.bPH.get(i).bPJ.hashCode();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.bPH.size();
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
        this.bPx = z;
    }

    public void agP() {
        if (this.bPC != null && this.bPC.getVisibility() != 0) {
            this.bPC.setVisibility(0);
        }
    }

    public void agQ() {
        if (this.bPC != null && this.bPC.getVisibility() != 8) {
            this.bPC.setVisibility(8);
        }
    }
}
