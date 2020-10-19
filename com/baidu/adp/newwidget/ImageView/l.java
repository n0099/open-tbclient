package com.baidu.adp.newwidget.ImageView;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends a {
    protected BitmapShader mShader;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF mTransformBounds = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(d dVar, ImageView imageView) {
        int width = dVar.getWidth();
        int height = dVar.getHeight();
        PointF applyMatrix = applyMatrix(this.mBounds.left, this.mBounds.top, this.mDrawMatrix);
        int i = (int) applyMatrix.x;
        int i2 = (int) applyMatrix.y;
        PointF applyMatrix2 = applyMatrix(this.mBounds.right, this.mBounds.bottom, this.mDrawMatrix);
        int i3 = (int) applyMatrix2.x;
        int i4 = (int) applyMatrix2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (dVar.isDrawableAvalible()) {
            this.mShader = new BitmapShader(dVar.drawable.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.mShader = dVar.RC.createBitmapShader();
        }
        if (this.mShader != null) {
            this.mShader.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.mShader);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.mTransformBounds.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.Rx.mHasBorder) {
                float f = this.Rx.mBorderWidth / 2.0f;
                if (!this.Rx.mBorderSurroundContent) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.mTransformBounds.left + f, this.mTransformBounds.top + f, this.mTransformBounds.right - f, this.mTransformBounds.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        boolean isBdImgAvailable = dVar.isBdImgAvailable();
        if (isBdImgAvailable && dVar.isBdImgAvailable()) {
            dVar.RC.changeDrawing(true);
        }
        if (!this.Rx.mIsRound) {
            canvas.drawRoundRect(this.mTransformBounds, this.Rx.mRadius, this.Rx.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.mTransformBounds.right + this.mTransformBounds.left) / 2.0f, (this.mTransformBounds.top + this.mTransformBounds.bottom) / 2.0f, Math.min(this.mTransformBounds.width(), this.mTransformBounds.height()) / 2.0f, this.mPaint);
        }
        if (isBdImgAvailable && dVar.isBdImgAvailable()) {
            dVar.RC.changeDrawing(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.Rx.mHasBorder) {
            if (!this.Rx.mIsRound) {
                canvas.drawRoundRect(this.mBorderRect, this.Rx.mRadius, this.Rx.mRadius, this.mBorderPaint);
                return;
            }
            float f = (this.mTransformBounds.right + this.mTransformBounds.left) / 2.0f;
            float f2 = (this.mTransformBounds.top + this.mTransformBounds.bottom) / 2.0f;
            float min = Math.min(this.mTransformBounds.width(), this.mTransformBounds.height()) / 2.0f;
            if (min <= 0.0f) {
                f = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                f2 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
            }
            canvas.drawCircle(f, f2, min - (this.Rx.mBorderWidth / 2.0f), this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.Rx.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundPaint.setColor(this.Rx.mForegroundColor);
            if (!this.Rx.mIsRound) {
                this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.mForegroundRect, this.Rx.mRadius, this.Rx.mRadius, this.mForegroundPaint);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.Rx.mBorderWidth / 2.0f), this.mForegroundPaint);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
