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
    private final Map<c<?>, Set<a>> aYU = new HashMap();

    /* loaded from: classes2.dex */
    public interface a extends com.baidu.swan.apps.an.d.a<Set<c<?>>> {
    }

    /* loaded from: classes2.dex */
    private static class b {
        private static final e aYY = new e();
    }

    public static e Ok() {
        return b.aYY;
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
        synchronized (this.aYU) {
            for (c<?> cVar : cVarArr) {
                if (!this.aYU.containsKey(cVar)) {
                    this.aYU.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.aYU) {
                HashSet keySet = l(cVarArr) ? this.aYU.keySet() : h.L(cVarArr);
                for (c<?> cVar : keySet) {
                    if (cVar != null) {
                        a(cVar).add(aVar);
                    }
                }
                b(h.L(aVar), keySet);
            }
        }
        return this;
    }

    private Set<a> a(@NonNull c<?> cVar) {
        Set<a> set = this.aYU.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.aYU.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.aYU) {
                for (c<?> cVar : l(cVarArr) ? this.aYU.keySet() : h.L(cVarArr)) {
                    if (cVar != null) {
                        a(cVar).remove(aVar);
                    }
                }
            }
        }
        return this;
    }

    private <T> boolean l(T... tArr) {
        return tArr == null || tArr.length < 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e b(c<?>... cVarArr) {
        return e(h.L(cVarArr));
    }

    protected e e(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.aYU) {
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
                    aVar.D(set2);
                }
            }
        });
        return this;
    }
}
