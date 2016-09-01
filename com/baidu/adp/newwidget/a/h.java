package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class h extends k {
    private final Paint vE = new Paint();
    private final Paint vF = new Paint();
    private final Rect vG = new Rect(0, 0, 0, 0);
    private final Rect vH = new Rect(0, 0, 0, 0);

    public h() {
        this.vE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.vE.setStyle(Paint.Style.FILL);
        this.vE.setAntiAlias(true);
        this.vF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uP != null) {
            canvas.concat(this.uP);
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vp.getBitmap();
            if (this.vL) {
                a(canvas, bitmap);
                return;
            }
            this.vH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vq.a(canvas, this.vH, this.uQ, this.mPaint);
        } else if (dVar.hK()) {
            if (this.vL) {
                a(canvas, dVar.vq.jV());
                return;
            }
            this.vH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vq.a(canvas, this.vH, this.uQ, this.mPaint);
        } else {
            this.vH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vq.a(canvas, this.vH, this.uQ, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.vH.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.vG.set(0, 0, (int) this.uQ.width(), (int) this.uQ.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.vI, this.vE);
        canvas.drawBitmap(bitmap, this.vH, this.uQ, this.vF);
        canvas.restore();
    }
}
