package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect FQ = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.FV) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.FW) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.FK.left, this.FK.top, this.FJ);
            PointF a2 = a(this.FK.right, this.FK.bottom, this.FJ);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FJ != null) {
            canvas.concat(this.FJ);
        }
        if (cVar.kT()) {
            Bitmap bitmap = cVar.FR.getBitmap();
            this.FQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.FQ, this.FK, this.mPaint);
            return;
        }
        this.FQ.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.FT.a(canvas, this.FQ, this.FK, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.FV) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Ga != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.FP.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.FI.setColor(this.mArgs.Ga);
            canvas.drawRect(this.FP, this.FI);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
