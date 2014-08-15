package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path l;
    private boolean m;
    private Rect n;

    private void a(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.l == null || this.m != this.g.b) {
                z = true;
            }
            if (this.n == null || !this.n.contains(rect)) {
                z = true;
            }
            this.m = this.g.b;
            if (z) {
                this.n = rect;
                this.l = new Path();
                if (this.m) {
                    this.l.addCircle((rect.right + rect.left) / 2, (rect.top + rect.bottom) / 2, Math.min(rect.width(), rect.height()) / 2, Path.Direction.CCW);
                } else {
                    this.l.addRoundRect(new RectF(rect), this.g.a, this.g.a, Path.Direction.CCW);
                }
                this.l.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        a(drawable.getBounds());
        canvas.clipPath(this.l);
        drawable.draw(canvas);
        canvas.restore();
    }
}
