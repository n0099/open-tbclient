package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path BI;
    private boolean Bw;
    private Rect rr;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BI == null || this.Bw != this.Ba.Bw) {
                z = true;
            }
            if (this.rr == null || !this.rr.contains(rect)) {
                z = true;
            }
            this.Bw = this.Ba.Bw;
            if (z) {
                this.rr = rect;
                this.BI = new Path();
                if (this.Bw) {
                    this.BI.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BI.addRoundRect(new RectF(rect), this.Ba.mRadius, this.Ba.mRadius, Path.Direction.CCW);
                }
                this.BI.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BI);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
