package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Jl;
    protected Path Jj = new Path();
    protected Paint Jk = null;
    protected boolean Jm = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Jl != null && (a2 = this.Jl.a(mh())) != null) {
            this.Jj.set(a2);
            if (this.Jk == null) {
                this.Jk = new Paint();
                this.Jk.setStyle(Paint.Style.STROKE);
                this.Jk.setAntiAlias(true);
                this.Jk.setColor(637534208);
                this.Jk.setDither(true);
                this.Jk.setStrokeWidth(2.0f);
            }
            mm();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Jm) {
            canvas.drawPath(this.Jj, this.Jk);
            if (this.Jl != null) {
                this.Jl.e(canvas);
            }
        }
    }

    public void mm() {
    }

    public void mn() {
    }

    public void a(a aVar) {
        this.Jl = aVar;
    }

    public void an(boolean z) {
        this.Jm = z;
    }
}
