package com.baidu.swan.apps.u.c.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public abstract class b<ValueT> {
    private final ValueT dib;

    protected abstract ValueT a(Bundle bundle, String str, ValueT valuet);

    protected abstract void b(Bundle bundle, String str, ValueT valuet);

    public b() {
        this(null);
    }

    public b(ValueT valuet) {
        this.dib = valuet;
    }

    public ValueT a(c cVar, String str) {
        return a(cVar, str, (String) this.dib);
    }

    public ValueT a(c cVar, String str, ValueT valuet) {
        return a(cVar.azA(), str, (String) valuet);
    }

    public void b(@NonNull final c cVar, final String str, final ValueT valuet) {
        aq azB = cVar.azB();
        if (azB.aOF()) {
            b(cVar.azA(), str, (String) valuet);
            azB.aOG();
            return;
        }
        azB.k(new Runnable() { // from class: com.baidu.swan.apps.u.c.a.b.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.u.c.a.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(cVar.azA(), str, (String) valuet);
            }
        });
    }
}
