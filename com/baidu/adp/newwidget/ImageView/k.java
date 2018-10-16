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
    protected BitmapShader Jk;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Jl = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.mBounds.left, this.mBounds.top, this.IG);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.mBounds.right, this.mBounds.bottom, this.IG);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.ml()) {
            this.Jk = new BitmapShader(cVar.IO.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Jk = cVar.IP.oy();
        }
        if (this.Jk != null) {
            this.Jk.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Jk);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Jl.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.IS) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.IT) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Jl.left + f, this.Jl.top + f, this.Jl.right - f, this.Jl.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean mm = cVar.mm();
        if (mm) {
            cVar.IP.af(true);
        }
        if (!this.mArgs.IR) {
            canvas.drawRoundRect(this.Jl, this.mArgs.IQ, this.mArgs.IQ, this.mPaint);
        } else {
            canvas.drawCircle((this.Jl.right + this.Jl.left) / 2.0f, (this.Jl.top + this.Jl.bottom) / 2.0f, Math.min(this.Jl.width(), this.Jl.height()) / 2.0f, this.mPaint);
        }
        if (mm) {
            cVar.IP.af(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.IS) {
            if (!this.mArgs.IR) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.IQ, this.mArgs.IQ, this.mBorderPaint);
                return;
            }
            float f = (this.Jl.right + this.Jl.left) / 2.0f;
            float f2 = (this.Jl.top + this.Jl.bottom) / 2.0f;
            float min = Math.min(this.Jl.width(), this.Jl.height()) / 2.0f;
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
        if (this.mArgs.IY != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.IF.setColor(this.mArgs.IY);
            if (!this.mArgs.IR) {
                this.IL.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.IL, this.mArgs.IQ, this.mArgs.IQ, this.IF);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.IF);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
