package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect mRect;
    private boolean rg;
    private Path rt;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.rt == null || this.rg != this.qH.rg) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.rg = this.qH.rg;
            if (z) {
                this.mRect = rect;
                this.rt = new Path();
                if (this.rg) {
                    this.rt.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.rt.addRoundRect(new RectF(rect), this.qH.mRadius, this.qH.mRadius, Path.Direction.CCW);
                }
                this.rt.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.rt);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
