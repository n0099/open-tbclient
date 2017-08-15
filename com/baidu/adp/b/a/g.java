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
    private boolean DC;
    private Path DO;
    private final Paint DP = new Paint();
    private final Paint DQ = new Paint();
    private Rect mRect;

    public g() {
        this.DP.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.DP.setStyle(Paint.Style.FILL);
        this.DP.setAntiAlias(true);
        this.DQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.DO == null || this.DC != this.Dh.DC) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.DC = this.Dh.DC;
            if (z) {
                this.mRect = rect;
                this.DO = new Path();
                if (this.DC) {
                    this.DO.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.DO.addRoundRect(new RectF(rect), this.Dh.mRadius, this.Dh.mRadius, Path.Direction.CCW);
                }
                this.DO.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.DO);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
