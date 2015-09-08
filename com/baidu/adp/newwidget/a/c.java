package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Bt = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Ba.Bx) {
            float f = this.Ba.By / 2.0f;
            if (!this.Ba.BB) {
                this.AX.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.AW.left, this.AW.top, this.AV);
            PointF a2 = a(this.AW.right, this.AW.bottom, this.AV);
            this.AX.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AV != null) {
            canvas.concat(this.AV);
        }
        if (dVar.kg()) {
            Bitmap bitmap = dVar.Bu.getBitmap();
            this.Bt.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Bt, this.AW, this.mPaint);
            return;
        }
        this.Bt.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Bv.a(canvas, this.Bt, this.AW, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Ba.Bx) {
            canvas.drawRect(this.AX, this.AT);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Ba.BF != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bd.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.AU.setColor(this.Ba.BF);
            canvas.drawRect(this.Bd, this.AU);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
