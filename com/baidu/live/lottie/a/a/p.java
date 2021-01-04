package com.baidu.live.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes10.dex */
public class p implements l, a.InterfaceC0194a {
    private boolean DM;
    @Nullable
    private r btF;
    private final com.baidu.live.lottie.a.b.a<?, Path> bub;
    private final com.baidu.live.lottie.h lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public p(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar, com.baidu.live.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = hVar;
        this.bub = kVar.Qw().PP();
        aVar.a(this.bub);
        this.bub.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
    public void is() {
        invalidate();
    }

    private void invalidate() {
        this.DM = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).PF() == ShapeTrimPath.Type.Simultaneously) {
                    this.btF = (r) bVar;
                    this.btF.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.l
    public Path iv() {
        if (this.DM) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.bub.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.baidu.live.lottie.d.f.a(this.path, this.btF);
        this.DM = true;
        return this.path;
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
