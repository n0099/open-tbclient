package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect apo = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.mArgs.apt) {
            float f = this.mArgs.ou / 2.0f;
            if (!this.mArgs.apv) {
                this.api.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.aph.left, this.aph.top, this.apg);
            PointF a2 = a(this.aph.right, this.aph.bottom, this.apg);
            this.api.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.apg != null) {
            canvas.concat(this.apg);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apq.getBitmap();
            this.apo.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.apo, this.aph, this.mPaint);
            return;
        }
        this.apo.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.apr.a(canvas, this.apo, this.aph, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apt) {
            canvas.drawRect(this.api, this.ape);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apz != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apn.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.apf.setColor(this.mArgs.apz);
            canvas.drawRect(this.apn, this.apf);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
