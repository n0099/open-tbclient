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
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private FragmentTabWidget Cq;
    private int Cr;
    private b Cs;
    private final List<b> Ct;
    private ViewPager Cu;
    private a Cv;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public FragmentTabHost(Context context) {
        super(context);
        this.Ct = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ct = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.fragment_tabhost, this, true);
        this.Cr = -1;
        this.Cs = null;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Cq = (FragmentTabWidget) findViewById(v.tabcontainer);
        this.Cq.setTabSelectionListener(this);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.Cy == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.Cz == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Ct.contains(bVar)) {
            this.Cq.addView(bVar.Cy, i);
            if (i == -1) {
                this.Ct.add(bVar);
            } else {
                this.Ct.add(i, bVar);
            }
            if (this.Cr != -1 && i <= this.Cr) {
                this.Cr++;
            }
        }
    }

    public void initViewPager() {
        if (this.Cu != null) {
            removeView(this.Cu);
        }
        this.Cu = new ViewPager(this.mContext);
        this.Cu.setId(v.tab_content);
        this.Cu.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.Cu);
        this.Cu.setOffscreenPageLimit(this.Ct.size() - 1);
        this.Cu.setOnPageChangeListener(this);
        this.Cv = new a(this.mFragmentManager, this.Ct);
        this.Cu.setAdapter(this.Cv);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Ct.size() && i != this.Cr) {
            this.Cr = i;
            this.Cs = this.Ct.get(this.Cr);
            this.Cq.d(this.Cr, true);
            this.Cu.setCurrentItem(this.Cr, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Ct.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Ct.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Cr == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Cq.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Cr;
    }

    public int getCurrentTabType() {
        if (this.Cr < 0 || this.Cr >= this.Ct.size()) {
            return -1;
        }
        return this.Ct.get(this.Cr).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.Cs != null) {
            return this.Cs.Cz;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Cq;
    }

    public b bk(int i) {
        for (b bVar : this.Ct) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Ct.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Cu.getId(), this.Cv.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.Ct.clear();
        this.Cs = null;
        this.Cr = -1;
        this.Cq.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.Cq.onChangeSkinType(i);
        for (b bVar : this.Ct) {
            bVar.Cy.bN(i);
        }
        if (this.Cv != null) {
            int count = this.Cv.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Cv.getItem(i2);
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
        this.Cq.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Cr = i;
        this.Cs = this.Ct.get(i);
        this.Cq.d(this.Cr, false);
        ViewGroup viewGroup = (ViewGroup) this.Cs.Cz.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
