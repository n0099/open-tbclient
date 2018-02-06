package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a apJ;
    protected Path apH = new Path();
    protected Paint apI = null;
    protected boolean apK = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void h(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.apJ != null && (a2 = this.apJ.a(pY())) != null) {
            this.apH.set(a2);
            if (this.apI == null) {
                this.apI = new Paint();
                this.apI.setStyle(Paint.Style.STROKE);
                this.apI.setAntiAlias(true);
                this.apI.setColor(637534208);
                this.apI.setDither(true);
                this.apI.setStrokeWidth(2.0f);
            }
            qd();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.apK) {
            canvas.drawPath(this.apH, this.apI);
            if (this.apJ != null) {
                this.apJ.h(canvas);
            }
        }
    }

    public void qd() {
    }

    public void qe() {
    }

    public void a(a aVar) {
        this.apJ = aVar;
    }

    public void av(boolean z) {
        this.apK = z;
    }
}
