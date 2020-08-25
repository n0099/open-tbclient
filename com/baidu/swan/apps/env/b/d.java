package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> cqb = new HashSet();
    private final Map<String, a<Boolean>> cqc = new HashMap();
    private final Map<String, a<b>> cqd = new HashMap();
    private a<Exception> cqe = new a<>();

    public d q(String... strArr) {
        this.cqb.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        return a(this.cqc, str, bVar);
    }

    public d h(com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cqe.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ap.e.b<T> bVar) {
        q(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> alF() {
        return new HashSet<>(this.cqb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.cqd, str).R(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, boolean z) {
        a b2 = b(this.cqc, str);
        b2.R(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Exception exc) {
        this.cqe.R(exc);
        this.cqe.clear();
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
        private Set<com.baidu.swan.apps.ap.e.b<T>> cqf = new HashSet();

        public void i(com.baidu.swan.apps.ap.e.b<T> bVar) {
            if (bVar != null) {
                this.cqf.add(bVar);
            }
        }

        public void clear() {
            this.cqf.clear();
        }

        public void R(T t) {
            for (com.baidu.swan.apps.ap.e.b<T> bVar : this.cqf) {
                bVar.I(t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final long cqg;
        public final double cqh;
        public final long current;

        public b(long j, long j2) {
            this.current = j;
            this.cqg = j2;
            if (j2 == 0) {
                this.cqh = 0.0d;
            } else {
                this.cqh = j / j2;
            }
        }

        public boolean valid() {
            return this.cqg > 0;
        }
    }
}
