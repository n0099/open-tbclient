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
    private final Paint Cb = new Paint();
    private final Paint Cc = new Paint();
    private final Rect Cd = new Rect(0, 0, 0, 0);
    private final Rect Ce = new Rect(0, 0, 0, 0);

    public h() {
        this.Cb.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cb.setStyle(Paint.Style.FILL);
        this.Cb.setAntiAlias(true);
        this.Cc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bm != null) {
            canvas.concat(this.Bm);
        }
        if (dVar.ku()) {
            Bitmap bitmap = dVar.BM.getBitmap();
            if (this.Ci) {
                a(canvas, bitmap);
                return;
            }
            this.Ce.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BN.a(canvas, this.Ce, this.Bn, this.mPaint);
        } else if (dVar.kv()) {
            if (this.Ci) {
                a(canvas, dVar.BN.mS());
                return;
            }
            this.Ce.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BN.a(canvas, this.Ce, this.Bn, this.mPaint);
        } else {
            this.Ce.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BN.a(canvas, this.Ce, this.Bn, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Ce.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Cd.set(0, 0, (int) this.Bn.width(), (int) this.Bn.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Cf, this.Cb);
        canvas.drawBitmap(bitmap, this.Ce, this.Bn, this.Cc);
        canvas.restore();
    }
}
