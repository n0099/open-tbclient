package com.baidu.live.lottie.a.a;

import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class r implements b, a.InterfaceC0185a {
    private final ShapeTrimPath.Type bpp;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpq;
    private final com.baidu.live.lottie.a.b.a<?, Float> bpr;
    private final com.baidu.live.lottie.a.b.a<?, Float> bps;
    private final List<a.InterfaceC0185a> listeners = new ArrayList();
    private final String name;

    public r(com.baidu.live.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.bpp = shapeTrimPath.LK();
        this.bpq = shapeTrimPath.MD().LU();
        this.bpr = shapeTrimPath.MC().LU();
        this.bps = shapeTrimPath.My().LU();
        aVar.a(this.bpq);
        aVar.a(this.bpr);
        aVar.a(this.bps);
        this.bpq.b(this);
        this.bpr.b(this);
        this.bps.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0185a
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

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0185a interfaceC0185a) {
        this.listeners.add(interfaceC0185a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type LK() {
        return this.bpp;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> LL() {
        return this.bpq;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> LM() {
        return this.bpr;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> LN() {
        return this.bps;
    }
}
