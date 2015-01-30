package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect mRect;
    private boolean rl;
    private Path ry;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.ry == null || this.rl != this.qM.rl) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.rl = this.qM.rl;
            if (z) {
                this.mRect = rect;
                this.ry = new Path();
                if (this.rl) {
                    this.ry.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.ry.addRoundRect(new RectF(rect), this.qM.mRadius, this.qM.mRadius, Path.Direction.CCW);
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
