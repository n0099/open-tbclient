package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public class g extends l {
    private boolean apj;
    private Path apt;
    private final Paint apu = new Paint();
    private final Paint apv = new Paint();
    private Rect lQ;

    public g() {
        this.apu.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apu.setStyle(Paint.Style.FILL);
        this.apu.setAntiAlias(true);
        this.apv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void h(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apt == null || this.apj != this.mArgs.apj) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apj = this.mArgs.apj;
            if (z) {
                this.lQ = rect;
                this.apt = new Path();
                if (this.apj) {
                    this.apt.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apt.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apt.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        h(drawable.getBounds());
        try {
            canvas.clipPath(this.apt);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
