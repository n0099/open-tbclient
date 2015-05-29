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
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private FragmentTabWidget Tu;
    private int Tv;
    private b Tw;
    private final List<b> Tx;
    private CustomViewPager Ty;
    private a Tz;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public FragmentTabHost(Context context) {
        super(context);
        this.Tx = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tx = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hr().a(context, r.fragment_tabhost, this, true);
        this.Tv = -1;
        this.Tw = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.Tu != null) {
            this.Tu.getLayoutParams().height = i;
            this.Tu.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.Tu != null) {
            this.Tu.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.Tu != null) {
            this.Tu.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Tu = (FragmentTabWidget) findViewById(q.tabcontainer);
        this.Tu.setTabSelectionListener(this);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.Tu.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.TB == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.TC == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Tx.contains(bVar)) {
            this.Tu.addView(bVar.TB, i);
            if (i == -1) {
                this.Tx.add(bVar);
            } else {
                this.Tx.add(i, bVar);
            }
            if (this.Tv != -1 && i <= this.Tv) {
                this.Tv++;
            }
        }
    }

    public void setViewPagerScrollable(boolean z) {
        if (this.Ty != null) {
            this.Ty.setScrollable(z);
        }
    }

    public void initViewPager() {
        bP(0);
    }

    public void bP(int i) {
        if (this.Ty != null) {
            removeView(this.Ty);
        }
        this.Ty = new CustomViewPager(this.mContext);
        this.Ty.setId(q.tab_content);
        this.Ty.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        if (i == 1) {
            addView(this.Ty, 0);
        } else {
            addView(this.Ty);
        }
        this.Ty.setOffscreenPageLimit(this.Tx.size() - 1);
        this.Ty.setOnPageChangeListener(this);
        this.Tz = new a(this.mFragmentManager, this.Tx);
        this.Ty.setAdapter(this.Tz);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Tx.size() && i != this.Tv) {
            this.Tv = i;
            this.Tw = this.Tx.get(this.Tv);
            this.Tu.d(this.Tv, true);
            this.Ty.setCurrentItem(this.Tv, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Tx.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Tx.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Tv == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Tu.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Tv;
    }

    public int getCurrentTabType() {
        if (this.Tv < 0 || this.Tv >= this.Tx.size()) {
            return -1;
        }
        return this.Tx.get(this.Tv).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.Tw != null) {
            return this.Tw.TC;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Tu;
    }

    public b bQ(int i) {
        for (b bVar : this.Tx) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Tx.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Ty.getId(), this.Tz.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.Tx.clear();
        this.Tw = null;
        this.Tv = -1;
        this.Tu.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.Tu.onChangeSkinType(i);
        for (b bVar : this.Tx) {
            bVar.TB.cz(i);
        }
        if (this.Tz != null) {
            int count = this.Tz.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Tz.getItem(i2);
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
        this.Tu.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Tv = i;
        this.Tw = this.Tx.get(i);
        this.Tu.d(this.Tv, false);
        ViewGroup viewGroup = (ViewGroup) this.Tw.TC.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
