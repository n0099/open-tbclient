package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class g extends j {
    private final Paint Jc = new Paint();
    private final Paint Jd = new Paint();
    private final Rect Je = new Rect(0, 0, 0, 0);
    private final Rect Jf = new Rect(0, 0, 0, 0);

    public g() {
        this.Jc.setColor(-16777216);
        this.Jc.setStyle(Paint.Style.FILL);
        this.Jc.setAntiAlias(true);
        this.Jd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.IG != null) {
            canvas.concat(this.IG);
        }
        if (cVar.ml()) {
            Bitmap bitmap = cVar.IO.getBitmap();
            if (this.Jj) {
                a(canvas, bitmap);
                return;
            }
            this.Jf.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IP.a(canvas, this.Jf, this.mBounds, this.mPaint);
        } else if (cVar.mm()) {
            if (this.Jj) {
                a(canvas, cVar.IP.os());
                return;
            }
            this.Jf.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IP.a(canvas, this.Jf, this.mBounds, this.mPaint);
        } else {
            this.Jf.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IP.a(canvas, this.Jf, this.mBounds, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Jf.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Je.set(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Jg, this.Jc);
        canvas.drawBitmap(bitmap, this.Jf, this.mBounds, this.Jd);
        canvas.restore();
    }
}
