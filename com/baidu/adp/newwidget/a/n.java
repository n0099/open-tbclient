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
        if (this.Bk != null) {
            canvas.concat(this.Bk);
        }
        canvas.save();
        if (this.Ci) {
            try {
                canvas.clipPath(this.Cf);
            } catch (Error e) {
            }
        }
        if (dVar.kq()) {
            Bitmap bitmap = dVar.BM.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Bl, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BN.a(canvas, this.mRect, this.Bl, this.mPaint);
        }
        canvas.restore();
    }
}
