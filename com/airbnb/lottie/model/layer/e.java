package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends a {
    private final com.airbnb.lottie.a.a.c gw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.gw = new com.airbnb.lottie.a.a.c(gVar, this, new j("__container", layer.ci()));
        this.gw.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.gw.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.gw.a(rectF, this.iV);
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void b(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        this.gw.a(eVar, i, list, eVar2);
    }
}
