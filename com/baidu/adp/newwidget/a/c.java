package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect rj = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.qN.ro) {
            float f = this.qN.rp / 2.0f;
            if (!this.qN.rs) {
                this.qK.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.qJ.left, this.qJ.top, this.qI);
            PointF a2 = a(this.qJ.right, this.qJ.bottom, this.qI);
            this.qK.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qI != null) {
            canvas.concat(this.qI);
        }
        if (dVar.gD()) {
            Bitmap bitmap = dVar.rk.getBitmap();
            this.rj.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rj, this.qJ, this.gs);
            return;
        }
        this.rj.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.rl.a(canvas, this.rj, this.qJ, this.gs);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qN.ro) {
            canvas.drawRect(this.qK, this.qG);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.qN.rw != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.qQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.qH.setColor(this.qN.rw);
            canvas.drawRect(this.qQ, this.qH);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
