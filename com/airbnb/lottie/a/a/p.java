package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class p implements l, a.InterfaceC0011a {
    @Nullable
    private r CY;
    private final com.airbnb.lottie.a.b.a<?, Path> DH;
    private boolean De;
    private final com.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = gVar;
        this.DH = kVar.kq().jD();
        aVar.a(this.DH);
        this.DH.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        invalidate();
    }

    private void invalidate() {
        this.De = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).jd() == ShapeTrimPath.Type.Simultaneously) {
                    this.CY = (r) bVar;
                    this.CY.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iW() {
        if (this.De) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.DH.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.f.a(this.path, this.CY);
        this.De = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
