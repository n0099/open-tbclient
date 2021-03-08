package com.airbnb.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class p implements l, a.InterfaceC0013a {
    private final com.airbnb.lottie.f Df;
    @Nullable
    private r EY;
    private final com.airbnb.lottie.a.b.a<?, Path> FF;
    private boolean Fe;
    private final String name;
    private final Path path = new Path();

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.Df = fVar;
        this.FF = kVar.jO().jb();
        aVar.a(this.FF);
        this.FF.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
    public void ir() {
        invalidate();
    }

    private void invalidate() {
        this.Fe = false;
        this.Df.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).iB() == ShapeTrimPath.Type.Simultaneously) {
                    this.EY = (r) bVar;
                    this.EY.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iu() {
        if (this.Fe) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.FF.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.f.a(this.path, this.EY);
        this.Fe = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
