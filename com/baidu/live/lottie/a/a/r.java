package com.baidu.live.lottie.a.a;

import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class r implements b, a.InterfaceC0186a {
    private final ShapeTrimPath.Type bsQ;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsR;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsS;
    private final com.baidu.live.lottie.a.b.a<?, Float> bsT;
    private final List<a.InterfaceC0186a> listeners = new ArrayList();
    private final String name;

    public r(com.baidu.live.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.bsQ = shapeTrimPath.Ni();
        this.bsR = shapeTrimPath.Ob().Ns();
        this.bsS = shapeTrimPath.Oa().Ns();
        this.bsT = shapeTrimPath.NW().Ns();
        aVar.a(this.bsR);
        aVar.a(this.bsS);
        aVar.a(this.bsT);
        this.bsR.b(this);
        this.bsS.b(this);
        this.bsT.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0186a
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

    @Override // com.baidu.live.lottie.a.a.b
    public void c(List<b> list, List<b> list2) {
    }

    @Override // com.baidu.live.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.listeners.add(interfaceC0186a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type Ni() {
        return this.bsQ;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> Nj() {
        return this.bsR;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> Nk() {
        return this.bsS;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> Nl() {
        return this.bsT;
    }
}
