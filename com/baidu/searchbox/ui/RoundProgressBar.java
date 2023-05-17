package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes4.dex */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int MAX = 100;
    public static final float MAX_ANGLE = 360.0f;
    public static final int MAX_PROGRESS_DEFAULT_VALUE = 100;
    public static final int ROUND_WIDTH_DEFAULT_VALUE = 5;
    public static final float START_ANGLE = 270.0f;
    public static final int STROKE = 0;
    public static final int TEXT_SIZE_DEFAULT_VALUE = 15;
    public int mMax;
    public RectF mOval;
    public boolean mPaintCapRound;
    public int mProgress;
    public boolean mReverse;
    public int mRoundColor;
    public Paint mRoundPaint;
    public int mRoundProgressColor;
    public int mRoundProgressEndColor;
    public Paint mRoundProgressPaint;
    public int mRoundProgressStartColor;
    public float mRoundWidth;
    public boolean mShouldUpdateGradient;
    public int mStyle;
    public SweepGradient mSweepGradient;
    public int mTextColor;
    public boolean mTextIsDisplayable;
    public Paint mTextPaint;
    public float mTextSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public void setCircleColor(int i) {
        this.mRoundColor = i;
        postInvalidate();
    }

    public void setCircleProgressColor(int i) {
        this.mRoundProgressColor = i;
        postInvalidate();
    }

    @SuppressLint({"BDThrowableCheck"})
    public synchronized void setMax(int i) {
        if (i >= 0) {
            this.mMax = i;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public synchronized void setProgress(int i) {
        if (i >= 0) {
            if (i > this.mMax) {
                i = this.mMax;
            }
            this.mProgress = i;
            postInvalidate();
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundWidth(float f) {
        this.mRoundWidth = f;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCircleProgressGradientColor(int i, int i2) {
        this.mRoundProgressStartColor = i;
        this.mRoundProgressEndColor = i2;
        this.mShouldUpdateGradient = true;
        postInvalidate();
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.loading.R.styleable.RoundProgressBar);
        this.mRoundColor = obtainStyledAttributes.getColor(2, -65536);
        this.mRoundProgressColor = obtainStyledAttributes.getColor(5, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        this.mRoundProgressStartColor = obtainStyledAttributes.getColor(7, 0);
        this.mRoundProgressEndColor = obtainStyledAttributes.getColor(6, 0);
        this.mTextColor = obtainStyledAttributes.getColor(14, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        this.mTextSize = obtainStyledAttributes.getDimension(16, 15.0f);
        this.mRoundWidth = obtainStyledAttributes.getDimension(12, 5.0f);
        this.mMax = obtainStyledAttributes.getInteger(0, 100);
        this.mTextIsDisplayable = obtainStyledAttributes.getBoolean(15, true);
        this.mStyle = obtainStyledAttributes.getInt(13, 0);
        this.mReverse = obtainStyledAttributes.getBoolean(1, false);
        this.mPaintCapRound = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        setupConfigs();
    }

    private void setupConfigs() {
        Paint paint = new Paint();
        this.mRoundPaint = paint;
        paint.setAntiAlias(true);
        this.mRoundPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mRoundProgressPaint = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mTextPaint = paint3;
        paint3.setAntiAlias(true);
        this.mTextPaint.setStrokeWidth(0.0f);
        this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mOval = new RectF();
    }

    public int getCircleColor() {
        return this.mRoundColor;
    }

    public int getCircleProgressColor() {
        return this.mRoundProgressColor;
    }

    public synchronized int getMax() {
        return this.mMax;
    }

    public synchronized int getProgress() {
        return this.mProgress;
    }

    public float getRoundWidth() {
        return this.mRoundWidth;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i = (int) (f - (this.mRoundWidth / 2.0f));
        this.mRoundPaint.setColor(this.mRoundColor);
        this.mRoundPaint.setStrokeWidth(this.mRoundWidth);
        if (this.mPaintCapRound) {
            this.mRoundPaint.setStrokeCap(Paint.Cap.ROUND);
        }
        canvas.drawCircle(f, f, i, this.mRoundPaint);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
        int max = (int) ((this.mProgress / getMax()) * 100.0f);
        float measureText = this.mTextPaint.measureText(max + "%");
        if (this.mTextIsDisplayable && max >= 0 && this.mStyle == 0) {
            canvas.drawText(max + "%", f - (measureText / 2.0f), (this.mTextSize / 2.0f) + f, this.mTextPaint);
        }
        this.mRoundProgressPaint.setStrokeWidth(this.mRoundWidth);
        if (this.mRoundProgressStartColor != 0 && this.mRoundProgressEndColor != 0) {
            if (this.mSweepGradient == null || this.mShouldUpdateGradient) {
                int i2 = this.mRoundProgressStartColor;
                this.mSweepGradient = new SweepGradient(f, f, new int[]{i2, this.mRoundProgressEndColor, i2}, (float[]) null);
                this.mShouldUpdateGradient = false;
            }
            this.mRoundProgressPaint.setShader(this.mSweepGradient);
        } else {
            this.mRoundProgressPaint.setColor(this.mRoundProgressColor);
        }
        float f2 = width - i;
        float f3 = width + i;
        this.mOval.set(f2, f2, f3, f3);
        int i3 = this.mStyle;
        if (i3 != 0) {
            if (i3 == 1) {
                this.mRoundProgressPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                int i4 = this.mProgress;
                if (i4 != 0) {
                    canvas.drawArc(this.mOval, 0.0f, (i4 * 360.0f) / getMax(), true, this.mRoundProgressPaint);
                    return;
                }
                return;
            }
            return;
        }
        this.mRoundProgressPaint.setStyle(Paint.Style.STROKE);
        if (this.mReverse) {
            canvas.drawArc(this.mOval, 270.0f, (this.mProgress * (-360.0f)) / getMax(), false, this.mRoundProgressPaint);
        } else {
            canvas.drawArc(this.mOval, 270.0f, (this.mProgress * 360.0f) / getMax(), false, this.mRoundProgressPaint);
        }
    }
}
