package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cxK;
    private d cxL;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aI(@NonNull JSONObject jSONObject);

    protected abstract boolean ajz();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.cxK = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.cxL = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cxK + " is called, can use sync mode: " + ajz() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return ajz() ? aH(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aH(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cxK + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aI = aI(jSONObject);
        if (!aI.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cxK + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cxK + " end handle sync, result: " + aI.toString());
            return aI;
        } else {
            return aI;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cxK + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.cxK + " async callback: " + bVar.toString());
                }
                c.this.cxL.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cxK + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cxK + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
