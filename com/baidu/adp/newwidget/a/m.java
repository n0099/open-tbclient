package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect rW = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BH != null) {
            canvas.concat(this.BH);
        }
        canvas.save();
        if (this.CD) {
            try {
                canvas.clipPath(this.CA);
            } catch (Error e) {
            }
        }
        if (dVar.kA()) {
            Bitmap bitmap = dVar.Ch.getBitmap();
            this.rW.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rW, this.BI, this.mPaint);
        } else {
            this.rW.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ci.a(canvas, this.rW, this.BI, this.mPaint);
        }
        canvas.restore();
    }
}
