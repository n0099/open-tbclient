package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class b implements com.baidu.swan.apps.ao.e.b<i.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, com.baidu.swan.apps.ao.e.b<i.a>> dDK = new HashMap();
    private final List<com.baidu.swan.apps.ao.e.c<i.a, Boolean>> dDL = new ArrayList();

    public b a(final com.baidu.swan.apps.ao.e.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: onCallback */
                public void L(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        b.this.dDK.put(str, bVar);
                    }
                }
            }, strArr);
        }
        return this;
    }

    public b E(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ao.e.a.a(new com.baidu.swan.apps.ao.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: onCallback */
                public void L(String str) {
                    b.this.dDK.remove(str);
                }
            }, strArr);
        }
        return this;
    }

    public b a(com.baidu.swan.apps.ao.e.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.dDL.add(cVar);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: b */
    public void L(i.a aVar) {
        com.baidu.swan.apps.ao.e.b<i.a> bVar;
        if (DEBUG) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (h(aVar) && (bVar = this.dDK.get(aVar.id)) != null) {
            bVar.L(aVar);
        }
    }

    private boolean h(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.baidu.swan.apps.ao.e.c<i.a, Boolean> cVar : this.dDL) {
            if (cVar != null && !cVar.M(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
