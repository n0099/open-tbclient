package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect IM = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.IS) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.IT) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.mBounds.left, this.mBounds.top, this.IG);
            PointF a2 = a(this.mBounds.right, this.mBounds.bottom, this.IG);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.IG != null) {
            canvas.concat(this.IG);
        }
        if (cVar.ml()) {
            Bitmap bitmap = cVar.IO.getBitmap();
            this.IM.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.IM, this.mBounds, this.mPaint);
            return;
        }
        this.IM.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.IP.a(canvas, this.IM, this.mBounds, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.IS) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.IY != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.IL.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.IF.setColor(this.mArgs.IY);
            canvas.drawRect(this.IL, this.IF);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
