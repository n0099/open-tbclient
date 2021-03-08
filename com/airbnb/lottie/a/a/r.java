package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0013a {
    private final ShapeTrimPath.Type FG;
    private final com.airbnb.lottie.a.b.a<?, Float> FH;
    private final com.airbnb.lottie.a.b.a<?, Float> FI;
    private final com.airbnb.lottie.a.b.a<?, Float> FJ;
    private final List<a.InterfaceC0013a> listeners = new ArrayList();
    private final String name;

    public r(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.FG = shapeTrimPath.iB();
        this.FH = shapeTrimPath.jQ().jb();
        this.FI = shapeTrimPath.jP().jb();
        this.FJ = shapeTrimPath.jJ().jb();
        aVar.a(this.FH);
        aVar.a(this.FI);
        aVar.a(this.FJ);
        this.FH.b(this);
        this.FI.b(this);
        this.FJ.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0013a
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
    public void b(List<b> list, List<b> list2) {
    }

    @Override // com.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0013a interfaceC0013a) {
        this.listeners.add(interfaceC0013a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type iB() {
        return this.FG;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iC() {
        return this.FH;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iD() {
        return this.FI;
    }

    public com.airbnb.lottie.a.b.a<?, Float> iE() {
        return this.FJ;
    }
}
