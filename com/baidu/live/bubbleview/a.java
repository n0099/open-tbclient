package com.baidu.live.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
class a extends Drawable {
    private Path aFe;
    private float aFf;
    private float aFg;
    private float aFh;
    private float aFi;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aFf = f;
        this.aFg = f2;
        this.aFh = f3;
        this.aFi = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aFe = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aFe, 0.0f);
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
            canvas.drawPath(this.aFe, this.mStrokePaint);
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
                if (this.aFg <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFg) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aFg <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFg) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aFg <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFg) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aFg <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aFg) {
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
        path.moveTo(this.aFf + rectF.left + this.aFg + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFg) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFg, rectF.top + f, rectF.right - f, this.aFg + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFg) - f);
        path.arcTo(new RectF(rectF.right - this.aFg, rectF.bottom - this.aFg, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFf + this.aFg + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aFf + f, rectF.bottom - this.aFg, this.aFg + rectF.left + this.aFf, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aFf + f, (this.aFh + this.aFi) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFi + (this.aFh / 2.0f));
        path.lineTo(rectF.left + this.aFf + f, this.aFi + (f / 2.0f));
        path.lineTo(rectF.left + this.aFf + f, rectF.top + this.aFg + f);
        path.arcTo(new RectF(rectF.left + this.aFf + f, rectF.top + f, this.aFg + rectF.left + this.aFf, this.aFg + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aFf + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFf + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aFf + f, (this.aFh + this.aFi) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aFi + (this.aFh / 2.0f));
        path.lineTo(rectF.left + this.aFf + f, this.aFi + (f / 2.0f));
        path.lineTo(rectF.left + this.aFf + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aFi, this.aFg) + f, rectF.top + this.aFh + f);
        path.lineTo(rectF.left + this.aFi + (f / 2.0f), rectF.top + this.aFh + f);
        path.lineTo(rectF.left + (this.aFf / 2.0f) + this.aFi, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFf) + this.aFi) - (f / 2.0f), rectF.top + this.aFh + f);
        path.lineTo((rectF.right - this.aFg) - f, rectF.top + this.aFh + f);
        path.arcTo(new RectF(rectF.right - this.aFg, rectF.top + this.aFh + f, rectF.right - f, this.aFg + rectF.top + this.aFh), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFg) - f);
        path.arcTo(new RectF(rectF.right - this.aFg, rectF.bottom - this.aFg, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFg + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFg, this.aFg + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFh + this.aFg + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aFh + f, this.aFg + rectF.left, this.aFg + rectF.top + this.aFh), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFi + f, rectF.top + this.aFh + f);
        path.lineTo(rectF.left + this.aFi + (f / 2.0f), rectF.top + this.aFh + f);
        path.lineTo(rectF.left + (this.aFf / 2.0f) + this.aFi, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aFf) + this.aFi) - (f / 2.0f), rectF.top + this.aFh + f);
        path.lineTo(rectF.right - f, rectF.top + this.aFh + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aFh + f);
        path.lineTo(rectF.left + this.aFi + f, rectF.top + this.aFh + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFg + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aFg) - this.aFf) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aFg) - this.aFf, rectF.top + f, (rectF.right - this.aFf) - f, this.aFg + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aFf) - f, this.aFi + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFi + (this.aFh / 2.0f));
        path.lineTo((rectF.right - this.aFf) - f, (this.aFi + this.aFh) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFf) - f, (rectF.bottom - this.aFg) - f);
        path.arcTo(new RectF((rectF.right - this.aFg) - this.aFf, rectF.bottom - this.aFg, (rectF.right - this.aFf) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aFf + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aFg, this.aFg + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFg + rectF.left, this.aFg + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFf) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aFf) - f, this.aFi + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aFi + (this.aFh / 2.0f));
        path.lineTo((rectF.right - this.aFf) - f, (this.aFi + this.aFh) - (f / 2.0f));
        path.lineTo((rectF.right - this.aFf) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aFg + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aFg) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aFg, rectF.top + f, rectF.right - f, this.aFg + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aFh) - this.aFg) - f);
        path.arcTo(new RectF(rectF.right - this.aFg, (rectF.bottom - this.aFg) - this.aFh, rectF.right - f, (rectF.bottom - this.aFh) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aFf) + this.aFi) - (f / 2.0f), (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + this.aFi + (this.aFf / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFi + (f / 2.0f), (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + Math.min(this.aFg, this.aFi) + f, (rectF.bottom - this.aFh) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aFg) - this.aFh, this.aFg + rectF.left, (rectF.bottom - this.aFh) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aFg + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aFg + rectF.left, this.aFg + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aFh) - f);
        path.lineTo(((rectF.left + this.aFf) + this.aFi) - (f / 2.0f), (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + this.aFi + (this.aFf / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aFi + (f / 2.0f), (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + this.aFi + f, (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aFh) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
