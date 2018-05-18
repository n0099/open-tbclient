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
    private Rect mRect;
    private boolean zL;
    private Path zU;
    private final Paint zV = new Paint();
    private final Paint zW = new Paint();

    public f() {
        this.zV.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.zV.setStyle(Paint.Style.FILL);
        this.zV.setAntiAlias(true);
        this.zW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.zU == null || this.zL != this.mArgs.zL) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.zL = this.mArgs.zL;
            if (z) {
                this.mRect = rect;
                this.zU = new Path();
                if (this.zL) {
                    this.zU.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.zU.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.zU.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.zU);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
