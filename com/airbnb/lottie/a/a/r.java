package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class r implements b, a.InterfaceC0010a {
    private final ShapeTrimPath.Type CG;
    private final com.airbnb.lottie.a.b.a<?, Float> CH;
    private final com.airbnb.lottie.a.b.a<?, Float> CI;
    private final com.airbnb.lottie.a.b.a<?, Float> CJ;
    private final List<a.InterfaceC0010a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.CG = shapeTrimPath.hA();
        this.CH = shapeTrimPath.iR().ia();
        this.CI = shapeTrimPath.iQ().ia();
        this.CJ = shapeTrimPath.iK().ia();
        aVar.a(this.CH);
        aVar.a(this.CI);
        aVar.a(this.CJ);
        this.CH.b(this);
        this.CI.b(this);
        this.CJ.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void hq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
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
    public ShapeTrimPath.Type hA() {
        return this.CG;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hB() {
        return this.CH;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hC() {
        return this.CI;
    }

    public com.airbnb.lottie.a.b.a<?, Float> hD() {
        return this.CJ;
    }
}
