package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BD = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Bk.BH) {
            float f = this.Bk.BI / 2.0f;
            if (!this.Bk.BL) {
                this.Bg.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bf.left, this.Bf.top, this.Be);
            PointF a2 = a(this.Bf.right, this.Bf.bottom, this.Be);
            this.Bg.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Be != null) {
            canvas.concat(this.Be);
        }
        if (dVar.kk()) {
            Bitmap bitmap = dVar.BE.getBitmap();
            this.BD.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BD, this.Bf, this.mPaint);
            return;
        }
        this.BD.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BF.a(canvas, this.BD, this.Bf, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bk.BH) {
            canvas.drawRect(this.Bg, this.Bc);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bk.BP != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bn.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bd.setColor(this.Bk.BP);
            canvas.drawRect(this.Bn, this.Bd);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
