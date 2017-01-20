package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect ky = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uH != null) {
            canvas.concat(this.uH);
        }
        canvas.save();
        if (this.vD) {
            try {
                canvas.clipPath(this.vA);
            } catch (Error e) {
            }
        }
        if (dVar.hH()) {
            Bitmap bitmap = dVar.vh.getBitmap();
            this.ky.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.ky, this.uI, this.mPaint);
        } else {
            this.ky.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vi.a(canvas, this.ky, this.uI, this.mPaint);
        }
        canvas.restore();
    }
}
