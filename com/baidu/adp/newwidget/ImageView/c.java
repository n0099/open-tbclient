package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect mTemp = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(d dVar, ImageView imageView) {
        if (this.PF.mHasBorder) {
            float f = this.PF.mBorderWidth / 2.0f;
            if (!this.PF.mBorderSurroundContent) {
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

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        if (dVar.isDrawableAvalible()) {
            Bitmap bitmap = dVar.drawable.getBitmap();
            this.mTemp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mTemp, this.mBounds, this.mPaint);
        } else if (dVar.isBdImgAvailable()) {
            this.mTemp.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.PM.drawImageTo(canvas, this.mTemp, this.mBounds, this.mPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.PF.mHasBorder) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.PF.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.mForegroundPaint.setColor(this.PF.mForegroundColor);
            canvas.drawRect(this.mForegroundRect, this.mForegroundPaint);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
