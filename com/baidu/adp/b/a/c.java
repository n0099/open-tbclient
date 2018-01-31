package com.baidu.adp.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class c extends a {
    private Rect apq = new Rect();

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView) {
        if (this.mArgs.apu) {
            float f = this.mArgs.ou / 2.0f;
            if (!this.mArgs.apw) {
                this.apj.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                return;
            }
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            PointF a = a(this.api.left, this.api.top, this.aph);
            PointF a2 = a(this.api.right, this.api.bottom, this.aph);
            this.apj.set(Math.max((int) a.x, 0) + f, Math.max((int) a.y, 0) + f, Math.min((int) a2.x, width) - f, Math.min((int) a2.y, height) - f);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.aph != null) {
            canvas.concat(this.aph);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apr.getBitmap();
            this.apq.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.apq, this.api, this.mPaint);
            return;
        }
        this.apq.set(0, 0, dVar.getWidth(), dVar.getHeight());
        dVar.aps.a(canvas, this.apq, this.api, this.mPaint);
    }

    @Override // com.baidu.adp.b.a.a
    public void b(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apu) {
            canvas.drawRect(this.apj, this.apf);
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, ImageView imageView) {
        if (this.mArgs.apA != 0) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            canvas.translate(scrollX, scrollY);
            this.apo.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            this.apg.setColor(this.mArgs.apA);
            canvas.drawRect(this.apo, this.apg);
            canvas.translate(-scrollX, -scrollY);
        }
    }
}
