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
    private final Paint BT = new Paint();
    private final Paint BU = new Paint();
    private final Rect BV = new Rect(0, 0, 0, 0);
    private final Rect BW = new Rect(0, 0, 0, 0);

    public h() {
        this.BT.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BT.setStyle(Paint.Style.FILL);
        this.BT.setAntiAlias(true);
        this.BU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Be != null) {
            canvas.concat(this.Be);
        }
        if (dVar.kk()) {
            Bitmap bitmap = dVar.BE.getBitmap();
            if (this.Ca) {
                a(canvas, bitmap);
                return;
            }
            this.BW.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BF.a(canvas, this.BW, this.Bf, this.mPaint);
        } else if (dVar.kl()) {
            if (this.Ca) {
                a(canvas, dVar.BF.mE());
                return;
            }
            this.BW.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BF.a(canvas, this.BW, this.Bf, this.mPaint);
        } else {
            this.BW.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BF.a(canvas, this.BW, this.Bf, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BW.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BV.set(0, 0, (int) this.Bf.width(), (int) this.Bf.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BX, this.BT);
        canvas.drawBitmap(bitmap, this.BW, this.Bf, this.BU);
        canvas.restore();
    }
}
