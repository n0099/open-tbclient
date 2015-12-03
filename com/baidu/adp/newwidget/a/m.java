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
        if (this.Bc != null) {
            canvas.concat(this.Bc);
        }
        canvas.save();
        if (this.BY) {
            try {
                canvas.clipPath(this.BV);
            } catch (Error e) {
            }
        }
        if (dVar.kj()) {
            Bitmap bitmap = dVar.BC.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Bd, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BD.a(canvas, this.mRect, this.Bd, this.mPaint);
        }
        canvas.restore();
    }
}
