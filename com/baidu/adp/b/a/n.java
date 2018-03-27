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
        if (this.aoZ != null) {
            canvas.concat(this.aoZ);
        }
        canvas.save();
        if (this.apC) {
            try {
                canvas.clipPath(this.apz);
            } catch (Error e) {
            }
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.api.getBitmap();
            this.lQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.lQ, this.apa, this.mPaint);
        } else {
            this.lQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apj.a(canvas, this.lQ, this.apa, this.mPaint);
        }
        canvas.restore();
    }
}
