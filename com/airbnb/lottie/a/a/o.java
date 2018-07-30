package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jQ;
    private final Path lg = new Path();
    @Nullable
    private q lp;
    private boolean lx;
    private final com.airbnb.lottie.a.b.a<?, Path> ma;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.jQ = fVar;
        this.ma = kVar.df().ci();
        aVar.a(this.ma);
        this.ma.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidate();
    }

    private void invalidate() {
        this.lx = false;
        this.jQ.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Simultaneously) {
                    this.lp = (q) bVar;
                    this.lp.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.lx) {
            return this.lg;
        }
        this.lg.reset();
        this.lg.set(this.ma.getValue());
        this.lg.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lg, this.lp);
        this.lx = true;
        return this.lg;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
