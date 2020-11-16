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
    private Paint bKM;
    private Paint bKN;
    private RectF bKO;
    private RectF bKP;
    private float bKQ;
    private float bKR;
    private boolean bKS;
    private float bKT;
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
        this.bKQ = f;
        invalidate();
    }

    public void setItemRadius(float f) {
        this.bKR = f;
        invalidate();
    }

    public void setTrackColor(int i) {
        this.bKM.setColor(i);
        invalidate();
    }

    public void setSlideColor(int i) {
        this.bKN.setColor(i);
        invalidate();
    }

    public void setSingleShow(boolean z) {
        this.bKS = z;
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
        this.bKT = 0.0f;
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
            if (this.mCount != 1 || this.bKS) {
                this.bKO.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + (this.bKQ * this.mCount), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bKO, this.bKR, this.bKR, this.bKM);
                this.bKP.set(getPaddingLeft() + (this.bKQ * (this.mCurrentPosition + this.bKT)), getPaddingTop(), getPaddingLeft() + (this.bKQ * (this.mCurrentPosition + 1 + this.bKT)), getHeight() - getPaddingBottom());
                canvas.drawRoundRect(this.bKP, this.bKR, this.bKR, this.bKN);
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
        sw();
        Wd();
        initAttrs(context, attributeSet);
    }

    private void sw() {
        this.bKM = new Paint(1);
        this.bKM.setStyle(Paint.Style.FILL);
        this.bKN = new Paint(1);
        this.bKN.setStyle(Paint.Style.FILL);
    }

    private void Wd() {
        this.bKO = new RectF();
        this.bKP = new RectF();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.sdk_RoundRectPageIndicator);
            this.mCount = obtainStyledAttributes.getInteger(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_count, 0);
            this.bKQ = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_width, 0);
            this.bKR = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_item_radius, 0);
            this.bKM.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_track_color, 0));
            this.bKN.setColor(obtainStyledAttributes.getColor(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_slide_color, 0));
            this.bKS = obtainStyledAttributes.getBoolean(a.j.sdk_RoundRectPageIndicator_sdk_rrpi_single_show, false);
            obtainStyledAttributes.recycle();
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int paddingLeft = (int) (getPaddingLeft() + (this.bKQ * this.mCount) + getPaddingRight());
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
        this.bKT = f;
        invalidate();
    }
}
