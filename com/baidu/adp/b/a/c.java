package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Bv = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Bc.Bz) {
            float f = this.Bc.BA / 2.0f;
            if (!this.Bc.BD) {
                this.AY.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.AX.left, this.AX.top, this.AW);
            PointF a2 = a(this.AX.right, this.AX.bottom, this.AW);
            this.AY.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AW != null) {
            canvas.concat(this.AW);
        }
        if (dVar.iD()) {
            Bitmap bitmap = dVar.Bw.getBitmap();
            this.Bv.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Bv, this.AX, this.mPaint);
            return;
        }
        this.Bv.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Bx.a(canvas, this.Bv, this.AX, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bc.Bz) {
            canvas.drawRect(this.AY, this.AU);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bc.BH != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bf.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.AV.setColor(this.Bc.BH);
            canvas.drawRect(this.Bf, this.AV);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
