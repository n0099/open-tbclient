package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> cMP = new HashSet();
    private final Map<String, a<Boolean>> cMQ = new HashMap();
    private final Map<String, a<b>> cMR = new HashMap();
    private a<Exception> cMS = new a<>();

    public d s(String... strArr) {
        this.cMP.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.cMQ, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cMS.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        s(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> aqV() {
        return new HashSet<>(this.cMP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.cMR, str).V(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(String str, boolean z) {
        a b2 = b(this.cMQ, str);
        b2.V(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.cMS.V(exc);
        this.cMS.clear();
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

    /* loaded from: classes10.dex */
    public static class a<T> {
        private Set<com.baidu.swan.apps.ap.e.b<T>> cMT = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.cMT.add(bVar);
            }
        }

        public void clear() {
            this.cMT.clear();
        }

        public void V(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.cMT) {
                bVar.M(t);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final long cMU;
        public final double cMV;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.cMU = j2;
            if (j2 == 0) {
                this.cMV = 0.0d;
            } else {
                this.cMV = j / j2;
            }
        }

        public boolean valid() {
            return this.cMU > 0;
        }
    }
}
