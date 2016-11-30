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
    private final Paint vF = new Paint();
    private final Paint vG = new Paint();
    private final Rect vH = new Rect(0, 0, 0, 0);
    private final Rect vI = new Rect(0, 0, 0, 0);

    public h() {
        this.vF.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.vF.setStyle(Paint.Style.FILL);
        this.vF.setAntiAlias(true);
        this.vG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.uQ != null) {
            canvas.concat(this.uQ);
        }
        if (dVar.hJ()) {
            Bitmap bitmap = dVar.vq.getBitmap();
            if (this.vM) {
                a(canvas, bitmap);
                return;
            }
            this.vI.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vr.a(canvas, this.vI, this.uR, this.mPaint);
        } else if (dVar.hK()) {
            if (this.vM) {
                a(canvas, dVar.vr.jV());
                return;
            }
            this.vI.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vr.a(canvas, this.vI, this.uR, this.mPaint);
        } else {
            this.vI.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.vr.a(canvas, this.vI, this.uR, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.vI.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.vH.set(0, 0, (int) this.uR.width(), (int) this.uR.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.vJ, this.vF);
        canvas.drawBitmap(bitmap, this.vI, this.uR, this.vG);
        canvas.restore();
    }
}
