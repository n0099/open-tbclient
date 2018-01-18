package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect apm = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.mArgs.apr) {
            float f = this.mArgs.ou / 2.0f;
            if (!this.mArgs.apt) {
                this.apg.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.apf.left, this.apf.top, this.ape);
            PointF a2 = a(this.apf.right, this.apf.bottom, this.ape);
            this.apg.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.ape != null) {
            canvas.concat(this.ape);
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apn.getBitmap();
            this.apm.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.apm, this.apf, this.mPaint);
            return;
        }
        this.apm.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.apo.a(canvas, this.apm, this.apf, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apr) {
            canvas.drawRect(this.apg, this.apc);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apx != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apl.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.apd.setColor(this.mArgs.apx);
            canvas.drawRect(this.apl, this.apd);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
