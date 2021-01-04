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
    private final com.airbnb.lottie.f BJ;
    private final com.airbnb.lottie.model.layer.a Du;
    private final com.airbnb.lottie.a.b.a<Float, Float> Ek;
    private final com.airbnb.lottie.a.b.a<Float, Float> El;
    private final com.airbnb.lottie.a.b.o Em;
    private c En;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.BJ = fVar;
        this.Du = aVar;
        this.name = gVar.getName();
        this.Ek = gVar.jJ().jc();
        aVar.a(this.Ek);
        this.Ek.b(this);
        this.El = gVar.jK().jc();
        aVar.a(this.El);
        this.El.b(this);
        this.Em = gVar.jL().jl();
        this.Em.a(aVar);
        this.Em.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.En == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.En = new c(this.BJ, this.Du, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        this.En.c(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iv() {
        Path iv = this.En.iv();
        this.path.reset();
        float floatValue = this.Ek.getValue().floatValue();
        float floatValue2 = this.El.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.Em.h(i + floatValue2));
            this.path.addPath(iv, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.Ek.getValue().floatValue();
        float floatValue2 = this.El.getValue().floatValue();
        float floatValue3 = this.Em.iR().getValue().floatValue() / 100.0f;
        float floatValue4 = this.Em.iS().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.Em.h(i2 + floatValue2));
            this.En.c(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.En.d(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        this.BJ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.Em.b(t, cVar)) {
            if (t == com.airbnb.lottie.j.CO) {
                this.Ek.a(cVar);
            } else if (t == com.airbnb.lottie.j.CP) {
                this.El.a(cVar);
            }
        }
    }
}
