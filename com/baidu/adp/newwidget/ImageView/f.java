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
    private boolean zM;
    private Path zV;
    private final Paint zW = new Paint();
    private final Paint zX = new Paint();

    public f() {
        this.zW.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.zW.setStyle(Paint.Style.FILL);
        this.zW.setAntiAlias(true);
        this.zX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.zV == null || this.zM != this.mArgs.zM) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.zM = this.mArgs.zM;
            if (z) {
                this.mRect = rect;
                this.zV = new Path();
                if (this.zM) {
                    this.zV.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.zV.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.zV.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.zV);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
