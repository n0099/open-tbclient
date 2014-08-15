package com.baidu.adp.newwidget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class h extends j {
    private final Paint l = new Paint();
    private final Paint m = new Paint();
    private final Rect n = new Rect(0, 0, 0, 0);
    private final Rect o = new Rect(0, 0, 0, 0);

    public h() {
        this.l.setColor(-16777216);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setAntiAlias(true);
        this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.a.c, com.baidu.adp.newwidget.a.a
    public void b(Canvas canvas, d dVar, ImageView imageView) {
        if (this.d != null) {
            canvas.concat(this.d);
        }
        if (dVar.a()) {
            Bitmap bitmap = dVar.a.getBitmap();
            if (this.k) {
                a(canvas, bitmap);
                return;
            }
            this.o.set(0, 0, dVar.d(), dVar.e());
            dVar.b.a(canvas, this.o, this.e, this.a);
        } else if (dVar.b()) {
            if (this.k) {
                a(canvas, dVar.b.h());
                return;
            }
            this.o.set(0, 0, dVar.d(), dVar.e());
            dVar.b.a(canvas, this.o, this.e, this.a);
        } else {
            this.o.set(0, 0, dVar.d(), dVar.e());
            dVar.b.a(canvas, this.o, this.e, this.a);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.o.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.n.set(0, 0, (int) this.e.width(), (int) this.e.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.i, this.l);
        canvas.drawBitmap(bitmap, this.o, this.e, this.m);
        canvas.restore();
    }
}
