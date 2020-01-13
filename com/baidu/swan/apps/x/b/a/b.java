package com.baidu.swan.apps.x.b.a;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class b<ValueT> {
    private final ValueT buM;

    protected abstract ValueT a(Bundle bundle, String str, ValueT valuet);

    protected abstract void b(Bundle bundle, String str, ValueT valuet);

    public b() {
        this(null);
    }

    public b(ValueT valuet) {
        this.buM = valuet;
    }

    public ValueT a(c cVar, String str) {
        return a(cVar, str, (String) this.buM);
    }

    public ValueT a(c cVar, String str, ValueT valuet) {
        return a(cVar.TQ(), str, (String) valuet);
    }

    public void b(c cVar, String str, ValueT valuet) {
        b(cVar.TQ(), str, (String) valuet);
    }
}
