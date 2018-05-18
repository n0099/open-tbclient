package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect zI = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.zM) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.zN) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.zC.left, this.zC.top, this.zB);
            PointF a2 = a(this.zC.right, this.zC.bottom, this.zB);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.zB != null) {
            canvas.concat(this.zB);
        }
        if (cVar.m10if()) {
            Bitmap bitmap = cVar.zJ.getBitmap();
            this.zI.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.zI, this.zC, this.mPaint);
            return;
        }
        this.zI.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.zK.a(canvas, this.zI, this.zC, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zM) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zR != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.zH.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.zA.setColor(this.mArgs.zR);
            canvas.drawRect(this.zH, this.zA);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
