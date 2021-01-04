package com.baidu.live.lottie.a.a;

import com.baidu.live.lottie.a.b.a;
import com.baidu.live.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class r implements b, a.InterfaceC0194a {
    private final ShapeTrimPath.Type buc;
    private final com.baidu.live.lottie.a.b.a<?, Float> bud;
    private final com.baidu.live.lottie.a.b.a<?, Float> bue;
    private final com.baidu.live.lottie.a.b.a<?, Float> bug;
    private final List<a.InterfaceC0194a> listeners = new ArrayList();
    private final String name;

    public r(com.baidu.live.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.buc = shapeTrimPath.PF();
        this.bud = shapeTrimPath.Qy().PP();
        this.bue = shapeTrimPath.Qx().PP();
        this.bug = shapeTrimPath.Qt().PP();
        aVar.a(this.bud);
        aVar.a(this.bue);
        aVar.a(this.bug);
        this.bud.b(this);
        this.bue.b(this);
        this.bug.b(this);
    }

    @Override // com.baidu.live.lottie.a.b.a.InterfaceC0194a
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
    public void a(a.InterfaceC0194a interfaceC0194a) {
        this.listeners.add(interfaceC0194a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type PF() {
        return this.buc;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> PG() {
        return this.bud;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> PH() {
        return this.bue;
    }

    public com.baidu.live.lottie.a.b.a<?, Float> PI() {
        return this.bug;
    }
}
