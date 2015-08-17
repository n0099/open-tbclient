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
public class g extends k {
    private Path BK;
    private final Paint BL = new Paint();
    private final Paint BM = new Paint();
    private boolean By;
    private Rect mRect;

    public g() {
        this.BL.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.BL.setStyle(Paint.Style.FILL);
        this.BL.setAntiAlias(true);
        this.BM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void c(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.BK == null || this.By != this.Bc.By) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.By = this.Bc.By;
            if (z) {
                this.mRect = rect;
                this.BK = new Path();
                if (this.By) {
                    this.BK.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.BK.addRoundRect(new RectF(rect), this.Bc.mRadius, this.Bc.mRadius, Path.Direction.CCW);
                }
                this.BK.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    protected void a(Canvas canvas, Drawable drawable) {
        canvas.save();
        c(drawable.getBounds());
        try {
            canvas.clipPath(this.BK);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
