package com.baidu.swan.apps.ap;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public final class e implements com.baidu.swan.apps.ap.b, d {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<c<?>, Set<a>> cxb = new HashMap();

    /* loaded from: classes11.dex */
    public interface a extends com.baidu.swan.apps.as.d.b<Set<c<?>>> {
    }

    /* loaded from: classes11.dex */
    private static class b {
        private static final e cxf = new e();
    }

    public static e aov() {
        return b.cxf;
    }

    public e f(com.baidu.swan.apps.ap.a aVar) {
        String aVar2 = aVar.toString();
        if (DEBUG) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        com.baidu.swan.apps.console.c.e("Tracer-ErrCode", aVar2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(c<?>... cVarArr) {
        synchronized (this.cxb) {
            for (c<?> cVar : cVarArr) {
                if (!this.cxb.containsKey(cVar)) {
                    this.cxb.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.cxb) {
                HashSet keySet = m(cVarArr) ? this.cxb.keySet() : i.N(cVarArr);
                for (c<?> cVar : keySet) {
                    if (cVar != null) {
                        a(cVar).add(aVar);
                    }
                }
                b(i.N(aVar), keySet);
            }
        }
        return this;
    }

    private Set<a> a(@NonNull c<?> cVar) {
        Set<a> set = this.cxb.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.cxb.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.cxb) {
                for (c<?> cVar : m(cVarArr) ? this.cxb.keySet() : i.N(cVarArr)) {
                    if (cVar != null) {
                        a(cVar).remove(aVar);
                    }
                }
            }
        }
        return this;
    }

    private <T> boolean m(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b(c<?>... cVarArr) {
        return h(i.N(cVarArr));
    }

    protected e h(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.cxb) {
                for (c<?> cVar : set) {
                    hashSet.addAll(a(cVar));
                }
            }
            b(hashSet, set);
        }
        return this;
    }

    private e b(final Set<a> set, final Set<c<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.swan.apps.ap.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : set) {
                    aVar.F(set2);
                }
            }
        });
        return this;
    }
}
