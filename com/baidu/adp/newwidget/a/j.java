package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    private a BP;
    protected Path BN = new Path();
    protected Paint BO = null;
    protected boolean BQ = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BP != null && (a2 = this.BP.a(kb())) != null) {
            this.BN.set(a2);
            if (this.BO == null) {
                this.BO = new Paint();
                this.BO.setStyle(Paint.Style.STROKE);
                this.BO.setAntiAlias(true);
                this.BO.setColor(637534208);
                this.BO.setDither(true);
                this.BO.setStrokeWidth(2.0f);
            }
            kj();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BQ) {
            canvas.drawPath(this.BN, this.BO);
            if (this.BP != null) {
                this.BP.c(canvas);
            }
        }
    }

    public void kj() {
    }

    public void kk() {
    }

    public void a(a aVar) {
        this.BP = aVar;
    }

    public void G(boolean z) {
        this.BQ = z;
    }
}
