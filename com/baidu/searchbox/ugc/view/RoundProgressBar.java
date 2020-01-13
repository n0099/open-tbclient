package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.R;
/* loaded from: classes12.dex */
public class RoundProgressBar extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int mMax;
    private Paint mPaint;
    private long mProgress;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UgcRoundProgressBar);
        this.mRoundColor = obtainStyledAttributes.getColor(R.styleable.UgcRoundProgressBar_ugcroundColor, getResources().getColor(R.color.ugc_common_black));
        this.mRoundProgressColor = obtainStyledAttributes.getColor(R.styleable.UgcRoundProgressBar_ugcroundProgressColor, getResources().getColor(R.color.ugc_round_color));
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.UgcRoundProgressBar_ugctextColor, getResources().getColor(R.color.ugc_round_color));
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.UgcRoundProgressBar_ugctextSize, DeviceUtil.ScreenInfo.dp2px(getContext(), 10.0f));
        this.mRoundWidth = obtainStyledAttributes.getDimension(R.styleable.UgcRoundProgressBar_ugcroundWidth, 7.0f);
        this.mMax = obtainStyledAttributes.getInteger(R.styleable.UgcRoundProgressBar_ugcmax, 100);
        this.mTextIsDisplayable = obtainStyledAttributes.getBoolean(R.styleable.UgcRoundProgressBar_ugctextIsDisplayable, true);
        this.mStyle = obtainStyledAttributes.getInt(R.styleable.UgcRoundProgressBar_ugcstyle, 0);
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
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int i2 = (int) ((((float) this.mProgress) / this.mMax) * 100.0f);
        float measureText = this.mPaint.measureText(i2 + "%");
        if (this.mTextIsDisplayable) {
            if (i2 == 0) {
                i2 = 1;
            }
            canvas.drawText(i2 + "%", width - (measureText / 2.0f), width + (this.mTextSize / 2.0f), this.mPaint);
        }
        this.mPaint.setStrokeWidth(this.mRoundWidth);
        this.mPaint.setColor(this.mRoundProgressColor);
        RectF rectF = new RectF(width - i, width - i, width + i, width + i);
        switch (this.mStyle) {
            case 0:
                this.mPaint.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, -90.0f, (float) ((this.mProgress * 360) / this.mMax), false, this.mPaint);
                return;
            case 1:
                this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.mProgress != 0) {
                    canvas.drawArc(rectF, -90.0f, (float) ((this.mProgress * 360) / this.mMax), true, this.mPaint);
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

    public synchronized long getProgress() {
        return this.mProgress;
    }

    public synchronized void setProgress(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (j > this.mMax) {
            j = this.mMax;
        }
        if (j <= this.mMax) {
            this.mProgress = j;
            postInvalidate();
        }
    }
}
