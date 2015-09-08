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

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AV != null) {
            canvas.concat(this.AV);
        }
        if (dVar.kg()) {
            Bitmap bitmap = dVar.Bu.getBitmap();
            if (this.BQ) {
                a(canvas, bitmap);
                return;
            }
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AW, this.mPaint);
        } else if (dVar.kh()) {
            if (this.BQ) {
                a(canvas, dVar.Bv.mZ());
                return;
            }
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AW, this.mPaint);
        } else {
            this.BM.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bv.a(canvas, this.BM, this.AW, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BM.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BL.set(0, 0, (int) this.AW.width(), (int) this.AW.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BN, this.BJ);
        canvas.drawBitmap(bitmap, this.BM, this.AW, this.BK);
        canvas.restore();
    }
}
