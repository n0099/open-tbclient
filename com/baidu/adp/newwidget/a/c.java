package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect sw = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.sa.sA) {
            float f = this.sa.sB / 2.0f;
            if (!this.sa.sE) {
                this.rW.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.rV.left, this.rV.top, this.rU);
            PointF a2 = a(this.rV.right, this.rV.bottom, this.rU);
            this.rW.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.rU != null) {
            canvas.concat(this.rU);
        }
        if (dVar.gP()) {
            Bitmap bitmap = dVar.sx.getBitmap();
            this.sw.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.sw, this.rV, this.mPaint);
            return;
        }
        this.sw.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.sy.a(canvas, this.sw, this.rV, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.sa.sA) {
            canvas.drawRect(this.rW, this.rS);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.sa.sI != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.sd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.rT.setColor(this.sa.sI);
            canvas.drawRect(this.sd, this.rT);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
