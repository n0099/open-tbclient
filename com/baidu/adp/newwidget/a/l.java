package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    protected BitmapShader Cu;
    protected Matrix Ct = new Matrix();
    protected RectF Cv = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bx.left, this.Bx.top, this.Bw);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bx.right, this.Bx.bottom, this.Bw);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Ct.reset();
        this.Ct.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Ct.postTranslate(i, i2);
        if (dVar.iF()) {
            this.Cu = new BitmapShader(dVar.BW.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Cu = dVar.BX.kX();
        }
        if (this.Cu != null) {
            this.Cu.setLocalMatrix(this.Ct);
            this.mPaint.setShader(this.Cu);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cv.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.BC.BZ) {
                float f = this.BC.Ca / 2.0f;
                if (!this.BC.Cd) {
                    this.By.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.By.set(this.Cv.left + f, this.Cv.top + f, this.Cv.right - f, this.Cv.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iG = dVar.iG();
        if (iG) {
            dVar.BX.R(true);
        }
        if (!this.BC.BY) {
            canvas.drawRoundRect(this.Cv, this.BC.mRadius, this.BC.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cv.right + this.Cv.left) / 2.0f, (this.Cv.top + this.Cv.bottom) / 2.0f, Math.min(this.Cv.width(), this.Cv.height()) / 2.0f, this.mPaint);
        }
        if (iG) {
            dVar.BX.R(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BC.BZ) {
            if (!this.BC.BY) {
                canvas.drawRoundRect(this.By, this.BC.mRadius, this.BC.mRadius, this.Bu);
            } else {
                canvas.drawCircle((this.Cv.right + this.Cv.left) / 2.0f, (this.Cv.top + this.Cv.bottom) / 2.0f, (Math.min(this.Cv.width(), this.Cv.height()) / 2.0f) - (this.BC.Ca / 2.0f), this.Bu);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BC.Ch != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bv.setColor(this.BC.Ch);
            if (!this.BC.BY) {
                this.BF.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.BF, this.BC.mRadius, this.BC.mRadius, this.Bv);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.BC.Ca / 2.0f), this.Bv);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
