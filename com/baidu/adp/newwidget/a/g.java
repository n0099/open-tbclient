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
    private boolean BZ;
    private Path Cl;
    private final Paint Cm = new Paint();
    private final Paint Cn = new Paint();
    private Rect mRect;

    public g() {
        this.Cm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cm.setStyle(Paint.Style.FILL);
        this.Cm.setAntiAlias(true);
        this.Cn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Cl == null || this.BZ != this.BA.BZ) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.BZ = this.BA.BZ;
            if (z) {
                this.mRect = rect;
                this.Cl = new Path();
                if (this.BZ) {
                    this.Cl.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.Cl.addRoundRect(new RectF(rect), this.BA.mRadius, this.BA.mRadius, Path.Direction.CCW);
                }
                this.Cl.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Cl);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
