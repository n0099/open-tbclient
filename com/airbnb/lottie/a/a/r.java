package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0010a {
    private final ShapeTrimPath.Type gC;
    private final com.airbnb.lottie.a.b.a<?, Float> gD;
    private final com.airbnb.lottie.a.b.a<?, Float> gE;
    private final com.airbnb.lottie.a.b.a<?, Float> gF;
    private final List<a.InterfaceC0010a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.gC = shapeTrimPath.bN();
        this.gD = shapeTrimPath.dc().cn();
        this.gE = shapeTrimPath.db().cn();
        this.gF = shapeTrimPath.cV().cn();
        aVar.a(this.gD);
        aVar.a(this.gE);
        aVar.a(this.gF);
        this.gD.b(this);
        this.gE.b(this);
        this.gF.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bD();
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
    public ShapeTrimPath.Type bN() {
        return this.gC;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bO() {
        return this.gD;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bP() {
        return this.gE;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bQ() {
        return this.gF;
    }
}
