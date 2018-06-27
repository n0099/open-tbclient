package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jY;
    @Nullable
    private q lA;
    private boolean lH;
    private final Path lo = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> mk;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.jY = fVar;
        this.mk = kVar.dh().ck();
        aVar.a(this.mk);
        this.mk.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        invalidate();
    }

    private void invalidate() {
        this.lH = false;
        this.jY.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bQ() == ShapeTrimPath.Type.Simultaneously) {
                    this.lA = (q) bVar;
                    this.lA.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lH) {
            return this.lo;
        }
        this.lo.reset();
        this.lo.set(this.mk.getValue());
        this.lo.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lo, this.lA);
        this.lH = true;
        return this.lo;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
