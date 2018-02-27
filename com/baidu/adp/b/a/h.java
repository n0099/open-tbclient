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
    private final Paint apu = new Paint();
    private final Paint apv = new Paint();
    private final Rect apw = new Rect(0, 0, 0, 0);
    private final Rect apx = new Rect(0, 0, 0, 0);

    public h() {
        this.apu.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apu.setStyle(Paint.Style.FILL);
        this.apu.setAntiAlias(true);
        this.apv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.aoZ != null) {
            canvas.concat(this.aoZ);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.aph.getBitmap();
            if (this.apB) {
                a(canvas, bitmap);
                return;
            }
            this.apx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.api.a(canvas, this.apx, this.apa, this.mPaint);
        } else if (dVar.qb()) {
            if (this.apB) {
                a(canvas, dVar.api.sh());
                return;
            }
            this.apx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.api.a(canvas, this.apx, this.apa, this.mPaint);
        } else {
            this.apx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.api.a(canvas, this.apx, this.apa, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apx.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apw.set(0, 0, (int) this.apa.width(), (int) this.apa.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apy, this.apu);
        canvas.drawBitmap(bitmap, this.apx, this.apa, this.apv);
        canvas.restore();
    }
}
