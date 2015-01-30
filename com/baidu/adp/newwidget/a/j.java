package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private k rF;
    protected Path rD = new Path();
    protected Paint rE = null;
    protected boolean rG = false;

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a;
        super.a(dVar, imageView, scaleType);
        if (this.rF != null && (a = this.rF.a(gy())) != null) {
            this.rD.set(a);
            if (this.rE == null) {
                this.rE = new Paint();
                this.rE.setStyle(Paint.Style.STROKE);
                this.rE.setAntiAlias(true);
                this.rE.setColor(637534208);
                this.rE.setDither(true);
                this.rE.setStrokeWidth(2.0f);
            }
            gG();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.rG) {
            canvas.drawPath(this.rD, this.rE);
            if (this.rF != null) {
                this.rF.b(canvas);
            }
        }
    }

    public void gG() {
    }

    public void gH() {
    }

    public void a(k kVar) {
        this.rF = kVar;
    }

    public void E(boolean z) {
        this.rG = z;
    }
}
