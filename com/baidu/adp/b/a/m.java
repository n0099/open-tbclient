package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private boolean Bj;
    private Path Bv;
    private Rect ru;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Bv == null || this.Bj != this.mArgs.Bj) {
                z = true;
            }
            if (this.ru == null || !this.ru.contains(rect)) {
                z = true;
            }
            this.Bj = this.mArgs.Bj;
            if (z) {
                this.ru = rect;
                this.Bv = new Path();
                if (this.Bj) {
                    this.Bv.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Bv.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.Bv.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Bv);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
