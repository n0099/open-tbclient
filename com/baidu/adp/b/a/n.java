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
        if (this.Db != null) {
            canvas.concat(this.Db);
        }
        canvas.save();
        if (this.DW) {
            try {
                canvas.clipPath(this.DT);
            } catch (Error e) {
            }
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.DA.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.Dc, this.mPaint);
        } else {
            this.mRect.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.DB.a(canvas, this.mRect, this.Dc, this.mPaint);
        }
        canvas.restore();
    }
}
