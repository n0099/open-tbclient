package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bz != null) {
            canvas.concat(this.Bz);
        }
        canvas.save();
        if (this.Cv) {
            try {
                canvas.clipPath(this.Cs);
            } catch (Error e) {
            }
        }
        if (dVar.iC()) {
            Bitmap bitmap = dVar.BZ.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.BA, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ca.a(canvas, this.mRect, this.BA, this.mPaint);
        }
        canvas.restore();
    }
}
