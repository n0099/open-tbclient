package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class PointPageIndicator extends View {

    /* renamed from: e  reason: collision with root package name */
    public Drawable f12683e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f12684f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f12685g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f12686h;
    public int i;
    public int j;
    public int k;

    public PointPageIndicator(Context context) {
        super(context);
        this.f12683e = null;
        this.f12684f = null;
        this.f12685g = new Rect();
        this.f12686h = new Rect();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }

    public final void a(Context context) {
    }

    public PointPageIndicator b(int i) {
        this.j = i;
        invalidate();
        return this;
    }

    public PointPageIndicator c(int i) {
        if (this.k != i) {
            this.k = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        this.f12683e = drawable;
        this.f12684f = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.f12685g.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.f12686h.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    public PointPageIndicator e(int i, int i2) {
        Resources resources = getResources();
        return d(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator f(int i) {
        this.i = i;
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        int i = this.k;
        if (i <= 0) {
            return;
        }
        int i2 = this.i;
        int height = getHeight();
        int width2 = getWidth();
        int i3 = this.j;
        Rect rect = this.f12685g;
        Rect rect2 = this.f12686h;
        Drawable drawable = this.f12683e;
        Drawable drawable2 = this.f12684f;
        int i4 = i - 1;
        int width3 = (width2 - (((i2 * i4) + (rect.width() * i4)) + rect2.width())) / 2;
        for (int i5 = 0; i5 < i; i5++) {
            if (i5 == i3) {
                if (drawable2 != null) {
                    rect2.offsetTo(width3, (height - rect2.height()) / 2);
                    drawable2.setBounds(rect2);
                    drawable2.draw(canvas);
                }
                width = rect2.width();
            } else {
                if (drawable != null) {
                    rect.offsetTo(width3, (height - rect.height()) / 2);
                    drawable.setBounds(rect);
                    drawable.draw(canvas);
                }
                width = rect.width();
            }
            width3 += width + i2;
        }
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12683e = null;
        this.f12684f = null;
        this.f12685g = new Rect();
        this.f12686h = new Rect();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12683e = null;
        this.f12684f = null;
        this.f12685g = new Rect();
        this.f12686h = new Rect();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }
}
