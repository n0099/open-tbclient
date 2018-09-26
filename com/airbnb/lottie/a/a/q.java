package com.airbnb.lottie.a.a;

import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0006a {
    private String name;
    private final List<a.InterfaceC0006a> oF = new ArrayList();
    private final ShapeTrimPath.Type oG;
    private final com.airbnb.lottie.a.b.a<?, Float> oH;
    private final com.airbnb.lottie.a.b.a<?, Float> oI;
    private final com.airbnb.lottie.a.b.a<?, Float> oJ;

    public q(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.oG = shapeTrimPath.cV();
        this.oH = shapeTrimPath.eo().dp();
        this.oI = shapeTrimPath.en().dp();
        this.oJ = shapeTrimPath.eh().dp();
        aVar.a(this.oH);
        aVar.a(this.oI);
        aVar.a(this.oJ);
        this.oH.b(this);
        this.oI.b(this);
        this.oJ.b(this);
    }

    @Override // com.airbnb.lottie.a.b.a.InterfaceC0006a
    public void cM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oF.size()) {
                this.oF.get(i2).cM();
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
        this.oF.add(interfaceC0006a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type cV() {
        return this.oG;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cW() {
        return this.oH;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cX() {
        return this.oI;
    }

    public com.airbnb.lottie.a.b.a<?, Float> cY() {
        return this.oJ;
    }
}
