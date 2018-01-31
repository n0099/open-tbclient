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
    private Path apD;
    private final Paint apE = new Paint();
    private final Paint apF = new Paint();
    private boolean apt;
    private Rect lQ;

    public g() {
        this.apE.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.apE.setStyle(Paint.Style.FILL);
        this.apE.setAntiAlias(true);
        this.apF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void g(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.apD == null || this.apt != this.mArgs.apt) {
                z = true;
            }
            if (this.lQ == null || !this.lQ.contains(rect)) {
                z = true;
            }
            this.apt = this.mArgs.apt;
            if (z) {
                this.lQ = rect;
                this.apD = new Path();
                if (this.apt) {
                    this.apD.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.apD.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.apD.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        g(drawable.getBounds());
        try {
            canvas.clipPath(this.apD);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
