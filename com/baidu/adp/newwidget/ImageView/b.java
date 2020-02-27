package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect mTemp = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.wx.mHasBorder) {
            float f = this.wx.mBorderWidth / 2.0f;
            if (!this.wx.mBorderSurroundContent) {
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
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        if (cVar.isDrawableAvalible()) {
            Bitmap bitmap = cVar.drawable.getBitmap();
            this.mTemp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mTemp, this.mBounds, this.mPaint);
            return;
        }
        this.mTemp.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.wA.drawImageTo(canvas, this.mTemp, this.mBounds, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawBorder(Canvas canvas, ImageView imageView) {
        if (this.wx.mHasBorder) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void drawForeground(Canvas canvas, ImageView imageView) {
        if (this.wx.mForegroundColor != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.mForegroundRect.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.mForegroundPaint.setColor(this.wx.mForegroundColor);
            canvas.drawRect(this.mForegroundRect, this.mForegroundPaint);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
