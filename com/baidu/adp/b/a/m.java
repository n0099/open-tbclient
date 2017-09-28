package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path BK;
    private boolean By;
    private Rect rs;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BK == null || this.By != this.Bc.By) {
                z = true;
            }
            if (this.rs == null || !this.rs.contains(rect)) {
                z = true;
            }
            this.By = this.Bc.By;
            if (z) {
                this.rs = rect;
                this.BK = new Path();
                if (this.By) {
                    this.BK.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BK.addRoundRect(new RectF(rect), this.Bc.mRadius, this.Bc.mRadius, Path.Direction.CCW);
                }
                this.BK.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BK);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
