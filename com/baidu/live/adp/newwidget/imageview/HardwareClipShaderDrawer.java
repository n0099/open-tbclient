package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
/* loaded from: classes2.dex */
public class HardwareClipShaderDrawer extends ShaderDrawer {
    private boolean mIsRound;
    private Rect mRect;
    private Path path;
    private final Paint mModeBeforePaint = new Paint();
    private final Paint mModeAfterPaint = new Paint();

    public HardwareClipShaderDrawer() {
        this.mModeBeforePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mModeBeforePaint.setStyle(Paint.Style.FILL);
        this.mModeBeforePaint.setAntiAlias(true);
        this.mModeAfterPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void makePath(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.path == null || this.mIsRound != this.mArgs.mIsRound) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.mIsRound = this.mArgs.mIsRound;
            if (z) {
                this.mRect = rect;
                this.path = new Path();
                if (this.mIsRound) {
                    this.path.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.path.addRoundRect(new RectF(rect), this.mArgs.mRadius, this.mArgs.mRadius, Path.Direction.CCW);
                }
                this.path.close();
            }
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    protected void drawBackgroundReal(Canvas canvas, Drawable drawable) {
        canvas.save();
        makePath(drawable.getBounds());
        try {
            canvas.clipPath(this.path);
        } catch (Exception e) {
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
