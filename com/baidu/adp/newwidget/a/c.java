package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect vo = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.uV.vs) {
            float f = this.uV.vt / 2.0f;
            if (!this.uV.vw) {
                this.uR.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.uQ.left, this.uQ.top, this.uP);
            PointF a2 = a(this.uQ.right, this.uQ.bottom, this.uP);
            this.uR.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uP != null) {
            canvas.concat(this.uP);
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vp.getBitmap();
            this.vo.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.vo, this.uQ, this.mPaint);
            return;
        }
        this.vo.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.vq.a(canvas, this.vo, this.uQ, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.uV.vs) {
            canvas.drawRect(this.uR, this.uN);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.uV.vA != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.uY.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.uO.setColor(this.uV.vA);
            canvas.drawRect(this.uY, this.uO);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
