package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path apB;
    private boolean apr;
    private Rect lQ;

    private void g(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apB == null || this.apr != this.mArgs.apr) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apr = this.mArgs.apr;
            if (z) {
                this.lQ = rect;
                this.apB = new Path();
                if (this.apr) {
                    this.apB.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apB.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apB.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        g(drawable.getBounds());
        try {
            canvas.clipPath(this.apB);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
