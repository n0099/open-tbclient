package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0010a {
    @Nullable
    private r BV;
    private final com.airbnb.lottie.a.b.a<?, Path> CD;
    private boolean Cb;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = gVar;
        this.CD = kVar.iP().ia();
        aVar.a(this.CD);
        this.CD.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        invalidate();
    }

    private void invalidate() {
        this.Cb = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).hA() == ShapeTrimPath.Type.Simultaneously) {
                    this.BV = (r) bVar;
                    this.BV.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path ht() {
        if (this.Cb) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.CD.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.f.a(this.path, this.BV);
        this.Cb = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
