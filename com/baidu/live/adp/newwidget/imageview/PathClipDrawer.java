package com.baidu.live.adp.newwidget.imageview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public abstract class PathClipDrawer extends CommonDrawer {
    private PathClipDrawerPathCreateDelegate delegate;
    protected Path mDefaultPath = new Path();
    protected Paint mPathStrokePaint = null;
    protected boolean isPathAvailable = false;

    /* loaded from: classes7.dex */
    public interface PathClipDrawerPathCreateDelegate {
        void drawWhenPathAvailable(Canvas canvas);

        Path makePath(RectF rectF);
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void computeBounds(DisplayImage displayImage, ImageView imageView, ImageView.ScaleType scaleType) {
        Path makePath;
        super.computeBounds(displayImage, imageView, scaleType);
        if (this.delegate != null && (makePath = this.delegate.makePath(getBounds())) != null) {
            this.mDefaultPath.set(makePath);
            if (this.mPathStrokePaint == null) {
                this.mPathStrokePaint = new Paint();
                this.mPathStrokePaint.setStyle(Paint.Style.STROKE);
                this.mPathStrokePaint.setAntiAlias(true);
                this.mPathStrokePaint.setColor(637534208);
                this.mPathStrokePaint.setDither(true);
                this.mPathStrokePaint.setStrokeWidth(2.0f);
            }
            onFinishComputeBounds();
        }
    }

    @Override // com.baidu.live.adp.newwidget.imageview.AbsDrawer
    public void drawContent(Canvas canvas, DisplayImage displayImage, ImageView imageView) {
        super.drawContent(canvas, displayImage, imageView);
        if (this.isPathAvailable) {
            canvas.drawPath(this.mDefaultPath, this.mPathStrokePaint);
            if (this.delegate != null) {
                this.delegate.drawWhenPathAvailable(canvas);
            }
        }
    }

    public void onFinishComputeBounds() {
    }

    public void releaseMemory() {
    }

    public void setDelegate(PathClipDrawerPathCreateDelegate pathClipDrawerPathCreateDelegate) {
        this.delegate = pathClipDrawerPathCreateDelegate;
    }

    public void setPathStrokePaint(Paint paint) {
        this.mPathStrokePaint = paint;
    }

    public void setPathAvailable(boolean z) {
        this.isPathAvailable = z;
    }
}
