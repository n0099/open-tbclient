package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Gl;
    protected Path Gj = new Path();
    protected Paint Gk = null;
    protected boolean Gm = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void g(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Gl != null && (a2 = this.Gl.a(kR())) != null) {
            this.Gj.set(a2);
            if (this.Gk == null) {
                this.Gk = new Paint();
                this.Gk.setStyle(Paint.Style.STROKE);
                this.Gk.setAntiAlias(true);
                this.Gk.setColor(637534208);
                this.Gk.setDither(true);
                this.Gk.setStrokeWidth(2.0f);
            }
            kW();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Gm) {
            canvas.drawPath(this.Gj, this.Gk);
            if (this.Gl != null) {
                this.Gl.g(canvas);
            }
        }
    }

    public void kW() {
    }

    public void kX() {
    }

    public void a(a aVar) {
        this.Gl = aVar;
    }

    public void Q(boolean z) {
        this.Gm = z;
    }
}
