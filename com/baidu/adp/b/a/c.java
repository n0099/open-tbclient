package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Bw = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Bd.BA) {
            float f = this.Bd.BB / 2.0f;
            if (!this.Bd.BE) {
                this.AZ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.AY.left, this.AY.top, this.AX);
            PointF a2 = a(this.AY.right, this.AY.bottom, this.AX);
            this.AZ.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        if (dVar.iD()) {
            Bitmap bitmap = dVar.Bx.getBitmap();
            this.Bw.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Bw, this.AY, this.mPaint);
            return;
        }
        this.Bw.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.By.a(canvas, this.Bw, this.AY, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bd.BA) {
            canvas.drawRect(this.AZ, this.AV);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bd.BI != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bg.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.AW.setColor(this.Bd.BI);
            canvas.drawRect(this.Bg, this.AW);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
