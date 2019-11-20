package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes2.dex */
public class n implements d, i, k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f cG;
    private final com.airbnb.lottie.model.layer.a eG;
    private final com.airbnb.lottie.a.b.a<Float, Float> eH;
    private final com.airbnb.lottie.a.b.a<Float, Float> eI;
    private final com.airbnb.lottie.a.b.p eJ;
    private c eK;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.cG = fVar;
        this.eG = aVar;
        this.name = gVar.getName();
        this.eH = gVar.cQ().bY();
        aVar.a(this.eH);
        this.eH.b(this);
        this.eI = gVar.cR().bY();
        aVar.a(this.eI);
        this.eI.b(this);
        this.eJ = gVar.cS().cq();
        this.eJ.a(aVar);
        this.eJ.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.eK == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.eK = new c(this.cG, this.eG, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.eK.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path bw() {
        Path bw = this.eK.bw();
        this.path.reset();
        float floatValue = this.eH.getValue().floatValue();
        float floatValue2 = this.eI.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.eJ.h(i + floatValue2));
            this.path.addPath(bw, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.eH.getValue().floatValue();
        float floatValue2 = this.eI.getValue().floatValue();
        float floatValue3 = this.eJ.bQ().getValue().floatValue() / 100.0f;
        float floatValue4 = this.eJ.bR().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.eJ.h(i2 + floatValue2));
            this.eK.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.eK.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.eK.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        this.cG.invalidateSelf();
    }
}
