package com.baidu.live.tieba.view.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
class a extends Drawable {
    private RectF awY;
    private Path awZ;
    private float axa;
    private float axb;
    private float axc;
    private float axd;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.awY = rectF;
        this.axa = f;
        this.axb = f2;
        this.axc = f3;
        this.axd = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.awZ = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.awZ, 0.0f);
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
            canvas.drawPath(this.awZ, this.mStrokePaint);
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
        return (int) this.awY.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.awY.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.axb <= 0.0f) {
                    b(this.awY, path, f);
                    return;
                } else if (f > 0.0f && f > this.axb) {
                    b(this.awY, path, f);
                    return;
                } else {
                    a(this.awY, path, f);
                    return;
                }
            case TOP:
                if (this.axb <= 0.0f) {
                    d(this.awY, path, f);
                    return;
                } else if (f > 0.0f && f > this.axb) {
                    d(this.awY, path, f);
                    return;
                } else {
                    c(this.awY, path, f);
                    return;
                }
            case RIGHT:
                if (this.axb <= 0.0f) {
                    f(this.awY, path, f);
                    return;
                } else if (f > 0.0f && f > this.axb) {
                    f(this.awY, path, f);
                    return;
                } else {
                    e(this.awY, path, f);
                    return;
                }
            case BOTTOM:
                if (this.axb <= 0.0f) {
                    h(this.awY, path, f);
                    return;
                } else if (f > 0.0f && f > this.axb) {
                    h(this.awY, path, f);
                    return;
                } else {
                    g(this.awY, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.axa + rectF.left + this.axb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.axb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.axb, rectF.top + f, rectF.right - f, this.axb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.axb) - f);
        path.arcTo(new RectF(rectF.right - this.axb, rectF.bottom - this.axb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.axa + this.axb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.axa + f, rectF.bottom - this.axb, this.axb + rectF.left + this.axa, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.axa + f, (this.axc + this.axd) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.axd + (this.axc / 2.0f));
        path.lineTo(rectF.left + this.axa + f, this.axd + (f / 2.0f));
        path.lineTo(rectF.left + this.axa + f, rectF.top + this.axb + f);
        path.arcTo(new RectF(rectF.left + this.axa + f, rectF.top + f, this.axb + rectF.left + this.axa, this.axb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.axa + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.axa + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.axa + f, (this.axc + this.axd) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.axd + (this.axc / 2.0f));
        path.lineTo(rectF.left + this.axa + f, this.axd + (f / 2.0f));
        path.lineTo(rectF.left + this.axa + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.axd, this.axb) + f, rectF.top + this.axc + f);
        path.lineTo(rectF.left + this.axd + (f / 2.0f), rectF.top + this.axc + f);
        path.lineTo(rectF.left + (this.axa / 2.0f) + this.axd, rectF.top + f + f);
        path.lineTo(((rectF.left + this.axa) + this.axd) - (f / 2.0f), rectF.top + this.axc + f);
        path.lineTo((rectF.right - this.axb) - f, rectF.top + this.axc + f);
        path.arcTo(new RectF(rectF.right - this.axb, rectF.top + this.axc + f, rectF.right - f, this.axb + rectF.top + this.axc), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.axb) - f);
        path.arcTo(new RectF(rectF.right - this.axb, rectF.bottom - this.axb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.axb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.axb, this.axb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.axc + this.axb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.axc + f, this.axb + rectF.left, this.axb + rectF.top + this.axc), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.axd + f, rectF.top + this.axc + f);
        path.lineTo(rectF.left + this.axd + (f / 2.0f), rectF.top + this.axc + f);
        path.lineTo(rectF.left + (this.axa / 2.0f) + this.axd, rectF.top + f + f);
        path.lineTo(((rectF.left + this.axa) + this.axd) - (f / 2.0f), rectF.top + this.axc + f);
        path.lineTo(rectF.right - f, rectF.top + this.axc + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.axc + f);
        path.lineTo(rectF.left + this.axd + f, rectF.top + this.axc + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.axb + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.axb) - this.axa) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.axb) - this.axa, rectF.top + f, (rectF.right - this.axa) - f, this.axb + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.axa) - f, this.axd + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.axd + (this.axc / 2.0f));
        path.lineTo((rectF.right - this.axa) - f, (this.axd + this.axc) - (f / 2.0f));
        path.lineTo((rectF.right - this.axa) - f, (rectF.bottom - this.axb) - f);
        path.arcTo(new RectF((rectF.right - this.axb) - this.axa, rectF.bottom - this.axb, (rectF.right - this.axa) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.axa + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.axb, this.axb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.axb + rectF.left, this.axb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.axa) - f, rectF.top + f);
        path.lineTo((rectF.right - this.axa) - f, this.axd + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.axd + (this.axc / 2.0f));
        path.lineTo((rectF.right - this.axa) - f, (this.axd + this.axc) - (f / 2.0f));
        path.lineTo((rectF.right - this.axa) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.axb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.axb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.axb, rectF.top + f, rectF.right - f, this.axb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.axc) - this.axb) - f);
        path.arcTo(new RectF(rectF.right - this.axb, (rectF.bottom - this.axb) - this.axc, rectF.right - f, (rectF.bottom - this.axc) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.axa) + this.axd) - (f / 2.0f), (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + this.axd + (this.axa / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.axd + (f / 2.0f), (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + Math.min(this.axb, this.axd) + f, (rectF.bottom - this.axc) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.axb) - this.axc, this.axb + rectF.left, (rectF.bottom - this.axc) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.axb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.axb + rectF.left, this.axb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.axc) - f);
        path.lineTo(((rectF.left + this.axa) + this.axd) - (f / 2.0f), (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + this.axd + (this.axa / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.axd + (f / 2.0f), (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + this.axd + f, (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.axc) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
