package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f dh;
    @Nullable
    private q eB;
    private boolean eI;
    private final com.airbnb.lottie.a.b.a<?, Path> fl;
    private final String name;
    private final Path path = new Path();

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.dh = fVar;
        this.fl = kVar.cW().bY();
        aVar.a(this.fl);
        this.fl.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.eI = false;
        this.dh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bD() == ShapeTrimPath.Type.Simultaneously) {
                    this.eB = (q) bVar;
                    this.eB.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.eI) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.fl.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.path, this.eB);
        this.eI = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
