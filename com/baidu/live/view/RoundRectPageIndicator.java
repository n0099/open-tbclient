package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class RoundRectPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private boolean asA;
    private float asB;
    private Paint asu;
    private Paint asv;
    private RectF asw;
    private RectF asx;
    private float asy;
    private float asz;
    private int mCount;
    private int mCurrentPosition;

    public RoundRectPageIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public void setCount(int i) {
        this.mCount = i;
        requestLayout();
        invalidate();
    }

    public void setItemWidth(float f) {
        this.asy = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.asz = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.asu.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.asv.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.asA = z;
        if (this.mCount == 1) {
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        this.mCurrentPosition = i;
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        e(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.asB = 0.0f;
        this.mCurrentPosition = i;
        invalidate();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mCount > 0) {
            if (this.mCount != 1 || this.asA) {
                this.asw.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.asy * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.asw, this.asz, this.asz, this.asu);
                this.asx.set(getPaddingLeft() + (this.asy * (this.mCurrentPosition + this.asB)), getPaddingTop(), getPaddingLeft() + (this.asy * (this.mCurrentPosition + 1 + this.asB)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.asx, this.asz, this.asz, this.asv);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instance", super.onSaveInstanceState());
        bundle.putInt("position", this.mCurrentPosition);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentPosition = bundle.getInt("position");
            super.onRestoreInstanceState(bundle.getParcelable("instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void init(Context context, AttributeSet attributeSet) {
        lj();
        wF();
        c(context, attributeSet);
    }

    private void lj() {
        this.asu = new Paint(1);
        this.asu.setStyle(Paint.Style.FILL);
        this.asv = new Paint(1);
        this.asv.setStyle(Paint.Style.FILL);
    }

    private void wF() {
        this.asw = new RectF();
        this.asx = new RectF();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.asy = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.asz = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.asu.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.asv.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.asA = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.asy * this.mCount) + getPaddingRight());
            return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        return size;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
        }
        return size;
    }

    private void e(int i, float f) {
        this.mCurrentPosition = i;
        this.asB = f;
        invalidate();
    }
}
