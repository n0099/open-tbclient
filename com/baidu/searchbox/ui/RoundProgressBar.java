package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes12.dex */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    private static final int MAX = 100;
    private static final int MAX_ANGLE = 360;
    private static final int MAX_PROGRESS_DEFALT_VALUE = 100;
    private static final int ROUNDWIDTH_DEFALT_VALUE = 5;
    private static final int START_ANGLE = 270;
    public static final int STROKE = 0;
    private static final int TEXTSIZE_DEFALT_VALUE = 15;
    private int mMax;
    private Paint mPaint;
    private int mProgress;
    private boolean mReverse;
    private int mRoundColor;
    private int mRoundProgressColor;
    private float mRoundWidth;
    private int mStyle;
    private int mTextColor;
    private boolean mTextIsDisplayable;
    private float mTextSize;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.loading.R.styleable.RoundProgressBar);
        this.mRoundColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundColor, SupportMenu.CATEGORY_MASK);
        this.mRoundProgressColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundProgressColor, -16711936);
        this.mTextColor = obtainStyledAttributes.getColor(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textColor, -16711936);
        this.mTextSize = obtainStyledAttributes.getDimension(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textSize, 15.0f);
        this.mRoundWidth = obtainStyledAttributes.getDimension(com.baidu.android.common.loading.R.styleable.RoundProgressBar_roundWidth, 5.0f);
        this.mMax = obtainStyledAttributes.getInteger(com.baidu.android.common.loading.R.styleable.RoundProgressBar_max, 100);
        this.mTextIsDisplayable = obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.RoundProgressBar_textIsDisplayable, true);
        this.mStyle = obtainStyledAttributes.getInt(com.baidu.android.common.loading.R.styleable.RoundProgressBar_style, 0);
        this.mReverse = obtainStyledAttributes.getBoolean(com.baidu.android.common.loading.R.styleable.RoundProgressBar_reverse, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = (int) (width - (this.mRoundWidth / 2.0f));
        this.mPaint.setColor(this.mRoundColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mRoundWidth);
        this.mPaint.setAntiAlias(true);
        canvas.drawCircle(width, width, i, this.mPaint);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(this.mTextColor);
        this.mPaint.setTextSize(this.mTextSize);
        this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        int max = (int) ((this.mProgress / getMax()) * 100.0f);
        float measureText = this.mPaint.measureText(max + "%");
        if (this.mTextIsDisplayable && max >= 0 && this.mStyle == 0) {
            canvas.drawText(max + "%", width - (measureText / 2.0f), width + (this.mTextSize / 2.0f), this.mPaint);
        }
        this.mPaint.setStrokeWidth(this.mRoundWidth);
        this.mPaint.setColor(this.mRoundProgressColor);
        RectF rectF = new RectF(width - i, width - i, width + i, width + i);
        switch (this.mStyle) {
            case 0:
                this.mPaint.setStyle(Paint.Style.STROKE);
                if (this.mReverse) {
                    canvas.drawArc(rectF, 270.0f, (this.mProgress * (-360)) / getMax(), false, this.mPaint);
                    return;
                } else {
                    canvas.drawArc(rectF, 270.0f, (this.mProgress * MAX_ANGLE) / getMax(), false, this.mPaint);
                    return;
                }
            case 1:
                this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.mProgress != 0) {
                    canvas.drawArc(rectF, 0.0f, (this.mProgress * MAX_ANGLE) / getMax(), true, this.mPaint);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public synchronized int getMax() {
        return this.mMax;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.mMax = i;
    }

    public synchronized int getProgress() {
        return this.mProgress;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.mMax) {
            i = this.mMax;
        }
        if (i <= this.mMax) {
            this.mProgress = i;
            postInvalidate();
        }
    }

    public int getCircleColor() {
        return this.mRoundColor;
    }

    public void setCircleColor(int i) {
        this.mRoundColor = i;
    }

    public int getCircleProgressColor() {
        return this.mRoundProgressColor;
    }

    public void setCircleProgressColor(int i) {
        this.mRoundProgressColor = i;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public float getRoundWidth() {
        return this.mRoundWidth;
    }

    public void setRoundWidth(float f) {
        this.mRoundWidth = f;
    }
}
