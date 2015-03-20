package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BW = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.BA.Ca) {
            float f = this.BA.Cb / 2.0f;
            if (!this.BA.Ce) {
                this.Bx.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bw.left, this.Bw.top, this.Bv);
            PointF a2 = a(this.Bw.right, this.Bw.bottom, this.Bv);
            this.Bx.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bv != null) {
            canvas.concat(this.Bv);
        }
        if (dVar.jZ()) {
            Bitmap bitmap = dVar.BX.getBitmap();
            this.BW.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BW, this.Bw, this.mPaint);
            return;
        }
        this.BW.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BY.a(canvas, this.BW, this.Bw, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BA.Ca) {
            canvas.drawRect(this.Bx, this.Bt);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BA.Ci != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BD.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bu.setColor(this.BA.Ci);
            canvas.drawRect(this.BD, this.Bu);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
