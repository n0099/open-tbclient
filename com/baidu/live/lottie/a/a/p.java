package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class p implements l, a.InterfaceC0186a {
    private boolean DJ;
    private final com.baidu.live.lottie.a.b.a<?, Path> bsP;
    @Nullable
    private r bst;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = hVar;
        this.bsP = kVar.NZ().Ns();
        aVar.a(this.bsP);
        this.bsP.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
    public void ir() {
        invalidate();
    }

    private void invalidate() {
        this.DJ = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).Ni() == ShapeTrimPath.Type.Simultaneously) {
                    this.bst = (r) bVar;
                    this.bst.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iu() {
        if (this.DJ) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.bsP.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.baidu.live.lottie.d.f.a(this.path, this.bst);
        this.DJ = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
