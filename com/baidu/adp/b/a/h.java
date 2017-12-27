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
    private final Paint apC = new Paint();
    private final Paint apD = new Paint();
    private final Rect apE = new Rect(0, 0, 0, 0);
    private final Rect apF = new Rect(0, 0, 0, 0);

    public h() {
        this.apC.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apC.setStyle(Paint.Style.FILL);
        this.apC.setAntiAlias(true);
        this.apD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.apf != null) {
            canvas.concat(this.apf);
        }
        if (dVar.pZ()) {
            Bitmap bitmap = dVar.apo.getBitmap();
            if (this.apJ) {
                a(canvas, bitmap);
                return;
            }
            this.apF.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apq.a(canvas, this.apF, this.apg, this.mPaint);
        } else if (dVar.qa()) {
            if (this.apJ) {
                a(canvas, dVar.apq.si());
                return;
            }
            this.apF.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apq.a(canvas, this.apF, this.apg, this.mPaint);
        } else {
            this.apF.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apq.a(canvas, this.apF, this.apg, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apF.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apE.set(0, 0, (int) this.apg.width(), (int) this.apg.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apG, this.apC);
        canvas.drawBitmap(bitmap, this.apF, this.apg, this.apD);
        canvas.restore();
    }
}
