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
    private boolean GJ;
    private final Paint GV = new Paint();
    private final Paint GW = new Paint();
    private Path lS;
    private Rect mRect;

    public f() {
        this.GV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.GV.setStyle(Paint.Style.FILL);
        this.GV.setAntiAlias(true);
        this.GW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.lS == null || this.GJ != this.mArgs.GJ) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.GJ = this.mArgs.GJ;
            if (z) {
                this.mRect = rect;
                this.lS = new Path();
                if (this.GJ) {
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
