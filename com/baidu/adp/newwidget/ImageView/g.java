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
    private final Paint Hg = new Paint();
    private final Paint Hh = new Paint();
    private final Rect Hi = new Rect(0, 0, 0, 0);
    private final Rect Hj = new Rect(0, 0, 0, 0);

    public g() {
        this.Hg.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Hg.setStyle(Paint.Style.FILL);
        this.Hg.setAntiAlias(true);
        this.Hh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.GH != null) {
            canvas.concat(this.GH);
        }
        if (cVar.lx()) {
            Bitmap bitmap = cVar.GQ.getBitmap();
            if (this.Hn) {
                a(canvas, bitmap);
                return;
            }
            this.Hj.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GR.a(canvas, this.Hj, this.GI, this.mPaint);
        } else if (cVar.ly()) {
            if (this.Hn) {
                a(canvas, cVar.GR.nK());
                return;
            }
            this.Hj.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GR.a(canvas, this.Hj, this.GI, this.mPaint);
        } else {
            this.Hj.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GR.a(canvas, this.Hj, this.GI, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Hj.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Hi.set(0, 0, (int) this.GI.width(), (int) this.GI.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Hk, this.Hg);
        canvas.drawBitmap(bitmap, this.Hj, this.GI, this.Hh);
        canvas.restore();
    }
}
