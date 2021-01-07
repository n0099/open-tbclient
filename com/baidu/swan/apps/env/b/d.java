package com.baidu.swan.apps.env.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<String> dcM = new HashSet();
    private final Map<String, a<Boolean>> dcN = new HashMap();
    private final Map<String, a<b>> dcO = new HashMap();
    private a<Exception> dcP = new a<>();

    public d z(String... strArr) {
        this.dcM.addAll(Arrays.asList(strArr));
        return this;
    }

    public d a(String str, com.baidu.swan.apps.ao.e.b<Boolean> bVar) {
        return a(this.dcN, str, bVar);
    }

    public d h(com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.dcP.i(bVar);
        return this;
    }

    private <T> d a(Map<String, a<T>> map, String str, com.baidu.swan.apps.ao.e.b<T> bVar) {
        z(str);
        b(map, str).i(bVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet<String> axp() {
        return new HashSet<>(this.dcM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        if (bVar == null || bVar.valid()) {
            b(this.dcO, str).V(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(String str, boolean z) {
        a b2 = b(this.dcN, str);
        b2.V(Boolean.valueOf(z));
        b2.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Exception exc) {
        this.dcP.V(exc);
        this.dcP.clear();
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
        private Set<com.baidu.swan.apps.ao.e.b<T>> dcQ = new HashSet();

        public void i(com.baidu.swan.apps.ao.e.b<T> bVar) {
            if (bVar != null) {
                this.dcQ.add(bVar);
            }
        }

        public void clear() {
            this.dcQ.clear();
        }

        public void V(T t) {
            for (com.baidu.swan.apps.ao.e.b<T> bVar : this.dcQ) {
                bVar.L(t);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public final long current;
        public final long dcR;
        public final double dcS;

        public b(long j, long j2) {
            this.current = j;
            this.dcR = j2;
            if (j2 == 0) {
                this.dcS = 0.0d;
            } else {
                this.dcS = j / j2;
            }
        }

        public boolean valid() {
            return this.dcR > 0;
        }
    }
}
