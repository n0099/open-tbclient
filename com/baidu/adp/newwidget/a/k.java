package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a sS;
    protected Path sQ = new Path();
    protected Paint sR = null;
    protected boolean sT = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.sS != null && (a2 = this.sS.a(gK())) != null) {
            this.sQ.set(a2);
            if (this.sR == null) {
                this.sR = new Paint();
                this.sR.setStyle(Paint.Style.STROKE);
                this.sR.setAntiAlias(true);
                this.sR.setColor(637534208);
                this.sR.setDither(true);
                this.sR.setStrokeWidth(2.0f);
            }
            gS();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.sT) {
            canvas.drawPath(this.sQ, this.sR);
            if (this.sS != null) {
                this.sS.c(canvas);
            }
        }
    }

    public void gS() {
    }

    public void gT() {
    }

    public void a(a aVar) {
        this.sS = aVar;
    }

    public void F(boolean z) {
        this.sT = z;
    }
}
