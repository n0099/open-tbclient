package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0007a {
    private final String name;
    private final com.airbnb.lottie.f nc;
    @Nullable
    private q oC;
    private boolean oJ;
    private final Path ot = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> pq;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.nc = fVar;
        this.pq = kVar.eC().dF();
        aVar.a(this.pq);
        this.pq.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        invalidate();
    }

    private void invalidate() {
        this.oJ = false;
        this.nc.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dl() == ShapeTrimPath.Type.Simultaneously) {
                    this.oC = (q) bVar;
                    this.oC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.oJ) {
            return this.ot;
        }
        this.ot.reset();
        this.ot.set(this.pq.getValue());
        this.ot.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.ot, this.oC);
        this.oJ = true;
        return this.ot;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
