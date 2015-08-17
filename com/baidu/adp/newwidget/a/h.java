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
    private final Paint BL = new Paint();
    private final Paint BM = new Paint();
    private final Rect BN = new Rect(0, 0, 0, 0);
    private final Rect BO = new Rect(0, 0, 0, 0);

    public h() {
        this.BL.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BL.setStyle(Paint.Style.FILL);
        this.BL.setAntiAlias(true);
        this.BM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        if (dVar.kj()) {
            Bitmap bitmap = dVar.Bw.getBitmap();
            if (this.BS) {
                a(canvas, bitmap);
                return;
            }
            this.BO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bx.a(canvas, this.BO, this.AY, this.mPaint);
        } else if (dVar.kk()) {
            if (this.BS) {
                a(canvas, dVar.Bx.nc());
                return;
            }
            this.BO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bx.a(canvas, this.BO, this.AY, this.mPaint);
        } else {
            this.BO.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.Bx.a(canvas, this.BO, this.AY, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BO.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BN.set(0, 0, (int) this.AY.width(), (int) this.AY.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BP, this.BL);
        canvas.drawBitmap(bitmap, this.BO, this.AY, this.BM);
        canvas.restore();
    }
}
