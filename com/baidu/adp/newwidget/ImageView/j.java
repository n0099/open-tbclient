package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Ac;
    protected Path Aa = new Path();
    protected Paint Ab = null;
    protected boolean Ae = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Ac != null && (a2 = this.Ac.a(id())) != null) {
            this.Aa.set(a2);
            if (this.Ab == null) {
                this.Ab = new Paint();
                this.Ab.setStyle(Paint.Style.STROKE);
                this.Ab.setAntiAlias(true);
                this.Ab.setColor(637534208);
                this.Ab.setDither(true);
                this.Ab.setStrokeWidth(2.0f);
            }
            ii();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Ae) {
            canvas.drawPath(this.Aa, this.Ab);
            if (this.Ac != null) {
                this.Ac.e(canvas);
            }
        }
    }

    public void ii() {
    }

    public void ij() {
    }

    public void a(a aVar) {
        this.Ac = aVar;
    }

    public void O(boolean z) {
        this.Ae = z;
    }
}
