package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a Cu;
    protected Path Cs = new Path();
    protected Paint Ct = null;
    protected boolean Cv = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.Cu != null && (a2 = this.Cu.a(iB())) != null) {
            this.Cs.set(a2);
            if (this.Ct == null) {
                this.Ct = new Paint();
                this.Ct.setStyle(Paint.Style.STROKE);
                this.Ct.setAntiAlias(true);
                this.Ct.setColor(637534208);
                this.Ct.setDither(true);
                this.Ct.setStrokeWidth(2.0f);
            }
            iJ();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.Cv) {
            canvas.drawPath(this.Cs, this.Ct);
            if (this.Cu != null) {
                this.Cu.c(canvas);
            }
        }
    }

    public void iJ() {
    }

    public void iK() {
    }

    public void a(a aVar) {
        this.Cu = aVar;
    }

    public void K(boolean z) {
        this.Cv = z;
    }
}
