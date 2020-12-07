package com.baidu.live.bubbleview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
class a extends Drawable {
    private Path aHK;
    private float aHL;
    private float aHM;
    private float aHN;
    private float aHO;
    private RectF mRect;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, int i3, int i4, ArrowDirection arrowDirection) {
        this.mRect = rectF;
        this.aHL = f;
        this.aHM = f2;
        this.aHN = f3;
        this.aHO = f4;
        this.mStrokeWidth = f5;
        if (i3 != 0 || i4 != 0) {
            this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getIntrinsicHeight(), i3, i4, Shader.TileMode.CLAMP));
        } else {
            this.mPaint.setColor(i2);
        }
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.aHK = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.aHK, 0.0f);
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
            canvas.drawPath(this.aHK, this.mStrokePaint);
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
                if (this.aHM <= 0.0f) {
                    b(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aHM) {
                    b(this.mRect, path, f);
                    return;
                } else {
                    a(this.mRect, path, f);
                    return;
                }
            case TOP:
                if (this.aHM <= 0.0f) {
                    d(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aHM) {
                    d(this.mRect, path, f);
                    return;
                } else {
                    c(this.mRect, path, f);
                    return;
                }
            case RIGHT:
                if (this.aHM <= 0.0f) {
                    f(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aHM) {
                    f(this.mRect, path, f);
                    return;
                } else {
                    e(this.mRect, path, f);
                    return;
                }
            case BOTTOM:
                if (this.aHM <= 0.0f) {
                    h(this.mRect, path, f);
                    return;
                } else if (f > 0.0f && f > this.aHM) {
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
        path.moveTo(this.aHL + rectF.left + this.aHM + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aHM) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aHM, rectF.top + f, rectF.right - f, this.aHM + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aHM) - f);
        path.arcTo(new RectF(rectF.right - this.aHM, rectF.bottom - this.aHM, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aHL + this.aHM + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.aHL + f, rectF.bottom - this.aHM, this.aHM + rectF.left + this.aHL, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.aHL + f, (this.aHN + this.aHO) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aHO + (this.aHN / 2.0f));
        path.lineTo(rectF.left + this.aHL + f, this.aHO + (f / 2.0f));
        path.lineTo(rectF.left + this.aHL + f, rectF.top + this.aHM + f);
        path.arcTo(new RectF(rectF.left + this.aHL + f, rectF.top + f, this.aHM + rectF.left + this.aHL, this.aHM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.aHL + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aHL + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.aHL + f, (this.aHN + this.aHO) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.aHO + (this.aHN / 2.0f));
        path.lineTo(rectF.left + this.aHL + f, this.aHO + (f / 2.0f));
        path.lineTo(rectF.left + this.aHL + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.aHO, this.aHM) + f, rectF.top + this.aHN + f);
        path.lineTo(rectF.left + this.aHO + (f / 2.0f), rectF.top + this.aHN + f);
        path.lineTo(rectF.left + (this.aHL / 2.0f) + this.aHO, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aHL) + this.aHO) - (f / 2.0f), rectF.top + this.aHN + f);
        path.lineTo((rectF.right - this.aHM) - f, rectF.top + this.aHN + f);
        path.arcTo(new RectF(rectF.right - this.aHM, rectF.top + this.aHN + f, rectF.right - f, this.aHM + rectF.top + this.aHN), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aHM) - f);
        path.arcTo(new RectF(rectF.right - this.aHM, rectF.bottom - this.aHM, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aHM + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aHM, this.aHM + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aHN + this.aHM + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.aHN + f, this.aHM + rectF.left, this.aHM + rectF.top + this.aHN), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aHO + f, rectF.top + this.aHN + f);
        path.lineTo(rectF.left + this.aHO + (f / 2.0f), rectF.top + this.aHN + f);
        path.lineTo(rectF.left + (this.aHL / 2.0f) + this.aHO, rectF.top + f + f);
        path.lineTo(((rectF.left + this.aHL) + this.aHO) - (f / 2.0f), rectF.top + this.aHN + f);
        path.lineTo(rectF.right - f, rectF.top + this.aHN + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.aHN + f);
        path.lineTo(rectF.left + this.aHO + f, rectF.top + this.aHN + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aHM + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.aHM) - this.aHL) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.aHM) - this.aHL, rectF.top + f, (rectF.right - this.aHL) - f, this.aHM + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.aHL) - f, this.aHO + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aHO + (this.aHN / 2.0f));
        path.lineTo((rectF.right - this.aHL) - f, (this.aHO + this.aHN) - (f / 2.0f));
        path.lineTo((rectF.right - this.aHL) - f, (rectF.bottom - this.aHM) - f);
        path.arcTo(new RectF((rectF.right - this.aHM) - this.aHL, rectF.bottom - this.aHM, (rectF.right - this.aHL) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.aHL + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.aHM, this.aHM + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aHM + rectF.left, this.aHM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aHL) - f, rectF.top + f);
        path.lineTo((rectF.right - this.aHL) - f, this.aHO + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.aHO + (this.aHN / 2.0f));
        path.lineTo((rectF.right - this.aHL) - f, (this.aHO + this.aHN) - (f / 2.0f));
        path.lineTo((rectF.right - this.aHL) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.aHM + f, rectF.top + f);
        path.lineTo((rectF.width() - this.aHM) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.aHM, rectF.top + f, rectF.right - f, this.aHM + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.aHN) - this.aHM) - f);
        path.arcTo(new RectF(rectF.right - this.aHM, (rectF.bottom - this.aHM) - this.aHN, rectF.right - f, (rectF.bottom - this.aHN) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.aHL) + this.aHO) - (f / 2.0f), (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + this.aHO + (this.aHL / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aHO + (f / 2.0f), (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + Math.min(this.aHM, this.aHO) + f, (rectF.bottom - this.aHN) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.aHM) - this.aHN, this.aHM + rectF.left, (rectF.bottom - this.aHN) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.aHM + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.aHM + rectF.left, this.aHM + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.aHN) - f);
        path.lineTo(((rectF.left + this.aHL) + this.aHO) - (f / 2.0f), (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + this.aHO + (this.aHL / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.aHO + (f / 2.0f), (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + this.aHO + f, (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.aHN) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
