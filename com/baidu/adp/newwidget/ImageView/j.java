package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Hm;
    protected Path Hk = new Path();
    protected Paint Hl = null;
    protected boolean Hn = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Hm != null && (a2 = this.Hm.a(lv())) != null) {
            this.Hk.set(a2);
            if (this.Hl == null) {
                this.Hl = new Paint();
                this.Hl.setStyle(Paint.Style.STROKE);
                this.Hl.setAntiAlias(true);
                this.Hl.setColor(637534208);
                this.Hl.setDither(true);
                this.Hl.setStrokeWidth(2.0f);
            }
            lA();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Hn) {
            canvas.drawPath(this.Hk, this.Hl);
            if (this.Hm != null) {
                this.Hm.e(canvas);
            }
        }
    }

    public void lA() {
    }

    public void lB() {
    }

    public void a(a aVar) {
        this.Hm = aVar;
    }

    public void ah(boolean z) {
        this.Hn = z;
    }
}
