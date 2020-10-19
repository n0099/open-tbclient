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
/* loaded from: classes10.dex */
public class o implements d, i, j, l, a.InterfaceC0011a {
    private final com.airbnb.lottie.model.layer.a CK;
    private final com.airbnb.lottie.a.b.a<Float, Float> DC;
    private final com.airbnb.lottie.a.b.a<Float, Float> DD;
    private final com.airbnb.lottie.a.b.o DE;
    private c DG;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.CK = aVar;
        this.name = gVar2.getName();
        this.DC = gVar2.kk().jD();
        aVar.a(this.DC);
        this.DC.b(this);
        this.DD = gVar2.kl().jD();
        aVar.a(this.DD);
        this.DD.b(this);
        this.DE = gVar2.km().jM();
        this.DE.a(aVar);
        this.DE.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.DG == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.DG = new c(this.lottieDrawable, this.CK, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.DG.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iW() {
        Path iW = this.DG.iW();
        this.path.reset();
        float floatValue = this.DC.getValue().floatValue();
        float floatValue2 = this.DD.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.DE.i(i + floatValue2));
            this.path.addPath(iW, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.DC.getValue().floatValue();
        float floatValue2 = this.DD.getValue().floatValue();
        float floatValue3 = this.DE.js().getValue().floatValue() / 100.0f;
        float floatValue4 = this.DE.jt().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.DE.i(i2 + floatValue2));
            this.DG.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.DG.a(rectF, matrix);
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
        if (!this.DE.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.Ch) {
                this.DC.a(cVar);
            } else if (t == com.airbnb.lottie.k.Ci) {
                this.DD.a(cVar);
            }
        }
    }
}
