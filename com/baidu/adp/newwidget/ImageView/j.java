package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a IG;
    protected Path IE = new Path();
    protected Paint IF = null;
    protected boolean IH = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.IG != null && (a2 = this.IG.a(lZ())) != null) {
            this.IE.set(a2);
            if (this.IF == null) {
                this.IF = new Paint();
                this.IF.setStyle(Paint.Style.STROKE);
                this.IF.setAntiAlias(true);
                this.IF.setColor(637534208);
                this.IF.setDither(true);
                this.IF.setStrokeWidth(2.0f);
            }
            me();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.IH) {
            canvas.drawPath(this.IE, this.IF);
            if (this.IG != null) {
                this.IG.e(canvas);
            }
        }
    }

    public void me() {
    }

    public void mf() {
    }

    public void a(a aVar) {
        this.IG = aVar;
    }

    public void Z(boolean z) {
        this.IH = z;
    }
}
