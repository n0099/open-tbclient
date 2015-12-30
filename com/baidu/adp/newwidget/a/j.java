package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a BZ;
    protected Path BX = new Path();
    protected Paint BY = null;
    protected boolean Ca = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BZ != null && (a2 = this.BZ.a(kf())) != null) {
            this.BX.set(a2);
            if (this.BY == null) {
                this.BY = new Paint();
                this.BY.setStyle(Paint.Style.STROKE);
                this.BY.setAntiAlias(true);
                this.BY.setColor(637534208);
                this.BY.setDither(true);
                this.BY.setStrokeWidth(2.0f);
            }
            kn();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Ca) {
            canvas.drawPath(this.BX, this.BY);
            if (this.BZ != null) {
                this.BZ.c(canvas);
            }
        }
    }

    public void kn() {
    }

    public void ko() {
    }

    public void a(a aVar) {
        this.BZ = aVar;
    }

    public void G(boolean z) {
        this.Ca = z;
    }
}
