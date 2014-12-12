package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends j {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qC != null) {
            canvas.concat(this.qC);
        }
        canvas.save();
        if (this.rB) {
            try {
                canvas.clipPath(this.ry);
            } catch (Error e) {
            }
        }
        if (dVar.gE()) {
            Bitmap bitmap = dVar.re.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.qD, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rf.a(canvas, this.mRect, this.qD, this.mPaint);
        }
        canvas.restore();
    }
}
