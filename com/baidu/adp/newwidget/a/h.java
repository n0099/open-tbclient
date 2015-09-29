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
    private final Paint BK = new Paint();
    private final Paint BL = new Paint();
    private final Rect BM = new Rect(0, 0, 0, 0);
    private final Rect BN = new Rect(0, 0, 0, 0);

    public h() {
        this.BK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BK.setStyle(Paint.Style.FILL);
        this.BK.setAntiAlias(true);
        this.BL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AW != null) {
            canvas.concat(this.AW);
        }
        if (dVar.kh()) {
            Bitmap bitmap = dVar.Bv.getBitmap();
            if (this.BR) {
                a(canvas, bitmap);
                return;
            }
            this.BN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bw.a(canvas, this.BN, this.AX, this.mPaint);
        } else if (dVar.ki()) {
            if (this.BR) {
                a(canvas, dVar.Bw.na());
                return;
            }
            this.BN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bw.a(canvas, this.BN, this.AX, this.mPaint);
        } else {
            this.BN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bw.a(canvas, this.BN, this.AX, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BN.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BM.set(0, 0, (int) this.AX.width(), (int) this.AX.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BO, this.BK);
        canvas.drawBitmap(bitmap, this.BN, this.AX, this.BL);
        canvas.restore();
    }
}
