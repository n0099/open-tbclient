package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> cEt = new HashSet();
    private final Map<String, a<Boolean>> cEu = new HashMap();
    private final Map<String, a<b>> cEv = new HashMap();
    private a<Exception> cEw = new a<>();

    public d r(String... strArr) {
        this.cEt.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.cEu, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cEw.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        r(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> apa() {
        return new HashSet<>(this.cEt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.cEv, str).V(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(String str, boolean z) {
        a b2 = b(this.cEu, str);
        b2.V(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.cEw.V(exc);
        this.cEw.clear();
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
        private Set<com.baidu.swan.apps.ap.e.b<T>> cEx = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.cEx.add(bVar);
            }
        }

        public void clear() {
            this.cEx.clear();
        }

        public void V(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.cEx) {
                bVar.M(t);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final long cEy;
        public final double cEz;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.cEy = j2;
            if (j2 == 0) {
                this.cEz = 0.0d;
            } else {
                this.cEz = j / j2;
            }
        }

        public boolean valid() {
            return this.cEy > 0;
        }
    }
}
