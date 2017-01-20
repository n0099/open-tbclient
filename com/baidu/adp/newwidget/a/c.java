package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect vg = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.uN.vk) {
            float f = this.uN.vl / 2.0f;
            if (!this.uN.vo) {
                this.uJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.uI.left, this.uI.top, this.uH);
            PointF a2 = a(this.uI.right, this.uI.bottom, this.uH);
            this.uJ.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uH != null) {
            canvas.concat(this.uH);
        }
        if (dVar.hH()) {
            Bitmap bitmap = dVar.vh.getBitmap();
            this.vg.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.vg, this.uI, this.mPaint);
            return;
        }
        this.vg.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.vi.a(canvas, this.vg, this.uI, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uN.vk) {
            canvas.drawRect(this.uJ, this.uF);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uN.vs != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.uG.setColor(this.uN.vs);
            canvas.drawRect(this.uQ, this.uG);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
