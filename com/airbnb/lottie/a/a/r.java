package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class r implements b, a.InterfaceC0010a {
    private final ShapeTrimPath.Type Dp;
    private final com.airbnb.lottie.a.b.a<?, Float> Dq;
    private final com.airbnb.lottie.a.b.a<?, Float> Dr;
    private final com.airbnb.lottie.a.b.a<?, Float> Ds;
    private final List<a.InterfaceC0010a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.Dp = shapeTrimPath.jb();
        this.Dq = shapeTrimPath.kq().jB();
        this.Dr = shapeTrimPath.kp().jB();
        this.Ds = shapeTrimPath.kj().jB();
        aVar.a(this.Dq);
        aVar.a(this.Dr);
        aVar.a(this.Ds);
        this.Dq.b(this);
        this.Dr.b(this);
        this.Ds.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0010a
    public void iR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iR();
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
    public ShapeTrimPath.Type jb() {
        return this.Dp;
    }

    public com.airbnb.lottie.a.b.a<?, Float> jc() {
        return this.Dq;
    }

    public com.airbnb.lottie.a.b.a<?, Float> jd() {
        return this.Dr;
    }

    public com.airbnb.lottie.a.b.a<?, Float> je() {
        return this.Ds;
    }
}
