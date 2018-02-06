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
    private final Paint apD = new Paint();
    private final Paint apE = new Paint();
    private final Rect apF = new Rect(0, 0, 0, 0);
    private final Rect apG = new Rect(0, 0, 0, 0);

    public h() {
        this.apD.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apD.setStyle(Paint.Style.FILL);
        this.apD.setAntiAlias(true);
        this.apE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.apg != null) {
            canvas.concat(this.apg);
        }
        if (dVar.qa()) {
            Bitmap bitmap = dVar.apq.getBitmap();
            if (this.apK) {
                a(canvas, bitmap);
                return;
            }
            this.apG.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apr.a(canvas, this.apG, this.aph, this.mPaint);
        } else if (dVar.qb()) {
            if (this.apK) {
                a(canvas, dVar.apr.sh());
                return;
            }
            this.apG.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apr.a(canvas, this.apG, this.aph, this.mPaint);
        } else {
            this.apG.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.apr.a(canvas, this.apG, this.aph, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.apG.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.apF.set(0, 0, (int) this.aph.width(), (int) this.aph.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.apH, this.apD);
        canvas.drawBitmap(bitmap, this.apG, this.aph, this.apE);
        canvas.restore();
    }
}
