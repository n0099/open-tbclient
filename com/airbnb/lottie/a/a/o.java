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
    private final com.airbnb.lottie.model.layer.a fK;
    private c gA;
    private final com.airbnb.lottie.a.b.a<Float, Float> gx;
    private final com.airbnb.lottie.a.b.a<Float, Float> gy;
    private final com.airbnb.lottie.a.b.o gz;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.fK = aVar;
        this.name = gVar2.getName();
        this.gx = gVar2.cU().cn();
        aVar.a(this.gx);
        this.gx.b(this);
        this.gy = gVar2.cV().cn();
        aVar.a(this.gy);
        this.gy.b(this);
        this.gz = gVar2.cW().cw();
        this.gz.a(aVar);
        this.gz.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.gA == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.gA = new c(this.lottieDrawable, this.fK, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.gA.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path bG() {
        Path bG = this.gA.bG();
        this.path.reset();
        float floatValue = this.gx.getValue().floatValue();
        float floatValue2 = this.gy.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.gz.j(i + floatValue2));
            this.path.addPath(bG, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.gx.getValue().floatValue();
        float floatValue2 = this.gy.getValue().floatValue();
        float floatValue3 = this.gz.cc().getValue().floatValue() / 100.0f;
        float floatValue4 = this.gz.cd().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.gz.j(i2 + floatValue2));
            this.gA.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.gA.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.gz.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.eZ) {
                this.gx.a(cVar);
            } else if (t == com.airbnb.lottie.k.fb) {
                this.gy.a(cVar);
            }
        }
    }
}
