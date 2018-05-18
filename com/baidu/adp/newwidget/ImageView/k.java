package com.baidu.adp.newwidget.ImageView;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class k extends a {
    protected BitmapShader Ae;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Af = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.zC.left, this.zC.top, this.zB);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.zC.right, this.zC.bottom, this.zB);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.m10if()) {
            this.Ae = new BitmapShader(cVar.zJ.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ae = cVar.zK.kr();
        }
        if (this.Ae != null) {
            this.Ae.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Ae);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Af.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.zM) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.zN) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Af.left + f, this.Af.top + f, this.Af.right - f, this.Af.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean ig = cVar.ig();
        if (ig) {
            cVar.zK.V(true);
        }
        if (!this.mArgs.zL) {
            canvas.drawRoundRect(this.Af, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Af.right + this.Af.left) / 2.0f, (this.Af.top + this.Af.bottom) / 2.0f, Math.min(this.Af.width(), this.Af.height()) / 2.0f, this.mPaint);
        }
        if (ig) {
            cVar.zK.V(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zM) {
            if (!this.mArgs.zL) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.Af.right + this.Af.left) / 2.0f, (this.Af.top + this.Af.bottom) / 2.0f, (Math.min(this.Af.width(), this.Af.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zR != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.zA.setColor(this.mArgs.zR);
            if (!this.mArgs.zL) {
                this.zH.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.zH, this.mArgs.mRadius, this.mArgs.mRadius, this.zA);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.zA);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
