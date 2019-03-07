package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect IZ = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.Jd) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.Je) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.IS.left, this.IS.top, this.IR);
            PointF a2 = a(this.IS.right, this.IS.bottom, this.IR);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.IR != null) {
            canvas.concat(this.IR);
        }
        if (cVar.mn()) {
            Bitmap bitmap = cVar.Ja.getBitmap();
            this.IZ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.IZ, this.IS, this.mPaint);
            return;
        }
        this.IZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.Jb.a(canvas, this.IZ, this.IS, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Jd) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Ji != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.IY.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.IQ.setColor(this.mArgs.Ji);
            canvas.drawRect(this.IY, this.IQ);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
