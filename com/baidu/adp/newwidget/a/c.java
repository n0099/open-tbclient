package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect rd = new Rect();

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.qH.rh) {
            float f = this.qH.ri / 2.0f;
            if (!this.qH.rl) {
                this.qE.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.qD.left, this.qD.top, this.qC);
            PointF a2 = a(this.qD.right, this.qD.bottom, this.qC);
            this.qE.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qC != null) {
            canvas.concat(this.qC);
        }
        if (dVar.gE()) {
            Bitmap bitmap = dVar.re.getBitmap();
            this.rd.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.rd, this.qD, this.mPaint);
            return;
        }
        this.rd.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.rf.a(canvas, this.rd, this.qD, this.mPaint);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.qH.rh) {
            canvas.drawRect(this.qE, this.qA);
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.qH.rq != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.qK.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.qB.setColor(this.qH.rq);
            canvas.drawRect(this.qK, this.qB);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
