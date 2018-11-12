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
        if (this.IK != null) {
            canvas.concat(this.IK);
        }
        canvas.save();
        if (this.Jm) {
            try {
                canvas.clipPath(this.Jj);
            } catch (Error e) {
            }
        }
        if (cVar.mj()) {
            Bitmap bitmap = cVar.IS.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.mBounds, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IT.a(canvas, this.mRect, this.mBounds, this.mPaint);
        }
        canvas.restore();
    }
}
