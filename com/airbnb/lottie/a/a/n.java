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
    private final com.airbnb.lottie.f jQ;
    private final com.airbnb.lottie.model.layer.a lV;
    private final com.airbnb.lottie.a.b.a<Float, Float> lW;
    private final com.airbnb.lottie.a.b.a<Float, Float> lX;
    private final com.airbnb.lottie.a.b.p lY;
    private c lZ;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lg = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.jQ = fVar;
        this.lV = aVar;
        this.name = gVar.getName();
        this.lW = gVar.cZ().ci();
        aVar.a(this.lW);
        this.lW.b(this);
        this.lX = gVar.da().ci();
        aVar.a(this.lX);
        this.lX.b(this);
        this.lY = gVar.db().cA();
        this.lY.a(aVar);
        this.lY.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.lZ == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.lZ = new c(this.jQ, this.lV, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.lZ.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.lZ.getPath();
        this.lg.reset();
        float floatValue = this.lW.getValue().floatValue();
        float floatValue2 = this.lX.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.lY.h(i + floatValue2));
            this.lg.addPath(path, this.matrix);
        }
        return this.lg;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.lW.getValue().floatValue();
        float floatValue2 = this.lX.getValue().floatValue();
        float floatValue3 = this.lY.cb().getValue().floatValue() / 100.0f;
        float floatValue4 = this.lY.cc().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.lY.h(i2 + floatValue2));
            this.lZ.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.lZ.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.lZ.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jQ.invalidateSelf();
    }
}
