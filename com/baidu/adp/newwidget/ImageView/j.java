package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a tZ;
    protected Path mDefaultPath = new Path();
    protected Paint mPathStrokePaint = null;
    protected boolean isPathAvailable = false;

    /* loaded from: classes.dex */
    public interface a {
        void drawWhenPathAvailable(Canvas canvas);

        Path makePath(RectF rectF);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path makePath;
        super.a(cVar, imageView, scaleType);
        if (this.tZ != null && (makePath = this.tZ.makePath(getBounds())) != null) {
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

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.isPathAvailable) {
            canvas.drawPath(this.mDefaultPath, this.mPathStrokePaint);
            if (this.tZ != null) {
                this.tZ.drawWhenPathAvailable(canvas);
            }
        }
    }

    public void onFinishComputeBounds() {
    }

    public void releaseMemory() {
    }

    public void a(a aVar) {
        this.tZ = aVar;
    }

    public void setPathAvailable(boolean z) {
        this.isPathAvailable = z;
    }
}
