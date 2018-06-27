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
    protected BitmapShader Gn;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Go = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.FM.left, this.FM.top, this.FL);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.FM.right, this.FM.bottom, this.FL);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.kT()) {
            this.Gn = new BitmapShader(cVar.FU.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Gn = cVar.FV.nf();
        }
        if (this.Gn != null) {
            this.Gn.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Gn);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Go.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.FX) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.FY) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Go.left + f, this.Go.top + f, this.Go.right - f, this.Go.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean kU = cVar.kU();
        if (kU) {
            cVar.FV.X(true);
        }
        if (!this.mArgs.FW) {
            canvas.drawRoundRect(this.Go, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Go.right + this.Go.left) / 2.0f, (this.Go.top + this.Go.bottom) / 2.0f, Math.min(this.Go.width(), this.Go.height()) / 2.0f, this.mPaint);
        }
        if (kU) {
            cVar.FV.X(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.FX) {
            if (!this.mArgs.FW) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.Go.right + this.Go.left) / 2.0f, (this.Go.top + this.Go.bottom) / 2.0f, (Math.min(this.Go.width(), this.Go.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Gc != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.FK.setColor(this.mArgs.Gc);
            if (!this.mArgs.FW) {
                this.FR.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.FR, this.mArgs.mRadius, this.mArgs.mRadius, this.FK);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.FK);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
