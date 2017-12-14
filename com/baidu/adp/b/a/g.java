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
    private boolean Bi;
    private Path Bu;
    private final Paint Bv = new Paint();
    private final Paint Bw = new Paint();
    private Rect rt;

    public g() {
        this.Bv.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Bv.setStyle(Paint.Style.FILL);
        this.Bv.setAntiAlias(true);
        this.Bw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Bu == null || this.Bi != this.mArgs.Bi) {
                z = true;
            }
            if (this.rt == null || !this.rt.contains(rect)) {
                z = true;
            }
            this.Bi = this.mArgs.Bi;
            if (z) {
                this.rt = rect;
                this.Bu = new Path();
                if (this.Bi) {
                    this.Bu.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Bu.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.Bu.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Bu);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
