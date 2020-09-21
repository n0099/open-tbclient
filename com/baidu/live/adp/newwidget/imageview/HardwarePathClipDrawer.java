package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class HardwarePathClipDrawer extends PathClipDrawer {
    private final Paint mModeBeforePaint = new Paint();
    private final Paint mModeAfterPaint = new Paint();
    private final Rect mDoubleCacheRect = new Rect(0, 0, 0, 0);
    private final Rect mBitmapRect = new Rect(0, 0, 0, 0);

    public HardwarePathClipDrawer() {
        this.mModeBeforePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mModeBeforePaint.setStyle(Paint.Style.FILL);
        this.mModeBeforePaint.setAntiAlias(true);
        this.mModeAfterPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.live.adp.newwidget.imageview.CommonDrawer, com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContentReal(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        if (displayImage.isDrawableAvalible()) {
            Bitmap bitmap = displayImage.drawable.getBitmap();
            if (this.isPathAvailable) {
                drawPathClip(canvas, bitmap);
                return;
            }
            this.mBitmapRect.set(0, 0, displayImage.getWidth(), displayImage.getHeight());
            displayImage.bdImg.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
        } else if (displayImage.isBdImgAvailable()) {
            if (this.isPathAvailable) {
                drawPathClip(canvas, displayImage.bdImg.getRawBitmap());
                return;
            }
            this.mBitmapRect.set(0, 0, displayImage.getWidth(), displayImage.getHeight());
            displayImage.bdImg.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
        } else {
            this.mBitmapRect.set(0, 0, displayImage.getWidth(), displayImage.getHeight());
            displayImage.bdImg.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
        }
    }

    protected void drawPathClip(Canvas canvas, Bitmap bitmap) {
        this.mBitmapRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.mDoubleCacheRect.set(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.mDefaultPath, this.mModeBeforePaint);
        canvas.drawBitmap(bitmap, this.mBitmapRect, this.mBounds, this.mModeAfterPaint);
        canvas.restore();
    }
}
