package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Dx = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Df.DB) {
            float f = this.Df.DC / 2.0f;
            if (!this.Df.DF) {
                this.Db.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Da.left, this.Da.top, this.CZ);
            PointF a2 = a(this.Da.right, this.Da.bottom, this.CZ);
            this.Db.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.CZ != null) {
            canvas.concat(this.CZ);
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.Dy.getBitmap();
            this.Dx.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Dx, this.Da, this.mPaint);
            return;
        }
        this.Dx.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Dz.a(canvas, this.Dx, this.Da, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Df.DB) {
            canvas.drawRect(this.Db, this.CX);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Df.DJ != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Di.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.CY.setColor(this.Df.DJ);
            canvas.drawRect(this.Di, this.CY);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
