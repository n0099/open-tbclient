package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a BQ;
    protected Path BO = new Path();
    protected Paint BP = null;
    protected boolean BR = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BQ != null && (a2 = this.BQ.a(kd())) != null) {
            this.BO.set(a2);
            if (this.BP == null) {
                this.BP = new Paint();
                this.BP.setStyle(Paint.Style.STROKE);
                this.BP.setAntiAlias(true);
                this.BP.setColor(637534208);
                this.BP.setDither(true);
                this.BP.setStrokeWidth(2.0f);
            }
            kl();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BR) {
            canvas.drawPath(this.BO, this.BP);
            if (this.BQ != null) {
                this.BQ.c(canvas);
            }
        }
    }

    public void kl() {
    }

    public void km() {
    }

    public void a(a aVar) {
        this.BQ = aVar;
    }

    public void G(boolean z) {
        this.BR = z;
    }
}
