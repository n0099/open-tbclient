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
public class h extends j {
    private final Paint rz = new Paint();
    private final Paint rA = new Paint();
    private final Rect rB = new Rect(0, 0, 0, 0);
    private final Rect rC = new Rect(0, 0, 0, 0);

    public h() {
        this.rz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.rz.setStyle(Paint.Style.FILL);
        this.rz.setAntiAlias(true);
        this.rA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qH != null) {
            canvas.concat(this.qH);
        }
        if (dVar.gE()) {
            Bitmap bitmap = dVar.rj.getBitmap();
            if (this.rG) {
                a(canvas, bitmap);
                return;
            }
            this.rC.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rk.a(canvas, this.rC, this.qI, this.mPaint);
        } else if (dVar.gF()) {
            if (this.rG) {
                a(canvas, dVar.rk.jc());
                return;
            }
            this.rC.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rk.a(canvas, this.rC, this.qI, this.mPaint);
        } else {
            this.rC.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rk.a(canvas, this.rC, this.qI, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.rC.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.rB.set(0, 0, (int) this.qI.width(), (int) this.qI.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.rD, this.rz);
        canvas.drawBitmap(bitmap, this.rC, this.qI, this.rA);
        canvas.restore();
    }
}
