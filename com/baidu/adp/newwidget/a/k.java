package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a vK;
    protected Path vI = new Path();
    protected Paint vJ = null;
    protected boolean vL = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.vK != null && (a2 = this.vK.a(hE())) != null) {
            this.vI.set(a2);
            if (this.vJ == null) {
                this.vJ = new Paint();
                this.vJ.setStyle(Paint.Style.STROKE);
                this.vJ.setAntiAlias(true);
                this.vJ.setColor(637534208);
                this.vJ.setDither(true);
                this.vJ.setStrokeWidth(2.0f);
            }
            hM();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.vL) {
            canvas.drawPath(this.vI, this.vJ);
            if (this.vK != null) {
                this.vK.c(canvas);
            }
        }
    }

    public void hM() {
    }

    public void hN() {
    }

    public void a(a aVar) {
        this.vK = aVar;
    }

    public void J(boolean z) {
        this.vL = z;
    }
}
