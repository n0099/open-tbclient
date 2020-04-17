package com.baidu.ar.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements c {
    private List<a<?, ?>> rU = new ArrayList();

    public d(a aVar) {
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r2) {
        aVar.b((a<InT, OutT>) r2);
        return new d(aVar);
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        for (a<?, ?> aVar : this.rU) {
            aVar.cancel();
        }
    }

    @Override // com.baidu.ar.d.c
    public c d(a<?, ?> aVar) {
        if (!this.rU.isEmpty()) {
            this.rU.get(this.rU.size() - 1).a(aVar);
        }
        this.rU.add(aVar);
        return this;
    }
}
