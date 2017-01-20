package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect ky;
    private boolean vj;
    private Path vv;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.vv == null || this.vj != this.uN.vj) {
                z = true;
            }
            if (this.ky == null || !this.ky.contains(rect)) {
                z = true;
            }
            this.vj = this.uN.vj;
            if (z) {
                this.ky = rect;
                this.vv = new Path();
                if (this.vj) {
                    this.vv.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.vv.addRoundRect(new RectF(rect), this.uN.mRadius, this.uN.mRadius, Path.Direction.CCW);
                }
                this.vv.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.vv);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
