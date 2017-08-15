package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a DV;
    protected Path DT = new Path();
    protected Paint DU = null;
    protected boolean DW = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.DV != null && (a2 = this.DV.a(iH())) != null) {
            this.DT.set(a2);
            if (this.DU == null) {
                this.DU = new Paint();
                this.DU.setStyle(Paint.Style.STROKE);
                this.DU.setAntiAlias(true);
                this.DU.setColor(637534208);
                this.DU.setDither(true);
                this.DU.setStrokeWidth(2.0f);
            }
            iP();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.DW) {
            canvas.drawPath(this.DT, this.DU);
            if (this.DV != null) {
                this.DV.c(canvas);
            }
        }
    }

    public void iP() {
    }

    public void iQ() {
    }

    public void a(a aVar) {
        this.DV = aVar;
    }

    public void K(boolean z) {
        this.DW = z;
    }
}
