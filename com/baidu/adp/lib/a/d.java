package com.baidu.adp.lib.a;

import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class d {
    private static d a = null;
    private HashMap<String, c> b;

    private d() {
        this.b = null;
        this.b = new HashMap<>();
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    public final void a(a aVar) {
        if (aVar != null && !this.b.containsKey(aVar.a())) {
            this.b.put(aVar.a(), new c(aVar));
        }
    }

    public final void a(String str) {
        Iterator<c> it = this.b.values().iterator();
        while (it.hasNext() && !it.next().a(str)) {
        }
    }

    public final boolean a(String str, int i) {
        c cVar;
        if (i >= 0 && (cVar = this.b.get(str)) != null) {
            return cVar.a(i);
        }
        return false;
    }

    public final int b(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            return cVar.a();
        }
        return -1;
    }

    public final void b() {
        for (c cVar : this.b.values()) {
            cVar.b();
        }
    }
}
