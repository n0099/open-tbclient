package com.baidu.adp.newwidget.a;

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
    private Rect il;
    private boolean tc;
    private Path tq;
    private final Paint tr = new Paint();
    private final Paint ts = new Paint();

    public g() {
        this.tr.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.tr.setStyle(Paint.Style.FILL);
        this.tr.setAntiAlias(true);
        this.ts.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.tq == null || this.tc != this.sF.tc) {
                z = true;
            }
            if (this.il == null || !this.il.contains(rect)) {
                z = true;
            }
            this.tc = this.sF.tc;
            if (z) {
                this.il = rect;
                this.tq = new Path();
                if (this.tc) {
                    this.tq.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.tq.addRoundRect(new RectF(rect), this.sF.mRadius, this.sF.mRadius, Path.Direction.CCW);
                }
                this.tq.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.tq);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
