package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apH;
    protected Path apF = new Path();
    protected Paint apG = null;
    protected boolean apI = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apH != null && (a2 = this.apH.a(pX())) != null) {
            this.apF.set(a2);
            if (this.apG == null) {
                this.apG = new Paint();
                this.apG.setStyle(Paint.Style.STROKE);
                this.apG.setAntiAlias(true);
                this.apG.setColor(637534208);
                this.apG.setDither(true);
                this.apG.setStrokeWidth(2.0f);
            }
            qc();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apI) {
            canvas.drawPath(this.apF, this.apG);
            if (this.apH != null) {
                this.apH.h(canvas);
            }
        }
    }

    public void qc() {
    }

    public void qd() {
    }

    public void a(a aVar) {
        this.apH = aVar;
    }

    public void ar(boolean z) {
        this.apI = z;
    }
}
