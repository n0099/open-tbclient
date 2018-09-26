package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f mp;
    private final Path nJ = new Path();
    @Nullable
    private q nS;
    private boolean nZ;
    private final String name;
    private final com.airbnb.lottie.a.b.a<?, Path> oE;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.mp = fVar;
        this.oE = kVar.em().dp();
        aVar.a(this.oE);
        this.oE.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        invalidate();
    }

    private void invalidate() {
        this.nZ = false;
        this.mp.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cV() == ShapeTrimPath.Type.Simultaneously) {
                    this.nS = (q) bVar;
                    this.nS.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.nZ) {
            return this.nJ;
        }
        this.nJ.reset();
        this.nJ.set(this.oE.getValue());
        this.nJ.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.nJ, this.nS);
        this.nZ = true;
        return this.nJ;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
