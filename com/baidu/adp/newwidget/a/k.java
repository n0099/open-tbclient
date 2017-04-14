package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a Cr;
    protected Path Cp = new Path();
    protected Paint Cq = null;
    protected boolean Cs = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.Cr != null && (a2 = this.Cr.a(iA())) != null) {
            this.Cp.set(a2);
            if (this.Cq == null) {
                this.Cq = new Paint();
                this.Cq.setStyle(Paint.Style.STROKE);
                this.Cq.setAntiAlias(true);
                this.Cq.setColor(637534208);
                this.Cq.setDither(true);
                this.Cq.setStrokeWidth(2.0f);
            }
            iI();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Cs) {
            canvas.drawPath(this.Cp, this.Cq);
            if (this.Cr != null) {
                this.Cr.c(canvas);
            }
        }
    }

    public void iI() {
    }

    public void iJ() {
    }

    public void a(a aVar) {
        this.Cr = aVar;
    }

    public void K(boolean z) {
        this.Cs = z;
    }
}
