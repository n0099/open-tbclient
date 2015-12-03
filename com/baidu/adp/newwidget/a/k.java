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
    protected BitmapShader Ca;
    protected Matrix BZ = new Matrix();
    protected RectF Cb = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.Bd.left, this.Bd.top, this.Bc);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.Bd.right, this.Bd.bottom, this.Bc);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.BZ.reset();
        this.BZ.postScale((i3 - i) / width, (i4 - i2) / height);
        this.BZ.postTranslate(i, i2);
        if (dVar.kj()) {
            this.Ca = new BitmapShader(dVar.BC.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ca = dVar.BD.nm();
        }
        if (this.Ca != null) {
            this.Ca.setLocalMatrix(this.BZ);
            this.mPaint.setShader(this.Ca);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Cb.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Bi.BF) {
                float f = this.Bi.BG / 2.0f;
                if (!this.Bi.BJ) {
                    this.Be.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.Be.set(this.Cb.left + f, this.Cb.top + f, this.Cb.right - f, this.Cb.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean kk = dVar.kk();
        if (kk) {
            dVar.BD.Q(true);
        }
        if (!this.Bi.BE) {
            canvas.drawRoundRect(this.Cb, this.Bi.mRadius, this.Bi.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Cb.right + this.Cb.left) / 2.0f, (this.Cb.top + this.Cb.bottom) / 2.0f, Math.min(this.Cb.width(), this.Cb.height()) / 2.0f, this.mPaint);
        }
        if (kk) {
            dVar.BD.Q(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bi.BF) {
            if (!this.Bi.BE) {
                canvas.drawRoundRect(this.Be, this.Bi.mRadius, this.Bi.mRadius, this.Ba);
            } else {
                canvas.drawCircle((this.Cb.right + this.Cb.left) / 2.0f, (this.Cb.top + this.Cb.bottom) / 2.0f, (Math.min(this.Cb.width(), this.Cb.height()) / 2.0f) - (this.Bi.BG / 2.0f), this.Ba);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bi.BN != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bb.setColor(this.Bi.BN);
            if (!this.Bi.BE) {
                this.Bl.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Bl, this.Bi.mRadius, this.Bi.mRadius, this.Bb);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Bi.BG / 2.0f), this.Bb);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
