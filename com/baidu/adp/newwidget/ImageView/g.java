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
    private final Paint Iz = new Paint();
    private final Paint IA = new Paint();
    private final Rect IB = new Rect(0, 0, 0, 0);
    private final Rect IC = new Rect(0, 0, 0, 0);

    public g() {
        this.Iz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Iz.setStyle(Paint.Style.FILL);
        this.Iz.setAntiAlias(true);
        this.IA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.adp.newwidget.ImageView.b, com.baidu.adp.newwidget.ImageView.a
    public void b(Canvas canvas, c cVar, ImageView imageView) {
        if (this.Ie != null) {
            canvas.concat(this.Ie);
        }
        if (cVar.mb()) {
            Bitmap bitmap = cVar.Im.getBitmap();
            if (this.IH) {
                a(canvas, bitmap);
                return;
            }
            this.IC.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.In.a(canvas, this.IC, this.If, this.mPaint);
        } else if (cVar.mc()) {
            if (this.IH) {
                a(canvas, cVar.In.oh());
                return;
            }
            this.IC.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.In.a(canvas, this.IC, this.If, this.mPaint);
        } else {
            this.IC.set(0, 0, cVar.getWidth(), cVar.getHeight());
            cVar.In.a(canvas, this.IC, this.If, this.mPaint);
        }
    }

    protected void a(Canvas canvas, Bitmap bitmap) {
        this.IC.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.IB.set(0, 0, (int) this.If.width(), (int) this.If.height());
        canvas.save();
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawPath(this.IE, this.Iz);
        canvas.drawBitmap(bitmap, this.IC, this.If, this.IA);
        canvas.restore();
    }
}
