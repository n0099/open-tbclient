package com.baidu.adp.newwidget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends c {
    protected Path i = new Path();
    protected Paint j = null;
    protected boolean k = false;
    private k l;

    @Override // com.baidu.adp.newwidget.a.a
    public void a(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a;
        super.a(dVar, imageView, scaleType);
        if (this.l != null && (a = this.l.a(b())) != null) {
            this.i.set(a);
            if (this.j == null) {
                this.j = new Paint();
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setAntiAlias(true);
                this.j.setColor(637534208);
                this.j.setDither(true);
                this.j.setStrokeWidth(2.0f);
            }
            c();
        }
    }

    @Override // com.baidu.adp.newwidget.a.a
    public void a(Canvas canvas, d dVar, ImageView imageView) {
        super.a(canvas, dVar, imageView);
        if (this.k) {
            canvas.drawPath(this.i, this.j);
            if (this.l != null) {
                this.l.a(canvas);
            }
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void a(k kVar) {
        this.l = kVar;
    }

    public void a(boolean z) {
        this.k = z;
    }
}
