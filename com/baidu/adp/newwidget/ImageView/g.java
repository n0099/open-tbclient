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
    private final Paint zV = new Paint();
    private final Paint zW = new Paint();
    private final Rect zX = new Rect(0, 0, 0, 0);
    private final Rect zY = new Rect(0, 0, 0, 0);

    public g() {
        this.zV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.zV.setStyle(Paint.Style.FILL);
        this.zV.setAntiAlias(true);
        this.zW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.zB != null) {
            canvas.concat(this.zB);
        }
        if (cVar.m10if()) {
            Bitmap bitmap = cVar.zJ.getBitmap();
            if (this.Ac) {
                a(canvas, bitmap);
                return;
            }
            this.zY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zK.a(canvas, this.zY, this.zC, this.mPaint);
        } else if (cVar.ig()) {
            if (this.Ac) {
                a(canvas, cVar.zK.kl());
                return;
            }
            this.zY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zK.a(canvas, this.zY, this.zC, this.mPaint);
        } else {
            this.zY.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.zK.a(canvas, this.zY, this.zC, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.zY.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.zX.set(0, 0, (int) this.zC.width(), (int) this.zC.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.zZ, this.zV);
        canvas.drawBitmap(bitmap, this.zY, this.zC, this.zW);
        canvas.restore();
    }
}
