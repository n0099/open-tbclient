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
        if (this.apg != null) {
            canvas.concat(this.apg);
        }
        canvas.save();
        if (this.apK) {
            try {
                canvas.clipPath(this.apH);
            } catch (Error e) {
            }
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apq.getBitmap();
            this.lQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.lQ, this.aph, this.mPaint);
        } else {
            this.lQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apr.a(canvas, this.lQ, this.aph, this.mPaint);
        }
        canvas.restore();
    }
}
