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
    protected BitmapShader He;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Hf = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.GB.left, this.GB.top, this.GA);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.GB.right, this.GB.bottom, this.GA);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.lh()) {
            this.He = new BitmapShader(cVar.GI.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.He = cVar.GJ.ny();
        }
        if (this.He != null) {
            this.He.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.He);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Hf.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.GL) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.GM) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Hf.left + f, this.Hf.top + f, this.Hf.right - f, this.Hf.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean li = cVar.li();
        if (li) {
            cVar.GJ.am(true);
        }
        if (!this.mArgs.GK) {
            canvas.drawRoundRect(this.Hf, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Hf.right + this.Hf.left) / 2.0f, (this.Hf.top + this.Hf.bottom) / 2.0f, Math.min(this.Hf.width(), this.Hf.height()) / 2.0f, this.mPaint);
        }
        if (li) {
            cVar.GJ.am(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GL) {
            if (!this.mArgs.GK) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
                return;
            }
            float f = (this.Hf.right + this.Hf.left) / 2.0f;
            float f2 = (this.Hf.top + this.Hf.bottom) / 2.0f;
            float min = Math.min(this.Hf.width(), this.Hf.height()) / 2.0f;
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
        if (this.mArgs.GQ != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Gz.setColor(this.mArgs.GQ);
            if (!this.mArgs.GK) {
                this.GG.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.GG, this.mArgs.mRadius, this.mArgs.mRadius, this.Gz);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.Gz);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
