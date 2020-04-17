package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0010a {
    private final ShapeTrimPath.Type Cd;
    private final com.airbnb.lottie.a.b.a<?, Float> Ce;
    private final com.airbnb.lottie.a.b.a<?, Float> Cf;
    private final com.airbnb.lottie.a.b.a<?, Float> Cg;
    private final List<a.InterfaceC0010a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.Cd = shapeTrimPath.hk();
        this.Ce = shapeTrimPath.iB().hK();
        this.Cf = shapeTrimPath.iA().hK();
        this.Cg = shapeTrimPath.iu().hK();
        aVar.a(this.Ce);
        aVar.a(this.Cf);
        aVar.a(this.Cg);
        this.Ce.b(this);
        this.Cf.b(this);
        this.Cg.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void ha() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ha();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.listeners.add(interfaceC0010a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type hk() {
        return this.Cd;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hl() {
        return this.Ce;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hm() {
        return this.Cf;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hn() {
        return this.Cg;
    }
}
