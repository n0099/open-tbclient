package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private boolean DA;
    private Path DM;
    private Rect mRect;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.DM == null || this.DA != this.Df.DA) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.DA = this.Df.DA;
            if (z) {
                this.mRect = rect;
                this.DM = new Path();
                if (this.DA) {
                    this.DM.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.DM.addRoundRect(new RectF(rect), this.Df.mRadius, this.Df.mRadius, Path.Direction.CCW);
                }
                this.DM.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.DM);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
