package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect Il = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.Iq) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.Ir) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.If.left, this.If.top, this.Ie);
            PointF a2 = a(this.If.right, this.If.bottom, this.Ie);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.Ie != null) {
            canvas.concat(this.Ie);
        }
        if (cVar.mb()) {
            Bitmap bitmap = cVar.Im.getBitmap();
            this.Il.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Il, this.If, this.mPaint);
            return;
        }
        this.Il.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.In.a(canvas, this.Il, this.If, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Iq) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Iv != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Ik.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Id.setColor(this.mArgs.Iv);
            canvas.drawRect(this.Ik, this.Id);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
