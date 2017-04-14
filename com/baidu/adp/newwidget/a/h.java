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
    private final Paint Cl = new Paint();
    private final Paint Cm = new Paint();
    private final Rect Cn = new Rect(0, 0, 0, 0);
    private final Rect Co = new Rect(0, 0, 0, 0);

    public h() {
        this.Cl.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cl.setStyle(Paint.Style.FILL);
        this.Cl.setAntiAlias(true);
        this.Cm.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bw != null) {
            canvas.concat(this.Bw);
        }
        if (dVar.iF()) {
            Bitmap bitmap = dVar.BW.getBitmap();
            if (this.Cs) {
                a(canvas, bitmap);
                return;
            }
            this.Co.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BX.a(canvas, this.Co, this.Bx, this.mPaint);
        } else if (dVar.iG()) {
            if (this.Cs) {
                a(canvas, dVar.BX.kR());
                return;
            }
            this.Co.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BX.a(canvas, this.Co, this.Bx, this.mPaint);
        } else {
            this.Co.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BX.a(canvas, this.Co, this.Bx, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Co.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Cn.set(0, 0, (int) this.Bx.width(), (int) this.Bx.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Cp, this.Cl);
        canvas.drawBitmap(bitmap, this.Co, this.Bx, this.Cm);
        canvas.restore();
    }
}
