package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0006a {
    private final com.airbnb.lottie.f jR;
    private final Path lh = new Path();
    @Nullable
    private q lq;
    private boolean ly;
    private final com.airbnb.lottie.a.b.a<?, Path> mb;
    private final String name;

    public o(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.jR = fVar;
        this.mb = kVar.df().ci();
        aVar.a(this.mb);
        this.mb.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        invalidate();
    }

    private void invalidate() {
        this.ly = false;
        this.jR.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).bO() == ShapeTrimPath.Type.Simultaneously) {
                    this.lq = (q) bVar;
                    this.lq.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.k
    public Path getPath() {
        if (this.ly) {
            return this.lh;
        }
        this.lh.reset();
        this.lh.set(this.mb.getValue());
        this.lh.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.c.f.a(this.lh, this.lq);
        this.ly = true;
        return this.lh;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
