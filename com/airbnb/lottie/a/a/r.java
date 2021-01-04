package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class r implements b, a.InterfaceC0007a {
    private final ShapeTrimPath.Type Ep;
    private final com.airbnb.lottie.a.b.a<?, Float> Eq;
    private final com.airbnb.lottie.a.b.a<?, Float> Er;
    private final com.airbnb.lottie.a.b.a<?, Float> Es;
    private final List<a.InterfaceC0007a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.Ep = shapeTrimPath.iC();
        this.Eq = shapeTrimPath.jR().jc();
        this.Er = shapeTrimPath.jQ().jc();
        this.Es = shapeTrimPath.jK().jc();
        aVar.a(this.Eq);
        aVar.a(this.Er);
        aVar.a(this.Es);
        this.Eq.b(this);
        this.Er.b(this);
        this.Es.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void is() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).is();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
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
    public ShapeTrimPath.Type iC() {
        return this.Ep;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iD() {
        return this.Eq;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iE() {
        return this.Er;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iF() {
        return this.Es;
    }
}
