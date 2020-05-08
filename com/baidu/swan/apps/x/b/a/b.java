package com.baidu.swan.apps.x.b.a;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public abstract class b<ValueT> {
    private final ValueT bXu;

    protected abstract ValueT a(Bundle bundle, String str, ValueT valuet);

    protected abstract void b(Bundle bundle, String str, ValueT valuet);

    public b() {
        this(null);
    }

    public b(ValueT valuet) {
        this.bXu = valuet;
    }

    public ValueT a(c cVar, String str) {
        return a(cVar, str, (String) this.bXu);
    }

    public ValueT a(c cVar, String str, ValueT valuet) {
        return a(cVar.adX(), str, (String) valuet);
    }

    public void b(c cVar, String str, ValueT valuet) {
        b(cVar.adX(), str, (String) valuet);
    }
}
