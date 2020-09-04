package com.baidu.swan.menu.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes14.dex */
public class PointPageIndicator extends View {
    protected Drawable dEE;
    protected Drawable dEF;
    protected Rect dEG;
    protected Rect dEH;
    private int dEI;
    private int dEJ;
    private int mPosition;

    public PointPageIndicator(Context context) {
        super(context);
        this.dEE = null;
        this.dEF = null;
        this.dEG = new Rect();
        this.dEH = new Rect();
        this.dEI = 0;
        this.mPosition = 0;
        this.dEJ = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEE = null;
        this.dEF = null;
        this.dEG = new Rect();
        this.dEH = new Rect();
        this.dEI = 0;
        this.mPosition = 0;
        this.dEJ = 0;
        init(context);
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEE = null;
        this.dEF = null;
        this.dEG = new Rect();
        this.dEH = new Rect();
        this.dEI = 0;
        this.mPosition = 0;
        this.dEJ = 0;
        init(context);
    }

    private void init(Context context) {
    }

    public PointPageIndicator lI(int i) {
        if (this.dEJ != i) {
            this.dEJ = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator lJ(int i) {
        this.dEI = i;
        return this;
    }

    public PointPageIndicator lK(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator aD(int i, int i2) {
        Resources resources = getResources();
        return b(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator b(Drawable drawable, Drawable drawable2) {
        this.dEE = drawable;
        this.dEF = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.dEG.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.dEH.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        if (this.dEJ > 0) {
            int i = this.dEJ;
            int i2 = this.dEI;
            int height = getHeight();
            int width2 = getWidth();
            int i3 = this.mPosition;
            Rect rect = this.dEG;
            Rect rect2 = this.dEH;
            Drawable drawable = this.dEE;
            Drawable drawable2 = this.dEF;
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
