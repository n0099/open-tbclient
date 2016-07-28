package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect sY = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.sF.td) {
            float f = this.sF.te / 2.0f;
            if (!this.sF.th) {
                this.sB.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.sA.left, this.sA.top, this.sz);
            PointF a2 = a(this.sA.right, this.sA.bottom, this.sz);
            this.sB.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.sz != null) {
            canvas.concat(this.sz);
        }
        if (dVar.gO()) {
            Bitmap bitmap = dVar.sZ.getBitmap();
            this.sY.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.sY, this.sA, this.mPaint);
            return;
        }
        this.sY.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.tb.a(canvas, this.sY, this.sA, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.sF.td) {
            canvas.drawRect(this.sB, this.sx);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.sF.tl != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.sI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.sy.setColor(this.sF.tl);
            canvas.drawRect(this.sI, this.sy);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
