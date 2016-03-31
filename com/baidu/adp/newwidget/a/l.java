package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean Cj;
    private Path Cv;
    private Rect rW;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Cv == null || this.Cj != this.BN.Cj) {
                z = true;
            }
            if (this.rW == null || !this.rW.contains(rect)) {
                z = true;
            }
            this.Cj = this.BN.Cj;
            if (z) {
                this.rW = rect;
                this.Cv = new Path();
                if (this.Cj) {
                    this.Cv.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Cv.addRoundRect(new RectF(rect), this.BN.mRadius, this.BN.mRadius, Path.Direction.CCW);
                }
                this.Cv.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Cv);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
