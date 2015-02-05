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
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, d {
    private FragmentTabWidget GH;
    private int GI;
    private b GJ;
    private final List<b> GK;
    private a GL;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mViewPager;

    public FragmentTabHost(Context context) {
        super(context);
        this.GK = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GK = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ei().a(context, x.fragment_tabhost, this, true);
        this.GI = -1;
        this.GJ = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.GH != null) {
            this.GH.getLayoutParams().height = i;
            this.GH.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.GH != null) {
            this.GH.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.GH != null) {
            this.GH.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.GH = (FragmentTabWidget) findViewById(w.tabcontainer);
        this.GH.setTabSelectionListener(this);
    }

    public void c(int i, int i2, int i3, int i4) {
        this.GH.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.GN == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.GP == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.GK.contains(bVar)) {
            this.GH.addView(bVar.GN, i);
            if (i == -1) {
                this.GK.add(bVar);
            } else {
                this.GK.add(i, bVar);
            }
            if (this.GI != -1 && i <= this.GI) {
                this.GI++;
            }
        }
    }

    public void initViewPager() {
        bL(0);
    }

    public void bL(int i) {
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
        this.mViewPager.setOffscreenPageLimit(this.GK.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.GL = new a(this.mFragmentManager, this.GK);
        this.mViewPager.setAdapter(this.GL);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.GK.size() && i != this.GI) {
            this.GI = i;
            this.GJ = this.GK.get(this.GI);
            this.GH.d(this.GI, true);
            this.mViewPager.setCurrentItem(this.GI, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.GK.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.GK.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.GI == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.GH.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.GI;
    }

    public int getCurrentTabType() {
        if (this.GI < 0 || this.GI >= this.GK.size()) {
            return -1;
        }
        return this.GK.get(this.GI).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.GJ != null) {
            return this.GJ.GP;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.GH;
    }

    public b bM(int i) {
        for (b bVar : this.GK) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.GK.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.GL.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.GK.clear();
        this.GJ = null;
        this.GI = -1;
        this.GH.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.GH.onChangeSkinType(i);
        for (b bVar : this.GK) {
            bVar.GN.ct(i);
        }
        if (this.GL != null) {
            int count = this.GL.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.GL.getItem(i2);
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
        this.GH.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.GI = i;
        this.GJ = this.GK.get(i);
        this.GH.d(this.GI, false);
        ViewGroup viewGroup = (ViewGroup) this.GJ.GP.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof c) {
                ((c) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
