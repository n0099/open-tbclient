package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Cu = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Cb.Cy) {
            float f = this.Cb.Cz / 2.0f;
            if (!this.Cb.CC) {
                this.BX.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.BW.left, this.BW.top, this.BV);
            PointF a2 = a(this.BW.right, this.BW.bottom, this.BV);
            this.BX.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BV != null) {
            canvas.concat(this.BV);
        }
        if (dVar.iB()) {
            Bitmap bitmap = dVar.Cv.getBitmap();
            this.Cu.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Cu, this.BW, this.mPaint);
            return;
        }
        this.Cu.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Cw.a(canvas, this.Cu, this.BW, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Cb.Cy) {
            canvas.drawRect(this.BX, this.BT);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Cb.CG != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Ce.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.BU.setColor(this.Cb.CG);
            canvas.drawRect(this.Ce, this.BU);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
