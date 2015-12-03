package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect BB = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.Bi.BF) {
            float f = this.Bi.BG / 2.0f;
            if (!this.Bi.BJ) {
                this.Be.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.Bd.left, this.Bd.top, this.Bc);
            PointF a2 = a(this.Bd.right, this.Bd.bottom, this.Bc);
            this.Be.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bc != null) {
            canvas.concat(this.Bc);
        }
        if (dVar.kj()) {
            Bitmap bitmap = dVar.BC.getBitmap();
            this.BB.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.BB, this.Bd, this.mPaint);
            return;
        }
        this.BB.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.BD.a(canvas, this.BB, this.Bd, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.Bi.BF) {
            canvas.drawRect(this.Be, this.Ba);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.Bi.BN != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.Bl.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.Bb.setColor(this.Bi.BN);
            canvas.drawRect(this.Bl, this.Bb);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
