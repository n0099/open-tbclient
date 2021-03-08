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
/* loaded from: classes5.dex */
public class o implements d, i, j, l, a.InterfaceC0013a {
    private final com.airbnb.lottie.f Df;
    private final com.airbnb.lottie.model.layer.a EO;
    private final com.airbnb.lottie.a.b.a<Float, Float> FB;
    private final com.airbnb.lottie.a.b.a<Float, Float> FC;
    private final com.airbnb.lottie.a.b.o FD;
    private c FE;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.Df = fVar;
        this.EO = aVar;
        this.name = gVar.getName();
        this.FB = gVar.jI().jb();
        aVar.a(this.FB);
        this.FB.b(this);
        this.FC = gVar.jJ().jb();
        aVar.a(this.FC);
        this.FC.b(this);
        this.FD = gVar.jK().jk();
        this.FD.a(aVar);
        this.FD.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.FE == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.FE = new c(this.Df, this.EO, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.FE.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iu() {
        Path iu = this.FE.iu();
        this.path.reset();
        float floatValue = this.FB.getValue().floatValue();
        float floatValue2 = this.FC.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.FD.l(i + floatValue2));
            this.path.addPath(iu, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.FB.getValue().floatValue();
        float floatValue2 = this.FC.getValue().floatValue();
        float floatValue3 = this.FD.iQ().getValue().floatValue() / 100.0f;
        float floatValue4 = this.FD.iR().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.FD.l(i2 + floatValue2));
            this.FE.c(canvas, this.matrix, (int) (i * com.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.FE.d(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.f
    public void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (!this.FD.b(t, cVar)) {
            if (t == com.airbnb.lottie.j.Em) {
                this.FB.a(cVar);
            } else if (t == com.airbnb.lottie.j.En) {
                this.FC.a(cVar);
            }
        }
    }
}
