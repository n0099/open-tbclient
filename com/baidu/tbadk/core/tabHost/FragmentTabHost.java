package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements ViewPager.OnPageChangeListener, c {
    private Context a;
    private LayoutInflater b;
    private FragmentTabWidget c;
    private int d;
    private b e;
    private FragmentManager f;
    private final List<b> g;
    private ViewPager.OnPageChangeListener h;
    private ViewPager i;
    private a j;

    public FragmentTabHost(Context context) {
        super(context);
        this.g = new ArrayList();
        this.h = null;
        a(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList();
        this.h = null;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.b = (LayoutInflater) this.a.getSystemService("layout_inflater");
        this.b.inflate(w.fragment_tabhost, (ViewGroup) this, true);
        this.d = -1;
        this.e = null;
    }

    public void setup(FragmentManager fragmentManager) {
        this.f = fragmentManager;
        this.c = (FragmentTabWidget) findViewById(v.tabcontainer);
        this.c.setTabSelectionListener(this);
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
        if (!this.g.contains(bVar)) {
            this.c.addView(bVar.b, i);
            if (i == -1) {
                this.g.add(bVar);
            } else {
                this.g.add(i, bVar);
            }
            if (this.d != -1 && i <= this.d) {
                this.d++;
            }
        }
    }

    public void a() {
        if (this.i != null) {
            removeView(this.i);
        }
        this.i = new ViewPager(this.a);
        this.i.setId(v.tab_content);
        this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(this.i);
        this.i.setOffscreenPageLimit(this.g.size() - 1);
        this.i.setOnPageChangeListener(this);
        this.j = new a(this.f, this.g);
        this.i.setAdapter(this.j);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.h = onPageChangeListener;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.g.size() && i != this.d) {
            this.d = i;
            this.e = this.g.get(this.d);
            this.c.a(this.d, true);
            this.i.setCurrentItem(this.d, false);
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.g.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.g.get(i3).a) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.d == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void a(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.c.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.d;
    }

    public int getCurrentTabType() {
        if (this.d < 0 || this.d >= this.g.size()) {
            return -1;
        }
        return this.g.get(this.d).a;
    }

    public Fragment getCurrentFragment() {
        if (this.e != null) {
            return this.e.c;
        }
        return null;
    }

    public void b() {
        FragmentTransaction beginTransaction = this.f.beginTransaction();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            Fragment findFragmentByTag = this.f.findFragmentByTag(a(this.i.getId(), this.j.getItemId(i)));
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
        this.g.clear();
        this.e = null;
        this.d = -1;
        this.c.a();
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void a(int i) {
        this.c.a(i);
        for (b bVar : this.g) {
            bVar.b.a(i);
        }
        if (this.j != null) {
            int count = this.j.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                Fragment item = this.j.getItem(i2);
                if (item != null && (item instanceof com.baidu.tbadk.core.d)) {
                    ((com.baidu.tbadk.core.d) item).b(i);
                }
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.h != null) {
            this.h.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.c.a(i, f);
        if (this.h != null) {
            this.h.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.h != null) {
            this.h.onPageSelected(i);
        }
        this.d = i;
        this.e = this.g.get(i);
        this.c.a(this.d, false);
        ViewGroup viewGroup = (ViewGroup) this.e.c.getView();
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof FragmentTabRootView) {
                ((FragmentTabRootView) childAt).a(0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
