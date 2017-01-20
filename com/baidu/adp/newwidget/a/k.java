package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a vC;
    protected Path vA = new Path();
    protected Paint vB = null;
    protected boolean vD = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.vC != null && (a2 = this.vC.a(hC())) != null) {
            this.vA.set(a2);
            if (this.vB == null) {
                this.vB = new Paint();
                this.vB.setStyle(Paint.Style.STROKE);
                this.vB.setAntiAlias(true);
                this.vB.setColor(637534208);
                this.vB.setDither(true);
                this.vB.setStrokeWidth(2.0f);
            }
            hK();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.vD) {
            canvas.drawPath(this.vA, this.vB);
            if (this.vC != null) {
                this.vC.c(canvas);
            }
        }
    }

    public void hK() {
    }

    public void hL() {
    }

    public void a(a aVar) {
        this.vC = aVar;
    }

    public void J(boolean z) {
        this.vD = z;
    }
}
