package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path apD;
    private boolean apt;
    private Rect lQ;

    private void g(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apD == null || this.apt != this.mArgs.apt) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apt = this.mArgs.apt;
            if (z) {
                this.lQ = rect;
                this.apD = new Path();
                if (this.apt) {
                    this.apD.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apD.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apD.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        g(drawable.getBounds());
        try {
            canvas.clipPath(this.apD);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
