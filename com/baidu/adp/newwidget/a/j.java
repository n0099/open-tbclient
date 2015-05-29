package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private k Ch;
    protected Path Cf = new Path();
    protected Paint Cg = null;
    protected boolean Ci = false;

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a;
        super.a(dVar, imageView, scaleType);
        if (this.Ch != null && (a = this.Ch.a(kl())) != null) {
            this.Cf.set(a);
            if (this.Cg == null) {
                this.Cg = new Paint();
                this.Cg.setStyle(Paint.Style.STROKE);
                this.Cg.setAntiAlias(true);
                this.Cg.setColor(637534208);
                this.Cg.setDither(true);
                this.Cg.setStrokeWidth(2.0f);
            }
            kt();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Ci) {
            canvas.drawPath(this.Cf, this.Cg);
            if (this.Ch != null) {
                this.Ch.b(canvas);
            }
        }
    }

    public void kt() {
    }

    public void ku() {
    }

    public void a(k kVar) {
        this.Ch = kVar;
    }

    public void G(boolean z) {
        this.Ci = z;
    }
}
