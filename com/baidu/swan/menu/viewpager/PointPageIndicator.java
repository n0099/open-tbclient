package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class PointPageIndicator extends View {
    protected Drawable brp;
    protected Drawable brq;
    protected Rect brr;
    protected Rect brs;
    private int brt;
    private int bru;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.brp = null;
        this.brq = null;
        this.brr = new Rect();
        this.brs = new Rect();
        this.brt = 0;
        this.mPosition = 0;
        this.bru = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brp = null;
        this.brq = null;
        this.brr = new Rect();
        this.brs = new Rect();
        this.brt = 0;
        this.mPosition = 0;
        this.bru = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brp = null;
        this.brq = null;
        this.brr = new Rect();
        this.brs = new Rect();
        this.brt = 0;
        this.mPosition = 0;
        this.bru = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator fy(int i) {
        if (this.bru != i) {
            this.bru = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator fz(int i) {
        this.brt = i;
        return this;
    }

    public PointPageIndicator fA(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator L(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.brp = drawable;
        this.brq = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.brr.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.brs.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.bru > 0) {
            int i = this.bru;
            int i2 = this.brt;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.brr;
            Rect rect2 = this.brs;
            Drawable drawable = this.brp;
            Drawable drawable2 = this.brq;
            int width3 = (width2 - ((((i - 1) * i2) + (rect.width() * (i - 1))) + rect2.width())) / 2;
            for (int i4 = 0; i4 < i; i4++) {
                if (i4 == i3) {
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
}
