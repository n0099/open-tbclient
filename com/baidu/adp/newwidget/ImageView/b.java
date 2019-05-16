package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect GH = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.GL) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.GM) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.GB.left, this.GB.top, this.GA);
            PointF a2 = a(this.GB.right, this.GB.bottom, this.GA);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.GA != null) {
            canvas.concat(this.GA);
        }
        if (cVar.lh()) {
            Bitmap bitmap = cVar.GI.getBitmap();
            this.GH.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.GH, this.GB, this.mPaint);
            return;
        }
        this.GH.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.GJ.a(canvas, this.GH, this.GB, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GL) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GQ != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.GG.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Gz.setColor(this.mArgs.GQ);
            canvas.drawRect(this.GG, this.Gz);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
