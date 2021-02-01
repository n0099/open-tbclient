package com.baidu.live.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.p;
import com.baidu.live.lottie.h;
import com.baidu.live.lottie.l;
/* loaded from: classes10.dex */
public class f extends a {
    @Nullable
    private com.baidu.live.lottie.a.b.a<ColorFilter, ColorFilter> bss;
    private final Layer buc;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar, Layer layer) {
        super(hVar, layer);
        this.rect = new RectF();
        this.paint = new Paint();
        this.points = new float[8];
        this.path = new Path();
        this.buc = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    @Override // com.baidu.live.lottie.model.layer.a
    public void d(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.buc.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) (((this.bsN.Nn().getValue().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            if (this.bss != null) {
                this.paint.setColorFilter(this.bss.getValue());
            }
            if (intValue > 0) {
                this.points[0] = 0.0f;
                this.points[1] = 0.0f;
                this.points[2] = this.buc.kf();
                this.points[3] = 0.0f;
                this.points[4] = this.buc.kf();
                this.points[5] = this.buc.ke();
                this.points[6] = 0.0f;
                this.points[7] = this.buc.ke();
                matrix.mapPoints(this.points);
                this.path.reset();
                this.path.moveTo(this.points[0], this.points[1]);
                this.path.lineTo(this.points[2], this.points[3]);
                this.path.lineTo(this.points[4], this.points[5]);
                this.path.lineTo(this.points[6], this.points[7]);
                this.path.lineTo(this.points[0], this.points[1]);
                this.path.close();
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.rect.set(0.0f, 0.0f, this.buc.kf(), this.buc.ke());
        this.Gx.mapRect(this.rect);
        rectF.set(this.rect);
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        super.a((f) t, (com.baidu.live.lottie.e.c<f>) cVar);
        if (t == l.Db) {
            if (cVar == null) {
                this.bss = null;
            } else {
                this.bss = new p(cVar);
            }
        }
    }
}
