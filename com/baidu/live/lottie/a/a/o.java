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
/* loaded from: classes10.dex */
public class o implements d, i, j, l, a.InterfaceC0194a {
    private final com.baidu.live.lottie.model.layer.a btA;
    private final com.baidu.live.lottie.a.b.a<Float, Float> btX;
    private final com.baidu.live.lottie.a.b.a<Float, Float> btY;
    private final com.baidu.live.lottie.a.b.o btZ;
    private c bua;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.g gVar) {
        this.lottieDrawable = hVar;
        this.btA = aVar;
        this.name = gVar.getName();
        this.btX = gVar.Qs().PP();
        aVar.a(this.btX);
        this.btX.b(this);
        this.btY = gVar.Qt().PP();
        aVar.a(this.btY);
        this.btY.b(this);
        this.btZ = gVar.Qu().PY();
        this.btZ.a(aVar);
        this.btZ.a(this);
    }

    @Override // com.baidu.live.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.bua == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.bua = new c(this.lottieDrawable, this.btA, "Repeater", arrayList, null);
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        this.bua.c(list, list2);
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        Path iv = this.bua.iv();
        this.path.reset();
        float floatValue = this.btX.getValue().floatValue();
        float floatValue2 = this.btY.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.btZ.h(i + floatValue2));
            this.path.addPath(iv, this.matrix);
        }
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.btX.getValue().floatValue();
        float floatValue2 = this.btY.getValue().floatValue();
        float floatValue3 = this.btZ.PL().getValue().floatValue() / 100.0f;
        float floatValue4 = this.btZ.PM().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.btZ.h(i2 + floatValue2));
            this.bua.c(canvas, this.matrix, (int) (i * com.baidu.live.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.bua.d(rectF, matrix);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (!this.btZ.b(t, cVar)) {
            if (t == com.baidu.live.lottie.l.CO) {
                this.btX.a(cVar);
            } else if (t == com.baidu.live.lottie.l.CP) {
                this.btY.a(cVar);
            }
        }
    }
}
