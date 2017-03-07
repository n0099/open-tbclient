package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect sv = new Rect();

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BV != null) {
            canvas.concat(this.BV);
        }
        canvas.save();
        if (this.CR) {
            try {
                canvas.clipPath(this.CO);
            } catch (Error e) {
            }
        }
        if (dVar.iB()) {
            Bitmap bitmap = dVar.Cv.getBitmap();
            this.sv.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.sv, this.BW, this.mPaint);
        } else {
            this.sv.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Cw.a(canvas, this.sv, this.BW, this.mPaint);
        }
        canvas.restore();
    }
}
