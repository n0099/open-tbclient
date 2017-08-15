package com.baidu.adp.b.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    protected BitmapShader DY;
    protected Matrix DX = new Matrix();
    protected RectF DZ = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Dc.left, this.Dc.top, this.Db);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Dc.right, this.Dc.bottom, this.Db);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.DX.reset();
        this.DX.postScale((i3 - i) / width, (i4 - i2) / height);
        this.DX.postTranslate(i, i2);
        if (dVar.iM()) {
            this.DY = new BitmapShader(dVar.DA.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.DY = dVar.DB.ld();
        }
        if (this.DY != null) {
            this.DY.setLocalMatrix(this.DX);
            this.mPaint.setShader(this.DY);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.DZ.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Dh.DD) {
                float f = this.Dh.DE / 2.0f;
                if (!this.Dh.DH) {
                    this.Dd.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Dd.set(this.DZ.left + f, this.DZ.top + f, this.DZ.right - f, this.DZ.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iN = dVar.iN();
        if (iN) {
            dVar.DB.R(true);
        }
        if (!this.Dh.DC) {
            canvas.drawRoundRect(this.DZ, this.Dh.mRadius, this.Dh.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.DZ.right + this.DZ.left) / 2.0f, (this.DZ.top + this.DZ.bottom) / 2.0f, Math.min(this.DZ.width(), this.DZ.height()) / 2.0f, this.mPaint);
        }
        if (iN) {
            dVar.DB.R(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Dh.DD) {
            if (!this.Dh.DC) {
                canvas.drawRoundRect(this.Dd, this.Dh.mRadius, this.Dh.mRadius, this.CZ);
            } else {
                canvas.drawCircle((this.DZ.right + this.DZ.left) / 2.0f, (this.DZ.top + this.DZ.bottom) / 2.0f, (Math.min(this.DZ.width(), this.DZ.height()) / 2.0f) - (this.Dh.DE / 2.0f), this.CZ);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Dh.DL != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Da.setColor(this.Dh.DL);
            if (!this.Dh.DC) {
                this.Dk.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Dk, this.Dh.mRadius, this.Dh.mRadius, this.Da);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Dh.DE / 2.0f), this.Da);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
