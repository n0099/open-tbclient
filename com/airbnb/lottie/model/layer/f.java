package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.j;
/* loaded from: classes5.dex */
public class f extends a {
    @Nullable
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> EW;
    private final Layer HV;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.rect = new RectF();
        this.paint = new Paint();
        this.points = new float[8];
        this.path = new Path();
        this.HV = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void d(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.HV.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) (((this.FD.iP().getValue().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            if (this.EW != null) {
                this.paint.setColorFilter(this.EW.getValue());
            }
            if (intValue > 0) {
                this.points[0] = 0.0f;
                this.points[1] = 0.0f;
                this.points[2] = this.HV.kf();
                this.points[3] = 0.0f;
                this.points[4] = this.HV.kf();
                this.points[5] = this.HV.ke();
                this.points[6] = 0.0f;
                this.points[7] = this.HV.ke();
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

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.rect.set(0.0f, 0.0f, this.HV.kf(), this.HV.ke());
        this.HU.mapRect(this.rect);
        rectF.set(this.rect);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        super.a((f) t, (com.airbnb.lottie.e.c<f>) cVar);
        if (t == j.Ex) {
            if (cVar == null) {
                this.EW = null;
            } else {
                this.EW = new p(cVar);
            }
        }
    }
}
