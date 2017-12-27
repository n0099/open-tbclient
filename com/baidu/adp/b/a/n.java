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
        if (this.apf != null) {
            canvas.concat(this.apf);
        }
        canvas.save();
        if (this.apJ) {
            try {
                canvas.clipPath(this.apG);
            } catch (Error e) {
            }
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apo.getBitmap();
            this.lQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.lQ, this.apg, this.mPaint);
        } else {
            this.lQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apq.a(canvas, this.lQ, this.apg, this.mPaint);
        }
        canvas.restore();
    }
}
