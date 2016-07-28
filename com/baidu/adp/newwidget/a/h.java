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
public class h extends k {
    private final Paint tr = new Paint();
    private final Paint ts = new Paint();
    private final Rect tt = new Rect(0, 0, 0, 0);
    private final Rect tu = new Rect(0, 0, 0, 0);

    public h() {
        this.tr.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.tr.setStyle(Paint.Style.FILL);
        this.tr.setAntiAlias(true);
        this.ts.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.sz != null) {
            canvas.concat(this.sz);
        }
        if (dVar.gO()) {
            Bitmap bitmap = dVar.sZ.getBitmap();
            if (this.ty) {
                a(canvas, bitmap);
                return;
            }
            this.tu.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.tb.a(canvas, this.tu, this.sA, this.mPaint);
        } else if (dVar.gP()) {
            if (this.ty) {
                a(canvas, dVar.tb.ja());
                return;
            }
            this.tu.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.tb.a(canvas, this.tu, this.sA, this.mPaint);
        } else {
            this.tu.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.tb.a(canvas, this.tu, this.sA, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.tu.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.tt.set(0, 0, (int) this.sA.width(), (int) this.sA.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.tv, this.tr);
        canvas.drawBitmap(bitmap, this.tu, this.sA, this.ts);
        canvas.restore();
    }
}
