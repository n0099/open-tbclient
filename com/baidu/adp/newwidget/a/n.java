package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends j {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qH != null) {
            canvas.concat(this.qH);
        }
        canvas.save();
        if (this.rG) {
            try {
                canvas.clipPath(this.rD);
            } catch (Error e) {
            }
        }
        if (dVar.gD()) {
            Bitmap bitmap = dVar.rj.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.qI, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rk.a(canvas, this.mRect, this.qI, this.mPaint);
        }
        canvas.restore();
    }
}
