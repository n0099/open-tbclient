package com.baidu.live.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class a extends Drawable {
    private RectF UG;
    private Path UH;
    private float UJ;
    private float UK;
    private float UL;
    private float UM;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.UG = rectF;
        this.UJ = f;
        this.UK = f2;
        this.UL = f3;
        this.UM = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.UH = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.UH, 0.0f);
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
            canvas.drawPath(this.UH, this.mStrokePaint);
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
        return (int) this.UG.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.UG.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.UK <= 0.0f) {
                    b(this.UG, path, f);
                    return;
                } else if (f > 0.0f && f > this.UK) {
                    b(this.UG, path, f);
                    return;
                } else {
                    a(this.UG, path, f);
                    return;
                }
            case TOP:
                if (this.UK <= 0.0f) {
                    d(this.UG, path, f);
                    return;
                } else if (f > 0.0f && f > this.UK) {
                    d(this.UG, path, f);
                    return;
                } else {
                    c(this.UG, path, f);
                    return;
                }
            case RIGHT:
                if (this.UK <= 0.0f) {
                    f(this.UG, path, f);
                    return;
                } else if (f > 0.0f && f > this.UK) {
                    f(this.UG, path, f);
                    return;
                } else {
                    e(this.UG, path, f);
                    return;
                }
            case BOTTOM:
                if (this.UK <= 0.0f) {
                    h(this.UG, path, f);
                    return;
                } else if (f > 0.0f && f > this.UK) {
                    h(this.UG, path, f);
                    return;
                } else {
                    g(this.UG, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.UJ + rectF.left + this.UK + f, rectF.top + f);
        path.lineTo((rectF.width() - this.UK) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.UK, rectF.top + f, rectF.right - f, this.UK + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.UK) - f);
        path.arcTo(new RectF(rectF.right - this.UK, rectF.bottom - this.UK, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.UJ + this.UK + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.UJ + f, rectF.bottom - this.UK, this.UK + rectF.left + this.UJ, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.UJ + f, (this.UL + this.UM) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.UM + (this.UL / 2.0f));
        path.lineTo(rectF.left + this.UJ + f, this.UM + (f / 2.0f));
        path.lineTo(rectF.left + this.UJ + f, rectF.top + this.UK + f);
        path.arcTo(new RectF(rectF.left + this.UJ + f, rectF.top + f, this.UK + rectF.left + this.UJ, this.UK + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.UJ + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.UJ + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.UJ + f, (this.UL + this.UM) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.UM + (this.UL / 2.0f));
        path.lineTo(rectF.left + this.UJ + f, this.UM + (f / 2.0f));
        path.lineTo(rectF.left + this.UJ + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.UM, this.UK) + f, rectF.top + this.UL + f);
        path.lineTo(rectF.left + this.UM + (f / 2.0f), rectF.top + this.UL + f);
        path.lineTo(rectF.left + (this.UJ / 2.0f) + this.UM, rectF.top + f + f);
        path.lineTo(((rectF.left + this.UJ) + this.UM) - (f / 2.0f), rectF.top + this.UL + f);
        path.lineTo((rectF.right - this.UK) - f, rectF.top + this.UL + f);
        path.arcTo(new RectF(rectF.right - this.UK, rectF.top + this.UL + f, rectF.right - f, this.UK + rectF.top + this.UL), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.UK) - f);
        path.arcTo(new RectF(rectF.right - this.UK, rectF.bottom - this.UK, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.UK + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.UK, this.UK + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.UL + this.UK + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.UL + f, this.UK + rectF.left, this.UK + rectF.top + this.UL), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.UM + f, rectF.top + this.UL + f);
        path.lineTo(rectF.left + this.UM + (f / 2.0f), rectF.top + this.UL + f);
        path.lineTo(rectF.left + (this.UJ / 2.0f) + this.UM, rectF.top + f + f);
        path.lineTo(((rectF.left + this.UJ) + this.UM) - (f / 2.0f), rectF.top + this.UL + f);
        path.lineTo(rectF.right - f, rectF.top + this.UL + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.UL + f);
        path.lineTo(rectF.left + this.UM + f, rectF.top + this.UL + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.UK + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.UK) - this.UJ) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.UK) - this.UJ, rectF.top + f, (rectF.right - this.UJ) - f, this.UK + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.UJ) - f, this.UM + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.UM + (this.UL / 2.0f));
        path.lineTo((rectF.right - this.UJ) - f, (this.UM + this.UL) - (f / 2.0f));
        path.lineTo((rectF.right - this.UJ) - f, (rectF.bottom - this.UK) - f);
        path.arcTo(new RectF((rectF.right - this.UK) - this.UJ, rectF.bottom - this.UK, (rectF.right - this.UJ) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.UJ + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.UK, this.UK + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.UK + rectF.left, this.UK + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.UJ) - f, rectF.top + f);
        path.lineTo((rectF.right - this.UJ) - f, this.UM + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.UM + (this.UL / 2.0f));
        path.lineTo((rectF.right - this.UJ) - f, (this.UM + this.UL) - (f / 2.0f));
        path.lineTo((rectF.right - this.UJ) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.UK + f, rectF.top + f);
        path.lineTo((rectF.width() - this.UK) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.UK, rectF.top + f, rectF.right - f, this.UK + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.UL) - this.UK) - f);
        path.arcTo(new RectF(rectF.right - this.UK, (rectF.bottom - this.UK) - this.UL, rectF.right - f, (rectF.bottom - this.UL) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.UJ) + this.UM) - (f / 2.0f), (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + this.UM + (this.UJ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.UM + (f / 2.0f), (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + Math.min(this.UK, this.UM) + f, (rectF.bottom - this.UL) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.UK) - this.UL, this.UK + rectF.left, (rectF.bottom - this.UL) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.UK + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.UK + rectF.left, this.UK + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.UL) - f);
        path.lineTo(((rectF.left + this.UJ) + this.UM) - (f / 2.0f), (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + this.UM + (this.UJ / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.UM + (f / 2.0f), (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + this.UM + f, (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.UL) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
