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
    private final Paint Cm = new Paint();
    private final Paint Cn = new Paint();
    private final Rect Co = new Rect(0, 0, 0, 0);
    private final Rect Cp = new Rect(0, 0, 0, 0);

    public h() {
        this.Cm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cm.setStyle(Paint.Style.FILL);
        this.Cm.setAntiAlias(true);
        this.Cn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bv != null) {
            canvas.concat(this.Bv);
        }
        if (dVar.jZ()) {
            Bitmap bitmap = dVar.BX.getBitmap();
            if (this.Ct) {
                a(canvas, bitmap);
                return;
            }
            this.Cp.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BY.a(canvas, this.Cp, this.Bw, this.mPaint);
        } else if (dVar.ka()) {
            if (this.Ct) {
                a(canvas, dVar.BY.mz());
                return;
            }
            this.Cp.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BY.a(canvas, this.Cp, this.Bw, this.mPaint);
        } else {
            this.Cp.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BY.a(canvas, this.Cp, this.Bw, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Cp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Co.set(0, 0, (int) this.Bw.width(), (int) this.Bw.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Cq, this.Cm);
        canvas.drawBitmap(bitmap, this.Cp, this.Bw, this.Cn);
        canvas.restore();
    }
}
