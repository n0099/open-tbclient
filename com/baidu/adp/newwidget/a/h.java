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
    private final Paint sM = new Paint();
    private final Paint sN = new Paint();
    private final Rect sO = new Rect(0, 0, 0, 0);
    private final Rect sP = new Rect(0, 0, 0, 0);

    public h() {
        this.sM.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.sM.setStyle(Paint.Style.FILL);
        this.sM.setAntiAlias(true);
        this.sN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.rU != null) {
            canvas.concat(this.rU);
        }
        if (dVar.gP()) {
            Bitmap bitmap = dVar.sx.getBitmap();
            if (this.sT) {
                a(canvas, bitmap);
                return;
            }
            this.sP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sy.a(canvas, this.sP, this.rV, this.mPaint);
        } else if (dVar.gQ()) {
            if (this.sT) {
                a(canvas, dVar.sy.jb());
                return;
            }
            this.sP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sy.a(canvas, this.sP, this.rV, this.mPaint);
        } else {
            this.sP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.sy.a(canvas, this.sP, this.rV, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.sP.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.sO.set(0, 0, (int) this.rV.width(), (int) this.rV.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.sQ, this.sM);
        canvas.drawBitmap(bitmap, this.sP, this.rV, this.sN);
        canvas.restore();
    }
}
