package com.baidu.swan.apps.publisher.emoji.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import d.a.l0.a.c;
import d.a.l0.a.d;
/* loaded from: classes3.dex */
public class CircleIndicator extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f11013e;

    /* renamed from: f  reason: collision with root package name */
    public int f11014f;

    /* renamed from: g  reason: collision with root package name */
    public int f11015g;

    /* renamed from: h  reason: collision with root package name */
    public int f11016h;

    /* renamed from: i  reason: collision with root package name */
    public int f11017i;
    public int j;
    public int k;
    public Paint l;
    public int m;
    public ViewPager n;
    public int o;
    public int p;
    public final ViewPager.OnPageChangeListener q;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            d.a.l0.a.w1.h.a.g(CircleIndicator.this.getContext().getApplicationContext()).k();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.0f) {
                CircleIndicator.this.f(i2, f2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            CircleIndicator.this.f11014f = i2;
        }
    }

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public final void b(Canvas canvas) {
        this.l.setColor(this.o);
        for (int i2 = 0; i2 < this.f11013e; i2++) {
            int i3 = this.f11016h;
            canvas.drawCircle(this.j + (this.f11015g * i2), i3, i3, this.l);
        }
    }

    public final void c() {
        int count = this.n.getAdapter().getCount();
        this.f11013e = count;
        if (count <= 0) {
            return;
        }
        int i2 = this.m;
        int i3 = this.f11015g;
        this.j = (i2 - ((count - 1) * i3)) / 2;
        this.f11016h = i3 / 5;
        invalidate();
    }

    public final void d(Canvas canvas) {
        this.l.setColor(this.p);
        int i2 = (this.j + this.k) - (this.f11015g / 2);
        canvas.drawRoundRect(new RectF(i2, 0, this.f11017i + i2, (this.f11016h * 2) + 0), 10.0f, 10.0f, this.l);
    }

    public final void e() {
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.o = getResources().getColor(c.swanapp_emotion_circle_indicator);
        this.p = getResources().getColor(c.swanapp_emotion_circle_indicator_highlight);
        this.f11015g = getResources().getDimensionPixelSize(d.aiapps_circle_inter_width);
    }

    public void f(int i2, float f2) {
        this.k = (int) (this.f11015g * (f2 + i2));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        d(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.m = i2;
        int i6 = this.f11015g;
        this.j = (i2 - ((this.f11013e - 1) * i6)) / 2;
        this.f11016h = i6 / 5;
        this.f11017i = i6;
    }

    public void setViewPager(ViewPager viewPager) {
        this.n = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        c();
        this.n.removeOnPageChangeListener(this.q);
        this.n.addOnPageChangeListener(this.q);
        this.n.getCurrentItem();
        invalidate();
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11013e = 1;
        this.k = 0;
        this.q = new a();
        e();
    }
}
