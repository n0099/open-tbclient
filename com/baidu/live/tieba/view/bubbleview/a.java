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
    private RectF WP;
    private Path WQ;
    private float WR;
    private float WS;
    private float WT;
    private float WU;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.WP = rectF;
        this.WR = f;
        this.WS = f2;
        this.WT = f3;
        this.WU = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.WQ = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.WQ, 0.0f);
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
            canvas.drawPath(this.WQ, this.mStrokePaint);
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
        return (int) this.WP.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.WP.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.WS <= 0.0f) {
                    b(this.WP, path, f);
                    return;
                } else if (f > 0.0f && f > this.WS) {
                    b(this.WP, path, f);
                    return;
                } else {
                    a(this.WP, path, f);
                    return;
                }
            case TOP:
                if (this.WS <= 0.0f) {
                    d(this.WP, path, f);
                    return;
                } else if (f > 0.0f && f > this.WS) {
                    d(this.WP, path, f);
                    return;
                } else {
                    c(this.WP, path, f);
                    return;
                }
            case RIGHT:
                if (this.WS <= 0.0f) {
                    f(this.WP, path, f);
                    return;
                } else if (f > 0.0f && f > this.WS) {
                    f(this.WP, path, f);
                    return;
                } else {
                    e(this.WP, path, f);
                    return;
                }
            case BOTTOM:
                if (this.WS <= 0.0f) {
                    h(this.WP, path, f);
                    return;
                } else if (f > 0.0f && f > this.WS) {
                    h(this.WP, path, f);
                    return;
                } else {
                    g(this.WP, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.WR + rectF.left + this.WS + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WS) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.WS, rectF.top + f, rectF.right - f, this.WS + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WS) - f);
        path.arcTo(new RectF(rectF.right - this.WS, rectF.bottom - this.WS, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WR + this.WS + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.WR + f, rectF.bottom - this.WS, this.WS + rectF.left + this.WR, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.WR + f, (this.WT + this.WU) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.WU + (this.WT / 2.0f));
        path.lineTo(rectF.left + this.WR + f, this.WU + (f / 2.0f));
        path.lineTo(rectF.left + this.WR + f, rectF.top + this.WS + f);
        path.arcTo(new RectF(rectF.left + this.WR + f, rectF.top + f, this.WS + rectF.left + this.WR, this.WS + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.WR + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.WR + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.WR + f, (this.WT + this.WU) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.WU + (this.WT / 2.0f));
        path.lineTo(rectF.left + this.WR + f, this.WU + (f / 2.0f));
        path.lineTo(rectF.left + this.WR + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.WU, this.WS) + f, rectF.top + this.WT + f);
        path.lineTo(rectF.left + this.WU + (f / 2.0f), rectF.top + this.WT + f);
        path.lineTo(rectF.left + (this.WR / 2.0f) + this.WU, rectF.top + f + f);
        path.lineTo(((rectF.left + this.WR) + this.WU) - (f / 2.0f), rectF.top + this.WT + f);
        path.lineTo((rectF.right - this.WS) - f, rectF.top + this.WT + f);
        path.arcTo(new RectF(rectF.right - this.WS, rectF.top + this.WT + f, rectF.right - f, this.WS + rectF.top + this.WT), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WS) - f);
        path.arcTo(new RectF(rectF.right - this.WS, rectF.bottom - this.WS, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WS + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.WS, this.WS + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.WT + this.WS + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.WT + f, this.WS + rectF.left, this.WS + rectF.top + this.WT), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WU + f, rectF.top + this.WT + f);
        path.lineTo(rectF.left + this.WU + (f / 2.0f), rectF.top + this.WT + f);
        path.lineTo(rectF.left + (this.WR / 2.0f) + this.WU, rectF.top + f + f);
        path.lineTo(((rectF.left + this.WR) + this.WU) - (f / 2.0f), rectF.top + this.WT + f);
        path.lineTo(rectF.right - f, rectF.top + this.WT + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.WT + f);
        path.lineTo(rectF.left + this.WU + f, rectF.top + this.WT + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WS + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.WS) - this.WR) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.WS) - this.WR, rectF.top + f, (rectF.right - this.WR) - f, this.WS + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.WR) - f, this.WU + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.WU + (this.WT / 2.0f));
        path.lineTo((rectF.right - this.WR) - f, (this.WU + this.WT) - (f / 2.0f));
        path.lineTo((rectF.right - this.WR) - f, (rectF.bottom - this.WS) - f);
        path.arcTo(new RectF((rectF.right - this.WS) - this.WR, rectF.bottom - this.WS, (rectF.right - this.WR) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.WR + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.WS, this.WS + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.WS + rectF.left, this.WS + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WR) - f, rectF.top + f);
        path.lineTo((rectF.right - this.WR) - f, this.WU + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.WU + (this.WT / 2.0f));
        path.lineTo((rectF.right - this.WR) - f, (this.WU + this.WT) - (f / 2.0f));
        path.lineTo((rectF.right - this.WR) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.WS + f, rectF.top + f);
        path.lineTo((rectF.width() - this.WS) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.WS, rectF.top + f, rectF.right - f, this.WS + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.WT) - this.WS) - f);
        path.arcTo(new RectF(rectF.right - this.WS, (rectF.bottom - this.WS) - this.WT, rectF.right - f, (rectF.bottom - this.WT) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.WR) + this.WU) - (f / 2.0f), (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + this.WU + (this.WR / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.WU + (f / 2.0f), (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + Math.min(this.WS, this.WU) + f, (rectF.bottom - this.WT) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.WS) - this.WT, this.WS + rectF.left, (rectF.bottom - this.WT) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.WS + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.WS + rectF.left, this.WS + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.WT) - f);
        path.lineTo(((rectF.left + this.WR) + this.WU) - (f / 2.0f), (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + this.WU + (this.WR / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.WU + (f / 2.0f), (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + this.WU + f, (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.WT) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
