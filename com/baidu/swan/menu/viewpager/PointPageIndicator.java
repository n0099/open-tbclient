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
    private int bKA;
    protected Drawable bKv;
    protected Drawable bKw;
    protected Rect bKx;
    protected Rect bKy;
    private int bKz;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.bKv = null;
        this.bKw = null;
        this.bKx = new Rect();
        this.bKy = new Rect();
        this.bKz = 0;
        this.mPosition = 0;
        this.bKA = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKv = null;
        this.bKw = null;
        this.bKx = new Rect();
        this.bKy = new Rect();
        this.bKz = 0;
        this.mPosition = 0;
        this.bKA = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKv = null;
        this.bKw = null;
        this.bKx = new Rect();
        this.bKy = new Rect();
        this.bKz = 0;
        this.mPosition = 0;
        this.bKA = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator gx(int i) {
        if (this.bKA != i) {
            this.bKA = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator gy(int i) {
        this.bKz = i;
        return this;
    }

    public PointPageIndicator gz(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator S(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.bKv = drawable;
        this.bKw = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.bKx.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.bKy.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.bKA > 0) {
            int i = this.bKA;
            int i2 = this.bKz;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.bKx;
            Rect rect2 = this.bKy;
            Drawable drawable = this.bKv;
            Drawable drawable2 = this.bKw;
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
