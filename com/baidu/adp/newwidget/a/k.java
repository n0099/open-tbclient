package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a vL;
    protected Path vJ = new Path();
    protected Paint vK = null;
    protected boolean vM = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.vL != null && (a2 = this.vL.a(hE())) != null) {
            this.vJ.set(a2);
            if (this.vK == null) {
                this.vK = new Paint();
                this.vK.setStyle(Paint.Style.STROKE);
                this.vK.setAntiAlias(true);
                this.vK.setColor(637534208);
                this.vK.setDither(true);
                this.vK.setStrokeWidth(2.0f);
            }
            hM();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.vM) {
            canvas.drawPath(this.vJ, this.vK);
            if (this.vL != null) {
                this.vL.c(canvas);
            }
        }
    }

    public void hM() {
    }

    public void hN() {
    }

    public void a(a aVar) {
        this.vL = aVar;
    }

    public void J(boolean z) {
        this.vM = z;
    }
}
