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
    private Path aGP;
    private float aGQ;
    private float aGR;
    private float aGS;
    private float aGT;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aGQ = f;
        this.aGR = f2;
        this.aGS = f3;
        this.aGT = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aGP = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aGP, 0.0f);
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
            canvas.drawPath(this.aGP, this.mStrokePaint);
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
                if (this.aGR <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGR) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aGR <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGR) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aGR <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGR) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aGR <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGR) {
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
        path.moveTo(this.aGQ + rectF.left + this.aGR + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGR) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGR, rectF.top + f, rectF.right - f, this.aGR + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGR) - f);
        path.arcTo(new RectF(rectF.right - this.aGR, rectF.bottom - this.aGR, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGQ + this.aGR + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aGQ + f, rectF.bottom - this.aGR, this.aGR + rectF.left + this.aGQ, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aGQ + f, (this.aGS + this.aGT) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGT + (this.aGS / 2.0f));
        path.lineTo(rectF.left + this.aGQ + f, this.aGT + (f / 2.0f));
        path.lineTo(rectF.left + this.aGQ + f, rectF.top + this.aGR + f);
        path.arcTo(new RectF(rectF.left + this.aGQ + f, rectF.top + f, this.aGR + rectF.left + this.aGQ, this.aGR + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aGQ + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGQ + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGQ + f, (this.aGS + this.aGT) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGT + (this.aGS / 2.0f));
        path.lineTo(rectF.left + this.aGQ + f, this.aGT + (f / 2.0f));
        path.lineTo(rectF.left + this.aGQ + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aGT, this.aGR) + f, rectF.top + this.aGS + f);
        path.lineTo(rectF.left + this.aGT + (f / 2.0f), rectF.top + this.aGS + f);
        path.lineTo(rectF.left + (this.aGQ / 2.0f) + this.aGT, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGQ) + this.aGT) - (f / 2.0f), rectF.top + this.aGS + f);
        path.lineTo((rectF.right - this.aGR) - f, rectF.top + this.aGS + f);
        path.arcTo(new RectF(rectF.right - this.aGR, rectF.top + this.aGS + f, rectF.right - f, this.aGR + rectF.top + this.aGS), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGR) - f);
        path.arcTo(new RectF(rectF.right - this.aGR, rectF.bottom - this.aGR, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGR + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGR, this.aGR + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGS + this.aGR + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aGS + f, this.aGR + rectF.left, this.aGR + rectF.top + this.aGS), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGT + f, rectF.top + this.aGS + f);
        path.lineTo(rectF.left + this.aGT + (f / 2.0f), rectF.top + this.aGS + f);
        path.lineTo(rectF.left + (this.aGQ / 2.0f) + this.aGT, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGQ) + this.aGT) - (f / 2.0f), rectF.top + this.aGS + f);
        path.lineTo(rectF.right - f, rectF.top + this.aGS + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aGS + f);
        path.lineTo(rectF.left + this.aGT + f, rectF.top + this.aGS + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGR + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aGR) - this.aGQ) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aGR) - this.aGQ, rectF.top + f, (rectF.right - this.aGQ) - f, this.aGR + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aGQ) - f, this.aGT + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGT + (this.aGS / 2.0f));
        path.lineTo((rectF.right - this.aGQ) - f, (this.aGT + this.aGS) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGQ) - f, (rectF.bottom - this.aGR) - f);
        path.arcTo(new RectF((rectF.right - this.aGR) - this.aGQ, rectF.bottom - this.aGR, (rectF.right - this.aGQ) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGQ + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGR, this.aGR + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGR + rectF.left, this.aGR + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGQ) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aGQ) - f, this.aGT + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGT + (this.aGS / 2.0f));
        path.lineTo((rectF.right - this.aGQ) - f, (this.aGT + this.aGS) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGQ) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGR + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGR) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGR, rectF.top + f, rectF.right - f, this.aGR + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aGS) - this.aGR) - f);
        path.arcTo(new RectF(rectF.right - this.aGR, (rectF.bottom - this.aGR) - this.aGS, rectF.right - f, (rectF.bottom - this.aGS) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aGQ) + this.aGT) - (f / 2.0f), (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + this.aGT + (this.aGQ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGT + (f / 2.0f), (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + Math.min(this.aGR, this.aGT) + f, (rectF.bottom - this.aGS) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aGR) - this.aGS, this.aGR + rectF.left, (rectF.bottom - this.aGS) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGR + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGR + rectF.left, this.aGR + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGS) - f);
        path.lineTo(((rectF.left + this.aGQ) + this.aGT) - (f / 2.0f), (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + this.aGT + (this.aGQ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGT + (f / 2.0f), (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + this.aGT + f, (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aGS) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
