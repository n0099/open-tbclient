package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private k rA;
    protected Path ry = new Path();
    protected Paint rz = null;
    protected boolean rB = false;

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a;
        super.a(dVar, imageView, scaleType);
        if (this.rA != null && (a = this.rA.a(gz())) != null) {
            this.ry.set(a);
            if (this.rz == null) {
                this.rz = new Paint();
                this.rz.setStyle(Paint.Style.STROKE);
                this.rz.setAntiAlias(true);
                this.rz.setColor(637534208);
                this.rz.setDither(true);
                this.rz.setStrokeWidth(2.0f);
            }
            gH();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.rB) {
            canvas.drawPath(this.ry, this.rz);
            if (this.rA != null) {
                this.rA.b(canvas);
            }
        }
    }

    public void gH() {
    }

    public void gI() {
    }

    public void a(k kVar) {
        this.rA = kVar;
    }

    public void E(boolean z) {
        this.rB = z;
    }
}
