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
    protected BitmapShader Af;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Ag = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.zD.left, this.zD.top, this.zC);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.zD.right, this.zD.bottom, this.zC);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.m10if()) {
            this.Af = new BitmapShader(cVar.zK.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Af = cVar.zL.ks();
        }
        if (this.Af != null) {
            this.Af.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Af);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Ag.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.zN) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.zO) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Ag.left + f, this.Ag.top + f, this.Ag.right - f, this.Ag.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean ig = cVar.ig();
        if (ig) {
            cVar.zL.V(true);
        }
        if (!this.mArgs.zM) {
            canvas.drawRoundRect(this.Ag, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Ag.right + this.Ag.left) / 2.0f, (this.Ag.top + this.Ag.bottom) / 2.0f, Math.min(this.Ag.width(), this.Ag.height()) / 2.0f, this.mPaint);
        }
        if (ig) {
            cVar.zL.V(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zN) {
            if (!this.mArgs.zM) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.Ag.right + this.Ag.left) / 2.0f, (this.Ag.top + this.Ag.bottom) / 2.0f, (Math.min(this.Ag.width(), this.Ag.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zS != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.zB.setColor(this.mArgs.zS);
            if (!this.mArgs.zM) {
                this.zI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.zI, this.mArgs.mRadius, this.mArgs.mRadius, this.zB);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.zB);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
