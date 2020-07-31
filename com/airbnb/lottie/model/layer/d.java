package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
/* loaded from: classes20.dex */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
