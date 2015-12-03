package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a BX;
    protected Path BV = new Path();
    protected Paint BW = null;
    protected boolean BY = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BX != null && (a2 = this.BX.a(ke())) != null) {
            this.BV.set(a2);
            if (this.BW == null) {
                this.BW = new Paint();
                this.BW.setStyle(Paint.Style.STROKE);
                this.BW.setAntiAlias(true);
                this.BW.setColor(637534208);
                this.BW.setDither(true);
                this.BW.setStrokeWidth(2.0f);
            }
            km();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BY) {
            canvas.drawPath(this.BV, this.BW);
            if (this.BX != null) {
                this.BX.c(canvas);
            }
        }
    }

    public void km() {
    }

    public void kn() {
    }

    public void a(a aVar) {
        this.BX = aVar;
    }

    public void G(boolean z) {
        this.BY = z;
    }
}
