package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean BE;
    private Path BQ;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BQ == null || this.BE != this.Bi.BE) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.BE = this.Bi.BE;
            if (z) {
                this.mRect = rect;
                this.BQ = new Path();
                if (this.BE) {
                    this.BQ.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BQ.addRoundRect(new RectF(rect), this.Bi.mRadius, this.Bi.mRadius, Path.Direction.CCW);
                }
                this.BQ.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BQ);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
