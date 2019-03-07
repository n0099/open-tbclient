package com.baidu.adp.newwidget.ImageView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class j extends b {
    private a Js;
    protected Path Jq = new Path();
    protected Paint Jr = null;
    protected boolean Jt = false;

    /* loaded from: classes.dex */
    public interface a {
        Path a(RectF rectF);

        void e(Canvas canvas);
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(c cVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        super.a(cVar, imageView, scaleType);
        if (this.Js != null && (a2 = this.Js.a(ml())) != null) {
            this.Jq.set(a2);
            if (this.Jr == null) {
                this.Jr = new Paint();
                this.Jr.setStyle(Paint.Style.STROKE);
                this.Jr.setAntiAlias(true);
                this.Jr.setColor(637534208);
                this.Jr.setDither(true);
                this.Jr.setStrokeWidth(2.0f);
            }
            mq();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.a
    public void a(Canvas canvas, c cVar, ImageView imageView) {
        super.a(canvas, cVar, imageView);
        if (this.Jt) {
            canvas.drawPath(this.Jq, this.Jr);
            if (this.Js != null) {
                this.Js.e(canvas);
            }
        }
    }

    public void mq() {
    }

    public void mr() {
    }

    public void a(a aVar) {
        this.Js = aVar;
    }

    public void an(boolean z) {
        this.Jt = z;
    }
}
