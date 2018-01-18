package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect lQ = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.ape != null) {
            canvas.concat(this.ape);
        }
        canvas.save();
        if (this.apI) {
            try {
                canvas.clipPath(this.apF);
            } catch (Error e) {
            }
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apn.getBitmap();
            this.lQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.lQ, this.apf, this.mPaint);
        } else {
            this.lQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apo.a(canvas, this.lQ, this.apf, this.mPaint);
        }
        canvas.restore();
    }
}
