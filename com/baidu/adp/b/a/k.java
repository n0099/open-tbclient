package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apB;
    protected Path apz = new Path();
    protected Paint apA = null;
    protected boolean apC = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apB != null && (a2 = this.apB.a(pY())) != null) {
            this.apz.set(a2);
            if (this.apA == null) {
                this.apA = new Paint();
                this.apA.setStyle(Paint.Style.STROKE);
                this.apA.setAntiAlias(true);
                this.apA.setColor(637534208);
                this.apA.setDither(true);
                this.apA.setStrokeWidth(2.0f);
            }
            qd();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apC) {
            canvas.drawPath(this.apz, this.apA);
            if (this.apB != null) {
                this.apB.h(canvas);
            }
        }
    }

    public void qd() {
    }

    public void qe() {
    }

    public void a(a aVar) {
        this.apB = aVar;
    }

    public void av(boolean z) {
        this.apC = z;
    }
}
