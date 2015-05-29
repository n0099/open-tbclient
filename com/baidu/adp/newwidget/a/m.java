package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private boolean BO;
    private Path Ca;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Ca == null || this.BO != this.Bp.BO) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.BO = this.Bp.BO;
            if (z) {
                this.mRect = rect;
                this.Ca = new Path();
                if (this.BO) {
                    this.Ca.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.Ca.addRoundRect(new RectF(rect), this.Bp.mRadius, this.Bp.mRadius, Path.Direction.CCW);
                }
                this.Ca.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Ca);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
