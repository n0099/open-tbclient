package com.baidu.searchbox.ui.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes3.dex */
public class ArrowView extends View {
    private static final int ALPHA = 204;
    public static final int DOWN = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int UP = 2;
    private Path mArrowPath;
    private int mColor;
    private Paint mColorPaint;
    private int mDirection;

    public ArrowView(Context context) {
        this(context, null);
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        init();
    }

    @TargetApi(21)
    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        init();
    }

    public void setDirection(int i) {
        this.mDirection = i;
        invalidate();
    }

    public void setArrowViewColor(int i) {
        this.mColor = i;
        this.mColorPaint.setColor(this.mColor);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mArrowPath = getArrowPath(this.mArrowPath, this.mDirection);
        canvas.drawPath(this.mArrowPath, this.mColorPaint);
    }

    private void init() {
        this.mArrowPath = new Path();
        this.mColorPaint = new Paint();
        this.mColorPaint.setAntiAlias(true);
        this.mColorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mColorPaint.setColor(this.mColor);
    }

    private Path getArrowPath(Path path, int i) {
        if (path == null) {
            return new Path();
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        path.reset();
        switch (i) {
            case 1:
                path.moveTo(paddingLeft, (((measuredHeight - paddingTop) - paddingBottom) / 2.0f) + paddingTop);
                path.lineTo(measuredWidth - paddingRight, paddingTop);
                path.lineTo(measuredWidth - paddingRight, measuredHeight - paddingBottom);
                path.close();
                return path;
            case 2:
                path.moveTo(paddingLeft, measuredHeight - paddingBottom);
                path.lineTo(measuredWidth - paddingRight, measuredHeight - paddingBottom);
                path.lineTo(paddingLeft + (((measuredWidth - paddingLeft) - paddingRight) / 2.0f), paddingTop);
                path.close();
                return path;
            case 3:
                path.moveTo(paddingLeft, paddingTop);
                path.lineTo(measuredWidth - paddingRight, paddingTop + (((measuredHeight - paddingBottom) - paddingTop) / 2.0f));
                path.lineTo(paddingLeft, measuredHeight - paddingBottom);
                path.close();
                return path;
            case 4:
                path.moveTo(paddingLeft, paddingTop);
                path.lineTo(measuredWidth - paddingRight, paddingTop);
                path.lineTo(paddingLeft + (((measuredWidth - paddingLeft) - paddingRight) / 2.0f), measuredHeight - paddingBottom);
                path.close();
                return path;
            default:
                return path;
        }
    }
}
