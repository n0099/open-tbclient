package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Ji;
    protected Path Jg = new Path();
    protected Paint Jh = null;
    protected boolean Jj = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Ji != null && (a2 = this.Ji.a(mj())) != null) {
            this.Jg.set(a2);
            if (this.Jh == null) {
                this.Jh = new Paint();
                this.Jh.setStyle(Paint.Style.STROKE);
                this.Jh.setAntiAlias(true);
                this.Jh.setColor(637534208);
                this.Jh.setDither(true);
                this.Jh.setStrokeWidth(2.0f);
            }
            mo();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Jj) {
            canvas.drawPath(this.Jg, this.Jh);
            if (this.Ji != null) {
                this.Ji.e(canvas);
            }
        }
    }

    public void mo() {
    }

    public void mp() {
    }

    public void a(a aVar) {
        this.Ji = aVar;
    }

    public void Z(boolean z) {
        this.Jj = z;
    }
}
