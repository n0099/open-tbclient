package com.airbnb.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes3.dex */
public class p implements l, a.InterfaceC0007a {
    private final com.airbnb.lottie.f BH;
    @Nullable
    private r DC;
    private boolean DJ;
    private final com.airbnb.lottie.a.b.a<?, Path> Em;
    private final String name;
    private final Path path = new Path();

    public p(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.BH = fVar;
        this.Em = kVar.jP().jc();
        aVar.a(this.Em);
        this.Em.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        invalidate();
    }

    private void invalidate() {
        this.DJ = false;
        this.BH.invalidateSelf();
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).iC() == ShapeTrimPath.Type.Simultaneously) {
                    this.DC = (r) bVar;
                    this.DC.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.l
    public Path iv() {
        if (this.DJ) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.Em.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.d.f.a(this.path, this.DC);
        this.DJ = true;
        return this.path;
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
