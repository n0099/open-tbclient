package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> dah = new HashSet();
    private final Map<String, a<Boolean>> dai = new HashMap();
    private final Map<String, a<b>> daj = new HashMap();
    private a<Exception> dak = new a<>();

    public d z(String... strArr) {
        this.dah.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ao.e.b<Boolean> bVar) {
        return a(this.dai, str, bVar);
    }

    public d h(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.dak.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ao.e.b<T> bVar) {
        z(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> atT() {
        return new HashSet<>(this.dah);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.daj, str).V(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(String str, boolean z) {
        a b2 = b(this.dai, str);
        b2.V(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Exception exc) {
        this.dak.V(exc);
        this.dak.clear();
    }

    private static <T> a<T> b(Map<String, a<T>> map, String str) {
        a<T> aVar = map.get(str);
        if (aVar == null) {
            a<T> aVar2 = new a<>();
            map.put(str, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* loaded from: classes9.dex */
    public static class a<T> {
        private Set<com.baidu.swan.apps.ao.e.b<T>> dal = new HashSet();

        public void i(com.baidu.swan.apps.ao.e.b<T> bVar) {
            if (bVar != null) {
                this.dal.add(bVar);
            }
        }

        public void clear() {
            this.dal.clear();
        }

        public void V(T t) {
            for (com.baidu.swan.apps.ao.e.b<T> bVar : this.dal) {
                bVar.L(t);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public final long current;
        public final long dam;
        public final double dan;

        public b(long j, long j2) {
            this.current = j;
            this.dam = j2;
            if (j2 == 0) {
                this.dan = 0.0d;
            } else {
                this.dan = j / j2;
            }
        }

        public boolean valid() {
            return this.dam > 0;
        }
    }
}
