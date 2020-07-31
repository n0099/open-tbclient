package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.c, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        canvas.save();
        if (this.isPathAvailable) {
            try {
                canvas.clipPath(this.mDefaultPath);
            } catch (Error e) {
            }
        }
        if (dVar.isDrawableAvalible()) {
            Bitmap bitmap = dVar.drawable.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.mBounds, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Qp.drawImageTo(canvas, this.mRect, this.mBounds, this.mPaint);
        }
        canvas.restore();
    }
}
