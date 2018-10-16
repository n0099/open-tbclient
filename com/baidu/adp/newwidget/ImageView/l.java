package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean IR;
    private Rect mRect;
    private Path oy;

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.oy == null || this.IR != this.mArgs.IR) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.IR = this.mArgs.IR;
            if (z) {
                this.mRect = rect;
                this.oy = new Path();
                if (this.IR) {
                    this.oy.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.oy.addRoundRect(new RectF(rect), this.mArgs.IQ, this.mArgs.IQ, Path.Direction.CCW);
                }
                this.oy.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.oy);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
