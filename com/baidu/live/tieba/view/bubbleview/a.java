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
    private RectF avT;
    private Path avU;
    private float avV;
    private float avW;
    private float avX;
    private float avY;
    private Paint mStrokePaint;
    private float mStrokeWidth;
    private Path mPath = new Path();
    private Paint mPaint = new Paint(1);

    public a(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        this.avT = rectF;
        this.avV = f;
        this.avW = f2;
        this.avX = f3;
        this.avY = f4;
        this.mStrokeWidth = f5;
        this.mPaint.setColor(i2);
        if (f5 > 0.0f) {
            this.mStrokePaint = new Paint(1);
            this.mStrokePaint.setColor(i);
            this.avU = new Path();
            a(arrowDirection, this.mPath, f5);
            a(arrowDirection, this.avU, 0.0f);
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
            canvas.drawPath(this.avU, this.mStrokePaint);
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
        return (int) this.avT.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.avT.height();
    }

    private void a(ArrowDirection arrowDirection, Path path, float f) {
        switch (arrowDirection) {
            case LEFT:
                if (this.avW <= 0.0f) {
                    b(this.avT, path, f);
                    return;
                } else if (f > 0.0f && f > this.avW) {
                    b(this.avT, path, f);
                    return;
                } else {
                    a(this.avT, path, f);
                    return;
                }
            case TOP:
                if (this.avW <= 0.0f) {
                    d(this.avT, path, f);
                    return;
                } else if (f > 0.0f && f > this.avW) {
                    d(this.avT, path, f);
                    return;
                } else {
                    c(this.avT, path, f);
                    return;
                }
            case RIGHT:
                if (this.avW <= 0.0f) {
                    f(this.avT, path, f);
                    return;
                } else if (f > 0.0f && f > this.avW) {
                    f(this.avT, path, f);
                    return;
                } else {
                    e(this.avT, path, f);
                    return;
                }
            case BOTTOM:
                if (this.avW <= 0.0f) {
                    h(this.avT, path, f);
                    return;
                } else if (f > 0.0f && f > this.avW) {
                    h(this.avT, path, f);
                    return;
                } else {
                    g(this.avT, path, f);
                    return;
                }
            default:
                return;
        }
    }

    private void a(RectF rectF, Path path, float f) {
        path.moveTo(this.avV + rectF.left + this.avW + f, rectF.top + f);
        path.lineTo((rectF.width() - this.avW) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.avW, rectF.top + f, rectF.right - f, this.avW + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.avW) - f);
        path.arcTo(new RectF(rectF.right - this.avW, rectF.bottom - this.avW, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.avV + this.avW + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + this.avV + f, rectF.bottom - this.avW, this.avW + rectF.left + this.avV, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.avV + f, (this.avX + this.avY) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.avY + (this.avX / 2.0f));
        path.lineTo(rectF.left + this.avV + f, this.avY + (f / 2.0f));
        path.lineTo(rectF.left + this.avV + f, rectF.top + this.avW + f);
        path.arcTo(new RectF(rectF.left + this.avV + f, rectF.top + f, this.avW + rectF.left + this.avV, this.avW + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void b(RectF rectF, Path path, float f) {
        path.moveTo(this.avV + rectF.left + f, rectF.top + f);
        path.lineTo(rectF.width() - f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + this.avV + f, rectF.bottom - f);
        path.lineTo(rectF.left + this.avV + f, (this.avX + this.avY) - (f / 2.0f));
        path.lineTo(rectF.left + f + f, this.avY + (this.avX / 2.0f));
        path.lineTo(rectF.left + this.avV + f, this.avY + (f / 2.0f));
        path.lineTo(rectF.left + this.avV + f, rectF.top + f);
        path.close();
    }

    private void c(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + Math.min(this.avY, this.avW) + f, rectF.top + this.avX + f);
        path.lineTo(rectF.left + this.avY + (f / 2.0f), rectF.top + this.avX + f);
        path.lineTo(rectF.left + (this.avV / 2.0f) + this.avY, rectF.top + f + f);
        path.lineTo(((rectF.left + this.avV) + this.avY) - (f / 2.0f), rectF.top + this.avX + f);
        path.lineTo((rectF.right - this.avW) - f, rectF.top + this.avX + f);
        path.arcTo(new RectF(rectF.right - this.avW, rectF.top + this.avX + f, rectF.right - f, this.avW + rectF.top + this.avX), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.avW) - f);
        path.arcTo(new RectF(rectF.right - this.avW, rectF.bottom - this.avW, rectF.right - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.avW + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.avW, this.avW + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.avX + this.avW + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + this.avX + f, this.avW + rectF.left, this.avW + rectF.top + this.avX), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.avY + f, rectF.top + this.avX + f);
        path.lineTo(rectF.left + this.avY + (f / 2.0f), rectF.top + this.avX + f);
        path.lineTo(rectF.left + (this.avV / 2.0f) + this.avY, rectF.top + f + f);
        path.lineTo(((rectF.left + this.avV) + this.avY) - (f / 2.0f), rectF.top + this.avX + f);
        path.lineTo(rectF.right - f, rectF.top + this.avX + f);
        path.lineTo(rectF.right - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + this.avX + f);
        path.lineTo(rectF.left + this.avY + f, rectF.top + this.avX + f);
        path.close();
    }

    private void e(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.avW + f, rectF.top + f);
        path.lineTo(((rectF.width() - this.avW) - this.avV) - f, rectF.top + f);
        path.arcTo(new RectF((rectF.right - this.avW) - this.avV, rectF.top + f, (rectF.right - this.avV) - f, this.avW + rectF.top), 270.0f, 90.0f);
        path.lineTo((rectF.right - this.avV) - f, this.avY + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.avY + (this.avX / 2.0f));
        path.lineTo((rectF.right - this.avV) - f, (this.avY + this.avX) - (f / 2.0f));
        path.lineTo((rectF.right - this.avV) - f, (rectF.bottom - this.avW) - f);
        path.arcTo(new RectF((rectF.right - this.avW) - this.avV, rectF.bottom - this.avW, (rectF.right - this.avV) - f, rectF.bottom - f), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.avV + f, rectF.bottom - f);
        path.arcTo(new RectF(rectF.left + f, rectF.bottom - this.avW, this.avW + rectF.left, rectF.bottom - f), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.avW + rectF.left, this.avW + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void f(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo((rectF.width() - this.avV) - f, rectF.top + f);
        path.lineTo((rectF.right - this.avV) - f, this.avY + (f / 2.0f));
        path.lineTo((rectF.right - f) - f, this.avY + (this.avX / 2.0f));
        path.lineTo((rectF.right - this.avV) - f, (this.avY + this.avX) - (f / 2.0f));
        path.lineTo((rectF.right - this.avV) - f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.bottom - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }

    private void g(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + this.avW + f, rectF.top + f);
        path.lineTo((rectF.width() - this.avW) - f, rectF.top + f);
        path.arcTo(new RectF(rectF.right - this.avW, rectF.top + f, rectF.right - f, this.avW + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - f, ((rectF.bottom - this.avX) - this.avW) - f);
        path.arcTo(new RectF(rectF.right - this.avW, (rectF.bottom - this.avW) - this.avX, rectF.right - f, (rectF.bottom - this.avX) - f), 0.0f, 90.0f);
        path.lineTo(((rectF.left + this.avV) + this.avY) - (f / 2.0f), (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + this.avY + (this.avV / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.avY + (f / 2.0f), (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + Math.min(this.avW, this.avY) + f, (rectF.bottom - this.avX) - f);
        path.arcTo(new RectF(rectF.left + f, (rectF.bottom - this.avW) - this.avX, this.avW + rectF.left, (rectF.bottom - this.avX) - f), 90.0f, 90.0f);
        path.lineTo(rectF.left + f, rectF.top + this.avW + f);
        path.arcTo(new RectF(rectF.left + f, rectF.top + f, this.avW + rectF.left, this.avW + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void h(RectF rectF, Path path, float f) {
        path.moveTo(rectF.left + f, rectF.top + f);
        path.lineTo(rectF.right - f, rectF.top + f);
        path.lineTo(rectF.right - f, (rectF.bottom - this.avX) - f);
        path.lineTo(((rectF.left + this.avV) + this.avY) - (f / 2.0f), (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + this.avY + (this.avV / 2.0f), (rectF.bottom - f) - f);
        path.lineTo(rectF.left + this.avY + (f / 2.0f), (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + this.avY + f, (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + f, (rectF.bottom - this.avX) - f);
        path.lineTo(rectF.left + f, rectF.top + f);
        path.close();
    }
}
