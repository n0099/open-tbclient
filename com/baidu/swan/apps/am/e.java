package com.baidu.swan.apps.am;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public final class e implements com.baidu.swan.apps.am.b, d {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<c<?>, Set<a>> dxc = new HashMap();

    /* loaded from: classes10.dex */
    public interface a extends com.baidu.swan.apps.ap.e.b<Set<c<?>>> {
    }

    /* loaded from: classes10.dex */
    private static class b {
        private static final e dxg = new e();
    }

    public static e aJt() {
        return b.dxg;
    }

    public e j(com.baidu.swan.apps.am.a aVar) {
        String aVar2 = aVar == null ? "" : aVar.toString();
        if (DEBUG) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        com.baidu.swan.apps.console.c.e("Tracer-ErrCode", aVar2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(c<?>... cVarArr) {
        synchronized (this.dxc) {
            for (c<?> cVar : cVarArr) {
                if (!this.dxc.containsKey(cVar)) {
                    this.dxc.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.dxc) {
                HashSet keySet = m(cVarArr) ? this.dxc.keySet() : i.N(cVarArr);
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
        Set<a> set = this.dxc.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.dxc.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.dxc) {
                for (c<?> cVar : m(cVarArr) ? this.dxc.keySet() : i.N(cVarArr)) {
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
        return f(i.N(cVarArr));
    }

    protected e f(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.dxc) {
                for (c<?> cVar : set) {
                    hashSet.addAll(a(cVar));
                }
            }
            b(hashSet, set);
        }
        return this;
    }

    private e b(final Set<a> set, final Set<c<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.swan.apps.am.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : set) {
                    aVar.M(set2);
                }
            }
        });
        return this;
    }
}
