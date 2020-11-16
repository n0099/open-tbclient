package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> cQY = new HashSet();
    private final Map<String, a<Boolean>> cQZ = new HashMap();
    private final Map<String, a<b>> cRa = new HashMap();
    private a<Exception> cRb = new a<>();

    public d s(String... strArr) {
        this.cQY.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.cQZ, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cRb.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        s(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> asO() {
        return new HashSet<>(this.cQY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.cRa, str).V(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(String str, boolean z) {
        a b2 = b(this.cQZ, str);
        b2.V(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.cRb.V(exc);
        this.cRb.clear();
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

    /* loaded from: classes7.dex */
    public static class a<T> {
        private Set<com.baidu.swan.apps.ap.e.b<T>> cRc = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.cRc.add(bVar);
            }
        }

        public void clear() {
            this.cRc.clear();
        }

        public void V(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.cRc) {
                bVar.M(t);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public final long cRd;
        public final double cRe;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.cRd = j2;
            if (j2 == 0) {
                this.cRe = 0.0d;
            } else {
                this.cRe = j / j2;
            }
        }

        public boolean valid() {
            return this.cRd > 0;
        }
    }
}
