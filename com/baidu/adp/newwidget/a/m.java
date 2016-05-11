package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect hJ = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.rU != null) {
            canvas.concat(this.rU);
        }
        canvas.save();
        if (this.sS) {
            try {
                canvas.clipPath(this.sP);
            } catch (Error e) {
            }
        }
        if (dVar.gN()) {
            Bitmap bitmap = dVar.sw.getBitmap();
            this.hJ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.hJ, this.rV, this.mPaint);
        } else {
            this.hJ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sx.a(canvas, this.hJ, this.rV, this.mPaint);
        }
        canvas.restore();
    }
}
