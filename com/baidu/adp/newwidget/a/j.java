package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a BR;
    protected Path BP = new Path();
    protected Paint BQ = null;
    protected boolean BS = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BR != null && (a2 = this.BR.a(ke())) != null) {
            this.BP.set(a2);
            if (this.BQ == null) {
                this.BQ = new Paint();
                this.BQ.setStyle(Paint.Style.STROKE);
                this.BQ.setAntiAlias(true);
                this.BQ.setColor(637534208);
                this.BQ.setDither(true);
                this.BQ.setStrokeWidth(2.0f);
            }
            km();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BS) {
            canvas.drawPath(this.BP, this.BQ);
            if (this.BR != null) {
                this.BR.c(canvas);
            }
        }
    }

    public void km() {
    }

    public void kn() {
    }

    public void a(a aVar) {
        this.BR = aVar;
    }

    public void G(boolean z) {
        this.BS = z;
    }
}
