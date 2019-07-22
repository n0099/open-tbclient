package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0007a {
    private final com.airbnb.lottie.f kB;
    private final Path lR = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> mO;
    @Nullable
    private q ma;
    private boolean mi;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.kB = fVar;
        this.mO = kVar.dD().cF();
        aVar.a(this.mO);
        this.mO.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        invalidate();
    }

    private void invalidate() {
        this.mi = false;
        this.kB.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).ck() == ShapeTrimPath.Type.Simultaneously) {
                    this.ma = (q) bVar;
                    this.ma.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path cd() {
        if (this.mi) {
            return this.lR;
        }
        this.lR.reset();
        this.lR.set(this.mO.getValue());
        this.lR.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lR, this.ma);
        this.mi = true;
        return this.lR;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
