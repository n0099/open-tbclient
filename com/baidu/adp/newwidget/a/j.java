package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a CC;
    protected Path CA = new Path();
    protected Paint CB = null;
    protected boolean CD = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.CC != null && (a2 = this.CC.a(kv())) != null) {
            this.CA.set(a2);
            if (this.CB == null) {
                this.CB = new Paint();
                this.CB.setStyle(Paint.Style.STROKE);
                this.CB.setAntiAlias(true);
                this.CB.setColor(637534208);
                this.CB.setDither(true);
                this.CB.setStrokeWidth(2.0f);
            }
            kD();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.CD) {
            canvas.drawPath(this.CA, this.CB);
            if (this.CC != null) {
                this.CC.c(canvas);
            }
        }
    }

    public void kD() {
    }

    public void kE() {
    }

    public void a(a aVar) {
        this.CC = aVar;
    }

    public void F(boolean z) {
        this.CD = z;
    }
}
