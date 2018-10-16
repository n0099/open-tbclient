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
    private final List<a.InterfaceC0009a> px = new ArrayList();
    private final ShapeTrimPath.Type py;
    private final com.airbnb.lottie.a.b.a<?, Float> pz;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.py = shapeTrimPath.dn();
        this.pz = shapeTrimPath.eG().dH();
        this.pA = shapeTrimPath.eF().dH();
        this.pB = shapeTrimPath.ez().dH();
        aVar.a(this.pz);
        aVar.a(this.pA);
        aVar.a(this.pB);
        this.pz.b(this);
        this.pA.b(this);
        this.pB.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0009a
    public void de() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.px.size()) {
                this.px.get(i2).de();
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
        this.px.add(interfaceC0009a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dn() {
        return this.py;
    }

    /* renamed from: do  reason: not valid java name */
    public com.airbnb.lottie.a.b.a<?, Float> m6do() {
        return this.pz;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dp() {
        return this.pA;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dq() {
        return this.pB;
    }
}
