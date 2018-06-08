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
        if (this.FJ != null) {
            canvas.concat(this.FJ);
        }
        if (cVar.kT()) {
            Bitmap bitmap = cVar.FR.getBitmap();
            if (this.Gk) {
                a(canvas, bitmap);
                return;
            }
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FT.a(canvas, this.Gg, this.FK, this.mPaint);
        } else if (cVar.kU()) {
            if (this.Gk) {
                a(canvas, cVar.FT.mZ());
                return;
            }
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FT.a(canvas, this.Gg, this.FK, this.mPaint);
        } else {
            this.Gg.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FT.a(canvas, this.Gg, this.FK, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Gg.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Gf.set(0, 0, (int) this.FK.width(), (int) this.FK.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Gh, this.Gd);
        canvas.drawBitmap(bitmap, this.Gg, this.FK, this.Ge);
        canvas.restore();
    }
}
