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
    protected BitmapShader Cv;
    protected Matrix Cu = new Matrix();
    protected RectF Cw = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bw.left, this.Bw.top, this.Bv);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bw.right, this.Bw.bottom, this.Bv);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Cu.reset();
        this.Cu.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Cu.postTranslate(i, i2);
        if (dVar.jZ()) {
            this.Cv = new BitmapShader(dVar.BX.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Cv = dVar.BY.mF();
        }
        if (this.Cv != null) {
            this.Cv.setLocalMatrix(this.Cu);
            this.mPaint.setShader(this.Cv);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cw.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.BA.Ca) {
                float f = this.BA.Cb / 2.0f;
                if (!this.BA.Ce) {
                    this.Bx.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Bx.set(this.Cw.left + f, this.Cw.top + f, this.Cw.right - f, this.Cw.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean ka = dVar.ka();
        if (ka) {
            dVar.BY.N(true);
        }
        if (!this.BA.BZ) {
            canvas.drawRoundRect(this.Cw, this.BA.mRadius, this.BA.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cw.right + this.Cw.left) / 2.0f, (this.Cw.top + this.Cw.bottom) / 2.0f, Math.min(this.Cw.width(), this.Cw.height()) / 2.0f, this.mPaint);
        }
        if (ka) {
            dVar.BY.N(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BA.Ca) {
            if (!this.BA.BZ) {
                canvas.drawRoundRect(this.Bx, this.BA.mRadius, this.BA.mRadius, this.Bt);
            } else {
                canvas.drawCircle((this.Cw.right + this.Cw.left) / 2.0f, (this.Cw.top + this.Cw.bottom) / 2.0f, (Math.min(this.Cw.width(), this.Cw.height()) / 2.0f) - (this.BA.Cb / 2), this.Bt);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        int scrollX;
        int scrollY;
        if (this.BA.Ci != 0) {
            canvas.translate(imageView.getScrollX(), imageView.getScrollY());
            this.Bu.setColor(this.BA.Ci);
            if (!this.BA.BZ) {
                this.BD.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.BD, this.BA.mRadius, this.BA.mRadius, this.Bu);
            } else {
                float width = imageView.getWidth() / 2;
                float height = imageView.getHeight() / 2;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.BA.Cb / 2), this.Bu);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
