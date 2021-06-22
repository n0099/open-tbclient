package com.baidu.tbadk.core.tabHost;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.b, ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f12286e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentTabWidget f12287f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.e0.a f12288g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabSwellingView f12289h;

    /* renamed from: i  reason: collision with root package name */
    public int f12290i;
    public b j;
    public FragmentManager k;
    public final List<b> l;
    public ViewPager.OnPageChangeListener m;
    public CustomViewPager n;
    public a o;
    public FragmentAdapter p;
    public LinearLayout q;
    public View r;
    public View s;
    public int t;
    public int u;

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f12291a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f12292b;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.f12291a = -1;
            this.f12292b = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            try {
                super.finishUpdate(viewGroup);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f12292b.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return this.f12292b.get(i2).f12295c;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i2) {
            return this.f12292b.get(i2).f12295c.hashCode();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            super.setPrimaryItem(viewGroup, i2, obj);
            int i3 = this.f12291a;
            if (i3 != i2) {
                if (i3 != -1) {
                    Fragment item = getItem(i3);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).setPrimary(false);
                    }
                }
                this.f12291a = i2;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i2, boolean z);

        void onTabSelectionChanged(int i2, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f12293a;

        /* renamed from: b  reason: collision with root package name */
        public TbFragmentTabIndicator f12294b;

        /* renamed from: c  reason: collision with root package name */
        public Fragment f12295c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.n0.e0.b f12296d;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.l = new ArrayList();
        this.m = null;
        this.t = 0;
        i(context);
    }

    public static String m(int i2, long j) {
        return "android:switcher:" + i2 + ":" + j;
    }

    public void a(b bVar) {
        b(bVar, -1);
    }

    public void b(b bVar, int i2) {
        if (bVar.f12294b != null) {
            if (bVar.f12295c != null) {
                if (this.l.contains(bVar)) {
                    return;
                }
                d.a.n0.e0.b bVar2 = bVar.f12296d;
                if (bVar2 != null) {
                    bVar2.onAdd();
                }
                this.f12287f.addView(bVar.f12294b, i2);
                if (i2 == -1) {
                    this.l.add(bVar);
                } else {
                    this.l.add(i2, bVar);
                }
                int i3 = this.f12290i;
                if (i3 == -1 || i2 > i3) {
                    return;
                }
                this.f12290i = i3 + 1;
                return;
            }
            throw new IllegalArgumentException("you must create the tab content");
        }
        throw new IllegalArgumentException("you must create the tab indicator.");
    }

    public void c(b bVar, int i2, boolean z) {
        if (bVar.f12294b != null) {
            if (bVar.f12295c != null) {
                if (this.l.contains(bVar)) {
                    return;
                }
                d.a.n0.e0.b bVar2 = bVar.f12296d;
                if (bVar2 != null) {
                    bVar2.onAdd();
                }
                this.f12287f.b(bVar.f12294b, i2, z);
                if (i2 == -1) {
                    this.l.add(bVar);
                } else {
                    this.l.add(i2, bVar);
                }
                int i3 = this.f12290i;
                if (i3 == -1 || i2 > i3) {
                    return;
                }
                this.f12290i = i3 + 1;
                return;
            }
            throw new IllegalArgumentException("you must create the tab content");
        }
        throw new IllegalArgumentException("you must create the tab indicator.");
    }

    public void d(int i2) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        if (this.n.getLayoutParams() == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        } else {
            layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams2.height = -2;
        }
        e(layoutParams.getRules());
        e(layoutParams2.getRules());
        if (i2 == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i2 == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i2 == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i2 == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.f12286e, R.dimen.ds88);
            this.q.setVisibility(0);
        } else if (i2 == 4) {
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(8);
        }
        this.n.setLayoutParams(layoutParams);
        this.q.setLayoutParams(layoutParams2);
    }

    public final void e(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = 0;
        }
    }

    public b f(int i2) {
        if (i2 < 0 || i2 >= this.l.size()) {
            return null;
        }
        return this.l.get(i2);
    }

    public b g(int i2) {
        for (b bVar : this.l) {
            if (i2 == bVar.f12293a) {
                return bVar;
            }
        }
        return null;
    }

    public Fragment getCurrentFragment() {
        b bVar = this.j;
        if (bVar != null) {
            return bVar.f12295c;
        }
        return null;
    }

    public int getCurrentTabIndex() {
        return this.f12290i;
    }

    public int getCurrentTabType() {
        int i2 = this.f12290i;
        if (i2 < 0 || i2 >= this.l.size()) {
            return -1;
        }
        return this.l.get(this.f12290i).f12293a;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.f12287f;
    }

    public CustomViewPager getFragmentViewPager() {
        return this.n;
    }

    public ViewGroup getTabWrapper() {
        return this.q;
    }

    public void h() {
        LinearLayout linearLayout = this.q;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.q.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(Context context) {
        this.f12286e = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.q = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.s = findViewById(R.id.tabcontainer_shadow);
        this.f12290i = -1;
        this.j = null;
    }

    public void j() {
        k(0);
    }

    public void k(int i2) {
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            removeView(customViewPager);
        }
        CustomViewPager customViewPager2 = new CustomViewPager(this.f12286e);
        this.n = customViewPager2;
        customViewPager2.setId(R.id.tab_content);
        d(i2);
        addView(this.n);
        removeView(this.q);
        addView(this.q);
        removeView(this.s);
        addView(this.s);
        this.n.setOffscreenPageLimit(this.l.size() - 1);
        this.n.setOnPageChangeListener(this);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.k, this.l);
        this.p = fragmentAdapter;
        this.n.setAdapter(fragmentAdapter);
    }

    public void l() {
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            removeView(customViewPager);
        }
        CustomViewPager customViewPager2 = new CustomViewPager(this.f12286e);
        this.n = customViewPager2;
        customViewPager2.setId(R.id.tab_content);
        addView(this.n);
        removeView(this.q);
        addView(this.q);
        this.n.setOffscreenPageLimit(this.l.size() - 1);
        this.n.setOnPageChangeListener(this);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.k, this.l);
        this.p = fragmentAdapter;
        this.n.setAdapter(fragmentAdapter);
    }

    public void n(boolean z) {
        if (z) {
            for (b bVar : this.l) {
                TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12294b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                    maintabBottomIndicator.r(true);
                    maintabBottomIndicator.setSelected(bVar.f12294b.isSelected());
                }
            }
            return;
        }
        for (b bVar2 : this.l) {
            TbFragmentTabIndicator tbFragmentTabIndicator2 = bVar2.f12294b;
            if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                maintabBottomIndicator2.r(false);
                maintabBottomIndicator2.setSelected(bVar2.f12294b.isSelected());
            }
        }
    }

    public void o(boolean z) {
        if (this.r == null) {
            this.r = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.r.setVisibility(8);
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawTopLine(false);
        }
        int e2 = l.e(getContext(), 1.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.gravity = 48;
        layoutParams.height = e2;
        this.r.setLayoutParams(layoutParams);
        this.r.setVisibility(0);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        ((FrameLayout.LayoutParams) this.f12287f.getLayoutParams()).gravity = 80;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        this.f12287f.c(i2, f2);
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        this.f12290i = i2;
        this.j = this.l.get(i2);
        this.f12287f.setCurrentTab(this.f12290i, false, true);
        ViewGroup viewGroup = (ViewGroup) this.j.f12295c.getView();
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof FragmentTabRootView) {
            ((FragmentTabRootView) childAt).b(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
    public void onTabSelectionChanged(int i2, boolean z) {
        this.j = this.l.get(i2);
        a aVar = this.o;
        if (aVar == null || aVar.onPreTabSelectionChange(i2, z)) {
            s(i2, z);
        }
    }

    public void p(int i2) {
        this.f12287f.h(i2);
        this.f12289h.b(i2);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.drawable.bottom_view_shadow);
        for (b bVar : this.l) {
            bVar.f12294b.e(i2);
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12294b;
            tbFragmentTabIndicator.setSelected(tbFragmentTabIndicator.isSelected());
        }
        FragmentAdapter fragmentAdapter = this.p;
        if (fragmentAdapter != null) {
            int count = fragmentAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                Fragment item = this.p.getItem(i3);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i2);
                }
            }
        }
    }

    public void q() {
        if (this.n == null || this.p == null) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = this.k.beginTransaction();
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment findFragmentByTag = this.k.findFragmentByTag(m(this.n.getId(), this.p.getItemId(i2)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commit();
            this.k.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        for (b bVar : this.l) {
            d.a.n0.e0.b bVar2 = bVar.f12296d;
            if (bVar2 != null) {
                bVar2.onRemove();
            }
        }
        this.l.clear();
        this.j = null;
        this.f12290i = -1;
        this.f12287f.i();
    }

    public void r() {
        LinearLayout linearLayout = this.q;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
    }

    public void s(int i2, boolean z) {
        a aVar = this.o;
        if (aVar != null) {
            aVar.onTabSelectionChanged(i2, z);
        }
        setCurrentTab(i2);
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setAbsoluteWeight(z);
        }
    }

    public void setBackGroundStyle(int i2) {
        this.u = i2;
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setBackGroundStyle(i2);
        }
    }

    public void setCurrentTab(int i2) {
        if (i2 < 0 || i2 >= this.l.size() || i2 == this.f12290i) {
            return;
        }
        this.f12290i = i2;
        this.j = this.l.get(i2);
        this.f12287f.setCurrentTab(this.f12290i, true, false);
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.f12290i, false);
        }
    }

    public void setCurrentTabByType(int i2) {
        int size = this.l.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (i2 == this.l.get(i3).f12293a) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1) {
            s(i3, false);
        } else if (this.f12290i == -1) {
            s(0, false);
        }
    }

    public void setNeedShowThemeStyle(boolean z) {
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.m = onPageChangeListener;
    }

    public void setOnTabSelectionListener(a aVar) {
        this.o = aVar;
    }

    public void setShouldDrawDividerLine(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.s.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetBackgroundColor(int i2) {
        this.f12287f.setBackgroundColor(i2);
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.f12288g == null) {
            this.f12288g = new d.a.n0.r.e0.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        o(false);
        this.f12288g.e(pair);
    }

    public void setTabWidgetViewHeight(int i2) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget == null) {
            return;
        }
        fragmentTabWidget.getLayoutParams().height = i2;
        this.f12287f.requestLayout();
        this.q.getLayoutParams().height = i2;
        this.q.requestLayout();
        if (this.u == 1) {
            this.f12289h.getLayoutParams().height = i2;
            this.f12289h.requestLayout();
        }
    }

    public void setTabWidgetViewPadding(int i2, int i3, int i4, int i5) {
        this.f12287f.setPadding(i2, i3, i4, i5);
    }

    public void setUIType(int i2) {
        if (this.t == i2) {
            return;
        }
        this.t = i2;
        if (i2 == 1) {
            setShouldDrawTopLine(false);
            o(false);
        } else if (i2 == 0) {
            setShouldDrawTopLine(true);
            o(true);
        }
    }

    public void setViewPagerScrollable(boolean z) {
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            customViewPager.setScrollable(z);
        }
    }

    public void setup(FragmentManager fragmentManager) {
        this.k = fragmentManager;
        this.f12287f = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.f12289h = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.f12287f.setTabSelectionListener(this);
    }

    public void setShouldDrawTopLine(boolean z, int i2) {
        FragmentTabWidget fragmentTabWidget = this.f12287f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new ArrayList();
        this.m = null;
        this.t = 0;
        i(context);
    }
}
