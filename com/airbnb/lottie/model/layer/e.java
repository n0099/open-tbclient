package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
/* loaded from: classes2.dex */
public class e extends a {
    private final com.airbnb.lottie.a.a.c fk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.fk = new com.airbnb.lottie.a.a.c(fVar, this, new j(layer.getName(), layer.bX()));
        this.fk.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.fk.a(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.fk.a(rectF, this.hK);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.fk.b(str, str2, colorFilter);
    }
}
