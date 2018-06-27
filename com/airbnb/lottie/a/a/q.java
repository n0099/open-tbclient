package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0006a {
    private final List<a.InterfaceC0006a> ml = new ArrayList();
    private final ShapeTrimPath.Type mm;
    private final com.airbnb.lottie.a.b.a<?, Float> mn;
    private final com.airbnb.lottie.a.b.a<?, Float> mo;
    private final com.airbnb.lottie.a.b.a<?, Float> mp;
    private String name;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mm = shapeTrimPath.bQ();
        this.mn = shapeTrimPath.dj().ck();
        this.mo = shapeTrimPath.di().ck();
        this.mp = shapeTrimPath.dc().ck();
        aVar.a(this.mn);
        aVar.a(this.mo);
        aVar.a(this.mp);
        this.mn.b(this);
        this.mo.b(this);
        this.mp.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ml.size()) {
                this.ml.get(i2).bH();
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
    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.ml.add(interfaceC0006a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type bQ() {
        return this.mm;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bR() {
        return this.mn;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bS() {
        return this.mo;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bT() {
        return this.mp;
    }
}
