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
    private final Paint Bw = new Paint();
    private final Paint Bx = new Paint();
    private final Rect By = new Rect(0, 0, 0, 0);
    private final Rect Bz = new Rect(0, 0, 0, 0);

    public h() {
        this.Bw.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Bw.setStyle(Paint.Style.FILL);
        this.Bw.setAntiAlias(true);
        this.Bx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        if (dVar.iA()) {
            Bitmap bitmap = dVar.Bh.getBitmap();
            if (this.BD) {
                a(canvas, bitmap);
                return;
            }
            this.Bz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bi.a(canvas, this.Bz, this.AY, this.mPaint);
        } else if (dVar.iB()) {
            if (this.BD) {
                a(canvas, dVar.Bi.kK());
                return;
            }
            this.Bz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bi.a(canvas, this.Bz, this.AY, this.mPaint);
        } else {
            this.Bz.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bi.a(canvas, this.Bz, this.AY, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Bz.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.By.set(0, 0, (int) this.AY.width(), (int) this.AY.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BA, this.Bw);
        canvas.drawBitmap(bitmap, this.Bz, this.AY, this.Bx);
        canvas.restore();
    }
}
