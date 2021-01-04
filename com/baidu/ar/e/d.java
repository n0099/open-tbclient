package com.baidu.ar.e;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements c {
    private List<a<?, ?>> tL = new ArrayList();

    public d(a aVar) {
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r2) {
        aVar.h(r2);
        return new d(aVar);
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        for (a<?, ?> aVar : this.tL) {
            aVar.cancel();
        }
    }

    @Override // com.baidu.ar.e.c
    public c d(a<?, ?> aVar) {
        if (!this.tL.isEmpty()) {
            this.tL.get(this.tL.size() - 1).a(aVar);
        }
        this.tL.add(aVar);
        return this;
    }
}
