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
    private final Paint BM = new Paint();
    private final Paint BN = new Paint();
    private final Rect BO = new Rect(0, 0, 0, 0);
    private final Rect BP = new Rect(0, 0, 0, 0);

    public h() {
        this.BM.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BM.setStyle(Paint.Style.FILL);
        this.BM.setAntiAlias(true);
        this.BN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.AX != null) {
            canvas.concat(this.AX);
        }
        if (dVar.iD()) {
            Bitmap bitmap = dVar.Bx.getBitmap();
            if (this.BT) {
                a(canvas, bitmap);
                return;
            }
            this.BP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.By.a(canvas, this.BP, this.AY, this.mPaint);
        } else if (dVar.iE()) {
            if (this.BT) {
                a(canvas, dVar.By.kN());
                return;
            }
            this.BP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.By.a(canvas, this.BP, this.AY, this.mPaint);
        } else {
            this.BP.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.By.a(canvas, this.BP, this.AY, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BP.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BO.set(0, 0, (int) this.AY.width(), (int) this.AY.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BQ, this.BM);
        canvas.drawBitmap(bitmap, this.BP, this.AY, this.BN);
        canvas.restore();
    }
}
