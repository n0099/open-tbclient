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
    private final String name;
    private final com.airbnb.lottie.f nc;
    private final com.airbnb.lottie.model.layer.a pi;
    private final com.airbnb.lottie.a.b.a<Float, Float> pj;
    private final com.airbnb.lottie.a.b.a<Float, Float> pl;
    private final com.airbnb.lottie.a.b.p po;
    private c pp;
    private final Matrix matrix = new Matrix();
    private final Path ot = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.nc = fVar;
        this.pi = aVar;
        this.name = gVar.getName();
        this.pj = gVar.ew().dF();
        aVar.a(this.pj);
        this.pj.b(this);
        this.pl = gVar.ex().dF();
        aVar.a(this.pl);
        this.pl.b(this);
        this.po = gVar.ey().dX();
        this.po.a(aVar);
        this.po.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.pp == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.pp = new c(this.nc, this.pi, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.pp.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.pp.getPath();
        this.ot.reset();
        float floatValue = this.pj.getValue().floatValue();
        float floatValue2 = this.pl.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.po.h(i + floatValue2));
            this.ot.addPath(path, this.matrix);
        }
        return this.ot;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.pj.getValue().floatValue();
        float floatValue2 = this.pl.getValue().floatValue();
        float floatValue3 = this.po.dy().getValue().floatValue() / 100.0f;
        float floatValue4 = this.po.dz().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.po.h(i2 + floatValue2));
            this.pp.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.pp.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.pp.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        this.nc.invalidateSelf();
    }
}
