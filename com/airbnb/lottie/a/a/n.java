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
    private final com.airbnb.lottie.model.layer.a mh;
    private final com.airbnb.lottie.a.b.a<Float, Float> mi;
    private final com.airbnb.lottie.a.b.a<Float, Float> mj;
    private final com.airbnb.lottie.a.b.p mk;
    private c ml;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lp = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.jY = fVar;
        this.mh = aVar;
        this.name = gVar.getName();
        this.mi = gVar.db().ck();
        aVar.a(this.mi);
        this.mi.b(this);
        this.mj = gVar.dc().ck();
        aVar.a(this.mj);
        this.mj.b(this);
        this.mk = gVar.dd().cC();
        this.mk.a(aVar);
        this.mk.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.ml == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.ml = new c(this.jY, this.mh, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.ml.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.ml.getPath();
        this.lp.reset();
        float floatValue = this.mi.getValue().floatValue();
        float floatValue2 = this.mj.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.mk.h(i + floatValue2));
            this.lp.addPath(path, this.matrix);
        }
        return this.lp;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.mi.getValue().floatValue();
        float floatValue2 = this.mj.getValue().floatValue();
        float floatValue3 = this.mk.cd().getValue().floatValue() / 100.0f;
        float floatValue4 = this.mk.ce().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.mk.h(i2 + floatValue2));
            this.ml.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.ml.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.ml.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        this.jY.invalidateSelf();
    }
}
