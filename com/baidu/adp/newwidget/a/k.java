package com.baidu.adp.newwidget.a;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class k extends a {
    protected BitmapShader Cc;
    protected Matrix Cb = new Matrix();
    protected RectF Cd = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bf.left, this.Bf.top, this.Be);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bf.right, this.Bf.bottom, this.Be);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.Cb.reset();
        this.Cb.postScale((i3 - i) / width, (i4 - i2) / height);
        this.Cb.postTranslate(i, i2);
        if (dVar.kk()) {
            this.Cc = new BitmapShader(dVar.BE.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Cc = dVar.BF.mK();
        }
        if (this.Cc != null) {
            this.Cc.setLocalMatrix(this.Cb);
            this.mPaint.setShader(this.Cc);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cd.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bk.BH) {
                float f = this.Bk.BI / 2.0f;
                if (!this.Bk.BL) {
                    this.Bg.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Bg.set(this.Cd.left + f, this.Cd.top + f, this.Cd.right - f, this.Cd.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean kl = dVar.kl();
        if (kl) {
            dVar.BF.N(true);
        }
        if (!this.Bk.BG) {
            canvas.drawRoundRect(this.Cd, this.Bk.mRadius, this.Bk.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cd.right + this.Cd.left) / 2.0f, (this.Cd.top + this.Cd.bottom) / 2.0f, Math.min(this.Cd.width(), this.Cd.height()) / 2.0f, this.mPaint);
        }
        if (kl) {
            dVar.BF.N(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bk.BH) {
            if (!this.Bk.BG) {
                canvas.drawRoundRect(this.Bg, this.Bk.mRadius, this.Bk.mRadius, this.Bc);
            } else {
                canvas.drawCircle((this.Cd.right + this.Cd.left) / 2.0f, (this.Cd.top + this.Cd.bottom) / 2.0f, (Math.min(this.Cd.width(), this.Cd.height()) / 2.0f) - (this.Bk.BI / 2.0f), this.Bc);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bk.BP != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bd.setColor(this.Bk.BP);
            if (!this.Bk.BG) {
                this.Bn.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bn, this.Bk.mRadius, this.Bk.mRadius, this.Bd);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bk.BI / 2.0f), this.Bd);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
