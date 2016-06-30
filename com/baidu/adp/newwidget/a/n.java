package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect hI = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.rU != null) {
            canvas.concat(this.rU);
        }
        canvas.save();
        if (this.sT) {
            try {
                canvas.clipPath(this.sQ);
            } catch (Error e) {
            }
        }
        if (dVar.gP()) {
            Bitmap bitmap = dVar.sx.getBitmap();
            this.hI.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.hI, this.rV, this.mPaint);
        } else {
            this.hI.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sy.a(canvas, this.hI, this.rV, this.mPaint);
        }
        canvas.restore();
    }
}
