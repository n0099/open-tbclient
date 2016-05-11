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
    private final Paint sL = new Paint();
    private final Paint sM = new Paint();
    private final Rect sN = new Rect(0, 0, 0, 0);
    private final Rect sO = new Rect(0, 0, 0, 0);

    public h() {
        this.sL.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.sL.setStyle(Paint.Style.FILL);
        this.sL.setAntiAlias(true);
        this.sM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.rU != null) {
            canvas.concat(this.rU);
        }
        if (dVar.gN()) {
            Bitmap bitmap = dVar.sw.getBitmap();
            if (this.sS) {
                a(canvas, bitmap);
                return;
            }
            this.sO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sx.a(canvas, this.sO, this.rV, this.mPaint);
        } else if (dVar.gO()) {
            if (this.sS) {
                a(canvas, dVar.sx.iY());
                return;
            }
            this.sO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sx.a(canvas, this.sO, this.rV, this.mPaint);
        } else {
            this.sO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sx.a(canvas, this.sO, this.rV, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.sO.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.sN.set(0, 0, (int) this.rV.width(), (int) this.rV.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.sP, this.sL);
        canvas.drawBitmap(bitmap, this.sO, this.rV, this.sM);
        canvas.restore();
    }
}
