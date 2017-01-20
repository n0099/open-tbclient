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
    private final Paint vw = new Paint();
    private final Paint vx = new Paint();
    private final Rect vy = new Rect(0, 0, 0, 0);
    private final Rect vz = new Rect(0, 0, 0, 0);

    public h() {
        this.vw.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.vw.setStyle(Paint.Style.FILL);
        this.vw.setAntiAlias(true);
        this.vx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uH != null) {
            canvas.concat(this.uH);
        }
        if (dVar.hH()) {
            Bitmap bitmap = dVar.vh.getBitmap();
            if (this.vD) {
                a(canvas, bitmap);
                return;
            }
            this.vz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vi.a(canvas, this.vz, this.uI, this.mPaint);
        } else if (dVar.hI()) {
            if (this.vD) {
                a(canvas, dVar.vi.jT());
                return;
            }
            this.vz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vi.a(canvas, this.vz, this.uI, this.mPaint);
        } else {
            this.vz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vi.a(canvas, this.vz, this.uI, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.vz.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.vy.set(0, 0, (int) this.uI.width(), (int) this.uI.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.vA, this.vw);
        canvas.drawBitmap(bitmap, this.vz, this.uI, this.vx);
        canvas.restore();
    }
}
