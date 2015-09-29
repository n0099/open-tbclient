package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private Path BJ;
    private boolean Bx;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BJ == null || this.Bx != this.Bb.Bx) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.Bx = this.Bb.Bx;
            if (z) {
                this.mRect = rect;
                this.BJ = new Path();
                if (this.Bx) {
                    this.BJ.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BJ.addRoundRect(new RectF(rect), this.Bb.mRadius, this.Bb.mRadius, Path.Direction.CCW);
                }
                this.BJ.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BJ);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
