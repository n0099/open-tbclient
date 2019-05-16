package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kC;
    private final Path lS = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> mP;
    @Nullable
    private q mb;
    private boolean mj;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.kC = fVar;
        this.mP = kVar.dw().cz();
        aVar.a(this.mP);
        this.mP.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        invalidate();
    }

    private void invalidate() {
        this.mj = false;
        this.kC.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cf() == ShapeTrimPath.Type.Simultaneously) {
                    this.mb = (q) bVar;
                    this.mb.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.mj) {
            return this.lS;
        }
        this.lS.reset();
        this.lS.set(this.mP.getValue());
        this.lS.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lS, this.mb);
        this.mj = true;
        return this.lS;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
