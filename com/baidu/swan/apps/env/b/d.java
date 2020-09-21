package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> csi = new HashSet();
    private final Map<String, a<Boolean>> csj = new HashMap();
    private final Map<String, a<b>> csk = new HashMap();
    private a<Exception> csl = new a<>();

    public d q(String... strArr) {
        this.csi.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.csj, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.csl.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        q(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> amp() {
        return new HashSet<>(this.csi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.csk, str).S(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, boolean z) {
        a b2 = b(this.csj, str);
        b2.S(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.csl.S(exc);
        this.csl.clear();
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

    /* loaded from: classes3.dex */
    public static class a<T> {
        private Set<com.baidu.swan.apps.ap.e.b<T>> csm = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.csm.add(bVar);
            }
        }

        public void clear() {
            this.csm.clear();
        }

        public void S(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.csm) {
                bVar.J(t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public final long csn;
        public final double cso;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.csn = j2;
            if (j2 == 0) {
                this.cso = 0.0d;
            } else {
                this.cso = j / j2;
            }
        }

        public boolean valid() {
            return this.csn > 0;
        }
    }
}
