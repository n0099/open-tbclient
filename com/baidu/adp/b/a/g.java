package com.baidu.adp.b.a;

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
    private Path BL;
    private final Paint BM = new Paint();
    private final Paint BN = new Paint();
    private boolean Bz;
    private Rect rt;

    public g() {
        this.BM.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BM.setStyle(Paint.Style.FILL);
        this.BM.setAntiAlias(true);
        this.BN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BL == null || this.Bz != this.Bd.Bz) {
                z = true;
            }
            if (this.rt == null || !this.rt.contains(rect)) {
                z = true;
            }
            this.Bz = this.Bd.Bz;
            if (z) {
                this.rt = rect;
                this.BL = new Path();
                if (this.Bz) {
                    this.BL.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BL.addRoundRect(new RectF(rect), this.Bd.mRadius, this.Bd.mRadius, Path.Direction.CCW);
                }
                this.BL.close();
            }
        }
    }

    @Override // com.baidu.adp.b.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BL);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
