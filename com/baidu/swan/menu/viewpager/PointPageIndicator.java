package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes11.dex */
public class PointPageIndicator extends View {
    private int cAa;
    protected Drawable czV;
    protected Drawable czW;
    protected Rect czX;
    protected Rect czY;
    private int czZ;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.czV = null;
        this.czW = null;
        this.czX = new Rect();
        this.czY = new Rect();
        this.czZ = 0;
        this.mPosition = 0;
        this.cAa = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czV = null;
        this.czW = null;
        this.czX = new Rect();
        this.czY = new Rect();
        this.czZ = 0;
        this.mPosition = 0;
        this.cAa = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czV = null;
        this.czW = null;
        this.czX = new Rect();
        this.czY = new Rect();
        this.czZ = 0;
        this.mPosition = 0;
        this.cAa = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator iy(int i) {
        if (this.cAa != i) {
            this.cAa = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator iz(int i) {
        this.czZ = i;
        return this;
    }

    public PointPageIndicator iA(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator ar(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.czV = drawable;
        this.czW = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.czX.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.czY.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.cAa > 0) {
            int i = this.cAa;
            int i2 = this.czZ;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.czX;
            Rect rect2 = this.czY;
            Drawable drawable = this.czV;
            Drawable drawable2 = this.czW;
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
