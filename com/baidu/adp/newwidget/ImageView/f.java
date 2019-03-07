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
    private boolean Jc;
    private final Paint Jm = new Paint();
    private final Paint Jn = new Paint();
    private Rect mRect;
    private Path ot;

    public f() {
        this.Jm.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Jm.setStyle(Paint.Style.FILL);
        this.Jm.setAntiAlias(true);
        this.Jn.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.ot == null || this.Jc != this.mArgs.Jc) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.Jc = this.mArgs.Jc;
            if (z) {
                this.mRect = rect;
                this.ot = new Path();
                if (this.Jc) {
                    this.ot.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.ot.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.ot.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.ot);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
