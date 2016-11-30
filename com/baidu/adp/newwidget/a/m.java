package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect kG;
    private Path vE;
    private boolean vs;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.vE == null || this.vs != this.uW.vs) {
                z = true;
            }
            if (this.kG == null || !this.kG.contains(rect)) {
                z = true;
            }
            this.vs = this.uW.vs;
            if (z) {
                this.kG = rect;
                this.vE = new Path();
                if (this.vs) {
                    this.vE.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.vE.addRoundRect(new RectF(rect), this.uW.mRadius, this.uW.mRadius, Path.Direction.CCW);
                }
                this.vE.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.vE);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
