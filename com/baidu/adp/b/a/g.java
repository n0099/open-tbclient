package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public class g extends l {
    private boolean Cb;
    private Path Cn;
    private final Paint Co = new Paint();
    private final Paint Cp = new Paint();
    private Rect mRect;

    public g() {
        this.Co.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Co.setStyle(Paint.Style.FILL);
        this.Co.setAntiAlias(true);
        this.Cp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Cn == null || this.Cb != this.BF.Cb) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.Cb = this.BF.Cb;
            if (z) {
                this.mRect = rect;
                this.Cn = new Path();
                if (this.Cb) {
                    this.Cn.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Cn.addRoundRect(new RectF(rect), this.BF.mRadius, this.BF.mRadius, Path.Direction.CCW);
                }
                this.Cn.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Cn);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
