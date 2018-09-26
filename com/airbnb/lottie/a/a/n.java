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
public class n implements d, i, k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f mp;
    private final String name;
    private final com.airbnb.lottie.a.b.a<Float, Float> oA;
    private final com.airbnb.lottie.a.b.a<Float, Float> oB;
    private final com.airbnb.lottie.a.b.p oC;
    private c oD;
    private final com.airbnb.lottie.model.layer.a oz;
    private final Matrix matrix = new Matrix();
    private final Path nJ = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.mp = fVar;
        this.oz = aVar;
        this.name = gVar.getName();
        this.oA = gVar.eg().dp();
        aVar.a(this.oA);
        this.oA.b(this);
        this.oB = gVar.eh().dp();
        aVar.a(this.oB);
        this.oB.b(this);
        this.oC = gVar.ei().dH();
        this.oC.a(aVar);
        this.oC.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.oD == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.oD = new c(this.mp, this.oz, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.oD.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.oD.getPath();
        this.nJ.reset();
        float floatValue = this.oA.getValue().floatValue();
        float floatValue2 = this.oB.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.oC.h(i + floatValue2));
            this.nJ.addPath(path, this.matrix);
        }
        return this.nJ;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.oA.getValue().floatValue();
        float floatValue2 = this.oB.getValue().floatValue();
        float floatValue3 = this.oC.di().getValue().floatValue() / 100.0f;
        float floatValue4 = this.oC.dj().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.oC.h(i2 + floatValue2));
            this.oD.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oD.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.oD.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        this.mp.invalidateSelf();
    }
}
