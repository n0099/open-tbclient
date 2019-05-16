package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Hc;
    protected Path Ha = new Path();
    protected Paint Hb = null;
    protected boolean Hd = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Hc != null && (a2 = this.Hc.a(lf())) != null) {
            this.Ha.set(a2);
            if (this.Hb == null) {
                this.Hb = new Paint();
                this.Hb.setStyle(Paint.Style.STROKE);
                this.Hb.setAntiAlias(true);
                this.Hb.setColor(637534208);
                this.Hb.setDither(true);
                this.Hb.setStrokeWidth(2.0f);
            }
            lk();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Hd) {
            canvas.drawPath(this.Ha, this.Hb);
            if (this.Hc != null) {
                this.Hc.e(canvas);
            }
        }
    }

    public void lk() {
    }

    public void ll() {
    }

    public void a(a aVar) {
        this.Hc = aVar;
    }

    public void af(boolean z) {
        this.Hd = z;
    }
}
