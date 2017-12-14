package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a BB;
    protected Path Bz = new Path();
    protected Paint BA = null;
    protected boolean BC = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void d(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BB != null && (a2 = this.BB.a(iy())) != null) {
            this.Bz.set(a2);
            if (this.BA == null) {
                this.BA = new Paint();
                this.BA.setStyle(Paint.Style.STROKE);
                this.BA.setAntiAlias(true);
                this.BA.setColor(637534208);
                this.BA.setDither(true);
                this.BA.setStrokeWidth(2.0f);
            }
            iD();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BC) {
            canvas.drawPath(this.Bz, this.BA);
            if (this.BB != null) {
                this.BB.d(canvas);
            }
        }
    }

    public void iD() {
    }

    public void iE() {
    }

    public void a(a aVar) {
        this.BB = aVar;
    }

    public void L(boolean z) {
        this.BC = z;
    }
}
