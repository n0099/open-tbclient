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
    protected Drawable doN;
    protected Drawable doO;
    protected Rect doP;
    protected Rect doQ;
    private int doR;
    private int doS;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.doN = null;
        this.doO = null;
        this.doP = new Rect();
        this.doQ = new Rect();
        this.doR = 0;
        this.mPosition = 0;
        this.doS = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doN = null;
        this.doO = null;
        this.doP = new Rect();
        this.doQ = new Rect();
        this.doR = 0;
        this.mPosition = 0;
        this.doS = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doN = null;
        this.doO = null;
        this.doP = new Rect();
        this.doQ = new Rect();
        this.doR = 0;
        this.mPosition = 0;
        this.doS = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator jj(int i) {
        if (this.doS != i) {
            this.doS = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator jk(int i) {
        this.doR = i;
        return this;
    }

    public PointPageIndicator jl(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator aw(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.doN = drawable;
        this.doO = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.doP.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.doQ.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.doS > 0) {
            int i = this.doS;
            int i2 = this.doR;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.doP;
            Rect rect2 = this.doQ;
            Drawable drawable = this.doN;
            Drawable drawable2 = this.doO;
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
