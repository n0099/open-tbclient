package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect FT = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.FX) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.FY) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.FM.left, this.FM.top, this.FL);
            PointF a2 = a(this.FM.right, this.FM.bottom, this.FL);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FL != null) {
            canvas.concat(this.FL);
        }
        if (cVar.kT()) {
            Bitmap bitmap = cVar.FU.getBitmap();
            this.FT.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.FT, this.FM, this.mPaint);
            return;
        }
        this.FT.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.FV.a(canvas, this.FT, this.FM, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.FX) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Gc != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.FR.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.FK.setColor(this.mArgs.Gc);
            canvas.drawRect(this.FR, this.FK);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
