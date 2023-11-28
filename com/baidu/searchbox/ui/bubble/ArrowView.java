package com.baidu.searchbox.ui.bubble;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ArrowView extends View {
    public static final int ALPHA = 204;
    public static final float ARC_SIZE = 2.0f;
    public static final int DOWN = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int UP = 2;
    public Path mArrowPath;
    public int mColor;
    public Paint mColorPaint;
    public boolean mD20Template;
    public int mDirection;

    public ArrowView(Context context) {
        this(context, null);
    }

    public float dpToPixel(float f) {
        return getResources().getDisplayMetrics().density * f;
    }

    public void enableNewTemplate(boolean z) {
        this.mD20Template = z;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mD20Template) {
            this.mArrowPath = getNewArrowPath(this.mArrowPath, this.mDirection);
        } else {
            this.mArrowPath = getArrowPath(this.mArrowPath, this.mDirection);
        }
        canvas.drawPath(this.mArrowPath, this.mColorPaint);
    }

    public void setArrowViewColor(int i) {
        this.mColor = i;
        this.mColorPaint.setColor(i);
        invalidate();
    }

    public void setDirection(int i) {
        this.mDirection = i;
        invalidate();
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        this.mD20Template = true;
        init();
    }

    @TargetApi(21)
    public ArrowView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDirection = 4;
        this.mColor = Color.argb(204, 0, 0, 0);
        this.mD20Template = true;
        init();
    }

    private Path getArrowPath(Path path, int i) {
        int i2;
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
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        float f = paddingLeft;
                        float f2 = paddingTop;
                        path.moveTo(f, f2);
                        path.lineTo(measuredWidth - paddingRight, f2);
                        path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f, measuredHeight - paddingBottom);
                        path.close();
                    }
                } else {
                    float f3 = paddingLeft;
                    float f4 = paddingTop;
                    path.moveTo(f3, f4);
                    path.lineTo(measuredWidth - paddingRight, ((i2 - paddingTop) / 2.0f) + f4);
                    path.lineTo(f3, measuredHeight - paddingBottom);
                    path.close();
                }
            } else {
                float f5 = paddingLeft;
                float f6 = measuredHeight - paddingBottom;
                path.moveTo(f5, f6);
                path.lineTo(measuredWidth - paddingRight, f6);
                path.lineTo((((measuredWidth - paddingLeft) - paddingRight) / 2.0f) + f5, paddingTop);
                path.close();
            }
        } else {
            float f7 = paddingTop;
            path.moveTo(paddingLeft, (((measuredHeight - paddingTop) - paddingBottom) / 2.0f) + f7);
            float f8 = measuredWidth - paddingRight;
            path.lineTo(f8, f7);
            path.lineTo(f8, measuredHeight - paddingBottom);
            path.close();
        }
        return path;
    }

    private Path getNewArrowPath(Path path, int i) {
        if (path == null) {
            return new Path();
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = ((measuredWidth - paddingLeft) - paddingRight) / 2.0f;
        float f2 = ((measuredHeight - paddingTop) - paddingBottom) / 2.0f;
        float dpToPixel = dpToPixel(2.0f);
        path.reset();
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        float f3 = paddingLeft;
                        float f4 = paddingTop;
                        path.moveTo(f3, f4);
                        path.lineTo(measuredWidth - paddingRight, f4);
                        float f5 = f + f3;
                        float f6 = (measuredHeight - paddingBottom) - dpToPixel;
                        path.lineTo(f5 + dpToPixel, f6);
                        path.lineTo(f5 - dpToPixel, f6);
                        path.close();
                        path.addCircle(f5, f6 - (dpToPixel / 2.0f), dpToPixel, Path.Direction.CW);
                    }
                } else {
                    float f7 = paddingLeft;
                    float f8 = paddingTop;
                    path.moveTo(f7, f8);
                    float f9 = (measuredWidth - paddingRight) - dpToPixel;
                    float f10 = f2 + f8;
                    path.lineTo(f9, f10 - dpToPixel);
                    path.lineTo(f9, f10 + dpToPixel);
                    path.lineTo(f7, measuredHeight - paddingBottom);
                    path.close();
                    path.addCircle(f9 - (dpToPixel / 2.0f), f10, dpToPixel, Path.Direction.CW);
                }
            } else {
                float f11 = paddingLeft;
                float f12 = measuredHeight - paddingBottom;
                path.moveTo(f11, f12);
                path.lineTo(measuredWidth - paddingRight, f12);
                float f13 = f + f11;
                float f14 = paddingTop + dpToPixel;
                path.lineTo(f13 + dpToPixel, f14);
                path.lineTo(f13 - dpToPixel, f14);
                path.close();
                path.addCircle(f13, f14 + (dpToPixel / 2.0f), dpToPixel, Path.Direction.CCW);
            }
        } else {
            float f15 = paddingLeft + dpToPixel;
            float f16 = paddingTop;
            float f17 = f2 + f16;
            path.moveTo(f15, f17 - dpToPixel);
            float f18 = measuredWidth - paddingRight;
            path.lineTo(f18, f16);
            path.lineTo(f18, measuredHeight - paddingBottom);
            path.lineTo(f15, f17 + dpToPixel);
            path.close();
            path.addCircle(f15 + (dpToPixel / 2.0f), f17, dpToPixel, Path.Direction.CW);
        }
        return path;
    }

    private void init() {
        this.mColor = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f060389);
        this.mArrowPath = new Path();
        Paint paint = new Paint();
        this.mColorPaint = paint;
        paint.setAntiAlias(true);
        this.mColorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mColorPaint.setColor(this.mColor);
    }
}
