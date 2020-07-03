package com.baidu.swan.apps.an;

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
public final class e implements com.baidu.swan.apps.an.b, d {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<c<?>, Set<a>> cNQ = new HashMap();

    /* loaded from: classes11.dex */
    public interface a extends com.baidu.swan.apps.aq.e.b<Set<c<?>>> {
    }

    /* loaded from: classes11.dex */
    private static class b {
        private static final e cNU = new e();
    }

    public static e atW() {
        return b.cNU;
    }

    public e g(com.baidu.swan.apps.an.a aVar) {
        String aVar2 = aVar == null ? "" : aVar.toString();
        if (DEBUG) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        com.baidu.swan.apps.console.c.e("Tracer-ErrCode", aVar2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(c<?>... cVarArr) {
        synchronized (this.cNQ) {
            for (c<?> cVar : cVarArr) {
                if (!this.cNQ.containsKey(cVar)) {
                    this.cNQ.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.cNQ) {
                HashSet keySet = m(cVarArr) ? this.cNQ.keySet() : i.O(cVarArr);
                for (c<?> cVar : keySet) {
                    if (cVar != null) {
                        a(cVar).add(aVar);
                    }
                }
                b(i.O(aVar), keySet);
            }
        }
        return this;
    }

    private Set<a> a(@NonNull c<?> cVar) {
        Set<a> set = this.cNQ.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.cNQ.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.cNQ) {
                for (c<?> cVar : m(cVarArr) ? this.cNQ.keySet() : i.O(cVarArr)) {
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
        return h(i.O(cVarArr));
    }

    protected e h(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.cNQ) {
                for (c<?> cVar : set) {
                    hashSet.addAll(a(cVar));
                }
            }
            b(hashSet, set);
        }
        return this;
    }

    private e b(final Set<a> set, final Set<c<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.swan.apps.an.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : set) {
                    aVar.H(set2);
                }
            }
        });
        return this;
    }
}
