package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends k {
    private boolean mIsRound;
    private Rect mRect;
    private Path path;

    private void makePath(Rect rect) {
        boolean z = false;
        if (rect != null) {
            if (this.path == null || this.mIsRound != this.we.mIsRound) {
                z = true;
            }
            if (this.mRect == null || !this.mRect.contains(rect)) {
                z = true;
            }
            this.mIsRound = this.we.mIsRound;
            if (z) {
                this.mRect = rect;
                this.path = new Path();
                if (this.mIsRound) {
                    this.path.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
                } else {
                    this.path.addRoundRect(new RectF(rect), this.we.mRadius, this.we.mRadius, Path.Direction.CCW);
                }
                this.path.close();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
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
