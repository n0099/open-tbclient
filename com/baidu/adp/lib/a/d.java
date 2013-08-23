package com.baidu.adp.lib.a;

import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f351a = null;
    private HashMap b;

    private d() {
        this.b = null;
        this.b = new HashMap();
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f351a == null) {
                f351a = new d();
            }
            dVar = f351a;
        }
        return dVar;
    }

    public void a(a aVar) {
        if (aVar != null && !this.b.containsKey(aVar.a())) {
            this.b.put(aVar.a(), new c(aVar));
        }
    }

    public void a(String str) {
        Iterator it = this.b.values().iterator();
        while (it.hasNext() && !((c) it.next()).a(str)) {
        }
    }

    public boolean a(String str, int i) {
        c cVar;
        if (i >= 0 && (cVar = (c) this.b.get(str)) != null) {
            return cVar.a(i);
        }
        return false;
    }

    public int b(String str) {
        c cVar = (c) this.b.get(str);
        if (cVar != null) {
            return cVar.b();
        }
        return -1;
    }

    public void b() {
        for (c cVar : this.b.values()) {
            cVar.c();
        }
    }
}
