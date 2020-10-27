package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.runtime.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class b implements com.baidu.swan.apps.ap.e.b<i.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, com.baidu.swan.apps.ap.e.b<i.a>> dmy = new HashMap();
    private final List<com.baidu.swan.apps.ap.e.c<i.a, Boolean>> dmz = new ArrayList();

    public b a(final com.baidu.swan.apps.ap.e.b<i.a> bVar, String... strArr) {
        if (bVar != null && strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void M(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        b.this.dmy.put(str, bVar);
                    }
                }
            }, strArr);
        }
        return this;
    }

    public b x(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.swan.apps.ap.e.a.a(new com.baidu.swan.apps.ap.e.b<String>() { // from class: com.baidu.swan.apps.runtime.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: onCallback */
                public void M(String str) {
                    b.this.dmy.remove(str);
                }
            }, strArr);
        }
        return this;
    }

    public b a(com.baidu.swan.apps.ap.e.c<i.a, Boolean> cVar) {
        if (cVar != null) {
            this.dmz.add(cVar);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: b */
    public void M(i.a aVar) {
        com.baidu.swan.apps.ap.e.b<i.a> bVar;
        if (DEBUG) {
            Log.i("EventHandler", "handle: " + aVar);
        }
        if (h(aVar) && (bVar = this.dmy.get(aVar.id)) != null) {
            bVar.M(aVar);
        }
    }

    private boolean h(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.baidu.swan.apps.ap.e.c<i.a, Boolean> cVar : this.dmz) {
            if (cVar != null && !cVar.N(aVar).booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
