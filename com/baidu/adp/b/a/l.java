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
    protected BitmapShader apC;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF apD = new RectF();

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
            this.apC = new BitmapShader(dVar.aph.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.apC = dVar.api.sn();
        }
        if (this.apC != null) {
            this.apC.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.apC);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.apD.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.apk) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.apl) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.apD.left + f, this.apD.top + f, this.apD.right - f, this.apD.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean qb = dVar.qb();
        if (qb) {
            dVar.api.aC(true);
        }
        if (!this.mArgs.apj) {
            canvas.drawRoundRect(this.apD, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.apD.right + this.apD.left) / 2.0f, (this.apD.top + this.apD.bottom) / 2.0f, Math.min(this.apD.width(), this.apD.height()) / 2.0f, this.mPaint);
        }
        if (qb) {
            dVar.api.aC(false);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apk) {
            if (!this.mArgs.apj) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.apD.right + this.apD.left) / 2.0f, (this.apD.top + this.apD.bottom) / 2.0f, (Math.min(this.apD.width(), this.apD.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apq != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.aoY.setColor(this.mArgs.apq);
            if (!this.mArgs.apj) {
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
