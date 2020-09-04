package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> cqf = new HashSet();
    private final Map<String, a<Boolean>> cqg = new HashMap();
    private final Map<String, a<b>> cqh = new HashMap();
    private a<Exception> cqi = new a<>();

    public d q(String... strArr) {
        this.cqf.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.cqg, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cqi.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        q(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> alF() {
        return new HashSet<>(this.cqf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.cqh, str).R(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, boolean z) {
        a b2 = b(this.cqg, str);
        b2.R(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.cqi.R(exc);
        this.cqi.clear();
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
        private Set<com.baidu.swan.apps.ap.e.b<T>> cqj = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.cqj.add(bVar);
            }
        }

        public void clear() {
            this.cqj.clear();
        }

        public void R(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.cqj) {
                bVar.I(t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final long cqk;
        public final double cql;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.cqk = j2;
            if (j2 == 0) {
                this.cql = 0.0d;
            } else {
                this.cql = j / j2;
            }
        }

        public boolean valid() {
            return this.cqk > 0;
        }
    }
}
