package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect rM = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bm != null) {
            canvas.concat(this.Bm);
        }
        canvas.save();
        if (this.Ci) {
            try {
                canvas.clipPath(this.Cf);
            } catch (Error e) {
            }
        }
        if (dVar.ku()) {
            Bitmap bitmap = dVar.BM.getBitmap();
            this.rM.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rM, this.Bn, this.mPaint);
        } else {
            this.rM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BN.a(canvas, this.rM, this.Bn, this.mPaint);
        }
        canvas.restore();
    }
}
