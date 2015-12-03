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
    private final Paint BR = new Paint();
    private final Paint BS = new Paint();
    private final Rect BT = new Rect(0, 0, 0, 0);
    private final Rect BU = new Rect(0, 0, 0, 0);

    public h() {
        this.BR.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BR.setStyle(Paint.Style.FILL);
        this.BR.setAntiAlias(true);
        this.BS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.Bc != null) {
            canvas.concat(this.Bc);
        }
        if (dVar.kj()) {
            Bitmap bitmap = dVar.BC.getBitmap();
            if (this.BY) {
                a(canvas, bitmap);
                return;
            }
            this.BU.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BD.a(canvas, this.BU, this.Bd, this.mPaint);
        } else if (dVar.kk()) {
            if (this.BY) {
                a(canvas, dVar.BD.ng());
                return;
            }
            this.BU.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BD.a(canvas, this.BU, this.Bd, this.mPaint);
        } else {
            this.BU.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.BD.a(canvas, this.BU, this.Bd, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.BU.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.BT.set(0, 0, (int) this.Bd.width(), (int) this.Bd.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.BV, this.BR);
        canvas.drawBitmap(bitmap, this.BU, this.Bd, this.BS);
        canvas.restore();
    }
}
