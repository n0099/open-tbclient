package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bPs;
    private d bPt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    protected abstract boolean VE();

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b an(@NonNull JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.bPs = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.bPt = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bPs + " is called, can use sync mode: " + VE() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return VE() ? am(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b am(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bPs + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b an = an(jSONObject);
        if (!an.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bPs + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bPs + " end handle sync, result: " + an.toString());
            return an;
        } else {
            return an;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bPs + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.bPs + " async callback: " + bVar.toString());
                }
                c.this.bPt.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bPs + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bPs + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
