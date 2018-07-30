package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0006a {
    private final List<a.InterfaceC0006a> mb = new ArrayList();
    private final ShapeTrimPath.Type mc;
    private final com.airbnb.lottie.a.b.a<?, Float> md;
    private final com.airbnb.lottie.a.b.a<?, Float> mf;
    private final com.airbnb.lottie.a.b.a<?, Float> mg;
    private String name;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mc = shapeTrimPath.bO();
        this.md = shapeTrimPath.dh().ci();
        this.mf = shapeTrimPath.dg().ci();
        this.mg = shapeTrimPath.da().ci();
        aVar.a(this.md);
        aVar.a(this.mf);
        aVar.a(this.mg);
        this.md.b(this);
        this.mf.b(this);
        this.mg.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void bF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mb.size()) {
                this.mb.get(i2).bF();
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
        this.mb.add(interfaceC0006a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type bO() {
        return this.mc;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bP() {
        return this.md;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bQ() {
        return this.mf;
    }

    public com.airbnb.lottie.a.b.a<?, Float> bR() {
        return this.mg;
    }
}
