package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0009a {
    private String name;
    private final com.airbnb.lottie.a.b.a<?, Float> pA;
    private final com.airbnb.lottie.a.b.a<?, Float> pB;
    private final com.airbnb.lottie.a.b.a<?, Float> pC;
    private final List<a.InterfaceC0009a> py = new ArrayList();
    private final ShapeTrimPath.Type pz;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pz = shapeTrimPath.dm();
        this.pA = shapeTrimPath.eF().dG();
        this.pB = shapeTrimPath.eE().dG();
        this.pC = shapeTrimPath.ey().dG();
        aVar.a(this.pA);
        aVar.a(this.pB);
        aVar.a(this.pC);
        this.pA.b(this);
        this.pB.b(this);
        this.pC.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void dd() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.py.size()) {
                this.py.get(i2).dd();
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
    public void a(a.InterfaceC0009a interfaceC0009a) {
        this.py.add(interfaceC0009a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dm() {
        return this.pz;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dn() {
        return this.pA;
    }

    /* renamed from: do  reason: not valid java name */
    public com.airbnb.lottie.a.b.a<?, Float> m6do() {
        return this.pB;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dp() {
        return this.pC;
    }
}
