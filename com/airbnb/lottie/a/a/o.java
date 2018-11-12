package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0009a {
    private final String name;
    private final com.airbnb.lottie.f nh;
    @Nullable
    private q oH;
    private boolean oO;
    private final Path oy = new Path();
    private final com.airbnb.lottie.a.b.a<?, Path> px;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.nh = fVar;
        this.px = kVar.eD().dG();
        aVar.a(this.px);
        this.px.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        invalidate();
    }

    private void invalidate() {
        this.oO = false;
        this.nh.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dm() == ShapeTrimPath.Type.Simultaneously) {
                    this.oH = (q) bVar;
                    this.oH.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.oO) {
            return this.oy;
        }
        this.oy.reset();
        this.oy.set(this.px.getValue());
        this.oy.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.oy, this.oH);
        this.oO = true;
        return this.oy;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
