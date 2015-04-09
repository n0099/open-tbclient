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
    private FragmentTabWidget SJ;
    private int SL;
    private b SM;
    private final List<b> SO;
    private a SP;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mViewPager;

    public FragmentTabHost(Context context) {
        super(context);
        this.SO = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SO = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, w.fragment_tabhost, this, true);
        this.SL = -1;
        this.SM = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.SJ != null) {
            this.SJ.getLayoutParams().height = i;
            this.SJ.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.SJ != null) {
            this.SJ.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.SJ != null) {
            this.SJ.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.SJ = (FragmentTabWidget) findViewById(v.tabcontainer);
        this.SJ.setTabSelectionListener(this);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.SJ.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.SR == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.SS == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.SO.contains(bVar)) {
            this.SJ.addView(bVar.SR, i);
            if (i == -1) {
                this.SO.add(bVar);
            } else {
                this.SO.add(i, bVar);
            }
            if (this.SL != -1 && i <= this.SL) {
                this.SL++;
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
        this.mViewPager.setOffscreenPageLimit(this.SO.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.SP = new a(this.mFragmentManager, this.SO);
        this.mViewPager.setAdapter(this.SP);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.SO.size() && i != this.SL) {
            this.SL = i;
            this.SM = this.SO.get(this.SL);
            this.SJ.d(this.SL, true);
            if (this.mViewPager != null) {
                this.mViewPager.setCurrentItem(this.SL, false);
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.SO.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.SO.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.SL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.SJ.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.SL;
    }

    public int getCurrentTabType() {
        if (this.SL < 0 || this.SL >= this.SO.size()) {
            return -1;
        }
        return this.SO.get(this.SL).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.SM != null) {
            return this.SM.SS;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.SJ;
    }

    public b bN(int i) {
        for (b bVar : this.SO) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.SO.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.SP.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.SO.clear();
        this.SM = null;
        this.SL = -1;
        this.SJ.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.SJ.onChangeSkinType(i);
        for (b bVar : this.SO) {
            bVar.SR.cu(i);
        }
        if (this.SP != null) {
            int count = this.SP.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.SP.getItem(i2);
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
        this.SJ.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.SL = i;
        this.SM = this.SO.get(i);
        this.SJ.d(this.SL, false);
        ViewGroup viewGroup = (ViewGroup) this.SM.SS.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
