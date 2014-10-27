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
    private FragmentTabWidget Cp;
    private int Cq;
    private b Cr;
    private final List<b> Cs;
    private ViewPager Ct;
    private a Cu;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public FragmentTabHost(Context context) {
        super(context);
        this.Cs = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Cs = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, w.fragment_tabhost, this, true);
        this.Cq = -1;
        this.Cr = null;
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.Cp = (FragmentTabWidget) findViewById(v.tabcontainer);
        this.Cp.setTabSelectionListener(this);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.Cx == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.Cy == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.Cs.contains(bVar)) {
            this.Cp.addView(bVar.Cx, i);
            if (i == -1) {
                this.Cs.add(bVar);
            } else {
                this.Cs.add(i, bVar);
            }
            if (this.Cq != -1 && i <= this.Cq) {
                this.Cq++;
            }
        }
    }

    public void initViewPager() {
        if (this.Ct != null) {
            removeView(this.Ct);
        }
        this.Ct = new ViewPager(this.mContext);
        this.Ct.setId(v.tab_content);
        this.Ct.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.Ct);
        this.Ct.setOffscreenPageLimit(this.Cs.size() - 1);
        this.Ct.setOnPageChangeListener(this);
        this.Cu = new a(this.mFragmentManager, this.Cs);
        this.Ct.setAdapter(this.Cu);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.Cs.size() && i != this.Cq) {
            this.Cq = i;
            this.Cr = this.Cs.get(this.Cq);
            this.Cp.d(this.Cq, true);
            this.Ct.setCurrentItem(this.Cq, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.Cs.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.Cs.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.Cq == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.Cp.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.Cq;
    }

    public int getCurrentTabType() {
        if (this.Cq < 0 || this.Cq >= this.Cs.size()) {
            return -1;
        }
        return this.Cs.get(this.Cq).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.Cr != null) {
            return this.Cr.Cy;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.Cp;
    }

    public b bk(int i) {
        for (b bVar : this.Cs) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.Cs.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.Ct.getId(), this.Cu.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.Cs.clear();
        this.Cr = null;
        this.Cq = -1;
        this.Cp.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.Cp.onChangeSkinType(i);
        for (b bVar : this.Cs) {
            bVar.Cx.bN(i);
        }
        if (this.Cu != null) {
            int count = this.Cu.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.Cu.getItem(i2);
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
        this.Cp.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.Cq = i;
        this.Cr = this.Cs.get(i);
        this.Cp.d(this.Cq, false);
        ViewGroup viewGroup = (ViewGroup) this.Cr.Cy.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
