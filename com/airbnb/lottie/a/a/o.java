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
/* loaded from: classes7.dex */
public class o implements d, i, j, l, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a DH;
    private final com.airbnb.lottie.a.b.a<Float, Float> Ev;
    private final com.airbnb.lottie.a.b.a<Float, Float> Ew;
    private final com.airbnb.lottie.a.b.o Ex;
    private c Ey;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.DH = aVar;
        this.name = gVar2.getName();
        this.Ev = gVar2.kk().jD();
        aVar.a(this.Ev);
        this.Ev.b(this);
        this.Ew = gVar2.kl().jD();
        aVar.a(this.Ew);
        this.Ew.b(this);
        this.Ex = gVar2.km().jM();
        this.Ex.a(aVar);
        this.Ex.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.Ey == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.Ey = new c(this.lottieDrawable, this.DH, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.Ey.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iW() {
        Path iW = this.Ey.iW();
        this.path.reset();
        float floatValue = this.Ev.getValue().floatValue();
        float floatValue2 = this.Ew.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.Ex.h(i + floatValue2));
            this.path.addPath(iW, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.Ev.getValue().floatValue();
        float floatValue2 = this.Ew.getValue().floatValue();
        float floatValue3 = this.Ex.js().getValue().floatValue() / 100.0f;
        float floatValue4 = this.Ex.jt().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.Ex.h(i2 + floatValue2));
            this.Ey.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.Ey.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.Ex.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.Dd) {
                this.Ev.a(cVar);
            } else if (t == com.airbnb.lottie.k.De) {
                this.Ew.a(cVar);
            }
        }
    }
}
