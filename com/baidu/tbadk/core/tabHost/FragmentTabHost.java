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
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private FragmentTabWidget GB;
    private int GC;
    private b GD;
    private final List<b> GE;
    private a GF;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mViewPager;

    public FragmentTabHost(Context context) {
        super(context);
        this.GE = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GE = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, x.fragment_tabhost, this, true);
        this.GC = -1;
        this.GD = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.GB != null) {
            this.GB.getLayoutParams().height = i;
            this.GB.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.GB != null) {
            this.GB.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.GB != null) {
            this.GB.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.GB = (FragmentTabWidget) findViewById(w.tabcontainer);
        this.GB.setTabSelectionListener(this);
    }

    public void c(int i, int i2, int i3, int i4) {
        this.GB.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.GH == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.GI == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.GE.contains(bVar)) {
            this.GB.addView(bVar.GH, i);
            if (i == -1) {
                this.GE.add(bVar);
            } else {
                this.GE.add(i, bVar);
            }
            if (this.GC != -1 && i <= this.GC) {
                this.GC++;
            }
        }
    }

    public void initViewPager() {
        bG(0);
    }

    public void bG(int i) {
        if (this.mViewPager != null) {
            removeView(this.mViewPager);
        }
        this.mViewPager = new ViewPager(this.mContext);
        this.mViewPager.setId(w.tab_content);
        this.mViewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i == 1) {
            addView(this.mViewPager, 0);
        } else {
            addView(this.mViewPager);
        }
        this.mViewPager.setOffscreenPageLimit(this.GE.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.GF = new a(this.mFragmentManager, this.GE);
        this.mViewPager.setAdapter(this.GF);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.GE.size() && i != this.GC) {
            this.GC = i;
            this.GD = this.GE.get(this.GC);
            this.GB.d(this.GC, true);
            this.mViewPager.setCurrentItem(this.GC, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.GE.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.GE.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.GC == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.GB.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.GC;
    }

    public int getCurrentTabType() {
        if (this.GC < 0 || this.GC >= this.GE.size()) {
            return -1;
        }
        return this.GE.get(this.GC).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.GD != null) {
            return this.GD.GI;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.GB;
    }

    public b bH(int i) {
        for (b bVar : this.GE) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.GE.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.GF.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.GE.clear();
        this.GD = null;
        this.GC = -1;
        this.GB.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.GB.onChangeSkinType(i);
        for (b bVar : this.GE) {
            bVar.GH.cm(i);
        }
        if (this.GF != null) {
            int count = this.GF.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.GF.getItem(i2);
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
        this.GB.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.GC = i;
        this.GD = this.GE.get(i);
        this.GB.d(this.GC, false);
        ViewGroup viewGroup = (ViewGroup) this.GD.GI.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
