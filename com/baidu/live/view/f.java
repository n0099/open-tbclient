package com.baidu.live.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class f extends Drawable {
    private int[] bTD;
    private int[] bTE;
    private int mAlpha = 255;
    private ColorFilter mColorFilter;
    private float mCornerRadius;
    private Paint mFillPaint;
    private RectF mRectF;
    private Paint mStrokePaint;

    public f() {
        init();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float strokeWidth = this.mStrokePaint.getStrokeWidth();
        this.mRectF.set(bounds.left + (strokeWidth * 0.5f), bounds.top + (strokeWidth * 0.5f), bounds.right - (strokeWidth * 0.5f), bounds.bottom - (strokeWidth * 0.5f));
        this.mFillPaint.setShader(new LinearGradient(bounds.left + strokeWidth, bounds.top + strokeWidth, bounds.right - strokeWidth, bounds.top + strokeWidth, this.bTD, (float[]) null, Shader.TileMode.CLAMP));
        this.mStrokePaint.setShader(new LinearGradient(this.mRectF.left, this.mRectF.top, this.mRectF.right, this.mRectF.top, this.bTE, (float[]) null, Shader.TileMode.CLAMP));
        this.mStrokePaint.setStrokeWidth(strokeWidth);
        float min = Math.min(this.mCornerRadius, Math.min(this.mRectF.width(), this.mRectF.height()) * 0.5f);
        canvas.drawRoundRect(this.mRectF, min, min, this.mFillPaint);
        if (strokeWidth > 0.0f) {
            canvas.drawRoundRect(this.mRectF, min, min, this.mStrokePaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            this.mFillPaint.setAlpha(this.mAlpha);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (colorFilter != this.mColorFilter) {
            this.mColorFilter = colorFilter;
            this.mFillPaint.setColorFilter(this.mColorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        switch (this.mAlpha) {
            case 0:
                return -2;
            case 255:
                return -1;
            default:
                return -3;
        }
    }

    public void N(int i, int i2) {
        setColors(new int[]{i, i2});
    }

    public void setColors(int[] iArr) {
        f(iArr, new int[]{0, 0});
    }

    public void setColors(int i, int i2, int i3, int i4) {
        f(new int[]{i, i2}, new int[]{i3, i4});
    }

    public void f(int[] iArr, int[] iArr2) {
        this.bTD = iArr;
        this.bTE = iArr2;
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        this.mCornerRadius = f;
        invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.mStrokePaint.setStrokeWidth(f);
        invalidateSelf();
    }

    public void O(int i, int i2) {
        this.mStrokePaint.setStrokeWidth(i);
        this.mStrokePaint.setAlpha(i2);
        invalidateSelf();
    }

    private void init() {
        this.mFillPaint = new Paint(1);
        this.mFillPaint.setStyle(Paint.Style.FILL);
        this.mStrokePaint = new Paint(1);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mRectF = new RectF();
    }
}
