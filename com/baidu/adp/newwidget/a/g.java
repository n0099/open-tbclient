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
    private Path BI;
    private final Paint BJ = new Paint();
    private final Paint BK = new Paint();
    private boolean Bw;
    private Rect mRect;

    public g() {
        this.BJ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BJ.setStyle(Paint.Style.FILL);
        this.BJ.setAntiAlias(true);
        this.BK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BI == null || this.Bw != this.Ba.Bw) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.Bw = this.Ba.Bw;
            if (z) {
                this.mRect = rect;
                this.BI = new Path();
                if (this.Bw) {
                    this.BI.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BI.addRoundRect(new RectF(rect), this.Ba.mRadius, this.Ba.mRadius, Path.Direction.CCW);
                }
                this.BI.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BI);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
