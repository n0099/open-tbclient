package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a tx;
    protected Path tv = new Path();
    protected Paint tw = null;
    protected boolean ty = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void c(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.tx != null && (a2 = this.tx.a(gJ())) != null) {
            this.tv.set(a2);
            if (this.tw == null) {
                this.tw = new Paint();
                this.tw.setStyle(Paint.Style.STROKE);
                this.tw.setAntiAlias(true);
                this.tw.setColor(637534208);
                this.tw.setDither(true);
                this.tw.setStrokeWidth(2.0f);
            }
            gR();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.ty) {
            canvas.drawPath(this.tv, this.tw);
            if (this.tx != null) {
                this.tx.c(canvas);
            }
        }
    }

    public void gR() {
    }

    public void gS() {
    }

    public void a(a aVar) {
        this.tx = aVar;
    }

    public void H(boolean z) {
        this.ty = z;
    }
}
