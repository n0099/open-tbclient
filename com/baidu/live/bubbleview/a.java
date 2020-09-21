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
    private Path aCM;
    private float aCN;
    private float aCO;
    private float aCP;
    private float aCQ;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aCN = f;
        this.aCO = f2;
        this.aCP = f3;
        this.aCQ = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aCM = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aCM, 0.0f);
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
            canvas.drawPath(this.aCM, this.mStrokePaint);
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
                if (this.aCO <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCO) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aCO <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCO) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aCO <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCO) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aCO <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aCO) {
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
        path.moveTo(this.aCN + rectF.left + this.aCO + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCO) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCO, rectF.top + f, rectF.right - f, this.aCO + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCO) - f);
        path.arcTo(new RectF(rectF.right - this.aCO, rectF.bottom - this.aCO, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCN + this.aCO + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aCN + f, rectF.bottom - this.aCO, this.aCO + rectF.left + this.aCN, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aCN + f, (this.aCP + this.aCQ) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCQ + (this.aCP / 2.0f));
        path.lineTo(rectF.left + this.aCN + f, this.aCQ + (f / 2.0f));
        path.lineTo(rectF.left + this.aCN + f, rectF.top + this.aCO + f);
        path.arcTo(new RectF(rectF.left + this.aCN + f, rectF.top + f, this.aCO + rectF.left + this.aCN, this.aCO + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aCN + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCN + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aCN + f, (this.aCP + this.aCQ) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aCQ + (this.aCP / 2.0f));
        path.lineTo(rectF.left + this.aCN + f, this.aCQ + (f / 2.0f));
        path.lineTo(rectF.left + this.aCN + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aCQ, this.aCO) + f, rectF.top + this.aCP + f);
        path.lineTo(rectF.left + this.aCQ + (f / 2.0f), rectF.top + this.aCP + f);
        path.lineTo(rectF.left + (this.aCN / 2.0f) + this.aCQ, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCN) + this.aCQ) - (f / 2.0f), rectF.top + this.aCP + f);
        path.lineTo((rectF.right - this.aCO) - f, rectF.top + this.aCP + f);
        path.arcTo(new RectF(rectF.right - this.aCO, rectF.top + this.aCP + f, rectF.right - f, this.aCO + rectF.top + this.aCP), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCO) - f);
        path.arcTo(new RectF(rectF.right - this.aCO, rectF.bottom - this.aCO, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCO + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCO, this.aCO + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCP + this.aCO + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aCP + f, this.aCO + rectF.left, this.aCO + rectF.top + this.aCP), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCQ + f, rectF.top + this.aCP + f);
        path.lineTo(rectF.left + this.aCQ + (f / 2.0f), rectF.top + this.aCP + f);
        path.lineTo(rectF.left + (this.aCN / 2.0f) + this.aCQ, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aCN) + this.aCQ) - (f / 2.0f), rectF.top + this.aCP + f);
        path.lineTo(rectF.right - f, rectF.top + this.aCP + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aCP + f);
        path.lineTo(rectF.left + this.aCQ + f, rectF.top + this.aCP + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCO + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aCO) - this.aCN) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aCO) - this.aCN, rectF.top + f, (rectF.right - this.aCN) - f, this.aCO + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aCN) - f, this.aCQ + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCQ + (this.aCP / 2.0f));
        path.lineTo((rectF.right - this.aCN) - f, (this.aCQ + this.aCP) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCN) - f, (rectF.bottom - this.aCO) - f);
        path.arcTo(new RectF((rectF.right - this.aCO) - this.aCN, rectF.bottom - this.aCO, (rectF.right - this.aCN) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aCN + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aCO, this.aCO + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCO + rectF.left, this.aCO + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCN) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aCN) - f, this.aCQ + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aCQ + (this.aCP / 2.0f));
        path.lineTo((rectF.right - this.aCN) - f, (this.aCQ + this.aCP) - (f / 2.0f));
        path.lineTo((rectF.right - this.aCN) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aCO + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aCO) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aCO, rectF.top + f, rectF.right - f, this.aCO + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aCP) - this.aCO) - f);
        path.arcTo(new RectF(rectF.right - this.aCO, (rectF.bottom - this.aCO) - this.aCP, rectF.right - f, (rectF.bottom - this.aCP) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aCN) + this.aCQ) - (f / 2.0f), (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + this.aCQ + (this.aCN / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCQ + (f / 2.0f), (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + Math.min(this.aCO, this.aCQ) + f, (rectF.bottom - this.aCP) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aCO) - this.aCP, this.aCO + rectF.left, (rectF.bottom - this.aCP) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aCO + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aCO + rectF.left, this.aCO + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aCP) - f);
        path.lineTo(((rectF.left + this.aCN) + this.aCQ) - (f / 2.0f), (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + this.aCQ + (this.aCN / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aCQ + (f / 2.0f), (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + this.aCQ + f, (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aCP) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
