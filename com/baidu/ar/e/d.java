package com.baidu.ar.e;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements c {
    public List<a<?, ?>> tL = new ArrayList();

    public d(a aVar) {
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r1) {
        aVar.h(r1);
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
            List<a<?, ?>> list = this.tL;
            list.get(list.size() - 1).a(aVar);
        }
        this.tL.add(aVar);
        return this;
    }
}
