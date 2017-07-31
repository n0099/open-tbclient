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
    protected BitmapShader DW;
    protected Matrix DV = new Matrix();
    protected RectF DX = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Da.left, this.Da.top, this.CZ);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Da.right, this.Da.bottom, this.CZ);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.DV.reset();
        this.DV.postScale((i3 - i) / width, (i4 - i2) / height);
        this.DV.postTranslate(i, i2);
        if (dVar.iM()) {
            this.DW = new BitmapShader(dVar.Dy.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.DW = dVar.Dz.ld();
        }
        if (this.DW != null) {
            this.DW.setLocalMatrix(this.DV);
            this.mPaint.setShader(this.DW);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.DX.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Df.DB) {
                float f = this.Df.DC / 2.0f;
                if (!this.Df.DF) {
                    this.Db.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Db.set(this.DX.left + f, this.DX.top + f, this.DX.right - f, this.DX.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean iN = dVar.iN();
        if (iN) {
            dVar.Dz.R(true);
        }
        if (!this.Df.DA) {
            canvas.drawRoundRect(this.DX, this.Df.mRadius, this.Df.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.DX.right + this.DX.left) / 2.0f, (this.DX.top + this.DX.bottom) / 2.0f, Math.min(this.DX.width(), this.DX.height()) / 2.0f, this.mPaint);
        }
        if (iN) {
            dVar.Dz.R(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Df.DB) {
            if (!this.Df.DA) {
                canvas.drawRoundRect(this.Db, this.Df.mRadius, this.Df.mRadius, this.CX);
            } else {
                canvas.drawCircle((this.DX.right + this.DX.left) / 2.0f, (this.DX.top + this.DX.bottom) / 2.0f, (Math.min(this.DX.width(), this.DX.height()) / 2.0f) - (this.Df.DC / 2.0f), this.CX);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Df.DJ != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.CY.setColor(this.Df.DJ);
            if (!this.Df.DA) {
                this.Di.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Di, this.Df.mRadius, this.Df.mRadius, this.CY);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Df.DC / 2.0f), this.CY);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
