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
    private final Paint Co = new Paint();
    private final Paint Cp = new Paint();
    private final Rect Cq = new Rect(0, 0, 0, 0);
    private final Rect Cr = new Rect(0, 0, 0, 0);

    public h() {
        this.Co.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Co.setStyle(Paint.Style.FILL);
        this.Co.setAntiAlias(true);
        this.Cp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bz != null) {
            canvas.concat(this.Bz);
        }
        if (dVar.iE()) {
            Bitmap bitmap = dVar.BZ.getBitmap();
            if (this.Cv) {
                a(canvas, bitmap);
                return;
            }
            this.Cr.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ca.a(canvas, this.Cr, this.BA, this.mPaint);
        } else if (dVar.iF()) {
            if (this.Cv) {
                a(canvas, dVar.Ca.kP());
                return;
            }
            this.Cr.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ca.a(canvas, this.Cr, this.BA, this.mPaint);
        } else {
            this.Cr.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ca.a(canvas, this.Cr, this.BA, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Cr.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Cq.set(0, 0, (int) this.BA.width(), (int) this.BA.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Cs, this.Co);
        canvas.drawBitmap(bitmap, this.Cr, this.BA, this.Cp);
        canvas.restore();
    }
}
