package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
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
        if (cVar.isDrawableAvalible()) {
            Bitmap bitmap = cVar.drawable.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.mBounds, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.tW.drawImageTo(canvas, this.mRect, this.mBounds, this.mPaint);
        }
        canvas.restore();
    }
}
