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
    private Rect hJ;
    private Path sK;
    private final Paint sL = new Paint();
    private final Paint sM = new Paint();
    private boolean sy;

    public g() {
        this.sL.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.sL.setStyle(Paint.Style.FILL);
        this.sL.setAntiAlias(true);
        this.sM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.sK == null || this.sy != this.sa.sy) {
                z = true;
            }
            if (this.hJ == null || !this.hJ.contains(rect)) {
                z = true;
            }
            this.sy = this.sa.sy;
            if (z) {
                this.hJ = rect;
                this.sK = new Path();
                if (this.sy) {
                    this.sK.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.sK.addRoundRect(new RectF(rect), this.sa.mRadius, this.sa.mRadius, Path.Direction.CCW);
                }
                this.sK.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.sK);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
