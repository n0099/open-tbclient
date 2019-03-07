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
        if (this.IR != null) {
            canvas.concat(this.IR);
        }
        canvas.save();
        if (this.Jt) {
            try {
                canvas.clipPath(this.Jq);
            } catch (Error e) {
            }
        }
        if (cVar.mn()) {
            Bitmap bitmap = cVar.Ja.getBitmap();
            this.mRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.mRect, this.IS, this.mPaint);
        } else {
            this.mRect.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.Jb.a(canvas, this.mRect, this.IS, this.mPaint);
        }
        canvas.restore();
    }
}
