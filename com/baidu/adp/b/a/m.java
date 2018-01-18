package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path apA;
    private boolean apq;
    private Rect lQ;

    private void g(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apA == null || this.apq != this.mArgs.apq) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apq = this.mArgs.apq;
            if (z) {
                this.lQ = rect;
                this.apA = new Path();
                if (this.apq) {
                    this.apA.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apA.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apA.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        g(drawable.getBounds());
        try {
            canvas.clipPath(this.apA);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
