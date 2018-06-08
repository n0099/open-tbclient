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
    private q lC;
    private boolean lJ;
    private final Path lp = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> mm;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.jY = fVar;
        this.mm = kVar.dh().ck();
        aVar.a(this.mm);
        this.mm.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        invalidate();
    }

    private void invalidate() {
        this.lJ = false;
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
                    this.lC = (q) bVar;
                    this.lC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lJ) {
            return this.lp;
        }
        this.lp.reset();
        this.lp.set(this.mm.getValue());
        this.lp.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lp, this.lC);
        this.lJ = true;
        return this.lp;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
