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
    private final Paint GV = new Paint();
    private final Paint GW = new Paint();
    private final Rect GX = new Rect(0, 0, 0, 0);
    private final Rect GY = new Rect(0, 0, 0, 0);

    public g() {
        this.GV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.GV.setStyle(Paint.Style.FILL);
        this.GV.setAntiAlias(true);
        this.GW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.Gz != null) {
            canvas.concat(this.Gz);
        }
        if (cVar.lh()) {
            Bitmap bitmap = cVar.GH.getBitmap();
            if (this.Hc) {
                a(canvas, bitmap);
                return;
            }
            this.GY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GI.a(canvas, this.GY, this.GA, this.mPaint);
        } else if (cVar.li()) {
            if (this.Hc) {
                a(canvas, cVar.GI.ns());
                return;
            }
            this.GY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GI.a(canvas, this.GY, this.GA, this.mPaint);
        } else {
            this.GY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.GI.a(canvas, this.GY, this.GA, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.GY.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.GX.set(0, 0, (int) this.GA.width(), (int) this.GA.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.GZ, this.GV);
        canvas.drawBitmap(bitmap, this.GY, this.GA, this.GW);
        canvas.restore();
    }
}
