package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bw != null) {
            canvas.concat(this.Bw);
        }
        canvas.save();
        if (this.Cs) {
            try {
                canvas.clipPath(this.Cp);
            } catch (Error e) {
            }
        }
        if (dVar.iF()) {
            Bitmap bitmap = dVar.BW.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Bx, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BX.a(canvas, this.mRect, this.Bx, this.mPaint);
        }
        canvas.restore();
    }
}
