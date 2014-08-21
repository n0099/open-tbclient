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
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private Context a;
    private FragmentTabWidget b;
    private int c;
    private b d;
    private FragmentManager e;
    private final List<b> f;
    private ViewPager.OnPageChangeListener g;
    private ViewPager h;
    private a i;

    public FragmentTabHost(Context context) {
        super(context);
        this.f = new ArrayList();
        this.g = null;
        a(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new ArrayList();
        this.g = null;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        com.baidu.adp.lib.e.b.a().a(context, v.fragment_tabhost, this, true);
        this.c = -1;
        this.d = null;
    }

    public void setup(FragmentManager fragmentManager) {
        this.e = fragmentManager;
        this.b = (FragmentTabWidget) findViewById(u.tabcontainer);
        this.b.setTabSelectionListener(this);
    }

    public void a(b bVar) {
        a(bVar, -1);
    }

    public void a(b bVar, int i) {
        if (bVar.b == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (bVar.c == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.f.contains(bVar)) {
            this.b.addView(bVar.b, i);
            if (i == -1) {
                this.f.add(bVar);
            } else {
                this.f.add(i, bVar);
            }
            if (this.c != -1 && i <= this.c) {
                this.c++;
            }
        }
    }

    public void a() {
        if (this.h != null) {
            removeView(this.h);
        }
        this.h = new ViewPager(this.a);
        this.h.setId(u.tab_content);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.h);
        this.h.setOffscreenPageLimit(this.f.size() - 1);
        this.h.setOnPageChangeListener(this);
        this.i = new a(this.e, this.f);
        this.h.setAdapter(this.i);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.g = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.f.size() && i != this.c) {
            this.c = i;
            this.d = this.f.get(this.c);
            this.b.a(this.c, true);
            this.h.setCurrentItem(this.c, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.f.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.f.get(i3).a) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.c == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void a(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.c;
    }

    public int getCurrentTabType() {
        if (this.c < 0 || this.c >= this.f.size()) {
            return -1;
        }
        return this.f.get(this.c).a;
    }

    public Fragment getCurrentFragment() {
        if (this.d != null) {
            return this.d.c;
        }
        return null;
    }

    public FragmentTabWidget getFragmentTabWidget() {
        return this.b;
    }

    public b a(int i) {
        for (b bVar : this.f) {
            if (i == bVar.a) {
                return bVar;
            }
        }
        return null;
    }

    public void b() {
        FragmentTransaction beginTransaction = this.e.beginTransaction();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.e.findFragmentByTag(a(this.h.getId(), this.i.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.f.clear();
        this.d = null;
        this.c = -1;
        this.b.a();
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void b(int i) {
        this.b.a(i);
        for (b bVar : this.f) {
            bVar.b.a(i);
        }
        if (this.i != null) {
            int count = this.i.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.i.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.g != null) {
            this.g.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.b.a(i, f);
        if (this.g != null) {
            this.g.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.g != null) {
            this.g.onPageSelected(i);
        }
        this.c = i;
        this.d = this.f.get(i);
        this.b.a(this.c, false);
        ViewGroup viewGroup = (ViewGroup) this.d.c.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
