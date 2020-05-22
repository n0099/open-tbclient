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
    private RectF atR;
    private Path atS;
    private float atT;
    private float atU;
    private float atV;
    private float atW;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.atR = rectF;
        this.atT = f;
        this.atU = f2;
        this.atV = f3;
        this.atW = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.atS = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.atS, 0.0f);
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
            canvas.drawPath(this.atS, this.mStrokePaint);
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
        return (int) this.atR.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.atR.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.atU <= 0.0f) {
                    b(this.atR, path, f);
                    return;
                } else if (f > 0.0f && f > this.atU) {
                    b(this.atR, path, f);
                    return;
                } else {
                    a(this.atR, path, f);
                    return;
                }
            case TOP:
                if (this.atU <= 0.0f) {
                    d(this.atR, path, f);
                    return;
                } else if (f > 0.0f && f > this.atU) {
                    d(this.atR, path, f);
                    return;
                } else {
                    c(this.atR, path, f);
                    return;
                }
            case RIGHT:
                if (this.atU <= 0.0f) {
                    f(this.atR, path, f);
                    return;
                } else if (f > 0.0f && f > this.atU) {
                    f(this.atR, path, f);
                    return;
                } else {
                    e(this.atR, path, f);
                    return;
                }
            case BOTTOM:
                if (this.atU <= 0.0f) {
                    h(this.atR, path, f);
                    return;
                } else if (f > 0.0f && f > this.atU) {
                    h(this.atR, path, f);
                    return;
                } else {
                    g(this.atR, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.atT + rectF.left + this.atU + f, rectF.top + f);
        path.lineTo((rectF.width() - this.atU) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.atU, rectF.top + f, rectF.right - f, this.atU + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.atU) - f);
        path.arcTo(new RectF(rectF.right - this.atU, rectF.bottom - this.atU, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.atT + this.atU + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.atT + f, rectF.bottom - this.atU, this.atU + rectF.left + this.atT, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.atT + f, (this.atV + this.atW) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.atW + (this.atV / 2.0f));
        path.lineTo(rectF.left + this.atT + f, this.atW + (f / 2.0f));
        path.lineTo(rectF.left + this.atT + f, rectF.top + this.atU + f);
        path.arcTo(new RectF(rectF.left + this.atT + f, rectF.top + f, this.atU + rectF.left + this.atT, this.atU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.atT + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.atT + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.atT + f, (this.atV + this.atW) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.atW + (this.atV / 2.0f));
        path.lineTo(rectF.left + this.atT + f, this.atW + (f / 2.0f));
        path.lineTo(rectF.left + this.atT + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.atW, this.atU) + f, rectF.top + this.atV + f);
        path.lineTo(rectF.left + this.atW + (f / 2.0f), rectF.top + this.atV + f);
        path.lineTo(rectF.left + (this.atT / 2.0f) + this.atW, rectF.top + f + f);
        path.lineTo(((rectF.left + this.atT) + this.atW) - (f / 2.0f), rectF.top + this.atV + f);
        path.lineTo((rectF.right - this.atU) - f, rectF.top + this.atV + f);
        path.arcTo(new RectF(rectF.right - this.atU, rectF.top + this.atV + f, rectF.right - f, this.atU + rectF.top + this.atV), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.atU) - f);
        path.arcTo(new RectF(rectF.right - this.atU, rectF.bottom - this.atU, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.atU + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.atU, this.atU + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.atV + this.atU + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.atV + f, this.atU + rectF.left, this.atU + rectF.top + this.atV), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.atW + f, rectF.top + this.atV + f);
        path.lineTo(rectF.left + this.atW + (f / 2.0f), rectF.top + this.atV + f);
        path.lineTo(rectF.left + (this.atT / 2.0f) + this.atW, rectF.top + f + f);
        path.lineTo(((rectF.left + this.atT) + this.atW) - (f / 2.0f), rectF.top + this.atV + f);
        path.lineTo(rectF.right - f, rectF.top + this.atV + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.atV + f);
        path.lineTo(rectF.left + this.atW + f, rectF.top + this.atV + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.atU + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.atU) - this.atT) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.atU) - this.atT, rectF.top + f, (rectF.right - this.atT) - f, this.atU + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.atT) - f, this.atW + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.atW + (this.atV / 2.0f));
        path.lineTo((rectF.right - this.atT) - f, (this.atW + this.atV) - (f / 2.0f));
        path.lineTo((rectF.right - this.atT) - f, (rectF.bottom - this.atU) - f);
        path.arcTo(new RectF((rectF.right - this.atU) - this.atT, rectF.bottom - this.atU, (rectF.right - this.atT) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.atT + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.atU, this.atU + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.atU + rectF.left, this.atU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.atT) - f, rectF.top + f);
        path.lineTo((rectF.right - this.atT) - f, this.atW + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.atW + (this.atV / 2.0f));
        path.lineTo((rectF.right - this.atT) - f, (this.atW + this.atV) - (f / 2.0f));
        path.lineTo((rectF.right - this.atT) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.atU + f, rectF.top + f);
        path.lineTo((rectF.width() - this.atU) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.atU, rectF.top + f, rectF.right - f, this.atU + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.atV) - this.atU) - f);
        path.arcTo(new RectF(rectF.right - this.atU, (rectF.bottom - this.atU) - this.atV, rectF.right - f, (rectF.bottom - this.atV) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.atT) + this.atW) - (f / 2.0f), (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + this.atW + (this.atT / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.atW + (f / 2.0f), (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + Math.min(this.atU, this.atW) + f, (rectF.bottom - this.atV) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.atU) - this.atV, this.atU + rectF.left, (rectF.bottom - this.atV) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.atU + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.atU + rectF.left, this.atU + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.atV) - f);
        path.lineTo(((rectF.left + this.atT) + this.atW) - (f / 2.0f), (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + this.atW + (this.atT / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.atW + (f / 2.0f), (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + this.atW + f, (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.atV) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
