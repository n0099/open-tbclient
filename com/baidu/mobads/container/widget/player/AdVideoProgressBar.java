package com.baidu.mobads.container.widget.player;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class AdVideoProgressBar extends View {
    public static final int MAX_PROGRESS = 100;
    public final Rect bounds;
    public Paint mPaint;
    public float mProgress;
    public int mProgressBackgroundColor;
    public int mProgressColor;
    public int mProgressHeight;

    public AdVideoProgressBar(Context context) {
        super(context);
        this.mProgressColor = -7829368;
        this.mProgressBackgroundColor = -16777216;
        this.mProgressHeight = 4;
        this.mPaint = new Paint();
        this.bounds = new Rect();
    }

    public float getProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        getDrawingRect(this.bounds);
        Rect rect = this.bounds;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mProgressHeight);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setAlpha(204);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mProgressBackgroundColor);
        Rect rect2 = this.bounds;
        float f2 = (rect.top + rect.bottom) / 2;
        canvas.drawLine(rect2.left, f2, rect2.right, f2, this.mPaint);
        this.mPaint.setColor(this.mProgressColor);
        canvas.drawLine(this.bounds.left, f2, i2 + ((int) (((rect.right - rect.left) * this.mProgress) / 100.0f)), f2, this.mPaint);
    }

    public void setProgress(float f2) {
        this.mProgress = f2 * 100.0f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.mProgressBackgroundColor = i2;
    }

    public void setProgressColor(int i2) {
        this.mProgressColor = i2;
    }

    public void setProgressHeight(int i2) {
        this.mProgressHeight = i2;
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressColor = -7829368;
        this.mProgressBackgroundColor = -16777216;
        this.mProgressHeight = 4;
        this.mPaint = new Paint();
        this.bounds = new Rect();
    }

    public AdVideoProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mProgressColor = -7829368;
        this.mProgressBackgroundColor = -16777216;
        this.mProgressHeight = 4;
        this.mPaint = new Paint();
        this.bounds = new Rect();
    }
}
