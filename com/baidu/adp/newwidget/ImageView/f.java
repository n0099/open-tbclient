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
    private boolean Ip;
    private Rect mRect;
    private Path nJ;
    private final Paint Iz = new Paint();
    private final Paint IA = new Paint();

    public f() {
        this.Iz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.Iz.setStyle(Paint.Style.FILL);
        this.Iz.setAntiAlias(true);
        this.IA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void d(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.nJ == null || this.Ip != this.mArgs.Ip) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.Ip = this.mArgs.Ip;
            if (z) {
                this.mRect = rect;
                this.nJ = new Path();
                if (this.Ip) {
                    this.nJ.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.nJ.addRoundRect(new RectF(rect), this.mArgs.Io, this.mArgs.Io, Path.Direction.CCW);
                }
                this.nJ.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        d(drawable.getBounds());
        try {
            canvas.clipPath(this.nJ);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
