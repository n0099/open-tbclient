package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Dz = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Dh.DD) {
            float f = this.Dh.DE / 2.0f;
            if (!this.Dh.DH) {
                this.Dd.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Dc.left, this.Dc.top, this.Db);
            PointF a2 = a(this.Dc.right, this.Dc.bottom, this.Db);
            this.Dd.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Db != null) {
            canvas.concat(this.Db);
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.DA.getBitmap();
            this.Dz.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Dz, this.Dc, this.mPaint);
            return;
        }
        this.Dz.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.DB.a(canvas, this.Dz, this.Dc, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Dh.DD) {
            canvas.drawRect(this.Dd, this.CZ);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Dh.DL != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Dk.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Da.setColor(this.Dh.DL);
            canvas.drawRect(this.Dk, this.Da);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
