package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect il = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.sz != null) {
            canvas.concat(this.sz);
        }
        canvas.save();
        if (this.ty) {
            try {
                canvas.clipPath(this.tv);
            } catch (Error e) {
            }
        }
        if (dVar.gO()) {
            Bitmap bitmap = dVar.sZ.getBitmap();
            this.il.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.il, this.sA, this.mPaint);
        } else {
            this.il.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.tb.a(canvas, this.il, this.sA, this.mPaint);
        }
        canvas.restore();
    }
}
