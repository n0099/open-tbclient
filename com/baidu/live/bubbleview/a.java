package com.baidu.live.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
class a extends Drawable {
    private RectF aCc;
    private Path aCd;
    private float aCe;
    private float aCf;
    private float aCg;
    private float aCh;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.aCc = rectF;
        this.aCe = f;
        this.aCf = f2;
        this.aCg = f3;
        this.aCh = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aCd = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aCd, 0.0f);
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
            canvas.drawPath(this.aCd, this.mStrokePaint);
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
        return (int) this.aCc.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.aCc.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.aCf <= 0.0f) {
                    b(this.aCc, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCf) {
                    b(this.aCc, path, f);
                    return;
                } else {
                    a(this.aCc, path, f);
                    return;
                }
            case TOP:
                if (this.aCf <= 0.0f) {
                    d(this.aCc, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCf) {
                    d(this.aCc, path, f);
                    return;
                } else {
                    c(this.aCc, path, f);
                    return;
                }
            case RIGHT:
                if (this.aCf <= 0.0f) {
                    f(this.aCc, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCf) {
                    f(this.aCc, path, f);
                    return;
                } else {
                    e(this.aCc, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aCf <= 0.0f) {
                    h(this.aCc, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCf) {
                    h(this.aCc, path, f);
                    return;
                } else {
                    g(this.aCc, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aCe + rectF.left + this.aCf + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCf) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCf, rectF.top + f, rectF.right - f, this.aCf + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCf) - f);
        path.arcTo(new RectF(rectF.right - this.aCf, rectF.bottom - this.aCf, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCe + this.aCf + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aCe + f, rectF.bottom - this.aCf, this.aCf + rectF.left + this.aCe, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aCe + f, (this.aCg + this.aCh) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCh + (this.aCg / 2.0f));
        path.lineTo(rectF.left + this.aCe + f, this.aCh + (f / 2.0f));
        path.lineTo(rectF.left + this.aCe + f, rectF.top + this.aCf + f);
        path.arcTo(new RectF(rectF.left + this.aCe + f, rectF.top + f, this.aCf + rectF.left + this.aCe, this.aCf + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aCe + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCe + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCe + f, (this.aCg + this.aCh) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCh + (this.aCg / 2.0f));
        path.lineTo(rectF.left + this.aCe + f, this.aCh + (f / 2.0f));
        path.lineTo(rectF.left + this.aCe + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aCh, this.aCf) + f, rectF.top + this.aCg + f);
        path.lineTo(rectF.left + this.aCh + (f / 2.0f), rectF.top + this.aCg + f);
        path.lineTo(rectF.left + (this.aCe / 2.0f) + this.aCh, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCe) + this.aCh) - (f / 2.0f), rectF.top + this.aCg + f);
        path.lineTo((rectF.right - this.aCf) - f, rectF.top + this.aCg + f);
        path.arcTo(new RectF(rectF.right - this.aCf, rectF.top + this.aCg + f, rectF.right - f, this.aCf + rectF.top + this.aCg), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCf) - f);
        path.arcTo(new RectF(rectF.right - this.aCf, rectF.bottom - this.aCf, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCf + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCf, this.aCf + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCg + this.aCf + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aCg + f, this.aCf + rectF.left, this.aCf + rectF.top + this.aCg), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCh + f, rectF.top + this.aCg + f);
        path.lineTo(rectF.left + this.aCh + (f / 2.0f), rectF.top + this.aCg + f);
        path.lineTo(rectF.left + (this.aCe / 2.0f) + this.aCh, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCe) + this.aCh) - (f / 2.0f), rectF.top + this.aCg + f);
        path.lineTo(rectF.right - f, rectF.top + this.aCg + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aCg + f);
        path.lineTo(rectF.left + this.aCh + f, rectF.top + this.aCg + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCf + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aCf) - this.aCe) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aCf) - this.aCe, rectF.top + f, (rectF.right - this.aCe) - f, this.aCf + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aCe) - f, this.aCh + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCh + (this.aCg / 2.0f));
        path.lineTo((rectF.right - this.aCe) - f, (this.aCh + this.aCg) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCe) - f, (rectF.bottom - this.aCf) - f);
        path.arcTo(new RectF((rectF.right - this.aCf) - this.aCe, rectF.bottom - this.aCf, (rectF.right - this.aCe) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCe + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCf, this.aCf + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCf + rectF.left, this.aCf + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCe) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aCe) - f, this.aCh + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCh + (this.aCg / 2.0f));
        path.lineTo((rectF.right - this.aCe) - f, (this.aCh + this.aCg) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCe) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCf + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCf) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCf, rectF.top + f, rectF.right - f, this.aCf + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aCg) - this.aCf) - f);
        path.arcTo(new RectF(rectF.right - this.aCf, (rectF.bottom - this.aCf) - this.aCg, rectF.right - f, (rectF.bottom - this.aCg) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aCe) + this.aCh) - (f / 2.0f), (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + this.aCh + (this.aCe / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCh + (f / 2.0f), (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + Math.min(this.aCf, this.aCh) + f, (rectF.bottom - this.aCg) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aCf) - this.aCg, this.aCf + rectF.left, (rectF.bottom - this.aCg) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCf + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCf + rectF.left, this.aCf + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCg) - f);
        path.lineTo(((rectF.left + this.aCe) + this.aCh) - (f / 2.0f), (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + this.aCh + (this.aCe / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCh + (f / 2.0f), (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + this.aCh + f, (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aCg) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
