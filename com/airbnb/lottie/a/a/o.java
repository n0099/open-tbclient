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
/* loaded from: classes20.dex */
public class o implements d, i, j, l, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a BO;
    private final com.airbnb.lottie.a.b.a<Float, Float> CB;
    private final com.airbnb.lottie.a.b.a<Float, Float> CC;
    private final com.airbnb.lottie.a.b.o CD;
    private c CE;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.BO = aVar;
        this.name = gVar2.getName();
        this.CB = gVar2.iJ().ia();
        aVar.a(this.CB);
        this.CB.b(this);
        this.CC = gVar2.iK().ia();
        aVar.a(this.CC);
        this.CC.b(this);
        this.CD = gVar2.iL().ik();
        this.CD.a(aVar);
        this.CD.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.CE == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.CE = new c(this.lottieDrawable, this.BO, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.CE.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path ht() {
        Path ht = this.CE.ht();
        this.path.reset();
        float floatValue = this.CB.getValue().floatValue();
        float floatValue2 = this.CC.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.CD.i(i + floatValue2));
            this.path.addPath(ht, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.CB.getValue().floatValue();
        float floatValue2 = this.CC.getValue().floatValue();
        float floatValue3 = this.CD.hP().getValue().floatValue() / 100.0f;
        float floatValue4 = this.CD.hQ().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.CD.i(i2 + floatValue2));
            this.CE.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.CE.a(rectF, matrix);
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
        if (!this.CD.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.Bm) {
                this.CB.a(cVar);
            } else if (t == com.airbnb.lottie.k.Bn) {
                this.CC.a(cVar);
            }
        }
    }
}
