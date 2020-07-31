package com.baidu.live.tbadk.coreextra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class CircleProgressView extends View {
    private Paint backgroundPaint;
    private int currentProgress;
    private Paint foregroundPaint;
    private boolean isAntiClockwiseProgress;
    private RectF oval;
    private float strokeWidth;

    public CircleProgressView(Context context) {
        super(context);
        this.strokeWidth = 5.0f;
        this.isAntiClockwiseProgress = true;
        initVariable();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.strokeWidth = 5.0f;
        this.isAntiClockwiseProgress = true;
        initVariable();
    }

    private void initVariable() {
        this.oval = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.foregroundPaint = new Paint();
        this.foregroundPaint.setAntiAlias(true);
        this.foregroundPaint.setDither(true);
        this.foregroundPaint.setStyle(Paint.Style.STROKE);
        this.foregroundPaint.setStrokeCap(Paint.Cap.ROUND);
        this.foregroundPaint.setStrokeWidth(this.strokeWidth);
        this.backgroundPaint = new Paint();
        this.backgroundPaint.setAntiAlias(true);
        this.backgroundPaint.setDither(true);
        this.backgroundPaint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint.setStrokeCap(Paint.Cap.ROUND);
        this.backgroundPaint.setStrokeWidth(this.strokeWidth);
    }

    public void setCircleBackgroundColor(int i) {
        this.backgroundPaint.setColor(i);
        postInvalidate();
    }

    public void setCircleForegroundColor(int i) {
        this.foregroundPaint.setColor(i);
        postInvalidate();
    }

    public void setWidth(int i) {
        this.strokeWidth = i;
        this.backgroundPaint.setStrokeWidth(i);
        this.foregroundPaint.setStrokeWidth(i);
        postInvalidate();
    }

    public void setAntiClockwiseProgress(boolean z) {
        this.isAntiClockwiseProgress = z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.currentProgress >= 0) {
            this.oval.left = this.strokeWidth;
            this.oval.top = this.strokeWidth;
            this.oval.right = getWidth() - this.strokeWidth;
            this.oval.bottom = getHeight() - this.strokeWidth;
            canvas.drawArc(this.oval, 0.0f, 360.0f, false, this.backgroundPaint);
            if (this.isAntiClockwiseProgress) {
                canvas.drawArc(this.oval, -90.0f, 360.0f * (-(this.currentProgress / 100)), false, this.foregroundPaint);
            } else {
                canvas.drawArc(this.oval, -90.0f, 360.0f * (this.currentProgress / 100), false, this.foregroundPaint);
            }
        }
    }

    public void setProgress(int i) {
        this.currentProgress = i;
        postInvalidate();
    }
}
