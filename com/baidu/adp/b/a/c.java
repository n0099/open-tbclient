package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect apn = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.mArgs.aps) {
            float f = this.mArgs.ou / 2.0f;
            if (!this.mArgs.apu) {
                this.aph.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.apg.left, this.apg.top, this.apf);
            PointF a2 = a(this.apg.right, this.apg.bottom, this.apf);
            this.aph.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.apf != null) {
            canvas.concat(this.apf);
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apo.getBitmap();
            this.apn.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.apn, this.apg, this.mPaint);
            return;
        }
        this.apn.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.apq.a(canvas, this.apn, this.apg, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.aps) {
            canvas.drawRect(this.aph, this.apd);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apy != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apm.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.ape.setColor(this.mArgs.apy);
            canvas.drawRect(this.apm, this.ape);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
