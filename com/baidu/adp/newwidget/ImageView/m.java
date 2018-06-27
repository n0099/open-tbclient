package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends j {
    protected Rect mRect = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FL != null) {
            canvas.concat(this.FL);
        }
        canvas.save();
        if (this.Gm) {
            try {
                canvas.clipPath(this.Gj);
            } catch (Error e) {
            }
        }
        if (cVar.kT()) {
            Bitmap bitmap = cVar.FU.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.FM, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FV.a(canvas, this.mRect, this.FM, this.mPaint);
        }
        canvas.restore();
    }
}
