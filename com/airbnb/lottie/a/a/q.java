package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0007a {
    private String name;
    private final List<a.InterfaceC0007a> pr = new ArrayList();
    private final ShapeTrimPath.Type pu;
    private final com.airbnb.lottie.a.b.a<?, Float> pv;
    private final com.airbnb.lottie.a.b.a<?, Float> pw;
    private final com.airbnb.lottie.a.b.a<?, Float> px;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pu = shapeTrimPath.dl();
        this.pv = shapeTrimPath.eE().dF();
        this.pw = shapeTrimPath.eD().dF();
        this.px = shapeTrimPath.ex().dF();
        aVar.a(this.pv);
        aVar.a(this.pw);
        aVar.a(this.px);
        this.pv.b(this);
        this.pw.b(this);
        this.px.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0007a
    public void dc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.pr.size()) {
                this.pr.get(i2).dc();
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
        this.pr.add(interfaceC0007a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dl() {
        return this.pu;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dm() {
        return this.pv;
    }

    public com.airbnb.lottie.a.b.a<?, Float> dn() {
        return this.pw;
    }

    /* renamed from: do  reason: not valid java name */
    public com.airbnb.lottie.a.b.a<?, Float> m6do() {
        return this.px;
    }
}
