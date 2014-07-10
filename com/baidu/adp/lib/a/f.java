package com.baidu.adp.lib.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f a = null;
    private HashMap<String, e> b;

    private f() {
        this.b = null;
        this.b = new HashMap<>();
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public void a(c cVar) {
        if (cVar != null && !this.b.containsKey(cVar.a())) {
            this.b.put(cVar.a(), new e(cVar));
        }
    }

    public void a(String str) {
        Iterator<e> it = this.b.values().iterator();
        while (it.hasNext() && !it.next().a(str)) {
        }
    }

    public boolean a(String str, int i) {
        e eVar;
        if (i >= 0 && (eVar = this.b.get(str)) != null) {
            return eVar.a(i);
        }
        return false;
    }

    public int b(String str) {
        e eVar = this.b.get(str);
        if (eVar != null) {
            return eVar.b();
        }
        return -1;
    }

    public void b() {
        for (e eVar : this.b.values()) {
            eVar.c();
        }
    }

    public void a(Class<?> cls) {
        try {
            cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public void a(HashMap<String, Integer> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                a(entry.getKey(), entry.getValue().intValue());
            }
        }
    }
}
