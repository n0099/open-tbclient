package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect Cg = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.BN.Ck) {
            float f = this.BN.Cl / 2.0f;
            if (!this.BN.Co) {
                this.BJ.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.BI.left, this.BI.top, this.BH);
            PointF a2 = a(this.BI.right, this.BI.bottom, this.BH);
            this.BJ.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BH != null) {
            canvas.concat(this.BH);
        }
        if (dVar.kA()) {
            Bitmap bitmap = dVar.Ch.getBitmap();
            this.Cg.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.Cg, this.BI, this.mPaint);
            return;
        }
        this.Cg.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.Ci.a(canvas, this.Cg, this.BI, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.BN.Ck) {
            canvas.drawRect(this.BJ, this.BF);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.BN.Cs != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.BQ.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.BG.setColor(this.BN.Cs);
            canvas.drawRect(this.BQ, this.BG);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
