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
    private final Paint Jm = new Paint();
    private final Paint Jn = new Paint();
    private final Rect Jo = new Rect(0, 0, 0, 0);
    private final Rect Jp = new Rect(0, 0, 0, 0);

    public g() {
        this.Jm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Jm.setStyle(Paint.Style.FILL);
        this.Jm.setAntiAlias(true);
        this.Jn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.IR != null) {
            canvas.concat(this.IR);
        }
        if (cVar.mn()) {
            Bitmap bitmap = cVar.Ja.getBitmap();
            if (this.Jt) {
                a(canvas, bitmap);
                return;
            }
            this.Jp.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.Jb.a(canvas, this.Jp, this.IS, this.mPaint);
        } else if (cVar.mo()) {
            if (this.Jt) {
                a(canvas, cVar.Jb.oy());
                return;
            }
            this.Jp.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.Jb.a(canvas, this.Jp, this.IS, this.mPaint);
        } else {
            this.Jp.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.Jb.a(canvas, this.Jp, this.IS, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Jp.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Jo.set(0, 0, (int) this.IS.width(), (int) this.IS.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Jq, this.Jm);
        canvas.drawBitmap(bitmap, this.Jp, this.IS, this.Jn);
        canvas.restore();
    }
}
