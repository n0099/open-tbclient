package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect GG = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.GK) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.GL) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.GA.left, this.GA.top, this.Gz);
            PointF a2 = a(this.GA.right, this.GA.bottom, this.Gz);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.Gz != null) {
            canvas.concat(this.Gz);
        }
        if (cVar.lh()) {
            Bitmap bitmap = cVar.GH.getBitmap();
            this.GG.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.GG, this.GA, this.mPaint);
            return;
        }
        this.GG.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.GI.a(canvas, this.GG, this.GA, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GK) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GP != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.GF.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Gy.setColor(this.mArgs.GP);
            canvas.drawRect(this.GF, this.Gy);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
