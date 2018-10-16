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
public class n implements d, i, k, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    private final com.airbnb.lottie.model.layer.a pq;
    private final com.airbnb.lottie.a.b.a<Float, Float> pr;
    private final com.airbnb.lottie.a.b.a<Float, Float> pt;
    private final com.airbnb.lottie.a.b.p pu;
    private c pv;
    private final Matrix matrix = new Matrix();
    private final Path oy = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.nh = fVar;
        this.pq = aVar;
        this.name = gVar.getName();
        this.pr = gVar.ey().dH();
        aVar.a(this.pr);
        this.pr.b(this);
        this.pt = gVar.ez().dH();
        aVar.a(this.pt);
        this.pt.b(this);
        this.pu = gVar.eA().dZ();
        this.pu.a(aVar);
        this.pu.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.pv == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.pv = new c(this.nh, this.pq, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.pv.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.pv.getPath();
        this.oy.reset();
        float floatValue = this.pr.getValue().floatValue();
        float floatValue2 = this.pt.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.pu.h(i + floatValue2));
            this.oy.addPath(path, this.matrix);
        }
        return this.oy;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.pr.getValue().floatValue();
        float floatValue2 = this.pt.getValue().floatValue();
        float floatValue3 = this.pu.dA().getValue().floatValue() / 100.0f;
        float floatValue4 = this.pu.dB().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.pu.h(i2 + floatValue2));
            this.pv.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.pv.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.pv.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
        this.nh.invalidateSelf();
    }
}
