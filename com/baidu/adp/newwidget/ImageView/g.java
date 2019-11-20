package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class g extends j {
    private final Paint mModeBeforePaint = new Paint();
    private final Paint mModeAfterPaint = new Paint();
    private final Rect mDoubleCacheRect = new Rect(0, 0, 0, 0);
    private final Rect mBitmapRect = new Rect(0, 0, 0, 0);

    public g() {
        this.mModeBeforePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mModeBeforePaint.setStyle(Paint.Style.FILL);
        this.mModeBeforePaint.setAntiAlias(true);
        this.mModeAfterPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.mDrawMatrix != null) {
            canvas.concat(this.mDrawMatrix);
        }
        if (cVar.isDrawableAvalible()) {
            Bitmap bitmap = cVar.drawable.getBitmap();
            if (this.isPathAvailable) {
                drawPathClip(canvas, bitmap);
                return;
            }
            this.mBitmapRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.tu.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
        } else if (cVar.isBdImgAvailable()) {
            if (this.isPathAvailable) {
                drawPathClip(canvas, cVar.tu.getRawBitmap());
                return;
            }
            this.mBitmapRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.tu.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
        } else {
            this.mBitmapRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.tu.drawImageTo(canvas, this.mBitmapRect, this.mBounds, this.mPaint);
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
