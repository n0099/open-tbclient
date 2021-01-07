package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class PointPageIndicator extends View {
    protected Drawable evU;
    protected Drawable evV;
    protected Rect evW;
    protected Rect evX;
    private int evY;
    private int evZ;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.evU = null;
        this.evV = null;
        this.evW = new Rect();
        this.evX = new Rect();
        this.evY = 0;
        this.mPosition = 0;
        this.evZ = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evU = null;
        this.evV = null;
        this.evW = new Rect();
        this.evX = new Rect();
        this.evY = 0;
        this.mPosition = 0;
        this.evZ = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evU = null;
        this.evV = null;
        this.evW = new Rect();
        this.evX = new Rect();
        this.evY = 0;
        this.mPosition = 0;
        this.evZ = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator no(int i) {
        if (this.evZ != i) {
            this.evZ = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator np(int i) {
        this.evY = i;
        return this;
    }

    public PointPageIndicator nq(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator aC(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.evU = drawable;
        this.evV = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.evW.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.evX.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.evZ > 0) {
            int i = this.evZ;
            int i2 = this.evY;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.evW;
            Rect rect2 = this.evX;
            Drawable drawable = this.evU;
            Drawable drawable2 = this.evV;
            int width3 = (width2 - ((((i - 1) * i2) + (rect.width() * (i - 1))) + rect2.width())) / 2;
            int i4 = 0;
            while (i4 < i) {
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
                i4++;
                width3 = width + i2 + width3;
            }
        }
    }
}
