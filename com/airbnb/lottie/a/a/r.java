package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class r implements b, a.InterfaceC0007a {
    private final ShapeTrimPath.Type En;
    private final com.airbnb.lottie.a.b.a<?, Float> Eo;
    private final com.airbnb.lottie.a.b.a<?, Float> Ep;
    private final com.airbnb.lottie.a.b.a<?, Float> Eq;
    private final List<a.InterfaceC0007a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.En = shapeTrimPath.iB();
        this.Eo = shapeTrimPath.jQ().jb();
        this.Ep = shapeTrimPath.jP().jb();
        this.Eq = shapeTrimPath.jJ().jb();
        aVar.a(this.Eo);
        aVar.a(this.Ep);
        aVar.a(this.Eq);
        this.Eo.b(this);
        this.Ep.b(this);
        this.Eq.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void ir() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ir();
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
    public ShapeTrimPath.Type iB() {
        return this.En;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iC() {
        return this.Eo;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iD() {
        return this.Ep;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iE() {
        return this.Eq;
    }
}
