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
    protected BitmapShader mShader;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF mTransformBounds = new RectF();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        PointF applyMatrix = applyMatrix(this.mBounds.left, this.mBounds.top, this.mDrawMatrix);
        int i = (int) applyMatrix.x;
        int i2 = (int) applyMatrix.y;
        PointF applyMatrix2 = applyMatrix(this.mBounds.right, this.mBounds.bottom, this.mDrawMatrix);
        int i3 = (int) applyMatrix2.x;
        int i4 = (int) applyMatrix2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (cVar.isDrawableAvalible()) {
            this.mShader = new BitmapShader(cVar.drawable.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.mShader = cVar.wA.createBitmapShader();
        }
        if (this.mShader != null) {
            this.mShader.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.mShader);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.mTransformBounds.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.wx.mHasBorder) {
                float f = this.wx.mBorderWidth / 2.0f;
                if (!this.wx.mBorderSurroundContent) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.mTransformBounds.left + f, this.mTransformBounds.top + f, this.mTransformBounds.right - f, this.mTransformBounds.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        boolean isBdImgAvailable = cVar.isBdImgAvailable();
        if (isBdImgAvailable) {
            cVar.wA.changeDrawing(true);
        }
        if (!this.wx.mIsRound) {
            canvas.drawRoundRect(this.mTransformBounds, this.wx.mRadius, this.wx.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.mTransformBounds.right + this.mTransformBounds.left) / 2.0f, (this.mTransformBounds.top + this.mTransformBounds.bottom) / 2.0f, Math.min(this.mTransformBounds.width(), this.mTransformBounds.height()) / 2.0f, this.mPaint);
        }
        if (isBdImgAvailable) {
            cVar.wA.changeDrawing(false);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.wx.mHasBorder) {
            if (!this.wx.mIsRound) {
                canvas.drawRoundRect(this.mBorderRect, this.wx.mRadius, this.wx.mRadius, this.mBorderPaint);
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
            canvas.drawCircle(f, f2, min - (this.wx.mBorderWidth / 2.0f), this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.wx.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundPaint.setColor(this.wx.mForegroundColor);
            if (!this.wx.mIsRound) {
                this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.mForegroundRect, this.wx.mRadius, this.wx.mRadius, this.mForegroundPaint);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.wx.mBorderWidth / 2.0f), this.mForegroundPaint);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
