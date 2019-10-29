package com.baidu.live.adp.newwidget.imageview;

import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
/* loaded from: classes6.dex */
public class ShaderDrawer extends AbsDrawer {
    protected BitmapShader mShader;
    protected Matrix mShaderMatrix = new Matrix();
    protected RectF mTransformBounds = new RectF();

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void applyBounds(DisplayImage displayImage, ImageView imageView) {
        int width = displayImage.getWidth();
        int height = displayImage.getHeight();
        PointF applyMatrix = applyMatrix(this.mBounds.left, this.mBounds.top, this.mDrawMatrix);
        int i = (int) applyMatrix.x;
        int i2 = (int) applyMatrix.y;
        PointF applyMatrix2 = applyMatrix(this.mBounds.right, this.mBounds.bottom, this.mDrawMatrix);
        int i3 = (int) applyMatrix2.x;
        int i4 = (int) applyMatrix2.y;
        this.mShaderMatrix.reset();
        this.mShaderMatrix.postScale((i3 - i) / width, (i4 - i2) / height);
        this.mShaderMatrix.postTranslate(i, i2);
        if (displayImage.isDrawableAvalible()) {
            this.mShader = new BitmapShader(displayImage.drawable.getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        } else {
            this.mShader = displayImage.bdImg.createBitmapShader();
        }
        if (this.mShader != null) {
            this.mShader.setLocalMatrix(this.mShaderMatrix);
            this.mPaint.setShader(this.mShader);
            int width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            this.mTransformBounds.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width2), Math.min(i4, (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom()));
            if (this.mArgs.mHasBorder) {
                float f = this.mArgs.mBorderWidth / 2.0f;
                if (!this.mArgs.mBorderSurroundContent) {
                    this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                } else {
                    this.mBorderRect.set(this.mTransformBounds.left + f, this.mTransformBounds.top + f, this.mTransformBounds.right - f, this.mTransformBounds.bottom - f);
                }
            }
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContentReal(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
        boolean isBdImgAvailable = displayImage.isBdImgAvailable();
        if (isBdImgAvailable) {
            displayImage.bdImg.changeDrawing(true);
        }
        if (!this.mArgs.mIsRound) {
            canvas.drawRoundRect(this.mTransformBounds, this.mArgs.mRadius, this.mArgs.mRadius, this.mPaint);
        } else {
            canvas.drawCircle((this.mTransformBounds.right + this.mTransformBounds.left) / 2.0f, (this.mTransformBounds.top + this.mTransformBounds.bottom) / 2.0f, Math.min(this.mTransformBounds.width(), this.mTransformBounds.height()) / 2.0f, this.mPaint);
        }
        if (isBdImgAvailable) {
            displayImage.bdImg.changeDrawing(false);
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.mArgs.mHasBorder) {
            if (!this.mArgs.mIsRound) {
                canvas.drawRoundRect(this.mBorderRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mBorderPaint);
            } else {
                canvas.drawCircle((this.mTransformBounds.right + this.mTransformBounds.left) / 2.0f, (this.mTransformBounds.top + this.mTransformBounds.bottom) / 2.0f, (Math.min(this.mTransformBounds.width(), this.mTransformBounds.height()) / 2.0f) - (this.mArgs.mBorderWidth / 2.0f), this.mBorderPaint);
            }
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.mArgs.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundPaint.setColor(this.mArgs.mForegroundColor);
            if (!this.mArgs.mIsRound) {
                this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                canvas.drawRoundRect(this.mForegroundRect, this.mArgs.mRadius, this.mArgs.mRadius, this.mForegroundPaint);
            } else {
                float width = imageView.getWidth() / 2.0f;
                float height = imageView.getHeight() / 2.0f;
                canvas.drawCircle(width, height, Math.min(width, height) - (this.mArgs.mBorderWidth / 2.0f), this.mForegroundPaint);
            }
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
