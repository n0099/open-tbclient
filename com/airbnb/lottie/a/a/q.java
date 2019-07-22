package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0007a {
    private final List<a.InterfaceC0007a> mP = new ArrayList();
    private final ShapeTrimPath.Type mQ;
    private final com.airbnb.lottie.a.b.a<?, Float> mR;
    private final com.airbnb.lottie.a.b.a<?, Float> mS;
    private final com.airbnb.lottie.a.b.a<?, Float> mT;
    private String name;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mQ = shapeTrimPath.ck();
        this.mR = shapeTrimPath.dF().cF();
        this.mS = shapeTrimPath.dE().cF();
        this.mT = shapeTrimPath.dy().cF();
        aVar.a(this.mR);
        aVar.a(this.mS);
        aVar.a(this.mT);
        this.mR.b(this);
        this.mS.b(this);
        this.mT.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ca() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mP.size()) {
                this.mP.get(i2).ca();
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
        this.mP.add(interfaceC0007a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type ck() {
        return this.mQ;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cl() {
        return this.mR;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cm() {
        return this.mS;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cn() {
        return this.mT;
    }
}
