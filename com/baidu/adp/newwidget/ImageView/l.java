package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean FW;
    private Path lo;
    private Rect mRect;

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.lo == null || this.FW != this.mArgs.FW) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.FW = this.mArgs.FW;
            if (z) {
                this.mRect = rect;
                this.lo = new Path();
                if (this.FW) {
                    this.lo.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.lo.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.lo.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.lo);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
