package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes5.dex */
public class PointPageIndicator extends View {
    protected Drawable eto;
    protected Drawable etp;
    protected Rect etq;
    protected Rect etr;
    private int ets;
    private int ett;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.eto = null;
        this.etp = null;
        this.etq = new Rect();
        this.etr = new Rect();
        this.ets = 0;
        this.mPosition = 0;
        this.ett = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eto = null;
        this.etp = null;
        this.etq = new Rect();
        this.etr = new Rect();
        this.ets = 0;
        this.mPosition = 0;
        this.ett = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eto = null;
        this.etp = null;
        this.etq = new Rect();
        this.etr = new Rect();
        this.ets = 0;
        this.mPosition = 0;
        this.ett = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator lL(int i) {
        if (this.ett != i) {
            this.ett = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator lM(int i) {
        this.ets = i;
        return this;
    }

    public PointPageIndicator lN(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator az(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.eto = drawable;
        this.etp = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.etq.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.etr.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.ett > 0) {
            int i = this.ett;
            int i2 = this.ets;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.etq;
            Rect rect2 = this.etr;
            Drawable drawable = this.eto;
            Drawable drawable2 = this.etp;
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
