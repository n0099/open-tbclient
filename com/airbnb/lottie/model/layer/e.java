package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends a {
    private final com.airbnb.lottie.a.a.c El;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.El = new com.airbnb.lottie.a.a.c(fVar, this, new j("__container", layer.iY()));
        this.El.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void d(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.El.c(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.El.d(rectF, this.Gx);
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        this.El.a(eVar, i, list, eVar2);
    }
}
