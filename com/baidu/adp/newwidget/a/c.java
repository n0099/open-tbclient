package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect ri = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.qM.rm) {
            float f = this.qM.ro / 2.0f;
            if (!this.qM.rr) {
                this.qJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.qI.left, this.qI.top, this.qH);
            PointF a2 = a(this.qI.right, this.qI.bottom, this.qH);
            this.qJ.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qH != null) {
            canvas.concat(this.qH);
        }
        if (dVar.gE()) {
            Bitmap bitmap = dVar.rj.getBitmap();
            this.ri.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.ri, this.qI, this.mPaint);
            return;
        }
        this.ri.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.rk.a(canvas, this.ri, this.qI, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qM.rm) {
            canvas.drawRect(this.qJ, this.qF);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.qM.rv != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.qP.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.qG.setColor(this.qM.rv);
            canvas.drawRect(this.qP, this.qG);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
