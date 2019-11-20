package com.baidu.swan.apps.ak;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.facebook.common.internal.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class e implements com.baidu.swan.apps.ak.b, d {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<c<?>, Set<a>> bsk = new HashMap();

    /* loaded from: classes2.dex */
    public interface a extends com.baidu.swan.apps.an.d.a<Set<c<?>>> {
    }

    /* loaded from: classes2.dex */
    private static class b {
        private static final e bso = new e();
    }

    public static e TR() {
        return b.bso;
    }

    public e b(com.baidu.swan.apps.ak.a aVar) {
        String aVar2 = aVar.toString();
        if (DEBUG) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        com.baidu.swan.apps.console.c.e("Tracer-ErrCode", aVar2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(c<?>... cVarArr) {
        synchronized (this.bsk) {
            for (c<?> cVar : cVarArr) {
                if (!this.bsk.containsKey(cVar)) {
                    this.bsk.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.bsk) {
                HashSet keySet = k(cVarArr) ? this.bsk.keySet() : h.J(cVarArr);
                for (c<?> cVar : keySet) {
                    if (cVar != null) {
                        a(cVar).add(aVar);
                    }
                }
                b(h.J(aVar), keySet);
            }
        }
        return this;
    }

    private Set<a> a(@NonNull c<?> cVar) {
        Set<a> set = this.bsk.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.bsk.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.bsk) {
                for (c<?> cVar : k(cVarArr) ? this.bsk.keySet() : h.J(cVarArr)) {
                    if (cVar != null) {
                        a(cVar).remove(aVar);
                    }
                }
            }
        }
        return this;
    }

    private <T> boolean k(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b(c<?>... cVarArr) {
        return e(h.J(cVarArr));
    }

    protected e e(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.bsk) {
                for (c<?> cVar : set) {
                    hashSet.addAll(a(cVar));
                }
            }
            b(hashSet, set);
        }
        return this;
    }

    private e b(final Set<a> set, final Set<c<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.swan.apps.ak.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : set) {
                    aVar.B(set2);
                }
            }
        });
        return this;
    }
}
