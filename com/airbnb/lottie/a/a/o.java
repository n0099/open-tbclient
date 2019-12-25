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
/* loaded from: classes4.dex */
public class o implements d, i, j, l, a.InterfaceC0010a {
    private final com.airbnb.lottie.model.layer.a fG;
    private final com.airbnb.lottie.a.b.a<Float, Float> gt;
    private final com.airbnb.lottie.a.b.a<Float, Float> gu;
    private final com.airbnb.lottie.a.b.o gv;
    private c gw;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.fG = aVar;
        this.name = gVar2.getName();
        this.gt = gVar2.cT().cm();
        aVar.a(this.gt);
        this.gt.b(this);
        this.gu = gVar2.cU().cm();
        aVar.a(this.gu);
        this.gu.b(this);
        this.gv = gVar2.cV().cv();
        this.gv.a(aVar);
        this.gv.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.gw == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.gw = new c(this.lottieDrawable, this.fG, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.gw.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path bF() {
        Path bF = this.gw.bF();
        this.path.reset();
        float floatValue = this.gt.getValue().floatValue();
        float floatValue2 = this.gu.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.gv.j(i + floatValue2));
            this.path.addPath(bF, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.gt.getValue().floatValue();
        float floatValue2 = this.gu.getValue().floatValue();
        float floatValue3 = this.gv.cb().getValue().floatValue() / 100.0f;
        float floatValue4 = this.gv.cc().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.gv.j(i2 + floatValue2));
            this.gw.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.gw.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.gv.b(t, cVar)) {
            if (t == com.airbnb.lottie.k.eX) {
                this.gt.a(cVar);
            } else if (t == com.airbnb.lottie.k.eY) {
                this.gu.a(cVar);
            }
        }
    }
}
