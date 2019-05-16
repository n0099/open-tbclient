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
    private boolean GK;
    private final Paint GW = new Paint();
    private final Paint GX = new Paint();
    private Path lS;
    private Rect mRect;

    public f() {
        this.GW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.GW.setStyle(Paint.Style.FILL);
        this.GW.setAntiAlias(true);
        this.GX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.lS == null || this.GK != this.mArgs.GK) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.GK = this.mArgs.GK;
            if (z) {
                this.mRect = rect;
                this.lS = new Path();
                if (this.GK) {
                    this.lS.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.lS.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.lS.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.lS);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
