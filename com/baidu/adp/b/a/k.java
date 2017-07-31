package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a DT;
    protected Path DR = new Path();
    protected Paint DS = null;
    protected boolean DU = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.DT != null && (a2 = this.DT.a(iH())) != null) {
            this.DR.set(a2);
            if (this.DS == null) {
                this.DS = new Paint();
                this.DS.setStyle(Paint.Style.STROKE);
                this.DS.setAntiAlias(true);
                this.DS.setColor(637534208);
                this.DS.setDither(true);
                this.DS.setStrokeWidth(2.0f);
            }
            iP();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.DU) {
            canvas.drawPath(this.DR, this.DS);
            if (this.DT != null) {
                this.DT.c(canvas);
            }
        }
    }

    public void iP() {
    }

    public void iQ() {
    }

    public void a(a aVar) {
        this.DT = aVar;
    }

    public void K(boolean z) {
        this.DU = z;
    }
}
