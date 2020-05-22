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
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class RoundRectPageIndicator extends View implements ViewPager.OnPageChangeListener {
    private Paint biM;
    private Paint biN;
    private RectF biO;
    private RectF biP;
    private float biQ;
    private float biR;
    private boolean biS;
    private float biT;
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
        this.biQ = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.biR = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.biM.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.biN.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.biS = z;
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
        this.biT = 0.0f;
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
            if (this.mCount != 1 || this.biS) {
                this.biO.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.biQ * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.biO, this.biR, this.biR, this.biM);
                this.biP.set(getPaddingLeft() + (this.biQ * (this.mCurrentPosition + this.biT)), getPaddingTop(), getPaddingLeft() + (this.biQ * (this.mCurrentPosition + 1 + this.biT)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.biP, this.biR, this.biR, this.biN);
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
        qy();
        Jt();
        initAttrs(context, attributeSet);
    }

    private void qy() {
        this.biM = new Paint(1);
        this.biM.setStyle(Paint.Style.FILL);
        this.biN = new Paint(1);
        this.biN.setStyle(Paint.Style.FILL);
    }

    private void Jt() {
        this.biO = new RectF();
        this.biP = new RectF();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.biQ = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.biR = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.biM.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.biN.setColor(obtainStyledAttributes.getColor(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.biS = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.biQ * this.mCount) + getPaddingRight());
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
        this.biT = f;
        invalidate();
    }
}
