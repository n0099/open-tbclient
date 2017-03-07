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
public class g extends l {
    private Path CJ;
    private final Paint CK = new Paint();
    private final Paint CL = new Paint();
    private boolean Cx;
    private Rect sv;

    public g() {
        this.CK.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.CK.setStyle(Paint.Style.FILL);
        this.CK.setAntiAlias(true);
        this.CL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.CJ == null || this.Cx != this.Cb.Cx) {
                z = true;
            }
            if (this.sv == null || !this.sv.contains(rect)) {
                z = true;
            }
            this.Cx = this.Cb.Cx;
            if (z) {
                this.sv = rect;
                this.CJ = new Path();
                if (this.Cx) {
                    this.CJ.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.CJ.addRoundRect(new RectF(rect), this.Cb.mRadius, this.Cb.mRadius, Path.Direction.CCW);
                }
                this.CJ.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.CJ);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
