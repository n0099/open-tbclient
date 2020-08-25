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
/* loaded from: classes18.dex */
public class o implements d, i, j, l, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a Cs;
    private final com.airbnb.lottie.a.b.a<Float, Float> Dk;
    private final com.airbnb.lottie.a.b.a<Float, Float> Dl;
    private final com.airbnb.lottie.a.b.o Dm;
    private c Dn;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.Cs = aVar;
        this.name = gVar2.getName();
        this.Dk = gVar2.ki().jB();
        aVar.a(this.Dk);
        this.Dk.b(this);
        this.Dl = gVar2.kj().jB();
        aVar.a(this.Dl);
        this.Dl.b(this);
        this.Dm = gVar2.kk().jK();
        this.Dm.a(aVar);
        this.Dm.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.Dn == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.Dn = new c(this.lottieDrawable, this.Cs, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.Dn.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iU() {
        Path iU = this.Dn.iU();
        this.path.reset();
        float floatValue = this.Dk.getValue().floatValue();
        float floatValue2 = this.Dl.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.Dm.i(i + floatValue2));
            this.path.addPath(iU, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.Dk.getValue().floatValue();
        float floatValue2 = this.Dl.getValue().floatValue();
        float floatValue3 = this.Dm.jq().getValue().floatValue() / 100.0f;
        float floatValue4 = this.Dm.jr().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.Dm.i(i2 + floatValue2));
            this.Dn.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.Dn.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void iR() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.Dm.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.BQ) {
                this.Dk.a(cVar);
            } else if (t == com.airbnb.lottie.k.BR) {
                this.Dl.a(cVar);
            }
        }
    }
}
