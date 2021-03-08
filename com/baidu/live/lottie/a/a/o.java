package com.baidu.live.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes9.dex */
public class o implements d, i, j, l, a.InterfaceC0192a {
    private final com.baidu.live.lottie.model.layer.a btP;
    private final com.baidu.live.lottie.a.b.a<Float, Float> bun;
    private final com.baidu.live.lottie.a.b.a<Float, Float> buo;
    private final com.baidu.live.lottie.a.b.o bup;
    private c buq;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.g gVar) {
        this.lottieDrawable = hVar;
        this.btP = aVar;
        this.name = gVar.getName();
        this.bun = gVar.NY().Nv();
        aVar.a(this.bun);
        this.bun.b(this);
        this.buo = gVar.NZ().Nv();
        aVar.a(this.buo);
        this.buo.b(this);
        this.bup = gVar.Oa().NE();
        this.bup.a(aVar);
        this.bup.a(this);
    }

    @Override // com.baidu.live.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.buq == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.buq = new c(this.lottieDrawable, this.btP, "Repeater", arrayList, null);
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.buq.b(list, list2);
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iu() {
        Path iu = this.buq.iu();
        this.path.reset();
        float floatValue = this.bun.getValue().floatValue();
        float floatValue2 = this.buo.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.bup.l(i + floatValue2));
            this.path.addPath(iu, this.matrix);
        }
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.bun.getValue().floatValue();
        float floatValue2 = this.buo.getValue().floatValue();
        float floatValue3 = this.bup.Nr().getValue().floatValue() / 100.0f;
        float floatValue4 = this.bup.Ns().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.bup.l(i2 + floatValue2));
            this.buq.c(canvas, this.matrix, (int) (i * com.baidu.live.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.buq.d(rectF, matrix);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (!this.bup.b(t, cVar)) {
            if (t == com.baidu.live.lottie.l.Em) {
                this.bun.a(cVar);
            } else if (t == com.baidu.live.lottie.l.En) {
                this.buo.a(cVar);
            }
        }
    }
}
