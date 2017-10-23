package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect rt = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        canvas.save();
        if (this.BT) {
            try {
                canvas.clipPath(this.BQ);
            } catch (Error e) {
            }
        }
        if (dVar.iD()) {
            Bitmap bitmap = dVar.Bx.getBitmap();
            this.rt.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rt, this.AY, this.mPaint);
        } else {
            this.rt.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.By.a(canvas, this.rt, this.AY, this.mPaint);
        }
        canvas.restore();
    }
}
