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
    private final com.airbnb.lottie.f kC;
    private final com.airbnb.lottie.model.layer.a mK;
    private final com.airbnb.lottie.a.b.a<Float, Float> mL;
    private final com.airbnb.lottie.a.b.a<Float, Float> mM;
    private final com.airbnb.lottie.a.b.p mN;
    private c mO;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lS = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.kC = fVar;
        this.mK = aVar;
        this.name = gVar.getName();
        this.mL = gVar.dq().cz();
        aVar.a(this.mL);
        this.mL.b(this);
        this.mM = gVar.dr().cz();
        aVar.a(this.mM);
        this.mM.b(this);
        this.mN = gVar.ds().cR();
        this.mN.a(aVar);
        this.mN.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.mO == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.mO = new c(this.kC, this.mK, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.mO.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        Path path = this.mO.getPath();
        this.lS.reset();
        float floatValue = this.mL.getValue().floatValue();
        float floatValue2 = this.mM.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.mN.h(i + floatValue2));
            this.lS.addPath(path, this.matrix);
        }
        return this.lS;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.mL.getValue().floatValue();
        float floatValue2 = this.mM.getValue().floatValue();
        float floatValue3 = this.mN.cs().getValue().floatValue() / 100.0f;
        float floatValue4 = this.mN.ct().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.mN.h(i2 + floatValue2));
            this.mO.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.mO.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.mO.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        this.kC.invalidateSelf();
    }
}
