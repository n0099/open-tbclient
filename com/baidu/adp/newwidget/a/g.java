package com.baidu.adp.newwidget.a;

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
public class g extends k {
    private boolean BO;
    private Path Ca;
    private final Paint Cb = new Paint();
    private final Paint Cc = new Paint();
    private Rect rM;

    public g() {
        this.Cb.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Cb.setStyle(Paint.Style.FILL);
        this.Cb.setAntiAlias(true);
        this.Cc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.Ca == null || this.BO != this.Bs.BO) {
                z = true;
            }
            if (this.rM == null || !this.rM.contains(rect)) {
                z = true;
            }
            this.BO = this.Bs.BO;
            if (z) {
                this.rM = rect;
                this.Ca = new Path();
                if (this.BO) {
                    this.Ca.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.Ca.addRoundRect(new RectF(rect), this.Bs.mRadius, this.Bs.mRadius, Path.Direction.CCW);
                }
                this.Ca.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.Ca);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
