package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class g extends j {
    private final Paint Gd = new Paint();
    private final Paint Ge = new Paint();
    private final Rect Gf = new Rect(0, 0, 0, 0);
    private final Rect Gg = new Rect(0, 0, 0, 0);

    public g() {
        this.Gd.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Gd.setStyle(Paint.Style.FILL);
        this.Gd.setAntiAlias(true);
        this.Ge.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FI != null) {
            canvas.concat(this.FI);
        }
        if (cVar.kV()) {
            Bitmap bitmap = cVar.FQ.getBitmap();
            if (this.Gk) {
                a(canvas, bitmap);
                return;
            }
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FR.a(canvas, this.Gg, this.FJ, this.mPaint);
        } else if (cVar.kW()) {
            if (this.Gk) {
                a(canvas, cVar.FR.nb());
                return;
            }
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FR.a(canvas, this.Gg, this.FJ, this.mPaint);
        } else {
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FR.a(canvas, this.Gg, this.FJ, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Gg.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Gf.set(0, 0, (int) this.FJ.width(), (int) this.FJ.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Gh, this.Gd);
        canvas.drawBitmap(bitmap, this.Gg, this.FJ, this.Ge);
        canvas.restore();
    }
}
