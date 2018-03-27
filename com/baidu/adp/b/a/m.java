package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private boolean apk;
    private Path apu;
    private Rect lQ;

    private void h(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apu == null || this.apk != this.mArgs.apk) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apk = this.mArgs.apk;
            if (z) {
                this.lQ = rect;
                this.apu = new Path();
                if (this.apk) {
                    this.apu.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apu.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apu.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        h(drawable.getBounds());
        try {
            canvas.clipPath(this.apu);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
