package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a Ch;
    protected Path Cf = new Path();
    protected Paint Cg = null;
    protected boolean Ci = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.Ch != null && (a2 = this.Ch.a(kp())) != null) {
            this.Cf.set(a2);
            if (this.Cg == null) {
                this.Cg = new Paint();
                this.Cg.setStyle(Paint.Style.STROKE);
                this.Cg.setAntiAlias(true);
                this.Cg.setColor(637534208);
                this.Cg.setDither(true);
                this.Cg.setStrokeWidth(2.0f);
            }
            kx();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Ci) {
            canvas.drawPath(this.Cf, this.Cg);
            if (this.Ch != null) {
                this.Ch.c(canvas);
            }
        }
    }

    public void kx() {
    }

    public void ky() {
    }

    public void a(a aVar) {
        this.Ch = aVar;
    }

    public void G(boolean z) {
        this.Ci = z;
    }
}
