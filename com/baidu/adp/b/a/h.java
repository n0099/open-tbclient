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
    private final Paint BJ = new Paint();
    private final Paint BK = new Paint();
    private final Rect BL = new Rect(0, 0, 0, 0);
    private final Rect BM = new Rect(0, 0, 0, 0);

    public h() {
        this.BJ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BJ.setStyle(Paint.Style.FILL);
        this.BJ.setAntiAlias(true);
        this.BK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AU != null) {
            canvas.concat(this.AU);
        }
        if (dVar.iE()) {
            Bitmap bitmap = dVar.Bu.getBitmap();
            if (this.BQ) {
                a(canvas, bitmap);
                return;
            }
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AV, this.mPaint);
        } else if (dVar.iF()) {
            if (this.BQ) {
                a(canvas, dVar.Bv.kO());
                return;
            }
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AV, this.mPaint);
        } else {
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AV, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BM.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BL.set(0, 0, (int) this.AV.width(), (int) this.AV.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BN, this.BJ);
        canvas.drawBitmap(bitmap, this.BM, this.AV, this.BK);
        canvas.restore();
    }
}
