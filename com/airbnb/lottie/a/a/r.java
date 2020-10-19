package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class r implements b, a.InterfaceC0011a {
    private final ShapeTrimPath.Type DI;
    private final com.airbnb.lottie.a.b.a<?, Float> DJ;
    private final com.airbnb.lottie.a.b.a<?, Float> DK;
    private final com.airbnb.lottie.a.b.a<?, Float> DM;
    private final List<a.InterfaceC0011a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.DI = shapeTrimPath.jd();
        this.DJ = shapeTrimPath.ks().jD();
        this.DK = shapeTrimPath.kr().jD();
        this.DM = shapeTrimPath.kl().jD();
        aVar.a(this.DJ);
        aVar.a(this.DK);
        aVar.a(this.DM);
        this.DJ.b(this);
        this.DK.b(this);
        this.DM.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0011a
    public void iT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
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
    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.listeners.add(interfaceC0011a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type jd() {
        return this.DI;
    }

    public com.airbnb.lottie.a.b.a<?, Float> je() {
        return this.DJ;
    }

    public com.airbnb.lottie.a.b.a<?, Float> jf() {
        return this.DK;
    }

    public com.airbnb.lottie.a.b.a<?, Float> jg() {
        return this.DM;
    }
}
