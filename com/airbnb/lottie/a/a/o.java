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
    private final com.airbnb.lottie.a.b.a<Float, Float> BY;
    private final com.airbnb.lottie.a.b.a<Float, Float> BZ;
    private final com.airbnb.lottie.model.layer.a Bm;
    private final com.airbnb.lottie.a.b.o Ca;
    private c Cb;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.Bm = aVar;
        this.name = gVar2.getName();
        this.BY = gVar2.it().hK();
        aVar.a(this.BY);
        this.BY.b(this);
        this.BZ = gVar2.iu().hK();
        aVar.a(this.BZ);
        this.BZ.b(this);
        this.Ca = gVar2.iv().hT();
        this.Ca.a(aVar);
        this.Ca.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.Cb == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.Cb = new c(this.lottieDrawable, this.Bm, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.Cb.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path hd() {
        Path hd = this.Cb.hd();
        this.path.reset();
        float floatValue = this.BY.getValue().floatValue();
        float floatValue2 = this.BZ.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.Ca.g(i + floatValue2));
            this.path.addPath(hd, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.BY.getValue().floatValue();
        float floatValue2 = this.BZ.getValue().floatValue();
        float floatValue3 = this.Ca.hz().getValue().floatValue() / 100.0f;
        float floatValue4 = this.Ca.hA().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.Ca.g(i2 + floatValue2));
            this.Cb.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.Cb.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void ha() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.Ca.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.AH) {
                this.BY.a(cVar);
            } else if (t == com.airbnb.lottie.k.AI) {
                this.BZ.a(cVar);
            }
        }
    }
}
