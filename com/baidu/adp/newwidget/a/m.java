package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Rect hI;
    private Path sL;
    private boolean sz;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.sL == null || this.sz != this.sa.sz) {
                z = true;
            }
            if (this.hI == null || !this.hI.contains(rect)) {
                z = true;
            }
            this.sz = this.sa.sz;
            if (z) {
                this.hI = rect;
                this.sL = new Path();
                if (this.sz) {
                    this.sL.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.sL.addRoundRect(new RectF(rect), this.sa.mRadius, this.sa.mRadius, Path.Direction.CCW);
                }
                this.sL.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.sL);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
