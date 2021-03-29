package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import d.b.g0.i.g;
import d.b.g0.i.h;
/* loaded from: classes3.dex */
public class SlideableGridView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f13018e;

    /* renamed from: f  reason: collision with root package name */
    public int f13019f;

    /* renamed from: g  reason: collision with root package name */
    public int f13020g;

    /* renamed from: h  reason: collision with root package name */
    public int f13021h;
    public int i;
    public a j;
    public ViewPager k;
    public PointPageIndicator l;
    public int[] m;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract int a(int i);

        public abstract View b(int i, int i2, View view, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i);

        public abstract void e(int i, int i2, View view);

        public abstract void f(SlideableGridView slideableGridView);
    }

    /* loaded from: classes3.dex */
    public class b extends PagerAdapterImpl {

        /* renamed from: c  reason: collision with root package name */
        public Context f13022c;

        public b(Context context) {
            this.f13022c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void a(View view, int i) {
            ((GridPageView) view).c(SlideableGridView.this.j.a(i), i);
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View b(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.f13022c);
            gridPageView.setGridItemAdapter(SlideableGridView.this.j);
            gridPageView.setPadding(SlideableGridView.this.f13019f, SlideableGridView.this.f13021h, SlideableGridView.this.f13020g, SlideableGridView.this.i);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (SlideableGridView.this.j != null) {
                return SlideableGridView.this.j.c();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.l.b(i);
        }
    }

    public SlideableGridView(Context context) {
        this(context, null);
    }

    public void f(Context context) {
        PointPageIndicator e2 = new PointPageIndicator(context).e(h.aiapp_menu_slide_indicator_normal, h.aiapp_menu_slide_indicator_selected);
        e2.f((int) getResources().getDimension(g.common_grid_indicator_margin));
        this.l = e2;
        this.m[0] = (int) getResources().getDimension(g.common_grid_indicator_height);
        this.m[1] = (int) getResources().getDimension(g.common_grid_indicator_height2);
        addView(this.l, j());
    }

    public void g(Context context) {
        ViewPager l = l(context);
        this.k = l;
        l.setOffscreenPageLimit(0);
        this.k.setOnPageChangeListener(new c());
        this.k.setOverScrollMode(2);
        addView(this.k, n());
    }

    public a getGridItemAdapter() {
        return this.j;
    }

    public PointPageIndicator getPageindicator() {
        return this.l;
    }

    public void h() {
        a aVar = this.j;
        int c2 = aVar == null ? 0 : aVar.c();
        boolean z = c2 > 1;
        int i = !z ? this.m[0] : this.m[1];
        this.l.c(c2);
        this.l.setVisibility(z ? 0 : 4);
        this.l.getLayoutParams().height = i;
    }

    public int i() {
        return (int) getResources().getDimension(g.common_grid_indicator_height);
    }

    public LinearLayout.LayoutParams j() {
        return new LinearLayout.LayoutParams(k(), i());
    }

    public int k() {
        return -1;
    }

    public ViewPager l(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    public int m() {
        return -2;
    }

    public LinearLayout.LayoutParams n() {
        return new LinearLayout.LayoutParams(o(), m());
    }

    public int o() {
        return -1;
    }

    public void p(Context context) {
        setOrientation(1);
        g(context);
        f(context);
    }

    public void setCurrentPage(int i) {
        ViewPager viewPager = this.k;
        if (viewPager == null || this.l == null) {
            return;
        }
        viewPager.setCurrentItem(i);
        this.l.b(i);
    }

    public void setGridItemAdapter(a aVar) {
        this.j = aVar;
        if (aVar != null) {
            aVar.f(this);
            b bVar = this.f13018e;
            if (bVar == null) {
                b bVar2 = new b(getContext());
                this.f13018e = bVar2;
                this.k.setAdapter(bVar2);
            } else {
                bVar.notifyDataSetChanged();
            }
            this.l.c(aVar.c());
        } else {
            b bVar3 = this.f13018e;
            if (bVar3 != null) {
                bVar3.notifyDataSetChanged();
            }
        }
        h();
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.f13019f = i;
        this.f13020g = i3;
        this.f13021h = i2;
        this.i = i4;
    }

    public void setIndicatorColor(int i, int i2) {
        PointPageIndicator pointPageIndicator = this.l;
        if (pointPageIndicator != null) {
            pointPageIndicator.e(i, i2);
        }
    }

    public void setPageIndicatorHeight(int i, int i2) {
        int[] iArr = this.m;
        iArr[0] = i;
        iArr[1] = i2;
        requestLayout();
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = null;
        this.l = null;
        this.m = new int[2];
        p(context);
    }
}
