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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FragmentTabHost extends RelativeLayout implements FragmentTabWidget.b, ViewPager.OnPageChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f12974e;

    /* renamed from: f  reason: collision with root package name */
    public FragmentTabWidget f12975f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.e0.a f12976g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabSwellingView f12977h;
    public int i;
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
        public int f12978a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f12979b;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.f12978a = -1;
            this.f12979b = list;
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
            return this.f12979b.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.f12979b.get(i).f12982c;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.f12979b.get(i).f12982c.hashCode();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            int i2 = this.f12978a;
            if (i2 != i) {
                if (i2 != -1) {
                    Fragment item = getItem(i2);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).setPrimary(false);
                    }
                }
                this.f12978a = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        boolean onPreTabSelectionChange(int i, boolean z);

        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f12980a;

        /* renamed from: b  reason: collision with root package name */
        public TbFragmentTabIndicator f12981b;

        /* renamed from: c  reason: collision with root package name */
        public Fragment f12982c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.i0.e0.b f12983d;
    }

    public FragmentTabHost(Context context) {
        super(context);
        this.l = new ArrayList();
        this.m = null;
        this.t = 0;
        i(context);
    }

    public static String m(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void a(b bVar) {
        b(bVar, -1);
    }

    public void b(b bVar, int i) {
        if (bVar.f12981b != null) {
            if (bVar.f12982c != null) {
                if (this.l.contains(bVar)) {
                    return;
                }
                d.b.i0.e0.b bVar2 = bVar.f12983d;
                if (bVar2 != null) {
                    bVar2.onAdd();
                }
                this.f12975f.addView(bVar.f12981b, i);
                if (i == -1) {
                    this.l.add(bVar);
                } else {
                    this.l.add(i, bVar);
                }
                int i2 = this.i;
                if (i2 == -1 || i > i2) {
                    return;
                }
                this.i = i2 + 1;
                return;
            }
            throw new IllegalArgumentException("you must create the tab content");
        }
        throw new IllegalArgumentException("you must create the tab indicator.");
    }

    public void c(b bVar, int i, boolean z) {
        if (bVar.f12981b != null) {
            if (bVar.f12982c != null) {
                if (this.l.contains(bVar)) {
                    return;
                }
                d.b.i0.e0.b bVar2 = bVar.f12983d;
                if (bVar2 != null) {
                    bVar2.onAdd();
                }
                this.f12975f.b(bVar.f12981b, i, z);
                if (i == -1) {
                    this.l.add(bVar);
                } else {
                    this.l.add(i, bVar);
                }
                int i2 = this.i;
                if (i2 == -1 || i > i2) {
                    return;
                }
                this.i = i2 + 1;
                return;
            }
            throw new IllegalArgumentException("you must create the tab content");
        }
        throw new IllegalArgumentException("you must create the tab indicator.");
    }

    public void d(int i) {
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
        if (i == 1) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i == 0) {
            layoutParams2.addRule(10, -1);
            layoutParams.addRule(3, R.id.tabcontainer_wrapper);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i == 2) {
            layoutParams2.addRule(12, -1);
            layoutParams.addRule(10, -1);
            layoutParams.bottomMargin = 0;
            this.q.setVisibility(0);
        } else if (i == 3) {
            layoutParams2.topMargin = UtilHelper.getLightStatusBarHeight() + l.g(this.f12974e, R.dimen.ds88);
            this.q.setVisibility(0);
        } else if (i == 4) {
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
        for (int i = 0; i < length; i++) {
            iArr[i] = 0;
        }
    }

    public b f(int i) {
        if (i < 0 || i >= this.l.size()) {
            return null;
        }
        return this.l.get(i);
    }

    public b g(int i) {
        for (b bVar : this.l) {
            if (i == bVar.f12980a) {
                return bVar;
            }
        }
        return null;
    }

    public Fragment getCurrentFragment() {
        b bVar = this.j;
        if (bVar != null) {
            return bVar.f12982c;
        }
        return null;
    }

    public int getCurrentTabIndex() {
        return this.i;
    }

    public int getCurrentTabType() {
        int i = this.i;
        if (i < 0 || i >= this.l.size()) {
            return -1;
        }
        return this.l.get(this.i).f12980a;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.f12975f;
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
        this.f12974e = context;
        LayoutInflater.from(context).inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.q = (LinearLayout) findViewById(R.id.tabcontainer_wrapper);
        this.s = findViewById(R.id.tabcontainer_shadow);
        this.i = -1;
        this.j = null;
    }

    public void j() {
        k(0);
    }

    public void k(int i) {
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            removeView(customViewPager);
        }
        CustomViewPager customViewPager2 = new CustomViewPager(this.f12974e);
        this.n = customViewPager2;
        customViewPager2.setId(R.id.tab_content);
        d(i);
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
        CustomViewPager customViewPager2 = new CustomViewPager(this.f12974e);
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
        if (this.r == null) {
            this.r = findViewById(R.id.topDvider);
        }
        if (!z) {
            this.r.setVisibility(8);
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.f12975f;
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
        ((FrameLayout.LayoutParams) this.f12975f.getLayoutParams()).gravity = 80;
    }

    public void o(int i) {
        this.f12975f.g(i);
        this.f12977h.b(i);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.s, R.drawable.bottom_view_shadow);
        for (b bVar : this.l) {
            bVar.f12981b.e(i);
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12981b;
            tbFragmentTabIndicator.setSelected(tbFragmentTabIndicator.isSelected());
        }
        FragmentAdapter fragmentAdapter = this.p;
        if (fragmentAdapter != null) {
            int count = fragmentAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.p.getItem(i2);
                if (item instanceof BaseFragment) {
                    ((BaseFragment) item).changeSkinType(i);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        this.f12975f.c(i, f2);
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f2, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.m;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        this.i = i;
        this.j = this.l.get(i);
        this.f12975f.setCurrentTab(this.i, false, true);
        ViewGroup viewGroup = (ViewGroup) this.j.f12982c.getView();
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof FragmentTabRootView) {
            ((FragmentTabRootView) childAt).b(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
    public void onTabSelectionChanged(int i, boolean z) {
        this.j = this.l.get(i);
        a aVar = this.o;
        if (aVar == null || aVar.onPreTabSelectionChange(i, z)) {
            a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.onTabSelectionChanged(i, z);
            }
            setCurrentTab(i);
        }
    }

    public void p() {
        if (this.n == null || this.p == null) {
            return;
        }
        FragmentTransaction beginTransaction = this.k.beginTransaction();
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.k.findFragmentByTag(m(this.n.getId(), this.p.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        for (b bVar : this.l) {
            d.b.i0.e0.b bVar2 = bVar.f12983d;
            if (bVar2 != null) {
                bVar2.onRemove();
            }
        }
        this.l.clear();
        this.j = null;
        this.i = -1;
        this.f12975f.h();
    }

    public void q() {
        LinearLayout linearLayout = this.q;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
    }

    public void setAbsoluteWeight(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setAbsoluteWeight(z);
        }
    }

    public void setBackGroundStyle(int i) {
        this.u = i;
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setBackGroundStyle(i);
        }
    }

    public void setCurrentTab(int i) {
        if (i < 0 || i >= this.l.size() || i == this.i) {
            return;
        }
        this.i = i;
        this.j = this.l.get(i);
        this.f12975f.setCurrentTab(this.i, true, false);
        CustomViewPager customViewPager = this.n;
        if (customViewPager != null) {
            customViewPager.setCurrentItem(this.i, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int size = this.l.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (i == this.l.get(i2).f12980a) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.i == -1) {
            setCurrentTab(0);
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
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawDividerLine(z);
        }
    }

    public void setShouldDrawIndicatorLine(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawIndicatorLine(z);
        }
    }

    public void setShouldDrawTopLine(boolean z) {
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget != null) {
            fragmentTabWidget.setShouldDrawTopLine(z);
        }
    }

    public void setTabContainerShadowShow(boolean z) {
        this.s.setVisibility(z ? 0 : 8);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.f12975f.setBackgroundColor(i);
    }

    public void setTabWidgetBackgroundImageUrl(Pair<String, String> pair) {
        if (this.f12976g == null) {
            this.f12976g = new d.b.i0.r.e0.a(this, R.color.common_color_10274);
        }
        setShouldDrawIndicatorLine(false);
        setShouldDrawTopLine(false);
        n(false);
        this.f12976g.e(pair);
    }

    public void setTabWidgetViewHeight(int i) {
        FragmentTabWidget fragmentTabWidget = this.f12975f;
        if (fragmentTabWidget == null) {
            return;
        }
        fragmentTabWidget.getLayoutParams().height = i;
        this.f12975f.requestLayout();
        this.q.getLayoutParams().height = i;
        this.q.requestLayout();
        if (this.u == 1) {
            this.f12977h.getLayoutParams().height = i;
            this.f12977h.requestLayout();
        }
    }

    public void setTabWidgetViewPadding(int i, int i2, int i3, int i4) {
        this.f12975f.setPadding(i, i2, i3, i4);
    }

    public void setUIType(int i) {
        if (this.t == i) {
            return;
        }
        this.t = i;
        if (i == 1) {
            setShouldDrawTopLine(false);
            n(false);
        } else if (i == 0) {
            setShouldDrawTopLine(true);
            n(true);
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
        this.f12975f = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.f12977h = (FragmentTabSwellingView) findViewById(R.id.tab_swelling_view);
        this.f12975f.setTabSelectionListener(this);
    }

    public void setShouldDrawTopLine(boolean z, int i) {
        FragmentTabWidget fragmentTabWidget = this.f12975f;
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
