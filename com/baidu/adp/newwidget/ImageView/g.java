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
    private final Paint Gf = new Paint();
    private final Paint Gg = new Paint();
    private final Rect Gh = new Rect(0, 0, 0, 0);
    private final Rect Gi = new Rect(0, 0, 0, 0);

    public g() {
        this.Gf.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Gf.setStyle(Paint.Style.FILL);
        this.Gf.setAntiAlias(true);
        this.Gg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.FL != null) {
            canvas.concat(this.FL);
        }
        if (cVar.kT()) {
            Bitmap bitmap = cVar.FU.getBitmap();
            if (this.Gm) {
                a(canvas, bitmap);
                return;
            }
            this.Gi.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FV.a(canvas, this.Gi, this.FM, this.mPaint);
        } else if (cVar.kU()) {
            if (this.Gm) {
                a(canvas, cVar.FV.mZ());
                return;
            }
            this.Gi.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FV.a(canvas, this.Gi, this.FM, this.mPaint);
        } else {
            this.Gi.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.FV.a(canvas, this.Gi, this.FM, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Gi.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Gh.set(0, 0, (int) this.FM.width(), (int) this.FM.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Gj, this.Gf);
        canvas.drawBitmap(bitmap, this.Gi, this.FM, this.Gg);
        canvas.restore();
    }
}
