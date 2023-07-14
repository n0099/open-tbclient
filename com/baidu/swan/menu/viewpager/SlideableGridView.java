package com.baidu.swan.menu.viewpager;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SlideableGridView extends LinearLayout {
    public b a;
    public a b;
    public int c;
    public int d;
    public int e;
    public int f;
    public ViewPager g;
    public PointPageIndicator h;
    public int[] i;

    /* loaded from: classes4.dex */
    public static abstract class a {
        public abstract int a(int i);

        public abstract View b(int i, int i2, View view2, ViewGroup viewGroup);

        public abstract int c();

        public abstract int d(int i);

        public abstract void e(int i, int i2, View view2);

        public abstract void f(SlideableGridView slideableGridView);
    }

    public int f() {
        return -1;
    }

    public int h() {
        return -2;
    }

    public int j() {
        return -1;
    }

    /* loaded from: classes4.dex */
    public class b extends PagerAdapterImpl {
        public Context c;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public b(Context context) {
            this.c = context;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public void onConfigItem(View view2, int i) {
            ((GridPageView) view2).a(SlideableGridView.this.b.a(i), i);
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl
        public View onInstantiateItem(ViewGroup viewGroup, int i) {
            GridPageView gridPageView = new GridPageView(this.c);
            gridPageView.setGridItemAdapter(SlideableGridView.this.b);
            SlideableGridView slideableGridView = SlideableGridView.this;
            gridPageView.setPadding(slideableGridView.c, slideableGridView.e, slideableGridView.d, slideableGridView.f);
            return gridPageView;
        }

        @Override // com.baidu.swan.menu.viewpager.PagerAdapterImpl, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            a aVar = SlideableGridView.this.b;
            if (aVar != null) {
                return aVar.c();
            }
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ViewPager.SimpleOnPageChangeListener {
        public c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SlideableGridView.this.h.b(i);
        }
    }

    public SlideableGridView(Context context) {
        this(context, null);
    }

    public void b(Context context) {
        ViewPager g = g(context);
        this.g = g;
        g.setOffscreenPageLimit(0);
        this.g.setOnPageChangeListener(new c());
        this.g.setOverScrollMode(2);
        addView(this.g, i());
    }

    public ViewPager g(Context context) {
        return new WrapContentHeightViewPager(context);
    }

    public void k(Context context) {
        setOrientation(1);
        b(context);
        a(context);
    }

    public void setCurrentPage(int i) {
        ViewPager viewPager = this.g;
        if (viewPager != null && this.h != null) {
            viewPager.setCurrentItem(i);
            this.h.b(i);
        }
    }

    public SlideableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setIndicatorColor(int i, int i2) {
        PointPageIndicator pointPageIndicator = this.h;
        if (pointPageIndicator != null) {
            pointPageIndicator.e(i, i2);
        }
    }

    public void setPageIndicatorHeight(int i, int i2) {
        int[] iArr = this.i;
        iArr[0] = i;
        iArr[1] = i2;
        requestLayout();
    }

    @TargetApi(11)
    public SlideableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = null;
        this.h = null;
        this.i = new int[2];
        k(context);
    }

    public void a(Context context) {
        PointPageIndicator e = new PointPageIndicator(context).e(R.drawable.obfuscated_res_0x7f080116, R.drawable.obfuscated_res_0x7f080117);
        e.f((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07024c));
        this.h = e;
        this.i[0] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07024a);
        this.i[1] = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07024b);
        addView(this.h, e());
    }

    public void c() {
        int c2;
        boolean z;
        int i;
        a aVar = this.b;
        int i2 = 0;
        if (aVar == null) {
            c2 = 0;
        } else {
            c2 = aVar.c();
        }
        if (c2 > 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i = this.i[0];
        } else {
            i = this.i[1];
        }
        this.h.c(c2);
        PointPageIndicator pointPageIndicator = this.h;
        if (!z) {
            i2 = 4;
        }
        pointPageIndicator.setVisibility(i2);
        this.h.getLayoutParams().height = i;
    }

    public int d() {
        return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07024a);
    }

    public LinearLayout.LayoutParams e() {
        return new LinearLayout.LayoutParams(f(), d());
    }

    public a getGridItemAdapter() {
        return this.b;
    }

    public PointPageIndicator getPageindicator() {
        return this.h;
    }

    public LinearLayout.LayoutParams i() {
        return new LinearLayout.LayoutParams(j(), h());
    }

    public void setGridItemAdapter(a aVar) {
        this.b = aVar;
        if (aVar != null) {
            aVar.f(this);
            b bVar = this.a;
            if (bVar == null) {
                b bVar2 = new b(getContext());
                this.a = bVar2;
                this.g.setAdapter(bVar2);
            } else {
                bVar.notifyDataSetChanged();
            }
            this.h.c(aVar.c());
        } else {
            b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.notifyDataSetChanged();
            }
        }
        c();
    }

    public void setGridViewPading(int i, int i2, int i3, int i4) {
        this.c = i;
        this.d = i3;
        this.e = i2;
        this.f = i4;
    }
}
