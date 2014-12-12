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
    private final Paint ru = new Paint();
    private final Paint rv = new Paint();
    private final Rect rw = new Rect(0, 0, 0, 0);
    private final Rect rx = new Rect(0, 0, 0, 0);

    public h() {
        this.ru.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.ru.setStyle(Paint.Style.FILL);
        this.ru.setAntiAlias(true);
        this.rv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.qC != null) {
            canvas.concat(this.qC);
        }
        if (dVar.gE()) {
            Bitmap bitmap = dVar.re.getBitmap();
            if (this.rB) {
                a(canvas, bitmap);
                return;
            }
            this.rx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rf.a(canvas, this.rx, this.qD, this.mPaint);
        } else if (dVar.gF()) {
            if (this.rB) {
                a(canvas, dVar.rf.ji());
                return;
            }
            this.rx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rf.a(canvas, this.rx, this.qD, this.mPaint);
        } else {
            this.rx.set(0, 0, dVar.getWidth(), dVar.getHeight());
            dVar.rf.a(canvas, this.rx, this.qD, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.rx.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.rw.set(0, 0, (int) this.qD.width(), (int) this.qD.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.ry, this.ru);
        canvas.drawBitmap(bitmap, this.rx, this.qD, this.rv);
        canvas.restore();
    }
}
