package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class o implements d, i, j, l, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BH;
    private final com.airbnb.lottie.model.layer.a Ds;
    private final com.airbnb.lottie.a.b.a<Float, Float> Ei;
    private final com.airbnb.lottie.a.b.a<Float, Float> Ej;
    private final com.airbnb.lottie.a.b.o Ek;
    private c El;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.BH = fVar;
        this.Ds = aVar;
        this.name = gVar.getName();
        this.Ei = gVar.jJ().jc();
        aVar.a(this.Ei);
        this.Ei.b(this);
        this.Ej = gVar.jK().jc();
        aVar.a(this.Ej);
        this.Ej.b(this);
        this.Ek = gVar.jL().jl();
        this.Ek.a(aVar);
        this.Ek.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.El == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.El = new c(this.BH, this.Ds, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        this.El.c(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iv() {
        Path iv = this.El.iv();
        this.path.reset();
        float floatValue = this.Ei.getValue().floatValue();
        float floatValue2 = this.Ej.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.Ek.h(i + floatValue2));
            this.path.addPath(iv, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.Ei.getValue().floatValue();
        float floatValue2 = this.Ej.getValue().floatValue();
        float floatValue3 = this.Ek.iR().getValue().floatValue() / 100.0f;
        float floatValue4 = this.Ek.iS().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.Ek.h(i2 + floatValue2));
            this.El.c(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.El.d(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BH.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.Ek.b(t, cVar)) {
            if (t == com.airbnb.lottie.j.CL) {
                this.Ei.a(cVar);
            } else if (t == com.airbnb.lottie.j.CN) {
                this.Ej.a(cVar);
            }
        }
    }
}
