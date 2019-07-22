package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends a {
    private Rect GP = new Rect();

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView) {
        if (this.mArgs.GV) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.GX) {
                this.GJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.GI.left, this.GI.top, this.GH);
            PointF a2 = a(this.GI.right, this.GI.bottom, this.GH);
            this.GJ.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.GH != null) {
            canvas.concat(this.GH);
        }
        if (cVar.lx()) {
            Bitmap bitmap = cVar.GQ.getBitmap();
            this.GP.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.GP, this.GI, this.mPaint);
            return;
        }
        this.GP.set(0, 0, cVar.getWidth(), cVar.getHeight());
        cVar.GR.a(canvas, this.GP, this.GI, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.GV) {
            canvas.drawRect(this.GJ, this.GF);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.Hc != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.GO.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.GG.setColor(this.mArgs.Hc);
            canvas.drawRect(this.GO, this.GG);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
