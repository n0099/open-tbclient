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
        if (this.Bv != null) {
            canvas.concat(this.Bv);
        }
        canvas.save();
        if (this.Ct) {
            try {
                canvas.clipPath(this.Cq);
            } catch (Error e) {
            }
        }
        if (dVar.jZ()) {
            Bitmap bitmap = dVar.BX.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Bw, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BY.a(canvas, this.mRect, this.Bw, this.mPaint);
        }
        canvas.restore();
    }
}
