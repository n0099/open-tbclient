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
    private Paint asM;
    private Paint asN;
    private RectF asO;
    private RectF asP;
    private float asQ;
    private float asR;
    private boolean asS;
    private float asT;
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
        this.asQ = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.asR = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.asM.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.asN.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.asS = z;
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
        this.asT = 0.0f;
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
            if (this.mCount != 1 || this.asS) {
                this.asO.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.asQ * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.asO, this.asR, this.asR, this.asM);
                this.asP.set(getPaddingLeft() + (this.asQ * (this.mCurrentPosition + this.asT)), getPaddingTop(), getPaddingLeft() + (this.asQ * (this.mCurrentPosition + 1 + this.asT)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.asP, this.asR, this.asR, this.asN);
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
        wE();
        c(context, attributeSet);
    }

    private void lj() {
        this.asM = new Paint(1);
        this.asM.setStyle(Paint.Style.FILL);
        this.asN = new Paint(1);
        this.asN.setStyle(Paint.Style.FILL);
    }

    private void wE() {
        this.asO = new RectF();
        this.asP = new RectF();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.asQ = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.asR = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.asM.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.asN.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.asS = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.asQ * this.mCount) + getPaddingRight());
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
        this.asT = f;
        invalidate();
    }
}
