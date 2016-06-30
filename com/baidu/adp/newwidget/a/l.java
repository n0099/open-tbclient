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
    protected BitmapShader sV;
    protected Matrix sU = new Matrix();
    protected RectF sW = new RectF();

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
        this.sU.reset();
        this.sU.postScale((i3 - i) / width, (i4 - i2) / height);
        this.sU.postTranslate(i, i2);
        if (dVar.gP()) {
            this.sV = new BitmapShader(dVar.sx.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.sV = dVar.sy.jh();
        }
        if (this.sV != null) {
            this.sV.setLocalMatrix(this.sU);
            this.mPaint.setShader(this.sV);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.sW.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.sa.sA) {
                float f = this.sa.sB / 2.0f;
                if (!this.sa.sE) {
                    this.rW.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.rW.set(this.sW.left + f, this.sW.top + f, this.sW.right - f, this.sW.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean gQ = dVar.gQ();
        if (gQ) {
            dVar.sy.M(true);
        }
        if (!this.sa.sz) {
            canvas.drawRoundRect(this.sW, this.sa.mRadius, this.sa.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.sW.right + this.sW.left) / 2.0f, (this.sW.top + this.sW.bottom) / 2.0f, Math.min(this.sW.width(), this.sW.height()) / 2.0f, this.mPaint);
        }
        if (gQ) {
            dVar.sy.M(false);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.sa.sA) {
            if (!this.sa.sz) {
                canvas.drawRoundRect(this.rW, this.sa.mRadius, this.sa.mRadius, this.rS);
            } else {
                canvas.drawCircle((this.sW.right + this.sW.left) / 2.0f, (this.sW.top + this.sW.bottom) / 2.0f, (Math.min(this.sW.width(), this.sW.height()) / 2.0f) - (this.sa.sB / 2.0f), this.rS);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.sa.sI != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.rT.setColor(this.sa.sI);
            if (!this.sa.sz) {
                this.sd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.sd, this.sa.mRadius, this.sa.mRadius, this.rT);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.sa.sB / 2.0f), this.rT);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
