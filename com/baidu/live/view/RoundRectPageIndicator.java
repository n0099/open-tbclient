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
/* loaded from: classes10.dex */
public class RoundRectPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private Paint bQk;
    private Paint bQl;
    private RectF bQm;
    private RectF bQn;
    private float bQo;
    private float bQp;
    private boolean bQq;
    private float bQr;
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
        this.bQo = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.bQp = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.bQk.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.bQl.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.bQq = z;
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
        this.bQr = 0.0f;
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
            if (this.mCount != 1 || this.bQq) {
                this.bQm.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.bQo * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bQm, this.bQp, this.bQp, this.bQk);
                this.bQn.set(getPaddingLeft() + (this.bQo * (this.mCurrentPosition + this.bQr)), getPaddingTop(), getPaddingLeft() + (this.bQo * (this.mCurrentPosition + 1 + this.bQr)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bQn, this.bQp, this.bQp, this.bQl);
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
        VV();
        c(context, attributeSet);
    }

    private void sa() {
        this.bQk = new Paint(1);
        this.bQk.setStyle(Paint.Style.FILL);
        this.bQl = new Paint(1);
        this.bQl.setStyle(Paint.Style.FILL);
    }

    private void VV() {
        this.bQm = new RectF();
        this.bQn = new RectF();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.bQo = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.bQp = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.bQk.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.bQl.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.bQq = obtainStyledAttributes.getBoolean(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.bQo * this.mCount) + getPaddingRight());
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
        this.bQr = f;
        invalidate();
    }
}
