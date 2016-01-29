package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean BO;
    private Path Ca;
    private Rect rM;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Ca == null || this.BO != this.Bs.BO) {
                z = true;
            }
            if (this.rM == null || !this.rM.contains(rect)) {
                z = true;
            }
            this.BO = this.Bs.BO;
            if (z) {
                this.rM = rect;
                this.Ca = new Path();
                if (this.BO) {
                    this.Ca.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Ca.addRoundRect(new RectF(rect), this.Bs.mRadius, this.Bs.mRadius, Path.Direction.CCW);
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
