package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Gj;
    protected Path Gh = new Path();
    protected Paint Gi = null;
    protected boolean Gk = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void f(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Gj != null && (a2 = this.Gj.a(kT())) != null) {
            this.Gh.set(a2);
            if (this.Gi == null) {
                this.Gi = new Paint();
                this.Gi.setStyle(Paint.Style.STROKE);
                this.Gi.setAntiAlias(true);
                this.Gi.setColor(637534208);
                this.Gi.setDither(true);
                this.Gi.setStrokeWidth(2.0f);
            }
            kY();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Gk) {
            canvas.drawPath(this.Gh, this.Gi);
            if (this.Gj != null) {
                this.Gj.f(canvas);
            }
        }
    }

    public void kY() {
    }

    public void kZ() {
    }

    public void a(a aVar) {
        this.Gj = aVar;
    }

    public void P(boolean z) {
        this.Gk = z;
    }
}
