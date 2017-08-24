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
    private final Paint DP = new Paint();
    private final Paint DQ = new Paint();
    private final Rect DR = new Rect(0, 0, 0, 0);
    private final Rect DS = new Rect(0, 0, 0, 0);

    public h() {
        this.DP.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.DP.setStyle(Paint.Style.FILL);
        this.DP.setAntiAlias(true);
        this.DQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.b.a.c, com.baidu.adp.b.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Db != null) {
            canvas.concat(this.Db);
        }
        if (dVar.iM()) {
            Bitmap bitmap = dVar.DA.getBitmap();
            if (this.DW) {
                a(canvas, bitmap);
                return;
            }
            this.DS.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.DB.a(canvas, this.DS, this.Dc, this.mPaint);
        } else if (dVar.iN()) {
            if (this.DW) {
                a(canvas, dVar.DB.kW());
                return;
            }
            this.DS.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.DB.a(canvas, this.DS, this.Dc, this.mPaint);
        } else {
            this.DS.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.DB.a(canvas, this.DS, this.Dc, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.DS.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.DR.set(0, 0, (int) this.Dc.width(), (int) this.Dc.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.DT, this.DP);
        canvas.drawBitmap(bitmap, this.DS, this.Dc, this.DQ);
        canvas.restore();
    }
}
