package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apK;
    protected Path apI = new Path();
    protected Paint apJ = null;
    protected boolean apL = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apK != null && (a2 = this.apK.a(pY())) != null) {
            this.apI.set(a2);
            if (this.apJ == null) {
                this.apJ = new Paint();
                this.apJ.setStyle(Paint.Style.STROKE);
                this.apJ.setAntiAlias(true);
                this.apJ.setColor(637534208);
                this.apJ.setDither(true);
                this.apJ.setStrokeWidth(2.0f);
            }
            qd();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apL) {
            canvas.drawPath(this.apI, this.apJ);
            if (this.apK != null) {
                this.apK.h(canvas);
            }
        }
    }

    public void qd() {
    }

    public void qe() {
    }

    public void a(a aVar) {
        this.apK = aVar;
    }

    public void as(boolean z) {
        this.apL = z;
    }
}
