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
    private boolean GU;
    private final Paint Hg = new Paint();
    private final Paint Hh = new Paint();
    private Path lR;
    private Rect mRect;

    public f() {
        this.Hg.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Hg.setStyle(Paint.Style.FILL);
        this.Hg.setAntiAlias(true);
        this.Hh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.lR == null || this.GU != this.mArgs.GU) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.GU = this.mArgs.GU;
            if (z) {
                this.mRect = rect;
                this.lR = new Path();
                if (this.GU) {
                    this.lR.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.lR.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.lR.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.lR);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
