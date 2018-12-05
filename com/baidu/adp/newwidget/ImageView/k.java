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
    protected BitmapShader Jn;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF Jo = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF a = a(this.mBounds.left, this.mBounds.top, this.IK);
        int i = (int) a.x;
        int i2 = (int) a.y;
        PointF a2 = a(this.mBounds.right, this.mBounds.bottom, this.IK);
        int i3 = (int) a2.x;
        int i4 = (int) a2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.mi()) {
            this.Jn = new BitmapShader(cVar.IS.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.Jn = cVar.IT.ov();
        }
        if (this.Jn != null) {
            this.Jn.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.Jn);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.Jo.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.IW) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.IX) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.Jo.left + f, this.Jo.top + f, this.Jo.right - f, this.Jo.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean mj = cVar.mj();
        if (mj) {
            cVar.IT.at(true);
        }
        if (!this.mArgs.IU) {
            canvas.drawRoundRect(this.Jo, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.Jo.right + this.Jo.left) / 2.0f, (this.Jo.top + this.Jo.bottom) / 2.0f, Math.min(this.Jo.width(), this.Jo.height()) / 2.0f, this.mPaint);
        }
        if (mj) {
            cVar.IT.at(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.IW) {
            if (!this.mArgs.IU) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
                return;
            }
            float f = (this.Jo.right + this.Jo.left) / 2.0f;
            float f2 = (this.Jo.top + this.Jo.bottom) / 2.0f;
            float min = Math.min(this.Jo.width(), this.Jo.height()) / 2.0f;
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
        if (this.mArgs.Jb != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.IJ.setColor(this.mArgs.Jb);
            if (!this.mArgs.IU) {
                this.IQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.IQ, this.mArgs.mRadius, this.mArgs.mRadius, this.IJ);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.IJ);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
