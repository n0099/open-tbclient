package com.baidu.swan.apps.al;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public final class e implements com.baidu.swan.apps.al.b, d {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private final Map<c<?>, Set<a>> dPJ = new HashMap();

    /* loaded from: classes8.dex */
    public interface a extends com.baidu.swan.apps.ao.e.b<Set<c<?>>> {
    }

    /* loaded from: classes8.dex */
    private static class b {
        private static final e dPN = new e();
    }

    public static e aNm() {
        return b.dPN;
    }

    public e j(com.baidu.swan.apps.al.a aVar) {
        String aVar2 = aVar == null ? "" : aVar.toString();
        if (DEBUG) {
            Log.i("Tracer-ErrCode", aVar2);
        }
        com.baidu.swan.apps.console.c.e("Tracer-ErrCode", aVar2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(c<?>... cVarArr) {
        synchronized (this.dPJ) {
            for (c<?> cVar : cVarArr) {
                if (!this.dPJ.containsKey(cVar)) {
                    this.dPJ.put(cVar, new HashSet());
                }
            }
        }
        return this;
    }

    public e a(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.dPJ) {
                HashSet keySet = m(cVarArr) ? this.dPJ.keySet() : i.Q(cVarArr);
                for (c<?> cVar : keySet) {
                    if (cVar != null) {
                        a(cVar).add(aVar);
                    }
                }
                b(i.Q(aVar), keySet);
            }
        }
        return this;
    }

    private Set<a> a(@NonNull c<?> cVar) {
        Set<a> set = this.dPJ.get(cVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.dPJ.put(cVar, hashSet);
            return hashSet;
        }
        return set;
    }

    public e b(a aVar, c<?>... cVarArr) {
        if (aVar != null) {
            synchronized (this.dPJ) {
                for (c<?> cVar : m(cVarArr) ? this.dPJ.keySet() : i.Q(cVarArr)) {
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
        return f(i.Q(cVarArr));
    }

    protected e f(Set<c<?>> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            synchronized (this.dPJ) {
                for (c<?> cVar : set) {
                    hashSet.addAll(a(cVar));
                }
            }
            b(hashSet, set);
        }
        return this;
    }

    private e b(final Set<a> set, final Set<c<?>> set2) {
        sHandler.post(new Runnable() { // from class: com.baidu.swan.apps.al.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : set) {
                    aVar.N(set2);
                }
            }
        });
        return this;
    }
}
