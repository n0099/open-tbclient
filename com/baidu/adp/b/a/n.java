package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n extends k {
    protected Rect rs = new Rect();

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AW != null) {
            canvas.concat(this.AW);
        }
        canvas.save();
        if (this.BS) {
            try {
                canvas.clipPath(this.BP);
            } catch (Error e) {
            }
        }
        if (dVar.iD()) {
            Bitmap bitmap = dVar.Bw.getBitmap();
            this.rs.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rs, this.AX, this.mPaint);
        } else {
            this.rs.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bx.a(canvas, this.rs, this.AX, this.mPaint);
        }
        canvas.restore();
    }
}
