package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.CZ != null) {
            canvas.concat(this.CZ);
        }
        canvas.save();
        if (this.DU) {
            try {
                canvas.clipPath(this.DR);
            } catch (Error e) {
            }
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.Dy.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Da, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Dz.a(canvas, this.mRect, this.Da, this.mPaint);
        }
        canvas.restore();
    }
}
