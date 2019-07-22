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
    private final com.airbnb.lottie.f kB;
    private final com.airbnb.lottie.model.layer.a mJ;
    private final com.airbnb.lottie.a.b.a<Float, Float> mK;
    private final com.airbnb.lottie.a.b.a<Float, Float> mL;
    private final com.airbnb.lottie.a.b.p mM;
    private c mN;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path lR = new Path();

    public n(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.g gVar) {
        this.kB = fVar;
        this.mJ = aVar;
        this.name = gVar.getName();
        this.mK = gVar.dx().cF();
        aVar.a(this.mK);
        this.mK.b(this);
        this.mL = gVar.dy().cF();
        aVar.a(this.mL);
        this.mL.b(this);
        this.mM = gVar.dz().cX();
        this.mM.a(aVar);
        this.mM.a(this);
    }

    @Override // com.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.mN == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.mN = new c(this.kB, this.mJ, "Repeater", arrayList, null);
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.mN.b(list, list2);
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path cd() {
        Path cd = this.mN.cd();
        this.lR.reset();
        float floatValue = this.mK.getValue().floatValue();
        float floatValue2 = this.mL.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.mM.h(i + floatValue2));
            this.lR.addPath(cd, this.matrix);
        }
        return this.lR;
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.mK.getValue().floatValue();
        float floatValue2 = this.mL.getValue().floatValue();
        float floatValue3 = this.mM.cx().getValue().floatValue() / 100.0f;
        float floatValue4 = this.mM.cy().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.mM.h(i2 + floatValue2));
            this.mN.a(canvas, this.matrix, (int) (i * com.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.mN.a(rectF, matrix);
    }

    @Override // com.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.mN.b(str, str2, colorFilter);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        this.kB.invalidateSelf();
    }
}
