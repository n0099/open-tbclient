package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0007a {
    private final List<a.InterfaceC0007a> mQ = new ArrayList();
    private final ShapeTrimPath.Type mR;
    private final com.airbnb.lottie.a.b.a<?, Float> mS;
    private final com.airbnb.lottie.a.b.a<?, Float> mT;
    private final com.airbnb.lottie.a.b.a<?, Float> mU;
    private String name;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mR = shapeTrimPath.cf();
        this.mS = shapeTrimPath.dy().cz();
        this.mT = shapeTrimPath.dx().cz();
        this.mU = shapeTrimPath.dr().cz();
        aVar.a(this.mS);
        aVar.a(this.mT);
        aVar.a(this.mU);
        this.mS.b(this);
        this.mT.b(this);
        this.mU.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mQ.size()) {
                this.mQ.get(i2).bW();
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
    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.mQ.add(interfaceC0007a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type cf() {
        return this.mR;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cg() {
        return this.mS;
    }

    public com.airbnb.lottie.a.b.a<?, Float> ch() {
        return this.mT;
    }

    public com.airbnb.lottie.a.b.a<?, Float> ci() {
        return this.mU;
    }
}
