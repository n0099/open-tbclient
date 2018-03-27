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
    private final Paint apv = new Paint();
    private final Paint apw = new Paint();
    private final Rect apx = new Rect(0, 0, 0, 0);
    private final Rect apy = new Rect(0, 0, 0, 0);

    public h() {
        this.apv.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apv.setStyle(Paint.Style.FILL);
        this.apv.setAntiAlias(true);
        this.apw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.aoZ != null) {
            canvas.concat(this.aoZ);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.api.getBitmap();
            if (this.apC) {
                a(canvas, bitmap);
                return;
            }
            this.apy.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apj.a(canvas, this.apy, this.apa, this.mPaint);
        } else if (dVar.qb()) {
            if (this.apC) {
                a(canvas, dVar.apj.sh());
                return;
            }
            this.apy.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apj.a(canvas, this.apy, this.apa, this.mPaint);
        } else {
            this.apy.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apj.a(canvas, this.apy, this.apa, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apy.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apx.set(0, 0, (int) this.apa.width(), (int) this.apa.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apz, this.apv);
        canvas.drawBitmap(bitmap, this.apy, this.apa, this.apw);
        canvas.restore();
    }
}
