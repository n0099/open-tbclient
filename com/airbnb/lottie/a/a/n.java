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
    private final com.airbnb.lottie.f jR;
    private final com.airbnb.lottie.model.layer.a lW;
    private final com.airbnb.lottie.a.b.a<Float, Float> lX;
    private final com.airbnb.lottie.a.b.a<Float, Float> lY;
    private final com.airbnb.lottie.a.b.p lZ;
    private c ma;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lh = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.jR = fVar;
        this.lW = aVar;
        this.name = gVar.getName();
        this.lX = gVar.cZ().ci();
        aVar.a(this.lX);
        this.lX.b(this);
        this.lY = gVar.da().ci();
        aVar.a(this.lY);
        this.lY.b(this);
        this.lZ = gVar.db().cA();
        this.lZ.a(aVar);
        this.lZ.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.ma == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.ma = new c(this.jR, this.lW, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.ma.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.ma.getPath();
        this.lh.reset();
        float floatValue = this.lX.getValue().floatValue();
        float floatValue2 = this.lY.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.lZ.h(i + floatValue2));
            this.lh.addPath(path, this.matrix);
        }
        return this.lh;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.lX.getValue().floatValue();
        float floatValue2 = this.lY.getValue().floatValue();
        float floatValue3 = this.lZ.cb().getValue().floatValue() / 100.0f;
        float floatValue4 = this.lZ.cc().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.lZ.h(i2 + floatValue2));
            this.ma.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.ma.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.ma.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        this.jR.invalidateSelf();
    }
}
