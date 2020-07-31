package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes20.dex */
public class e extends a {
    private final com.airbnb.lottie.a.a.c CE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.CE = new com.airbnb.lottie.a.a.c(gVar, this, new j("__container", layer.hW()));
        this.CE.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.CE.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.CE.a(rectF, this.EZ);
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        this.CE.a(eVar, i, list, eVar2);
    }
}
