package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0007a {
    private final ShapeTrimPath.Type eM;
    private final com.airbnb.lottie.a.b.a<?, Float> eN;
    private final com.airbnb.lottie.a.b.a<?, Float> eO;
    private final com.airbnb.lottie.a.b.a<?, Float> eP;
    private final List<a.InterfaceC0007a> listeners = new ArrayList();
    private String name;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.eM = shapeTrimPath.bD();
        this.eN = shapeTrimPath.cY().bY();
        this.eO = shapeTrimPath.cX().bY();
        this.eP = shapeTrimPath.cR().bY();
        aVar.a(this.eN);
        aVar.a(this.eO);
        aVar.a(this.eP);
        this.eN.b(this);
        this.eO.b(this);
        this.eP.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void bt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bt();
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
        this.listeners.add(interfaceC0007a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type bD() {
        return this.eM;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bE() {
        return this.eN;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bF() {
        return this.eO;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bG() {
        return this.eP;
    }
}
