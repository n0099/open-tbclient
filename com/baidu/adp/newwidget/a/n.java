package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect kF = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uP != null) {
            canvas.concat(this.uP);
        }
        canvas.save();
        if (this.vL) {
            try {
                canvas.clipPath(this.vI);
            } catch (Error e) {
            }
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vp.getBitmap();
            this.kF.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.kF, this.uQ, this.mPaint);
        } else {
            this.kF.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vq.a(canvas, this.kF, this.uQ, this.mPaint);
        }
        canvas.restore();
    }
}
