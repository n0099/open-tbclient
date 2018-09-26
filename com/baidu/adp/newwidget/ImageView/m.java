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
        if (this.Ie != null) {
            canvas.concat(this.Ie);
        }
        canvas.save();
        if (this.IH) {
            try {
                canvas.clipPath(this.IE);
            } catch (Error e) {
            }
        }
        if (cVar.mb()) {
            Bitmap bitmap = cVar.Im.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.If, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.In.a(canvas, this.mRect, this.If, this.mPaint);
        }
        canvas.restore();
    }
}
