package com.baidu.adp.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class k extends c {
    private a BC;
    protected Path BA = new Path();
    protected Paint BB = null;
    protected boolean BD = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void d(Canvas canvas);
    }

    @Override // com.baidu.adp.b.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(dVar, imageView, scaleType);
        if (this.BC != null && (a2 = this.BC.a(iy())) != null) {
            this.BA.set(a2);
            if (this.BB == null) {
                this.BB = new Paint();
                this.BB.setStyle(Paint.Style.STROKE);
                this.BB.setAntiAlias(true);
                this.BB.setColor(637534208);
                this.BB.setDither(true);
                this.BB.setStrokeWidth(2.0f);
            }
            iD();
        }
    }

    @Override // com.baidu.adp.b.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.BD) {
            canvas.drawPath(this.BA, this.BB);
            if (this.BC != null) {
                this.BC.d(canvas);
            }
        }
    }

    public void iD() {
    }

    public void iE() {
    }

    public void a(a aVar) {
        this.BC = aVar;
    }

    public void L(boolean z) {
        this.BD = z;
    }
}
