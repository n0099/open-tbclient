package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class RoundRectPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private Paint bUW;
    private Paint bUX;
    private RectF bUY;
    private RectF bUZ;
    private float bVa;
    private float bVb;
    private boolean bVc;
    private float bVd;
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
        this.bVa = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.bVb = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.bUW.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.bUX.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.bVc = z;
        if (this.mCount == 1) {
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        this.mCurrentPosition = i;
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        c(i, f);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bVd = 0.0f;
        this.mCurrentPosition = i;
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
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
            if (this.mCount != 1 || this.bVc) {
                this.bUY.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.bVa * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bUY, this.bVb, this.bVb, this.bUW);
                this.bUZ.set(getPaddingLeft() + (this.bVa * (this.mCurrentPosition + this.bVd)), getPaddingTop(), getPaddingLeft() + (this.bVa * (this.mCurrentPosition + 1 + this.bVd)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bUZ, this.bVb, this.bVb, this.bUX);
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
        sa();
        ZO();
        c(context, attributeSet);
    }

    private void sa() {
        this.bUW = new Paint(1);
        this.bUW.setStyle(Paint.Style.FILL);
        this.bUX = new Paint(1);
        this.bUX.setStyle(Paint.Style.FILL);
    }

    private void ZO() {
        this.bUY = new RectF();
        this.bUZ = new RectF();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.bVa = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.bVb = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.bUW.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.bUX.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.bVc = obtainStyledAttributes.getBoolean(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.bVa * this.mCount) + getPaddingRight());
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
        this.bVd = f;
        invalidate();
    }
}
