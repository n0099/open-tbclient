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
        if (this.GH != null) {
            canvas.concat(this.GH);
        }
        canvas.save();
        if (this.Hn) {
            try {
                canvas.clipPath(this.Hk);
            } catch (Error e) {
            }
        }
        if (cVar.lx()) {
            Bitmap bitmap = cVar.GQ.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.GI, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GR.a(canvas, this.mRect, this.GI, this.mPaint);
        }
        canvas.restore();
    }
}
