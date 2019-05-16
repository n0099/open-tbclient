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
    private final Paint GW = new Paint();
    private final Paint GX = new Paint();
    private final Rect GY = new Rect(0, 0, 0, 0);
    private final Rect GZ = new Rect(0, 0, 0, 0);

    public g() {
        this.GW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.GW.setStyle(Paint.Style.FILL);
        this.GW.setAntiAlias(true);
        this.GX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.GA != null) {
            canvas.concat(this.GA);
        }
        if (cVar.lh()) {
            Bitmap bitmap = cVar.GI.getBitmap();
            if (this.Hd) {
                a(canvas, bitmap);
                return;
            }
            this.GZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GJ.a(canvas, this.GZ, this.GB, this.mPaint);
        } else if (cVar.li()) {
            if (this.Hd) {
                a(canvas, cVar.GJ.ns());
                return;
            }
            this.GZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GJ.a(canvas, this.GZ, this.GB, this.mPaint);
        } else {
            this.GZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GJ.a(canvas, this.GZ, this.GB, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.GZ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.GY.set(0, 0, (int) this.GB.width(), (int) this.GB.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Ha, this.GW);
        canvas.drawBitmap(bitmap, this.GZ, this.GB, this.GX);
        canvas.restore();
    }
}
