package com.baidu.ar.e;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class d implements c {
    private List<a<?, ?>> sY = new ArrayList();

    public d(a aVar) {
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r2) {
        aVar.h(r2);
        return new d(aVar);
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        for (a<?, ?> aVar : this.sY) {
            aVar.cancel();
        }
    }

    @Override // com.baidu.ar.e.c
    public c d(a<?, ?> aVar) {
        if (!this.sY.isEmpty()) {
            this.sY.get(this.sY.size() - 1).a(aVar);
        }
        this.sY.add(aVar);
        return this;
    }
}
