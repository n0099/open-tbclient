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
        if (this.aph != null) {
            canvas.concat(this.aph);
        }
        canvas.save();
        if (this.apL) {
            try {
                canvas.clipPath(this.apI);
            } catch (Error e) {
            }
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apr.getBitmap();
            this.lQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.lQ, this.api, this.mPaint);
        } else {
            this.lQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.aps.a(canvas, this.lQ, this.api, this.mPaint);
        }
        canvas.restore();
    }
}
