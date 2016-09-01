package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect kF;
    private Path vD;
    private boolean vr;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.vD == null || this.vr != this.uV.vr) {
                z = true;
            }
            if (this.kF == null || !this.kF.contains(rect)) {
                z = true;
            }
            this.vr = this.uV.vr;
            if (z) {
                this.kF = rect;
                this.vD = new Path();
                if (this.vr) {
                    this.vD.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.vD.addRoundRect(new RectF(rect), this.uV.mRadius, this.uV.mRadius, Path.Direction.CCW);
                }
                this.vD.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.vD);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
