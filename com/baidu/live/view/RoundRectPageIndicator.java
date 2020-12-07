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
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class RoundRectPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private Paint bPS;
    private Paint bPT;
    private RectF bPU;
    private RectF bPV;
    private float bPW;
    private float bPX;
    private boolean bPY;
    private float bPZ;
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
        this.bPW = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.bPX = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.bPS.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.bPT.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.bPY = z;
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
        c(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bPZ = 0.0f;
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
            if (this.mCount != 1 || this.bPY) {
                this.bPU.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.bPW * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bPU, this.bPX, this.bPX, this.bPS);
                this.bPV.set(getPaddingLeft() + (this.bPW * (this.mCurrentPosition + this.bPZ)), getPaddingTop(), getPaddingLeft() + (this.bPW * (this.mCurrentPosition + 1 + this.bPZ)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bPV, this.bPX, this.bPX, this.bPT);
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
        sz();
        YD();
        initAttrs(context, attributeSet);
    }

    private void sz() {
        this.bPS = new Paint(1);
        this.bPS.setStyle(Paint.Style.FILL);
        this.bPT = new Paint(1);
        this.bPT.setStyle(Paint.Style.FILL);
    }

    private void YD() {
        this.bPU = new RectF();
        this.bPV = new RectF();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.bPW = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.bPX = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.bPS.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.bPT.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.bPY = obtainStyledAttributes.getBoolean(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.bPW * this.mCount) + getPaddingRight());
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

    private void c(int i, float f) {
        this.mCurrentPosition = i;
        this.bPZ = f;
        invalidate();
    }
}
