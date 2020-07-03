package com.baidu.ar.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements c {
    private List<a<?, ?>> st = new ArrayList();

    public d(a aVar) {
        d(aVar);
    }

    public static <InT, OutT> c b(a<InT, OutT> aVar, InT r2) {
        aVar.b((a<InT, OutT>) r2);
        return new d(aVar);
    }

    @Override // com.baidu.ar.callback.ICancellable
    public void cancel() {
        for (a<?, ?> aVar : this.st) {
            aVar.cancel();
        }
    }

    @Override // com.baidu.ar.d.c
    public c d(a<?, ?> aVar) {
        if (!this.st.isEmpty()) {
            this.st.get(this.st.size() - 1).a(aVar);
        }
        this.st.add(aVar);
        return this;
    }
}
