package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a CQ;
    protected Path CO = new Path();
    protected Paint CP = null;
    protected boolean CR = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.CQ != null && (a2 = this.CQ.a(iw())) != null) {
            this.CO.set(a2);
            if (this.CP == null) {
                this.CP = new Paint();
                this.CP.setStyle(Paint.Style.STROKE);
                this.CP.setAntiAlias(true);
                this.CP.setColor(637534208);
                this.CP.setDither(true);
                this.CP.setStrokeWidth(2.0f);
            }
            iE();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.CR) {
            canvas.drawPath(this.CO, this.CP);
            if (this.CQ != null) {
                this.CQ.c(canvas);
            }
        }
    }

    public void iE() {
    }

    public void iF() {
    }

    public void a(a aVar) {
        this.CQ = aVar;
    }

    public void K(boolean z) {
        this.CR = z;
    }
}
