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
    private Path aFZ;
    private float aGa;
    private float aGb;
    private float aGc;
    private float aGd;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aGa = f;
        this.aGb = f2;
        this.aGc = f3;
        this.aGd = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aFZ = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aFZ, 0.0f);
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
            canvas.drawPath(this.aFZ, this.mStrokePaint);
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
                if (this.aGb <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGb) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aGb <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGb) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aGb <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGb) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aGb <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aGb) {
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
        path.moveTo(this.aGa + rectF.left + this.aGb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGb, rectF.top + f, rectF.right - f, this.aGb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGb) - f);
        path.arcTo(new RectF(rectF.right - this.aGb, rectF.bottom - this.aGb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGa + this.aGb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aGa + f, rectF.bottom - this.aGb, this.aGb + rectF.left + this.aGa, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aGa + f, (this.aGc + this.aGd) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGd + (this.aGc / 2.0f));
        path.lineTo(rectF.left + this.aGa + f, this.aGd + (f / 2.0f));
        path.lineTo(rectF.left + this.aGa + f, rectF.top + this.aGb + f);
        path.arcTo(new RectF(rectF.left + this.aGa + f, rectF.top + f, this.aGb + rectF.left + this.aGa, this.aGb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aGa + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGa + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aGa + f, (this.aGc + this.aGd) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aGd + (this.aGc / 2.0f));
        path.lineTo(rectF.left + this.aGa + f, this.aGd + (f / 2.0f));
        path.lineTo(rectF.left + this.aGa + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aGd, this.aGb) + f, rectF.top + this.aGc + f);
        path.lineTo(rectF.left + this.aGd + (f / 2.0f), rectF.top + this.aGc + f);
        path.lineTo(rectF.left + (this.aGa / 2.0f) + this.aGd, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGa) + this.aGd) - (f / 2.0f), rectF.top + this.aGc + f);
        path.lineTo((rectF.right - this.aGb) - f, rectF.top + this.aGc + f);
        path.arcTo(new RectF(rectF.right - this.aGb, rectF.top + this.aGc + f, rectF.right - f, this.aGb + rectF.top + this.aGc), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGb) - f);
        path.arcTo(new RectF(rectF.right - this.aGb, rectF.bottom - this.aGb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGb, this.aGb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGc + this.aGb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aGc + f, this.aGb + rectF.left, this.aGb + rectF.top + this.aGc), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGd + f, rectF.top + this.aGc + f);
        path.lineTo(rectF.left + this.aGd + (f / 2.0f), rectF.top + this.aGc + f);
        path.lineTo(rectF.left + (this.aGa / 2.0f) + this.aGd, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aGa) + this.aGd) - (f / 2.0f), rectF.top + this.aGc + f);
        path.lineTo(rectF.right - f, rectF.top + this.aGc + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aGc + f);
        path.lineTo(rectF.left + this.aGd + f, rectF.top + this.aGc + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGb + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aGb) - this.aGa) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aGb) - this.aGa, rectF.top + f, (rectF.right - this.aGa) - f, this.aGb + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aGa) - f, this.aGd + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGd + (this.aGc / 2.0f));
        path.lineTo((rectF.right - this.aGa) - f, (this.aGd + this.aGc) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGa) - f, (rectF.bottom - this.aGb) - f);
        path.arcTo(new RectF((rectF.right - this.aGb) - this.aGa, rectF.bottom - this.aGb, (rectF.right - this.aGa) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aGa + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aGb, this.aGb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGb + rectF.left, this.aGb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGa) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aGa) - f, this.aGd + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aGd + (this.aGc / 2.0f));
        path.lineTo((rectF.right - this.aGa) - f, (this.aGd + this.aGc) - (f / 2.0f));
        path.lineTo((rectF.right - this.aGa) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aGb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aGb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aGb, rectF.top + f, rectF.right - f, this.aGb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aGc) - this.aGb) - f);
        path.arcTo(new RectF(rectF.right - this.aGb, (rectF.bottom - this.aGb) - this.aGc, rectF.right - f, (rectF.bottom - this.aGc) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aGa) + this.aGd) - (f / 2.0f), (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + this.aGd + (this.aGa / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGd + (f / 2.0f), (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + Math.min(this.aGb, this.aGd) + f, (rectF.bottom - this.aGc) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aGb) - this.aGc, this.aGb + rectF.left, (rectF.bottom - this.aGc) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aGb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aGb + rectF.left, this.aGb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aGc) - f);
        path.lineTo(((rectF.left + this.aGa) + this.aGd) - (f / 2.0f), (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + this.aGd + (this.aGa / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aGd + (f / 2.0f), (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + this.aGd + f, (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aGc) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
