package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a BR;
    protected Path BP = new Path();
    protected Paint BQ = null;
    protected boolean BS = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BR != null && (a2 = this.BR.a(iy())) != null) {
            this.BP.set(a2);
            if (this.BQ == null) {
                this.BQ = new Paint();
                this.BQ.setStyle(Paint.Style.STROKE);
                this.BQ.setAntiAlias(true);
                this.BQ.setColor(637534208);
                this.BQ.setDither(true);
                this.BQ.setStrokeWidth(2.0f);
            }
            iG();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BS) {
            canvas.drawPath(this.BP, this.BQ);
            if (this.BR != null) {
                this.BR.e(canvas);
            }
        }
    }

    public void iG() {
    }

    public void iH() {
    }

    public void a(a aVar) {
        this.BR = aVar;
    }

    public void L(boolean z) {
        this.BS = z;
    }
}
