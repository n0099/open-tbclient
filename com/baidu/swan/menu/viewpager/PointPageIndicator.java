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
    protected Drawable euP;
    protected Drawable euQ;
    protected Rect euR;
    protected Rect euS;
    private int euT;
    private int euU;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.euP = null;
        this.euQ = null;
        this.euR = new Rect();
        this.euS = new Rect();
        this.euT = 0;
        this.mPosition = 0;
        this.euU = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euP = null;
        this.euQ = null;
        this.euR = new Rect();
        this.euS = new Rect();
        this.euT = 0;
        this.mPosition = 0;
        this.euU = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euP = null;
        this.euQ = null;
        this.euR = new Rect();
        this.euS = new Rect();
        this.euT = 0;
        this.mPosition = 0;
        this.euU = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator lM(int i) {
        if (this.euU != i) {
            this.euU = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator lN(int i) {
        this.euT = i;
        return this;
    }

    public PointPageIndicator lO(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator az(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.euP = drawable;
        this.euQ = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.euR.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.euS.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.euU > 0) {
            int i = this.euU;
            int i2 = this.euT;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.euR;
            Rect rect2 = this.euS;
            Drawable drawable = this.euP;
            Drawable drawable2 = this.euQ;
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
