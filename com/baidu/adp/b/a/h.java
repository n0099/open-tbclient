package com.baidu.adp.b.a;

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
    private final Paint DN = new Paint();
    private final Paint DO = new Paint();
    private final Rect DP = new Rect(0, 0, 0, 0);
    private final Rect DQ = new Rect(0, 0, 0, 0);

    public h() {
        this.DN.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.DN.setStyle(Paint.Style.FILL);
        this.DN.setAntiAlias(true);
        this.DO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.CZ != null) {
            canvas.concat(this.CZ);
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.Dy.getBitmap();
            if (this.DU) {
                a(canvas, bitmap);
                return;
            }
            this.DQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Dz.a(canvas, this.DQ, this.Da, this.mPaint);
        } else if (dVar.iN()) {
            if (this.DU) {
                a(canvas, dVar.Dz.kX());
                return;
            }
            this.DQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Dz.a(canvas, this.DQ, this.Da, this.mPaint);
        } else {
            this.DQ.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Dz.a(canvas, this.DQ, this.Da, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.DQ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.DP.set(0, 0, (int) this.Da.width(), (int) this.Da.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.DR, this.DN);
        canvas.drawBitmap(bitmap, this.DQ, this.Da, this.DO);
        canvas.restore();
    }
}
