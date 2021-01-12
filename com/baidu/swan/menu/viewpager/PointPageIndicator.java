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
    protected Drawable erg;
    protected Drawable erh;
    protected Rect eri;
    protected Rect erj;
    private int erk;
    private int erl;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.erg = null;
        this.erh = null;
        this.eri = new Rect();
        this.erj = new Rect();
        this.erk = 0;
        this.mPosition = 0;
        this.erl = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erg = null;
        this.erh = null;
        this.eri = new Rect();
        this.erj = new Rect();
        this.erk = 0;
        this.mPosition = 0;
        this.erl = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erg = null;
        this.erh = null;
        this.eri = new Rect();
        this.erj = new Rect();
        this.erk = 0;
        this.mPosition = 0;
        this.erl = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator lI(int i) {
        if (this.erl != i) {
            this.erl = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator lJ(int i) {
        this.erk = i;
        return this;
    }

    public PointPageIndicator lK(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator aC(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.erg = drawable;
        this.erh = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.eri.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.erj.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.erl > 0) {
            int i = this.erl;
            int i2 = this.erk;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.eri;
            Rect rect2 = this.erj;
            Drawable drawable = this.erg;
            Drawable drawable2 = this.erh;
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
