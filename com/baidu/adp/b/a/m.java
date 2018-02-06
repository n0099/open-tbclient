package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path apC;
    private boolean aps;
    private Rect lQ;

    private void h(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apC == null || this.aps != this.mArgs.aps) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.aps = this.mArgs.aps;
            if (z) {
                this.lQ = rect;
                this.apC = new Path();
                if (this.aps) {
                    this.apC.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apC.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apC.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        h(drawable.getBounds());
        try {
            canvas.clipPath(this.apC);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
