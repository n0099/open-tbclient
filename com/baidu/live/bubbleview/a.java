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
    private RectF UY;
    private Path UZ;
    private float Va;
    private float Vb;
    private float Vc;
    private float Ve;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.UY = rectF;
        this.Va = f;
        this.Vb = f2;
        this.Vc = f3;
        this.Ve = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.UZ = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.UZ, 0.0f);
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
            canvas.drawPath(this.UZ, this.mStrokePaint);
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
        return (int) this.UY.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.UY.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.Vb <= 0.0f) {
                    b(this.UY, path, f);
                    return;
                } else if (f > 0.0f && f > this.Vb) {
                    b(this.UY, path, f);
                    return;
                } else {
                    a(this.UY, path, f);
                    return;
                }
            case TOP:
                if (this.Vb <= 0.0f) {
                    d(this.UY, path, f);
                    return;
                } else if (f > 0.0f && f > this.Vb) {
                    d(this.UY, path, f);
                    return;
                } else {
                    c(this.UY, path, f);
                    return;
                }
            case RIGHT:
                if (this.Vb <= 0.0f) {
                    f(this.UY, path, f);
                    return;
                } else if (f > 0.0f && f > this.Vb) {
                    f(this.UY, path, f);
                    return;
                } else {
                    e(this.UY, path, f);
                    return;
                }
            case BOTTOM:
                if (this.Vb <= 0.0f) {
                    h(this.UY, path, f);
                    return;
                } else if (f > 0.0f && f > this.Vb) {
                    h(this.UY, path, f);
                    return;
                } else {
                    g(this.UY, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.Va + rectF.left + this.Vb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.Vb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.Vb, rectF.top + f, rectF.right - f, this.Vb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Vb) - f);
        path.arcTo(new RectF(rectF.right - this.Vb, rectF.bottom - this.Vb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Va + this.Vb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.Va + f, rectF.bottom - this.Vb, this.Vb + rectF.left + this.Va, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.Va + f, (this.Vc + this.Ve) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.Ve + (this.Vc / 2.0f));
        path.lineTo(rectF.left + this.Va + f, this.Ve + (f / 2.0f));
        path.lineTo(rectF.left + this.Va + f, rectF.top + this.Vb + f);
        path.arcTo(new RectF(rectF.left + this.Va + f, rectF.top + f, this.Vb + rectF.left + this.Va, this.Vb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.Va + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.Va + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.Va + f, (this.Vc + this.Ve) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.Ve + (this.Vc / 2.0f));
        path.lineTo(rectF.left + this.Va + f, this.Ve + (f / 2.0f));
        path.lineTo(rectF.left + this.Va + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.Ve, this.Vb) + f, rectF.top + this.Vc + f);
        path.lineTo(rectF.left + this.Ve + (f / 2.0f), rectF.top + this.Vc + f);
        path.lineTo(rectF.left + (this.Va / 2.0f) + this.Ve, rectF.top + f + f);
        path.lineTo(((rectF.left + this.Va) + this.Ve) - (f / 2.0f), rectF.top + this.Vc + f);
        path.lineTo((rectF.right - this.Vb) - f, rectF.top + this.Vc + f);
        path.arcTo(new RectF(rectF.right - this.Vb, rectF.top + this.Vc + f, rectF.right - f, this.Vb + rectF.top + this.Vc), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Vb) - f);
        path.arcTo(new RectF(rectF.right - this.Vb, rectF.bottom - this.Vb, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Vb + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.Vb, this.Vb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.Vc + this.Vb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.Vc + f, this.Vb + rectF.left, this.Vb + rectF.top + this.Vc), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Ve + f, rectF.top + this.Vc + f);
        path.lineTo(rectF.left + this.Ve + (f / 2.0f), rectF.top + this.Vc + f);
        path.lineTo(rectF.left + (this.Va / 2.0f) + this.Ve, rectF.top + f + f);
        path.lineTo(((rectF.left + this.Va) + this.Ve) - (f / 2.0f), rectF.top + this.Vc + f);
        path.lineTo(rectF.right - f, rectF.top + this.Vc + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.Vc + f);
        path.lineTo(rectF.left + this.Ve + f, rectF.top + this.Vc + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Vb + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.Vb) - this.Va) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.Vb) - this.Va, rectF.top + f, (rectF.right - this.Va) - f, this.Vb + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.Va) - f, this.Ve + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.Ve + (this.Vc / 2.0f));
        path.lineTo((rectF.right - this.Va) - f, (this.Ve + this.Vc) - (f / 2.0f));
        path.lineTo((rectF.right - this.Va) - f, (rectF.bottom - this.Vb) - f);
        path.arcTo(new RectF((rectF.right - this.Vb) - this.Va, rectF.bottom - this.Vb, (rectF.right - this.Va) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Va + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.Vb, this.Vb + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.Vb + rectF.left, this.Vb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.Va) - f, rectF.top + f);
        path.lineTo((rectF.right - this.Va) - f, this.Ve + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.Ve + (this.Vc / 2.0f));
        path.lineTo((rectF.right - this.Va) - f, (this.Ve + this.Vc) - (f / 2.0f));
        path.lineTo((rectF.right - this.Va) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.Vb + f, rectF.top + f);
        path.lineTo((rectF.width() - this.Vb) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.Vb, rectF.top + f, rectF.right - f, this.Vb + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.Vc) - this.Vb) - f);
        path.arcTo(new RectF(rectF.right - this.Vb, (rectF.bottom - this.Vb) - this.Vc, rectF.right - f, (rectF.bottom - this.Vc) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.Va) + this.Ve) - (f / 2.0f), (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + this.Ve + (this.Va / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.Ve + (f / 2.0f), (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + Math.min(this.Vb, this.Ve) + f, (rectF.bottom - this.Vc) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.Vb) - this.Vc, this.Vb + rectF.left, (rectF.bottom - this.Vc) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.Vb + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.Vb + rectF.left, this.Vb + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.Vc) - f);
        path.lineTo(((rectF.left + this.Va) + this.Ve) - (f / 2.0f), (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + this.Ve + (this.Va / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.Ve + (f / 2.0f), (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + this.Ve + f, (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.Vc) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
