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
    private final Paint Bv = new Paint();
    private final Paint Bw = new Paint();
    private final Rect Bx = new Rect(0, 0, 0, 0);
    private final Rect By = new Rect(0, 0, 0, 0);

    public h() {
        this.Bv.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Bv.setStyle(Paint.Style.FILL);
        this.Bv.setAntiAlias(true);
        this.Bw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AW != null) {
            canvas.concat(this.AW);
        }
        if (dVar.iA()) {
            Bitmap bitmap = dVar.Bg.getBitmap();
            if (this.BC) {
                a(canvas, bitmap);
                return;
            }
            this.By.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bh.a(canvas, this.By, this.AX, this.mPaint);
        } else if (dVar.iB()) {
            if (this.BC) {
                a(canvas, dVar.Bh.kK());
                return;
            }
            this.By.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bh.a(canvas, this.By, this.AX, this.mPaint);
        } else {
            this.By.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bh.a(canvas, this.By, this.AX, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.By.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Bx.set(0, 0, (int) this.AX.width(), (int) this.AX.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Bz, this.Bv);
        canvas.drawBitmap(bitmap, this.By, this.AX, this.Bw);
        canvas.restore();
    }
}
