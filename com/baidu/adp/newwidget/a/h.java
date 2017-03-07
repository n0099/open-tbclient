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
    private final Paint CK = new Paint();
    private final Paint CL = new Paint();
    private final Rect CM = new Rect(0, 0, 0, 0);
    private final Rect CN = new Rect(0, 0, 0, 0);

    public h() {
        this.CK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.CK.setStyle(Paint.Style.FILL);
        this.CK.setAntiAlias(true);
        this.CL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.BV != null) {
            canvas.concat(this.BV);
        }
        if (dVar.iB()) {
            Bitmap bitmap = dVar.Cv.getBitmap();
            if (this.CR) {
                a(canvas, bitmap);
                return;
            }
            this.CN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Cw.a(canvas, this.CN, this.BW, this.mPaint);
        } else if (dVar.iC()) {
            if (this.CR) {
                a(canvas, dVar.Cw.kN());
                return;
            }
            this.CN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Cw.a(canvas, this.CN, this.BW, this.mPaint);
        } else {
            this.CN.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Cw.a(canvas, this.CN, this.BW, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.CN.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.CM.set(0, 0, (int) this.BW.width(), (int) this.BW.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.CO, this.CK);
        canvas.drawBitmap(bitmap, this.CN, this.BW, this.CL);
        canvas.restore();
    }
}
