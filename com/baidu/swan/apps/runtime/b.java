package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class b implements com.baidu.swan.apps.ap.e.b<i.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, com.baidu.swan.apps.ap.e.b<i.a>> cPR = new HashMap();
    private final List<com.baidu.swan.apps.ap.e.c<i.a, Boolean>> cPS = new ArrayList();

    public b a(final com.baidu.swan.apps.ap.e.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void I(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        b.this.cPR.put(str, bVar);
                    }
                }
            }, strArr);
        }
        return this;
    }

    public b v(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void I(String str) {
                    b.this.cPR.remove(str);
                }
            }, strArr);
        }
        return this;
    }

    public b a(com.baidu.swan.apps.ap.e.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.cPS.add(cVar);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: b */
    public void I(i.a aVar) {
        com.baidu.swan.apps.ap.e.b<i.a> bVar;
        if (DEBUG) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (h(aVar) && (bVar = this.cPR.get(aVar.id)) != null) {
            bVar.I(aVar);
        }
    }

    private boolean h(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.baidu.swan.apps.ap.e.c<i.a, Boolean> cVar : this.cPS) {
            if (cVar != null && !cVar.J(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
