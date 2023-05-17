package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class PointPageIndicator extends View {
    public Drawable a;
    public Drawable b;
    public Rect c;
    public Rect d;
    public int e;
    public int f;
    public int g;

    public final void a(Context context) {
    }

    public PointPageIndicator(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = new Rect();
        this.d = new Rect();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        a(context);
    }

    public PointPageIndicator b(int i) {
        this.f = i;
        invalidate();
        return this;
    }

    public PointPageIndicator c(int i) {
        if (this.g != i) {
            this.g = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator f(int i) {
        this.e = i;
        return this;
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = new Rect();
        this.d = new Rect();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        a(context);
    }

    public PointPageIndicator d(Drawable drawable, Drawable drawable2) {
        this.a = drawable;
        this.b = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.c.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.d.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    public PointPageIndicator e(int i, int i2) {
        Resources resources = getResources();
        return d(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = new Rect();
        this.d = new Rect();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        a(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        int i = this.g;
        if (i <= 0) {
            return;
        }
        int i2 = this.e;
        int height = getHeight();
        int width2 = getWidth();
        int i3 = this.f;
        Rect rect = this.c;
        Rect rect2 = this.d;
        Drawable drawable = this.a;
        Drawable drawable2 = this.b;
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
}
