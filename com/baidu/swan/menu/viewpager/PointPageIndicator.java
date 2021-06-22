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
    public Drawable f11973e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f11974f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f11975g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f11976h;

    /* renamed from: i  reason: collision with root package name */
    public int f11977i;
    public int j;
    public int k;

    public PointPageIndicator(Context context) {
        super(context);
        this.f11973e = null;
        this.f11974f = null;
        this.f11975g = new Rect();
        this.f11976h = new Rect();
        this.f11977i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }

    public final void a(Context context) {
    }

    public PointPageIndicator b(int i2) {
        this.j = i2;
        invalidate();
        return this;
    }

    public PointPageIndicator c(int i2) {
        if (this.k != i2) {
            this.k = i2;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        this.f11973e = drawable;
        this.f11974f = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.f11975g.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.f11976h.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    public PointPageIndicator e(int i2, int i3) {
        Resources resources = getResources();
        return d(resources.getDrawable(i2), resources.getDrawable(i3));
    }

    public PointPageIndicator f(int i2) {
        this.f11977i = i2;
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        int i2 = this.k;
        if (i2 <= 0) {
            return;
        }
        int i3 = this.f11977i;
        int height = getHeight();
        int width2 = getWidth();
        int i4 = this.j;
        Rect rect = this.f11975g;
        Rect rect2 = this.f11976h;
        Drawable drawable = this.f11973e;
        Drawable drawable2 = this.f11974f;
        int i5 = i2 - 1;
        int width3 = (width2 - (((i3 * i5) + (rect.width() * i5)) + rect2.width())) / 2;
        for (int i6 = 0; i6 < i2; i6++) {
            if (i6 == i4) {
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
            width3 += width + i3;
        }
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11973e = null;
        this.f11974f = null;
        this.f11975g = new Rect();
        this.f11976h = new Rect();
        this.f11977i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11973e = null;
        this.f11974f = null;
        this.f11975g = new Rect();
        this.f11976h = new Rect();
        this.f11977i = 0;
        this.j = 0;
        this.k = 0;
        a(context);
    }
}
