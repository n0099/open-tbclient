package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0010a {
    @Nullable
    private r fT;
    private boolean fZ;
    private final com.airbnb.lottie.a.b.a<?, Path> gB;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = gVar;
        this.gB = kVar.da().cn();
        aVar.a(this.gB);
        this.gB.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
        invalidate();
    }

    private void invalidate() {
        this.fZ = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).bN() == ShapeTrimPath.Type.Simultaneously) {
                    this.fT = (r) bVar;
                    this.fT.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path bG() {
        if (this.fZ) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.gB.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.f.a(this.path, this.fT);
        this.fZ = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
