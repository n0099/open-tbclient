package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes2.dex */
public class n implements d, i, k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f dh;
    private final com.airbnb.lottie.model.layer.a fg;
    private final com.airbnb.lottie.a.b.a<Float, Float> fh;
    private final com.airbnb.lottie.a.b.a<Float, Float> fi;
    private final com.airbnb.lottie.a.b.p fj;
    private c fk;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.dh = fVar;
        this.fg = aVar;
        this.name = gVar.getName();
        this.fh = gVar.cQ().bY();
        aVar.a(this.fh);
        this.fh.b(this);
        this.fi = gVar.cR().bY();
        aVar.a(this.fi);
        this.fi.b(this);
        this.fj = gVar.cS().cq();
        this.fj.a(aVar);
        this.fj.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.fk == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.fk = new c(this.dh, this.fg, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.fk.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path bw() {
        Path bw = this.fk.bw();
        this.path.reset();
        float floatValue = this.fh.getValue().floatValue();
        float floatValue2 = this.fi.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.fj.h(i + floatValue2));
            this.path.addPath(bw, this.matrix);
        }
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.fh.getValue().floatValue();
        float floatValue2 = this.fi.getValue().floatValue();
        float floatValue3 = this.fj.bQ().getValue().floatValue() / 100.0f;
        float floatValue4 = this.fj.bR().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.fj.h(i2 + floatValue2));
            this.fk.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.fk.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.fk.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        this.dh.invalidateSelf();
    }
}
