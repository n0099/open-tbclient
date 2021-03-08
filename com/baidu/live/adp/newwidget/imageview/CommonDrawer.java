package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class CommonDrawer extends AbsDrawer {
    private Rect mTemp = new Rect();

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void applyBounds(DisplayImage displayImage, ImageView imageView) {
        if (this.mArgs.mHasBorder) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.mBorderSurroundContent) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF applyMatrix = applyMatrix(this.mBounds.left, this.mBounds.top, this.mDrawMatrix);
            PointF applyMatrix2 = applyMatrix(this.mBounds.right, this.mBounds.bottom, this.mDrawMatrix);
            this.mBorderRect.set(Math.max((int) applyMatrix.x, 0) + f, Math.max((int) applyMatrix.y, 0) + f, Math.min((int) applyMatrix2.x, width) - f, Math.min((int) applyMatrix2.y, height) - f);
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContentReal(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        if (displayImage.isDrawableAvalible()) {
            Bitmap bitmap = displayImage.drawable.getBitmap();
            this.mTemp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mTemp, this.mBounds, this.mPaint);
            return;
        }
        this.mTemp.set(0, 0, displayImage.getWidth(), displayImage.getHeight());
        displayImage.bdImg.drawImageTo(canvas, this.mTemp, this.mBounds, this.mPaint);
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.mArgs.mHasBorder) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.mArgs.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.mForegroundPaint.setColor(this.mArgs.mForegroundColor);
            canvas.drawRect(this.mForegroundRect, this.mForegroundPaint);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
