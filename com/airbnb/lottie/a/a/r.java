package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0010a {
    private final com.airbnb.lottie.a.b.a<?, Float> gA;
    private final com.airbnb.lottie.a.b.a<?, Float> gB;
    private final ShapeTrimPath.Type gy;
    private final com.airbnb.lottie.a.b.a<?, Float> gz;
    private final List<a.InterfaceC0010a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.gy = shapeTrimPath.bM();
        this.gz = shapeTrimPath.db().cm();
        this.gA = shapeTrimPath.da().cm();
        this.gB = shapeTrimPath.cU().cm();
        aVar.a(this.gz);
        aVar.a(this.gA);
        aVar.a(this.gB);
        this.gz.b(this);
        this.gA.b(this);
        this.gB.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void bC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bC();
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
    public ShapeTrimPath.Type bM() {
        return this.gy;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bN() {
        return this.gz;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bO() {
        return this.gA;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bP() {
        return this.gB;
    }
}
