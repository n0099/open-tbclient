package com.baidu.live.lottie.a.a;

import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class r implements b, a.InterfaceC0192a {
    private final ShapeTrimPath.Type bus;
    private final com.baidu.live.lottie.a.b.a<?, Float> but;
    private final com.baidu.live.lottie.a.b.a<?, Float> buu;
    private final com.baidu.live.lottie.a.b.a<?, Float> buv;
    private final List<a.InterfaceC0192a> listeners = new ArrayList();
    private final String name;

    public r(com.baidu.live.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.bus = shapeTrimPath.Nl();
        this.but = shapeTrimPath.Oe().Nv();
        this.buu = shapeTrimPath.Od().Nv();
        this.buv = shapeTrimPath.NZ().Nv();
        aVar.a(this.but);
        aVar.a(this.buu);
        aVar.a(this.buv);
        this.but.b(this);
        this.buu.b(this);
        this.buv.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0192a
    public void ir() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ir();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.live.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0192a interfaceC0192a) {
        this.listeners.add(interfaceC0192a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type Nl() {
        return this.bus;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> Nm() {
        return this.but;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> Nn() {
        return this.buu;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> No() {
        return this.buv;
    }
}
