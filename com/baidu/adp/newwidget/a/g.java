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
public class g extends l {
    private Rect kF;
    private Path vE;
    private final Paint vF = new Paint();
    private final Paint vG = new Paint();
    private boolean vs;

    public g() {
        this.vF.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.vF.setStyle(Paint.Style.FILL);
        this.vF.setAntiAlias(true);
        this.vG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.vE == null || this.vs != this.uW.vs) {
                z = true;
            }
            if (this.kF == null || !this.kF.contains(rect)) {
                z = true;
            }
            this.vs = this.uW.vs;
            if (z) {
                this.kF = rect;
                this.vE = new Path();
                if (this.vs) {
                    this.vE.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.vE.addRoundRect(new RectF(rect), this.uW.mRadius, this.uW.mRadius, Path.Direction.CCW);
                }
                this.vE.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.vE);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
