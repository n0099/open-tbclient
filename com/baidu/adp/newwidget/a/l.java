package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean BG;
    private Path BS;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BS == null || this.BG != this.Bk.BG) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.BG = this.Bk.BG;
            if (z) {
                this.mRect = rect;
                this.BS = new Path();
                if (this.BG) {
                    this.BS.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BS.addRoundRect(new RectF(rect), this.Bk.mRadius, this.Bk.mRadius, Path.Direction.CCW);
                }
                this.BS.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BS);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
