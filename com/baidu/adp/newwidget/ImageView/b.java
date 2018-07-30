package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect FP = new Rect();

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
            PointF a = a(this.FJ.left, this.FJ.top, this.FI);
            PointF a2 = a(this.FJ.right, this.FJ.bottom, this.FI);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FI != null) {
            canvas.concat(this.FI);
        }
        if (cVar.kV()) {
            Bitmap bitmap = cVar.FQ.getBitmap();
            this.FP.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.FP, this.FJ, this.mPaint);
            return;
        }
        this.FP.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.FR.a(canvas, this.FP, this.FJ, this.mPaint);
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
            this.FO.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.FH.setColor(this.mArgs.Ga);
            canvas.drawRect(this.FO, this.FH);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
