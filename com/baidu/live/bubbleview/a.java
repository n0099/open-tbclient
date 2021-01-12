package com.baidu.live.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* loaded from: classes10.dex */
class a extends Drawable {
    private Path aDs;
    private float aDt;
    private float aDu;
    private float aDv;
    private float aDw;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aDt = f;
        this.aDu = f2;
        this.aDv = f3;
        this.aDw = f4;
        this.mStrokeWidth = f5;
        if (i3 != 0 || i4 != 0) {
            this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getIntrinsicHeight(), i3, i4, Shader.TileMode.CLAMP));
        } else {
            this.mPaint.setColor(i2);
        }
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aDs = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aDs, 0.0f);
            return;
        }
        a(arrowDirection, this.mPath, 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mStrokeWidth > 0.0f) {
            canvas.drawPath(this.aDs, this.mStrokePaint);
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mRect.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mRect.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.aDu <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aDu) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aDu <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aDu) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aDu <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aDu) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aDu <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aDu) {
                    h(this.mRect, path, f);
                    return;
                } else {
                    g(this.mRect, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aDt + rectF.left + this.aDu + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aDu) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aDu, rectF.top + f, rectF.right - f, this.aDu + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aDu) - f);
        path.arcTo(new RectF(rectF.right - this.aDu, rectF.bottom - this.aDu, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aDt + this.aDu + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aDt + f, rectF.bottom - this.aDu, this.aDu + rectF.left + this.aDt, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aDt + f, (this.aDv + this.aDw) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aDw + (this.aDv / 2.0f));
        path.lineTo(rectF.left + this.aDt + f, this.aDw + (f / 2.0f));
        path.lineTo(rectF.left + this.aDt + f, rectF.top + this.aDu + f);
        path.arcTo(new RectF(rectF.left + this.aDt + f, rectF.top + f, this.aDu + rectF.left + this.aDt, this.aDu + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aDt + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aDt + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aDt + f, (this.aDv + this.aDw) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aDw + (this.aDv / 2.0f));
        path.lineTo(rectF.left + this.aDt + f, this.aDw + (f / 2.0f));
        path.lineTo(rectF.left + this.aDt + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aDw, this.aDu) + f, rectF.top + this.aDv + f);
        path.lineTo(rectF.left + this.aDw + (f / 2.0f), rectF.top + this.aDv + f);
        path.lineTo(rectF.left + (this.aDt / 2.0f) + this.aDw, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aDt) + this.aDw) - (f / 2.0f), rectF.top + this.aDv + f);
        path.lineTo((rectF.right - this.aDu) - f, rectF.top + this.aDv + f);
        path.arcTo(new RectF(rectF.right - this.aDu, rectF.top + this.aDv + f, rectF.right - f, this.aDu + rectF.top + this.aDv), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aDu) - f);
        path.arcTo(new RectF(rectF.right - this.aDu, rectF.bottom - this.aDu, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aDu + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aDu, this.aDu + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aDv + this.aDu + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aDv + f, this.aDu + rectF.left, this.aDu + rectF.top + this.aDv), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aDw + f, rectF.top + this.aDv + f);
        path.lineTo(rectF.left + this.aDw + (f / 2.0f), rectF.top + this.aDv + f);
        path.lineTo(rectF.left + (this.aDt / 2.0f) + this.aDw, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aDt) + this.aDw) - (f / 2.0f), rectF.top + this.aDv + f);
        path.lineTo(rectF.right - f, rectF.top + this.aDv + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aDv + f);
        path.lineTo(rectF.left + this.aDw + f, rectF.top + this.aDv + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aDu + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aDu) - this.aDt) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aDu) - this.aDt, rectF.top + f, (rectF.right - this.aDt) - f, this.aDu + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aDt) - f, this.aDw + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aDw + (this.aDv / 2.0f));
        path.lineTo((rectF.right - this.aDt) - f, (this.aDw + this.aDv) - (f / 2.0f));
        path.lineTo((rectF.right - this.aDt) - f, (rectF.bottom - this.aDu) - f);
        path.arcTo(new RectF((rectF.right - this.aDu) - this.aDt, rectF.bottom - this.aDu, (rectF.right - this.aDt) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aDt + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aDu, this.aDu + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aDu + rectF.left, this.aDu + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aDt) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aDt) - f, this.aDw + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aDw + (this.aDv / 2.0f));
        path.lineTo((rectF.right - this.aDt) - f, (this.aDw + this.aDv) - (f / 2.0f));
        path.lineTo((rectF.right - this.aDt) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aDu + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aDu) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aDu, rectF.top + f, rectF.right - f, this.aDu + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aDv) - this.aDu) - f);
        path.arcTo(new RectF(rectF.right - this.aDu, (rectF.bottom - this.aDu) - this.aDv, rectF.right - f, (rectF.bottom - this.aDv) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aDt) + this.aDw) - (f / 2.0f), (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + this.aDw + (this.aDt / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aDw + (f / 2.0f), (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + Math.min(this.aDu, this.aDw) + f, (rectF.bottom - this.aDv) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aDu) - this.aDv, this.aDu + rectF.left, (rectF.bottom - this.aDv) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aDu + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aDu + rectF.left, this.aDu + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aDv) - f);
        path.lineTo(((rectF.left + this.aDt) + this.aDw) - (f / 2.0f), (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + this.aDw + (this.aDt / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aDw + (f / 2.0f), (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + this.aDw + f, (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aDv) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
