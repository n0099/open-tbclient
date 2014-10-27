package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends j {
    protected Rect dZ = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qI != null) {
            canvas.concat(this.qI);
        }
        canvas.save();
        if (this.rG) {
            try {
                canvas.clipPath(this.rD);
            } catch (Error e) {
            }
        }
        if (dVar.gD()) {
            Bitmap bitmap = dVar.rk.getBitmap();
            this.dZ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.dZ, this.qJ, this.gs);
        } else {
            this.dZ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rl.a(canvas, this.dZ, this.qJ, this.gs);
        }
        canvas.restore();
    }
}
