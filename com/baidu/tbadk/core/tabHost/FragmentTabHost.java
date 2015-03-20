package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private FragmentTabWidget SH;
    private int SI;
    private b SJ;
    private final List<b> SL;
    private a SM;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mViewPager;

    public FragmentTabHost(Context context) {
        super(context);
        this.SL = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SL = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, w.fragment_tabhost, this, true);
        this.SI = -1;
        this.SJ = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.SH != null) {
            this.SH.getLayoutParams().height = i;
            this.SH.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.SH != null) {
            this.SH.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.SH != null) {
            this.SH.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.SH = (FragmentTabWidget) findViewById(v.tabcontainer);
        this.SH.setTabSelectionListener(this);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.SH.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.SP == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.SQ == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.SL.contains(bVar)) {
            this.SH.addView(bVar.SP, i);
            if (i == -1) {
                this.SL.add(bVar);
            } else {
                this.SL.add(i, bVar);
            }
            if (this.SI != -1 && i <= this.SI) {
                this.SI++;
            }
        }
    }

    public void initViewPager() {
        bM(0);
    }

    public void bM(int i) {
        if (this.mViewPager != null) {
            removeView(this.mViewPager);
        }
        this.mViewPager = new CustomViewPager(this.mContext);
        this.mViewPager.setId(v.tab_content);
        this.mViewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i == 1) {
            addView(this.mViewPager, 0);
        } else {
            addView(this.mViewPager);
        }
        this.mViewPager.setOffscreenPageLimit(this.SL.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.SM = new a(this.mFragmentManager, this.SL);
        this.mViewPager.setAdapter(this.SM);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.SL.size() && i != this.SI) {
            this.SI = i;
            this.SJ = this.SL.get(this.SI);
            this.SH.d(this.SI, true);
            this.mViewPager.setCurrentItem(this.SI, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.SL.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.SL.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.SI == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.SH.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.SI;
    }

    public int getCurrentTabType() {
        if (this.SI < 0 || this.SI >= this.SL.size()) {
            return -1;
        }
        return this.SL.get(this.SI).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.SJ != null) {
            return this.SJ.SQ;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.SH;
    }

    public b bN(int i) {
        for (b bVar : this.SL) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.SL.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.SM.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.SL.clear();
        this.SJ = null;
        this.SI = -1;
        this.SH.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.SH.onChangeSkinType(i);
        for (b bVar : this.SL) {
            bVar.SP.cu(i);
        }
        if (this.SM != null) {
            int count = this.SM.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.SM.getItem(i2);
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
        this.SH.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.SI = i;
        this.SJ = this.SL.get(i);
        this.SH.d(this.SI, false);
        ViewGroup viewGroup = (ViewGroup) this.SJ.SQ.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
