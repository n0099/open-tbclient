package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apA;
    protected Path apy = new Path();
    protected Paint apz = null;
    protected boolean apB = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apA != null && (a2 = this.apA.a(pY())) != null) {
            this.apy.set(a2);
            if (this.apz == null) {
                this.apz = new Paint();
                this.apz.setStyle(Paint.Style.STROKE);
                this.apz.setAntiAlias(true);
                this.apz.setColor(637534208);
                this.apz.setDither(true);
                this.apz.setStrokeWidth(2.0f);
            }
            qd();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apB) {
            canvas.drawPath(this.apy, this.apz);
            if (this.apA != null) {
                this.apA.h(canvas);
            }
        }
    }

    public void qd() {
    }

    public void qe() {
    }

    public void a(a aVar) {
        this.apA = aVar;
    }

    public void av(boolean z) {
        this.apB = z;
    }
}
