package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect rt = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AW != null) {
            canvas.concat(this.AW);
        }
        canvas.save();
        if (this.BC) {
            try {
                canvas.clipPath(this.Bz);
            } catch (Error e) {
            }
        }
        if (dVar.iA()) {
            Bitmap bitmap = dVar.Bg.getBitmap();
            this.rt.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rt, this.AX, this.mPaint);
        } else {
            this.rt.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bh.a(canvas, this.rt, this.AX, this.mPaint);
        }
        canvas.restore();
    }
}
