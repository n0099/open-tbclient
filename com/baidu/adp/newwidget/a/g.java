package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class g extends l {
    private Rect dZ;
    private boolean rm;
    private Path ry;
    private final Paint rz = new Paint();
    private final Paint rA = new Paint();

    public g() {
        this.rz.setColor(-16777216);
        this.rz.setStyle(Paint.Style.FILL);
        this.rz.setAntiAlias(true);
        this.rA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.ry == null || this.rm != this.qN.rm) {
                z = true;
            }
            if (this.dZ == null || !this.dZ.contains(rect)) {
                z = true;
            }
            this.rm = this.qN.rm;
            if (z) {
                this.dZ = rect;
                this.ry = new Path();
                if (this.rm) {
                    this.ry.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.ry.addRoundRect(new RectF(rect), this.qN.mRadius, this.qN.mRadius, Path.Direction.CCW);
                }
                this.ry.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.ry);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
