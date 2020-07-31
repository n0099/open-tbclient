package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class SoftwarePathClipDrawer extends PathClipDrawer {
    protected Rect mRect = new Rect();

    @Override // com.baidu.live.adp.newwidget.imageview.CommonDrawer, com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContentReal(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
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
        if (displayImage.isDrawableAvalible()) {
            Bitmap bitmap = displayImage.drawable.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.mBounds, this.mPaint);
        } else {
            this.mRect.set(0, 0, displayImage.getWidth(), displayImage.getHeight());
            displayImage.bdImg.drawImageTo(canvas, this.mRect, this.mBounds, this.mPaint);
        }
        canvas.restore();
    }
}
