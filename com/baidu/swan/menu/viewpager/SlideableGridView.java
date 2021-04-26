package com.baidu.swan.menu.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import d.a.h0.i.g;
import d.a.h0.i.h;
/* loaded from: classes3.dex */
public class SlideableGridView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f12591e;

    /* renamed from: f  reason: collision with root package name */
    public int f12592f;

    /* renamed from: g  reason: collision with root package name */
    public int f12593g;

    /* renamed from: h  reason: collision with root package name */
    public int f12594h;

    /* renamed from: i  reason: collision with root package name */
    public int f12595i;
    public a j;
    public ViewPager k;
    public PointPageIndicator l;
    public int[] m;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public abstract int a(int i2);

        public abstract View b(int i2, int i3, View view, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i2);

        public abstract void e(int i2, int i3, View view);

        public abstract void f(SlideableGridView slideableGridView);
    }

    /* loaded from: classes3.dex */
    public class b extends PagerAdapterImpl {

        /* renamed from: c  reason: collision with root package name */
        public Context f12596c;

        public b(Context context) {
            this.f12596c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void b(View view, int i2) {
            ((GridPageView) view).c(SlideableGridView.this.j.a(i2), i2);
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View c(ViewGroup viewGroup, int i2) {
            GridPageView gridPageView = new GridPageView(this.f12596c);
            gridPageView.setGridItemAdapter(SlideableGridView.this.j);
            gridPageView.setPadding(SlideableGridView.this.f12592f, SlideableGridView.this.f12594h, SlideableGridView.this.f12593g, SlideableGridView.this.f12595i);
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
        public void onPageSelected(int i2) {
            SlideableGridView.this.l.b(i2);
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
        int i2 = !z ? this.m[0] : this.m[1];
        this.l.c(c2);
        this.l.setVisibility(z ? 0 : 4);
        this.l.getLayoutParams().height = i2;
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

    public void setCurrentPage(int i2) {
        ViewPager viewPager = this.k;
        if (viewPager == null || this.l == null) {
            return;
        }
        viewPager.setCurrentItem(i2);
        this.l.b(i2);
    }

    public void setGridItemAdapter(a aVar) {
        this.j = aVar;
        if (aVar != null) {
            aVar.f(this);
            b bVar = this.f12591e;
            if (bVar == null) {
                b bVar2 = new b(getContext());
                this.f12591e = bVar2;
                this.k.setAdapter(bVar2);
            } else {
                bVar.notifyDataSetChanged();
            }
            this.l.c(aVar.c());
        } else {
            b bVar3 = this.f12591e;
            if (bVar3 != null) {
                bVar3.notifyDataSetChanged();
            }
        }
        h();
    }

    public void setGridViewPading(int i2, int i3, int i4, int i5) {
        this.f12592f = i2;
        this.f12593g = i4;
        this.f12594h = i3;
        this.f12595i = i5;
    }

    public void setIndicatorColor(int i2, int i3) {
        PointPageIndicator pointPageIndicator = this.l;
        if (pointPageIndicator != null) {
            pointPageIndicator.e(i2, i3);
        }
    }

    public void setPageIndicatorHeight(int i2, int i3) {
        int[] iArr = this.m;
        iArr[0] = i2;
        iArr[1] = i3;
        requestLayout();
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = null;
        this.l = null;
        this.m = new int[2];
        p(context);
    }
}
