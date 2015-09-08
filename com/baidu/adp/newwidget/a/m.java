package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AV != null) {
            canvas.concat(this.AV);
        }
        canvas.save();
        if (this.BQ) {
            try {
                canvas.clipPath(this.BN);
            } catch (Error e) {
            }
        }
        if (dVar.kg()) {
            Bitmap bitmap = dVar.Bu.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.AW, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.mRect, this.AW, this.mPaint);
        }
        canvas.restore();
    }
}
