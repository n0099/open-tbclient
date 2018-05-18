package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Ab;
    protected Path zZ = new Path();
    protected Paint Aa = null;
    protected boolean Ac = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Ab != null && (a2 = this.Ab.a(id())) != null) {
            this.zZ.set(a2);
            if (this.Aa == null) {
                this.Aa = new Paint();
                this.Aa.setStyle(Paint.Style.STROKE);
                this.Aa.setAntiAlias(true);
                this.Aa.setColor(637534208);
                this.Aa.setDither(true);
                this.Aa.setStrokeWidth(2.0f);
            }
            ii();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Ac) {
            canvas.drawPath(this.zZ, this.Aa);
            if (this.Ab != null) {
                this.Ab.e(canvas);
            }
        }
    }

    public void ii() {
    }

    public void ij() {
    }

    public void a(a aVar) {
        this.Ab = aVar;
    }

    public void O(boolean z) {
        this.Ac = z;
    }
}
