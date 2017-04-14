package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private boolean BY;
    private Path Ck;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Ck == null || this.BY != this.BC.BY) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.BY = this.BC.BY;
            if (z) {
                this.mRect = rect;
                this.Ck = new Path();
                if (this.BY) {
                    this.Ck.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Ck.addRoundRect(new RectF(rect), this.BC.mRadius, this.BC.mRadius, Path.Direction.CCW);
                }
                this.Ck.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Ck);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
