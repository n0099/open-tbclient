package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public class f extends a {
    private final Layer oG;
    private final Paint paint;
    private final RectF rect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.rect = new RectF();
        this.paint = new Paint();
        this.oG = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.oG.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) (((this.lZ.ca().getValue().intValue() * (alpha / 255.0f)) / 100.0f) * (i / 255.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            if (intValue > 0) {
                b(matrix);
                canvas.drawRect(this.rect, this.paint);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        b(this.oF);
        rectF.set(this.rect);
    }

    private void b(Matrix matrix) {
        this.rect.set(0.0f, 0.0f, this.oG.dv(), this.oG.du());
        matrix.mapRect(this.rect);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
