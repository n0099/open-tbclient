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
    private final Paint Cw = new Paint();
    private final Paint Cx = new Paint();
    private final Rect Cy = new Rect(0, 0, 0, 0);
    private final Rect Cz = new Rect(0, 0, 0, 0);

    public h() {
        this.Cw.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cw.setStyle(Paint.Style.FILL);
        this.Cw.setAntiAlias(true);
        this.Cx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BH != null) {
            canvas.concat(this.BH);
        }
        if (dVar.kA()) {
            Bitmap bitmap = dVar.Ch.getBitmap();
            if (this.CD) {
                a(canvas, bitmap);
                return;
            }
            this.Cz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ci.a(canvas, this.Cz, this.BI, this.mPaint);
        } else if (dVar.kB()) {
            if (this.CD) {
                a(canvas, dVar.Ci.mK());
                return;
            }
            this.Cz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ci.a(canvas, this.Cz, this.BI, this.mPaint);
        } else {
            this.Cz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Ci.a(canvas, this.Cz, this.BI, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Cz.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Cy.set(0, 0, (int) this.BI.width(), (int) this.BI.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.CA, this.Cw);
        canvas.drawBitmap(bitmap, this.Cz, this.BI, this.Cx);
        canvas.restore();
    }
}
