package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a sR;
    protected Path sP = new Path();
    protected Paint sQ = null;
    protected boolean sS = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.sR != null && (a2 = this.sR.a(gI())) != null) {
            this.sP.set(a2);
            if (this.sQ == null) {
                this.sQ = new Paint();
                this.sQ.setStyle(Paint.Style.STROKE);
                this.sQ.setAntiAlias(true);
                this.sQ.setColor(637534208);
                this.sQ.setDither(true);
                this.sQ.setStrokeWidth(2.0f);
            }
            gQ();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.sS) {
            canvas.drawPath(this.sP, this.sQ);
            if (this.sR != null) {
                this.sR.c(canvas);
            }
        }
    }

    public void gQ() {
    }

    public void gR() {
    }

    public void a(a aVar) {
        this.sR = aVar;
    }

    public void F(boolean z) {
        this.sS = z;
    }
}
