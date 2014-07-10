package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect i = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.g.c) {
            float f = this.g.d / 2.0f;
            if (!this.g.g) {
                this.f.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.e.left, this.e.top, this.d);
            PointF a2 = a(this.e.right, this.e.bottom, this.d);
            this.f.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.d != null) {
            canvas.concat(this.d);
        }
        if (dVar.a()) {
            Bitmap bitmap = dVar.a.getBitmap();
            this.i.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.i, this.e, this.a);
            return;
        }
        this.i.set(0, 0, dVar.d(), dVar.e());
        dVar.b.a(canvas, this.i, this.e, this.a);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void c(Canvas canvas, ImageView imageView) {
        if (this.g.c) {
            canvas.drawRect(this.f, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.g.l != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.h.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.c.setColor(this.g.l);
            canvas.drawRect(this.h, this.c);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
