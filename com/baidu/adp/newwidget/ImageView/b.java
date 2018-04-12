package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect zJ = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.zN) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.zO) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.zD.left, this.zD.top, this.zC);
            PointF a2 = a(this.zD.right, this.zD.bottom, this.zC);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.zC != null) {
            canvas.concat(this.zC);
        }
        if (cVar.m10if()) {
            Bitmap bitmap = cVar.zK.getBitmap();
            this.zJ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.zJ, this.zD, this.mPaint);
            return;
        }
        this.zJ.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.zL.a(canvas, this.zJ, this.zD, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zN) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.zS != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.zI.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.zB.setColor(this.mArgs.zS);
            canvas.drawRect(this.zI, this.zB);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
