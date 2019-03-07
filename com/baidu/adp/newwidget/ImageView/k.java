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
    protected BitmapShader Ju;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Jv = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.IS.left, this.IS.top, this.IR);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.IS.right, this.IS.bottom, this.IR);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.mn()) {
            this.Ju = new BitmapShader(cVar.Ja.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Ju = cVar.Jb.oE();
        }
        if (this.Ju != null) {
            this.Ju.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Ju);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Jv.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.Jd) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.Je) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Jv.left + f, this.Jv.top + f, this.Jv.right - f, this.Jv.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean mo = cVar.mo();
        if (mo) {
            cVar.Jb.au(true);
        }
        if (!this.mArgs.Jc) {
            canvas.drawRoundRect(this.Jv, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Jv.right + this.Jv.left) / 2.0f, (this.Jv.top + this.Jv.bottom) / 2.0f, Math.min(this.Jv.width(), this.Jv.height()) / 2.0f, this.mPaint);
        }
        if (mo) {
            cVar.Jb.au(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Jd) {
            if (!this.mArgs.Jc) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
                return;
            }
            float f = (this.Jv.right + this.Jv.left) / 2.0f;
            float f2 = (this.Jv.top + this.Jv.bottom) / 2.0f;
            float min = Math.min(this.Jv.width(), this.Jv.height()) / 2.0f;
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
        if (this.mArgs.Ji != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.IQ.setColor(this.mArgs.Ji);
            if (!this.mArgs.Jc) {
                this.IY.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.IY, this.mArgs.mRadius, this.mArgs.mRadius, this.IQ);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.IQ);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
