package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect aph = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.mArgs.apl) {
            float f = this.mArgs.mBorderWidth / 2.0f;
            if (!this.mArgs.apm) {
                this.mBorderRect.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.apa.left, this.apa.top, this.aoZ);
            PointF a2 = a(this.apa.right, this.apa.bottom, this.aoZ);
            this.mBorderRect.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.aoZ != null) {
            canvas.concat(this.aoZ);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.api.getBitmap();
            this.aph.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.aph, this.apa, this.mPaint);
            return;
        }
        this.aph.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.apj.a(canvas, this.aph, this.apa, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apl) {
            canvas.drawRect(this.mBorderRect, this.mBorderPaint);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apr != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apf.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.aoY.setColor(this.mArgs.apr);
            canvas.drawRect(this.apf, this.aoY);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
