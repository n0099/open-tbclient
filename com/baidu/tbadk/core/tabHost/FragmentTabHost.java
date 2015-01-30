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
    private FragmentTabWidget GK;
    private int GL;
    private b GM;
    private final List<b> GN;
    private a GP;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mViewPager;

    public FragmentTabHost(Context context) {
        super(context);
        this.GN = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GN = new ArrayList();
        this.mOnPageChangeListener = null;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ei().a(context, x.fragment_tabhost, this, true);
        this.GL = -1;
        this.GM = null;
    }

    public void setTabWidgetViewHeight(int i) {
        if (this.GK != null) {
            this.GK.getLayoutParams().height = i;
            this.GK.requestLayout();
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        if (this.GK != null) {
            this.GK.setShouldDrawIndicatorLine(z);
        }
    }

    public void setTabWidgetBackgroundRes(int i) {
        if (this.GK != null) {
            this.GK.setBackGroundDrawableResId(i);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
        this.GK = (FragmentTabWidget) findViewById(w.tabcontainer);
        this.GK.setTabSelectionListener(this);
    }

    public void c(int i, int i2, int i3, int i4) {
        this.GK.setPadding(i, i2, i3, i4);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.GR == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.GS == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.GN.contains(bVar)) {
            this.GK.addView(bVar.GR, i);
            if (i == -1) {
                this.GN.add(bVar);
            } else {
                this.GN.add(i, bVar);
            }
            if (this.GL != -1 && i <= this.GL) {
                this.GL++;
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
        this.mViewPager.setOffscreenPageLimit(this.GN.size() - 1);
        this.mViewPager.setOnPageChangeListener(this);
        this.GP = new a(this.mFragmentManager, this.GN);
        this.mViewPager.setAdapter(this.GP);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.GN.size() && i != this.GL) {
            this.GL = i;
            this.GM = this.GN.get(this.GL);
            this.GK.d(this.GL, true);
            this.mViewPager.setCurrentItem(this.GL, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.GN.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.GN.get(i3).mType) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.GL == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.GK.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.GL;
    }

    public int getCurrentTabType() {
        if (this.GL < 0 || this.GL >= this.GN.size()) {
            return -1;
        }
        return this.GN.get(this.GL).mType;
    }

    public Fragment getCurrentFragment() {
        if (this.GM != null) {
            return this.GM.GS;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.GK;
    }

    public b bM(int i) {
        for (b bVar : this.GN) {
            if (i == bVar.mType) {
                return bVar;
            }
        }
        return null;
    }

    public void reset() {
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int size = this.GN.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(this.mViewPager.getId(), this.GP.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.GN.clear();
        this.GM = null;
        this.GL = -1;
        this.GK.reset();
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void onChangeSkinType(int i) {
        this.GK.onChangeSkinType(i);
        for (b bVar : this.GN) {
            bVar.GR.ct(i);
        }
        if (this.GP != null) {
            int count = this.GP.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.GP.getItem(i2);
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
        this.GK.a(i, f);
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        this.GL = i;
        this.GM = this.GN.get(i);
        this.GK.d(this.GL, false);
        ViewGroup viewGroup = (ViewGroup) this.GM.GS.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof c) {
                ((c) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
