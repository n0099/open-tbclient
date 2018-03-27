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
    protected BitmapShader apD;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF apE = new RectF();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF a = a(this.apa.left, this.apa.top, this.aoZ);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.apa.right, this.apa.bottom, this.aoZ);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (dVar.qa()) {
            this.apD = new BitmapShader(dVar.api.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apD = dVar.apj.sn();
        }
        if (this.apD != null) {
            this.apD.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.apD);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apE.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.apl) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.apm) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.apE.left + f, this.apE.top + f, this.apE.right - f, this.apE.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qb = dVar.qb();
        if (qb) {
            dVar.apj.aC(true);
        }
        if (!this.mArgs.apk) {
            canvas.drawRoundRect(this.apE, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apE.right + this.apE.left) / 2.0f, (this.apE.top + this.apE.bottom) / 2.0f, Math.min(this.apE.width(), this.apE.height()) / 2.0f, this.mPaint);
        }
        if (qb) {
            dVar.apj.aC(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apl) {
            if (!this.mArgs.apk) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.apE.right + this.apE.left) / 2.0f, (this.apE.top + this.apE.bottom) / 2.0f, (Math.min(this.apE.width(), this.apE.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apr != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.aoY.setColor(this.mArgs.apr);
            if (!this.mArgs.apk) {
                this.apf.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.apf, this.mArgs.mRadius, this.mArgs.mRadius, this.aoY);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.aoY);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
