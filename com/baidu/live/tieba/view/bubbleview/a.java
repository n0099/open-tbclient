package com.baidu.live.tieba.view.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
class a extends Drawable {
    private RectF aoR;
    private Path aoS;
    private float aoT;
    private float aoU;
    private float aoV;
    private float aoW;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.aoR = rectF;
        this.aoT = f;
        this.aoU = f2;
        this.aoV = f3;
        this.aoW = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aoS = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aoS, 0.0f);
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
            canvas.drawPath(this.aoS, this.mStrokePaint);
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
        return (int) this.aoR.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.aoR.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.aoU <= 0.0f) {
                    b(this.aoR, path, f);
                    return;
                } else if (f > 0.0f && f > this.aoU) {
                    b(this.aoR, path, f);
                    return;
                } else {
                    a(this.aoR, path, f);
                    return;
                }
            case TOP:
                if (this.aoU <= 0.0f) {
                    d(this.aoR, path, f);
                    return;
                } else if (f > 0.0f && f > this.aoU) {
                    d(this.aoR, path, f);
                    return;
                } else {
                    c(this.aoR, path, f);
                    return;
                }
            case RIGHT:
                if (this.aoU <= 0.0f) {
                    f(this.aoR, path, f);
                    return;
                } else if (f > 0.0f && f > this.aoU) {
                    f(this.aoR, path, f);
                    return;
                } else {
                    e(this.aoR, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aoU <= 0.0f) {
                    h(this.aoR, path, f);
                    return;
                } else if (f > 0.0f && f > this.aoU) {
                    h(this.aoR, path, f);
                    return;
                } else {
                    g(this.aoR, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.aoT + rectF.left + this.aoU + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aoU) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aoU, rectF.top + f, rectF.right - f, this.aoU + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aoU) - f);
        path.arcTo(new RectF(rectF.right - this.aoU, rectF.bottom - this.aoU, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aoT + this.aoU + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aoT + f, rectF.bottom - this.aoU, this.aoU + rectF.left + this.aoT, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aoT + f, (this.aoV + this.aoW) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aoW + (this.aoV / 2.0f));
        path.lineTo(rectF.left + this.aoT + f, this.aoW + (f / 2.0f));
        path.lineTo(rectF.left + this.aoT + f, rectF.top + this.aoU + f);
        path.arcTo(new RectF(rectF.left + this.aoT + f, rectF.top + f, this.aoU + rectF.left + this.aoT, this.aoU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aoT + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aoT + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aoT + f, (this.aoV + this.aoW) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aoW + (this.aoV / 2.0f));
        path.lineTo(rectF.left + this.aoT + f, this.aoW + (f / 2.0f));
        path.lineTo(rectF.left + this.aoT + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aoW, this.aoU) + f, rectF.top + this.aoV + f);
        path.lineTo(rectF.left + this.aoW + (f / 2.0f), rectF.top + this.aoV + f);
        path.lineTo(rectF.left + (this.aoT / 2.0f) + this.aoW, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aoT) + this.aoW) - (f / 2.0f), rectF.top + this.aoV + f);
        path.lineTo((rectF.right - this.aoU) - f, rectF.top + this.aoV + f);
        path.arcTo(new RectF(rectF.right - this.aoU, rectF.top + this.aoV + f, rectF.right - f, this.aoU + rectF.top + this.aoV), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aoU) - f);
        path.arcTo(new RectF(rectF.right - this.aoU, rectF.bottom - this.aoU, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aoU + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aoU, this.aoU + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aoV + this.aoU + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aoV + f, this.aoU + rectF.left, this.aoU + rectF.top + this.aoV), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aoW + f, rectF.top + this.aoV + f);
        path.lineTo(rectF.left + this.aoW + (f / 2.0f), rectF.top + this.aoV + f);
        path.lineTo(rectF.left + (this.aoT / 2.0f) + this.aoW, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aoT) + this.aoW) - (f / 2.0f), rectF.top + this.aoV + f);
        path.lineTo(rectF.right - f, rectF.top + this.aoV + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aoV + f);
        path.lineTo(rectF.left + this.aoW + f, rectF.top + this.aoV + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aoU + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aoU) - this.aoT) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aoU) - this.aoT, rectF.top + f, (rectF.right - this.aoT) - f, this.aoU + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aoT) - f, this.aoW + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aoW + (this.aoV / 2.0f));
        path.lineTo((rectF.right - this.aoT) - f, (this.aoW + this.aoV) - (f / 2.0f));
        path.lineTo((rectF.right - this.aoT) - f, (rectF.bottom - this.aoU) - f);
        path.arcTo(new RectF((rectF.right - this.aoU) - this.aoT, rectF.bottom - this.aoU, (rectF.right - this.aoT) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aoT + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aoU, this.aoU + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aoU + rectF.left, this.aoU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aoT) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aoT) - f, this.aoW + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aoW + (this.aoV / 2.0f));
        path.lineTo((rectF.right - this.aoT) - f, (this.aoW + this.aoV) - (f / 2.0f));
        path.lineTo((rectF.right - this.aoT) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aoU + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aoU) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aoU, rectF.top + f, rectF.right - f, this.aoU + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aoV) - this.aoU) - f);
        path.arcTo(new RectF(rectF.right - this.aoU, (rectF.bottom - this.aoU) - this.aoV, rectF.right - f, (rectF.bottom - this.aoV) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aoT) + this.aoW) - (f / 2.0f), (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + this.aoW + (this.aoT / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aoW + (f / 2.0f), (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + Math.min(this.aoU, this.aoW) + f, (rectF.bottom - this.aoV) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aoU) - this.aoV, this.aoU + rectF.left, (rectF.bottom - this.aoV) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aoU + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aoU + rectF.left, this.aoU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aoV) - f);
        path.lineTo(((rectF.left + this.aoT) + this.aoW) - (f / 2.0f), (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + this.aoW + (this.aoT / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aoW + (f / 2.0f), (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + this.aoW + f, (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aoV) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
