package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a SD;
    protected Path mDefaultPath = new Path();
    protected Paint mPathStrokePaint = null;
    protected boolean isPathAvailable = false;

    /* loaded from: classes.dex */
    public interface a {
        void drawWhenPathAvailable(Canvas canvas);

        Path makePath(RectF rectF);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path makePath;
        super.a(dVar, imageView, scaleType);
        if (this.SD != null && (makePath = this.SD.makePath(getBounds())) != null) {
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
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.isPathAvailable) {
            canvas.drawPath(this.mDefaultPath, this.mPathStrokePaint);
            if (this.SD != null) {
                this.SD.drawWhenPathAvailable(canvas);
            }
        }
    }

    public void onFinishComputeBounds() {
    }

    public void releaseMemory() {
    }

    public void a(a aVar) {
        this.SD = aVar;
    }

    public void setPathAvailable(boolean z) {
        this.isPathAvailable = z;
    }
}
