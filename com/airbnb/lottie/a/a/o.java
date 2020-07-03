package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes6.dex */
public class o implements d, i, j, l, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a BM;
    private final com.airbnb.lottie.a.b.o CB;
    private c CC;
    private final com.airbnb.lottie.a.b.a<Float, Float> Cy;
    private final com.airbnb.lottie.a.b.a<Float, Float> Cz;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.BM = aVar;
        this.name = gVar2.getName();
        this.Cy = gVar2.iJ().ia();
        aVar.a(this.Cy);
        this.Cy.b(this);
        this.Cz = gVar2.iK().ia();
        aVar.a(this.Cz);
        this.Cz.b(this);
        this.CB = gVar2.iL().ik();
        this.CB.a(aVar);
        this.CB.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.CC == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.CC = new c(this.lottieDrawable, this.BM, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.CC.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path ht() {
        Path ht = this.CC.ht();
        this.path.reset();
        float floatValue = this.Cy.getValue().floatValue();
        float floatValue2 = this.Cz.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.CB.i(i + floatValue2));
            this.path.addPath(ht, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.Cy.getValue().floatValue();
        float floatValue2 = this.Cz.getValue().floatValue();
        float floatValue3 = this.CB.hP().getValue().floatValue() / 100.0f;
        float floatValue4 = this.CB.hQ().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.CB.i(i2 + floatValue2));
            this.CC.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.CC.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.CB.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.Bk) {
                this.Cy.a(cVar);
            } else if (t == com.airbnb.lottie.k.Bl) {
                this.Cz.a(cVar);
            }
        }
    }
}
