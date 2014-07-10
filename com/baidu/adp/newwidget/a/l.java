package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l extends i {
    protected Rect l = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.d != null) {
            canvas.concat(this.d);
        }
        canvas.save();
        if (this.k) {
            try {
                canvas.clipPath(this.i);
            } catch (Error e) {
            }
        }
        if (dVar.a()) {
            Bitmap bitmap = dVar.a.getBitmap();
            this.l.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.l, this.e, this.a);
        } else {
            this.l.set(0, 0, dVar.d(), dVar.e());
            dVar.b.a(canvas, this.l, this.e, this.a);
        }
        canvas.restore();
    }
}
