package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a BS;
    protected Path BQ = new Path();
    protected Paint BR = null;
    protected boolean BT = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BS != null && (a2 = this.BS.a(iy())) != null) {
            this.BQ.set(a2);
            if (this.BR == null) {
                this.BR = new Paint();
                this.BR.setStyle(Paint.Style.STROKE);
                this.BR.setAntiAlias(true);
                this.BR.setColor(637534208);
                this.BR.setDither(true);
                this.BR.setStrokeWidth(2.0f);
            }
            iG();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BT) {
            canvas.drawPath(this.BQ, this.BR);
            if (this.BS != null) {
                this.BS.e(canvas);
            }
        }
    }

    public void iG() {
    }

    public void iH() {
    }

    public void a(a aVar) {
        this.BS = aVar;
    }

    public void L(boolean z) {
        this.BT = z;
    }
}
