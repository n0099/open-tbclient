package com.baidu.adp.newwidget.ImageView;

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
public class f extends k {
    private boolean FU;
    private final Paint Gd = new Paint();
    private final Paint Ge = new Paint();
    private Path lg;
    private Rect mRect;

    public f() {
        this.Gd.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Gd.setStyle(Paint.Style.FILL);
        this.Gd.setAntiAlias(true);
        this.Ge.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.lg == null || this.FU != this.mArgs.FU) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.FU = this.mArgs.FU;
            if (z) {
                this.mRect = rect;
                this.lg = new Path();
                if (this.FU) {
                    this.lg.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.lg.addRoundRect(new RectF(rect), this.mArgs.FT, this.mArgs.FT, Path.Direction.CCW);
                }
                this.lg.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.lg);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
