package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public final class b implements com.baidu.swan.apps.as.d.b<i.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, com.baidu.swan.apps.as.d.b<i.a>> cnN = new HashMap();
    private final List<com.baidu.swan.apps.as.d.c<i.a, Boolean>> cnO = new ArrayList();

    public b a(final com.baidu.swan.apps.as.d.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.as.d.a.a(new com.baidu.swan.apps.as.d.b<String>() { // from class: com.baidu.swan.apps.runtime.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: onCallback */
                public void F(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        b.this.cnN.put(str, bVar);
                    }
                }
            }, strArr);
        }
        return this;
    }

    public b a(com.baidu.swan.apps.as.d.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.cnO.add(cVar);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void F(i.a aVar) {
        com.baidu.swan.apps.as.d.b<i.a> bVar;
        if (DEBUG) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (c(aVar) && (bVar = this.cnN.get(aVar.id)) != null) {
            bVar.F(aVar);
        }
    }

    private boolean c(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.baidu.swan.apps.as.d.c<i.a, Boolean> cVar : this.cnO) {
            if (cVar != null && !cVar.G(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
