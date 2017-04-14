package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BV = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.BC.BZ) {
            float f = this.BC.Ca / 2.0f;
            if (!this.BC.Cd) {
                this.By.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bx.left, this.Bx.top, this.Bw);
            PointF a2 = a(this.Bx.right, this.Bx.bottom, this.Bw);
            this.By.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bw != null) {
            canvas.concat(this.Bw);
        }
        if (dVar.iF()) {
            Bitmap bitmap = dVar.BW.getBitmap();
            this.BV.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BV, this.Bx, this.mPaint);
            return;
        }
        this.BV.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BX.a(canvas, this.BV, this.Bx, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BC.BZ) {
            canvas.drawRect(this.By, this.Bu);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BC.Ch != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BF.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bv.setColor(this.BC.Ch);
            canvas.drawRect(this.BF, this.Bv);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
