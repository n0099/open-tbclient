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
    protected BitmapShader II;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF IJ = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.If.left, this.If.top, this.Ie);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.If.right, this.If.bottom, this.Ie);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.mb()) {
            this.II = new BitmapShader(cVar.Im.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.II = cVar.In.on();
        }
        if (this.II != null) {
            this.II.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.II);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.IJ.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.Iq) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.Ir) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.IJ.left + f, this.IJ.top + f, this.IJ.right - f, this.IJ.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean mc = cVar.mc();
        if (mc) {
            cVar.In.ag(true);
        }
        if (!this.mArgs.Ip) {
            canvas.drawRoundRect(this.IJ, this.mArgs.Io, this.mArgs.Io, this.mPaint);
        } else {
            canvas.drawCircle((this.IJ.right + this.IJ.left) / 2.0f, (this.IJ.top + this.IJ.bottom) / 2.0f, Math.min(this.IJ.width(), this.IJ.height()) / 2.0f, this.mPaint);
        }
        if (mc) {
            cVar.In.ag(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Iq) {
            if (!this.mArgs.Ip) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.Io, this.mArgs.Io, this.mBorderPaint);
                return;
            }
            float f = (this.IJ.right + this.IJ.left) / 2.0f;
            float f2 = (this.IJ.top + this.IJ.bottom) / 2.0f;
            float min = Math.min(this.IJ.width(), this.IJ.height()) / 2.0f;
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
        if (this.mArgs.Iv != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Id.setColor(this.mArgs.Iv);
            if (!this.mArgs.Ip) {
                this.Ik.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.Ik, this.mArgs.Io, this.mArgs.Io, this.Id);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.Id);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
