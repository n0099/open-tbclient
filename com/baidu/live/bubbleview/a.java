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
/* loaded from: classes11.dex */
class a extends Drawable {
    private Path aFf;
    private float aFg;
    private float aFh;
    private float aFi;
    private float aFj;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aFg = f;
        this.aFh = f2;
        this.aFi = f3;
        this.aFj = f4;
        this.mStrokeWidth = f5;
        if (i3 != 0 || i4 != 0) {
            this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (int) this.mRect.height(), i3, i4, Shader.TileMode.CLAMP));
        } else {
            this.mPaint.setColor(i2);
        }
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aFf = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aFf, 0.0f);
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
            canvas.drawPath(this.aFf, this.mStrokePaint);
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
                if (this.aFh <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFh) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aFh <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFh) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aFh <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFh) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aFh <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFh) {
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
        path.moveTo(this.aFg + rectF.left + this.aFh + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFh) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFh, rectF.top + f, rectF.right - f, this.aFh + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFh) - f);
        path.arcTo(new RectF(rectF.right - this.aFh, rectF.bottom - this.aFh, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFg + this.aFh + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aFg + f, rectF.bottom - this.aFh, this.aFh + rectF.left + this.aFg, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aFg + f, (this.aFi + this.aFj) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFj + (this.aFi / 2.0f));
        path.lineTo(rectF.left + this.aFg + f, this.aFj + (f / 2.0f));
        path.lineTo(rectF.left + this.aFg + f, rectF.top + this.aFh + f);
        path.arcTo(new RectF(rectF.left + this.aFg + f, rectF.top + f, this.aFh + rectF.left + this.aFg, this.aFh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aFg + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFg + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFg + f, (this.aFi + this.aFj) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFj + (this.aFi / 2.0f));
        path.lineTo(rectF.left + this.aFg + f, this.aFj + (f / 2.0f));
        path.lineTo(rectF.left + this.aFg + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aFj, this.aFh) + f, rectF.top + this.aFi + f);
        path.lineTo(rectF.left + this.aFj + (f / 2.0f), rectF.top + this.aFi + f);
        path.lineTo(rectF.left + (this.aFg / 2.0f) + this.aFj, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFg) + this.aFj) - (f / 2.0f), rectF.top + this.aFi + f);
        path.lineTo((rectF.right - this.aFh) - f, rectF.top + this.aFi + f);
        path.arcTo(new RectF(rectF.right - this.aFh, rectF.top + this.aFi + f, rectF.right - f, this.aFh + rectF.top + this.aFi), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFh) - f);
        path.arcTo(new RectF(rectF.right - this.aFh, rectF.bottom - this.aFh, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFh + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFh, this.aFh + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFi + this.aFh + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aFi + f, this.aFh + rectF.left, this.aFh + rectF.top + this.aFi), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFj + f, rectF.top + this.aFi + f);
        path.lineTo(rectF.left + this.aFj + (f / 2.0f), rectF.top + this.aFi + f);
        path.lineTo(rectF.left + (this.aFg / 2.0f) + this.aFj, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFg) + this.aFj) - (f / 2.0f), rectF.top + this.aFi + f);
        path.lineTo(rectF.right - f, rectF.top + this.aFi + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aFi + f);
        path.lineTo(rectF.left + this.aFj + f, rectF.top + this.aFi + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFh + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aFh) - this.aFg) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aFh) - this.aFg, rectF.top + f, (rectF.right - this.aFg) - f, this.aFh + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aFg) - f, this.aFj + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFj + (this.aFi / 2.0f));
        path.lineTo((rectF.right - this.aFg) - f, (this.aFj + this.aFi) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFg) - f, (rectF.bottom - this.aFh) - f);
        path.arcTo(new RectF((rectF.right - this.aFh) - this.aFg, rectF.bottom - this.aFh, (rectF.right - this.aFg) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFg + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFh, this.aFh + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFh + rectF.left, this.aFh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFg) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aFg) - f, this.aFj + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFj + (this.aFi / 2.0f));
        path.lineTo((rectF.right - this.aFg) - f, (this.aFj + this.aFi) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFg) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFh + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFh) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFh, rectF.top + f, rectF.right - f, this.aFh + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aFi) - this.aFh) - f);
        path.arcTo(new RectF(rectF.right - this.aFh, (rectF.bottom - this.aFh) - this.aFi, rectF.right - f, (rectF.bottom - this.aFi) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aFg) + this.aFj) - (f / 2.0f), (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + this.aFj + (this.aFg / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFj + (f / 2.0f), (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + Math.min(this.aFh, this.aFj) + f, (rectF.bottom - this.aFi) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aFh) - this.aFi, this.aFh + rectF.left, (rectF.bottom - this.aFi) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFh + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFh + rectF.left, this.aFh + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFi) - f);
        path.lineTo(((rectF.left + this.aFg) + this.aFj) - (f / 2.0f), (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + this.aFj + (this.aFg / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFj + (f / 2.0f), (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + this.aFj + f, (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aFi) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
