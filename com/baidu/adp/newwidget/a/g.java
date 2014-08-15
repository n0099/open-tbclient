package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class g extends l {
    private Path l;
    private boolean m;
    private Rect n;
    private final Paint o = new Paint();
    private final Paint p = new Paint();

    public g() {
        this.o.setColor(-16777216);
        this.o.setStyle(Paint.Style.FILL);
        this.o.setAntiAlias(true);
        this.p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

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
        canvas.restore();
    }
}
