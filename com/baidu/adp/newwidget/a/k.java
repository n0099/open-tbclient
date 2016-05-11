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
    protected BitmapShader sU;
    protected Matrix sT = new Matrix();
    protected RectF sV = new RectF();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.rV.left, this.rV.top, this.rU);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.rV.right, this.rV.bottom, this.rU);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.sT.reset();
        this.sT.postScale((i3 - i) / width, (i4 - i2) / height);
        this.sT.postTranslate(i, i2);
        if (dVar.gN()) {
            this.sU = new BitmapShader(dVar.sw.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.sU = dVar.sx.je();
        }
        if (this.sU != null) {
            this.sU.setLocalMatrix(this.sT);
            this.mPaint.setShader(this.sU);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.sV.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.sa.sz) {
                float f = this.sa.sA / 2.0f;
                if (!this.sa.sD) {
                    this.rW.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.rW.set(this.sV.left + f, this.sV.top + f, this.sV.right - f, this.sV.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gO = dVar.gO();
        if (gO) {
            dVar.sx.M(true);
        }
        if (!this.sa.sy) {
            canvas.drawRoundRect(this.sV, this.sa.mRadius, this.sa.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.sV.right + this.sV.left) / 2.0f, (this.sV.top + this.sV.bottom) / 2.0f, Math.min(this.sV.width(), this.sV.height()) / 2.0f, this.mPaint);
        }
        if (gO) {
            dVar.sx.M(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.sa.sz) {
            if (!this.sa.sy) {
                canvas.drawRoundRect(this.rW, this.sa.mRadius, this.sa.mRadius, this.rS);
            } else {
                canvas.drawCircle((this.sV.right + this.sV.left) / 2.0f, (this.sV.top + this.sV.bottom) / 2.0f, (Math.min(this.sV.width(), this.sV.height()) / 2.0f) - (this.sa.sA / 2.0f), this.rS);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.sa.sH != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.rT.setColor(this.sa.sH);
            if (!this.sa.sy) {
                this.sd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.sd, this.sa.mRadius, this.sa.mRadius, this.rT);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.sa.sA / 2.0f), this.rT);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
