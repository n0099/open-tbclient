package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect vp = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.uW.vt) {
            float f = this.uW.vu / 2.0f;
            if (!this.uW.vx) {
                this.uS.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.uR.left, this.uR.top, this.uQ);
            PointF a2 = a(this.uR.right, this.uR.bottom, this.uQ);
            this.uS.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uQ != null) {
            canvas.concat(this.uQ);
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vq.getBitmap();
            this.vp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.vp, this.uR, this.mPaint);
            return;
        }
        this.vp.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.vr.a(canvas, this.vp, this.uR, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uW.vt) {
            canvas.drawRect(this.uS, this.uO);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uW.vB != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uZ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.uP.setColor(this.uW.vB);
            canvas.drawRect(this.uZ, this.uP);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
