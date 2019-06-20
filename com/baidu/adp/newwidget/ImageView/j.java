package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Hb;
    protected Path GZ = new Path();
    protected Paint Ha = null;
    protected boolean Hc = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Hb != null && (a2 = this.Hb.a(lf())) != null) {
            this.GZ.set(a2);
            if (this.Ha == null) {
                this.Ha = new Paint();
                this.Ha.setStyle(Paint.Style.STROKE);
                this.Ha.setAntiAlias(true);
                this.Ha.setColor(637534208);
                this.Ha.setDither(true);
                this.Ha.setStrokeWidth(2.0f);
            }
            lk();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Hc) {
            canvas.drawPath(this.GZ, this.Ha);
            if (this.Hb != null) {
                this.Hb.e(canvas);
            }
        }
    }

    public void lk() {
    }

    public void ll() {
    }

    public void a(a aVar) {
        this.Hb = aVar;
    }

    public void af(boolean z) {
        this.Hc = z;
    }
}
