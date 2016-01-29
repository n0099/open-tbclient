package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BL = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Bs.BP) {
            float f = this.Bs.BQ / 2.0f;
            if (!this.Bs.BT) {
                this.Bo.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bn.left, this.Bn.top, this.Bm);
            PointF a2 = a(this.Bn.right, this.Bn.bottom, this.Bm);
            this.Bo.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bm != null) {
            canvas.concat(this.Bm);
        }
        if (dVar.ku()) {
            Bitmap bitmap = dVar.BM.getBitmap();
            this.BL.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BL, this.Bn, this.mPaint);
            return;
        }
        this.BL.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BN.a(canvas, this.BL, this.Bn, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bs.BP) {
            canvas.drawRect(this.Bo, this.Bk);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bs.BX != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bv.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bl.setColor(this.Bs.BX);
            canvas.drawRect(this.Bv, this.Bl);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
