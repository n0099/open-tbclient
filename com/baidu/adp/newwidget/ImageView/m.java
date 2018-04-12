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
        if (this.zC != null) {
            canvas.concat(this.zC);
        }
        canvas.save();
        if (this.Ae) {
            try {
                canvas.clipPath(this.Aa);
            } catch (Error e) {
            }
        }
        if (cVar.m10if()) {
            Bitmap bitmap = cVar.zK.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.zD, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zL.a(canvas, this.mRect, this.zD, this.mPaint);
        }
        canvas.restore();
    }
}
