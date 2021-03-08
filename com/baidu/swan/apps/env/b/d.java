package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> dbK = new HashSet();
    private final Map<String, a<Boolean>> dbL = new HashMap();
    private final Map<String, a<b>> dbM = new HashMap();
    private a<Exception> dbN = new a<>();

    public d z(String... strArr) {
        this.dbK.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ao.e.b<Boolean> bVar) {
        return a(this.dbL, str, bVar);
    }

    public d h(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.dbN.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ao.e.b<T> bVar) {
        z(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> atW() {
        return new HashSet<>(this.dbK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.dbM, str).X(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(String str, boolean z) {
        a b2 = b(this.dbL, str);
        b2.X(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Exception exc) {
        this.dbN.X(exc);
        this.dbN.clear();
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

    /* loaded from: classes8.dex */
    public static class a<T> {
        private Set<com.baidu.swan.apps.ao.e.b<T>> dbO = new HashSet();

        public void i(com.baidu.swan.apps.ao.e.b<T> bVar) {
            if (bVar != null) {
                this.dbO.add(bVar);
            }
        }

        public void clear() {
            this.dbO.clear();
        }

        public void X(T t) {
            for (com.baidu.swan.apps.ao.e.b<T> bVar : this.dbO) {
                bVar.N(t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final long current;
        public final long dbP;
        public final double dbQ;

        public b(long j, long j2) {
            this.current = j;
            this.dbP = j2;
            if (j2 == 0) {
                this.dbQ = 0.0d;
            } else {
                this.dbQ = j / j2;
            }
        }

        public boolean valid() {
            return this.dbP > 0;
        }
    }
}
