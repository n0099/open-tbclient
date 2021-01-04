package com.baidu.live.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.baidu.live.lottie.h;
import com.baidu.live.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends a {
    private final com.baidu.live.lottie.a.a.c bua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar, Layer layer) {
        super(hVar, layer);
        this.bua = new com.baidu.live.lottie.a.a.c(hVar, this, new j("__container", layer.iY()));
        this.bua.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.baidu.live.lottie.model.layer.a
    void d(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.bua.c(canvas, matrix, i);
    }

    @Override // com.baidu.live.lottie.model.layer.a, com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.bua.d(rectF, this.Gz);
    }

    @Override // com.baidu.live.lottie.model.layer.a
    protected void b(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        this.bua.a(eVar, i, list, eVar2);
    }
}
