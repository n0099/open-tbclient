package com.baidu.searchbox.ui.viewpager;

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
    public Drawable mNormalDrawable;
    public Rect mNormalPointRect;
    public int mPointCount;
    public int mPointMargin;
    public int mPosition;
    public Drawable mSelectDrawable;
    public Rect mSelectPointRect;

    private void init(Context context) {
    }

    public PointPageIndicator(Context context) {
        super(context);
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.mPointMargin = 0;
        this.mPosition = 0;
        this.mPointCount = 0;
        init(context);
    }

    public PointPageIndicator setCurrentPosition(int i) {
        this.mPosition = i;
        invalidate();
        return this;
    }

    public PointPageIndicator setPointCount(int i) {
        if (this.mPointCount != i) {
            this.mPointCount = i;
            invalidate();
        }
        return this;
    }

    public PointPageIndicator setPointMargin(int i) {
        this.mPointMargin = i;
        return this;
    }

    public PointPageIndicator setPointSize(int i) {
        this.mNormalPointRect.set(0, 0, i, i);
        this.mSelectPointRect.set(0, 0, i, i);
        return this;
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.mPointMargin = 0;
        this.mPosition = 0;
        this.mPointCount = 0;
        init(context);
    }

    public PointPageIndicator setPointDrawable(Drawable drawable, Drawable drawable2) {
        this.mNormalDrawable = drawable;
        this.mSelectDrawable = drawable2;
        if (drawable instanceof BitmapDrawable) {
            this.mNormalPointRect.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        if (drawable2 instanceof BitmapDrawable) {
            this.mSelectPointRect.set(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        }
        return this;
    }

    public PointPageIndicator setPointDrawableResId(int i, int i2) {
        Resources resources = getResources();
        return setPointDrawable(resources.getDrawable(i), resources.getDrawable(i2));
    }

    public PointPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalDrawable = null;
        this.mSelectDrawable = null;
        this.mNormalPointRect = new Rect();
        this.mSelectPointRect = new Rect();
        this.mPointMargin = 0;
        this.mPosition = 0;
        this.mPointCount = 0;
        init(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        int i = this.mPointCount;
        if (i <= 0) {
            return;
        }
        int i2 = this.mPointMargin;
        int height = getHeight();
        int width2 = getWidth();
        int i3 = this.mPosition;
        Rect rect = this.mNormalPointRect;
        Rect rect2 = this.mSelectPointRect;
        Drawable drawable = this.mNormalDrawable;
        Drawable drawable2 = this.mSelectDrawable;
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
