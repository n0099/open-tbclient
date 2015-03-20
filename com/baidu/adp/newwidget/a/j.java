package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private k Cs;
    protected Path Cq = new Path();
    protected Paint Cr = null;
    protected boolean Ct = false;

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a;
        super.a(dVar, imageView, scaleType);
        if (this.Cs != null && (a = this.Cs.a(jU())) != null) {
            this.Cq.set(a);
            if (this.Cr == null) {
                this.Cr = new Paint();
                this.Cr.setStyle(Paint.Style.STROKE);
                this.Cr.setAntiAlias(true);
                this.Cr.setColor(637534208);
                this.Cr.setDither(true);
                this.Cr.setStrokeWidth(2.0f);
            }
            kc();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Ct) {
            canvas.drawPath(this.Cq, this.Cr);
            if (this.Cs != null) {
                this.Cs.b(canvas);
            }
        }
    }

    public void kc() {
    }

    public void kd() {
    }

    public void a(k kVar) {
        this.Cs = kVar;
    }

    public void E(boolean z) {
        this.Ct = z;
    }
}
