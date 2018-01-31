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
    private final Paint apE = new Paint();
    private final Paint apF = new Paint();
    private final Rect apG = new Rect(0, 0, 0, 0);
    private final Rect apH = new Rect(0, 0, 0, 0);

    public h() {
        this.apE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apE.setStyle(Paint.Style.FILL);
        this.apE.setAntiAlias(true);
        this.apF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.aph != null) {
            canvas.concat(this.aph);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apr.getBitmap();
            if (this.apL) {
                a(canvas, bitmap);
                return;
            }
            this.apH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.aps.a(canvas, this.apH, this.api, this.mPaint);
        } else if (dVar.qb()) {
            if (this.apL) {
                a(canvas, dVar.aps.sj());
                return;
            }
            this.apH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.aps.a(canvas, this.apH, this.api, this.mPaint);
        } else {
            this.apH.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.aps.a(canvas, this.apH, this.api, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apH.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apG.set(0, 0, (int) this.api.width(), (int) this.api.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apI, this.apE);
        canvas.drawBitmap(bitmap, this.apH, this.api, this.apF);
        canvas.restore();
    }
}
