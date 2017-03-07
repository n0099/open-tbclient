package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class m extends l {
    private Path CJ;
    private boolean Cx;
    private Rect sv;

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.CJ == null || this.Cx != this.Cb.Cx) {
                z = true;
            }
            if (this.sv == null || !this.sv.contains(rect)) {
                z = true;
            }
            this.Cx = this.Cb.Cx;
            if (z) {
                this.sv = rect;
                this.CJ = new Path();
                if (this.Cx) {
                    this.CJ.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.CJ.addRoundRect(new RectF(rect), this.Cb.mRadius, this.Cb.mRadius, Path.Direction.CCW);
                }
                this.CJ.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.CJ);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
