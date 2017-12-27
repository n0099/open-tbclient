package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apI;
    protected Path apG = new Path();
    protected Paint apH = null;
    protected boolean apJ = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apI != null && (a2 = this.apI.a(pX())) != null) {
            this.apG.set(a2);
            if (this.apH == null) {
                this.apH = new Paint();
                this.apH.setStyle(Paint.Style.STROKE);
                this.apH.setAntiAlias(true);
                this.apH.setColor(637534208);
                this.apH.setDither(true);
                this.apH.setStrokeWidth(2.0f);
            }
            qc();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apJ) {
            canvas.drawPath(this.apG, this.apH);
            if (this.apI != null) {
                this.apI.h(canvas);
            }
        }
    }

    public void qc() {
    }

    public void qd() {
    }

    public void a(a aVar) {
        this.apI = aVar;
    }

    public void ar(boolean z) {
        this.apJ = z;
    }
}
