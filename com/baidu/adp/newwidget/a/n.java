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
        if (this.uQ != null) {
            canvas.concat(this.uQ);
        }
        canvas.save();
        if (this.vM) {
            try {
                canvas.clipPath(this.vJ);
            } catch (Error e) {
            }
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vq.getBitmap();
            this.kF.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.kF, this.uR, this.mPaint);
        } else {
            this.kF.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vr.a(canvas, this.kF, this.uR, this.mPaint);
        }
        canvas.restore();
    }
}
