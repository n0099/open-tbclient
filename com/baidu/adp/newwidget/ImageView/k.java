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
    protected BitmapShader Gl;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Gm = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.FJ.left, this.FJ.top, this.FI);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.FJ.right, this.FJ.bottom, this.FI);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.kV()) {
            this.Gl = new BitmapShader(cVar.FQ.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Gl = cVar.FR.nh();
        }
        if (this.Gl != null) {
            this.Gl.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Gl);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Gm.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.FV) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.FW) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Gm.left + f, this.Gm.top + f, this.Gm.right - f, this.Gm.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean kW = cVar.kW();
        if (kW) {
            cVar.FR.W(true);
        }
        if (!this.mArgs.FU) {
            canvas.drawRoundRect(this.Gm, this.mArgs.FT, this.mArgs.FT, this.mPaint);
        } else {
            canvas.drawCircle((this.Gm.right + this.Gm.left) / 2.0f, (this.Gm.top + this.Gm.bottom) / 2.0f, Math.min(this.Gm.width(), this.Gm.height()) / 2.0f, this.mPaint);
        }
        if (kW) {
            cVar.FR.W(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.FV) {
            if (!this.mArgs.FU) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.FT, this.mArgs.FT, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.Gm.right + this.Gm.left) / 2.0f, (this.Gm.top + this.Gm.bottom) / 2.0f, (Math.min(this.Gm.width(), this.Gm.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Ga != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.FH.setColor(this.mArgs.Ga);
            if (!this.mArgs.FU) {
                this.FO.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.FO, this.mArgs.FT, this.mArgs.FT, this.FH);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.FH);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
