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
    private final Paint apB = new Paint();
    private final Paint apC = new Paint();
    private final Rect apD = new Rect(0, 0, 0, 0);
    private final Rect apE = new Rect(0, 0, 0, 0);

    public h() {
        this.apB.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apB.setStyle(Paint.Style.FILL);
        this.apB.setAntiAlias(true);
        this.apC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.ape != null) {
            canvas.concat(this.ape);
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apn.getBitmap();
            if (this.apI) {
                a(canvas, bitmap);
                return;
            }
            this.apE.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apo.a(canvas, this.apE, this.apf, this.mPaint);
        } else if (dVar.qa()) {
            if (this.apI) {
                a(canvas, dVar.apo.si());
                return;
            }
            this.apE.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apo.a(canvas, this.apE, this.apf, this.mPaint);
        } else {
            this.apE.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apo.a(canvas, this.apE, this.apf, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apE.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apD.set(0, 0, (int) this.apf.width(), (int) this.apf.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apF, this.apB);
        canvas.drawBitmap(bitmap, this.apE, this.apf, this.apC);
        canvas.restore();
    }
}
