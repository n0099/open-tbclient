package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes9.dex */
public class p implements l, a.InterfaceC0192a {
    private boolean Fe;
    @Nullable
    private r btU;
    private final com.baidu.live.lottie.a.b.a<?, Path> bur;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = hVar;
        this.bur = kVar.Oc().Nv();
        aVar.a(this.bur);
        this.bur.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        invalidate();
    }

    private void invalidate() {
        this.Fe = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).Nl() == ShapeTrimPath.Type.Simultaneously) {
                    this.btU = (r) bVar;
                    this.btU.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iu() {
        if (this.Fe) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.bur.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.baidu.live.lottie.d.f.a(this.path, this.btU);
        this.Fe = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
