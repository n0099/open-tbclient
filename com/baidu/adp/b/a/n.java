package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect rr = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AU != null) {
            canvas.concat(this.AU);
        }
        canvas.save();
        if (this.BQ) {
            try {
                canvas.clipPath(this.BN);
            } catch (Error e) {
            }
        }
        if (dVar.iE()) {
            Bitmap bitmap = dVar.Bu.getBitmap();
            this.rr.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rr, this.AV, this.mPaint);
        } else {
            this.rr.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.rr, this.AV, this.mPaint);
        }
        canvas.restore();
    }
}
