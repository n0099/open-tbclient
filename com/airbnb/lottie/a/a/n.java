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
    private final com.airbnb.lottie.f jY;
    private final com.airbnb.lottie.model.layer.a mf;
    private final com.airbnb.lottie.a.b.a<Float, Float> mg;
    private final com.airbnb.lottie.a.b.a<Float, Float> mh;
    private final com.airbnb.lottie.a.b.p mi;
    private c mj;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lo = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.jY = fVar;
        this.mf = aVar;
        this.name = gVar.getName();
        this.mg = gVar.db().ck();
        aVar.a(this.mg);
        this.mg.b(this);
        this.mh = gVar.dc().ck();
        aVar.a(this.mh);
        this.mh.b(this);
        this.mi = gVar.dd().cC();
        this.mi.a(aVar);
        this.mi.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.mj == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.mj = new c(this.jY, this.mf, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.mj.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.mj.getPath();
        this.lo.reset();
        float floatValue = this.mg.getValue().floatValue();
        float floatValue2 = this.mh.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.mi.h(i + floatValue2));
            this.lo.addPath(path, this.matrix);
        }
        return this.lo;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.mg.getValue().floatValue();
        float floatValue2 = this.mh.getValue().floatValue();
        float floatValue3 = this.mi.cd().getValue().floatValue() / 100.0f;
        float floatValue4 = this.mi.ce().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.mi.h(i2 + floatValue2));
            this.mj.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.mj.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.mj.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }
}
