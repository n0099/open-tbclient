package com.baidu.adp.newwidget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class g extends j {
    private final Paint Jf = new Paint();
    private final Paint Jg = new Paint();
    private final Rect Jh = new Rect(0, 0, 0, 0);
    private final Rect Ji = new Rect(0, 0, 0, 0);

    public g() {
        this.Jf.setColor(-16777216);
        this.Jf.setStyle(Paint.Style.FILL);
        this.Jf.setAntiAlias(true);
        this.Jg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.IK != null) {
            canvas.concat(this.IK);
        }
        if (cVar.mi()) {
            Bitmap bitmap = cVar.IS.getBitmap();
            if (this.Jm) {
                a(canvas, bitmap);
                return;
            }
            this.Ji.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IT.a(canvas, this.Ji, this.mBounds, this.mPaint);
        } else if (cVar.mj()) {
            if (this.Jm) {
                a(canvas, cVar.IT.op());
                return;
            }
            this.Ji.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IT.a(canvas, this.Ji, this.mBounds, this.mPaint);
        } else {
            this.Ji.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.IT.a(canvas, this.Ji, this.mBounds, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.Ji.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Jh.set(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.Jj, this.Jf);
        canvas.drawBitmap(bitmap, this.Ji, this.mBounds, this.Jg);
        canvas.restore();
    }
}
