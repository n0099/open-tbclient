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
        if (this.Bp.BP) {
            float f = this.Bp.BQ / 2.0f;
            if (!this.Bp.BT) {
                this.Bm.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bl.left, this.Bl.top, this.Bk);
            PointF a2 = a(this.Bl.right, this.Bl.bottom, this.Bk);
            this.Bm.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bk != null) {
            canvas.concat(this.Bk);
        }
        if (dVar.kq()) {
            Bitmap bitmap = dVar.BM.getBitmap();
            this.BL.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BL, this.Bl, this.mPaint);
            return;
        }
        this.BL.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BN.a(canvas, this.BL, this.Bl, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bp.BP) {
            canvas.drawRect(this.Bm, this.Bi);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bp.BX != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bs.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bj.setColor(this.Bp.BX);
            canvas.drawRect(this.Bs, this.Bj);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
