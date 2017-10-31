package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect ru = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        canvas.save();
        if (this.BD) {
            try {
                canvas.clipPath(this.BA);
            } catch (Error e) {
            }
        }
        if (dVar.iA()) {
            Bitmap bitmap = dVar.Bh.getBitmap();
            this.ru.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.ru, this.AY, this.mPaint);
        } else {
            this.ru.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bi.a(canvas, this.ru, this.AY, this.mPaint);
        }
        canvas.restore();
    }
}
