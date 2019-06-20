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
    protected BitmapShader Hd;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF He = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.GA.left, this.GA.top, this.Gz);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.GA.right, this.GA.bottom, this.Gz);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.lh()) {
            this.Hd = new BitmapShader(cVar.GH.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Hd = cVar.GI.ny();
        }
        if (this.Hd != null) {
            this.Hd.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Hd);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.He.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.GK) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.GL) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.He.left + f, this.He.top + f, this.He.right - f, this.He.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean li = cVar.li();
        if (li) {
            cVar.GI.am(true);
        }
        if (!this.mArgs.GJ) {
            canvas.drawRoundRect(this.He, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.He.right + this.He.left) / 2.0f, (this.He.top + this.He.bottom) / 2.0f, Math.min(this.He.width(), this.He.height()) / 2.0f, this.mPaint);
        }
        if (li) {
            cVar.GI.am(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GK) {
            if (!this.mArgs.GJ) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
                return;
            }
            float f = (this.He.right + this.He.left) / 2.0f;
            float f2 = (this.He.top + this.He.bottom) / 2.0f;
            float min = Math.min(this.He.width(), this.He.height()) / 2.0f;
            if (min <= 0.0f) {
                f = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                f2 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
            }
            canvas.drawCircle(f, f2, min - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GP != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Gy.setColor(this.mArgs.GP);
            if (!this.mArgs.GJ) {
                this.GF.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.GF, this.mArgs.mRadius, this.mArgs.mRadius, this.Gy);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.Gy);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
