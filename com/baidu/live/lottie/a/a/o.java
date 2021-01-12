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
public class o implements d, i, j, l, a.InterfaceC0185a {
    private final com.baidu.live.lottie.model.layer.a boN;
    private final com.baidu.live.lottie.a.b.a<Float, Float> bpk;
    private final com.baidu.live.lottie.a.b.a<Float, Float> bpl;
    private final com.baidu.live.lottie.a.b.o bpm;
    private c bpn;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.g gVar) {
        this.lottieDrawable = hVar;
        this.boN = aVar;
        this.name = gVar.getName();
        this.bpk = gVar.Mx().LU();
        aVar.a(this.bpk);
        this.bpk.b(this);
        this.bpl = gVar.My().LU();
        aVar.a(this.bpl);
        this.bpl.b(this);
        this.bpm = gVar.Mz().Md();
        this.bpm.a(aVar);
        this.bpm.a(this);
    }

    @Override // com.baidu.live.lottie.a.a.i
    public void b(ListIterator<b> listIterator) {
        if (this.bpn == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.bpn = new c(this.lottieDrawable, this.boN, "Repeater", arrayList, null);
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        this.bpn.c(list, list2);
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        Path iv = this.bpn.iv();
        this.path.reset();
        float floatValue = this.bpk.getValue().floatValue();
        float floatValue2 = this.bpl.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.bpm.h(i + floatValue2));
            this.path.addPath(iv, this.matrix);
        }
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.bpk.getValue().floatValue();
        float floatValue2 = this.bpl.getValue().floatValue();
        float floatValue3 = this.bpm.LQ().getValue().floatValue() / 100.0f;
        float floatValue4 = this.bpm.LR().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.bpm.h(i2 + floatValue2));
            this.bpn.c(canvas, this.matrix, (int) (i * com.baidu.live.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.baidu.live.lottie.a.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.bpn.d(rectF, matrix);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0185a
    public void is() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.model.f
    public void a(com.baidu.live.lottie.model.e eVar, int i, List<com.baidu.live.lottie.model.e> list, com.baidu.live.lottie.model.e eVar2) {
        com.baidu.live.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.baidu.live.lottie.model.f
    public <T> void a(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (!this.bpm.b(t, cVar)) {
            if (t == com.baidu.live.lottie.l.CL) {
                this.bpk.a(cVar);
            } else if (t == com.baidu.live.lottie.l.CN) {
                this.bpl.a(cVar);
            }
        }
    }
}
