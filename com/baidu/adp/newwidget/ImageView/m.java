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
        if (this.FI != null) {
            canvas.concat(this.FI);
        }
        canvas.save();
        if (this.Gk) {
            try {
                canvas.clipPath(this.Gh);
            } catch (Error e) {
            }
        }
        if (cVar.kV()) {
            Bitmap bitmap = cVar.FQ.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.FJ, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FR.a(canvas, this.mRect, this.FJ, this.mPaint);
        }
        canvas.restore();
    }
}
