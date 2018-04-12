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
    private final Paint zW = new Paint();
    private final Paint zX = new Paint();
    private final Rect zY = new Rect(0, 0, 0, 0);
    private final Rect zZ = new Rect(0, 0, 0, 0);

    public g() {
        this.zW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.zW.setStyle(Paint.Style.FILL);
        this.zW.setAntiAlias(true);
        this.zX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.zC != null) {
            canvas.concat(this.zC);
        }
        if (cVar.m10if()) {
            Bitmap bitmap = cVar.zK.getBitmap();
            if (this.Ae) {
                a(canvas, bitmap);
                return;
            }
            this.zZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zL.a(canvas, this.zZ, this.zD, this.mPaint);
        } else if (cVar.ig()) {
            if (this.Ae) {
                a(canvas, cVar.zL.km());
                return;
            }
            this.zZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zL.a(canvas, this.zZ, this.zD, this.mPaint);
        } else {
            this.zZ.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zL.a(canvas, this.zZ, this.zD, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.zZ.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.zY.set(0, 0, (int) this.zD.width(), (int) this.zD.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Aa, this.zW);
        canvas.drawBitmap(bitmap, this.zZ, this.zD, this.zX);
        canvas.restore();
    }
}
